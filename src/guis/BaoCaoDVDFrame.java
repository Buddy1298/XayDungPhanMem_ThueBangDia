package guis;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import daos.CTHDDao;
import daos.DVDDao;
import daos.KhachHangDao;
import daos.PhieuDatDao;
import daos.TieuDeDVDDao;
import entities.DVD;
import entities.KhachHang;
import entities.PhieuDatTruoc;
import entities.TieuDeDVD;
import java.awt.Font;

public class BaoCaoDVDFrame extends JFrame implements MouseListener{
	
	public static JPanel contentPane;
	public DefaultTableModel tablemodelDVDSanSangChoThue;
	public DefaultTableModel tablemodelDVDDangThue;
	public DefaultTableModel tablemodelDVDDangDat;
	public DefaultTableModel tablemodelKhachHangDat;
	public DefaultTableModel tablemodelTieuDeDVD;
	private JTable tableDVDSanSangChoThue;
	private JTable tableDVĐangThue;
	private JTable tableDVĐangDat;
	private JTable tableKhachHangDat;
	private JTable tableTieuDeDVD;
	private JScrollPane scrollBaoCaoTrangThaiDVDSanSangThue;
	private JScrollPane scrollBaoCaoTrangThaiDVDDangThue;
	private JScrollPane scrollBaoCaoTrangThaiDVDDangDat;
	private JScrollPane scrollBaoCaoTrangThaiDVDKhachHangDat;
	private JScrollPane scrollBaoCaoTieuDeDVD;
	private List<PhieuDatTruoc> listPhieuDatTruocs;
	public static JTabbedPane tabbedPane;
	public static JPanel panel_2,panel_3,panel_4;
	
	
	
	private DVDDao dvdDao = new DVDDao();
	private TieuDeDVDDao tieuDeDVDDao=new TieuDeDVDDao();
	private KhachHangDao khachHangDao=new KhachHangDao();
	private CTHDDao cthdDao=new CTHDDao();
	private PhieuDatDao phieuDatDao=new PhieuDatDao();
	
	// vu.begin
		private DefaultTableModel tablemodelKhachHang;
		private DefaultTableModel tablemodelKhachHangTreHan;
		public DefaultTableModel tablemodelTieuDeOnly;
		// vu.end
		// vu.begin
		private JTable tableKhachHang;
		private JTable tableKhachHangTreHan;
		private JTable tableTieuDeOnly;
		// vu.end
		// vu.begin
		private JScrollPane scrollBaoCaoKH;
		private JScrollPane scrollBaoCaoKHTreHan;
		private JScrollPane scrollTieuDeOnly;
		// vu.end
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoDVDFrame frame = new BaoCaoDVDFrame();
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
	public BaoCaoDVDFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 38, 959, 502);
		contentPane.add(tabbedPane);
		
		JPanel panelBaoCaoDVD = new JPanel();
		tabbedPane.addTab("BÁO CÁO TRẠNG THÁI ĐĨA", null, panelBaoCaoDVD, null);
		//
		String[] colnameDVDSanSangChoThue = "ID DVD;Tiêu đề;giá;Trạng thái DVD;Loai đĩa".split(";");
		tablemodelDVDSanSangChoThue = new DefaultTableModel(colnameDVDSanSangChoThue, 0);
		panelBaoCaoDVD.setLayout(null);
		tableDVDSanSangChoThue = new JTable(tablemodelDVDSanSangChoThue);
		tableDVDSanSangChoThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDVDSanSangChoThue.setBackground(new java.awt.Color(244, 204, 153));
		tableDVDSanSangChoThue.setRowHeight(20);
		//
		String[] colnameDVDDangthue = "ID DVD;Tiêu đề;giá;Loai đĩa;Tên khách thuê;Số điện thoại".split(";");
		tablemodelDVDDangThue = new DefaultTableModel(colnameDVDDangthue, 0);
		panelBaoCaoDVD.setLayout(null);
		tableDVĐangThue = new JTable(tablemodelDVDDangThue);
		tableDVĐangThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDVĐangThue.setBackground(new java.awt.Color(244, 204, 153));
		tableDVĐangThue.setRowHeight(20);
		//
		String[] colnameDVDDangDat = "ID tiêu đề;Tiêu đề;giá;Loại đĩa".split(";");
		tablemodelDVDDangDat = new DefaultTableModel(colnameDVDDangDat, 0);
		panelBaoCaoDVD.setLayout(null);
		tableDVĐangDat = new JTable(tablemodelDVDDangDat);
		tableDVĐangDat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDVĐangDat.setBackground(new java.awt.Color(244, 204, 153));
		tableDVĐangDat.setRowHeight(20);
		//
		String[] colnameDVDKhachHangDat = "Tên khách hàng;số điện thoại;Ngày đặt".split(";");
		tablemodelKhachHangDat = new DefaultTableModel(colnameDVDKhachHangDat, 0);
		panelBaoCaoDVD.setLayout(null);
		tableKhachHangDat = new JTable(tablemodelKhachHangDat);
		tableKhachHangDat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableKhachHangDat.setBackground(new java.awt.Color(244, 204, 153));
		tableKhachHangDat.setRowHeight(20);
	

		// scroll

		scrollBaoCaoTrangThaiDVDSanSangThue = new JScrollPane(tableDVDSanSangChoThue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBaoCaoTrangThaiDVDSanSangThue.setPreferredSize(new Dimension(645, 220));
		scrollBaoCaoTrangThaiDVDSanSangThue.setBorder(BorderFactory.createTitledBorder("DVD sẵn sàng cho thuê"));
		scrollBaoCaoTrangThaiDVDSanSangThue.setBounds(12, 46, 891, 413);
		
		panelBaoCaoDVD.add(scrollBaoCaoTrangThaiDVDSanSangThue);
		panelBaoCaoDVD.setBackground(new java.awt.Color(145, 102, 72));
		// scoll
		scrollBaoCaoTrangThaiDVDDangThue = new JScrollPane(tableDVĐangThue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBaoCaoTrangThaiDVDDangThue.setPreferredSize(new Dimension(645, 220));
		scrollBaoCaoTrangThaiDVDDangThue.setBorder(BorderFactory.createTitledBorder("DVD đang được thuê"));
		scrollBaoCaoTrangThaiDVDDangThue.setBounds(12, 46, 891, 413);
		panelBaoCaoDVD.add(scrollBaoCaoTrangThaiDVDDangThue);
		panelBaoCaoDVD.setBackground(new java.awt.Color(145, 102, 72));
		scrollBaoCaoTrangThaiDVDDangThue.setVisible(false);
		
		// scoll
		scrollBaoCaoTrangThaiDVDDangDat = new JScrollPane(tableDVĐangDat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBaoCaoTrangThaiDVDDangDat.setPreferredSize(new Dimension(645, 220));
		scrollBaoCaoTrangThaiDVDDangDat.setBorder(BorderFactory.createTitledBorder("Danh sách tiêu đề"));
		scrollBaoCaoTrangThaiDVDDangDat.setBounds(12, 46, 400, 413);
		panelBaoCaoDVD.add(scrollBaoCaoTrangThaiDVDDangDat);
		panelBaoCaoDVD.setBackground(new java.awt.Color(145, 102, 72));
		scrollBaoCaoTrangThaiDVDDangDat.setVisible(false);
		
		// scoll
		scrollBaoCaoTrangThaiDVDKhachHangDat = new JScrollPane(tableKhachHangDat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBaoCaoTrangThaiDVDKhachHangDat.setPreferredSize(new Dimension(645, 220));
		scrollBaoCaoTrangThaiDVDKhachHangDat.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
		scrollBaoCaoTrangThaiDVDKhachHangDat.setBounds(459, 46, 444, 413);
		panelBaoCaoDVD.add(scrollBaoCaoTrangThaiDVDKhachHangDat);
		panelBaoCaoDVD.setBackground(new java.awt.Color(145, 102, 72));
		scrollBaoCaoTrangThaiDVDKhachHangDat.setVisible(false);
		
		
		
		

		

		
		
		
		String loai[]={"Sẵn sàng cho thuê","Đang thuê","Đang đặt trước"};
		JComboBox cbPhanLoaiTrangThaiDVD = new JComboBox(loai);
		cbPhanLoaiTrangThaiDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhanLoaiTrangThaiDVD.setBounds(12, 11, 162, 22);
		
		panelBaoCaoDVD.add(cbPhanLoaiTrangThaiDVD);
		
		JButton btnLocDVD = new JButton("Lọc DVD");
		btnLocDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLocDVD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				if(cbPhanLoaiTrangThaiDVD.getSelectedIndex()==0) {
					scrollBaoCaoTrangThaiDVDDangDat.setVisible(false);
					scrollBaoCaoTrangThaiDVDDangThue.setVisible(false);
					scrollBaoCaoTrangThaiDVDKhachHangDat.setVisible(false);
					scrollBaoCaoTrangThaiDVDSanSangThue.setVisible(true);
				}
				
				
				if(cbPhanLoaiTrangThaiDVD.getSelectedIndex()==1) {
					scrollBaoCaoTrangThaiDVDDangDat.setVisible(false);
					scrollBaoCaoTrangThaiDVDSanSangThue.setVisible(false);
					scrollBaoCaoTrangThaiDVDKhachHangDat.setVisible(false);
					scrollBaoCaoTrangThaiDVDDangThue.setVisible(true);
				
				
				}
				if(cbPhanLoaiTrangThaiDVD.getSelectedIndex()==2) {
					scrollBaoCaoTrangThaiDVDSanSangThue.setVisible(false);
					scrollBaoCaoTrangThaiDVDDangThue.setVisible(false);
					scrollBaoCaoTrangThaiDVDDangDat.setVisible(true);
					scrollBaoCaoTrangThaiDVDKhachHangDat.setVisible(true);
					
				}
		
					
			}
		});
		btnLocDVD.setBounds(184, 10, 97, 25);
		panelBaoCaoDVD.add(btnLocDVD);
		
		//
		
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Báo cáo tiêu đề DVD", null, panel_1, null);
		String[] colname1 = "Tiêu đề;giá;Loại;Số bản DVD sẵn sàng cho thuê".split(";");
		tablemodelTieuDeDVD = new DefaultTableModel(colname1, 0);
		panel_1.setLayout(null);
		tableTieuDeDVD = new JTable(tablemodelTieuDeDVD);
		tableTieuDeDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableTieuDeDVD.setBackground(new java.awt.Color(244, 204, 153));
		tableTieuDeDVD.setRowHeight(20);
	

		// scroll

		scrollBaoCaoTieuDeDVD = new JScrollPane(tableTieuDeDVD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBaoCaoTieuDeDVD.setPreferredSize(new Dimension(645, 220));
		scrollBaoCaoTieuDeDVD.setBorder(BorderFactory.createTitledBorder("Báo cáo tiêu đề đĩa"));
		scrollBaoCaoTieuDeDVD.setBounds(12, 46, 800, 354);
		
		panel_1.add(scrollBaoCaoTieuDeDVD);
		panel_1.setBackground(new java.awt.Color(145, 102, 72));
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_1);
		// Vũ begin
				// panel
				panel_2 = new JPanel();
				tabbedPane.addTab("Báo cáo thông tin khách hàng", null, panel_2, null);
				String[] colname2 = "ID;Họ tên;Địa chỉ;Số điện thoại;Tên tiêu đề khách thuê;Số DVD đang thuê".split(";");
				tablemodelKhachHang = new DefaultTableModel(colname2, 0);
				panel_2.setLayout(null);
				tableKhachHang = new JTable(tablemodelKhachHang);
				tableKhachHang.setBackground(new java.awt.Color(244, 204, 153));
				tableKhachHang.setRowHeight(20);
				

				// scroll
				scrollBaoCaoKH = new JScrollPane(tableKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollBaoCaoKH.setPreferredSize(new Dimension(645, 220));
				scrollBaoCaoKH.setBorder(BorderFactory.createTitledBorder("Báo cáo thông tin khách hàng thuê"));
				scrollBaoCaoKH.setBounds(12, 46, 800, 354);

				panel_2.add(scrollBaoCaoKH);
				panel_2.setBackground(new java.awt.Color(145, 102, 72));
				updateTablemodelKhachHang();

				// Vũ end

				// Vũ begin

				panel_3 = new JPanel();
				tabbedPane.addTab("Báo cáo phí trễ hẹn khách hàng", null, panel_3, null);
				String[] colname3 = "ID;Họ tên;Phí trễ hạn;Địa chỉ;Số điện thoại".split(";");
				tablemodelKhachHangTreHan = new DefaultTableModel(colname3, 0);
				panel_3.setLayout(null);
				tableKhachHangTreHan = new JTable(tablemodelKhachHangTreHan);
				tableKhachHangTreHan.setBackground(new java.awt.Color(244, 204, 153));
				tableKhachHangTreHan.setRowHeight(20);
				panel_3.setEnabled(false);

				scrollBaoCaoKHTreHan = new JScrollPane(tableKhachHangTreHan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollBaoCaoKHTreHan.setPreferredSize(new Dimension(645, 220));
				scrollBaoCaoKHTreHan.setBorder(BorderFactory.createTitledBorder("Báo cáo phí trễ hẹn khách hàng"));
				scrollBaoCaoKHTreHan.setBounds(12, 46, 800, 354);

				panel_3.add(scrollBaoCaoKHTreHan);
				panel_3.setBackground(new java.awt.Color(145, 102, 72));
				updateTablemodelKhachHangTreHan();

				// Vũ end

				// Vũ begin

				panel_4 = new JPanel();
				tabbedPane.addTab("Báo cáo tiêu đề", null, panel_4, null);
				String[] colname4 = "ID Tiêu đề;Tên tiêu đề;Id Loại;Tên Loại;Sẵn sàng cho thuê;Đang thuê;Đang được đặt"
						.split(";");
				tablemodelTieuDeOnly = new DefaultTableModel(colname4, 0);
				panel_4.setLayout(null);
				tableTieuDeOnly = new JTable(tablemodelTieuDeOnly);
				tableTieuDeOnly.setBackground(new java.awt.Color(244, 204, 153));
				tableTieuDeOnly.setRowHeight(20);
				panel_4.setEnabled(false);

				scrollTieuDeOnly = new JScrollPane(tableTieuDeOnly, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollTieuDeOnly.setPreferredSize(new Dimension(645, 220));
				scrollTieuDeOnly.setBorder(BorderFactory.createTitledBorder("Báo cáo tiêu đề"));
				scrollTieuDeOnly.setBounds(12, 46, 800, 354);

				panel_4.add(scrollTieuDeOnly);
				panel_4.setBackground(new java.awt.Color(145, 102, 72));
				updateTablemodelTieuDeOnly();

				// Vũ end
		
				tabbedPane.setEnabledAt(2, false);
				tabbedPane.setEnabledAt(3, false);
				tabbedPane.setEnabledAt(4, false);
		
		tableDVĐangDat.addMouseListener(this);
		
	}
	
	public void updateTableDataSanSangChoThue() {
		
		for (DVD dvd : dvdDao.getdsDVD()) {		
			if(dvd.getTrangThai()==0) {
				String[] rowData = {String.valueOf(dvd.getiDDVD()),dvd.getTieuDeDVD().getTenTieuDe(),String.valueOf(dvd.getTieuDeDVD().getLoaiDVD().getGiaThue())+"VND","sẵn sàng cho thuê",dvd.getTieuDeDVD().getLoaiDVD().getTenLoai()+ "" };
				tablemodelDVDSanSangChoThue.addRow(rowData);
			}		
		}

		tableDVDSanSangChoThue.setModel(tablemodelDVDSanSangChoThue);
	}
	
	
	public void updateTableDataDangThue() {

		for (DVD dvd : dvdDao.getdsDVD()) {		
			if(dvd.getTrangThai()==1) {
				String[] rowData = {String.valueOf(dvd.getiDDVD()),dvd.getTieuDeDVD().getTenTieuDe(),String.valueOf(dvd.getTieuDeDVD().getLoaiDVD().getGiaThue())+"VND"
						,dvd.getTieuDeDVD().getLoaiDVD().getTenLoai()
						,cthdDao.getCTHDthoiGianThueGanNhat(dvd.getiDDVD()).getHoaDon().getKhachHang().getTen()
						,cthdDao.getCTHDthoiGianThueGanNhat(dvd.getiDDVD()).getHoaDon().getKhachHang().getSdt()+ "" };
				tablemodelDVDDangThue.addRow(rowData);
			}		
		}
		tableDVĐangThue.setModel(tablemodelDVDDangThue);
	}
	
	public void updateTablemodelTieuDeDangDat() {
		
	for (TieuDeDVD tieuDeDVD : tieuDeDVDDao.getdsTieuDeDVD()) {	
		
		String[] rowData = {String.valueOf(tieuDeDVD.getiDTieuDe()),tieuDeDVD.getTenTieuDe(),String.valueOf(tieuDeDVD.getLoaiDVD().getGiaThue())+"VND",tieuDeDVD.getLoaiDVD().getTenLoai()+ "" };
		tablemodelDVDDangDat.addRow(rowData);
	}

	tableDVĐangDat.setModel(tablemodelDVDDangDat);
	}
	
	
	public void updateTablemodelKhachHangDat() {
		
	for (PhieuDatTruoc phieuDatTruoc : listPhieuDatTruocs) {	
		
		LocalDateTime ngay = phieuDatTruoc.getThoiGianDat();
	    Date date2 = Date.from(ngay.atZone(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(date2);
		
		String[] rowData = {phieuDatTruoc.getKhachHang().getTen(),phieuDatTruoc.getKhachHang().getSdt(),dateFormat+ "" };
		tablemodelKhachHangDat.addRow(rowData);
	}

	tableKhachHangDat.setModel(tablemodelKhachHangDat);
	}
	
	
	public void updateTablemodelTieuDeDVD() {
	
	for (TieuDeDVD tieuDeDVD : tieuDeDVDDao.getdsTieuDeDVD()) {	
		
		String[] rowData = {tieuDeDVD.getTenTieuDe(),String.valueOf(tieuDeDVD.getLoaiDVD().getGiaThue())+"VND",tieuDeDVD.getLoaiDVD().getTenLoai(),
				dvdDao.getdsDVDbyTieuDeDVD(tieuDeDVD.getiDTieuDe()).size()+ "" };
		tablemodelTieuDeDVD.addRow(rowData);
	}

	tableTieuDeDVD.setModel(tablemodelTieuDeDVD);
}
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = tableDVĐangDat.getSelectedRow();
		System.out.println(tableDVĐangDat.getValueAt(row, 0).toString());
		long idTieuDe=Long.valueOf(tableDVĐangDat.getValueAt(row, 0).toString());
		listPhieuDatTruocs= phieuDatDao.getdPhieuDatByTieuDeDVD(idTieuDe);
		
		int rows =tablemodelKhachHangDat.getRowCount();
			for (int i = rows - 1; i >= 0; i--) {
				tablemodelKhachHangDat.removeRow(i);
			}
		updateTablemodelKhachHangDat();
		
		
//		textFieldDiaChi.setText(tableDVĐangDat.getValueAt(row, 2).toString());
//		textFieldSdt.setText(tableDVĐangDat.getValueAt(row, 3).toString());
		
	}
	
	// Vu begin
		public void updateTablemodelKhachHang() {
			
			for (KhachHang kh : khachHangDao.getdsKhachHang()) {
				for (TieuDeDVD tieuDeDVD : tieuDeDVDDao.getdsTieuDeDVD()) {
				String[] rowData = { String.valueOf(kh.getiDKH()), kh.getTen(), kh.getDiaChi(), kh.getSdt(), tieuDeDVD.getTenTieuDe(), dvdDao.getdsDVDDangThuebyTieuDeDVD(tieuDeDVD.getiDTieuDe()).size() + "" };
				tablemodelKhachHang.addRow(rowData);
				}
			}

			tableKhachHang.setModel(tablemodelKhachHang);

		}
		// Vu end

		// Vu begin
		public void updateTablemodelKhachHangTreHan() {
			KhachHangDao KhachHangDao = new KhachHangDao();
			for (KhachHang kh : KhachHangDao.getdsKhachHang()) {
				String[] rowData = { String.valueOf(kh.getiDKH()), kh.getTen(), String.valueOf(kh.getphiTreHan()),
						kh.getDiaChi(), kh.getSdt() + "" };
				tablemodelKhachHangTreHan.addRow(rowData);
			}

			tableKhachHangTreHan.setModel(tablemodelKhachHangTreHan);

		}
		// Vu end

		// Vu begin
		public void updateTablemodelTieuDeOnly() {
			for (TieuDeDVD tieuDeDVD : tieuDeDVDDao.getdsTieuDeDVD()) {

				String[] rowData = { String.valueOf(tieuDeDVD.getiDTieuDe()), tieuDeDVD.getTenTieuDe(),
						String.valueOf(tieuDeDVD.getLoaiDVD().getiDLoai()), tieuDeDVD.getLoaiDVD().getTenLoai(),
						String.valueOf(dvdDao.getdsDVDbyTieuDeDVD(tieuDeDVD.getiDTieuDe()).size()),
						String.valueOf(dvdDao.getdsDVDDangThuebyTieuDeDVD(tieuDeDVD.getiDTieuDe()).size()),
						dvdDao.getdsDVDDangDatbyTieuDeDVD(tieuDeDVD.getiDTieuDe()).size() + "" };
				tablemodelTieuDeOnly.addRow(rowData);

			}

			tableTieuDeOnly.setModel(tablemodelTieuDeOnly);

		}
		// Vu end
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
