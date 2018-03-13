import java.util.ArrayList;

public class Student {
	//declare student name
	private String studentName;
	private int studentId;
	ArrayList<String> regCourseList = new ArrayList<>();
	
	//constructor	may throws IOException
	public Student(String studentName, int studentId) {
		//check if there exist a registered file with this student name?
		//Yes: load it to regCourseList, Else regCourselist is null
		//File regFile = new File(name + ".txt");
		//bool fileExist = regFile.exists(); //check whether reg file exist
		//bool isRegFile = regFile.isFile(); //check whether is a reg file
//		java.io.File file = new java.io.File(name + ".txt");
//		if (file.exists()) {
//			//load reg course list to regCourseList
//		} else {
//			initialize regCourseList
//		}
		this.studentName = studentName;
		this.studentId = studentId;
	}
	
	//get student name
	public String getName() {
		return studentName;
	}
	
	public void setStudentID(int studentID) {
		this.studentId = studentId;
	}
	
	public int getStudentID() {
		return studentId;
	}
	
	//To do: add course to regCourseList
//	public void setRegCourse(Course[] course) {
	
//	}

	//To do: remove course from regCourseList
//	public void removeRegCourse(Course[] course) {
	
//	}
	
	public ArrayList<String> getRegCourseList() {
		return regCourseList;
	}
	
	public void viewProfile() {
		//equivalent of customized Student.toString()
	}
}
