import com.lti.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 public DeleteController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		HttpSession session=request.getSession();
		Student s=new Student();
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		StudentDao studentDao=new StudentDao();
		
		String result=studentDao.deleteCollege(s);
		System.out.println("Delete Status:"+result);
		if(result.equals(Results.SUCCESS))
		{
			session.setAttribute("cid",s.getId());
			RequestDispatcher rd=request.getRequestDispatcher("/deleteDisplay.jsp");
			rd.forward(request, response);
		}
		
	}

}
