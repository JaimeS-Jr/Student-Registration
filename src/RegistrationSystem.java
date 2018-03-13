import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationSystem {
	
	//list of available courses
	static ArrayList<Course> listAvailCourse = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//get student name and student id
		System.out.print("Enter Student name, e.g. John Doe, ");
		String studentName = input.nextLine();
		System.out.print("Enter student id, e.g, 123456, ");
		String strId = input.nextLine();
		
		int studentId = Integer.parseInt(strId);
		//Option available for user
		int option = viewRegOption();
		
		boolean registerStatus = false;
		boolean unregisterStatus = false;
		
		switch (option) {
			case 1: registerStatus = registerCourse(studentName, studentId);
					break;
			case 2: unregisterStatus = unRegisterCourse(studentName, studentId);
					break;
			case 3:	System.out.println("System exit. Thank you.");
					System.exit(0);
					break;
			default:
					System.out.println("Wrong option selected: " + option + "\n Bye Bye!");
					System.exit(0);
		}
		
		//To do: print student profile
		
		//To do: write listAvailableCourse to file before quit system
	}
	
	//First Screen: the list of courses available and 
	//the ability to register for one
	public static void viewCourseList() {
		System.out.println("--- List of Course Available ---");
		java.io.File file = new java.io.File("courseList.txt");

		//read in course list from courseList.txt
		try {
			Scanner input = new Scanner(file).useDelimiter("[,\r\n]");
			
			//read data from file
			while (input.hasNext()) {
				String courseName = input.next();
				String strCourseId = input.next();
				String startDate = input.next();
				String courseDesc = input.next();
				String strCourseLimit = input.next();
				String strNumberEnrolled = input.next();
				boolean isCourseOpen = input.nextBoolean();
				String lineSeparator = input.nextLine();

				int courseId = Integer.parseInt(strCourseId);  		//convert strCourseId to int
				int courseLimit = Integer.parseInt(strCourseLimit); //convert strCourseLimit to int
				int numberEnrolled = Integer.parseInt(strNumberEnrolled);  //convert strNumberEnrolled to int

				//print read in course list from text file
//				System.out.println(courseName + "," + strCourseId + "," + 
//				                   startDate + "," + courseDesc + "," + 
//						           courseLimit + "," + strNumberEnrolled);
				
				Course course = new Course();
				
				course.setCourseName(courseName);
				course.setCourseId(courseId);
				course.setCourseDescription(courseDesc);
				course.setCourseLimit(courseLimit);
				course.setNumberEnrolled(numberEnrolled);
				course.setCourseStatus(isCourseOpen);
				course.setStartDate(startDate);

				//add course to list of available courses
				listAvailCourse.add(course);
				
			}
			
			//close the file
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------ Print list avail courses --------------");
		
		for (Course c : listAvailCourse) {
			System.out.println(c);
		}

		
//		PrintWriter output = null;
//		try {
//			output = new PrintWriter(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		output.println("Test line");
//		output.close();
	}
	
	public static int viewRegOption() {
		System.out.println("Select your option: ");
		System.out.println("1)	Register for a course");
		System.out.println("2)	Unregister for a course");
		System.out.println("3)	Quit");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		return choice;
	}
	
	public static boolean isRegisterSucceed(int courseId) {
		boolean status = false;
		
		for (int i = 0; i < listAvailCourse.size(); i++) {
			if (courseId == listAvailCourse.get(i).getCourseId() &&
				listAvailCourse.get(i).getCourseStatus()) {
				System.out.println("Found Course OPEN.");
				
				//update course limit and number enrolled
				listAvailCourse.get(i).setNumberEnrolled(listAvailCourse.get(i).getNumberEnrolled() + 1);
				
				if (listAvailCourse.get(i).getCourseLimit() == listAvailCourse.get(i).getNumberEnrolled() ) {
					//update course available status
					listAvailCourse.get(i).setCourseStatus(false);
				}
				
				status = true;
			}
		}
		
		return status;		
	}
	
	public static boolean isUnRegisterSucceed(int courseId) {
		boolean status = false;
		
		for (int i = 0; i < listAvailCourse.size(); i++) {
			if (courseId == listAvailCourse.get(i).getCourseId() &&
					listAvailCourse.get(i).getNumberEnrolled() > 0) {  //required number enrolled > 0
				System.out.println("Found Course to Unregister.");
				
				//update course limit and number enrolled
				listAvailCourse.get(i).setNumberEnrolled(listAvailCourse.get(i).getNumberEnrolled() - 1);
				
				//update course available status
				listAvailCourse.get(i).setCourseStatus(true);
				
				status = true;
			}
		}
		
		return status;		
	}
	
	public static boolean registerCourse(String studentName, int studentId) {
		System.out.println("Register for a course");
		
		//view list of courses
		viewCourseList();
		
		Student std = new Student(studentName, studentId);
		
		//to register, ask for course id
		//hardcode for testing
		int courseId = 100002;
		
		//check if course is open for register?
		boolean cStatus = isRegisterSucceed(courseId);
		
		System.out.println("RegistrationSystem::registerCourse.cStatus: " + cStatus);
		
		//To Do: add course to Student
//		std.addCourse(studentId, courseId);
		
		if (cStatus) {  //To do: for completed, need status of std.addCourse(studentId, courseId)
			System.out.println("Congratulation! Course ID: " + courseId + " register succeed!");
		} else {
			System.out.println("Sorry! Course ID: \" + courseID + \" register failed!");
		}
		
		//view list of courses
		System.out.println("--- After Registered for a course ---");
		viewCourseList();

		
		return true;
	}
	
	public static boolean unRegisterCourse(String studentName, int studentId) {
		System.out.println("Unregister for a course");
		
		//view list of courses
		viewCourseList();
		
		Student std = new Student(studentName, studentId);
		
		//to register, ask for course id
		//hardcode for testing
		int courseId = 100003;
		
		//check if course is open for unregister?
		boolean cStatus = isUnRegisterSucceed(courseId);
		
		System.out.println("RegistrationSystem::unRegisterCourse.cStatus: " + cStatus);
		
		//To Do: remove course to Student
//		std.removeCourse(studentId, courseId);
		
		if (cStatus) {  //To do: for completed, need status of std.addCourse(studentId, courseId)
			System.out.println("Congratulation! Course ID: " + courseId + " unregister succeed!");
		} else {
			System.out.println("Sorry! Course ID: \" + courseID + \" unregister failed!");
		}
		
		//view list of courses
		System.out.println("--- After unregistered for a course ---");
		viewCourseList();

		
		return true;	
	}
	
	//Second Screen: registration status screen 
	//that denotes either success or failure upon registration
	
	
	//Third Screen: student profile page that shows a list of classes 
	//that the student is already registered for
	//To do: use name and id to view list of this student reg courses

}