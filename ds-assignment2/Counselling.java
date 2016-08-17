package session2;

import java.util.Scanner;

import session1.MyArrayList;

public class Counselling {

	private MyQueue<Candidates> students;
	private MyArrayList<College> clg;
	private Scanner scan;
	private ReadFiles files;
	
	public Counselling() {
		students = new MyQueue<Candidates>();
		clg = new MyArrayList<College>();
		scan = new Scanner(System.in);
		files = new ReadFiles();
	}
	
	public void read() {
		String path;
		System.out.println("Enter path for students list");
		path = scan.nextLine();
		files.readStudents(students, path);
		System.out.println(students.size());
		students.sort();
		
		System.out.println("Enter path for college list");
		path = scan.nextLine();
		files.readColleges(clg, path);
	}
	
	public void display() {
		int j=students.size();
		for (int i=0; i < j; i++) {
			System.out.println(students.getFront().getName());
			students.dequeue();
		}
	}
	
	public static void main(String[] args) {
		Counselling counsel = new Counselling();
		counsel.read();
		counsel.display();
	}
}
