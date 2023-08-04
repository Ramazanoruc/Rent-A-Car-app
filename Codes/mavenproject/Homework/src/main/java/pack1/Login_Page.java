package pack1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login_Page extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtpassword;

	/**
	 * Launch the application.
	 */
	
	
	
	
	public  boolean checkLogin(String username,String password) {
		
		boolean validuser=false;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(String.format( "select * from user where username  = '%s' and password = '%s'",
					txtusername.getText(),
					txtpassword.getText()));
			
			if(rs.next()) {
				validuser=true;
				Manager user = new Manager();
				user.userId=rs.getInt(1);
				user.name=rs.getString(2);
				user.surname=rs.getString(3);
				user.username=rs.getString(4);
				user.password=rs.getString(5);
				
				
			}
			else {
				validuser=false;
				
			}
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return validuser;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page frame = new Login_Page();
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
	public Login_Page() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(86, 22, 79, 45);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(86, 69, 79, 45);
		panel.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtusername.setBounds(183, 34, 111, 21);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpassword.setColumns(10);
		txtpassword.setBounds(183, 81, 111, 21);
		panel.add(txtpassword);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin(txtusername.getText(),txtpassword.getText())) {
					After_Login after_login = new After_Login();
					after_login.setVisible(true);
					dispose();
					
					
				}
				else {
					JOptionPane.showMessageDialog(panel,"Login Failed" );
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnlogin.setBounds(77, 135, 111, 37);
		panel.add(btnlogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Page log = new Login_Page();
				log.dispose();
				Register_Page reg = new Register_Page();
				reg.setVisible(true);
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBounds(226, 135, 111, 37);
		panel.add(btnRegister);
		
		JButton btn_forgot_password = new JButton("Forgot Password?");
		btn_forgot_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forgot_password_page frgt_pssword = new Forgot_password_page();
				frgt_pssword.setVisible(true);
			}
		});
		btn_forgot_password.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_forgot_password.setBounds(237, 209, 167, 30);
		panel.add(btn_forgot_password);
		
		
		
		
	}
}
