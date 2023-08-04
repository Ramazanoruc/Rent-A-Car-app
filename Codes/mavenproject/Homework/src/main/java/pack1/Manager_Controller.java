package pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager_Controller {
	
	
	
	
	
	public ArrayList<Manager> getManagers() throws SQLException{
		
		
		ArrayList<Manager> temp_managers = new ArrayList<Manager>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		Statement st = con.createStatement();
		String query= "Select * from user";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			temp_managers.add(new Manager(rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(1)));
			
		}
		
		
		
		return temp_managers;
	}
	
	
	public void SaveManager(Manager manager) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		
		String query= "insert into user values (?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, manager.userId);
		ps.setString(2, manager.name);
		ps.setString(3, manager.surname);
		ps.setString(4, manager.username);
		ps.setString(5, manager.password);
		ps.execute();
		
	}
	
	public void DeleteManager(int managerid) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		Statement st= con.createStatement();
		
		st.executeUpdate(String.format("delete from user where user_id = '%d'",managerid));
		
		
		
	}

}
