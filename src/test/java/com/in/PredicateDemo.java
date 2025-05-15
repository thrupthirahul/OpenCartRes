package com.in;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		System.out.println("Main");
		
		Student s1= new Student("rahul",101,"java");
		Student s2= new Student("ram",102,"sql");
		Student s3= new Student("hari",103,"java");
		Student s4= new Student("krishna",104,"java");
		Student s5= new Student("ashok",105,"spring");
		
		List<Student> list= Arrays.asList(s1, s2, s3, s4, s5);
		
		 Predicate<Student> p=(Student student) ->{ 
			 return student.course.equals("sql");
		 	};
		 	
		 Predicate<Student> p1= student -> {return student.id>=103; };
		 	
		 	for(Student student:list) {
		 		if(p.test(student)) {
		 			if(p1.test(student))
		 			System.out.println(student.toString());
		 		}
		 		
		 	}	
	}
}
