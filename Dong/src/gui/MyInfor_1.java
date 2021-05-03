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


	private String Url = "jdbc:mysql://@localhost:3306/druglist"; // URL 정보 저장 변수
	private String user = "root"; 
	private String password = "mirim2";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmtAdd = null;
	private PreparedStatement pstmtDel = null;
	private PreparedStatement pstmtUpdate = null;


	public MyInfor_1() {

		super("JdbcTable 연동 Sample");
		preDbTreatment();

		data = new Vector<>();
		title = new Vector<>();
		title.add("날짜");
		title.add("약 이름");
		title.add("개수");

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

//				in 벡터에 들어있는 값을 각각의 String 변수에 대입 
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

		lblNum = new JLabel("날짜");
		lblName = new JLabel("이름");
		lblAddress = new JLabel("개수");

		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnUpdate = new JButton("수정");
		btnClear = new JButton("초기화");

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String date = tfNum.getText(); // 번호
				String name = tfName.getText(); // 이름
				String count = tfAddress.getText(); // 주소

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
		c.add(new JLabel("알략 일지", JLabel.CENTER),"North");
		c.add(sp,BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent w) {
				try{
					stmt.close(); // Statement 객체 닫기
					conn.close(); // Connection 객체 닫기
					setVisible(false); // 화면 닫기
					dispose(); // 자원 반납
					System.exit(0); // 종료 처리
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
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}
	
	private void insert(String date, String name, String count){
		try{
			pstmtAdd = conn.prepareStatement("insert into drug values(?,?,?)");
//			insert into member values(? -> 1 ,? -> 2, ? -> 3)" 각각의 ? 에 값 대입
			pstmtAdd.setString(1, date);
			pstmtAdd.setString(2, name);
			pstmtAdd.setString(3, count);

//			대입받은 쿼리를 실행 -> 입력 (insert)
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
		//		내부 컴포넌트의 크기와 정렬 상태에 따라 프레임의 크기를 정함
		frame.pack();
		frame.setVisible(true);
	}
}
