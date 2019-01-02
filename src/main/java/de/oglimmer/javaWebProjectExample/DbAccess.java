package de.oglimmer.javaWebProjectExample;

import java.sql.*;

/*
 * A fake DB access bean
 */
public class DbAccess {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getSomething() {
		String dbUrl = "jdbc:mysql://" + JavaProperties.SINGLETON.getDbHost() + "/java_code?useSSL=false";
		try (Connection conn = DriverManager.getConnection(dbUrl, "root", "")) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery("SELECT fact FROM fun_facts limit 1")) {
					if (rs.next()) {
						return rs.getString(1);
					}
				}	
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return "getSomething failed.";
	}

}
