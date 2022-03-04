package guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import daos.ChoThueDialogDao;
import daos.DVDDao;
import daos.HoaDonDao;
import daos.QuanLyChoThueDao;
import entities.CTHD;
import entities.DVD;
import entities.HoaDon;
import entities.KhachHang;

public class ChoThueDialogFrame extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelTitle;
	private JTextField txtTongTien, txtTim;
	private JLabel lblThngTina, lblchonLoaiDia, lblTongTien;

	private JList listDia, listDiaThue;

	private static JComboBox cbLoaiDia;
	private JButton btnThem, btnLamMoi, btnTim, btnXoa, btnDong, btnLapHoaDon;

	private static MainForm mainForm = new MainForm();
	private static HoaDonDao hoaDonDao = new HoaDonDao();
	DecimalFormat formatTien = new DecimalFormat("#,##0 vnđ");
	private static DVDDao dvdDao = new DVDDao();
	private static ChoThueDialogDao choThueDialogDao = new ChoThueDialogDao();
	private static QuanLyChoThueDao quanLyChoThueDao = new QuanLyChoThueDao();
	private static QuanLyChoThueFrame quanLyChoThueFrame = new QuanLyChoThueFrame();
	public static DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
	public static DefaultListModel<String> defaultListModelDiaThue = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoThueDialogFrame frame = new ChoThueDialogFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ChoThueDialogFrame() {
//		frame=new JFrame();
//		frame.add(contentPane);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 545);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelTitle = new JPanel();
		panelTitle.setBackground(new Color(222, 184, 135));
		panelTitle.setBounds(0, 0, 709, 42);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);

		lblThngTina = new JLabel("Thông tin đĩa thuê");
		lblThngTina.setBackground(new Color(222, 184, 135));
		lblThngTina.setForeground(new Color(255, 255, 255));
		lblThngTina.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblThngTina.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTina.setBounds(0, 0, 709, 42);
		panelTitle.add(lblThngTina);

		listDia = new JList();
		listDia.setModel(defaultListModel);
		
		listDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listDia.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		listDia.setBounds(10, 100, 285, 337);
		JScrollPane scrolllistDia = new JScrollPane();
		scrolllistDia.setBounds(10, 100, 285, 337);
		scrolllistDia.setViewportView(listDia);
		contentPane.add(scrolllistDia);

		listDiaThue = new JList();
		
		listDiaThue.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"C\u00E1c \u0111\u0129a \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLACK));
		listDiaThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listDiaThue.setBounds(415, 100, 285, 337);
		listDiaThue.setModel(defaultListModelDiaThue);
		
		JScrollPane scrolllistDiaThue = new JScrollPane();
		scrolllistDiaThue.setViewportView(listDiaThue);
		scrolllistDiaThue.setBounds(415, 100, 285, 337);
		contentPane.add(scrolllistDiaThue);

//		cbLoaiDia = new JComboBox();
//		cbLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		cbLoaiDia.setModel(defaultComboBoxModel);
//		cbLoaiDia.setBounds(125, 53, 141, 36);
//		contentPane.add(cbLoaiDia);

//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setViewportView(listDia);
//		scrollPane.setPreferredSize(new Dimension(0,350));
//		scrollPane.setBounds(10, 100, 300, 350);
//	    contentPane.add(scrollPane, BorderLayout.CENTER);

		lblchonLoaiDia = new JLabel("Chọn loại đĩa:");
		lblchonLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblchonLoaiDia.setBounds(10, 53, 115, 36);
		contentPane.add(lblchonLoaiDia);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 102, 204));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(313, 169, 88, 36);
		contentPane.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(0, 102, 204));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(313, 233, 88, 36);
		contentPane.add(btnXoa);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien.setBounds(446, 447, 88, 36);
		contentPane.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setForeground(Color.RED);
		txtTongTien.setBounds(544, 448, 156, 36);
		contentPane.add(txtTongTien);
		txtTongTien.setColumns(10);
		txtTongTien.setText("0");

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBackground(new Color(0, 102, 204));
		btnLapHoaDon.setForeground(new Color(255, 255, 255));
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLapHoaDon.setBounds(355, 495, 355, 50);
		contentPane.add(btnLapHoaDon);

		btnDong = new JButton("Đóng");
		btnDong.setForeground(Color.WHITE);
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDong.setBackground(Color.RED);
		btnDong.setBounds(0, 495, 355, 50);
		contentPane.add(btnDong);

//		JRootPane rootPane = SwingUtilities.getRootPane(this);
//		rootPane.setDefaultButton(btnLapHoaDon);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTim.setBounds(125, 448, 97, 36);
		contentPane.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 102, 204));
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(232, 447, 61, 36);
		contentPane.add(btnTim);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(0, 102, 204));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBounds(303, 448, 112, 36);
		contentPane.add(btnLamMoi);

		JLabel lblNhpId = new JLabel("Nhập mã đĩa:");
		lblNhpId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpId.setBounds(13, 445, 112, 38);
		contentPane.add(lblNhpId);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLapHoaDon.addActionListener(this);
		btnDong.addActionListener(this);
//		cbLoaiDia.addActionListener(this);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);

		
		defaultListModelDiaThue.removeAllElements();
//		cbLoaiDia.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				defaultListModel.removeAllElements();
////				loadDataToListDia();
//			}
//		});
		loadDataToComboBoxLoaiDia();
		loadDataToListDia();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		List<String> listDaChon = listDia.getSelectedValuesList();
		if (obj.equals(btnThem)) {

//			List<String> listDaThue = 
//			System.out.println(listDaThue);
//			for (String string : listDiaThue) {
//			}
			if (listDaChon == null || listDaChon.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đĩa để thêm !", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				for (String string : listDaChon) {
//					for (String isExisted : listIsExisted) {
//						if (isExisted.equals(string)) {
					defaultListModelDiaThue.addElement(string);
					defaultListModel.removeElement(string);
//							listIsExisted.add(string);
//						} else {
//							JOptionPane.showMessageDialog(this, "Đĩa " + isExisted + " đã được thêm !", "Lỗi !",
//									JOptionPane.ERROR_MESSAGE);
//							break;
//						}
//					}
				}

//				for (String string : listDaChon) {
//					System.out.println("them" + string);
//				}
				capNhatTongTien();

			}

		} else if (obj.equals(btnXoa)) {
			List<String> listDaThue = listDiaThue.getSelectedValuesList();
			if (listDaThue == null || listDaThue.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đĩa để xóa !", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				for (String string : listDaThue) {
					defaultListModel.addElement(string);
					defaultListModelDiaThue.removeElement(string);
				}
//				for (String string : listDaChon) {
//					System.out.println("xoa " + string);
//				}
				capNhatTongTien();
			}

		} else if (obj.equals(btnDong)) {
			ChoThueDialogFrame.this.dispose();
			mainForm.setEnabled(true);
			
			defaultListModel.removeAllElements();
			defaultListModelDiaThue.removeAllElements();
			loadDataToListDia();
			txtTongTien.setText(formatTien.format(0));
			txtTim.setText("");
		} else if (obj.equals(btnLapHoaDon)) {
			mainForm.setEnabled(true);
			int size = defaultListModelDiaThue.getSize();
			System.out.println("size=" + size);
			if (size == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đĩa để lập hóa đơn !", "Lỗi !",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					KhachHang kh = new KhachHang();
					kh = quanLyChoThueDao.layThongTinKhachHang(quanLyChoThueFrame.layIDKH.getiDKH());
					HoaDon hoaDon = new HoaDon(LocalDate.now(), kh);
					hoaDonDao.themHoaDon(hoaDon);
					int thoiGianThue;
					for (int i = 0; i < size; i++) {
						String idStr = defaultListModelDiaThue.get(i);
						int end = idStr.indexOf("]");
						String id = idStr.substring(1, end);
						long iDDVD = Long.parseLong(id);
						DVD dvd = new DVD();
						dvd = choThueDialogDao.getDVDById(iDDVD);
						if (dvd.getTieuDeDVD().getLoaiDVD().getTenLoai().equals("Game"))
							thoiGianThue = 20;
						else
							thoiGianThue = 10;
						CTHD cthd = new CTHD(hoaDon, dvd, thoiGianThue);
						hoaDonDao.themCTHD(cthd);
						dvd.setTrangThai(1);
						dvdDao.updateDVD(dvd);
					}
					JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công !", "Thông báo !",
							JOptionPane.INFORMATION_MESSAGE);
					defaultListModel.removeAllElements();
					defaultListModelDiaThue.removeAllElements();
					loadDataToListDia();
					txtTongTien.setText(formatTien.format(0));
					ChoThueDialogFrame.this.dispose();
					mainForm.setEnabled(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại !", "Thông báo !",
							JOptionPane.INFORMATION_MESSAGE);
					e2.printStackTrace();
				}
			}

		} else if (obj.equals(btnTim)) {
			if (txtTim.getText().trim().equals("") || txtTim.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã DVD !", "Lỗi !", JOptionPane.ERROR_MESSAGE);
				txtTim.selectAll();
				txtTim.requestFocus();
			} else {
				try {
					long id = Long.parseLong(txtTim.getText().trim());
					DVD dvd = choThueDialogDao.getDVDById(id);

					int size = defaultListModelDiaThue.getSize();
					if (dvd.getTrangThai() == 0) {
						if (size > 0) {
							for (int i = 0; i < size; i++) {
								String idStr = defaultListModelDiaThue.get(i);
								int end = idStr.indexOf("]");
								String ids = idStr.substring(1, end);
								long iDDVD = Long.parseLong(ids);

								for (int j = 0; j < size; j++) {
									if (dvd.getiDDVD() != iDDVD) {
										defaultListModel.removeAllElements();
										defaultListModel.addElement(
												"[" + dvd.getiDDVD() + "]" + " " + dvd.getTieuDeDVD().getTenTieuDe());
										txtTim.selectAll();
										txtTim.requestFocus();
										break;
									} else if (dvd.getiDDVD() == iDDVD) {
										defaultListModel.removeAllElements();
										JOptionPane.showMessageDialog(this, "Đĩa này đã được thêm !", "Thông báo !",
												JOptionPane.ERROR_MESSAGE);
										txtTim.selectAll();
										txtTim.requestFocus();
										break;
									}
								}

							}
						} else {
							defaultListModel.removeAllElements();
							defaultListModel
									.addElement("[" + dvd.getiDDVD() + "]" + " " + dvd.getTieuDeDVD().getTenTieuDe());
							txtTim.selectAll();
							txtTim.requestFocus();
						}

					} else if (dvd.getTrangThai() != 0) {
						JOptionPane.showMessageDialog(this, "Đĩa này hiện đang cho thuê !\n Vui lòng quay lại sau !",
								"Thông báo !", JOptionPane.ERROR_MESSAGE);
						txtTim.selectAll();
						txtTim.requestFocus();
					} else {
						JOptionPane.showMessageDialog(this, "Lỗi !", "Thông báo !", JOptionPane.ERROR_MESSAGE);
						txtTim.selectAll();
						txtTim.requestFocus();
					}

//					if (dvd.getTrangThai() == 0) {
//						defaultListModel.removeAllElements();
//						defaultListModel
//								.addElement("[" + dvd.getiDDVD() + "]" + " " + dvd.getTieuDeDVD().getTenTieuDe());
//					} else {
//						JOptionPane.showMessageDialog(this, "Đĩa này hiện đang cho thuê !\n Vui lòng quay lại sau !",
//								"Thông báo !", JOptionPane.ERROR_MESSAGE);
//						txtTim.selectAll();
//						txtTim.requestFocus();
//					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Mã DVD là số nguyên !", "Lỗi !", JOptionPane.ERROR_MESSAGE);
					txtTim.selectAll();
					txtTim.requestFocus();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Không tồn tại DVD có mã " + txtTim.getText().trim() + " !",
							"Lỗi !", JOptionPane.ERROR_MESSAGE);
					txtTim.selectAll();
					txtTim.requestFocus();
				}
			}
		} else if (obj.equals(btnLamMoi)) {
//			int size = defaultListModelDiaThue.getSize();
//			String str;
//			List<String> list = new ArrayList<String>();
//			for (int i = 0; i < size; i++) {
//				str = defaultListModel.get(i);
//				list.add(str);
//			}
//			defaultListModel.removeAllElements();
//			for (String string : list) {
//				defaultListModel.addElement(string);
//			}

			defaultListModel.removeAllElements();
			defaultListModelDiaThue.removeAllElements();
			loadDataToListDia();
			txtTim.setText("");
		}
	}
	
	private void loadDataToComboBoxLoaiDia() {
		try {
			List<String> dsDia = new ArrayList<>();
			dsDia = choThueDialogDao.getAllLoaiDia();
			for (String string : dsDia) {
				defaultComboBoxModel.addElement(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void loadDataToListDia() {
//		String loaiDiaDuocChon = cbLoaiDia.getSelectedItem().toString();
		List<DVD> dvds = new ArrayList<DVD>();
		dvds = choThueDialogDao.getDVDsByTrangThaiSanSangChoThue();
		for (DVD dvd : dvds) {
//			if (loaiDiaDuocChon.equals(dvd.getTieuDeDVD().getLoaiDVD().getTenLoai())) {
				defaultListModel.addElement("[" + dvd.getiDDVD() + "]" + " " + dvd.getTieuDeDVD().getTenTieuDe()+" ["+dvd.getTieuDeDVD().getLoaiDVD().getTenLoai()+"]");
//			}
		}
		dvds = null;
	}

	private double capNhatTongTien() {
		double tongTien = 0;
		int size = defaultListModelDiaThue.getSize();
		for (int i = 0; i < size; i++) {
			String idStr = defaultListModelDiaThue.get(i);
			int end = idStr.indexOf("]");
			String id = idStr.substring(1, end);
			long iDDVD = Long.parseLong(id);
			DVD dvd = new DVD();
			dvd = choThueDialogDao.getDVDById(iDDVD);
			tongTien = tongTien + dvd.getTieuDeDVD().getLoaiDVD().getGiaThue();
		}
		txtTongTien.setText(String.valueOf(formatTien.format(tongTien)));
		return tongTien;
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
}
