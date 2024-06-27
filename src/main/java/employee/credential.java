package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class credential{
	public static boolean isvalid(String un,String psw) {
		boolean check=false;
		try {
			String str="select uname from result where uname=?";
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","123456");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1, un);
			
			ResultSet rs=ps.executeQuery();
           while(rs.next()) {
			    if(un.equals(rs.getString(1))) {
			    		
			    	check=true;
			   }
             }
		}
		catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;  
}
}