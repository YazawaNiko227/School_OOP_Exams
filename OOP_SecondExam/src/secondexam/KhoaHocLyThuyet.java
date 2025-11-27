package secondexam;

public class KhoaHocLyThuyet extends KhoaHoc{
	private HinhThuc hinhThucGiangDay;
	private boolean coTaiLieu;
	
	public KhoaHocLyThuyet(String maKhoaHoc, String tenKhoaHoc, int soBuoiHoc, HinhThuc hinhThucGiangDay,
			boolean coTaiLieu) {
		super(maKhoaHoc, tenKhoaHoc, soBuoiHoc);
		setHinhThucGiangDay(hinhThucGiangDay);
		setCoTaiLieu(coTaiLieu);
	}

	public HinhThuc getHinhThucGiangDay() {
		return hinhThucGiangDay;
	}

	public void setHinhThucGiangDay(HinhThuc hinhThucGiangDay) {
		if (hinhThucGiangDay == null) {
			throw new IllegalArgumentException("Hinh thuc giang day khong hop le.");
		}
		this.hinhThucGiangDay = hinhThucGiangDay;
	}

	public boolean isCoTaiLieu() {
		return coTaiLieu;
	}

	public void setCoTaiLieu(boolean coTaiLieu) {
		this.coTaiLieu = coTaiLieu;
	}

	@Override
	public double tinhHocPhi() {
		double hocPhi = getSoBuoiHoc() * HOC_PHI_MOI_BUOI;
		if (hinhThucGiangDay == HinhThuc.TRUC_TUYEN) {
			return hocPhi * 0.8;
		}
		return hocPhi;
	}
	
	@Override
	public String toString() {

		return super.toString() + String.format("%s | %s | ", 
				getHinhThucGiangDay(),
				isCoTaiLieu()
				);
	}
}
