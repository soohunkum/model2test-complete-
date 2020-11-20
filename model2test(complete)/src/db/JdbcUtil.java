package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("commit success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("rollback success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
