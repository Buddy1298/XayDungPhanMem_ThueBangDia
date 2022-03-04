package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.TaiKhoan;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class MainForm extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	public static JTextField textField, txtTen;
	private JPanel panelMenu;
	public static JButton btnTrangChu, btnDangNhap, btnDangXuat;
	public static JButton btnQuanLyChoThue;
	public static JButton btnQuanLBangDia;
	public static JButton btnQuanLyKhachHang;
	public static JButton btnBaoCaoDVDvaTieuDe;
	public static JButton btnDatTruocTieuDeDVD, btnThanhToan;
	private JPanel panelHeader;
	private JPanel panelContent;
	private static JTabbedPane tabbedPane;

	private  QuanLyChoThueFrame quanLyChoThue = new QuanLyChoThueFrame();
	public static LoginFrame loginFrame = new LoginFrame();
	private  BaoCaoDVDFrame baoCaoDVDFrame = new BaoCaoDVDFrame();
	private  QuanLiKhachHangFrame quanLiKhachHangFrame = new QuanLiKhachHangFrame();
	private ThanhToanPhiTraChamFrame thanhToanPhiTraChamFrame = new ThanhToanPhiTraChamFrame();
	private QuanLyDVDFrame quanLyDVDFrame=new QuanLyDVDFrame();
	private QuanLyDatTruocFrame quanLyDatTruocFrame=new QuanLyDatTruocFrame();
	private JLabel lblTenUngDung;
	private JLabel lblNewLabel = new JLabel("");

//	private  QuanLiKhachHangFrame quanLiKhachHangFrame = new QuanLiKhachHangFrame();



	/**
	 * Launch the application.y
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1379, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(204, 0, 0));
		panelMenu.setBorder(null);
		panelMenu.setBounds(0, 97, 256, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		setResizable(false);

		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTrangChu.setBackground(new java.awt.Color(145, 102, 72));
		btnTrangChu.setBounds(0, 0, 256, 99);
		panelMenu.add(btnTrangChu);

		btnQuanLyChoThue = new JButton("Quản lý cho thuê");
		btnQuanLyChoThue.setForeground(Color.WHITE);
		btnQuanLyChoThue.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyChoThue.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyChoThue.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLyChoThue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuanLyChoThue.setBounds(0, 94, 256, 87);
		panelMenu.add(btnQuanLyChoThue);

		btnQuanLBangDia = new JButton("Quản lý băng đĩa");
		btnQuanLBangDia.setEnabled(false);
		btnQuanLBangDia.setForeground(Color.WHITE);
		btnQuanLBangDia.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLBangDia.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLBangDia.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLBangDia.setBounds(0, 175, 256, 93);
		panelMenu.add(btnQuanLBangDia);

		btnQuanLyKhachHang = new JButton("Quản lý khách hàng");
		btnQuanLyKhachHang.setForeground(Color.WHITE);
		btnQuanLyKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyKhachHang.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLyKhachHang.setBounds(0, 266, 256, 87);
		panelMenu.add(btnQuanLyKhachHang);

		btnBaoCaoDVDvaTieuDe = new JButton("Thống kê báo cáo");
		btnBaoCaoDVDvaTieuDe.setForeground(Color.WHITE);
		btnBaoCaoDVDvaTieuDe.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoCaoDVDvaTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBaoCaoDVDvaTieuDe.setBackground(new java.awt.Color(145, 102, 72));
		btnBaoCaoDVDvaTieuDe.setBounds(0, 351, 256, 87);
		panelMenu.add(btnBaoCaoDVDvaTieuDe);

		btnDatTruocTieuDeDVD = new JButton("Đặt trước tiêu đề");
		btnDatTruocTieuDeDVD.setForeground(Color.WHITE);
		btnDatTruocTieuDeDVD.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatTruocTieuDeDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatTruocTieuDeDVD.setBackground(new java.awt.Color(145, 102, 72));
		btnDatTruocTieuDeDVD.setBounds(0, 438, 256, 87);
		panelMenu.add(btnDatTruocTieuDeDVD);
		
		btnThanhToan = new JButton("Thanh toán phí trễ hạn");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(145, 102, 72));
		btnThanhToan.setBounds(0, 522, 256, 87);
		panelMenu.add(btnThanhToan);

		panelHeader = new JPanel();
		panelHeader.setBackground(new java.awt.Color(145, 102, 72));
		panelHeader.setBounds(0, 0, 1382, 97);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		lblTenUngDung = new JLabel("ỨNG DỤNG QUẢN LÍ THUÊ TRẢ ĐĨA");
		lblTenUngDung.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTenUngDung.setForeground(Color.WHITE);
		lblTenUngDung.setBounds(498, 24, 520, 43);
		panelHeader.add(lblTenUngDung);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangNhap.setBackground(Color.BLUE);
		btnDangNhap.setBounds(12, 13, 119, 25);
		panelHeader.add(btnDangNhap);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setEnabled(false);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setBackground(Color.RED);
		btnDangXuat.setBounds(12, 51, 119, 25);
		panelHeader.add(btnDangXuat);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTen.setEnabled(false);
		txtTen.setBounds(139, 13, 111, 25);
		panelHeader.add(txtTen);
		txtTen.setColumns(10);

		panelContent = new JPanel();
		panelContent.setBackground(SystemColor.control);
		panelContent.setBounds(255, 97, 1115, 610);
		contentPane.add(panelContent);
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		panelContent.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new java.awt.Color(244, 204, 153));
		tabbedPane.setBounds(0, -23, 1127, 620);
		panelContent.add(tabbedPane);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setIcon(new ImageIcon("./resource/images/de-1-0128.png"));
		lblNewLabel.setBounds(372, 111, 480, 402);
		tabbedPane.add(lblNewLabel);
		
	

		btnTrangChu.addActionListener(this);
		btnDatTruocTieuDeDVD.addActionListener(this);
		btnQuanLBangDia.addActionListener(this);
		btnQuanLyChoThue.addActionListener(this);
		btnBaoCaoDVDvaTieuDe.addActionListener(this);
		btnQuanLyKhachHang.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnDangNhap.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
		
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
	public void hienThiTenDangNhap(TaiKhoan tk) {
		txtTen.setText(tk.getTaiKhoan().toString());
		System.out.println(txtTen.getText());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnQuanLyChoThue)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyChoThue.panel);
		}
		else if(obj.equals(btnTrangChu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			
			lblNewLabel.setIcon(new ImageIcon(MainForm.class.getResource("/images/de-1-0128.png")));
			lblNewLabel.setBounds(372, 111, 480, 402);
			tabbedPane.add(lblNewLabel);
			panelContent.setVisible(true);
		
		}
		else if(obj.equals(btnQuanLBangDia)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyDVDFrame.contentPane);
		
		}
		else if(obj.equals(btnQuanLyKhachHang)) {
			if(txtTen.getText().equalsIgnoreCase("")){
				quanLiKhachHangFrame.btnXoaKhachHang.setEnabled(false);
			} else {
				quanLiKhachHangFrame.btnXoaKhachHang.setEnabled(true);
				
			}
			
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLiKhachHangFrame.contentPane);
		
		}
		else if(obj.equals(btnBaoCaoDVDvaTieuDe)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(baoCaoDVDFrame.contentPane);
			
			int rows1 = baoCaoDVDFrame.tablemodelDVDSanSangChoThue.getRowCount();
			if(rows1>0) {
				for (int i = rows1 - 1; i >= 0; i--) {
					baoCaoDVDFrame.tablemodelDVDSanSangChoThue.removeRow(i);
			}
			}
			baoCaoDVDFrame.updateTableDataSanSangChoThue();
			int rows = baoCaoDVDFrame.tablemodelDVDDangThue.getRowCount();
			if(rows>0) {
				for (int i = rows - 1; i >= 0; i--) {
					baoCaoDVDFrame.tablemodelDVDDangThue.removeRow(i);
				}
			}
			baoCaoDVDFrame.updateTableDataDangThue();
			//cap nhat lai table tieudeDVD
			int rowtablemodelTieuDeDVD = baoCaoDVDFrame.tablemodelTieuDeDVD.getRowCount();
			if(rowtablemodelTieuDeDVD>0) {
				for (int i = rowtablemodelTieuDeDVD - 1; i >= 0; i--) {
					baoCaoDVDFrame.tablemodelDVDDangThue.removeRow(i);
				}
			}
			baoCaoDVDFrame.updateTablemodelTieuDeDVD();
			
			baoCaoDVDFrame.updateTablemodelTieuDeDangDat();
		
		}
		else if(obj.equals(btnDatTruocTieuDeDVD)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyDatTruocFrame.contentPane);
		
		}else if(obj.equals(btnThanhToan)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(thanhToanPhiTraChamFrame.contentPane);		
		}
		else if(obj.equals(btnDangNhap)) {
			loginFrame.setLocationRelativeTo(null);
			loginFrame.setVisible(true);
		}
		else if(obj.equals(btnDangXuat)) {
			int n = JOptionPane.showConfirmDialog(this, "Đồng ý đăng xuất khỏi hệ thống ?","XÁC NHẬN",JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Đã đăng xuất khỏi hệ thống !","THÔNG BÁO",JOptionPane.INFORMATION_MESSAGE);
				txtTen.setText("");	
				btnQuanLBangDia.setEnabled(false);
				thanhToanPhiTraChamFrame.btnHuyPhi.setEnabled(false);
				baoCaoDVDFrame.tabbedPane.setEnabledAt(2,false);
				baoCaoDVDFrame.tabbedPane.setEnabledAt(3,false);
				baoCaoDVDFrame.tabbedPane.setEnabledAt(4,false);
				btnDangNhap.setEnabled(true);
				btnDangXuat.setEnabled(false);
			}
		}
	}

}
