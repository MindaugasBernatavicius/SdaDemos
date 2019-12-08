package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._02_strategy.nonsda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _01_StrategyEverydayDemo {
	
	private static void printContents(List<Person> people) {
		for (Person person : people) {
			System.out.println(person.getName());
		}
	}
	
	public static void main(String args[]) {
		Person bryan = new Person("Bryan", "801-555-1212", 39);
		Person mark = new Person("Mark", "801-444-1234", 41);
		Person chris = new Person("Chris", "801-222-5151", 38);
		
		List<Person> people = new ArrayList<Person>();
		people.add(bryan);
		people.add(mark);
		people.add(chris);
		
		System.out.println("Not sorted");
		printContents(people);


		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o1.getAge();
			}
		});
		System.out.println("\nSorted by age");
		printContents(people);


		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		System.out.println("\nSorted by name");
		printContents(people);
		
	}
}

class Person {

	private int age;
	private String name;
	private String phoneNumber;

	public Person() { }

	public Person(String name, String phoneNumber, int age) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}