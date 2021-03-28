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
 
public class AcheAllOver extends JFrame implements ActionListener {
    //멤버변수
    private BufferedImage pic;
    private JButton tylenol, panpyrin, pancoldA, tylenoljunior, home, back;
    private JPanel imgPanel;
   
    //생성자
    public AcheAllOver() {
        setTitle("몸살");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgPanel = new ChangeImagePanel();
        try {
            pic = ImageIO.read(new File("img/dongchoice.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("이미지 없음!");
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(tylenol = new JButton("타이레놀"));
        tylenol.setForeground(Color.black);
        tylenol.setBackground(new Color(221, 221, 255));
        tylenol.setFont(new Font("굴림",Font.BOLD,20));
        tylenol.addActionListener(this);
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
        panel.add(tylenoljunior = new JButton("타이레놀주니어"));
        tylenoljunior.setForeground(Color.black);
        tylenoljunior.setBackground(new Color(221, 221, 255));
        tylenoljunior.setFont(new Font("굴림",Font.BOLD,17));
        tylenoljunior.addActionListener(this);
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
   
    class ChangeImagePanel extends JPanel {
        public ChangeImagePanel() {
        }
       
        @Override
        public void paint(Graphics g) {
            g.drawImage(pic, 0, 0, null);
        }
       
        @Override
        public Dimension getPreferredSize() {
            if (pic == null) {
                return new Dimension(200, 300);
            } else {
                return new Dimension(pic.getWidth(), pic.getHeight());
            }
        }
    }
   
    //멤버메소드
    @Override
    public void actionPerformed(ActionEvent e) {
        String imgFile = "";
       
        if (e.getSource() == tylenol) {
            imgFile = "tylenol.jpg";
        } else if(e.getSource() == panpyrin){
        	imgFile = "panpyrin.jpg";
        } else if(e.getSource() == pancoldA){
        	imgFile = "pancoldA.jpg";
        } else if(e.getSource() == tylenoljunior){
        	imgFile = "tylenoljunior.jpg";
        } 
       
        try {
            pic = ImageIO.read(new File("img/"+ imgFile));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("이미지 없음!");
        }
        imgPanel.repaint();
    }
   
    public static void main(String[] args) {
        new AcheAllOver();
    }
}