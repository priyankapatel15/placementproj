<%@ page import= "Model.*" %>
<%@ page import= "java.util.*" %>

<%
	Faq faqObj = new Faq();
	if((request.getParameter("act")).equals("Save"))
	{
		HashMap results = new HashMap();
		results.put("faq_id",request.getParameter("faq_id"));
		results.put("faq_question",request.getParameter("faq_question"));
		results.put("faq_answer",request.getParameter("faq_answer"));
		
		if((request.getParameter("faq_id")).equals(""))
		{
			out.println(faqObj.saveFaq(results));
			response.sendRedirect("../report-faq.jsp?msg=FAQ Saved Successfully");
		}
		else
		{
			results.put("faq_id",request.getParameter("faq_id"));
			out.println(faqObj.updateFaq(results));
			response.sendRedirect("../report-faq.jsp?msg=FAQ Updated Successfully");
		}
	}
%>
