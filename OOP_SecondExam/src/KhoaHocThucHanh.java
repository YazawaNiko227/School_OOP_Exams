
public class KhoaHocThucHanh extends KhoaHoc{
	private String tenPhongThucHanh;
	private int soLuongMayTinh;
	
	public KhoaHocThucHanh(String maKhoaHoc, String tenKhoaHoc, int soBuoiHoc, String tenPhongThucHanh,
			int soLuongMayTinh) {
		super(maKhoaHoc, tenKhoaHoc, soBuoiHoc);
		setTenPhongThucHanh(tenPhongThucHanh);
		setSoLuongMayTinh(soLuongMayTinh);
	}

	public String getTenPhongThucHanh() {
		return tenPhongThucHanh;
	}

	public void setTenPhongThucHanh(String tenPhongThucHanh) {
		if (tenPhongThucHanh == null || tenPhongThucHanh.isEmpty()) {
			throw new IllegalArgumentException("Ten phong thuc hanh khong hop le.");
		}
		this.tenPhongThucHanh = tenPhongThucHanh;
	}

	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}

	public void setSoLuongMayTinh(int soLuongMayTinh) {
		if (soLuongMayTinh <= 0) {
			throw new IllegalArgumentException("So luong may tinh khong hop le.");
		}
		this.soLuongMayTinh = soLuongMayTinh;
	}

	@Override
	public double tinhHocPhi() {
		if (getSoBuoiHoc() < 10) {
			return (getSoBuoiHoc() * HOC_PHI_MOI_BUOI) * 1.30;
		}
		return getSoBuoiHoc() * HOC_PHI_MOI_BUOI;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("%10s | %10s | ", 
				getTenPhongThucHanh(),
				getSoLuongMayTinh()
				);
	}
}
