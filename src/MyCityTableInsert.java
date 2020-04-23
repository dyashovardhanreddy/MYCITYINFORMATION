import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
public class MyCityTableInsert extends JFrame{
	private JLabel Label_cityname;
	private JTextField txt_cityname;
	private JButton button_Insert;
	private JButton button_clear;
	private JMenu MyCityTable;
	private JMenu Services;
	private JMenu Tourist_Places;
	private JMenu Has_Tourist_Places;
	private JMenu MetroStations;
	private JMenu Has_MetroStations;
	private JMenu Hotels;
	private JMenu Has_Hotels;
	private JMenuItem insert9;
	private JMenuItem view9;
	private JMenuItem delete9;
	private JMenu Landmarks;
	private JMenuBar menubar;
	private JPanel panel;
	private JMenuItem insert1;
	private JMenuItem delete1;
	private JMenuItem view1;
	private JMenuItem insert2;
	private JMenuItem delete2;
	private JMenuItem view2;
	private JMenuItem insert3;
	private JMenuItem delete3;
	private JMenuItem view3;
	private JMenuItem insert4;
	private JMenuItem delete4;
	private JMenuItem view4;
	private JMenuItem insert5;
	private JMenuItem delete5;
	private JMenuItem view5;
	private JMenuItem insert6;
	private JMenuItem delete6;
	private JMenuItem view6;
	private JMenuItem insert7;
	private JMenuItem delete7;
	private JMenuItem view7;
	private JMenuItem insert8;
	private JMenuItem delete8;
	private JMenuItem view8;
	private JLabel message;
	private JTextArea messageBox;
	private JPanel panel2;
	private JButton btnHome;
	public MyCityTableInsert()
	{
		panel=new JPanel();
		panel2=new JPanel();
		btnHome=new JButton("Home");
		panel2.setBackground(Color.DARK_GRAY);
		panel.setLayout(new FlowLayout());
		menubar=new JMenuBar();
		MyCityTable=new JMenu("MyCityTable");
		insert1=new JMenuItem("Insert");
		view1=new JMenuItem("View");
		delete1=new JMenuItem("Delete");
		MyCityTable.add(insert1);
		MyCityTable.add(view1);
		MyCityTable.add(delete1);
		Services=new JMenu("Services");
		insert2=new JMenuItem("Insert");
		view2=new JMenuItem("View");
		delete2=new JMenuItem("Delete");
		Services.add(insert2);
		Services.add(view2);
		Services.add(delete2);
		Tourist_Places=new JMenu("Tourist_Places");
		insert3=new JMenuItem("Insert");
		view3=new JMenuItem("View");
		delete3=new JMenuItem("Delete");
		Tourist_Places.add(insert3);
		Tourist_Places.add(view3);
		Tourist_Places.add(delete3);
		Has_Tourist_Places=new JMenu("Has_Tourist_Places");
		insert4=new JMenuItem("Insert");
		view4=new JMenuItem("View");
		delete4=new JMenuItem("Delete");
		Has_Tourist_Places.add(insert4);
		Has_Tourist_Places.add(view4);
		Has_Tourist_Places.add(delete4);
		MetroStations=new JMenu("MetroStations");
		insert5=new JMenuItem("Insert");
		view5=new JMenuItem("View");
		delete5=new JMenuItem("Delete");
		MetroStations.add(insert5);
		MetroStations.add(view5);
		MetroStations.add(delete5);
		Has_MetroStations=new JMenu("Has_MetroStations");
		insert6=new JMenuItem("Insert");
		view6=new JMenuItem("View");
		delete6=new JMenuItem("Delete");
		Has_MetroStations.add(insert6);
		Has_MetroStations.add(view6);
		Has_MetroStations.add(delete6);
		Hotels=new JMenu("Hotels");
		insert7=new JMenuItem("Insert");
		view7=new JMenuItem("View");
		delete7=new JMenuItem("Delete");
		Hotels.add(insert7);
		Hotels.add(view7);
		Hotels.add(delete7);
		Has_Hotels=new JMenu("Has_Hotels");
		insert8=new JMenuItem("Insert");
		view8=new JMenuItem("View");
		delete8=new JMenuItem("Delete");
		Has_Hotels.add(insert8);
		Has_Hotels.add(view8);
		Has_Hotels.add(delete8);
		this.setVisible(true);
		this.setSize(800,700);
		this.setDefaultCloseOperation(3);
		this.setJMenuBar(menubar);
		this.setTitle("MyCity Table : Insert");
		this.add(panel);
		this.add(panel2,BorderLayout.PAGE_END);
		panel2.add(btnHome);
		Label_cityname=new JLabel("CityName:");
		txt_cityname=new JTextField(20);
		button_Insert=new JButton("Insert");
		button_clear=new JButton("Clear");
		message=new JLabel("Message:");
		messageBox=new JTextArea(10,40);
		messageBox.setEditable(false);
		panel.add(Label_cityname);
		panel.add(txt_cityname);
		panel.add(button_Insert);
		panel.add(message);
		panel.add(messageBox);
		panel.add(button_clear);
		menubar.add(MyCityTable);
		menubar.add(Services);
		menubar.add(Tourist_Places);
		menubar.add(Has_Tourist_Places);
		menubar.add(MetroStations);
		menubar.add(Has_MetroStations);
		menubar.add(Hotels);
		menubar.add(Has_Hotels);
		Landmarks=new JMenu("Landmarks");
		menubar.add(Landmarks);

		insert9=new JMenuItem("Insert");
		view9=new JMenuItem("View");
		delete9=new JMenuItem("Delete");
		Landmarks.add(insert9);
		Landmarks.add(view9);
		Landmarks.add(delete9);
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Home();
				dispose();
			}
		});
		insert9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new LandmarksInsert();
				dispose();
				
			}
		});
		view9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new LandmarksView();
				dispose();
			}
		});
		delete9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new LandmarksDelete();
				dispose();
			}
			
		});
		button_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt_cityname.setText("");
				messageBox.setText("");
			}
		});
		button_Insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					
					if(txt_cityname.getText().compareTo("")==0)
					{
						JOptionPane.showMessageDialog(null, "Enter the cityname");
					}
					else
					{
						String newCityname=txt_cityname.getText();
						Statement stmt=con.createStatement();
						String query="insert into mycity values('"+newCityname+"')";
						int x=stmt.executeUpdate(query);
						con.commit();
						messageBox.setText("\n " + x + " row inserted successfully");
						
						
					}
					
					
					  
					
					con.close();  
					  
				}
				catch(Exception ex)
				{
					messageBox.setText(ex+"");
				}  
			}
		});
	insert1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyCityTableInsert();
				dispose();
			}
		});
		view1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyCityTableView();
				dispose();
			}
		});
		delete1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyCityTableDelete();
				dispose();
			}
		});
		insert2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ServicesInsert();
				dispose();
			}
		});
		view2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ServicesView();
				dispose();
			}
		});
		delete2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ServicesDelete();
				dispose();
			}
		});
		insert3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TouristPlacesInsert();
				
				dispose();
			}
		});
		view3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TouristPlacesView();
				dispose();
			}
		});
		delete3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TouristPlacesDelete();
				dispose();
			}
		});
		insert4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasTouristPlacesInsert();
				dispose();
			}
		});
		view4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasTouristPlacesView();
				dispose();
			}
		});
		delete4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasTouristPlacesDelete();
				dispose();
			}
		});
		insert5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStationsInsert();
				dispose();
			}
		});
		view5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStationsView();
				dispose();
			}
		});
		delete5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStationsDelete();
				dispose();
			}
		});
		insert6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasMetroStationsInsert();
				dispose();
			}
		});
		view6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasMetroStationView();
				dispose();
			}
		});
		delete6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasMetroStationDelete();
				dispose();
			}
		});
		insert7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HotelsInsert();
				dispose();
			}
		});
		view7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HotelsView();
				dispose();
			}
		});
		delete7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HotelsDelete();
				dispose();
			}
		});
		insert8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasHotelsInsert();
				dispose();
			}
		});
		view8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasHotelsView();
				dispose();
			}
		});
		delete8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasHotelsDelete();
				dispose();
			}
		});
	}
	public static void main(String args[])
	{
		new MyCityTableInsert();
	}
}
