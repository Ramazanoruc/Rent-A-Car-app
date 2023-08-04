package pack1;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class After_Login extends JFrame {

	protected static final Component After_Login = null;
	private JPanel contentPane;
	private JTextField txtcustomerid;
	private JTextField txt_customer_name;
	private JTextField txt_customer_surname;
	private JTextField txtcarid;
	private JTextField txt_customer_debt;
	private JTextField txtage;
	private JTextField txtgender;
	private JButton btnsave;
	private JButton btnShowCustomers;
	private JButton btnDeleteCustomer;
	private JButton btn_exit;

	/**
	 * Launch the application.
	 */
	
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	private JButton btnback;
	private JButton btnShowCustomers_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					After_Login frame = new After_Login();
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
	public After_Login() {
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 566, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		
		
		final JList list = new JList(model);
		list.setBounds(224, 19, 199, 105);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Customer Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 33, 82, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(10, 69, 89, 20);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurname.setBounds(10, 104, 89, 20);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(10, 135, 50, 20);
		contentPane.add(lblAge);
		
		JLabel lblCarId = new JLabel("Car Id");
		lblCarId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarId.setBounds(10, 166, 68, 20);
		contentPane.add(lblCarId);
		
		JLabel lblDebt = new JLabel("Debt");
		lblDebt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDebt.setBounds(10, 197, 89, 20);
		contentPane.add(lblDebt);
		
		txtcustomerid = new JTextField();
		txtcustomerid.setBounds(102, 34, 89, 20);
		contentPane.add(txtcustomerid);
		txtcustomerid.setColumns(10);
		
		txt_customer_name = new JTextField();
		txt_customer_name.setColumns(10);
		txt_customer_name.setBounds(102, 70, 89, 20);
		contentPane.add(txt_customer_name);
		
		txt_customer_surname = new JTextField();
		txt_customer_surname.setColumns(10);
		txt_customer_surname.setBounds(102, 105, 89, 20);
		contentPane.add(txt_customer_surname);
		
		txtcarid = new JTextField();
		txtcarid.setColumns(10);
		txtcarid.setBounds(102, 167, 89, 20);
		contentPane.add(txtcarid);
		
		txt_customer_debt = new JTextField();
		txt_customer_debt.setColumns(10);
		txt_customer_debt.setBounds(102, 198, 89, 20);
		contentPane.add(txt_customer_debt);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(10, 228, 50, 20);
		contentPane.add(lblGender);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(102, 136, 89, 20);
		contentPane.add(txtage);
		
		txtgender = new JTextField();
		txtgender.setColumns(10);
		txtgender.setBounds(102, 229, 89, 20);
		contentPane.add(txtgender);
		
		btnsave = new JButton("Save Customer");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customers = new Customer(Integer.parseInt(txtcustomerid.getText()),
						txt_customer_name.getText(),
						txt_customer_surname.getText(),
						txtage.getText(),
						txtgender.getText(), 
						Integer.parseInt(txtcarid.getText()),
						txt_customer_debt.getText());
				
				Customer_Controller cus_con = new Customer_Controller();
				try {
					cus_con.save_customer(customers);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(After_Login, "Customer Successfully Added!");
						
			}
		});
		btnsave.setBounds(10, 288, 181, 30);
		contentPane.add(btnsave);
		
		btnShowCustomers = new JButton("Show Customers");
		btnShowCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				Customer_Controller cus_cnt = new Customer_Controller();
				try {
					customers=cus_cnt.get_customers();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Customer c : customers) {
					model.addElement(c.customer_id+" "+c.name+" "+c.surname);
					
				}
				
			}
		});
		btnShowCustomers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShowCustomers.setBounds(447, 19, 95, 54);
		contentPane.add(btnShowCustomers);
		
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_customer = list.getSelectedValue().toString();
				for (Customer c : customers) {
					if((c.customer_id+" "+c.name+" "+c.surname).equals(selected_customer)) {
						Customer_Controller cus_cont = new Customer_Controller();
						try {
							cus_cont.delete_customer(c.customer_id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				}
				
				JOptionPane.showMessageDialog(After_Login, "Customer Successfully Deleted!");
				
			}
		});
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteCustomer.setBounds(420, 288, 120, 30);
		contentPane.add(btnDeleteCustomer);
		
		btn_exit = new JButton("Exit");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_exit.setBounds(420, 338, 120, 30);
		contentPane.add(btn_exit);
		
		
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				After_Login aftlogin = new After_Login();
				final Login_Page logpage = new Login_Page();
				aftlogin.dispose();
				logpage.setVisible(true);
				
							
				

				
				
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnback.setBounds(268, 288, 130, 30);
		contentPane.add(btnback);
		
		btnShowCustomers_1 = new JButton("Show Customers(JTable)");
		btnShowCustomers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Show_Customers_Page showcustopage = new Show_Customers_Page();
					showcustopage.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowCustomers_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShowCustomers_1.setBounds(224, 166, 282, 72);
		contentPane.add(btnShowCustomers_1);
	}
}
