<%@ page import= "Model.*" %>
<%@ page import= "java.util.*" %>

<%
	Company company = new Company();
	String emp_id = "0";
	if((request.getParameter("act")).equals("chk_login"))
	{
		if(company.checkLogin(request.getParameter("login_user"),request.getParameter("login_password")))
		{
			HashMap Values =  company.getLoginDetails(request.getParameter("login_user"),request.getParameter("login_password"));
			
			session.setAttribute("company_id",Values.get("company_id"));
			session.setAttribute("login_id",Values.get("company_id"));
			session.setAttribute("company_name",Values.get("company_name"));
			session.setAttribute("login_level","2");
			session.setAttribute("login_name",Values.get("company_name"));
			response.sendRedirect("../login-home.jsp?msg=You are login successfully.");
		}
		else
		{
			response.sendRedirect("../company-login.jsp?msg=Invalid User/Password. Please try again.........");			
		}
	}
	if((request.getParameter("act")).equals("logout"))
	{
		session.setAttribute("login_id",null);
		session.setAttribute("login_level",null);
		session.setAttribute("company_id",null);
		session.setAttribute("company_name",null);
		response.sendRedirect("../company-login.jsp?msg=You are logout successfully......");			
	}
%>
