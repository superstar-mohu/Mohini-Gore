package bank_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connector {
	Connection c;
	Statement s;
	public connector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///banksystem","root","182000");
			s=c.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
