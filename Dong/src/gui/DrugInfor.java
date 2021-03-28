package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DrugInfor extends JFrame{
	DrugInfor() {
	setSize(1100, 800);
	setTitle("약정보");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	Container cp = getContentPane();
	cp.setBackground(new Color(143, 206, 255));
	cp.setLayout(null);
	
	JButton headache = new JButton("두통");
	headache.setLocation(280,50);
	headache.setSize(200,80);
	headache.setForeground(Color.black);
	headache.setBackground(new Color(221, 221, 255));
	headache.setFont(new Font("굴림",Font.BOLD,28));
	cp.add(headache);
	headache.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent headache) {
			hide();
			new Headache();
		}
	});
	
	JButton stomachache = new JButton("복통");
	stomachache.setLocation(630,50);
	stomachache.setSize(200,80);
	stomachache.setForeground(Color.black);
	stomachache.setBackground(new Color(221, 221, 255));
	stomachache.setFont(new Font("굴림",Font.BOLD,28));
	cp.add(stomachache);
	stomachache.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent stomachache) {
			hide();
			new Stomachache();
		}
	});
	
	JButton acheAllOver = new JButton("몸살");
	acheAllOver.setLocation(120,230);
	acheAllOver.setSize(200,80);
	acheAllOver.setForeground(Color.black);
	acheAllOver.setBackground(new Color(221, 221, 255));
	acheAllOver.setFont(new Font("굴림",Font.BOLD,28));
	cp.add(acheAllOver);
	acheAllOver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent acheAllOver) {
			hide();
			new AcheAllOver();
		}
	});
	
	JButton menstrualPain = new JButton("생리통");
	menstrualPain.setLocation(450,230);
	menstrualPain.setSize(200,80);
	menstrualPain.setForeground(Color.black);
	menstrualPain.setBackground(new Color(221, 221, 255));
	menstrualPain.setFont(new Font("굴림",Font.BOLD,28));
	cp.add(menstrualPain);
	menstrualPain.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent menstrualPain) {
			hide();
			new MenstrualPain();
		}
	});
	
	JButton soreThroat = new JButton("목감기");
	soreThroat.setLocation(790,230);
	soreThroat.setSize(200,80);
	soreThroat.setForeground(Color.black);
	soreThroat.setBackground(new Color(221, 221, 255));
	soreThroat.setFont(new Font("굴림",Font.BOLD,28));
	cp.add(soreThroat);
	soreThroat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent soreThroat) {
			hide();
			new SoreThroat();
		}
	});
	
	ImageIcon img = new ImageIcon("img/smalldong.JPG");
	JLabel dong = new JLabel(img);
	dong.setSize(400, 400);
	dong.setLocation(-30, 380);
	cp.add(dong);
	
	JLabel drug = new JLabel("위에서 증상을 선택해 주세요!!");
	drug.setFont(new Font("굴림",Font.BOLD,30));
	drug.setLocation(300, 400);
	//drug.setForeground(Color.BLUE);   //글자색
	drug.setOpaque(true); // 배경색 바꾸기 위해 true로 설정
    drug.setBackground(new Color(143, 206, 255));
	drug.setSize(450, 80);
	cp.add(drug);
	
	JButton home = new JButton("홈");
	home.setLocation(950,650);
	home.setSize(120,40);
	home.setForeground(Color.black);
	home.setBackground(new Color(221, 221, 255));
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
	back.setBackground(new Color(221, 221, 255));
	back.setFont(new Font("굴림",Font.BOLD,20));
	cp.add(back);
	back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent my) {
			hide();
			new DrugMain();
		}
	});
	setVisible(true);
	}
}