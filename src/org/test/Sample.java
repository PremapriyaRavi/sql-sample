package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//connect to database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","admin");
		//write query
		String query="select * from fblogin";
		//prepare statement
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			String name = rs.getString("username");
			String pw = rs.getString("password");
			System.out.println(name);
			System.out.println(pw);
		}
		con.close();
	}

}
