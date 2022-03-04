package guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

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

import daos.LoaiDVDDao;
import entities.LoaiDVD;

public class SuaLoaiDVDFrame extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JTextField textFieldGiaThue;
	private JTextField textFieldTenLoaiDVD;
	private JTextField textFieldThoiGianThue;
	private LoaiDVDDao loaiDVDDao = new LoaiDVDDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaLoaiDVDFrame frame = new SuaLoaiDVDFrame();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuaLoaiDVDFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1131, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(312, 13, 789, 527);

		// table
		String[] colname = "ID loại DVD;Tên Loại DVD;Giá thuê;Thời gian thuê".split(";");
		tablemodel = new DefaultTableModel(colname, 0);
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.setBackground(new java.awt.Color(244, 204, 153));
		table.setRowHeight(20);

		// scroll

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(645, 220));
		scroll.setBorder(BorderFactory.createTitledBorder("DANH SÁCH LOẠI DVD"));
		scroll.setBounds(12, 13, 765, 430);

		panel.add(scroll);
		panel.setBackground(new java.awt.Color(145, 102, 72));
		contentPane.add(panel);

		JLabel lblTenLoaiDVD = new JLabel("Tên Loại DVD");
		lblTenLoaiDVD.setBounds(12, 121, 82, 24);
		contentPane.add(lblTenLoaiDVD);

		textFieldTenLoaiDVD = new JTextField();
		textFieldTenLoaiDVD.setBounds(117, 122, 183, 23);
		contentPane.add(textFieldTenLoaiDVD);
		textFieldTenLoaiDVD.setColumns(10);

		JLabel lblGiaThue = new JLabel("Giá Thuê");
		lblGiaThue.setBounds(12, 184, 99, 19);
		contentPane.add(lblGiaThue);

		textFieldGiaThue = new JTextField();
		textFieldGiaThue.setBounds(117, 182, 183, 22);
		contentPane.add(textFieldGiaThue);
		textFieldGiaThue.setColumns(10);

		JLabel lblThoiGianThue = new JLabel("Thời Gian Thuê");
		lblThoiGianThue.setBounds(12, 245, 56, 16);
		contentPane.add(lblThoiGianThue);

		textFieldThoiGianThue = new JTextField();
		textFieldThoiGianThue.setBounds(117, 242, 183, 22);
		contentPane.add(textFieldThoiGianThue);
		textFieldThoiGianThue.setColumns(10);

		JLabel lblNewLabel = new JLabel("Sửa thông tin loại DVD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 13, 271, 32);
		contentPane.add(lblNewLabel);

		JButton btnSua = new JButton("Sửa thông tin");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBackground(new java.awt.Color(145, 102, 72));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (validData()) {
						LoaiDVD loaiDVD = loaiDVDDao.getLoaiDVDbyTenLoai(textFieldTenLoaiDVD.getText());
						loaiDVDDao.capnhatLoaiDVD(new LoaiDVD(loaiDVD.getiDLoai(), textFieldTenLoaiDVD.getText(),
								Double.parseDouble(textFieldGiaThue.getText()),
								Integer.parseInt(textFieldThoiGianThue.getText())));

						int rows = tablemodel.getRowCount();
						for (int i = rows - 1; i >= 0; i--) {
							tablemodel.removeRow(i);
						}
						updateTableData();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSua.setBounds(12, 339, 288, 52);
		contentPane.add(btnSua);

		Icon iconReload = new ImageIcon("./resource/images/reload.png");
		JButton btnNewButton_1 = new JButton(iconReload);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldGiaThue.setText("");
				textFieldThoiGianThue.setText("");

			}
		});
		updateTableData();
		table.addMouseListener(this);

	}

	private void updateTableData() {
		LoaiDVDDao loaiDVDDao = new LoaiDVDDao();
		for (LoaiDVD ldvd : loaiDVDDao.getDsLoaiDVD()) {
			String[] rowData = { String.valueOf(ldvd.getiDLoai()), ldvd.getTenLoai(), String.valueOf(ldvd.getGiaThue()),
					String.valueOf(ldvd.getThoiGianThue()) + "" };
			tablemodel.addRow(rowData);
		}

		table.setModel(tablemodel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int row = table.getSelectedRow();
		textFieldTenLoaiDVD.setText(table.getValueAt(row, 1).toString());
		textFieldTenLoaiDVD.setEditable(false);
		textFieldGiaThue.setText(table.getValueAt(row, 2).toString());
		textFieldThoiGianThue.setText(table.getValueAt(row, 3).toString());

	}

	private boolean validData() {
		String giathue = textFieldGiaThue.getText().trim();
		String thoigianthue = textFieldThoiGianThue.getText().trim();

		if (!(giathue.length() > 0 && giathue.matches("[\\d.,]+"))) {
			showMessage("Loi: Giá thuê phải là số và không được để trống", textFieldGiaThue);
			return false;
		}
		if (!(thoigianthue.length() > 0 && thoigianthue.matches("\\d+"))) {
			showMessage("Loi: Thời gian thuê phải là số và không được để trống", textFieldThoiGianThue);
			return false;
		}

		return true;
	}

	private void showMessage(String message, JTextField textfield) {
		textfield.requestFocus();
		JOptionPane.showMessageDialog(null, message);
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
