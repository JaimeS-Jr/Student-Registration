import java.util.Date;

public class Course {
	private int courseId;				//course identification
	private String courseName;			//course name
	private String courseDescription;	//brief course summary
	int courseLimit;					//course max
	int numberEnrolled;					//number student enrolled
	boolean isCourseOpen;				//course status
	private String startDate;			//course start date
//	private Date endDate;				//course end date
	public static final int ENROLLED_MAX = 5;
	
	Course() {
		courseId = 0;
		courseName = "";
		courseDescription = "";
		courseLimit = 0;
		numberEnrolled = 0;
		isCourseOpen = false;
		startDate = "";
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	
	public void setCourseLimit(int courseLimit) {
		this.courseLimit = courseLimit;
	}
	
	public int getCourseLimit()	{
		return courseLimit;
	}
	
	public void setNumberEnrolled(int numberEnrolled) {
		this.numberEnrolled = numberEnrolled;
	}
	
	public int getNumberEnrolled()	{
		return numberEnrolled;
	}

	public void setCourseStatus(boolean isCourseOpen) {
		this.isCourseOpen = isCourseOpen;
	}
	
	public boolean getCourseStatus()	{
		return isCourseOpen;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartDate()	{
		return startDate;
	}

	public String toString() {
		return courseName + "\t" + courseId + "\t" + courseDescription
				+ "\t" + courseLimit + "\t" + numberEnrolled + "\t" + isCourseOpen;
	}
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//
//	public Date getEndDate()	{
//		return endDate;
//	}
}
