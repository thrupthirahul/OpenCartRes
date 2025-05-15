package com.in;

public class Student {
	
	String name;
	int id;
	String course;
	
	public Student(){
		
	}
	
	public Student(String name, int id,String course) {
		this.name=name;
		this.id=id;
		this.course=course;
  		System.out.println("Student Constructor->");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.name+","+this.id+","+this.course+"]";
	}

}
