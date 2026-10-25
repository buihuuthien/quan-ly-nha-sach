import giohang.GioHang;
import hoadon.*;
import khachhang.*;
import kho.*;
import mathang.*;
import nhanvien.*;
import phieunhap.*;
import thanhtoan.*;
import tienich.TienIch;
 

public class Main {
 
    // ====== Dữ liệu dùng chung ======
    static Kho kho = new Kho();
    static DanhSachMatHang dsmh = new DanhSachMatHang();
    static DanhSachKhachHang dskh = new DanhSachKhachHang();
    static DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();
    static DanhSachHoaDon dshd = new DanhSachHoaDon(dsmh, dskh);
 
    // Nhân viên bán hàng mẫu để lập hóa đơn
    static NhanVienBanHang nvBanHang =
            new NhanVienBanHang("NV01", "Nguyen Van A", "0900000000", "123", "Sang", 8000000);
 
    static String hoiFile(String macDinh) {
        String s = TienIch.nhapChuoi("Nhập đường dẫn file (gõ . để dùng mặc định '" + macDinh + "'): ").trim();
        return (s.isEmpty() || s.equals(".")) ? macDinh : s;
    }
 
    // ====== Menu chính ======
    static void menuChinh() {
        System.out.println();
        System.out.println("============ QUẢN LÝ NHÀ SÁCH ============");
        System.out.println("1. Quản lý kho");
        System.out.println("2. Quản lý phiếu nhập");
        System.out.println("3. Quản lý mặt hàng (cửa hàng)");
        System.out.println("4. Quản lý khách hàng");
        System.out.println("5. Quản lý hóa đơn");
        System.out.println("6. Mua hàng (giỏ hàng)");
        System.out.println("7. Xem thông tin nhân viên mẫu");
        System.out.println("0. Thoát");
        System.out.println("==========================================");
    }
 
    // ====== Kho ======
    static void menuKho() {
        int chon;
        do {
            System.out.println("\n---------- KHO ----------");
            System.out.println("1. Xem hàng tồn");
            System.out.println("2. Thêm 1 mặt hàng vào kho");
            System.out.println("3. Nhập nhiều mặt hàng vào kho");
            System.out.println("4. Sửa số lượng tồn");
            System.out.println("5. Xóa mặt hàng khỏi kho");
            System.out.println("6. Tra cứu theo mã");
            System.out.println("7. Kiểm tra sức chứa");
            System.out.println("8. Đọc kho từ file");
            System.out.println("9. Ghi kho ra file");
            System.out.println("0. Quay lại");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: kho.xuat(); break;
                case 2: kho.them(); break;
                case 3: kho.nhap(); break;
                case 4: kho.sua(); break;
                case 5: kho.xoa(); break;
                case 6: kho.timHangTon(); break;
                case 7: kho.kiemTraSucChua(); break;
                case 8: kho.docFile(hoiFile("kho/kho_input.txt")); break;
                case 9: kho.ghiFile(hoiFile("kho/kho_output.txt")); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // ====== Phiếu nhập ======
    static void menuPhieuNhap() {
        int chon;
        do {
            System.out.println("\n---------- PHIẾU NHẬP ----------");
            System.out.println("1. Xem danh sách phiếu nhập");
            System.out.println("2. Thêm 1 phiếu nhập");
            System.out.println("3. Thêm nhiều phiếu nhập");
            System.out.println("4. Sửa phiếu nhập");
            System.out.println("5. Xóa phiếu nhập");
            System.out.println("6. Nhập hàng của phiếu vào kho");
            System.out.println("7. Xem hàng tồn trong kho");
            System.out.println("8. Đọc phiếu nhập từ file");
            System.out.println("9. Ghi phiếu nhập ra file");
            System.out.println("0. Quay lại");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: dspn.xuat(); break;
                case 2: dspn.them(); break;
                case 3: dspn.nhap(); break;
                case 4: dspn.sua(); break;
                case 5: dspn.xoa(); break;
                case 6: dspn.nhapKho(kho); break;
                case 7: kho.xuat(); break;
                case 8: dspn.docFile(hoiFile("phieunhap/phieunhap_input.txt")); break;
                case 9: dspn.ghiFile(hoiFile("phieunhap/phieunhap_output.txt")); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // ====== Mặt hàng ======
    static void menuMatHang() {
        int chon;
        do {
            System.out.println("\n---------- MẶT HÀNG (CỬA HÀNG) ----------");
            System.out.println("1. Xem số lượng mặt hàng đang bày bán");
            System.out.println("2. Nhập hàng loạt từ kho lên");
            System.out.println("3. Nhập 1 mặt hàng cụ thể từ kho lên");
            System.out.println("4. Xuất danh sách mặt hàng");
            System.out.println("5. Thêm mặt hàng");
            System.out.println("6. Xóa mặt hàng");
            System.out.println("7. Sửa mặt hàng");
            System.out.println("8. Tìm kiếm theo mã");
            System.out.println("9. Bộ lọc nâng cao");
            System.out.println("0. Quay lại");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: System.out.println("Số mặt hàng: " + dsmh.getSoMH()); break;
                case 2: dsmh.nhapHangLoat(kho); break;
                case 3: {
                    // dsmh.nhap() dùng field kho chưa được khởi tạo nên gọi nhapTuKho trực tiếp
                    String ma = TienIch.nhapChuoi("Nhập mã hàng cần lấy từ kho: ");
                    int sl = TienIch.nhapSoNguyenDuong("Nhập số lượng cần lấy: ");
                    dsmh.nhapTuKho(kho, ma, sl);
                    break;
                }
                case 4: dsmh.xuat(); break;
                case 5: dsmh.them(); break;
                case 6: dsmh.xoa(); break;
                case 7: dsmh.sua(); break;
                case 8: dsmh.timkiem(); break;
                case 9: dsmh.timkiem_nangcao(); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // ====== Khách hàng ======
    static void menuKhachHang() {
        int chon;
        do {
            System.out.println("\n---------- KHÁCH HÀNG ----------");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Nhập nhiều khách hàng");
            System.out.println("4. Sửa khách hàng");
            System.out.println("5. Xóa khách hàng");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi ra file");
            System.out.println("0. Quay lại");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: dskh.xuat(); break;
                case 2: dskh.them(); break;
                case 3: dskh.nhap(); break;
                case 4: dskh.sua(); break;
                case 5: dskh.xoa(); break;
                case 6: dskh.docFile(hoiFile("khachhang.txt")); break;
                case 7: dskh.ghiFile(hoiFile("khachhang.txt")); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // ====== Hóa đơn ======
    static void menuHoaDon() {
        int chon;
        do {
            System.out.println("\n---------- HÓA ĐƠN ----------");
            System.out.println("1. Xem danh sách hóa đơn");
            System.out.println("2. Lập hóa đơn mới");
            System.out.println("3. Sửa hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Đọc từ file");
            System.out.println("6. Ghi ra file");
            System.out.println("7. Thanh toán hóa đơn");
            System.out.println("0. Quay lại");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: dshd.xuat(); break;
                case 2: {
                    String maKH = TienIch.nhapChuoi("Nhập mã khách hàng: ");
                    KhachHang kh = dskh.timkiem_khachhang(maKH);
                    if (kh == null) {
                        System.out.println("Không tìm thấy khách hàng! Hãy thêm khách hàng trước.");
                        break;
                    }
                    String maHD = TienIch.nhapChuoi("Nhập mã hóa đơn: ");
                    dshd.taoHoaDon(maHD, kh, nvBanHang);
                    break;
                }
                case 3: dshd.sua(); break;
                case 4: dshd.xoa(); break;
                case 5: dshd.docFile(hoiFile("hoadon.txt"), dskh, dsmh); break;
                case 6: dshd.ghiFile(hoiFile("hoadon.txt")); break;
                case 7: {
                    HoaDon hd = dshd.timKiem(TienIch.nhapChuoi("Nhập mã hóa đơn cần thanh toán: "));
                    if (hd == null) System.out.println("Không tìm thấy hóa đơn!");
                    else thanhToanHoaDon(hd);
                    break;
                }
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // ====== Thanh toán hóa đơn ======
    // Chọn hình thức, thu tiền, thành công thì hàng trên kệ được trừ (do HoaDon.thanhToan()).
    static void thanhToanHoaDon(HoaDon hd) {
        if (hd.isDaThanhToan()) {
            System.out.println("Hóa đơn này đã được thanh toán!");
            return;
        }
        while (!hd.isDaThanhToan()) {
            System.out.printf("Tổng tiền cần thanh toán: %.0f%n", hd.tinhThanhTien());
            System.out.println("Hình thức thanh toán: 1. Tiền mặt  2. Thẻ  0. Thanh toán sau");
            int chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            if (chon == 0) {
                System.out.println("Hóa đơn chưa thanh toán, có thể thanh toán sau ở menu Hóa đơn.");
                return;
            }
            if (chon == 1) {
                hd.setHinhThucThanhToan(new ThanhToanTienMat(TienIch.nhapGiaTien("Nhập số tiền khách đưa: ")));
            } else if (chon == 2) {
                String maGD = TienIch.nhapChuoi("Nhập mã giao dịch: ");
                hd.setHinhThucThanhToan(new ThanhToanThe(maGD, TienIch.nhapChuoi("Nhập tên ngân hàng: ")));
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }
            if (!hd.thanhToan()
                    && !TienIch.nhapChuoi("Thanh toán chưa thành công. Thử lại? (c/k): ").equalsIgnoreCase("c")) {
                System.out.println("Hóa đơn chưa thanh toán, có thể thanh toán sau ở menu Hóa đơn.");
                return;
            }
        }
    }

    // ====== Mua hàng (giỏ hàng) ======
    // Chỉ khi khách xác nhận mua mới xuất hóa đơn; thoát hoặc không xác nhận thì không có hóa đơn.
    static void muaHang() {
        if (dsmh.getSoMH() == 0) {
            System.out.println("Cửa hàng chưa có mặt hàng nào để bán! Hãy nhập hàng từ kho lên kệ trước.");
            return;
        }
        KhachHang kh = dskh.timkiem_khachhang(TienIch.nhapChuoi("Nhập mã khách hàng: "));
        if (kh == null) {
            System.out.println("Không tìm thấy khách hàng! Hãy thêm khách hàng trước.");
            return;
        }
        GioHang gh = new GioHang(kh);
        int chon;
        do {
            System.out.println("\n---------- GIỎ HÀNG: " + kh.getTenKH() + " ----------");
            System.out.println("1. Xem giỏ hàng");
            System.out.println("2. Thêm mặt hàng vào giỏ");
            System.out.println("3. Sửa số lượng (nhập 0 để xóa)");
            System.out.println("4. Xóa mặt hàng khỏi giỏ");
            System.out.println("5. Xác nhận mua và xuất hóa đơn");
            System.out.println("0. Thoát (không mua)");
            chon = TienIch.nhapSoNguyenDuong("Chọn: ");
            switch (chon) {
                case 1: gh.xemGioHang(); break;
                case 2: {
                    MatHang mh = dsmh.timKiem_hang(TienIch.nhapChuoi("Nhập mã mặt hàng cần mua: "));
                    if (mh == null) System.out.println("Không tìm thấy mặt hàng trên kệ!");
                    else gh.themVaoGio(mh, TienIch.nhapSoNguyenDuong("Nhập số lượng: "));
                    break;
                }
                case 3: {
                    String ma = TienIch.nhapChuoi("Nhập mã mặt hàng cần sửa: ");
                    gh.capNhatSoLuong(ma, TienIch.nhapSoNguyenDuong("Nhập số lượng mới: "));
                    break;
                }
                case 4: gh.xoaKhoiGio(TienIch.nhapChuoi("Nhập mã mặt hàng cần xóa: ")); break;
                case 5: {
                    if (gh.isRong()) {
                        System.out.println("Giỏ hàng trống, không thể mua!");
                        break;
                    }
                    gh.xemGioHang();
                    if (!TienIch.nhapChuoi("Xác nhận mua hàng? (c/k): ").equalsIgnoreCase("c")) {
                        System.out.println("Chưa mua hàng nên không xuất hóa đơn.");
                        break;
                    }
                    HoaDon hd = gh.xacNhanMua(dshd, TienIch.nhapChuoi("Nhập mã hóa đơn: "), nvBanHang);
                    if (hd != null) {
                        System.out.println("Đã xuất hóa đơn thành công!");
                        hd.xuat();
                        thanhToanHoaDon(hd);
                        chon = 0; // mua xong, quay về menu chính
                    }
                    break;
                }
                case 0:
                    if (!gh.isRong()) System.out.println("Đã bỏ giỏ hàng, không xuất hóa đơn.");
                    break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        int chon;
        do {
            menuChinh();
            chon = TienIch.nhapSoNguyenDuong("Chọn chức năng: ");
            switch (chon) {
                case 1: menuKho(); break;
                case 2: menuPhieuNhap(); break;
                case 3: menuMatHang(); break;
                case 4: menuKhachHang(); break;
                case 5: menuHoaDon(); break;
                case 6: muaHang(); break;
                case 7: nvBanHang.xuatThongTin(); break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}
