<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>

<%
	Student studentDetails = new Student();
	ArrayList allStudent = studentDetails.getAllStudent();
%>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div class="scrollable">
        <h2>All Student Report</h2>
		<% if(request.getParameter("msg") != null) { %>
		<div class="msg"><%=request.getParameter("msg") %></div>
		<% } %>
        <table>
          <thead>
            <tr>
              <th>Student Code</th>
              <th>Name</th>
              <th>Email</th>
              <th>Mobile</th>
              <th>City</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
			<% for(int i=0;i<allStudent.size();i++) 
			{ 
				HashMap StudentDetails = new HashMap();
				StudentDetails = (HashMap)allStudent.get(i);
			%>
				<tr>
				  <td style="text-align:center;"><% out.print(StudentDetails.get("student_id")); %></td>
				  <td><% out.print(StudentDetails.get("student_name")); %></td>
				  <td><% out.print(StudentDetails.get("student_email")); %></td>
				  <td><% out.print(StudentDetails.get("student_mobile")); %></td>
				  <td><% out.print(StudentDetails.get("student_city")); %></td>
				  <td>
				  <% if(session.getAttribute("login_level").equals("2")) { %>	
					<a href="student.jsp?student_id=<% out.print(StudentDetails.get("student_id")); %>">View Details</a></a>
				  <% } else { %>
					<a href="student.jsp?student_id=<% out.print(StudentDetails.get("student_id")); %>">Edit Student</a></a>
				  <% } %>
				  </td>
				</tr>
			<%
			}
			%>
			</tbody>
        </table>
        </div>
        
        <div style="clear:both; margin-top:50px;"></div>
        <h2 style="background-color:#043347; padding:10px; color:#ffffff; font-weight:bold; ">Send Email To Student !!!</h2>
        <div id="comments">
          <center>
          <% if(request.getParameter ("email") != null) { %>
			<div class="msg" style="background-color:#ff0000">Email Sent Successfully !!! </div>
		  <% } %>
          <form method="post" action="#">
			<div style="border:1px solid; width:50%; padding:10px;">
			  <div style="text-align:left">
				<label for="email">Email<span>*</span></label>
				<input type="text" name="email" id="email" size="22" style="width:400px;" required>
			  </div>
			  <div style="text-align:left">
				<label for="email">Message<span>*</span></label>
				<textarea style="width:400px; height:100px;" name="message" required></textarea>
			  </div>
			  <div>
					<input name="submit" type="submit" value="Send Email">
				&nbsp;
				<input name="reset" type="reset" value="Reset Form">
			  </div>
		   </div>
		   </form>
		  </center>
        </div>
    </main>
  </div>
</div>
<%@ include file="includes/footer.jsp" %>
