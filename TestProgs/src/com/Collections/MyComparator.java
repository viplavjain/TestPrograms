package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MyComparator 
{
	public static void main(String[] args) 
	{
		ArrayList<Student> al= new ArrayList<>();
		al.add(new Student(3,"Ram",23));
		al.add(new Student(1,"Shyam",20));
		al.add(new Student(2,"Sunder",21));
		
		Collections.sort(al,new AgeComparator());
		Iterator itr=al.iterator();
		while(itr.hasNext())
		{
			Student st= (Student)itr.next();
			System.out.println(st.rollno +" " + st.name +" "+st.age);
		}
		
		
	}

}

class Student
{
	int rollno;
	String name;
	int age;
	
	Student(int rollno,String name,int age)
	{
		this.rollno=rollno;
		this.name=name;
		this.age=age;
	}
	
}

 class AgeComparator implements Comparator
 {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1=(Student) o1;
		Student s2=(Student) o2;
		if(s2.age>s1.age)
			return 1;
		else if(s2.age<s1.age)
			return -1;
		return 0;
	}
 }