/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 1 thg 10, 2025 23:18:54
 */
package Exam;

public enum Gender {
	EMPTY("Trống"),
	MAN("Nam"),
	FEMALE("Nữ");
	
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
