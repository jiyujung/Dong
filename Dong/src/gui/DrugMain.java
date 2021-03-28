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
	/*Frame ��ü�� ���� �ߴٴ� �͸����δ� â�� ��Ÿ���� ����
	  Frame Ŭ���� �Ӽ� �߿��� ����ڿ��� ������ ������ �ƴ����� ����
	  ������ false�� �Ǿ��ֱ� ����.
	 �׷��Ƿ� â�� �����ֱ� ���� �޼ҵ带 ȣ���� ��� â�� �� �� ����.*/
	DrugMain() {
		setSize(1100, 800); //â�� ���ο� ���� ���̸� ����
		setTitle("���׸�"); //â�� Ÿ��Ʋ���� ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������â �Ϻ��� �ݱ�
		setLocationRelativeTo(null); //â ��� ����
		setResizable(false); // â�� ũ�⸦ ������ �� ����
		Container cp = getContentPane(); //Ư�� ����� �ϴ� ��ǰ �� �������� ����ִ� ����
		cp.setBackground(new Color(143, 206, 255)); //�����̳��� ���� ����
		cp.setLayout(null); //�����̳��� ��ġ������ ����
		
		JLabel drug = new JLabel("���׸� �౹�� ���� ���� ȯ���մϴ�!"); //�� ����
		drug.setFont(new Font("����",Font.BOLD,45)); //drug�� �۾�ü�� �۾� ����, �۾� ũ�⸦ ����
		drug.setLocation(140, 70); //drug�� ��ġ ����
		drug.setSize(800, 80); //drug�� ������ ����
		cp.add(drug); //�����̳ʿ� drug �ֱ�
		
		ImageIcon img = new ImageIcon("img/dong.JPG"); //ImageIcon �ν��Ͻ��� ����
		JLabel dong = new JLabel(img);
		dong.setSize(800, 800);
		dong.setLocation(-85, 45);
		cp.add(dong);
		
		JButton info = new JButton("������"); //��ư ����
		info.setLocation(820,400);
		info.setSize(200,80);
		info.setForeground(Color.black); //�۾��� ����
		info.setBackground(new Color(221, 221, 255));
		info.setFont(new Font("����",Font.BOLD,28));
		cp.add(info);
		info.addActionListener(new ActionListener() { // �̺�Ʈ �����ʸ� ���
			public void actionPerformed(ActionEvent drug) { // ��ưŬ�� �ÿ� �ߵ� �Ǵ� �޼ҵ�
				hide(); //â �����
				new DrugInfor(); //DrugInfor â ����
			}
		});
		
		JButton myinfo = new JButton("������");
		myinfo.setLocation(820,510);
		myinfo.setSize(200,80);
		myinfo.setForeground(Color.black);
		myinfo.setBackground(new Color(221, 221, 255));
		myinfo.setFont(new Font("����",Font.BOLD,28));
		cp.add(myinfo);
		myinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent my) {
				hide();
				new MyInfor1();
			}
		});
		
		JButton end = new JButton("����");
		end.setLocation(820,620);
		end.setSize(200,80);
		end.setForeground(Color.black);
		end.setBackground(new Color(221, 221, 255));
		end.setFont(new Font("����",Font.BOLD,28));
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cp.add(end);
		setVisible(true); //â�� ȭ�鿡 ��Ÿ�� ������ ����
	}
	
	public static void main(String[] args) {
		new DrugMain();
	}
}