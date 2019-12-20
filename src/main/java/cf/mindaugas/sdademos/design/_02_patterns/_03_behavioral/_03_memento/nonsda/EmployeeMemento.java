package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._03_memento.nonsda;

//memento
public class EmployeeMemento {

	private String name;
	private String phone;

	public EmployeeMemento(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
}
