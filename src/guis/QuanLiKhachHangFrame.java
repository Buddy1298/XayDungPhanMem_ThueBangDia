package guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import daos.KhachHangDao;
import entities.KhachHang;


public class QuanLiKhachHangFrame extends JFrame implements MouseListener{
	public static JPanel contentPane;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JTextField txtSDT;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JLabel lblThongbaoVeSdt;
	private KhachHangDao KhachHangDao=new KhachHangDao();
	public static JButton btnXoaKhachHang;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					QuanLiKhachHangFrame quanLiKhachHangframe = new QuanLiKhachHangFrame();
					quanLiKhachHangframe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLiKhachHangFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(312, 13, 789, 527);

		// table
		String[] colname = "Mã khách hàng;Họ tên;Địa chỉ;Số điện thoại".split(";");
		tablemodel = new DefaultTableModel(colname, 0);
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new java.awt.Color(244, 204, 153));
		table.setRowHeight(20);
	

		// scroll

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(645, 220));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
		scroll.setBounds(12, 13, 765, 504);
		
		panel.add(scroll);
		panel.setBackground(new java.awt.Color(145, 102, 72));
		contentPane.add(panel);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(12, 121, 116, 24);
		contentPane.add(lblSoDienThoai);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setBounds(138, 122, 162, 23);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblTen = new JLabel("Tên khách hàng:");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTen.setBounds(12, 184, 126, 19);
		contentPane.add(lblTen);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKH.setBounds(138, 182, 162, 22);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(12, 245, 56, 16);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBounds(138, 242, 162, 22);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JButton btnThemKhachHang = new JButton("Thêm mới");
		btnThemKhachHang.setForeground(Color.WHITE);
		btnThemKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemKhachHang.setBackground(Color.BLUE);
		btnThemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					if(txtSDT.getText().matches("^[0-9]*$")==true) {
					
					
					
					boolean trangThaiTonTaiSdt=false;
					// kiem tra sdt da ton tai chua
					for (KhachHang khachHang : KhachHangDao.getdsKhachHang()) {
						if(txtSDT.getText().equals(khachHang.getSdt())) {
							trangThaiTonTaiSdt=true;
							lblThongbaoVeSdt.setText("Số điện thoại đã tồn tại");
							
							
						}
						
					}
					// neu sdt chua co them khach hang moi
					if(trangThaiTonTaiSdt==false) {
							if(KhachHangDao.getdsKhachHang().size()-1>=0) {
								
								
								long idKh=KhachHangDao.getdsKhachHang().get(KhachHangDao.getdsKhachHang().size()-1).getiDKH();
								KhachHangDao.themKhachHang(new KhachHang(txtTenKH.getText(), txtDiaChi.getText(), txtSDT.getText()));
								int rows = tablemodel.getRowCount();
								if(rows>0) {
									for (int i = rows - 1; i >= 0; i--) {
										tablemodel.removeRow(i);
									}
								}
								lblThongbaoVeSdt.setText("");
								updateTableData();
								JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thành công"); 
							}
							if(KhachHangDao.getdsKhachHang().size()-1<0) {
								KhachHangDao.themKhachHang(new KhachHang(txtTenKH.getText(), txtDiaChi.getText(), txtSDT.getText()));
								long idKh=KhachHangDao.getdsKhachHang().get(0).getiDKH();
								int rows = tablemodel.getRowCount();
								if(rows>0) {
									for (int i = rows - 1; i >= 0; i--) {
										tablemodel.removeRow(i);
									}
								}
								lblThongbaoVeSdt.setText("");
								updateTableData();
								JOptionPane.showMessageDialog(contentPane, "Thêm khách hàng thành công"); 
							
							}
							
							
						
						
					}}else {
						JOptionPane.showMessageDialog(contentPane, "Số điện thoại chỉ nhập số"); 
					}
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnThemKhachHang.setBounds(41, 301, 236, 30);
		contentPane.add(btnThemKhachHang);
		
		JLabel lblQuanLyKH = new JLabel("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
		lblQuanLyKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuanLyKH.setBounds(12, 13, 290, 32);
		contentPane.add(lblQuanLyKH);
		
		JButton btnSua = new JButton("Sửa thông tin");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBackground(Color.BLUE);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			
				try {
					
					KhachHang khachHang = KhachHangDao.getKhbangSdt(txtSDT.getText());
					KhachHangDao.capnhatKhachHang(new KhachHang(khachHang.getiDKH(), txtTenKH.getText(),
							txtDiaChi.getText(), txtSDT.getText()));
					int rows = tablemodel.getRowCount();
					for (int i = rows - 1; i >= 0; i--) {
						tablemodel.removeRow(i);
					}
					
					updateTableData();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSua.setBounds(41, 337, 236, 30);
		contentPane.add(btnSua);
		Icon iconReload = new ImageIcon("./resource/images/reload.png");
		JButton btnTaiLai = new JButton(new ImageIcon(QuanLiKhachHangFrame.class.getResource("/images/reload.png")));
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenKH.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				lblThongbaoVeSdt.setText("");
				
			}
		});
		btnTaiLai.setBounds(268, 84, 30, 30);
		contentPane.add(btnTaiLai);
		
		lblThongbaoVeSdt = new JLabel("");
		lblThongbaoVeSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongbaoVeSdt.setForeground(Color.RED);
		lblThongbaoVeSdt.setBounds(116, 153, 184, 16);
		contentPane.add(lblThongbaoVeSdt);
		
		btnXoaKhachHang = new JButton("Xóa khách hàng");
		btnXoaKhachHang.setForeground(Color.WHITE);
		btnXoaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaKhachHang.setBackground(Color.RED);
		btnXoaKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rows = tablemodel.getRowCount();
					int row = table.getSelectedRow();
					
					long id=Long.valueOf(table.getValueAt(row, 0).toString());
					KhachHangDao.xoaKhachHang(id);
					for (int i = rows - 1; i >= 0; i--) {
						tablemodel.removeRow(i);
					}
					updateTableData();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "Khách hàng này không thể xóa"); 
				}
				
			}
		});
		btnXoaKhachHang.setBounds(41, 377, 236, 25);
		contentPane.add(btnXoaKhachHang);
		updateTableData();
		table.addMouseListener(this);
		
	}

	private void updateTableData() {
		 KhachHangDao KhachHangDao = new KhachHangDao();
		for (KhachHang kh : KhachHangDao.getdsKhachHang()) {
			String[] rowData = {String.valueOf(kh.getiDKH()),kh.getTen(),kh.getDiaChi(),kh.getSdt() + "" };
			tablemodel.addRow(rowData);
		}

		table.setModel(tablemodel);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtTenKH.setText(table.getValueAt(row, 1).toString());
		txtDiaChi.setText(table.getValueAt(row, 2).toString());
		txtSDT.setText(table.getValueAt(row, 3).toString());
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
