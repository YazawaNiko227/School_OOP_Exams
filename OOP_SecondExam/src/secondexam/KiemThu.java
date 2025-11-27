package secondexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KiemThu {
    public static void main(String[] args) {
        List<KhoaHoc> danhSach = new ArrayList<>();
        QuanLyKhoaHoc ql = new QuanLyKhoaHoc(danhSach);

        // 3.1: Thêm 10 khóa học (5 lý thuyết, 5 thực hành)
        for (int i = 1; i <= 5; i++) {
            KhoaHocLyThuyet lt = new KhoaHocLyThuyet(
                "LT0" + i,
                "Lý thuyết môn " + i,
                10 + i,
                i % 2 == 0 ? HinhThuc.TRUC_TUYEN : HinhThuc.TAI_LOP,
                i % 2 == 0
            );
            ql.themKhoaHoc(lt.getMaKhoaHoc(), lt);
        }

        for (int i = 1; i <= 5; i++) {
            KhoaHocThucHanh th = new KhoaHocThucHanh(
                "TH0" + i,
                "Thực hành môn " + i,
                8 + i,
                "Phòng Lab " + i,
                10 + i
            );
            ql.themKhoaHoc(th.getMaKhoaHoc(), th);
        }

        // 3.2: Gọi các phương thức và kiểm tra kết quả

        // In danh sách ban đầu
        System.out.println("📘 Danh sách khóa học ban đầu:");
        System.out.println(ql);

        // Kiểm tra tìm kiếm thành công
        System.out.println("\n🔍 Tìm kiếm LT01:");
        System.out.println(ql.timKiemBangMaTraVeKhoaHoc("LT01"));

        // Kiểm tra tìm kiếm thất bại
        System.out.println("\n🔍 Tìm kiếm KHONGTONTAI:");
        System.out.println(ql.timKiemBangMaTraVeKhoaHoc("KHONGTONTAI"));

        // Kiểm tra thêm trùng mã (thất bại)
        System.out.println("\n➕ Thêm trùng mã LT01:");
        try {
            ql.themKhoaHoc("LT01", new KhoaHocLyThuyet("LT01", "Trùng mã", 5, HinhThuc.TAI_LOP, false));
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }

        // Kiểm tra cập nhật thành công
        System.out.println("\n✏️ Cập nhật LT02:");
        boolean capNhat = ql.capNhatKhoaHoc("LT02", "Lý thuyết nâng cao", 20);
        System.out.println("Thành công? " + capNhat);
        System.out.println(ql.timKiemBangMaTraVeKhoaHoc("LT02"));

        // Kiểm tra cập nhật thất bại
        System.out.println("\n✏️ Cập nhật KHONGTONTAI:");
        boolean capNhatFail = ql.capNhatKhoaHoc("KHONGTONTAI", "Không tồn tại", 5);
        System.out.println("Thành công? " + capNhatFail);

        // Kiểm tra sắp xếp
        System.out.println("\n📊 Danh sách sau khi sắp xếp:");
        ql.sapXep().forEach(System.out::println);

        // Kiểm tra trung bình học phí theo loại
        System.out.println("\n📈 Trung bình học phí theo loại:");
        Map<String, Double> tbHocPhi = ql.trungBinhHocPhi();
        tbHocPhi.forEach((loai, tb) -> System.out.println(loai + " : " + tb));
    }
}
