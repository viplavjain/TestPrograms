package com.coreJava;

public final class ImmutableStudent 
{
	private final int id;
	private final String name;
	private Age age;

	ImmutableStudent(int id, String name,Age age)
	{
		this.id=id;
		this.name=name;
		this.age= new Age(age);
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) 
	{
		Age age = new Age();
	    age.setDay(1);
	    age.setMonth(1);
	    age.setYear(1992);
	    
	    ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
	    System.out.println("Alex age year before modification = " + student.getAge().getYear());
	    age.setYear(1993);
	    System.out.println("Alex age year after modification = " + student.getAge().getYear());
	}

	public Age getAge() {
		/*
		 * Age cloneAge = new Age(age); return cloneAge;
		 */
		return this.age;
	}

	

}

class Age {
	private int day;
	private int month;
	private int year;
	Age(){}
	
	Age(Age age){
		day = age.getDay();
		month = age.getMonth();
		year = age.getYear();
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}

