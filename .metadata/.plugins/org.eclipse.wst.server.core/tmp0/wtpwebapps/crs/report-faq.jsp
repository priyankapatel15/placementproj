<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>

<%
	Faq faqDetails = new Faq();
	ArrayList allFaq = faqDetails.getAllFaq();
%>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div class="scrollable">
        <h2>FAQ Report</h2>
		<% if(request.getParameter("msg") != null) { %>
		<div class="msg"><%=request.getParameter("msg") %></div>
		<% } %>
        <table>
          <thead>
            <tr>
              <th>Question</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
			<% for(int i=0;i<allFaq.size();i++) 
			{ 
				HashMap FaqDetails = new HashMap();
				FaqDetails = (HashMap)allFaq.get(i);
			%>
				<tr>
				  <td style="width:90%"><% out.print(FaqDetails.get("faq_question")); %></td>
				  <td> <a href="faq.jsp?faq_id=<% out.print(FaqDetails.get("faq_id")); %>">Edit</a> </td>
				</tr>
			<%
			}
			%>
			</tbody>
        </table>
        </div>
    </main>
  </div>
</div>
<%@ include file="includes/footer.jsp" %>
