package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyInfor1  extends JFrame{
	MyInfor1() {	
		setSize(1100, 800);
		setTitle("내정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		Container cp = getContentPane();
		cp.setBackground(new Color(184,211,144));
		cp.setLayout(null);
		
		JButton home = new JButton("홈");
		home.setLocation(950,650);
		home.setSize(120,40);
		home.setForeground(Color.black);
		home.setBackground(new Color(150,252,177));
		home.setFont(new Font("굴림",Font.BOLD,20));
		cp.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent my) {
				hide();
				new DrugMain();
			}
		});
		
		JButton back = new JButton("뒤로가기");
		back.setLocation(950,700);
		back.setSize(120,40);
		back.setForeground(Color.black);
		back.setBackground(new Color(150,252,177));
		back.setFont(new Font("굴림",Font.BOLD,20));
		cp.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent my) {
				hide();
				new DrugMain();
			}
		});
		
		init();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	Label dateLb;
	Label drugnameLb;
	Label drugcountLb;
	TextField dateTf;
	TextField drugnameTf;
	TextField drugcountTf;
	Button submitBt;
	Button deleteBt;
	Label dateListTitle;
	Label drugnameListTitle;
	Label drugcountListTile;
	JLabel dateListContent;
	JLabel drugnameListContent;
	JLabel drugcountListContent;
	ArrayList<String> dateArr = new ArrayList<>();
	ArrayList<String> drugnameArr = new ArrayList<>();
	ArrayList<String> drugcountArr = new ArrayList<>();
	
	public void init() {	
		dateLb = new Label("약 먹은날짜"); //약먹은날짜 글씨
		dateLb.setFont(new Font("굴림",Font.BOLD,20));
		dateLb.setSize(120,30);
		dateLb.setLocation(60, 60);
		add(dateLb);
		
		drugnameLb = new Label("약 이름"); //약 이름 글씨
		drugnameLb.setFont(new Font("굴림",Font.BOLD,20));
		drugnameLb.setSize(70,50);
		drugnameLb.setLocation(350, 50);
		add(drugnameLb);
		
		drugcountLb = new Label("약 갯수"); //약 갯수 글씨
		drugcountLb.setFont(new Font("굴림",Font.BOLD,20));
		drugcountLb.setSize(70,50);
		drugcountLb.setLocation(600, 50);
		add(drugcountLb);
		
		dateTf=new TextField();	//text박스 생성
		dateTf.setFont(new Font("굴림",Font.BOLD,20));
		dateTf.setSize(150, 70);
		dateTf.setLocation(190,50);
		add(dateTf);
		
		drugnameTf=new TextField();
		drugnameTf.setFont(new Font("굴림",Font.BOLD,20));
		drugnameTf.setSize(150, 70);
		drugnameTf.setLocation(440,50);
		add(drugnameTf);
		
		drugcountTf=new TextField();
		drugcountTf.setFont(new Font("굴림",Font.BOLD,20));
		drugcountTf.setSize(150, 70);
		drugcountTf.setLocation(690,50);
		add(drugcountTf);
		
		submitBt=new Button("확인");		//확인버튼 
		submitBt.setSize(80, 50);
		submitBt.setLocation(870, 60);
		submitBt.setForeground(Color.black);
		submitBt.setBackground(new Color(150,252,177));
		submitBt.setFont(new Font("굴림",Font.BOLD,20));
		add(submitBt);
		
		deleteBt=new Button("삭제");		//삭제버튼 
		deleteBt.setSize(90, 50);
		deleteBt.setLocation(980, 60);
		deleteBt.setForeground(Color.black);
		deleteBt.setBackground(new Color(150,252,177));
		deleteBt.setFont(new Font("굴림",Font.BOLD,20));
		add(deleteBt);
		deleteBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTf.setText("");
				drugnameTf.setText("");
				drugcountTf.setText("");
			}
		});

		dateListTitle=new Label("약 먹은날짜");  // 약먹은날짜 데이터 위 글씨
		dateListTitle.setFont(new Font("굴림",Font.BOLD,20));
		dateListTitle.setSize(120, 50);
		dateListTitle.setLocation(60, 200);
		add(dateListTitle);
		
		drugnameListTitle=new Label("약 이름");
		drugnameListTitle.setFont(new Font("굴림",Font.BOLD,20));
		drugnameListTitle.setSize(70, 50);
		drugnameListTitle.setLocation(240, 200);
		add(drugnameListTitle);
		
		drugcountListTile=new Label("약 갯수");
		drugcountListTile.setFont(new Font("굴림",Font.BOLD,20));
		drugcountListTile.setSize(80, 50);
		drugcountListTile.setLocation(370, 200);
		add(drugcountListTile);

		dateListContent = new JLabel(""); //데이터 출력칸
		dateListContent.setFont(new Font("굴림",Font.BOLD,18));
		dateListContent.setSize(110, 600);
		dateListContent.setLocation(65,250);
		dateListContent.setVerticalAlignment(SwingConstants.TOP);
		add(dateListContent);
		
		drugnameListContent = new JLabel("");	//데이터 출력칸
		drugnameListContent.setFont(new Font("굴림",Font.BOLD,18));
		drugnameListContent.setSize(100, 600);
		drugnameListContent.setLocation(240,250);
		drugnameListContent.setVerticalAlignment(SwingConstants.TOP);
		add(drugnameListContent);
		
		drugcountListContent = new JLabel("");	//데이터 출력칸
		drugcountListContent.setFont(new Font("굴림",Font.BOLD,18));
		drugcountListContent.setSize(50, 600);
		drugcountListContent.setLocation(400,250);
		drugcountListContent.setVerticalAlignment(SwingConstants.TOP);
		add(drugcountListContent);
		
		
		ImageIcon img = new ImageIcon("img/middledong.JPG");
		JLabel middledong = new JLabel(img);
		middledong.setSize(400, 400);
		middledong.setLocation(550, 200);
		add(middledong);
		
		submitBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String date ="";
				String drugname = "";
				String drugcount = "";
				date = dateTf.getText(); //입력된 텍스트 불러오기
				drugname = drugnameTf.getText();
				drugcount = drugcountTf.getText();
				
				dateArr.add(date);
				drugnameArr.add(drugname);
				drugcountArr.add(drugcount);
				
				show(dateListContent, drugnameListContent,drugcountListContent);
				
				save2();
			}
		});
		load2();
		
		show(dateListContent, drugnameListContent, drugcountListContent);
	}
	private void show (JLabel korListContent, JLabel engListContent, JLabel jpListContent) {
		String totaldate="";
		String totaldrugname="";
		String totaldrugcount="";
		
		for(int i = 0;i<dateArr.size(); i++) {
			totaldate +=dateArr.get(i)+"<br>";
			totaldrugname += drugnameArr.get(i)+"<br>";
			totaldrugcount += drugcountArr.get(i)+"<br>";
		}
		korListContent.setText("<html>" + totaldate + "</html>"); //들어갈 텍스트 설정
		engListContent.setText("<html>" + totaldrugname + "</html>");
		jpListContent.setText("<html>" + totaldrugcount + "</html>");
		
	}
	private void load2() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("txt//date.txt")); //데이터를 입력 받음
			BufferedReader br2 = new BufferedReader(new FileReader("txt//drugname.txt"));// FileReader:파일의 내용을 읽고
			BufferedReader br3 = new BufferedReader(new FileReader("txt//drugcount.txt"));//사용자의 컴퓨터에 저장
			
			while(true) {
				String line1 = br.readLine(); //한 줄씩 읽기
				String line2 = br2.readLine();
				String line3 = br3.readLine();
				if(line1 == null || line1.length() == 0)
					break;
				dateArr.add(line1);
				drugnameArr.add(line2);
				drugcountArr.add(line3);
			}
			br.close();	
			}catch(IOException e) {
				e.printStackTrace(); //에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력
			}
		}
		private void save2() {
			FileWriter fw; //파일로 데이터를 출력하기 위한 출력 스트림을 제공
			FileWriter fw2;
			FileWriter fw3;
			String date="";
			String date2 = "";
			String date3 = "";
			
			try {
				fw = new FileWriter("txt//date.txt");
				fw2 = new FileWriter("txt//drugname.txt");
				fw3 = new FileWriter("txt//drugcount.txt");
				
				for(int i = 0; i<dateArr.size();i++) {
					date = dateArr.get(i) + "\r\n";
					date2 = drugnameArr.get(i) + "\r\n";
					date3 = drugcountArr.get(i) + "\r\n";
					fw.write(date);
					fw2.write(date2);
					fw3.write(date3);
			}
					fw.close();
					fw2.close();
					fw3.close();
					
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		new MyInfor1();
	}
}