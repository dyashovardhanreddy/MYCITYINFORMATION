import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon;
public class HasTouristPlacesDelete extends JFrame{
	private JPanel panel;
	private JPanel panel2;
	private JButton btnHome;
	private JLabel lblselectcityname;
	private JLabel lblselectplacename;
	private JLabel lblcityname;
	private JLabel lblplacename;
	private JComboBox< String> cmbcityname;
	private JComboBox<String> cmbplacename;
	private JTextField txtcityname;
	private JTextField txtplacename;
	private JTextArea txtmessage;
	private JButton btndelete;
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
	private ArrayList cityList;
	private ArrayList placeList;
	public HasTouristPlacesDelete()
	{
		try{  
			 cityList=new ArrayList();
			 cityList.add("-");
			 placeList=new ArrayList();
			 placeList.add("-");
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
			  
			Statement stmt=con.createStatement();  
			   
			ResultSet rs=stmt.executeQuery("select distinct cityname from has_tourist_places");  
			while(rs.next())  
				cityList.add(rs.getString(1));
			  
			  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}
		panel2=new JPanel();
		btnHome=new JButton("Home");
		panel2.setBackground(Color.DARK_GRAY);
		panel=new JPanel(new FlowLayout());
		lblselectcityname=new JLabel("Select CityName:");
		lblselectplacename=new JLabel("Select Placename:");
		lblcityname=new JLabel("Cityname:");
		lblplacename=new JLabel("PlaceName:");
		cmbcityname=new JComboBox(cityList.toArray());
		cmbplacename=new JComboBox(placeList.toArray());
		txtcityname=new JTextField(20);
		txtplacename=new JTextField(20);
		txtmessage=new JTextArea(10,40);
		btndelete=new JButton("Delete");
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
		this.setSize(1000, 500);
		this.setTitle("Has Tourist Places : Delete");
		this.setJMenuBar(menubar);
		this.setDefaultCloseOperation(3);
		this.add(panel);
		this.add(panel2,BorderLayout.PAGE_END);
		panel2.add(btnHome);
		panel.add(lblselectcityname);
		panel.add(cmbcityname);
		panel.add(lblselectplacename);
		panel.add(cmbplacename);
		panel.add(lblcityname);
		panel.add(txtcityname);
		panel.add(lblplacename);
		panel.add(txtplacename);
		panel.add(btndelete);
		panel.add(txtmessage);
		menubar.add(MyCityTable);
		menubar.add(Services);
		menubar.add(Tourist_Places);
		menubar.add(Has_Tourist_Places);
		menubar.add(MetroStations);
		menubar.add(Has_MetroStations);
		menubar.add(Hotels);
		menubar.add(Has_Hotels);
		txtcityname.setEditable(false);
		txtplacename.setEditable(false);
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
		cmbcityname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					placeList=new ArrayList();   
					ResultSet rs=stmt.executeQuery("select place_name from has_tourist_places where cityname='"+cmbcityname.getSelectedItem()+"'");  
					while(rs.next())  
						placeList.add(rs.getString(1));
					int count=cmbplacename.getItemCount();
					for(int i=0;i<count;i++)
						cmbplacename.removeItemAt(0);
					for(int i=0;i<placeList.size();i++)
					{
						cmbplacename.addItem(placeList.get(i)+"");
					}
					  
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
			}
		});
		cmbplacename.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtcityname.setText(cmbcityname.getSelectedItem()+"");
				txtplacename.setText(cmbplacename.getSelectedItem()+"");
			}
		});
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					   
					int rows=stmt.executeUpdate("delete from has_tourist_places where cityname='"+txtcityname.getText()+"' and place_name='"+txtplacename.getText()+"'");  
					txtmessage.setText("Deleted "+rows+" row");
					con.commit();
					cityList=new ArrayList();
					cityList.add("-");
					ResultSet rs=stmt.executeQuery("select distinct cityname from has_tourist_places");  
					while(rs.next())  
						cityList.add(rs.getString(1));
					int count=cmbcityname.getItemCount();
					for(int i=0;i<count;i++)
						cmbcityname.removeItemAt(0);
					for(int i=0;i<cityList.size();i++)
						cmbcityname.addItem(cityList.get(i)+"");
					placeList=new ArrayList();
					rs=stmt.executeQuery("select place_name from has_tourist_places where cityname='"+cmbcityname.getSelectedItem()+"'"); 
					while(rs.next())  
						placeList.add(rs.getString(1));
					count=cmbplacename.getItemCount();
					for(int i=0;i<count;i++)
						cmbplacename.removeItemAt(0);
					for(int i=0;i<placeList.size();i++)
					{
					cmbplacename.addItem(placeList.get(i)+"");
					}
					  
					  
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HasTouristPlacesDelete();
	}

}
