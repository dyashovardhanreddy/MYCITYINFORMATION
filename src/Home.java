import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Home extends JFrame{
	private JPanel panel1;
	private JPanel panel2;
	private JButton btnMycity;
	private JButton btnLandmarks;
	private JButton btnServices;
	private JButton btnHotels;
	private JButton btnMetrostations;
	private JButton btnTouristplaces;
	private JButton btnHas_Hotels;
	private JButton btnHas_metrostations;
	private JButton btnHas_touristplaces;
	private JButton btnCustomer;
	public Home()
	{
		panel1=new JPanel(new GridLayout(3,3,15,15));
		panel2=new JPanel();
		btnMetrostations=new JButton("Metro Stations");
		btnMetrostations.setBackground(Color.orange);
		btnHas_Hotels=new JButton("Has Hotels");
		btnHas_Hotels.setBackground(Color.ORANGE);
		btnHas_metrostations=new JButton("Has Metro Stations");
		btnHas_metrostations.setBackground(Color.orange);
		btnHas_touristplaces=new JButton("Has Tourist Places");
		btnHas_touristplaces.setBackground(Color.ORANGE);
		btnHotels=new JButton("Hotels");
		btnHotels.setBackground(Color.ORANGE);
		btnLandmarks=new JButton("Landmark");
		btnLandmarks.setBackground(Color.ORANGE);
		btnMycity=new JButton("My City");
		btnMycity.setBackground(Color.ORANGE);
		btnServices=new JButton("Services");
		btnServices.setBackground(Color.ORANGE);
		btnTouristplaces=new JButton("Tourist Places");
		btnTouristplaces.setBackground(Color.ORANGE);
		btnCustomer=new JButton("Go To User Interface");
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.DARK_GRAY);
		panel1.add(btnMycity);
		panel1.add(btnServices);
		panel1.add(btnLandmarks);
		panel1.add(btnHotels);
		panel1.add(btnMetrostations);
		panel1.add(btnTouristplaces);
		panel1.add(btnHas_Hotels);
		panel1.add(btnHas_metrostations);
		panel1.add(btnHas_touristplaces);
		panel2.add(btnCustomer);
		this.setVisible(true);
		this.setSize(600,400);
		this.setDefaultCloseOperation(3);
		this.add(panel1,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.PAGE_END);
		btnHas_Hotels.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasHotelsView();
				dispose();
			}
		});
		btnHas_metrostations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasMetroStationView();
				dispose();
			}
		});
		btnHas_touristplaces.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HasTouristPlacesView();
				dispose();
			}
		});
		btnHotels.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HotelsView();
				dispose();
			}
		});
		btnLandmarks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LandmarksView();
				dispose();
			}
		});
		btnMetrostations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStationsView();
				dispose();
			}
		});
		btnMycity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyCityTableView();
				dispose();
			}
		});
		btnServices.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ServicesView();
				dispose();
			}
		});
		btnTouristplaces.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TouristPlacesView();
				dispose();
			}
		});
		btnCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MetroStations();
				dispose();
			}
		});
	}
	public static void main(String args[])
	{
		new Home();
	}

}
