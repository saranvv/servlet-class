import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		String username=req.getParameter("username");
			String password=req.getParameter("password");
			RequestDispatcher rp=req.getRequestDispatcher("/General.html");
			try {
				rp.include(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(username.equals("saran")&&password.equals("123456")) {
				HttpSession sc=req.getSession();
				sc.setAttribute("un", username);
				System.out.print("ok");
			}else {
				RequestDispatcher rs=req.getRequestDispatcher("/login.html");
				try {
					rs.forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
		
	}
}
