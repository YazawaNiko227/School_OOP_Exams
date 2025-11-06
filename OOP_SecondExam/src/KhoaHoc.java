import java.text.DecimalFormat;
import java.util.Objects;

public abstract class KhoaHoc {
	protected final String maKhoaHoc;
	protected String tenKhoaHoc;
	protected int soBuoiHoc;
	protected static final double HOC_PHI_MOI_BUOI = 200000;
	
	DecimalFormat df = new DecimalFormat("0.0");
	
	public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, int soBuoiHoc) {
		if (maKhoaHoc == null || maKhoaHoc.isEmpty()) {
			throw new IllegalArgumentException("Ma khoa hoc khong hop le.");
		}
		this.maKhoaHoc = maKhoaHoc;
		setTenKhoaHoc(tenKhoaHoc);
		setSoBuoiHoc(soBuoiHoc);
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		if (tenKhoaHoc == null || tenKhoaHoc.isEmpty()) {
			throw new IllegalArgumentException("Ten khoa hoc khong hop le.");
		}
		this.tenKhoaHoc = tenKhoaHoc;
	}
	public int getSoBuoiHoc() {
		return soBuoiHoc;
	}
	public void setSoBuoiHoc(int soBuoiHoc) {
		if (soBuoiHoc <= 0) {
			throw new IllegalArgumentException("So buoi hoc khong hop le.");
		}
		this.soBuoiHoc = soBuoiHoc;
	}
	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}
	
	public abstract double tinhHocPhi();
	
	@Override
	public int hashCode() {
		return Objects.hash(maKhoaHoc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhoaHoc other = (KhoaHoc) obj;
		return Objects.equals(maKhoaHoc, other.maKhoaHoc);
	}
	
	@Override
	public String toString() {
		return String.format("%10s | %15s | %10s | %10s | ",
				getMaKhoaHoc(),
				getTenKhoaHoc(),
				getSoBuoiHoc(),
				df.format(tinhHocPhi())
				);
	}
}
