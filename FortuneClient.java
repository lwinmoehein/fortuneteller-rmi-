

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FortuneClient extends JFrame {

	public  JPanel above,bottom;
	public JTextField name;
	public JTextField age;
	public DatePicker datePicker1 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FortuneClient frame = new FortuneClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FortuneClient() {
		setBackground(Color.ORANGE);
		setTitle("Fortune Teller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(200,200));
		setBounds(100, 100, 450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		above = new JPanel();
		bottom=new JPanel();
		
		
		
		above.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(above,BorderLayout.NORTH);
		this.add(bottom,BorderLayout.SOUTH);
		
		above.setLayout(new GridLayout(3,2));
		
		
		
		
		
		JLabel lblEnterYourName = new JLabel("Enter your name");
		above.add(lblEnterYourName);
		

		name = new JTextField();
		above.add(name);
		name.setColumns(10);
		
		JLabel lblEnterYourAge = new JLabel("Enter Your age");
		above.add(lblEnterYourAge);
		
		age = new JTextField();
		age.setSize(100, 20);
		above.add(age);
		age.setColumns(10);
		JLabel lblEnterBirth = new JLabel("Enter Your birthday");
		above.add(lblEnterBirth);
		
		datePicker1= new DatePicker();
		above.add(datePicker1);
		
		JButton calculatefortune=new JButton("Calculate Fortune");
		bottom.add(calculatefortune);
		
		calculatefortune.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					calculateFortune();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
	}

	public void calculateFortune() throws MalformedURLException, RemoteException, NotBoundException {
		String uname=this.name.getText().toString();
		int age=Integer.parseInt(this.age.getText().toString());
		String birthday=this.datePicker1.getText().toString();
		
		
		CalculateFortune fortune=(CalculateFortune)Naming.lookup("rmi://localhost:1099/fortune");
		JOptionPane.showMessageDialog(null, fortune.calculate(uname,age,birthday));

		
	}

}
