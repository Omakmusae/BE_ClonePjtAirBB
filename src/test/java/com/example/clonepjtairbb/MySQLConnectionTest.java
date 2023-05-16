package com.example.clonepjtairbb;



import static org.assertj.core.api.Fail.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class MySQLConnectionTest {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try(Connection con =
				DriverManager.getConnection(
					"jdbc:mysql://sprint-database.cpbvg0wee2mz.ap-northeast-2.rds.amazonaws.com:3306/SPrint",
					"HangHaeSPrint",
					"hanghae14sprint")){
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
}
