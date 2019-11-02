
import com.lti.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.Results;

@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public AddController() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		HttpSession session=request.getSession();
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String courseType=request.getParameter("courseType");
		String city=request.getParameter("city");
		int fees=Integer.parseInt(request.getParameter("fees"));
		String pincode=request.getParameter("pincode");
		
		Student s=new Student();
		s.setId(cid);
		s.setCname(cname);
		s.setCourseType(courseType);
		s.setCity(city);
		s.setFees(fees);
		s.setPincode(pincode);
		
		StudentDao studentDao=new StudentDao();
		String result=studentDao.addDetails(s);
		
		if(result.equals(Results.SUCCESS))
		{
			session.setAttribute("cname",s.getCname());
			RequestDispatcher rd=request.getRequestDispatcher("/addSuccess.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/addSuccess.jsp");
		}
		
	
		
		
	}

}
