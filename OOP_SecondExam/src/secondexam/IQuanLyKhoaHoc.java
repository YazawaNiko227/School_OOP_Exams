package secondexam;

import java.util.List;
import java.util.Map;

public interface IQuanLyKhoaHoc {
	public int timKiemBangMa(String maCanTim);
	public boolean themKhoaHoc(String maCanThem, KhoaHoc khoaHocMoi);
	public boolean capNhatKhoaHoc(String maCanCapNhat, String tenKhoaHocMoi, int soBuoiHocMoi);
	public KhoaHoc timKiemBangMaTraVeKhoaHoc(String maCanTim);
	public List<KhoaHoc> sapXep();
	public Map<String, Double> trungBinhHocPhi();
}
