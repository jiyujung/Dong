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
 
public class SoreThroat extends JFrame implements ActionListener {
    //�������
    private BufferedImage pic;
    private JButton panpyrin, pancoldA, home, back;
    private JPanel imgPanel;
   
    //������
    public SoreThroat() {
        setTitle("�񰨱�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgPanel = new ChangeImagePanel();
        try {
            pic = ImageIO.read(new File("img/dongchoice.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("�̹��� ����!");
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(panpyrin = new JButton("���Ǹ�"));
        panpyrin.setForeground(Color.black);
        panpyrin.setBackground(new Color(150,252,177));
        panpyrin.setFont(new Font("����",Font.BOLD,20));
        panpyrin.addActionListener(this);
        panel.add(pancoldA = new JButton("���ݿ���"));
        pancoldA.setForeground(Color.black);
        pancoldA.setBackground(new Color(150,252,177));
        pancoldA.setFont(new Font("����",Font.BOLD,20));
        pancoldA.addActionListener(this);
        panel.add(home = new JButton("Ȩ"));
        home.setForeground(Color.black);
        home.setBackground(new Color(255,255,128));
        home.setFont(new Font("����",Font.BOLD,20));
        home.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent b) {
    			hide();
    			new DrugMain();
    		}
    	});
        panel.add(back = new JButton("�ڷΰ���"));
        back.setForeground(Color.black);
        back.setBackground(new Color(255,255,128));
        back.setFont(new Font("����",Font.BOLD,20));
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
   
    //����޼ҵ�
    @Override
    public void actionPerformed(ActionEvent e) {
        String imgFile = "";
       
        if (e.getSource() == panpyrin){
        	imgFile = "panpyrin.jpg";
        } else if(e.getSource() == pancoldA){
        	imgFile = "pancoldA.jpg";
        }
       
        try {
            pic = ImageIO.read(new File("img/"+ imgFile));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("�̹��� ����!");
        }
        imgPanel.repaint();
    }
   
    public static void main(String[] args) {
        new SoreThroat();
    }
}