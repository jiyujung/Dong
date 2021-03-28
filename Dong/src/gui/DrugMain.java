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

public class DrugMain extends JFrame{
	/*Frame 객체를 생성 했다는 것만으로는 창이 나타나지 않음
	  Frame 클래스 속성 중에서 사용자에게 보여줄 것인지 아닌지에 대한
	  설정이 false로 되어있기 때문.
	 그러므로 창을 보여주기 위한 메소드를 호출해 줘야 창을 볼 수 있음.*/
	DrugMain() {
		setSize(1100, 800); //창의 가로와 세로 길이르 설정
		setTitle("동그리"); //창의 타이틀바의 내용을 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우창 완벽히 닫기
		setLocationRelativeTo(null); //창 가운데 띄우기
		setResizable(false); // 창의 크기를 조절할 수 없게
		Container cp = getContentPane(); //특정 기능을 하는 제품 및 자제들을 담아주는 역할
		cp.setBackground(new Color(143, 206, 255)); //컨테이너의 배경색 설정
		cp.setLayout(null); //컨테이너의 배치관리자 제거
		
		JLabel drug = new JLabel("동그리 약국에 오신 것을 환영합니다!"); //라벨 생성
		drug.setFont(new Font("굴림",Font.BOLD,45)); //drug의 글씨체와 글씨 굵기, 글씨 크기를 설정
		drug.setLocation(140, 70); //drug의 위치 설정
		drug.setSize(800, 80); //drug의 사이즈 설정
		cp.add(drug); //컨테이너에 drug 넣기
		
		ImageIcon img = new ImageIcon("img/dong.JPG"); //ImageIcon 인스턴스를 생성
		JLabel dong = new JLabel(img);
		dong.setSize(800, 800);
		dong.setLocation(-85, 45);
		cp.add(dong);
		
		JButton info = new JButton("약정보"); //버튼 생성
		info.setLocation(820,400);
		info.setSize(200,80);
		info.setForeground(Color.black); //글씨색 설정
		info.setBackground(new Color(221, 221, 255));
		info.setFont(new Font("굴림",Font.BOLD,28));
		cp.add(info);
		info.addActionListener(new ActionListener() { // 이벤트 리스너를 등록
			public void actionPerformed(ActionEvent drug) { // 버튼클릭 시에 발동 되는 메소드
				hide(); //창 숨기기
				new DrugInfor(); //DrugInfor 창 띄우기
			}
		});
		
		JButton myinfo = new JButton("내관리");
		myinfo.setLocation(820,510);
		myinfo.setSize(200,80);
		myinfo.setForeground(Color.black);
		myinfo.setBackground(new Color(221, 221, 255));
		myinfo.setFont(new Font("굴림",Font.BOLD,28));
		cp.add(myinfo);
		myinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent my) {
				hide();
				new MyInfor1();
			}
		});
		
		JButton end = new JButton("종료");
		end.setLocation(820,620);
		end.setSize(200,80);
		end.setForeground(Color.black);
		end.setBackground(new Color(221, 221, 255));
		end.setFont(new Font("굴림",Font.BOLD,28));
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cp.add(end);
		setVisible(true); //창을 화면에 나타낼 것인지 설정
	}
	
	public static void main(String[] args) {
		new DrugMain();
	}
}