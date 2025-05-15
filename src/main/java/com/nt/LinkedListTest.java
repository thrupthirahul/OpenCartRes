package com.nt;

public class LinkedListTest {

	private Node head;

	LinkedListTest(){
		this.head=null;
	}

	static class Node{
		private int data;
		private Node next;

		Node(int data){
			this.data=data;
			this.next=null;
		}
	}

	public void display() {

		if(head==null) {
			System.out.println("{}");
		}

		else {
			Node trav=head;

			while(trav !=null) {
				System.out.print(trav.data +" ");
				trav=trav.next;
			}
			System.out.println();
		}
	}
	public void add(int data) {
		Node newNode= new Node(data);

		if(head == null) {
			head=newNode;
		}
		else {
			Node trav=head;
			while(trav.next !=null) {
				trav=trav.next;
			}
			trav.next=newNode;
		}

	}
	public void addFirst(int data) {
		Node newNode=new Node(data);

		if(head== null) {
			head=newNode;
		}else {
			Node temp=head;
			head=newNode;
			newNode.next=temp;
		}

	}
	public void addPosAt(int data, int pos) {

		if(pos==0) {
			addFirst(data);
		}
		else {
			Node newNode= new Node(data);
			Node trav=head;
			for(int i=1; i<pos; i++) {	
				if(trav.next !=null) {
					trav= trav.next;
					continue;
				}else if (i > pos) {
					add(data);
					return;
				}
			}
			Node temp=trav.next;
			trav.next=newNode;
			newNode.next=temp;
		}
	}
}
