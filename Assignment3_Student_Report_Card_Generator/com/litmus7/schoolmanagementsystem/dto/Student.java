package com.litmus7.schoolmanagementsystem.dto;


import java.util.*;

public class Student {
	
	private String name;
	private int rollno;
	private int[] marks = new int[5];

	
	public void inputDetails()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name : ");
		name = scanner.next();
		System.out.print("Enter roll number : ");
		rollno = scanner.nextInt();
		System.out.println("Enter marks in 5 subjects : ");
		for(int i=0;i<5;i++)
		{
			System.out.print("Subject " + (i+1) + ": ");
			marks[i] = scanner.nextInt();
		}
	}
	
	public int calculateTotal()
	{
		int total = 0;
		for(int i : marks)
		{
			total += i;
		}
		return total;
	}
	
	public double calculateAverage()
	{
		double average;
		average = this.calculateTotal()/5.0;
		return average;	
	}
	
	public char getGrade()
	{
		double avg = this.calculateAverage();
		
		if(avg >= 90.0)
			return 'A';
		else if(avg>=75.0)
			return 'B';
		else if(avg>=60.0)
			return 'C';
		else if(avg>=50.0)
			return 'D';
		else 
			return 'F';
	}

	public void printReportCard()
	{
		System.out.println("Name : " + name);
		System.out.println("Roll Number : " + rollno);
		System.out.println("Total Marks : " + this.calculateTotal());
		System.out.println("Average Marks : " + this.calculateAverage());
		System.out.println("Grade : " + this.getGrade());
		System.out.println();
	}
	
	
}
