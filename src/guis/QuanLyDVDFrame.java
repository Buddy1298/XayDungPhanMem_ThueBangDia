package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import antlr.collections.List;
import daos.DVDDao;
import daos.LoaiDVDDao;
import daos.TieuDeDVDDao;
import entities.DVD;
import entities.LoaiDVD;
import entities.TieuDeDVD;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class QuanLyDVDFrame extends JFrame {

	public JPanel contentPane;
	private JTable tableDanhSachDia;
	private DVDDao  dvdDAO= new DVDDao();
	private TieuDeDVDDao tieuDeDAO = new TieuDeDVDDao();
	private DefaultTableModel tablemodel,tieuDeModel;
	private JTextField txtTenTieuDe;
	private JTable tableTieuDe;
	private LoaiDVDDao loaiDVDDAO = new LoaiDVDDao();
	private ArrayList<TieuDeDVD> dsTieuDe;
	private ArrayList<LoaiDVD> dsLoaiDVD;
	JComboBox comboBoxTieuDe;
	private int selectedRow=0;
	private int selectedTieuDeRow=0;
	JComboBox comboBoxLoaiDVD;
	
	private static SuaLoaiDVDFrame suaLoaiDVDFrame = new SuaLoaiDVDFrame();

	private static MainForm mainForm = new MainForm();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyDVDFrame frame = new QuanLyDVDFrame();
					frame.setVisible(true);
					frame.setTitle("Quản lý DVD");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyDVDFrame() {
		dsTieuDe= new ArrayList<TieuDeDVD>(tieuDeDAO.getdsTieuDeDVD());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(507, 64, 579, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// table scroll
		String [] collumnNames = {"Mã đĩa","Tiêu đề","Trạng Thái"};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 559, 529);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách đĩa"));
		panel.add(scrollPane);
		tableDanhSachDia = new JTable();
		tableDanhSachDia.setRowHeight(20);
		tablemodel = new DefaultTableModel(collumnNames, 0);
		tableDanhSachDia.setModel(tablemodel);
		scrollPane.setViewportView(tableDanhSachDia);
		updateTable();
		
		JButton btnThemDia = new JButton("Thêm đĩa");
		btnThemDia.setForeground(new Color(255, 255, 255));
		btnThemDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					themDia();
					updateTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThemDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThemDia.setBounds(77, 11, 172, 42);
		btnThemDia.setBackground(Color.BLUE);
		contentPane.add(btnThemDia);
		
		JButton btnXoaDia = new JButton("Xóa đĩa");
		btnXoaDia.setForeground(new Color(255, 255, 255));
		btnXoaDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaDia.setBounds(259, 11, 172, 42);
		btnXoaDia.setBackground(Color.RED);
		btnXoaDia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaDia();
			}
		});
		contentPane.add(btnXoaDia);
		
		JButton btnThemTieuDe = new JButton("Thêm tiêu đề");
		btnThemTieuDe.setForeground(new Color(255, 255, 255));
		btnThemTieuDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					themTieuDe();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThemTieuDe.setBackground(Color.BLUE);
		btnThemTieuDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemTieuDe.setBounds(2, 536, 144, 42);
		contentPane.add(btnThemTieuDe);
		
		txtTenTieuDe = new JTextField();
		txtTenTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenTieuDe.setBounds(116, 496, 240, 27);
		contentPane.add(txtTenTieuDe);
		txtTenTieuDe.setColumns(10);
		
		JLabel lblTenTieuDe = new JLabel("Tên tiêu đề:");
		lblTenTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenTieuDe.setBounds(10, 495, 96, 27);
		contentPane.add(lblTenTieuDe);
		
		dsLoaiDVD = new ArrayList<LoaiDVD>(loaiDVDDAO.getDsLoaiDVD());
		ArrayList<String> dsTenLoaiDVD = new ArrayList<String>();
		for (LoaiDVD loaidvd: dsLoaiDVD) {
			dsTenLoaiDVD.add(loaidvd.getTenLoai());
		}
		comboBoxLoaiDVD = new JComboBox(dsTenLoaiDVD.toArray());
		comboBoxLoaiDVD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxLoaiDVD.setBounds(116, 463, 240, 27);
		contentPane.add(comboBoxLoaiDVD);
		
		JLabel lblLoaiDia = new JLabel("Loại đĩa:");
		lblLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiDia.setBounds(10, 468, 96, 17);
		contentPane.add(lblLoaiDia);
		
		ArrayList<String> dsTenTieuDe = new ArrayList<String>();
		
		for(TieuDeDVD tieuDe : dsTieuDe) {
			String tenTieuDe = tieuDe.getTenTieuDe();
			dsTenTieuDe.add(tenTieuDe);
		}
		comboBoxTieuDe = new JComboBox(dsTenTieuDe.toArray());
		comboBoxTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuDe.setBounds(164, 64, 267, 42);
		
		contentPane.add(comboBoxTieuDe);
		
		JLabel lblCombobox = new JLabel("Tiêu đề:");
		lblCombobox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCombobox.setBounds(77, 78, 77, 14);
		contentPane.add(lblCombobox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 148, 487, 302);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 487, 304);
		panel_1.add(scrollPane_1);
		
		tableTieuDe = new JTable();
		tableTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableTieuDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1) {
				JTable target =(JTable) e.getSource();
				int row = target.getSelectedRow();
				selectedTieuDeRow =row;
				String selectedTenTieuDe =(String) tableTieuDe.getValueAt(row, 1);
				txtTenTieuDe.setText(selectedTenTieuDe);
				String selectedTenLoaiDVD = (String) tableTieuDe.getValueAt(row, 2);
				comboBoxLoaiDVD.setSelectedItem(selectedTenLoaiDVD);
			}
			}
		});
		
		scrollPane_1.setViewportView(tableTieuDe);
		String[] tieuDeCol= {"Mã tiêu đề","Tên tiêu đề","Loại đĩa","Giá"};
		tieuDeModel = new DefaultTableModel(tieuDeCol,0);
		tableTieuDe.setModel(tieuDeModel);
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("Danh sách Tiêu đề"));

		JButton btnGiaThueTGThue = new JButton("Đặt giá thuê và thời gian thuê ");
		btnGiaThueTGThue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * chuyển đến form sửa loại DVD
				 */
				suaLoaiDVDFrame.setLocationRelativeTo(null);
				suaLoaiDVDFrame.setVisible(true);
				mainForm.setEnabled(false);

			}

		});
		btnGiaThueTGThue.setForeground(Color.WHITE);
		btnGiaThueTGThue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGiaThueTGThue.setBounds(229, 536, 275, 42);
		btnGiaThueTGThue.setBackground(Color.BLUE);
		contentPane.add(btnGiaThueTGThue);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(QuanLyDVDFrame.class.getResource("/images/reload.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
				updateTieuDeTable();
			}
		});
		btnNewButton.setBounds(507, 26, 35, 35);
		contentPane.add(btnNewButton);
		
		JButton btnSuaTieuDe = new JButton("Sửa");
		btnSuaTieuDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSuaTieuDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaTieuDe();
			}
		});
		btnSuaTieuDe.setForeground(Color.WHITE);
		btnSuaTieuDe.setBackground(Color.BLUE);
		btnSuaTieuDe.setBounds(149, 536, 77, 42);
		contentPane.add(btnSuaTieuDe);
		updateTieuDeTable();
	

	}
	
	private void updateTieuDeTable() {
		dsTieuDe = new ArrayList<TieuDeDVD>(tieuDeDAO.getdsTieuDeDVD());
		tieuDeModel.setRowCount(0);
		for (TieuDeDVD tieuDe: dsTieuDe) {
			String [] rowData = {String.valueOf(tieuDe.getiDTieuDe()),String.valueOf(tieuDe.getTenTieuDe()),String.valueOf(tieuDe.getLoaiDVD().getTenLoai()),String.valueOf(tieuDe.getLoaiDVD().getGiaThue())};
			tieuDeModel.addRow(rowData);
		}
	}
	
	private void updateTable () {
		ArrayList<DVD> dsDVD ;
		dsDVD = new ArrayList<DVD>(dvdDAO.getdsDVD());
		tablemodel.setRowCount(0);
		for ( DVD dvd :dsDVD) {
			if(dvd.getTrangThai()!=DVD.DA_HU_HONG) {
			String[] rowData = {String.valueOf(dvd.getiDDVD()),dvd.getTieuDeDVD().getTenTieuDe(),dvd.getTrangThai()==0?"Có sẵn":dvd.getTrangThai()==1?"Đã được thuê" : "Đã được đặt"};
			tablemodel.addRow(rowData);
			}
		}
	}
	
	private void themDia() throws Exception {
		String selectedTenTieuDe= comboBoxTieuDe.getSelectedItem().toString();
		for(TieuDeDVD tieude: dsTieuDe) {
			if(tieude.getTenTieuDe().compareToIgnoreCase(selectedTenTieuDe)==0) {
				DVD dvd = new DVD(tieude, DVD.SAN_CHO_THUE);
				dvdDAO.themDVD(dvd);
			};

		}
	}
	private void xoaDia() {
		selectedRow = tableDanhSachDia.getSelectedRow();
		String selectedTrangThai=  tableDanhSachDia.getValueAt(selectedRow, 2).toString();
		if(selectedTrangThai.compareToIgnoreCase("có sẵn")!=0) {JOptionPane.showMessageDialog(getContentPane(), "Không thể xóa đĩa này");}
		else{long SelectedID= Long.parseLong((String) tableDanhSachDia.getValueAt(selectedRow, 0)) ;
		dvdDAO.deleteDVDbyID(SelectedID);
		DVD dvd = dvdDAO.getDVDByID(SelectedID);
		dvd.setTrangThai(DVD.DA_HU_HONG);
		try {
			dvdDAO.updateDVD(dvd);
		}catch (Exception e) {
			// TODO: handle exception
		}
		updateTable();
		};
		
	}
	private void themTieuDe() throws Exception {
		System.out.println(comboBoxLoaiDVD.getSelectedItem().toString());
		String inputTenTieuDe = txtTenTieuDe.getText();
		for(LoaiDVD loaiDVD : dsLoaiDVD) {
			if (loaiDVD.getTenLoai().compareToIgnoreCase(comboBoxLoaiDVD.getSelectedItem().toString())==0 && inputTenTieuDe.length()>0) {
				TieuDeDVD tieuDeDVD = new TieuDeDVD(inputTenTieuDe, loaiDVD);
				tieuDeDAO.themTieuDeDVD(tieuDeDVD);
				dsTieuDe.add(tieuDeDVD);
				comboBoxTieuDe.addItem(tieuDeDVD.getTenTieuDe());
			}
		}
		txtTenTieuDe.setText("");
		updateTieuDeTable();
	}
	
	private void suaTieuDe() {
		long selectedIDTieuDe =  Long.parseLong(tableTieuDe.getValueAt(selectedTieuDeRow, 0).toString()) ;
		for(TieuDeDVD tieudeDVD : dsTieuDe) {
			if(tieudeDVD.getiDTieuDe()==selectedIDTieuDe) {
				LoaiDVD newLoai = null;
				for (LoaiDVD loaiDVD : dsLoaiDVD) {
					if (loaiDVD.getTenLoai().equalsIgnoreCase(comboBoxLoaiDVD.getSelectedItem().toString())) {
						newLoai = new LoaiDVD(loaiDVD.getiDLoai(), loaiDVD.getTenLoai(), loaiDVD.getGiaThue(), loaiDVD.getThoiGianThue());
					}
				}
				TieuDeDVD newTieuDe = new TieuDeDVD(tieudeDVD.getiDTieuDe(),txtTenTieuDe.getText().toString(), newLoai);
				tieuDeDAO.updateTieuDeDVD(newTieuDe);
			}
		}
		updateTieuDeTable();
		
		
	}
}

