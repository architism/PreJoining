package com.litmus7.schoolmanagementsystem;
import java.util.*;

import com.litmus7.schoolmanagementsystem.dto.Student;

public class StudentApp 
{	
	public static void main(String args[])
	{	
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of students to be entered : ");
		n = scanner.nextInt();
		
		Student[] s = new Student[n];
		for(int i=0;i<n;i++)
		{
			s[i] = new Student();
			System.out.println();
			System.out.println("Student " + (i+1));
			s[i].inputDetails(); 
		}
		
		System.out.println();
		System.out.println("---Report Card---");
		System.out.println();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Student " + (i+1));
			s[i].printReportCard();
		}
		
		scanner.close()	;	
	}
}
