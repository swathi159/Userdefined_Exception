package Crud_Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;



public class Implimentation implements Db_Interface {

	final static Logger logger = Logger.getLogger(Implimentation.class);
	public  static Connection getConnection() {
		 String url = "jdbc:mysql://localhost:3306/test";
			String name = "root";
			String pass = "root";
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(url, name, pass);
				
			} catch (SQLException e) {
			System.out.println("Connection failed");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not loaded");
			}
			return  con;
		
	
		
	}


	@Override
	public void save(Employee employee) {
		try {
			System.out.println("entered");
			Connection con= Implimentation.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employeee(emp_name,emp_sal) values(?,?);",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Connection Estabblished");
			// int emp_id = employee.getEmp_id();
			String emp_name = employee.getEmp_name();
			int emp_sal = employee.getEmp_sal();
			  
			ps.setString(1, emp_name);
			ps.setInt(2, emp_sal);
			int rows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rows > 0) {
				System.out.println("Inserted");
			}
			ResultSet rs1 =ps.getGeneratedKeys();
			while(rs1.next())
			{
				System.out.println(rs1.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Entered Duplicate Value");
		
	}
	}

	@Override
	public void update(Employee employee1) {
		int rows =0;
		try {
			Connection con= Implimentation.getConnection(); 
			PreparedStatement ps = con.prepareStatement("Update employeee set emp_sal=? where emp_id=?;");
		ps.setInt(1, employee1.getEmp_sal());
		ps.setInt(2, employee1.getEmp_id());
			 rows = ps.executeUpdate();
			 con.close();
			if (rows < 0) {
				System.out.println("Updated");
			}
			else{
				
				throw new InvalidNumException();
			}
          
		} catch (SQLException e) {
			System.out.println("Sql exception");
		}catch(InvalidNumException e1){
			System.out.println(e1.getMessage());
		}
		}
		
	

	@Override
	public void retrieve() {
		try {
			Connection con=Implimentation.getConnection(); 
			PreparedStatement ps = con.prepareStatement("select * from employeee;");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int emp_id = rs.getInt(1);
				String emp_name = rs.getString(2);
				int emp_sal = rs.getInt(3);
				System.out.println(
						"Employee id:" + emp_id + "  Employee Name:" + emp_name + "  Employee Salary:" + emp_sal);
			}
			con.close();
		} catch (SQLException e) {
			logger.error("Syntax error in query:" + e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			Connection con= Implimentation.getConnection(); 
			PreparedStatement ps = con.prepareStatement("delete from employeee where emp_id = ?;");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				logger.info("Deleted");
				con.close();
				}
			else
			{
				logger.info("Error");
			}
			
		}catch (SQLException e) {
			logger.error("Syntax Error In SQL Query:" + e.getMessage());

		}
	}

	@Override
	public void retrieve(int id) {
		try {
			Connection con=Implimentation.getConnection(); 
			PreparedStatement ps = con.prepareStatement("select * from employeee where emp_id=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int emp_id = rs.getInt(1);
				String emp_name = rs.getString(2);
				int emp_sal = rs.getInt(3);
				System.out.println("Employee id:" + emp_id + "  Employee Name:" + emp_name + "  Employee Salary:" + emp_sal);
			}
			con.close();
		} catch (SQLException e) {
			logger.error("Syntax error in query:" + e.getMessage());
		}

		
	}

}
