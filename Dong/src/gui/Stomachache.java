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
 
public class Stomachache extends JFrame implements ActionListener {
    //�������
    private BufferedImage pic;
    private JButton bearse, festalplus, gas, mexolon, drbearse, home, back;
    private JPanel imgPanel;
   
    //������
    public Stomachache() {
        setTitle("����");
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
        panel.add(bearse = new JButton("������"));;
        bearse.setForeground(Color.black);
        bearse.setBackground(new Color(221, 221, 255));
		bearse.setFont(new Font("����",Font.BOLD,20));
        bearse.addActionListener(this);
        panel.add(festalplus = new JButton("�ѽ�Ż�÷���"));
        festalplus.setForeground(Color.black);
        festalplus.setBackground(new Color(221, 221, 255));
        festalplus.setFont(new Font("����",Font.BOLD,17));
        festalplus.addActionListener(this);
        panel.add(gas = new JButton("�Ȱ"));
        gas.setForeground(Color.black);
        gas.setBackground(new Color(221, 221, 255));
        gas.setFont(new Font("����",Font.BOLD,20));
        gas.addActionListener(this);
        panel.add(mexolon = new JButton("�߼ҷ� ����"));
        mexolon.setForeground(Color.black);
        mexolon.setBackground(new Color(221, 221, 255));
        mexolon.setFont(new Font("����",Font.BOLD,17));
        mexolon.addActionListener(this);
        panel.add(drbearse = new JButton("���ͺ�����"));;
        drbearse.setForeground(Color.black);
        drbearse.setBackground(new Color(221, 221, 255));
        drbearse.setFont(new Font("����",Font.BOLD,20));
        drbearse.addActionListener(this);
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
       
        if (e.getSource() == bearse) {
            imgFile = "bearse.jpg";
        } else if(e.getSource() == festalplus){
            imgFile = "festalplus.jpg";
        } else if(e.getSource() == gas){
        	imgFile = "gas.jpg";
        } else if(e.getSource() == mexolon){
        	imgFile = "mexolon.jpg";
        } else if(e.getSource() == drbearse){
        	imgFile = "drbearse.jpg";
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
        new Stomachache();
    }
}