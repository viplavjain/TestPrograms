package com.Multithreading;

public class PrintTablesof2NosOnebyOne 
{
	public synchronized void printTable(int num)
	{
		for(int i=1; i<=10;i++)
		{
			System.out.println(num +"*" +i+"="+num*i);
		}
	}
	
	public static void main(String[] args) 
	 {
	 PrintTablesof2NosOnebyOne sharedObj = new PrintTablesof2NosOnebyOne();
   	 TableofNum1 tn1 = new TableofNum1(sharedObj);
   	 TableofNum2 tn2 = new TableofNum2(sharedObj);
   	 tn1.start();
   	 tn2.start();
	 }
	
     
	}
	



class TableofNum1 extends Thread
{
	PrintTablesof2NosOnebyOne sharedObj;
    
	TableofNum1(PrintTablesof2NosOnebyOne sharedObj)
	{
		this.sharedObj=sharedObj;
	}
	@Override
	public void run() {
		sharedObj.printTable(3);
		
	}
}

class TableofNum2 extends Thread
{
	PrintTablesof2NosOnebyOne sharedObj;
    
	TableofNum2(PrintTablesof2NosOnebyOne sharedObj)
	{
		this.sharedObj=sharedObj;
	}
	@Override
	public void run() {
		sharedObj.printTable(7);
		
	}
}

 