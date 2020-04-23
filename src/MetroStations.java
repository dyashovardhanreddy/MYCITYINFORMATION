
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class MetroStations extends JFrame{
	private JPanel panel1;
	private JLabel lblTimmings;
	private JLabel lblCity;
	private JLabel lblLandmark;
	private JLabel lblMetroStations;
	private JPanel panel2;
	private ImageIcon img;
	private JComboBox cmbCity;
	private JComboBox cmbLandmarks;
	private JComboBox cmbMetrostations;
	private JTextField txtTimmings;
	private JLabel lblImage;
	private JButton btnTouristPlaces;
	private JButton btnHotels;
	private JButton btnHome;
	private ArrayList cityList;
	private ArrayList landmarkList;
	private ArrayList metroList;
	private ImageIcon iconMycity;
	private JLabel lblMycity;
	public MetroStations()
	{
		
		try{  
			cityList=new ArrayList();
			landmarkList=new ArrayList();
			metroList=new ArrayList();
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
			  
			Statement stmt=con.createStatement();  
			cityList.add("-");  
			landmarkList.add("-");
			metroList.add("-");
			ResultSet rs=stmt.executeQuery("select * from mycity");  
			while(rs.next())  
				cityList.add(rs.getString(1));
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		GridBagConstraints gbc = new GridBagConstraints();  
		lblCity=new JLabel("City:");
		lblLandmark=new JLabel("Near By:");
		lblMetroStations=new JLabel("Metro Station:");
		img=new ImageIcon(getClass().getResource("metro.jpg"));
		lblImage=new JLabel(img);
		lblTimmings=new JLabel("Timmings");
		txtTimmings=new JTextField(15);
		txtTimmings.setEditable(false);
		cmbCity=new JComboBox(cityList.toArray());
		cmbLandmarks=new JComboBox(landmarkList.toArray());
		cmbMetrostations=new JComboBox(metroList.toArray());
		panel1=new JPanel(new GridBagLayout());
		panel2=new JPanel(new GridBagLayout());
		iconMycity=new ImageIcon(getClass().getResource("mycity.jpg"));
		Image dabImage=iconMycity.getImage();
		Image modifiedDabImage=dabImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		iconMycity=new ImageIcon(modifiedDabImage);
		lblMycity=new JLabel(iconMycity);
		btnTouristPlaces=new JButton("TouristPlaces");
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
		panel2.add(btnTouristPlaces,gbc);
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
	    panel1.add(lblMetroStations);
	    panel1.add(cmbMetrostations);
	    panel1.add(lblTimmings);
	    panel1.add(txtTimmings);
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
					metroList=new ArrayList();
					metroList.add("-");
					ResultSet rs=stmt.executeQuery("select landmark from landmarks where cityname='"+cmbCity.getSelectedItem()+"'");  
					while(rs.next())
						landmarkList.add(rs.getString(1));
					rs=stmt.executeQuery("select station_name from has_metrostations where cityname='"+cmbCity.getSelectedItem()+"'");
					while(rs.next())
						metroList.add(rs.getString(1)+"");
	    			int count=cmbLandmarks.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbLandmarks.removeItemAt(0);
	    			count=cmbMetrostations.getItemCount();
	    			for(int i=0;i<count;i++)
	    				cmbMetrostations.removeItemAt(0);
	    			txtTimmings.setText("");
	    			for(int i=0;i<landmarkList.size();i++)
	    				cmbLandmarks.addItem(landmarkList.get(i));
	    			for(int i=0;i<metroList.size();i++)
	    				cmbMetrostations.addItem(metroList.get(i));
						
					  
					  
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
					metroList=new ArrayList();
					metroList.add("-");
					ResultSet rs=stmt.executeQuery("select ms.station_name from metrostations ms, has_metrostations hms where hms.cityname='"+cmbCity.getSelectedItem()+"' and hms.station_name=ms.station_name and ms.landmark='"+cmbLandmarks.getSelectedItem()+"'");  
					while(rs.next())
						metroList.add(rs.getString(1));
					int itemCount=cmbMetrostations.getItemCount();
					for(int i=0;i<itemCount;i++)
						cmbMetrostations.removeItemAt(0);
					for(int i=0;i<metroList.size();i++)
						cmbMetrostations.addItem(metroList.get(i));
					txtTimmings.setText("");  
					  
					con.close();  
					  
					}catch(Exception ex){ System.out.println(ex);}  
			}
		});
		cmbMetrostations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{  
					 
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","yasho","password");  
					  
					Statement stmt=con.createStatement();  
					   
					ResultSet rs=stmt.executeQuery("select timmings from metrostations where station_name='"+cmbMetrostations.getSelectedItem()+"'");
					while(rs.next())
					txtTimmings.setText(rs.getString(1));  
					  
					  
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
		new MetroStations();
	}

}
