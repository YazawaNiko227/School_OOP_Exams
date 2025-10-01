/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 1 thg 10, 2025 23:32:16
 */
package Exam;

import java.util.Arrays;

public class StudenList {
	Student[] list;
	private int size;
	
	public StudenList(int capacity) {
		if(capacity <= 0) {
			capacity = 10;
		}
		list = new Student[capacity];
	}
	
	public Student addStudent(Student newStudent) {
		if(newStudent == null) {
			return null;
		}
		if(findByCode(newStudent.getStudentCode()) >= 0) {
			throw new IllegalArgumentException("Mã số sinh viên đã tồn tại.");
		}
		if(size >= list.length) {
			Arrays.copyOf(list, (int)(size * 1.50));
		}
		list[size++] = newStudent;
		return newStudent;
	}

	public int findByCode(String studentCode) {
		for (int i = 0; i < size; i++) {
			if(list[i].getStudentCode() == studentCode) {
				return i;
			}
		}
		return -1;
	}
	
	public int getSize() {
		return size;
	}
	
	public void showStudent() {
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	public Student updateByCode(String studentCode, Student updateStudent) {
		int index = findByCode(studentCode);
		
		if(index >= 0) {
			list[index] = updateStudent;
			return list[index];
		}else {
			return null;
		}
	}
	
	public Student removeStudent(String studentCode) {
		int index = findByCode(studentCode);
		if(index < 0) {
			for (int i = index; i < size - 1; i++) {
				list[i] = list[i + 1];
			}
			return list[index];
		}else {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private void sortByAverageScore() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i; j < size; j++) {
				if(list[i].getAvgScore() > list[j].getAvgScore()) {
					Student temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
}
