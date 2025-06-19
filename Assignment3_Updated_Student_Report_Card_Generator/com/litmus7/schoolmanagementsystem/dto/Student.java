package com.litmus7.schoolmanagementsystem.dto;

import java.util.Scanner;

/**
 * This class is used for student data and contains student information for
 * name, roll number and marks.
 */
public class Student {

	private String name;
	private int rollNo;
	private int[] marks = new int[5];

	enum Grade {
		A, B, C, D, E, F;
	}

	/**
	 * This method is used to get the value of student's name, roll number and marks
	 * in five subjects from the user.
	 */

	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name : ");
		name = scanner.nextLine();
		System.out.print("Enter roll number : ");
		rollNo = scanner.nextInt();
		System.out.println("Enter marks in 5 subjects : ");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
		}
	}

	/**
	 * This method calculates the total marks of the student.
	 * 
	 * @return integer value for total marks of the student.
	 */
	public int calculateTotal() {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total;
	}

	/**
	 * This method calculates the average marks of the student.
	 * 
	 * @return double value for average marks of the student.
	 */
	public double calculateAverage() {

		double average = calculateTotal() / 5.0;
		return average;
	}

	/**
	 * This method calculates the grade of the student based on average marks.
	 * 
	 * @return Grade value for the student.
	 */

	public Grade getGrade() {
		double avg = calculateAverage();

		if (avg >= 90.0)
			return Grade.A;
		else if (avg >= 75.0)
			return Grade.B;
		else if (avg >= 60.0)
			return Grade.C;
		else if (avg >= 50.0)
			return Grade.D;
		else
			return Grade.F;
	}

	/**
	 * This method prints name, roll number, total marks, average marks and grade of
	 * the student.
	 */

	public void printReportCard() {
		System.out.println("Name : " + name);
		System.out.println("Roll Number : " + rollNo);
		System.out.println("Total Marks : " + calculateTotal());
		System.out.println("Average Marks : " + calculateAverage());
		System.out.println("Grade : " + getGrade());
		System.out.println();
	}

}
