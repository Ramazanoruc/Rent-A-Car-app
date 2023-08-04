package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Register_Page extends JFrame {
	protected static final Component Register_Page = null;
	private JTextField txtregisterkey;
	private JTextField txtregistername;
	private JTextField txtregistersurname;
	private JTextField txtregisterusername;
	private JTextField txtregisterpassword;
	
	
	static ArrayList<Manager> managers = new ArrayList<Manager>(); 
	private JTextField txtuserid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Page frame = new Register_Page();
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
	public Register_Page() {
		setTitle("Register Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 425);
		JPanel contentPane = new JPanel();
		contentPane.setAlignmentY(5.0f);
		contentPane.setAlignmentX(5.0f);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Key");
		lblNewLabel.setBounds(10, 51, 87, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 92, 87, 30);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 133, 87, 30);
		contentPane.add(lblSurname);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(230, 92, 87, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassoword = new JLabel("Password");
		lblPassoword.setBounds(230, 133, 74, 30);
		contentPane.add(lblPassoword);
		
		txtregisterkey = new JTextField();
		txtregisterkey.setBounds(84, 56, 99, 20);
		contentPane.add(txtregisterkey);
		txtregisterkey.setColumns(10);
		
		txtregistername = new JTextField();
		txtregistername.setColumns(10);
		txtregistername.setBounds(84, 97, 99, 20);
		contentPane.add(txtregistername);
		
		txtregistersurname = new JTextField();
		txtregistersurname.setColumns(10);
		txtregistersurname.setBounds(84, 138, 99, 20);
		contentPane.add(txtregistersurname);
		
		txtregisterusername = new JTextField();
		txtregisterusername.setColumns(10);
		txtregisterusername.setBounds(314, 97, 99, 20);
		contentPane.add(txtregisterusername);
		
		txtregisterpassword = new JTextField();
		txtregisterpassword.setColumns(10);
		txtregisterpassword.setBounds(314, 138, 99, 20);
		contentPane.add(txtregisterpassword);
		
		JLabel lblRentACar = new JLabel("Rent A Car Admin Registration");
		lblRentACar.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblRentACar.setBackground(Color.LIGHT_GRAY);
		lblRentACar.setBounds(53, 6, 417, 39);
		contentPane.add(lblRentACar);
		
		JButton btnregister = new JButton("REGİSTER");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager managers = new Manager(txtregistername.getText(),
						txtregistersurname.getText(),
						txtregisterusername.getText(),
						txtregisterpassword.getText(),
						Integer.parseInt(txtuserid.getText()));
				
				
				if(txtregisterkey.getText().equals("123")) {
					
					Manager_Controller mng_con = new Manager_Controller();
					try {
						mng_con.SaveManager(managers);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(Register_Page, "Manager Successfully Added!");
					
				}
				else {
					JOptionPane.showMessageDialog(Register_Page, "Wrong Register Key Try Again!");
					
				}
				
				
				
		
						
						
				
				
			}
		});
		btnregister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnregister.setBounds(344, 200, 145, 43);
		contentPane.add(btnregister);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Page log = new Login_Page();
				log.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnback.setBounds(383, 318, 87, 20);
		contentPane.add(btnback);
		
		
	
		
		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		
		
	
		final JList list_1 = new JList(model);
		list_1.setForeground(Color.BLACK);
		list_1.setBounds(10, 174, 307, 130);
		contentPane.add(list_1);
		
		JButton btnshowusers = new JButton("Show Admin List");
		btnshowusers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_Controller mng_controller = new Manager_Controller();
				try {
					
					model.removeAllElements();
					managers = mng_controller.getManagers();
					for (Manager m: managers) {
						model.addElement(m.userId+"-- "+m.name+"--"+m.surname+"--"+m.username+"--"+m.password);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnshowusers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnshowusers.setBounds(10, 318, 145, 20);
		contentPane.add(btnshowusers);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedManager = list_1.getSelectedValue().toString();
				for (Manager m: managers) {
					if((m.userId+"-- "+m.name+"--"+m.surname+"--"+m.username+"--"+m.password).equals(selectedManager)){
						Manager_Controller mng_con = new Manager_Controller();
						try {
							mng_con.DeleteManager(m.userId);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(Register_Page, "Manager Successfully Deleted");
					}	
					
				}
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btndelete.setBounds(172, 317, 145, 20);
		contentPane.add(btndelete);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setBounds(230, 51, 87, 30);
		contentPane.add(lblUserId);
		
		txtuserid = new JTextField();
		txtuserid.setColumns(10);
		txtuserid.setBounds(314, 56, 99, 20);
		contentPane.add(txtuserid);
	}
}
