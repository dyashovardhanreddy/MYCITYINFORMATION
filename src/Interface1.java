import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Interface1 extends JFrame{
	private JPanel panel1;
	private JPanel panel2;
	private JButton btnHome;
	private ImageIcon iconMycity;
	private JLabel lblMycity;
	private ImageIcon iconTiitle;
	public Interface1()
	{
		panel1=new JPanel(new BorderLayout());
		panel1.setBackground(Color.WHITE);
		panel2=new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		btnHome=new JButton("Home");
		iconMycity=new ImageIcon(getClass().getResource("mycity.jpg"));
		Image dabImage=iconMycity.getImage();
		Image modifiedDabImage=dabImage.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		iconMycity=new ImageIcon(modifiedDabImage);
		lblMycity=new JLabel(iconMycity);
		this.add(panel1,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.PAGE_END);
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Mycity.jpg")));
		panel2.add(btnHome);
		panel1.add(lblMycity,BorderLayout.CENTER);
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Home();
				dispose();
			}
		});

	}
	public static void main(String args[])
	{
		new Interface1();
	}
}
