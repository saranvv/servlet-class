package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	/**
	 * 
	 */

	public void service(HttpServletRequest req,HttpServletResponse res) {
		String uname=req.getParameter("uName");
		String pass =req.getParameter("psw");
		//res.addCookie(ck);
		boolean check=credential.isvalid(uname, pass);
		
		if(check) {
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			try {
			String str="select * from result";
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","123456");
			PreparedStatement ps=cn.prepareStatement(str);
			
			ResultSet rs=ps.executeQuery();
           while(rs.next()) {
			    	
			PrintWriter pw=res.getWriter();
			pw.println("User name" +rs.getString(1));
           }
	
		}
			catch(Exception e) {
				e.printStackTrace();
			}
           
		}
           
		else {
		//  System.out.print("Noo");
		RequestDispatcher rd=req.getRequestDispatcher("/login.html");
		}
	}

}
