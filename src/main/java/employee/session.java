package employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session = req.getSession();
		String uname = (String) session.getAttribute("uname");
		PrintWriter pw;
		try {
			pw = res.getWriter();
			pw.print(uname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}


