

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Hotels extends JFrame{
	private JPanel panel1;
	private JLabel lblPhone;
	private JLabel lblRating;
	private JLabel lblCity;
	private JLabel lblLandmark;
	private JLabel lblHotel;
	private JPanel panel2;
	private ImageIcon img1;
	private JComboBox cmbCity;
	private JComboBox cmbLandmarks;
	private JComboBox cmbHotel;
	private JTextField txtRating;
	private JTextField txtPhone;
	private JLabel lblImage1;
	private JButton btnMetroStation;
	private JButton btnTouristPlaces;
	private JButton btnHome;
	private ArrayList cityList;
	private ArrayList landmarkList;
	private ArrayList hotelsList;
	private ImageIcon iconMycity;
	private JLabel lblMycity;
	public Hotels()
	{
		
		try{  
			cityList=new ArrayList();
			landmarkList=new ArrayList();
			hotelsList=new ArrayList();
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
			  
			Statement stmt=con.createStatement();  
			cityList.add("-");  
			landmarkList.add("-");
			hotelsList.add("-");
			ResultSet rs=stmt.executeQuery("select * from mycity");  
			while(rs.next())  
				cityList.add(rs.getString(1));
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		GridBagConstraints gbc = new GridBagConstraints();  
		lblCity=new JLabel("City:");
		lblLandmark=new JLabel("Near By:");
		lblHotel=new JLabel("Hotels:");
		img1=new ImageIcon(getClass().getResource("Restaurants.jpg"));
		Image dabImage=img1.getImage();
		Image modifiedDabImage=dabImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		img1=new ImageIcon(modifiedDabImage);
		lblImage1=new JLabel(img1);
		iconMycity=new ImageIcon(getClass().getResource("mycity.jpg"));
		dabImage=iconMycity.getImage();
		modifiedDabImage=dabImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		iconMycity=new ImageIcon(modifiedDabImage);
		lblMycity=new JLabel(iconMycity);
		lblRating=new JLabel("Rating");
		txtRating=new JTextField(4);
		lblPhone=new JLabel("Phone Number:");
		txtPhone=new JTextField(11);
		txtPhone.setEditable(false);
		txtRating.setEditable(false);
		cmbCity=new JComboBox(cityList.toArray());
		cmbLandmarks=new JComboBox(landmarkList.toArray());
		cmbHotel=new JComboBox(hotelsList.toArray());
		panel1=new JPanel(new GridBagLayout());
		panel2=new JPanel(new GridBagLayout());
		btnMetroStation=new JButton("Metro Station");
		btnTouristPlaces=new JButton("Toursit Places");
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
	    panel2.add(btnTouristPlaces,gbc);
	    gbc.gridx = 0;  
	    gbc.gridy = 3;
	    panel2.add(btnHome,gbc);
	    gbc.gridx = 0;  
	    gbc.gridy = 4; 
	    panel2.add(lblImage1,gbc);
	    panel1.add(lblCity);
	    panel1.add(cmbCity);
	    panel1.add(lblLandmark);
	    panel1.add(cmbLandmarks);
	    panel1.add(lblHotel);
	    panel1.add(cmbHotel);
	    panel1.add(lblRating);
	    panel1.add(txtRating);
	    panel1.add(lblPhone);
	    panel1.add(txtPhone);
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
					hotelsList=new ArrayList();
					hotelsList.add("-");
					ResultSet rs=stmt.executeQuery("select landmark from landmarks where cityname='"+cmbCity.getSelectedItem()+"'");  
					while(rs.next())
						landmarkList.add(rs.getString(1));
					rs=stmt.executeQuery("select hotel_name from has_hotels where cityname='"+cmbCity.getSelectedItem()+"'");
					while(rs.next())
						hotelsList.add(rs.getString(1)+"");
	    			int count=cmbLandmarks.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbLandmarks.removeItemAt(0);
	    			count=cmbHotel.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbHotel.removeItemAt(0);
	    			txtRating.setText("");
	    			txtPhone.setText("");
	    			for(int i=0;i<landmarkList.size();i++)
	    				cmbLandmarks.addItem(landmarkList.get(i));
	    			for(int i=0;i<hotelsList.size();i++)
	    				cmbHotel.addItem(hotelsList.get(i));
						
					  
					  
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
					hotelsList=new ArrayList();
					hotelsList.add("-");
					ResultSet rs=stmt.executeQuery("select h.hotel_name from hotels h, has_hotels hh where hh.cityname='"+cmbCity.getSelectedItem()+"' and hh.hotel_name=h.hotel_name and h.landmark='"+cmbLandmarks.getSelectedItem()+"'");  
					while(rs.next())
						hotelsList.add(rs.getString(1));
					int itemCount=cmbHotel.getItemCount();
					for(int i=0;i<itemCount;i++)
						cmbHotel.removeItemAt(0);
					for(int i=0;i<hotelsList.size();i++)
						cmbHotel.addItem(hotelsList.get(i));
					txtRating.setText("");  
					txtPhone.setText("");  
					con.close();  
					  
					}catch(Exception ex){ System.out.println(ex);}  
			}
		});
		cmbHotel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					   
					ResultSet rs=stmt.executeQuery("select rating,phone_number from hotels where hotel_name='"+cmbHotel.getSelectedItem()+"'");
					while(rs.next())
					{
						txtRating.setText(rs.getString(1));
						txtPhone.setText(rs.getString(2));
					}  
					
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
		btnMetroStation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStations();
			}
		});
		btnTouristPlaces.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				new TouristPlaces();
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hotels();
	}

}
