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
        <h2>FAQ (Frequently Asked Questions)</h2>
		<% if(request.getParameter("msg") != null) { %>
		<div class="msg"><%=request.getParameter("msg") %></div>
		<% } %>
		<table>
		<% for(int i=0;i<allFaq.size();i++) 
		{ 
			HashMap FaqDetails = new HashMap();
			FaqDetails = (HashMap)allFaq.get(i);
			String answer = FaqDetails.get("faq_answer").toString();
			answer = answer.replace("\n", "<br/>");
		%>
		<tr style="text-align:left;"><th><% out.print(FaqDetails.get("faq_question")); %></th></tr>
		<tr><td><% out.print(answer); %></td></tr>
		<%
		}
		%>
        </table>
        </div>
    </main>
  </div>
</div>
<%@ include file="includes/footer.jsp" %>
