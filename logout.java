

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		PrintWriter pw ;
		try {
			pw = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rp=req.getRequestDispatcher("/General.html");
		try {
			rp.include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   HttpSession hp = req.getSession();
	   
		
		pw.print("logged out successfully");
	
	   hp.getAttribute("UN");
	   hp.invalidate();
	 
	}
}
