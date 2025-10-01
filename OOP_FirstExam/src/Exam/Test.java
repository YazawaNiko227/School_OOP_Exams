/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 2 thg 10, 2025 00:05:35
 */
package Exam;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        StudenList studentList = new StudenList(3);

        // Tạo sinh viên hợp lệ
        Student s1 = new Student("SV001", "Nguyễn Văn A", Gender.MAN, LocalDate.of(2000, 5, 15), 8.5);
        Student s2 = new Student("SV002", "Trần Thị B", Gender.FEMALE, LocalDate.of(2001, 8, 20), 7.2);
        Student s3 = new Student("SV003", "Lê Văn C", Gender.MAN, LocalDate.of(1999, 12, 5), 9.0);

        // Thêm sinh viên
        System.out.println("Thêm sinh viên:");
        studentList.addStudent(s1);
        studentList.addStudent(s2);
        studentList.addStudent(s3);
        studentList.showStudent();

        // Thử thêm sinh viên trùng mã
        try {
            studentList.addStudent(new Student("SV001", "Trùng mã", Gender.FEMALE, LocalDate.of(2002, 1, 1), 6.0));
        } catch (IllegalArgumentException e) {
            System.out.println("\nLỗi thêm sinh viên trùng mã: " + e.getMessage());
        }

        // Cập nhật sinh viên
        System.out.println("\nCập nhật SV002:");
        Student updatedS2 = new Student("SV002", "Trần Thị Bảo", Gender.FEMALE, LocalDate.of(2001, 8, 20), 8.0);
        studentList.updateByCode("SV002", updatedS2);
        studentList.showStudent();

        // Xóa sinh viên
        System.out.println("\nXóa SV001:");
        Student removed = studentList.removeStudent("SV001");
        System.out.println("Đã xóa: " + removed);
        studentList.showStudent();

        // Tìm kiếm sinh viên
        System.out.println("\nTìm SV003:");
        int index = studentList.findByCode("SV003");
        System.out.println("Vị trí SV003: " + index);

        // Thử xóa sinh viên không tồn tại
        System.out.println("\nXóa SV999:");
        Student notFound = studentList.removeStudent("SV999");
        System.out.println("Kết quả: " + notFound);

        // Kiểm tra dữ liệu không hợp lệ
        System.out.println("\nThêm sinh viên dữ liệu sai:");
        Student invalidStudent = new Student("", "", null, LocalDate.of(2025, 1, 1), 15.0);
        studentList.addStudent(invalidStudent);
        studentList.showStudent();

        // Sắp xếp theo điểm trung bình
        System.out.println("\nSắp xếp theo điểm trung bình:");
        studentList.sortByAverageScore();
        studentList.showStudent();
    }
}
