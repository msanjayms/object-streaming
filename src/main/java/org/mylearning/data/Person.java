package org.mylearning.data;

import java.io.Serializable;

public class Person implements Serializable {

	private String firstName;
	private String lastName;
	private Long phoneNumber;

	public Person(String fName, String lName, long phoneNumber) {
		firstName = fName;
		lastName = lName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + ", Last Name: " + lastName + " Phone #: " + phoneNumber;
	}

}
