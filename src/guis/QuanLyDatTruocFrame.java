package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import daos.DVDDao;
import daos.KhachHangDao;
import daos.PhieuDatDao;
import daos.TieuDeDVDDao;
import entities.DVD;
import entities.KhachHang;
import entities.PhieuDatTruoc;
import entities.TieuDeDVD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class QuanLyDatTruocFrame extends JFrame implements MouseListener{

	public JPanel contentPane;
	private JTextField textMaKhachHang;
	private JTextField textTenKhachHang;
	private KhachHangDao khachHangDao = new KhachHangDao(); 
	private TieuDeDVDDao tieuDeDVDDao = new TieuDeDVDDao();
	private PhieuDatDao phieuDatDao = new PhieuDatDao();
	private DVDDao dvdDao=new DVDDao();
	private ArrayList<TieuDeDVD> dsTieuDe=null ;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTieuDe;
	private JTextField txtTenKH;
	private JTextField txtTenTieuDe;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JLabel lblThongbao;
	private JTextField txtNgay;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyDatTruocFrame frame = new QuanLyDatTruocFrame();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public QuanLyDatTruocFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1102, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		
		JLabel lblTieuDe = new JLabel("   ĐẶT TRƯỚC ĐĨA CHO MỘT TIÊU ĐỀ");
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblTieuDe.setBounds(0, 11, 1076, 33);
		contentPane.add(lblTieuDe);
		
		textMaKhachHang = new JTextField();
		textMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMaKhachHang.setBounds(143, 55, 325, 33);
		contentPane.add(textMaKhachHang);
		textMaKhachHang.setColumns(10);
		
		JButton btnNhap = new JButton("Tìm");
		btnNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNhap.setForeground(Color.WHITE);
		btnNhap.setBackground(Color.BLUE);
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKhachHang();
			}
		});
		btnNhap.setBounds(478, 55, 112, 33);
		contentPane.add(btnNhap);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 198, 1066, 335);
	
		//
		String[] colnamehuydattruoc = "Khách hàng;Tiêu Đề;Ngày lập phiếu;Trạng thái".split(";");
		tablemodel = new DefaultTableModel(colnamehuydattruoc, 0);
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new java.awt.Color(244, 204, 153));
		table.setRowHeight(20);	

		// scroll

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(645, 220));
		scroll.setBorder(new TitledBorder(null, "Danh s\u00E1ch phi\u1EBFu \u0111\u1EB7t tr\u01B0\u1EDBc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scroll.setBounds(439, 4, 617, 323);
		
		panel.add(scroll);
		panel.setBackground(new java.awt.Color(145, 102, 72));
		
		//			
		
		contentPane.add(panel);
		panel.setLayout(null);		
		
		JLabel lblNewLabel_4 = new JLabel("HỦY ĐẶT TRƯỚC CHO MỘT TIÊU ĐỀ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(12, 10, 356, 34);
		panel.add(lblNewLabel_4);
		
		JLabel lblKH = new JLabel("Tên khách hàng:");
		lblKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKH.setBounds(12, 84, 123, 24);
		panel.add(lblKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKH.setBounds(133, 80, 272, 31);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên tiêu đề:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(12, 137, 123, 23);
		panel.add(lblNewLabel_2_1);
		
		txtTenTieuDe = new JTextField();
		txtTenTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenTieuDe.setEnabled(false);
		txtTenTieuDe.setBounds(133, 133, 272, 31);
		panel.add(txtTenTieuDe);
		txtTenTieuDe.setColumns(10);
		
		JButton btnHuyDatTruoc = new JButton("Hủy đặt trước");
		btnHuyDatTruoc.setBackground(Color.RED);
		btnHuyDatTruoc.setForeground(Color.WHITE);
		btnHuyDatTruoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuyDatTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rows = tablemodel.getRowCount();
				int row = table.getSelectedRow();
				if(txtTenTieuDe.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null,"Chọn phiếu đặt trước muốn hủy.");
				} 
				else {	
					KhachHang kh = khachHangDao.getKhbyTen(txtTenKH.getText());
					TieuDeDVD tdDeDVD = tieuDeDVDDao.getTieuDeDVDByName(txtTenTieuDe.getText());
					int n = JOptionPane.showConfirmDialog(null, "Chắc chắn hủy phiếu?","XÁC NHẬN",JOptionPane.YES_NO_OPTION);
					if(n == JOptionPane.YES_OPTION) {
						long idTD=tdDeDVD.getiDTieuDe();
						long idKH=kh.getiDKH();
						String tenTieuDe=table.getValueAt(row, 1).toString();
					
						phieuDatDao.huyPhieuDat(idTD,idKH);	
						
						for (int i = rows - 1; i >= 0; i--) {
							tablemodel.removeRow(i);							
						}
						updateTableData();
						JOptionPane.showMessageDialog(null,"Đã hủy phiếu thành công !");
						setRongTextFields();
						if(phieuDatDao.ktraDatTruoc(idTD)!=0) {
							JOptionPane.showMessageDialog(null,"Có khách hàng khác cũng đang đặt cho tiêu đề \""+tenTieuDe+"\" !");
						}else {
							phieuDatDao.huyChoChoDiaDVD(idTD);
						}
					}											
				}
			}
		});
		btnHuyDatTruoc.setBounds(133, 250, 159, 34);
		panel.add(btnHuyDatTruoc);
		
		lblThongbao = new JLabel("");
		lblThongbao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThongbao.setForeground(Color.RED);
		lblThongbao.setBounds(133, 42, 321, 24);
		panel.add(lblThongbao);
		
		JLabel lblNgay = new JLabel("Ngày lập phiếu:");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgay.setBounds(12, 187, 123, 30);
		panel.add(lblNgay);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgay.setEnabled(false);
		txtNgay.setColumns(10);
		txtNgay.setBounds(133, 187, 272, 31);
		panel.add(txtNgay);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaKH.setBounds(19, 59, 123, 24);
		contentPane.add(lblMaKH);
		
		textTenKhachHang = new JTextField();
		textTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTenKhachHang.setEnabled(false);
		textTenKhachHang.setBounds(143, 99, 325, 33);
		contentPane.add(textTenKhachHang);
		textTenKhachHang.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenKH.setBounds(19, 103, 123, 24);
		contentPane.add(lblTenKH);
		
		TieuDeDVDDao tieuDeDAO = new TieuDeDVDDao();
		dsTieuDe = (ArrayList<TieuDeDVD>) tieuDeDAO.getdsTieuDeDVD();
		ArrayList<String> dsTenTieuDe = new ArrayList<String>() ;
		for(TieuDeDVD  tieuDeDVD : dsTieuDe) {
			dsTenTieuDe.add(tieuDeDVD.getTenTieuDe());
		}
		comboBoxTieuDe = new JComboBox(dsTenTieuDe.toArray());
		comboBoxTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuDe.setBounds(143, 143, 325, 33);
		contentPane.add(comboBoxTieuDe);
		
		JButton btnDatTruoc = new JButton("Đặt trước");
		btnDatTruoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatTruoc.setForeground(Color.WHITE);
		btnDatTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datTruoc();
				updateTableData();
			}
		});
		btnDatTruoc.setBackground(Color.BLUE);
		btnDatTruoc.setBounds(478, 143, 112, 33);
		contentPane.add(btnDatTruoc);
		
		JLabel lblTieuDeDat = new JLabel("Tiêu đề:");
		lblTieuDeDat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuDeDat.setBounds(19, 152, 123, 14);
		contentPane.add(lblTieuDeDat);
		
		JButton btnDoiKhachHang = new JButton("Đổi khách hàng");
		btnDoiKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiKhachHang.setForeground(Color.WHITE);
		btnDoiKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 textMaKhachHang.setEnabled(true);
			 textTenKhachHang.setText("");
			 textMaKhachHang.setText("");
			}
		});
		btnDoiKhachHang.setBackground(Color.BLUE);
		btnDoiKhachHang.setBounds(600, 55, 157, 33);
		contentPane.add(btnDoiKhachHang);
		
		JButton btnTaiLai = new JButton("");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTableData();
			}
		});
		btnTaiLai.setIcon(new ImageIcon(QuanLyDatTruocFrame.class.getResource("/images/reload.png")));
		btnTaiLai.setBounds(1041, 164, 35, 35);
		contentPane.add(btnTaiLai);
		table.addMouseListener(this);
		updateTableData();
	}
	
	private void timKhachHang() {
		textTenKhachHang.setText("");
		long inputIDKhach = Long.parseLong(textMaKhachHang.getText().length()>0?textMaKhachHang.getText():"-1");
		KhachHang khachHang = null;
		khachHang= khachHangDao.getKhbyId(inputIDKhach);
		if (khachHang== null ) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
		}else {
			textTenKhachHang.setText(khachHang.getTen());
			textMaKhachHang.setEnabled(false);
		}	
	}
	public void xoaDuLieuTrenTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	private void datTruoc() {
		if(textTenKhachHang.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "Chưa nhập khách hàng");
		}else {
			boolean coTheDat = true;			
			PhieuDatDao phieuDatTruocDao = new PhieuDatDao();
			ArrayList<PhieuDatTruoc> dsPhieuDatTruoc = new ArrayList<PhieuDatTruoc>(phieuDatTruocDao.getDsPhieuDatTruoc());
			KhachHang khachHang = khachHangDao.getKhbyId(Long.parseLong(textMaKhachHang.getText()));
			TieuDeDVDDao tieuDeDVDDao = new TieuDeDVDDao();			
			TieuDeDVD tieuDeDVD = tieuDeDVDDao.getTieuDeDVDByName(comboBoxTieuDe.getSelectedItem().toString());
			List<DVD> listDvd= dvdDao.getdsDVDbyTieuDeDVD(tieuDeDVD.getiDTieuDe());
			if(listDvd.size()!=0) {
				JOptionPane.showMessageDialog(null, "Tiêu đề có sẵn đĩa cho thuê, không cần đặt trước");
				return;			
			}
			// Kiểm tra khách đã đặt tiêu đề này chưa
			for(PhieuDatTruoc phieuDat : dsPhieuDatTruoc) {
				if(phieuDat.getKhachHang().getiDKH()==khachHang.getiDKH()&& phieuDat.getTieuDeDVD().getiDTieuDe()==tieuDeDVD.getiDTieuDe()) {
					coTheDat= false;// Khách đã đặt rồi nên ko đặt đc nữa
				}
			}
			if(coTheDat) {
				PhieuDatTruoc p = new PhieuDatTruoc(khachHang, tieuDeDVD, false, LocalDateTime.now());
				phieuDatDao.themPhieuDatTruoc(p);
				JOptionPane.showMessageDialog(null, "Đặt trước thành công");
			}else {
				JOptionPane.showMessageDialog(null, "Khách hàng đã đặt tiêu đề này rồi!!!!");
			}
		}
		
	}
	private void updateTableData() {	
		xoaDuLieuTrenTable();
		List<PhieuDatTruoc> pList = phieuDatDao.getDsPhieuDatTruoc();
		for(PhieuDatTruoc pdDatTruoc : pList) {
			LocalDateTime ngay = pdDatTruoc.getThoiGianDat();
		    Date date2 = Date.from(ngay.atZone(ZoneId.systemDefault()).toInstant());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dateFormat = formatter.format(date2);
			
			String tenKH = pdDatTruoc.getKhachHang().getTen();
			String tenTD = pdDatTruoc.getTieuDeDVD().getTenTieuDe();
			boolean trangThai = pdDatTruoc.isTrangThai();
			String[] rowData = {tenKH,tenTD,dateFormat,trangThai==true?"Chờ khách hàng nhận":"Chưa xử lý"};	
		    tablemodel.addRow(rowData);
		}
		table.setModel(tablemodel);
	}
	public void setRongTextFields() {
		txtTenKH.setText("");
		txtNgay.setText("");
		txtTenTieuDe.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();	
		txtTenKH.setText(table.getValueAt(row, 0).toString());
		txtTenTieuDe.setText(table.getValueAt(row, 1).toString());
		txtNgay.setText(table.getValueAt(row, 2).toString());	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

