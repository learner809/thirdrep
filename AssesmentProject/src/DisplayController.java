

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.Student;
import com.lti.StudentDao;


@WebServlet("/FetchAllUsers")
public class DisplayController extends HttpServlet {   
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StudentDao studentDao=new StudentDao();
		ArrayList<Student> list=studentDao.getAllColleges("courseType","city");
		
		HttpSession session=request.getSession();
		session.setAttribute("clgList",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/displayDets.jsp");
		rd.forward(request, response);
		
	}

}
