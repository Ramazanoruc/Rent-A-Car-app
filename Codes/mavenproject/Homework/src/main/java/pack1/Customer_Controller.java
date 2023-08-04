package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer_Controller {
	
	
	public ArrayList<Customer> get_customers() throws SQLException{
		
		ArrayList<Customer> tem_customers= new ArrayList<Customer>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		Statement st = con.createStatement();
		String query= "Select * from customer";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			tem_customers.add(new Customer(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(6),
					rs.getString(7)));
		}
		
		
		return tem_customers;
		
	}
	
	public void save_customer(Customer customer) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		String query= "insert into customer values (?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,customer.customer_id);
		ps.setString(2, customer.name);
		ps.setString(3, customer.surname);
		ps.setString(4, customer.age);
		ps.setString(5, customer.gender);
		ps.setInt(6,customer.car_id);
		ps.setString(7, customer.debt);
		ps.execute();
	}
	
	public void delete_customer(int customer_id) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		Statement st= con.createStatement();
		st.executeUpdate(String.format("delete from customer where customer_id = '%d'",customer_id));
		
	}
	

}
