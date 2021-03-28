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
    //�������
    private BufferedImage pic;
    private JButton tylenol, brufen, panpyrin, pancoldA, home, back;
    private JPanel imgPanel;
   
    //������
    public Headache() {
        setTitle("����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgPanel = new ChangeImagePanel();
        try {
            pic = ImageIO.read(new File("img/dongchoice.jpg")); //���Ϸκ��� �̹��� �б�
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("�̹��� ����!"); //�̹����� ���ٸ� "�̹��� ����!" ���
        }
        JPanel panel = new JPanel(); //���� ������
        panel.setLayout(new GridLayout(1, 2)); //1�� 2���� ������ ���̾ƿ��� �ۼ�
        panel.add(tylenol = new JButton("Ÿ�̷���"));
        tylenol.setForeground(Color.black);
        tylenol.setBackground(new Color(221, 221, 255));
        tylenol.setFont(new Font("����",Font.BOLD,20));
        tylenol.addActionListener(this); //tylenol ��ü�� ActionListener�� �߰�
        panel.add(brufen = new JButton("�η���"));
        brufen.setForeground(Color.black);
        brufen.setBackground(new Color(221, 221, 255));
        brufen.setFont(new Font("����",Font.BOLD,20));
        brufen.addActionListener(this);
        panel.add(panpyrin = new JButton("���Ǹ�"));
        panpyrin.setForeground(Color.black);
        panpyrin.setBackground(new Color(221, 221, 255));
        panpyrin.setFont(new Font("����",Font.BOLD,20));
        panpyrin.addActionListener(this);
        panel.add(pancoldA = new JButton("���ݿ���"));
        pancoldA.setForeground(Color.black);
        pancoldA.setBackground(new Color(221, 221, 255));
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
   
    class ChangeImagePanel extends JPanel { //�ٸ� �г�
        public ChangeImagePanel() {
        }
       
        @Override
        public void paint(Graphics g) {
            g.drawImage(pic, 0, 0, null); //pic�� ������ ��ġ�� �׸���
        }
       
        @Override
        public Dimension getPreferredSize() {//��õ ����� ������
            if (pic == null) {
                return new Dimension(200, 300); //���ο� ����, ���� ���� ���� ����
            } else {
                return new Dimension(pic.getWidth(), pic.getHeight()); //pic�� ���ο� ���� ���� ���� ����
            }
        }
    }
   
    //����޼ҵ�
    @Override
    public void actionPerformed(ActionEvent e) { //������ ��
        String imgFile = "";
       
        if (e.getSource() == tylenol) { //�̺�Ʈ�����ʸ� ����� ���� ������ ���� tylenol�� ������
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
            System.out.println("�̹��� ����!");
        }
        imgPanel.repaint(); //imgPanel�� �ٽ� ĥ�ϱ�
    }
   
    public static void main(String[] args) {
        new Headache();
    }
}