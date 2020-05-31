package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._06_memento.nonsda;

import java.io.*;

public class _01_MementoEverydayDemo {

	private static EmployeeSer deserialize() {
		EmployeeSer emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("./employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (EmployeeSer) in.readObject();
			in.close();
			fileIn.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	private static void serialize(EmployeeSer emp) {
		try {
			FileOutputStream fileOut = new FileOutputStream("./employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void main(String args[]) {
		EmployeeSer emp = new EmployeeSer();
		emp.setName("Mindaugas Bernatavičius");
		emp.setAddress("111 E Code Street");
		emp.setPhone("888-555-1212");

		serialize(emp);
		EmployeeSer newEmp = deserialize();

		System.out.println(newEmp.getName());
	}
}

//originator
class EmployeeSer implements Serializable {

	private String name;
	private String address;
	private String phone;

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return name + " : " + phone;
	}
}
