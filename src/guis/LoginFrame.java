package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import daos.TaiKhoanDao;
import entities.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginFrame extends JFrame implements ActionListener{

	public static JPanel contentPane;
	private JTextField txtMK;
	private JTextField txtTenDN;
	private JButton btnDangNhap;
	private TaiKhoanDao taiKhoanDAO = new TaiKhoanDao();
	private static MainForm mainForm = new MainForm();
	private static ThanhToanPhiTraChamFrame thanhToanPhiTraChamFrame = new ThanhToanPhiTraChamFrame();
	private static BaoCaoDVDFrame baoCaoDVDFrame = new BaoCaoDVDFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 210);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblDangNhap = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDangNhap.setBounds(87, 10, 110, 30);
		contentPane.add(lblDangNhap);
		
		JLabel lblTenDN = new JLabel("Tài khoản:");
		lblTenDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenDN.setBounds(10, 54, 67, 16);
		contentPane.add(lblTenDN);
		
		JLabel lblMK = new JLabel("Mật khẩu:");
		lblMK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMK.setBounds(10, 94, 67, 19);
		contentPane.add(lblMK);
		
		txtMK = new JPasswordField();
		txtMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMK.setBounds(87, 92, 174, 22);
		contentPane.add(txtMK);
		txtMK.setColumns(10);
		
		txtTenDN = new JTextField();
		txtTenDN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDN.setBounds(87, 51, 174, 22);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		btnDangNhap.setBounds(87, 124, 110, 30);
		contentPane.add(btnDangNhap);
		
		btnDangNhap.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(btnDangNhap)) {			
			String tenDN = txtTenDN.getText().trim();
			String mk = txtMK.getText().trim();				
			if(txtTenDN.getText().equals("")||txtMK.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin !");
			}else {
				try {
					TaiKhoan tk = taiKhoanDAO.kiemTra(tenDN);
					if(tk.getMatKhau().equals(mk)) {
						mainForm.hienThiTenDangNhap(tk);
						setButtonKhiDangNhap();
						LoginFrame.this.dispose();
					}else {				
						JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác !");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác !");
				}
					
			}
					
		}						
	}
	public void setButtonKhiDangNhap() {	
		mainForm.btnQuanLBangDia.setEnabled(true);
		thanhToanPhiTraChamFrame.btnHuyPhi.setEnabled(true);
		baoCaoDVDFrame.tabbedPane.setEnabledAt(2,true);
		baoCaoDVDFrame.tabbedPane.setEnabledAt(3,true);
		baoCaoDVDFrame.tabbedPane.setEnabledAt(4,true);
		mainForm.btnDangXuat.setEnabled(true);
		mainForm.btnDangNhap.setEnabled(false);
	}
}
