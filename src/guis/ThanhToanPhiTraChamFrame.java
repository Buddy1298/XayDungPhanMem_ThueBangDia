package guis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import daos.KhachHangDao;
import daos.PhieuGhiNhanThanhToanDao;
import entities.KhachHang;
import entities.PhieuGhiNhanThanhToanPhiTreHan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

public class ThanhToanPhiTraChamFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;

	private KhachHangDao khachHangDAO = new KhachHangDao();
	private PhieuGhiNhanThanhToanDao phieuGhiNhanThanhToanDao = new PhieuGhiNhanThanhToanDao();
	private static MainForm mainForm = new MainForm();
	private JTextField txtTimKiem;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtSoDuNo;
	private JTextField txtSoTraTruoc;
	public static JButton btnTim,btnThanhToan,btnXem,btnHuyPhi;
	private JTable table;
	private DefaultTableModel dataModel;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToanPhiTraChamFrame frame = new ThanhToanPhiTraChamFrame();
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
	public ThanhToanPhiTraChamFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTieuDeThanhToanFrame = new JLabel("THANH TOÁN PHÍ TRẢ TRỄ HẠN");
		lblTieuDeThanhToanFrame.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTieuDeThanhToanFrame.setBounds(339, 10, 414, 35);
		contentPane.add(lblTieuDeThanhToanFrame);
		
		JLabel lblTimKiem = new JLabel("Nhập mã khách hàng:");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiem.setBounds(10, 58, 186, 24);
		contentPane.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(190, 55, 209, 30);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(SystemColor.textHighlight);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTim.setBounds(190, 92, 85, 30);
		contentPane.add(btnTim);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 127, 389, 328);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSoDuNo = new JLabel("Số dư nợ:");
		lblSoDuNo.setBounds(10, 233, 82, 30);
		panel.add(lblSoDuNo);
		lblSoDuNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(10, 185, 63, 30);
		panel.add(lblDiaChi);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(10, 136, 106, 30);
		panel.add(lblSDT);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setBounds(10, 86, 117, 30);
		panel.add(lblTenKH);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setBounds(122, 87, 258, 30);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setText("");
		txtSDT.setBounds(122, 137, 258, 30);
		panel.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setText("");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(122, 186, 258, 30);
		panel.add(txtDiaChi);
		
		txtSoDuNo = new JTextField();
		txtSoDuNo.setEditable(false);
		txtSoDuNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoDuNo.setText("");
		txtSoDuNo.setColumns(10);
		txtSoDuNo.setBounds(122, 234, 155, 30);
		panel.add(txtSoDuNo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thanh to\u00E1n ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 465, 389, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSoTraTruoc = new JLabel("Nhập số tiền trả:");
		lblSoTraTruoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoTraTruoc.setBounds(10, 10, 129, 30);
		panel_1.add(lblSoTraTruoc);
		
		txtSoTraTruoc = new JTextField();
		txtSoTraTruoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoTraTruoc.setBounds(121, 10, 258, 30);
		panel_1.add(txtSoTraTruoc);
		txtSoTraTruoc.setColumns(10);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBackground(SystemColor.textHighlight);
		btnThanhToan.setBounds(121, 50, 156, 30);
		panel_1.add(btnThanhToan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "L\u1ECBch s\u1EED thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(409, 127, 686, 426);
		
		String[] colname = "Tên khách hàng;Ngày thanh toán;Tổng dư nợ;Đã trả;Còn lại".split(";");
		dataModel  = new DefaultTableModel(colname, 0);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("Mã khách hàng:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(10, 43, 117, 30);
		panel.add(lblID);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(122, 44, 258, 30);
		panel.add(txtID);
		
		btnHuyPhi = new JButton("Hủy phí trễ hạn");
		btnHuyPhi.setEnabled(false);
		btnHuyPhi.setForeground(Color.WHITE);
		btnHuyPhi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuyPhi.setBackground(Color.RED);
		btnHuyPhi.setBounds(123, 274, 154, 30);
		panel.add(btnHuyPhi);
		table = new JTable(dataModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(20);
		
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(645, 380));
		scroll.setBounds(12, 13, 668, 279);
		
		panel_2.add(scroll);
		contentPane.add(panel_2);
		
		btnXem = new JButton("Xem lịch sử thanh toán");
		btnXem.setForeground(Color.WHITE);
		
		btnXem.setBackground(SystemColor.textHighlight);
		btnXem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXem.setBounds(409, 92, 215, 30);
		contentPane.add(btnXem);
		
		btnThanhToan.addActionListener(this);
		btnTim.addActionListener(this);
		btnXem.addActionListener(this);
		btnHuyPhi.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnThanhToan)) {
			if(txtID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng thanh toán !");
			}else if(txtSoTraTruoc.getText().toString().equals("")) {		
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền trả trước !");
			}else {
				float soDuNo = Float.parseFloat(txtSoDuNo.getText().toString());
				float soTraTruoc = Float.parseFloat(txtSoTraTruoc.getText().toString());
				float conlai = soDuNo - soTraTruoc;
				if(soDuNo<soTraTruoc || soTraTruoc<=0) { 
					JOptionPane.showMessageDialog(null, "Yêu cầu: 0 < Số tiền trả trước < Số dự nợ !");
				}else {
					Long idKH = Long.parseLong(txtID.getText().toString());
					KhachHang kh = khachHangDAO.getKhbyId(idKH);
					
					PhieuGhiNhanThanhToanPhiTreHan phieu = new PhieuGhiNhanThanhToanPhiTreHan(kh,LocalDateTime.now(),soDuNo,soTraTruoc);
					phieuGhiNhanThanhToanDao.themPhieuGhiNhanThanhToan(phieu);
					JOptionPane.showMessageDialog(null, "Khách hàng đã trả: "+soTraTruoc+", số dư nợ còn lại là: "+conlai);
					txtSoTraTruoc.setText("");
					txtSoDuNo.setText(conlai+"");
					
					kh.setphiTreHan(conlai);
					try {
						khachHangDAO.capnhatKhachHang(kh);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						txtSoTraTruoc.setText("");
					}	
					updateTable();
				}		
			}
			
		} 
		if(obj.equals(btnXem)) {
			if(txtID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để xem lịch sử thanh toán phí trễ hạn !");
			}else {
				try {
					xoaDuLieuTrenTable();
					loadToanBoDuLieu();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Khách hàng này chưa có lịch sử ghi nợ");
				}
									
			}
		}
		if(obj.equals(btnTim)) {
			if(txtTimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nhập mã khách hàng cần tìm !");
			}else {
				Long idKH = Long.parseLong(txtTimKiem.getText().toString());
				try {
					KhachHang kh = khachHangDAO.getKhbyId(idKH);
					txtID.setText(String.valueOf(kh.getiDKH()));
					txtTen.setText(kh.getTen());
					txtSDT.setText(kh.getSdt());
					txtDiaChi.setText(kh.getDiaChi());
					txtSoDuNo.setText(String.valueOf(kh.getphiTreHan()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Khách hàng này không có !");
				}		
			}	
		}
		if(obj.equals(btnHuyPhi)) {
			
			if(txtID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Chọn khách hàng muốn hủy phí trễ hạn !");
			}else {
				int n = JOptionPane.showConfirmDialog(null, "Hủy phí sẽ xóa lịch sử thanh toán của khách hàng?","XÁC NHẬN",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					float soDu = 0;
					txtSoDuNo.setText(soDu+"");
					long idKH = Long.parseLong(txtID.getText());
					KhachHang kh = khachHangDAO.getKhbyId(idKH);
					kh.setphiTreHan(0);
					try {
						khachHangDAO.capnhatKhachHang(kh);
						phieuGhiNhanThanhToanDao.xoaLichSuThanhToan(idKH);
						dataModel.setRowCount(0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
	}
	public void xoaDuLieuTrenTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public void loadToanBoDuLieu() {
		Long idKH = Long.parseLong(txtID.getText().toString());
		KhachHang kh = khachHangDAO.getKhbyId(idKH);
		String ten;
		String str="";
		List<PhieuGhiNhanThanhToanPhiTreHan> list = phieuGhiNhanThanhToanDao.getDSPhieuGhiNhan(kh.getiDKH());
		if(list.size()==0) {
			JOptionPane.showMessageDialog(this, "Khách hàng này không có lịch sử thanh toán !");
			xoaDuLieuTrenTable();
		}else {
			for(PhieuGhiNhanThanhToanPhiTreHan phieu : list) {
				ten = phieu.getKhachHang().getTen();
			
				LocalDateTime ngay = phieu.getNgayThanhToan();
			    Date date2 = Date.from(ngay.atZone(ZoneId.systemDefault()).toInstant());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dateFormat = formatter.format(date2);
				
				float soTra= phieu.getSoTienTra();
				float tong = phieu.getSoDuNo();     
		        float noConLai = tong - soTra;
		        
		        String[] rowData = {ten,dateFormat,String.valueOf(tong),String.valueOf(soTra),String.valueOf(noConLai)};	
		        dataModel.addRow(rowData);
			}	
		}		
		table.setModel(dataModel);	
	}
	public void updateTable() {
		Long idKH = Long.parseLong(txtID.getText());
		KhachHang kh = khachHangDAO.getKhbyId(idKH);

		List<PhieuGhiNhanThanhToanPhiTreHan> phieu = phieuGhiNhanThanhToanDao.getPhieuGhiNhanMoiNhat(idKH);	
		String ten = phieu.get(0).getKhachHang().getTen();
		
		LocalDateTime ngay = phieu.get(0).getNgayThanhToan();
	    Date date2 = Date.from(ngay.atZone(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(date2);		
		
		float soTra = phieu.get(0).getSoTienTra();				
		String tongNo_str = txtSoDuNo.getText().toString();
		float tong=Float.parseFloat(tongNo_str)+soTra;		
		float noConLai = kh.getphiTreHan();
		
		String[] rowData = {ten,dateFormat,String.valueOf(tong),String.valueOf(soTra),String.valueOf(noConLai)};
		dataModel.addRow(rowData);
			
		table.setModel(dataModel);	
	}
}
