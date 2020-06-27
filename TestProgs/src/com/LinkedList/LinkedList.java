package com.LinkedList;

public class LinkedList
{
	private class Node
	{
		int data;
		Node next;
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public void display()
	{
	  	Node temp=head;
	  	while(temp!=null)
	  	{
	  		System.out.println(temp.data);
	  		temp=temp.next;
	  	}
	}
	
	public void addLast(int item)
	{
		Node nn = new Node();
		nn.data=item;
		nn.next=null;
		
		if(this.size==0)
		{
		  head=nn;
		  tail=nn;
		}
		
		else
		{
			tail.next=nn;
			tail=nn;
			
		}
		size++;
	  	
	}
	
	public void addFirst(int item)
	{
		Node nn = new Node();
		nn.data=item;
		nn.next=null;
		
		if(this.size==0)
		{
		  head=nn;
		  tail=nn;
		}
		
		else
		{ 
		  nn.next=head;
		  head=nn; 	
		}
		size++;
		
	}
	

}
