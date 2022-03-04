package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import daos.DVDDao;
import daos.KhachHangDao;
import daos.PhieuDatDao;
import daos.QuanLyChoThueDao;
import entities.CTHD;
import entities.DVD;
import entities.HoaDon;
import entities.KhachHang;
import entities.PhieuDatTruoc;

public class QuanLyChoThueFrame extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4414585133533176600L;
//	protected long idKH;

	private JPanel contentPane;
	protected JTextField txtIDTimKiem;
	private DefaultTableModel model;
	private JPanel panelContent;
	private JButton btnThem;
	private JPanel panelHeader;
	public static JPanel panel;

//	private final String[] columnNames = new String[] { "STT", "Mã HD", "Tên khách hàng", "Tên băng đĩa", "Số lượng",
//			"Ngày thuê", "Ngày trả", "Giá tiền" };

	private JButton btnTim;
	private JLabel lblTenKhachHang;
	private JLabel lblSoDienThoai;
	private JLabel lblDiaChi;
	private JPanel panelContentHeaderKH;
	private JLabel lblThngTinKhch;
	private JTextField txtIDKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JLabel lblIDKhachHang;
	private static ChoThueDialogFrame choThueDialogFrame = new ChoThueDialogFrame();
	private QuanLyChoThueDao quanLyChoThueDao = new QuanLyChoThueDao();
	private static MainForm mainForm = new MainForm();
	public static KhachHang layIDKH = new KhachHang();
	private static DVDDao dvdDao = new DVDDao();
	private static PhieuDatDao pdDAO = new PhieuDatDao();
	KhachHangDao khachHangDao = new KhachHangDao();
	DecimalFormat formatTien = new DecimalFormat("#,##0 vnđ");
	private JTextField txtNhapIDDVD;
	private JTextField txtIDDVD;
	private  JTextField txtTenDVD;
	private JTextField txtLoaiDVD;
	private JTextField txtGiaDVD;
	private JButton btnTraDVD;
	private JLabel lblNhapIDKH;
	private JLabel lblNhapIDDVD;
	private JPanel panelContentHeaderDVD;
	private JLabel lblThngTinDvd;
	private JLabel lblIDDVD;
	private JLabel lblTenDVD;
	private JLabel lblLoaiDVD;
	private JLabel lblGiaDVD;
	private JButton btnTimDVD;
	private JPanel panel_2;
//	private static JPanel panelQuanLyChoThue;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyChoThue frame = new QuanLyChoThue();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	public QuanLyChoThueFrame() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 1104, 610);
		contentPane.add(panel);

		panelHeader = new JPanel();
		panelHeader.setLayout(null);
		panelHeader.setBackground(new java.awt.Color(244, 204, 153));
		panelHeader.setBounds(0, 0, 1105, 80);
		panel.add(panelHeader);

		btnThem = new JButton("Thêm hóa đơn");
		btnThem.setToolTipText("Thêm hóa đơn");
		btnThem.setForeground(Color.WHITE);
		btnThem.setIcon(new ImageIcon(MainForm.class.getResource("/images/baseline_add_white_18dp.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBackground(new Color(0, 102, 204));
		btnThem.setBounds(341, 12, 188, 40);
		btnThem.setEnabled(false);
		btnThem.setToolTipText("Cần có khách hàng để thêm hóa đơn");
		panelHeader.add(btnThem);

		txtIDTimKiem = new JTextField();
		txtIDTimKiem.setBackground(new Color(255, 255, 255));
		txtIDTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIDTimKiem.setBounds(155, 12, 106, 40);
		panelHeader.add(txtIDTimKiem);
		txtIDTimKiem.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 102, 204));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTim.setBounds(262, 12, 78, 40);
		panelHeader.add(btnTim);

		panelContent = new JPanel();
		panelContent.setBackground(new java.awt.Color(244, 204, 153));
		panelContent.setBounds(0, 79, 1105, 531);
		panel.add(panelContent);
		panelContent.setLayout(null);

		lblIDKhachHang = new JLabel("Mã khách hàng:");
		lblIDKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDKhachHang.setBounds(10, 123, 148, 44);
		panelContent.add(lblIDKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKhachHang.setBounds(10, 177, 148, 44);
		panelContent.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(10, 233, 148, 44);
		panelContent.add(lblSoDienThoai);

		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChi.setBounds(10, 287, 108, 44);
		panelContent.add(lblDiaChi);

		panelContentHeaderKH = new JPanel();
		panelContentHeaderKH.setBackground(new java.awt.Color(145, 102, 72));
		panelContentHeaderKH.setBounds(0, 0, 545, 68);
		panelContent.add(panelContentHeaderKH);
		panelContentHeaderKH.setLayout(null);

		lblThngTinKhch = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKhch.setBounds(93, 11, 383, 46);
		panelContentHeaderKH.add(lblThngTinKhch);

		txtIDKhachHang = new JTextField();
		txtIDKhachHang.setEditable(false);
		txtIDKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		txtIDKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIDKhachHang.setBounds(158, 122, 305, 44);
		panelContent.add(txtIDKhachHang);
		txtIDKhachHang.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(158, 177, 305, 44);
		panelContent.add(txtTenKhachHang);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setHorizontalAlignment(SwingConstants.LEFT);
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(158, 232, 305, 44);
		panelContent.add(txtSoDienThoai);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(158, 287, 305, 44);
		panelContent.add(txtDiaChi);

		panelContentHeaderDVD = new JPanel();
		panelContentHeaderDVD.setLayout(null);
		panelContentHeaderDVD.setBackground(new java.awt.Color(145, 102, 72));
		panelContentHeaderDVD.setBounds(539, 0, 566, 68);
		panelContent.add(panelContentHeaderDVD);

		lblThngTinDvd = new JLabel("THÔNG TIN ĐĨA");
		lblThngTinDvd.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinDvd.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThngTinDvd.setBounds(56, 10, 486, 46);
		panelContentHeaderDVD.add(lblThngTinDvd);

		lblIDDVD = new JLabel("Mã đĩa:");
		lblIDDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDDVD.setBounds(590, 122, 108, 44);
		panelContent.add(lblIDDVD);

		txtIDDVD = new JTextField();
		txtIDDVD.setHorizontalAlignment(SwingConstants.LEFT);
		txtIDDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIDDVD.setEditable(false);
		txtIDDVD.setColumns(10);
		txtIDDVD.setBounds(708, 122, 305, 44);
		panelContent.add(txtIDDVD);

		lblTenDVD = new JLabel("Tên đĩa:");
		lblTenDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenDVD.setBounds(590, 177, 108, 44);
		panelContent.add(lblTenDVD);

		txtTenDVD = new JTextField();
		txtTenDVD.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenDVD.setEditable(false);
		txtTenDVD.setColumns(10);
		txtTenDVD.setBounds(708, 177, 305, 44);
		panelContent.add(txtTenDVD);

		lblLoaiDVD = new JLabel("Loại đĩa:");
		lblLoaiDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiDVD.setBounds(590, 232, 108, 44);
		panelContent.add(lblLoaiDVD);

		txtLoaiDVD = new JTextField();
		txtLoaiDVD.setHorizontalAlignment(SwingConstants.LEFT);
		txtLoaiDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLoaiDVD.setEditable(false);
		txtLoaiDVD.setColumns(10);
		txtLoaiDVD.setBounds(708, 232, 305, 44);
		panelContent.add(txtLoaiDVD);

		lblGiaDVD = new JLabel("Giá:");
		lblGiaDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaDVD.setBounds(590, 287, 108, 44);
		panelContent.add(lblGiaDVD);

		txtGiaDVD = new JTextField();
		txtGiaDVD.setHorizontalAlignment(SwingConstants.LEFT);
		txtGiaDVD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaDVD.setEditable(false);
		txtGiaDVD.setColumns(10);
		txtGiaDVD.setBounds(708, 287, 305, 44);
		panelContent.add(txtGiaDVD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(145, 102, 72));
		panel_1.setBounds(528, -69, 17, 600);
		panelContent.add(panel_1);

		lblNhapIDKH = new JLabel("Nhập mã khách hàng:");
		lblNhapIDKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhapIDKH.setBounds(2, 12, 153, 40);
		panelHeader.add(lblNhapIDKH);

		lblNhapIDDVD = new JLabel("Nhập mã đĩa:");
		lblNhapIDDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhapIDDVD.setBounds(556, 12, 97, 40);
		panelHeader.add(lblNhapIDDVD);

		txtNhapIDDVD = new JTextField();
		txtNhapIDDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhapIDDVD.setColumns(10);
		txtNhapIDDVD.setBackground(Color.WHITE);
		txtNhapIDDVD.setBounds(650, 13, 204, 40);
		panelHeader.add(txtNhapIDDVD);

		btnTimDVD = new JButton("Tìm");
		btnTimDVD.setForeground(Color.WHITE);
		btnTimDVD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimDVD.setBackground(new Color(0, 102, 204));
		btnTimDVD.setBounds(1006, 11, 89, 40);
		panelHeader.add(btnTimDVD);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new java.awt.Color(145, 102, 72));
		panel_2.setBounds(529, 0, 17, 80);
		panelHeader.add(panel_2);
		
		//		model = new DefaultTableModel(columnNames, 0);
		//		model = new DefaultTableModel(columnNames, 0);
		//		JRootPane rootPane = SwingUtilities.getRootPane(this);
		//		rootPane.setDefaultButton(btnTim);
		
				btnTraDVD = new JButton("Trả DVD");
				btnTraDVD.setBounds(864, 12, 126, 40);
				panelHeader.add(btnTraDVD);
				btnTraDVD.setToolTipText("Thêm hóa đơn");
				btnTraDVD.setForeground(Color.WHITE);
				btnTraDVD.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnTraDVD.setEnabled(false);
				btnTraDVD.setBackground(new Color(0, 102, 204));
				btnTraDVD.setToolTipText("Cần có ID DVD để trả đĩa");
				btnTraDVD.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnTimDVD.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
//			mainForm.setEnabled(false);
//			if (!choThueDialogFrame.btnDong.getModel().isPressed()
//					|| !choThueDialogFrame.btnLapHoaDon.getModel().isPressed()) {
//				mainForm.setEnabled(false);
//			} else {
//				SmainForm.setEnabled(true);
//			}
//			choThueDialogFrame.setLocationRelativeTo(null);
//			choThueDialogFrame.setVisible(true);

			/**
			 * kiểm tra có phí trả chậm hay không khi ko có column phiTreHan
			 */
			try {
//				List<HoaDon> hoaDons = quanLyChoThueDao.getHoaDonsByIDKH(layIDKH.getiDKH());
//				List<Long> iDHDs = new ArrayList<Long>();
//				for (HoaDon hoaDon : hoaDons) {
//					iDHDs.add(hoaDon.getiDHD());
//				}
//				List<CTHD> cthds = new ArrayList<CTHD>();
//				for (Long iDHD : iDHDs) {
//					cthds = quanLyChoThueDao.getChiTietHoaDonsByIDHD(iDHD);
//				}
//				int ngaythue;
//				String loai;
//				LocalDate dayNow = LocalDate.now();
//				double phiTraCham = 0;
//				for (CTHD cthd : cthds) {
//					if (cthd.getdVD().getTrangThai() == 1) {
//						loai = cthd.getdVD().getTieuDeDVD().getLoaiDVD().getTenLoai();
//						if (loai.equals("Game"))
//							ngaythue = 20;
//						else
//							ngaythue = 10;
//						if (cthd.getHoaDon().getNgayThue().plusDays(ngaythue).compareTo(dayNow) == -1) {
//							phiTraCham = phiTraCham + (cthd.getdVD().getTieuDeDVD().getLoaiDVD().getGiaThue() * 0.5);
//						}
//					}
//				}
				KhachHang khachHang = quanLyChoThueDao.layThongTinKhachHang(layIDKH.getiDKH());
				double phiTreHan = khachHang.getphiTreHan();
				if (phiTreHan == 0) {
					/**
					 * nếu không có phí trả chậm thông báo chuyển đến form cho thue
					 */
					choThueDialogFrame.setLocationRelativeTo(null);
					choThueDialogFrame.setVisible(true);
					mainForm.setEnabled(false);

				} 
				if(phiTreHan!=0){
					/**
					 * nếu có phí trả chậm thông báo có 2 lựa chọn là tiếp tục thuê hoặc trả phí trả
					 * châm nếu chọn tiếp tục thuê sẽ chuyển đến form thuê, ngược lại nếu chọn trả
					 * phí sẽ chuyển đến form trả phí
					 */
					int a = JOptionPane.showConfirmDialog(this,
							"Khách hàng này đang có phí trả chậm !\n Có muốn thanh toán hay không ?", "Thông báo",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (a == JOptionPane.YES_OPTION) {
						/**
						 * chuyển qua form thanh toán phí trả chậm.use case trả phí bắt đầu ở đây
						 */
						ThanhToanFrame thanhToanFrame = new ThanhToanFrame();
						
						thanhToanFrame.setLocationRelativeTo(null);
						thanhToanFrame.setVisible(true);
						thanhToanFrame.hienThiKhachHang(khachHang);
						mainForm.setEnabled(false);
					} 
					if(a==JOptionPane.NO_OPTION){
						/**
						 * chuyển đến form thuê
						 */
						choThueDialogFrame.setLocationRelativeTo(null);
						choThueDialogFrame.setVisible(true);
						mainForm.setEnabled(false);
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		/**
		 * xử lí button Tìm
		 */
		else if (obj.equals(btnTim)) {
			String txtId = txtIDTimKiem.getText().trim();
			if (txtId.equalsIgnoreCase("") || txtId.isEmpty()) {
				setNull();
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng !", "Lỗi", JOptionPane.ERROR_MESSAGE);
				btnThem.setEnabled(false);
				btnThem.setToolTipText("Cần có khách hàng để thêm hóa đơn");
				txtIDTimKiem.selectAll();
				txtIDTimKiem.requestFocus();
			} else {
				try {
					KhachHang khachHang = new KhachHang();
					long idKH = Long.parseLong(txtId);
					khachHang = quanLyChoThueDao.layThongTinKhachHang(idKH);
//					idKH = khachHang.getiDKH();
					layIDKH = khachHang;
					txtIDKhachHang.setText(khachHang.getiDKH() + "");
					txtTenKhachHang.setText(khachHang.getTen());
					txtDiaChi.setText(khachHang.getDiaChi());
					txtSoDienThoai.setText(khachHang.getSdt());

					btnThem.setEnabled(true);
					btnThem.setToolTipText("Thêm hóa đơn");
					txtIDTimKiem.selectAll();
					txtIDTimKiem.requestFocus();
					choThueDialogFrame.defaultListModel.removeAllElements();
					choThueDialogFrame.loadDataToListDia();
//					JRootPane rootPane = SwingUtilities.getRootPane(this);
//					rootPane.setDefaultButton(btnTim);
				} catch (NullPointerException e1) {
					setNull();
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại !", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					btnThem.setEnabled(false);
					btnThem.setToolTipText("Cần có khách hàng để thêm hóa đơn");
					txtIDTimKiem.selectAll();
					txtIDTimKiem.requestFocus();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(this, "Mã khách hàng là số nguyên !", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					txtIDTimKiem.selectAll();
					txtIDTimKiem.requestFocus();
				} catch (Exception e2) {
					setNull();
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lỗi hệ thống !", "Thông báo", JOptionPane.ERROR_MESSAGE);
					btnThem.setEnabled(false);
					btnThem.setToolTipText("Cần có khách hàng để thêm hóa đơn");
					txtIDTimKiem.selectAll();
					txtIDTimKiem.requestFocus();
				}

			}

		} else if (obj.equals(btnTimDVD)) {
			String idStr = txtNhapIDDVD.getText().trim();
			if (idStr.equals("") || idStr.isEmpty()) {
				setNullDVD();
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã DVD !", "Lỗi !", JOptionPane.ERROR_MESSAGE);
				txtNhapIDDVD.selectAll();
				txtNhapIDDVD.requestFocus();
			} else {
				try {
					long id = Long.parseLong(idStr);
					DVD dvd = dvdDao.getDVDByID(id);
					txtIDDVD.setText(String.valueOf(dvd.getiDDVD()));
					txtTenDVD.setText(dvd.getTieuDeDVD().getTenTieuDe());
					txtLoaiDVD.setText(dvd.getTieuDeDVD().getLoaiDVD().getTenLoai());
					txtGiaDVD.setText(String.valueOf(dvd.getTieuDeDVD().getLoaiDVD().getGiaThue()));
					btnTraDVD.setEnabled(true);
					btnTraDVD.setToolTipText("Trả đĩa");
					txtNhapIDDVD.selectAll();
					txtNhapIDDVD.requestFocus();
				} catch (NullPointerException e2) {
					setNullDVD();
					JOptionPane.showMessageDialog(this,
							"Không tồn tại DVD có mã " + txtNhapIDDVD.getText().trim() + " !", "Thông báo !",
							JOptionPane.ERROR_MESSAGE);
					btnTraDVD.setEnabled(false);
					txtNhapIDDVD.selectAll();
					txtNhapIDDVD.requestFocus();
				} catch (NumberFormatException e2) {
					setNullDVD();
					JOptionPane.showMessageDialog(this, "Mã DVD là số nguyên !", "Thông báo !",
							JOptionPane.ERROR_MESSAGE);
					btnTraDVD.setEnabled(false);
					txtNhapIDDVD.selectAll();
					txtNhapIDDVD.requestFocus();
				} catch (Exception e2) {
					setNullDVD();
					JOptionPane.showMessageDialog(this, "Lỗi hệ thống !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
					btnTraDVD.setEnabled(false);
					txtNhapIDDVD.selectAll();
					txtNhapIDDVD.requestFocus();
				}

			}
		} else if (obj.equals(btnTraDVD)) {
			String idDVD = txtIDDVD.getText();
			if (idDVD.equals("") || idDVD.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Cần nhập mã ID DVD trước khi chọn chức năng trả đĩa !",
						"Thông báo !", JOptionPane.ERROR_MESSAGE);
				txtNhapIDDVD.selectAll();
				txtNhapIDDVD.requestFocus();
			} else {
				try {
					DVD dvd = dvdDao.getDVDByID(Long.parseLong(idDVD));
					try {
						List<CTHD> cthds = quanLyChoThueDao.getChiTietHoaDonsByIDDVDOrderByNgay(dvd.getiDDVD());
						if (cthds.size() > 0) {

							for (CTHD cthd : cthds) {
//								ngaymax=cthd.getHoaDon().getNgayThue();
								if (cthd.getdVD().getTrangThai() == 1) {
									System.out.println(dvd.getiDDVD() + "-" + dvd.getTieuDeDVD().getTenTieuDe() + "-"
											+ cthd.getHoaDon().getKhachHang().getTen()
											+ cthd.getHoaDon().getKhachHang().getphiTreHan());
//									JOptionPane.showMessageDialog(this, "Đĩa trả dc !", "Thông báo !",
//											JOptionPane.ERROR_MESSAGE);

									LocalDate dayNow = LocalDate.now();
									LocalDate ngayThue = cthd.getHoaDon().getNgayThue();
									int ngayDuocThue = cthd.getdVD().getTieuDeDVD().getLoaiDVD().getThoiGianThue();
									float phi = (float) (cthd.getdVD().getTieuDeDVD().getLoaiDVD().getGiaThue() * 0.3);
									String tenKH,sdt,diachi;				
									long idTieuDe = cthd.getdVD().getTieuDeDVD().getiDTieuDe();
									System.out.println(idTieuDe+"");
									String ten = txtTenDVD.getText().toString();
									String id = txtIDDVD.getText().toString();
									
									if (ngayThue.plusDays(ngayDuocThue).isAfter(dayNow)) {
										if (cthd.getHoaDon().getKhachHang().getphiTreHan() == 0) {																				
											if(dvdDao.ktraDatTruoc(idTieuDe)==1) {
												cthd.getdVD().setTrangThai(2);
												dvdDao.updateDVD(cthd.getdVD());
						
												long idTD = cthd.getdVD().getTieuDeDVD().getiDTieuDe();
												List<PhieuDatTruoc> listpdt = pdDAO.getdPhieuDatByTieuDeDVD(idTieuDe);
					
												tenKH = listpdt.get(0).getKhachHang().getTen().toUpperCase();
												sdt = listpdt.get(0).getKhachHang().getSdt();
												diachi = listpdt.get(0).getKhachHang().getDiaChi();
												
												JOptionPane.showMessageDialog(this,
														"Trả thành công với đĩa: \""+ten+"\"-Mã:"+id+"\n"+"Có khách hàng đã đặt trước cho tiêu đề \""+ten+"\" này.\n"
																+ "Liên hệ khách hàng đến nhận đĩa:\n"
																+ "	- Tên: "+tenKH+"\n" 
																+ "	- SĐT: "+sdt+"\n"
																+ "	- Địa chỉ: "+diachi, "Thông báo",
														JOptionPane.INFORMATION_MESSAGE);
												listpdt.get(0).setTrangThai(true);
												pdDAO.capNhatTrangThaiPhieuDat(listpdt.get(0));
											}else {
												cthd.getdVD().setTrangThai(0);
												dvdDao.updateDVD(cthd.getdVD());
												JOptionPane.showMessageDialog(this,
														"Trả thành công với đĩa: \""+ten+"\"-Mã: "+id, "Thông báo",
														JOptionPane.INFORMATION_MESSAGE);
											}																	
											break;
										} else {
											int luaChonKH = JOptionPane.showConfirmDialog(this,
													"Khách hàng này đang có phí trể hạn là "
															+ formatTien.format(
																	cthd.getHoaDon().getKhachHang().getphiTreHan())
															+ "\n Có muốn thanh toán hay không ?",
													"Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
											if (luaChonKH == JOptionPane.YES_OPTION) {
												cthd.getdVD().setTrangThai(0);
												dvdDao.updateDVD(cthd.getdVD());
												/**
												 * chuyển qua form thanh toán phi trả châm. use case ghi nhận phí trả
												 * chậm bắt đầu tại đây
												 */
												ThanhToanKhiTraFrame thanhToanKhiTraFrame = new ThanhToanKhiTraFrame();
												KhachHang khachHang = quanLyChoThueDao.layThongTinKhachHang(layIDKH.getiDKH());
												
												thanhToanKhiTraFrame.setLocationRelativeTo(null);
												thanhToanKhiTraFrame.setVisible(true);
												thanhToanKhiTraFrame.hienThiKhachHang(khachHang);
												mainForm.setEnabled(false);
												break;
												
											} else if (luaChonKH == JOptionPane.NO_OPTION) {
												cthd.getdVD().setTrangThai(0);
												dvdDao.updateDVD(cthd.getdVD());
												JOptionPane.showMessageDialog(this,
														"Trả đĩa thành công với ID DVD là " + dvd.getiDDVD(),
														"Thông báo", JOptionPane.INFORMATION_MESSAGE);
												break;
											} else {
												JOptionPane.showMessageDialog(this,
														"Trả đĩa không thành công với ID DVD là " + dvd.getiDDVD(),
														"Thông báo", JOptionPane.INFORMATION_MESSAGE);
												break;
											}
										}
									} else {
										cthd.getHoaDon().getKhachHang()
												.setphiTreHan(phi + cthd.getHoaDon().getKhachHang().getphiTreHan());
										khachHangDao.capnhatKhachHang(cthd.getHoaDon().getKhachHang());
										int luaChonKH = JOptionPane.showConfirmDialog(this,
												"Khách hàng này đang có phí trể hạn là "
														+ formatTien
																.format(cthd.getHoaDon().getKhachHang().getphiTreHan())
														+ "\n Có muốn thanh toán hay không ?",
												"Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
										if (luaChonKH == JOptionPane.YES_OPTION) {
											cthd.getdVD().setTrangThai(0);
											dvdDao.updateDVD(cthd.getdVD());
											/**
											 * chuyển qua form thanh toán phi trả châm. use case ghi nhận phí trả chậm
											 * bắt đầu tại đây
											 */
											ThanhToanKhiTraFrame thanhToanKhiTraFrame = new ThanhToanKhiTraFrame();
											KhachHang khachHang = quanLyChoThueDao.layThongTinKhachHang(layIDKH.getiDKH());
											
											thanhToanKhiTraFrame.setLocationRelativeTo(null);
											thanhToanKhiTraFrame.setVisible(true);
											thanhToanKhiTraFrame.hienThiKhachHang(khachHang);
											mainForm.setEnabled(false);
											
										} else if (luaChonKH == JOptionPane.NO_OPTION) {
											cthd.getdVD().setTrangThai(0);
											dvdDao.updateDVD(cthd.getdVD());
											JOptionPane.showMessageDialog(this,
													"Trả đĩa thành công với ID DVD là " + dvd.getiDDVD(), "Thông báo",
													JOptionPane.INFORMATION_MESSAGE);
											break;
										} else {
											JOptionPane.showMessageDialog(this,
													"Trả đĩa không thành công với ID DVD là " + dvd.getiDDVD(),
													"Thông báo", JOptionPane.INFORMATION_MESSAGE);
											break;
										}
									}

//								} else if (cthds.size() == 0) {
//									JOptionPane.showMessageDialog(this,
//											"Đĩa có mã " + idDVD + " không thể trả vì hiện đang không cho thuê !",
//											"Thông báo !", JOptionPane.ERROR_MESSAGE);
//									txtNhapIDDVD.selectAll();
//									txtNhapIDDVD.requestFocus();
//									break;
								} else if (cthd.getdVD().getTrangThai() != 1) {
									JOptionPane.showMessageDialog(this,
											"Đĩa có mã " + idDVD + " không thể trả vì hiện đang không cho thuê !",
											"Thông báo !", JOptionPane.ERROR_MESSAGE);
									txtNhapIDDVD.selectAll();
									txtNhapIDDVD.requestFocus();
									break;
								} else {
									JOptionPane.showMessageDialog(this, "Lỗi hệ thống !", "Thông báo !",
											JOptionPane.ERROR_MESSAGE);
									txtNhapIDDVD.selectAll();
									txtNhapIDDVD.requestFocus();
									break;
								}
							}
						} else {
							JOptionPane.showMessageDialog(this,
									"Đĩa có mã " + idDVD + " không thể trả vì hiện đang không cho thuê !",
									"Thông báo !", JOptionPane.ERROR_MESSAGE);
							txtNhapIDDVD.selectAll();
							txtNhapIDDVD.requestFocus();
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Lỗi không xác định !", "Thông báo !",
								JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
					}
//					CTHD cthd = cthds.get(0);
//					if(cthd.getdVD().getTrangThai()==1) {
//					System.out.println(dvd.getiDDVD() + "-" + dvd.getTieuDeDVD().getTenTieuDe() + "-"
//							+ cthd.getHoaDon().getKhachHang().getTen());
//					}

//					LocalDate dayNow = LocalDate.now();
//					if(dvd.get)
//					for (CTHD cthd : cthds) {
//						if (cthd.getdVD().getTrangThai() == 1) {
//							loai = cthd.getdVD().getTieuDeDVD().getLoaiDVD().getTenLoai();
//							if (loai.equals("Game"))
//								ngaythue = 20;
//							else
//								ngaythue = 10;
//							if (cthd.getHoaDon().getNgayThue().plusDays(ngaythue).compareTo(dayNow) == -1) {
//								phiTraCham = phiTraCham + (cthd.getdVD().getTieuDeDVD().getLoaiDVD().getGiaThue() * 0.5);
//							}
//						}
//					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}

	}

	/**
	 * làm rỗng các text field thông tin khách hàng
	 */
	private void setNull() {
		txtIDKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
	}

	private void setNullDVD() {
		txtIDDVD.setText("");
		txtTenDVD.setText("");
		txtLoaiDVD.setText("");
		txtGiaDVD.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
