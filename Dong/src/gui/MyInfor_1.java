package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyInfor_1 extends JFrame {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private Vector data = null;
	@SuppressWarnings("rawtypes")
	private Vector title = null;
	private JTable table = null;

	private DefaultTableModel model = null;
	private JButton btnAdd = null;
	private JButton btnDel = null;
	private JButton btnUpdate = null;
	private JButton btnClear = null;
	
	private JTextField tfNum = null;
	private JTextField tfName = null;
	private JTextField tfAddress = null;

	private JLabel	lblNum	= null;
	private JLabel	lblName	= null;
	private JLabel	lblAddress	= null;


	private String Url = "jdbc:mysql://@localhost:3306/druglist"; // URL ���� ���� ����
	private String user = "root"; 
	private String password = "mirim2";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmtAdd = null;
	private PreparedStatement pstmtDel = null;
	private PreparedStatement pstmtUpdate = null;


	public MyInfor_1() {

		super("JdbcTable ���� Sample");
		preDbTreatment();

		data = new Vector<>();
		title = new Vector<>();
		title.add("��¥");
		title.add("�� �̸�");
		title.add("����");

		model = new DefaultTableModel();

		Vector result = selectAll();
		model.setDataVector(result, title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Vector in = (Vector) data.get(index);

//				in ���Ϳ� ����ִ� ���� ������ String ������ ���� 
				String date = (String)in.get(0);
				String name = (String)in.get(1);
				String count = (String)in.get(2);

				tfNum.setText(date);
				tfName.setText(name);
				tfAddress.setText(count);
				tfNum.setEditable(false);		
			}
		});

		JPanel panel = new JPanel();

		tfNum = new JTextField(15);
		tfName = new JTextField(10);
		tfAddress = new JTextField(5);

		lblNum = new JLabel("��¥");
		lblName = new JLabel("�̸�");
		lblAddress = new JLabel("����");

		btnAdd = new JButton("�߰�");
		btnDel = new JButton("����");
		btnUpdate = new JButton("����");
		btnClear = new JButton("�ʱ�ȭ");

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String date = tfNum.getText(); // ��ȣ
				String name = tfName.getText(); // �̸�
				String count = tfAddress.getText(); // �ּ�

				insert(date, name, count);
				Vector result = selectAll();
				model.setDataVector(result, title);
			}
		});

		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = tfNum.getText();
				delete(num);
				Vector result = selectAll();
				model.setDataVector(result, title);
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = tfNum.getText();
				String name = tfName.getText();
				String address = tfAddress.getText();

				update(name, address, num);
				Vector result = selectAll();
				model.setDataVector(result, title);
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNum.setText("");
				tfName.setText("");
				tfAddress.setText("");

				tfNum.setEditable(true);
				tfName.setEditable(true);
				tfAddress.setEditable(true);
				tfNum.requestFocus();
			}
		});

		panel.add(lblNum);
		panel.add(tfNum);
		panel.add(lblName);
		panel.add(tfName);
		panel.add(lblAddress);
		panel.add(tfAddress);
		panel.add(btnAdd);
		panel.add(btnDel);
		panel.add(btnUpdate);
		panel.add(btnClear);

		Container c = getContentPane();
		c.add(new JLabel("�˷� ����", JLabel.CENTER),"North");
		c.add(sp,BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent w) {
				try{
					stmt.close(); // Statement ��ü �ݱ�
					conn.close(); // Connection ��ü �ݱ�
					setVisible(false); // ȭ�� �ݱ�
					dispose(); // �ڿ� �ݳ�
					System.exit(0); // ���� ó��
				}catch(Exception e){
				}
			}
		});
	}

	private Vector selectAll() {
		data.clear();
		try{
			ResultSet rs = stmt.executeQuery("select * from drug order by date");
			while(rs.next()){
				Vector in = new Vector<String>(); 
				String date = rs.getString(1); 
				String name = rs.getString(2);
				String count = rs.getString(3); 

				in.add(date);
				in.add(name);
				in.add(count);
				data.add(in);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data; // ��ü ������ �����ϴ� data ���� ����
	}
	
	private void insert(String date, String name, String count){
		try{
			pstmtAdd = conn.prepareStatement("insert into drug values(?,?,?)");
//			insert into member values(? -> 1 ,? -> 2, ? -> 3)" ������ ? �� �� ����
			pstmtAdd.setString(1, date);
			pstmtAdd.setString(2, name);
			pstmtAdd.setString(3, count);

//			���Թ��� ������ ���� -> �Է� (insert)
			pstmtAdd.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void delete(String date){
		try{
			pstmtDel = conn.prepareStatement("delete from drug where date = ?");
 			pstmtDel.setString(1, date);
			pstmtDel.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void update(String date, String name, String count){
		try{
			pstmtUpdate = conn.prepareStatement("update drug set date = ?, name = ? where count = ?");
			pstmtUpdate.setString(1, date);
			pstmtUpdate.setString(2, name);
			pstmtUpdate.setString(3, count);
			pstmtUpdate.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void preDbTreatment() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/druglist","root","mirim2");
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyInfor_1 frame = new MyInfor_1();
		//		���� ������Ʈ�� ũ��� ���� ���¿� ���� �������� ũ�⸦ ����
		frame.pack();
		frame.setVisible(true);
	}
}
