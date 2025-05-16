package com.nt;



public class Test01 {
	
	public static void main(String[] args) {
		LinkedListTest list= new LinkedListTest();
		list.display();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.addFirst(50);
		list.addFirst(60);
		list.addPosAt(70, 0);
		list.addPosAt(80, 1);
		list.addPosAt(90, 3);
		list.addPosAt(100, 8);
		list.add(101);
		list.addFirst(101);
		list.addPosAt(103,15);
		list.display();
		list.display();
		list.display();
		
	}

}
