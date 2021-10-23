<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>
<%
	Faq faqDetails = new Faq();
	int faq_id = Integer.parseInt(request.getParameter ("faq_id"));
	HashMap Values =  faqDetails.getFaqDetails(faq_id);
%>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div id="comments" style="width: 70%; float:left; margin-right:30px">
      <h2>Pay Employee Faq</h2>
        <form action="model/faq.jsp" method="post">
		  <div class="one_third first">
            <label for="email">FAQ Question<span>*</span></label>
            <input type="text" name="faq_question" value="<% out.print(Values.get("faq_question")); %>" required style="width:600px">
          </div>
          <div class="one_third first">
            <label for="email">FAQ Answer<span>*</span></label>
            <textarea name="faq_answer" style="height:200px; width:600px" required><% out.print(Values.get("faq_answer")); %></textarea>
          </div>
          <div class="block clear"></div>
          <div>
            <input name="submit" type="submit" value="Save FAQ">
            &nbsp;
            <input name="reset" type="reset" value="Reset Form">
          </div>
		  <input type="hidden" name="act" value="Save" />
		  <input type="hidden" name="faq_id" value="<% out.print(Values.get("faq_id")); %>"/>
        </form>
        </div>
        <div style="float: left">
        	<div><img src="images/save_1.jpg" style="width: 250px"></div><br>
        	<div><img src="images/save_2.jpg" style="width: 250px"></div>
        </div>
      <div class="clear"></div>
    </main>
  </div>
</div>
<%@ include file="includes/footer.jsp" %>
