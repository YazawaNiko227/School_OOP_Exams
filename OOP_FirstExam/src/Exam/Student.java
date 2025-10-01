/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 1 thg 10, 2025 23:12:22
 */
package Exam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
	private String studentCode;
	private String studentFullname;
	private Gender genderStudent;
	private LocalDate birthday;
	private double avgScore;
	
	public Student(String studentCode, String studentFullname, Gender gender, LocalDate birthday, double avgScore) {
		setStudentCode(studentCode);
		setStudentFullname(studentFullname);
		setGenderStudent(gender);
		setBirthday(birthday);
		setAvgScore(avgScore);
	}
	
	public Student() {
		this("Empty", "Empty", Gender.EMPTY, LocalDate.now(), 0.0);
	}

	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		if(studentCode == null || studentCode.isEmpty()) {
			studentCode = "Empty";
		}
		this.studentCode = studentCode;
	}
	public String getStudentFullname() {
		return studentFullname;
	}
	public void setStudentFullname(String studentFullname) {
		if(studentFullname == null || studentFullname.isEmpty()) {
			studentFullname = "Empry";
		}
		this.studentFullname = studentFullname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		if(birthday.isAfter(LocalDate.now()) || 
				LocalDate.now().getYear() - birthday.getYear() < 18) {
			birthday = LocalDate.now();
		}
		this.birthday = birthday;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(double avgScore) {
		if(avgScore < 0.0 || avgScore > 10.0) {
			avgScore = 0.0;
		}
		this.avgScore = avgScore;
	}
	public Gender getGenderStudent() {
		return genderStudent;
	}
	public void setGenderStudent(Gender genderStudent) {
		if(genderStudent == null) {
			genderStudent = Gender.EMPTY;
		}
		this.genderStudent = genderStudent;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return String.format("%s | %s | %s | %s | %s", 
				getStudentCode(),
				getStudentFullname(),
				getGenderStudent(),
				dtf.format(getBirthday()),
				getAvgScore()
				);
	}
}
