package guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import daos.KhachHangDao;
import daos.PhieuGhiNhanThanhToanDao;
import entities.KhachHang;
import entities.PhieuGhiNhanThanhToanPhiTreHan;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ThanhToanFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JButton btnDong,btnThanhToan;
	private static ChoThueDialogFrame choThueDialogFrame = new ChoThueDialogFrame();
	private static PhieuGhiNhanThanhToanDao phieuGhiNhanThanhToanDao = new PhieuGhiNhanThanhToanDao();
	private static KhachHangDao khachHangDAO = new KhachHangDao();
	private JTextField txtTraTruoc;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtSoDuNo;
	public static String id_KH;
	private JTextField txtMa;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThanhToanFrame frame = new ThanhToanFrame();
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
	public ThanhToanFrame() {
		setBounds(100, 100, 450, 400);
		setTitle("Thông báo\r\n");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 50, 418, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTen = new JLabel("Tên khách hàng:");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTen.setBounds(10, 81, 130, 30);
		panel.add(lblTen);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSDT.setBounds(10, 121, 130, 30);
		panel.add(lblSDT);
		
		JLabel lblSoDu = new JLabel("Số dư nợ:");
		lblSoDu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDu.setBounds(10, 161, 130, 30);
		panel.add(lblSoDu);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTen.setEnabled(false);
		
		txtTen.setBounds(150, 82, 258, 30);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setEnabled(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 122, 258, 30);
		panel.add(txtSDT);
		
		txtSoDuNo = new JTextField();
		txtSoDuNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoDuNo.setEnabled(false);
		txtSoDuNo.setColumns(10);
		txtSoDuNo.setBounds(150, 162, 258, 30);
		panel.add(txtSoDuNo);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMa.setEnabled(false);
		txtMa.setColumns(10);
		txtMa.setBounds(150, 42, 258, 30);
		panel.add(txtMa);
		
		JLabel lblMa = new JLabel("Mã khách hàng:");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMa.setBounds(10, 41, 130, 30);
		panel.add(lblMa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u1EADp s\u1ED1 ti\u1EC1n c\u1EA7n thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 264, 418, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtTraTruoc = new JTextField();
		txtTraTruoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTraTruoc.setBounds(10, 19, 223, 30);
		panel_1.add(txtTraTruoc);
		txtTraTruoc.setColumns(10);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(Color.BLUE);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBounds(243, 19, 149, 30);
		panel_1.add(btnThanhToan);
		
		btnDong = new JButton("Bỏ qua");
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(Color.RED);
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDong.setBounds(254, 327, 103, 30);
		contentPane.add(btnDong);
		
		JLabel lblThongBao = new JLabel("KHÁCH HÀNG CÓ ĐANG PHÍ TRỄ HẠN");
		lblThongBao.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongBao.setBounds(10, 10, 418, 30);
		contentPane.add(lblThongBao);
		
		JLabel lblTiepTuc = new JLabel("Nhấn vào đây để bỏ qua và tiếp tục  →");
		lblTiepTuc.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblTiepTuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiepTuc.setBounds(10, 331, 240, 24);
		contentPane.add(lblTiepTuc);
		
		btnDong.addActionListener(this);
		btnThanhToan.addActionListener(this);
		
	
	}
	public void hienThiKhachHang(KhachHang kh) {
		txtMa.setText(String.valueOf(kh.getiDKH()));
		txtTen.setText(kh.getTen());
		txtSDT.setText(kh.getSdt());
		txtSoDuNo.setText(String.valueOf(kh.getphiTreHan()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object.equals(btnDong)) {
			ThanhToanFrame.this.dispose();
			choThueDialogFrame.setLocationRelativeTo(null);
			choThueDialogFrame.setVisible(true);	
			choThueDialogFrame.defaultListModel.removeAllElements();
			choThueDialogFrame.loadDataToListDia();
		}
		if(object.equals(btnThanhToan)) {
			KhachHang kh = khachHangDAO.getKhbyId(Long.parseLong(txtMa.getText()));
			PhieuGhiNhanThanhToanPhiTreHan phieu = new PhieuGhiNhanThanhToanPhiTreHan(kh,LocalDateTime.now(),
					Float.parseFloat(txtSoDuNo.getText()),Float.parseFloat(txtTraTruoc.getText()));
			phieuGhiNhanThanhToanDao.themPhieuGhiNhanThanhToan(phieu);				
			kh.setphiTreHan(Float.parseFloat(txtSoDuNo.getText())-Float.parseFloat(txtTraTruoc.getText()));								
			try {
				khachHangDAO.capnhatKhachHang(kh);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			JOptionPane.showMessageDialog(null, "Thanh toán thành công, tiếp tục thuê đĩa!");
			setRongTextfield();
			ThanhToanFrame.this.dispose();			
			choThueDialogFrame.setLocationRelativeTo(null);
			choThueDialogFrame.setVisible(true);
			
			choThueDialogFrame.defaultListModel.removeAllElements();
			choThueDialogFrame.loadDataToListDia();
		}
	}
	public void setRongTextfield() {
		txtMa.setText("");
		txtSDT.setText("");
		txtSoDuNo.setText("");
		txtTen.setText("");
		txtTraTruoc.setText("");
	}
}
