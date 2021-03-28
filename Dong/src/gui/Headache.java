package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Headache extends JFrame implements ActionListener {
    //멤버변수
    private BufferedImage pic;
    private JButton tylenol, brufen, panpyrin, pancoldA, home, back;
    private JPanel imgPanel;
   
    //생성자
    public Headache() {
        setTitle("두통");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgPanel = new ChangeImagePanel();
        try {
            pic = ImageIO.read(new File("img/dongchoice.jpg")); //파일로부터 이미지 읽기
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("이미지 없음!"); //이미지가 없다면 "이미지 없음!" 출력
        }
        JPanel panel = new JPanel(); //보조 프레임
        panel.setLayout(new GridLayout(1, 2)); //1행 2열로 구성된 레이아웃을 작성
        panel.add(tylenol = new JButton("타이레놀"));
        tylenol.setForeground(Color.black);
        tylenol.setBackground(new Color(221, 221, 255));
        tylenol.setFont(new Font("굴림",Font.BOLD,20));
        tylenol.addActionListener(this); //tylenol 객체에 ActionListener를 추가
        panel.add(brufen = new JButton("부루펜"));
        brufen.setForeground(Color.black);
        brufen.setBackground(new Color(221, 221, 255));
        brufen.setFont(new Font("굴림",Font.BOLD,20));
        brufen.addActionListener(this);
        panel.add(panpyrin = new JButton("판피린"));
        panpyrin.setForeground(Color.black);
        panpyrin.setBackground(new Color(221, 221, 255));
        panpyrin.setFont(new Font("굴림",Font.BOLD,20));
        panpyrin.addActionListener(this);
        panel.add(pancoldA = new JButton("판콜에이"));
        pancoldA.setForeground(Color.black);
        pancoldA.setBackground(new Color(221, 221, 255));
        pancoldA.setFont(new Font("굴림",Font.BOLD,20));
        pancoldA.addActionListener(this);
        panel.add(home = new JButton("홈"));
        home.setForeground(Color.black);
        home.setBackground(new Color(255,255,128));
        home.setFont(new Font("굴림",Font.BOLD,20));
        home.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent b) {
    			hide();
    			new DrugMain();
    		}
    	});
        panel.add(back = new JButton("뒤로가기"));
        back.setForeground(Color.black);
        back.setBackground(new Color(255,255,128));
        back.setFont(new Font("굴림",Font.BOLD,20));
        back.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent bt6) {
    			hide();
    			new DrugInfor();
    		}
    	});
       
        add(imgPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        pack();
        setSize(1100, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
    class ChangeImagePanel extends JPanel { //다른 패널
        public ChangeImagePanel() {
        }
       
        @Override
        public void paint(Graphics g) {
            g.drawImage(pic, 0, 0, null); //pic을 지정된 위치에 그리기
        }
       
        @Override
        public Dimension getPreferredSize() {//추천 사이즈를 돌려줌
            if (pic == null) {
                return new Dimension(200, 300); //새로운 가로, 세로 길이 값을 리턴
            } else {
                return new Dimension(pic.getWidth(), pic.getHeight()); //pic의 가로와 세로 길이 값을 리턴
            }
        }
    }
   
    //멤버메소드
    @Override
    public void actionPerformed(ActionEvent e) { //실행할 것
        String imgFile = "";
       
        if (e.getSource() == tylenol) { //이벤트리스너를 등록한 것을 실행한 것이 tylenol과 같으면
            imgFile = "tylenol.jpg";
        } else if(e.getSource() == brufen){
            imgFile = "brufen.jpg";
        } else if(e.getSource() == panpyrin){
        	imgFile = "panpyrin.jpg";
        } else if(e.getSource() == pancoldA){
        	imgFile = "pancoldA.jpg";
        }
       
        try {
            pic = ImageIO.read(new File("img/"+ imgFile));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("이미지 없음!");
        }
        imgPanel.repaint(); //imgPanel에 다시 칠하기
    }
   
    public static void main(String[] args) {
        new Headache();
    }
}