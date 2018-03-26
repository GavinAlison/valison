package com.alison.spring.ioc.t3;

public class Family {
	private Person person;
	private String familyName;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Family(Person person, String familyName) {
		super();
		this.person = person;
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "Family [familyName=" + familyName + ", person=" + person + "]";
	}

}
