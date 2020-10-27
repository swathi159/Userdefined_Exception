package Crud_Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public interface Db_Interface {
	
//public abstract Connection getConnection();
 public abstract void save(Employee employee);
 public abstract void update(Employee employee1);
 public abstract void retrieve();
 public abstract void delete(int id);
 public abstract void retrieve(int id);

	
 
 
}
