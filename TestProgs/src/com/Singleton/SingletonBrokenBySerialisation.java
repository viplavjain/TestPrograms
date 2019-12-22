package com.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonBrokenBySerialisation 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
	  Singleton instance1 = Singleton.getInstance();
	  instance1.setValue(22);
	  
	  File file= new File("E:\\file1.txt");
	  
	  instance1.saveToFile(file, instance1);
	  
	  Singleton instance2= instance1.readFromFile(file);
	  
	  instance2.setValue(11);
	  System.out.println(instance1.getValue());
	  System.out.println(instance2.getValue());
	  
	  System.out.println(instance1==instance2);
	  
	  }
   
}

class Singleton implements Serializable
{
	private static Singleton singleInstance = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance()
	{
		return singleInstance;
	}
	
	private static int value;
	
	public static int getValue() {
		return value;
	}

	public static void setValue(int value) {
		Singleton.value = value;
	}

	public static void saveToFile(File file, Singleton singleton) throws IOException
	{
	  FileOutputStream fout= new FileOutputStream(file);
	  ObjectOutputStream out = new ObjectOutputStream(fout);
	  out.writeObject(singleton);
	}
	
	public static Singleton readFromFile(File file) throws IOException, ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fin);
		return (Singleton) in.readObject();
	}
	
	
	/* protected Object readResolve() { return singleInstance; } */
	 
	
}
