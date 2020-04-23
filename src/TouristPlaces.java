
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class TouristPlaces extends JFrame{
	private JPanel panel1;
	private JLabel lblRating;
	private JLabel lblCity;
	private JLabel lblLandmark;
	private JLabel lblTouristPlace;
	private JPanel panel2;
	private ImageIcon img;
	private JComboBox cmbCity;
	private JComboBox cmbLandmarks;
	private JComboBox cmbTouristPlace;
	private JTextField txtRating;
	private JLabel lblImage;
	private JButton btnMetroStation;
	private JButton btnHotels;
	private JButton btnHome;
	private ArrayList cityList;
	private ArrayList landmarkList;
	private ArrayList touristPlaceList;
	private ImageIcon iconMycity;
	private JLabel lblMycity;
	public TouristPlaces()
	{
		
		try{  
			cityList=new ArrayList();
			landmarkList=new ArrayList();
			touristPlaceList=new ArrayList();
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
			  
			Statement stmt=con.createStatement();  
			cityList.add("-");  
			landmarkList.add("-");
			touristPlaceList.add("-");
			ResultSet rs=stmt.executeQuery("select * from mycity");  
			while(rs.next())  
				cityList.add(rs.getString(1));
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		GridBagConstraints gbc = new GridBagConstraints();  
		lblCity=new JLabel("City:");
		lblLandmark=new JLabel("Near By:");
		lblTouristPlace=new JLabel("Tourit Places:");
		img=new ImageIcon(getClass().getResource("TouristPlaces.jpg"));
		Image dabImage=img.getImage();
		Image modifiedDabImage=dabImage.getScaledInstance(320, 320, java.awt.Image.SCALE_SMOOTH);
		img=new ImageIcon(modifiedDabImage);
		lblImage=new JLabel(img);
		lblRating=new JLabel("Rating");
		txtRating=new JTextField(4);
		txtRating.setEditable(false);
		iconMycity=new ImageIcon(getClass().getResource("mycity.jpg"));
		dabImage=iconMycity.getImage();
		modifiedDabImage=dabImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		iconMycity=new ImageIcon(modifiedDabImage);
		lblMycity=new JLabel(iconMycity);
		cmbCity=new JComboBox(cityList.toArray());
		cmbLandmarks=new JComboBox(landmarkList.toArray());
		cmbTouristPlace=new JComboBox(touristPlaceList.toArray());
		panel1=new JPanel(new GridBagLayout());
		panel2=new JPanel(new GridBagLayout());
		btnMetroStation=new JButton("Metro Station");
		btnHotels=new JButton("      Hotels       ");
		btnHome=new   JButton("       Home         ");
		panel1.setBackground(Color.YELLOW);
		panel2.setBackground(Color.DARK_GRAY);
		this.setSize(1200,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.add(panel1,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.WEST);
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(20,0,0,0);
		gbc.gridx = 0;  
	    gbc.gridy = 0;
	    panel2.add(lblMycity,gbc);
		gbc.insets = new Insets(20,0,0,0);
		gbc.gridx = 0;  
	    gbc.gridy = 1;  
		panel2.add(btnMetroStation,gbc);
		gbc.gridx = 0;  
	    gbc.gridy = 2;  
	    panel2.add(btnHotels,gbc);
	    gbc.gridx = 0;  
	    gbc.gridy = 3;
	    panel2.add(btnHome,gbc);
	    gbc.gridx = 0;  
	    gbc.gridy = 4; 
	    panel2.add(lblImage,gbc);
	    panel1.add(lblCity);
	    panel1.add(cmbCity);
	    panel1.add(lblLandmark);
	    panel1.add(cmbLandmarks);
	    panel1.add(lblTouristPlace);
	    panel1.add(cmbTouristPlace);
	    panel1.add(lblRating);
	    panel1.add(txtRating);
	    cmbCity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					landmarkList=new ArrayList();
					landmarkList.add("-");
					touristPlaceList=new ArrayList();
					touristPlaceList.add("-");
					ResultSet rs=stmt.executeQuery("select landmark from landmarks where cityname='"+cmbCity.getSelectedItem()+"'");  
					while(rs.next())
						landmarkList.add(rs.getString(1));
					rs=stmt.executeQuery("select place_name from has_tourist_places where cityname='"+cmbCity.getSelectedItem()+"'");
					while(rs.next())
						touristPlaceList.add(rs.getString(1)+"");
	    			int count=cmbLandmarks.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbLandmarks.removeItemAt(0);
	    			count=cmbTouristPlace.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbTouristPlace.removeItemAt(0);
	    			txtRating.setText("");
	    			for(int i=0;i<landmarkList.size();i++)
	    				cmbLandmarks.addItem(landmarkList.get(i));
	    			for(int i=0;i<touristPlaceList.size();i++)
	    				cmbTouristPlace.addItem(touristPlaceList.get(i));
						
					  
					  
					con.close();  
					  
					}catch(Exception ex){ System.out.println(ex);}  
			}
		});
	    cmbLandmarks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					touristPlaceList=new ArrayList();
					touristPlaceList.add("-");
					ResultSet rs=stmt.executeQuery("select tp.place_name from tourist_places tp, has_tourist_places htp where htp.cityname='"+cmbCity.getSelectedItem()+"' and htp.place_name=tp.place_name and tp.landmark='"+cmbLandmarks.getSelectedItem()+"'");  
					while(rs.next())
						touristPlaceList.add(rs.getString(1));
					int itemCount=cmbTouristPlace.getItemCount();
					for(int i=0;i<itemCount;i++)
						cmbTouristPlace.removeItemAt(0);
					for(int i=0;i<touristPlaceList.size();i++)
						cmbTouristPlace.addItem(touristPlaceList.get(i));
					txtRating.setText("");  
					  
					con.close();  
					  
					}catch(Exception ex){ System.out.println(ex);}  
			}
		});
		cmbTouristPlace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					   
					ResultSet rs=stmt.executeQuery("select rating from tourist_places where place_name='"+cmbTouristPlace.getSelectedItem()+"'");
					while(rs.next())
					txtRating.setText(rs.getString(1));  
					  
					  
					con.close();  
					  
					}catch(Exception ex){ System.out.println(ex);}  
			}
		});
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Home();
				dispose();
			}
		});
		btnHotels.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Hotels();
				dispose();
			}
		});
		btnMetroStation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStations();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TouristPlaces();
	}

}
