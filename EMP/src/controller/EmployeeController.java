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
	//servlet���� Field�� ���� �ʴ´�. -> servlet�� �������뿡�� ������ �� �ֱ� ������
	//servlet�� �ϳ��� �̸����� �ϳ��� �ν��Ͻ��� ���������. 
	//was�� servlet�� Lifecycle�� �����Ѵ�. 
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("context",request.getContextPath());	
	
		//request.setCharacterEncoding("UTF-8");   
		//������ ���������� ���� ��� �⺻ ������ 885`9-1 �� �ޱ� ������, UTF-8�� request�� ���� �ްڴٴ� ���� �����Ѱ�
		//client�� ��� �ش� ������ �� �� ���� ������, client�� �ٸ� Character set���� ���� ��� ���� �� �ִ�. 
		//�Ϲ������� �� ����� �ƴ� Filter�� �̿��Ѵ�. 
		
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