package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAOImpl;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = -1438802864929405976L;
	//servlet에는 Field를 두지 않는다. -> servlet을 여러군대에서 공유할 수 있기 때문에
	//servlet은 하나의 이름으로 하나의 인스턴스만 만들어진다. 
	//was가 servlet의 Lifecycle을 관리한다. 
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("context",request.getContextPath());	
	
		//request.setCharacterEncoding("UTF-8");   
		//별도로 지정해주지 않을 경우 기본 설정인 885`9-1 로 받기 때문에, UTF-8로 request의 값을 받겠다는 것을 선언한것
		//client는 경우 해당 설정을 알 수 없기 때문에, client가 다른 Character set으로 보낼 경우 깨질 수 있다. 
		//일반적으로 이 방법이 아닌 Filter를 이용한다. 
		
		if(request.getParameter("option").equals("all")) {
			request.setAttribute("list",new EmployeeDAOImpl().list());
		}else {
			Map<String, String> searchInfo = new HashMap<>();
			searchInfo.put("searchOption", request.getParameter("option"));
			searchInfo.put("searchWord", request.getParameter("word"));
			request.setAttribute("list",new EmployeeDAOImpl().Search(searchInfo));	
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/employeeList.jsp").forward(request, response);
	}
}
