

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	
		protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
			
			 PrintWriter pw= res.getWriter();
		RequestDispatcher rp=req.getRequestDispatcher("/General.html");
			rp.include(req, res);
			
		HttpSession sd = req.getSession();
		String name =(String) sd.getAttribute("un");
		pw.print("Welcome"+name);
	}
}
