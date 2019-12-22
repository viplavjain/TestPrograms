package com.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool 
{
	public static void main(String[] args) 
	{
	
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Runnable worker=new EmailSender("Message from email");
		
		executor.execute(worker);
		executor.execute(worker);
		
		executor.shutdown();
	}

}

  class EmailSender implements Runnable
 {
	  String message;
	  EmailSender(String message)
	  {
		  this.message=message;
	  }
	@Override
	public void run() 
	{
		for(int i=1;i<=10;i++)
		{
		System.out.println(Thread.currentThread().getName()+"Sending Email" + message);
		}
	}
	 
 }
