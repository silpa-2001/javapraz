/*
CREATE OR REPLACE PROCEDURE deptin(deptno IN number,dname IN varchar2,loc IN varchar2)
IS
BEGIN 
	insert into dept values(deptno,dname,loc);
END;
/
*/
import java.io.*;
import java.util.*;
import java.sql.*;
class Proced
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","silpa","anil");
			CallableStatement stmt=con.prepareCall("{call deptin(?,?,?)}");
			stmt.setInt(1, 101);
			stmt.setString(2, "Computer Science");
			stmt.setString(3, "Kerala");
			stmt.execute();
			System.out.println("Successfully Updated...");
		}
		catch(Exception e)
		{
		}
	}
}