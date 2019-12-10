package com.Multithreading;

public class PrintTablesof2NosAlternatively 
{
  public static void main(String[] args) 
  {
	PrintTable pt= new PrintTable();
	Thread t1= new Thread(new Runnable(){
		
		public void run()
		{
			try {
				pt.printTable(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
   Thread t2= new Thread(new Runnable(){
		
		public void run()
		{
			try {
				pt.printTable(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
    t1.start();
    t2.start();
  }
}

class PrintTable
{
	boolean b=true;
	public void printTable(int num) throws InterruptedException
	{
		synchronized(this)
		{
			for(int i=1;i<=10;i++)
			{
			  while(b)	
			  {
				  System.out.println(num +"*" +i+"="+num*i);
				  b=false;
				  this.notify();//Using notify(), the thread releases the lock on the object, but not immediately
			  }
			  b=true;
			  this.wait();//Using wait(), the thread releases the lock on the object immediately
			}
		}
	}
}
