
public class KhoaHocLyThuyet extends KhoaHoc{
	private HinhThuc hinhThuc;
	private boolean coTaiLieu;

	public KhoaHocLyThuyet(String maKhoaHoc, String tenKhoaHoc, int soBuoiHoc, HinhThuc hinhThuc, boolean coTaiLieu) {
		super(maKhoaHoc, tenKhoaHoc, soBuoiHoc);
		setHinhThuc(hinhThuc);
		setCoTaiLieu(coTaiLieu);
	}

	public HinhThuc getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(HinhThuc hinhThuc) {
		if (hinhThuc == null) {
			throw new IllegalArgumentException("Hinh thuc khong hop le.");
		}
		this.hinhThuc = hinhThuc;
	}

	public boolean isCoTaiLieu() {
		return coTaiLieu;
	}

	public void setCoTaiLieu(boolean coTaiLieu) {
		this.coTaiLieu = coTaiLieu;
	}

	@Override
	public double tinhHocPhi() {
		if (HinhThuc.TRUC_TUYEN == hinhThuc) {
			return (getSoBuoiHoc() * HOC_PHI_MOI_BUOI) * 0.8;
		}
		return getSoBuoiHoc() * HOC_PHI_MOI_BUOI;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("%10s | %10s | ", 
				getHinhThuc(),
				isCoTaiLieu()
				);
	}
}
