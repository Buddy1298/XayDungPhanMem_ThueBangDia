package guis;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daos.KhachHangDao;

public class MainFrame extends JFrame {
//	public static QuanLiKhachHangFrame quanLiKhachHangframe;
	public static BaoCaoDVDFrame baoCaoFrame;
	public static JPanel contentPane;
	public static MainFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangDao KhachHangDao = new KhachHangDao();
					frame = new MainFrame();
					frame.setLocationRelativeTo(null);
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/image/de-1-0128.png"));
		lblNewLabel.setBounds(372, 111, 480, 402);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Quản lí thuê trả đĩa");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new java.awt.Color(145, 102, 72));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(72, 136, 218, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quản lí khách hàng");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new java.awt.Color(145, 102, 72));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				quanLiKhachHangframe=new QuanLiKhachHangFrame();
//				quanLiKhachHangframe.setVisible(true);
//				quanLiKhachHangframe.setLocationRelativeTo(null);
//				quanLiKhachHangframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(72, 205, 218, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Báo cáo đĩa");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new java.awt.Color(145, 102, 72));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baoCaoFrame=new BaoCaoDVDFrame();
				baoCaoFrame.setVisible(true);
				baoCaoFrame.setLocationRelativeTo(null);
				baoCaoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(72, 275, 218, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Chức năng của quản lí");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(new java.awt.Color(145, 102, 72));
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe=new LoginFrame();
				loginframe.setVisible(true);
				loginframe.setLocationRelativeTo(null);
				loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
		});
		btnNewButton_3.setBounds(72, 341, 218, 41);
		
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("\u1EE8NG D\u1EE4NG QU\u1EA2N L\u00CD THU\u00CA TR\u1EA2 \u0110\u0128A");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(242, 29, 462, 69);
		contentPane.add(lblNewLabel_1);
	}

}
