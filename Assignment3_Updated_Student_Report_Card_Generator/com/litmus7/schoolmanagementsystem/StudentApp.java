package com.litmus7.schoolmanagementsystem;

import java.util.Scanner;

import com.litmus7.schoolmanagementsystem.dto.Student;

/**
 * This class contains the main method.
 */
public class StudentApp {
	public static void main(String args[]) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of students to be entered : ");
		n = scanner.nextInt();

		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			students[i] = new Student();
			System.out.println();
			System.out.println("Student " + (i + 1));
			students[i].inputDetails();
		}

		System.out.println();
		System.out.println("---Report Card---");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.println("Student " + (i + 1));
			students[i].printReportCard();
		}

		scanner.close();
	}
}
