package secondexam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuanLyKhoaHoc implements IQuanLyKhoaHoc{
	private List<KhoaHoc> quanLy;

	public QuanLyKhoaHoc(List<KhoaHoc> quanLy) {
		this.quanLy = quanLy;
	}

	@Override
	public int timKiemBangMa(String maCanTim) {
		for (int i = 0; i < quanLy.size(); i++) {
			if (quanLy.get(i).getMaKhoaHoc().equals(maCanTim)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean themKhoaHoc(String maCanThem, KhoaHoc khoaHocMoi) {
		if (maCanThem == null || maCanThem.isEmpty()) {
			throw new IllegalArgumentException("Ma can them khong hop le");
		}
		
		if (timKiemBangMa(maCanThem) >= 0) {
			throw new IllegalArgumentException("Ma da ton tai.");
		}
		
		quanLy.add(khoaHocMoi);
		return true;
	}

	@Override
	public boolean capNhatKhoaHoc(String maCanCapNhat, String tenKhoaHocMoi, int soBuoiHocMoi) {
		if (maCanCapNhat == null || maCanCapNhat.isEmpty()) {
			throw new IllegalArgumentException("Ma can cap nhat khong hop le.");
		}
		
		int viTri = timKiemBangMa(maCanCapNhat);
		if (viTri >= 0) {
			quanLy.get(viTri).setTenKhoaHoc(tenKhoaHocMoi);
			quanLy.get(viTri).setSoBuoiHoc(soBuoiHocMoi);
			return true;
		}
		
		return false;
	}

	@Override
	public KhoaHoc timKiemBangMaTraVeKhoaHoc(String maCanTim) {
		if (maCanTim == null || maCanTim.isEmpty()) {
			throw new IllegalArgumentException("Ma khong hop le.");
		}
		int viTri = timKiemBangMa(maCanTim);
		if (viTri >= 0) {
			return quanLy.get(viTri);
		}
		return null;
	}

	@Override
	public List<KhoaHoc> sapXep() {
	    return quanLy.stream()
	        .sorted(Comparator.comparing((KhoaHoc kh) -> kh.getClass().getSimpleName()).reversed()
	            .thenComparingDouble(KhoaHoc::tinhHocPhi))
	        .toList();
	}

	@Override
	public Map<String, Double> trungBinhHocPhi() {
	    return quanLy.stream()
	                 .collect(Collectors.groupingBy(
	                     kh -> kh.getClass().getSimpleName(), 
	                     Collectors.averagingDouble(KhoaHoc::tinhHocPhi)
	                 ));
	}

	
	@Override
	public String toString() {
		return super.toString();
	}
}
