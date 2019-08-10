package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionInfo {

	public static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";

	public static final String MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/emp?serverTimezone=Asia/Seoul";

	public static final String USER = "SCOTT";
	public static final String PASSWORD = "TIGER";
	public static final String PASSWORD2 = "0000";

	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

}