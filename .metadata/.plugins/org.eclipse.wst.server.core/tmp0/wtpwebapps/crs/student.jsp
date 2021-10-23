<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>
<%
	Student studentDetails = new Student();
	int student_id = Integer.parseInt(request.getParameter ("student_id"));
	HashMap Values =  studentDetails.getStudentDetails(student_id);	
%>
<div class="wrapper row3">
  <div class="rounded">
    <% if(request.getParameter("msg") != null) { %>
	<div class="msg"><%=request.getParameter("msg") %></div>
	<% } %>
    <main class="container clear"> 
      <!-- main body --> 
      <div id="comments" style="width: 100%; float:left; margin-right:30px">
      <h2>Student Registration Form</h2>
		<h4>Personal Details</h4>
		<form method="post" action="model/student.jsp">
          <div class="one_third first">
            <label for="email">Name<span>*</span></label>
            <input type="text" name="student_name" id="student_name" value="<% out.print(Values.get("student_name")); %>" size="22" style="width:300px;" required>
          </div>
          <div class="one_third">
            <label for="email">Mobile<span>*</span></label>
            <input type="text" name="student_mobile" id="student_mobile" value="<% out.print(Values.get("student_mobile")); %>" size="22" style="width:300px;" required>
          </div>
           <div class="one_third">
            <label for="email">Email<span>*</span></label>
            <input type="text" name="student_email" id="student_email" value="<% out.print(Values.get("student_email")); %>" size="22" style="width:300px;" required>
          </div>
          <div id="password_row">
			  <div class="one_third first">
				<label for="email">Password<span>*</span></label>
				<input type="password" name="student_password" id="student_password" value="<% out.print(Values.get("student_password")); %>" size="22" style="width:300px;" required>
			  </div>
			  <div class="one_third">
				<label for="email">Confirm Password<span>*</span></label>
				<input type="password" name="student_confirm_password" id="student_confirm_password" value="<% out.print(Values.get("student_password")); %>" size="22" style="width:300px;" required>
			  </div>
		  </div>
          <div style="clear:both"></div>
          <h4>Qualification Details</h4>
          <table>
			<tr>
				<th style="width:160px; height:50px; vertical-align:middle">Degree Name</th>
				<th style="width:160px; height:50px; vertical-align:middle">College</th>
				<th style="vertical-align:middle">Start Year</th>
				<th style="vertical-align:middle">Year of Passing</th>
				<th style="vertical-align:middle">Subject</th>
				<th style="vertical-align:middle">Persantage</th>
			</tr>
			<tr>
				<th style="vertical-align:middle">High School</th>
				<td><input type="text" name="student_high_college" value="<% out.print(Values.get("student_high_college")); %>"></td>
				<td><input type="text" name="student_high_start" value="<% out.print(Values.get("student_high_start")); %>"></td>
				<td><input type="text" name="student_high_pass" value="<% out.print(Values.get("student_high_pass")); %>"></td>
				<td><input type="text" name="student_high_subject" value="<% out.print(Values.get("student_high_subject")); %>"></td>
				<td><input type="text" name="student_high_persantage" value="<% out.print(Values.get("student_high_persantage")); %>"></td>
			</tr>
			<tr>
				<th style="vertical-align:middle">Intermediate</th>
				<td><input type="text" name="student_inter_college" value="<% out.print(Values.get("student_inter_college")); %>"></td>
				<td><input type="text" name="student_inter_start" value="<% out.print(Values.get("student_inter_start")); %>"></td>
				<td><input type="text" name="student_inter_pass" value="<% out.print(Values.get("student_inter_pass")); %>"></td>
				<td><input type="text" name="student_inter_subject" value="<% out.print(Values.get("student_inter_subject")); %>"></td>
				<td><input type="text" name="student_inter_persantage" value="<% out.print(Values.get("student_inter_persantage")); %>"></td>
			</tr>
			<tr>
				<th style="vertical-align:middle">Graduation</th>
				<td><input type="text" name="student_graduate_college" value="<% out.print(Values.get("student_graduate_college")); %>"></td>
				<td><input type="text" name="student_graduate_start" value="<% out.print(Values.get("student_graduate_start")); %>"></td>
				<td><input type="text" name="student_graduate_pass" value="<% out.print(Values.get("student_graduate_pass")); %>"></td>
				<td><input type="text" name="student_graduate_subject" value="<% out.print(Values.get("student_graduate_subject")); %>"></td>
				<td><input type="text" name="student_graduate_persantage" value="<% out.print(Values.get("student_graduate_persantage")); %>"></td>
			</tr>
			<tr>
				<th style="vertical-align:middle">Post Graduation</th>
				<td><input type="text" name="student_pg_college" value="<% out.print(Values.get("student_pg_college")); %>"></td>
				<td><input type="text" name="student_pg_start" value="<% out.print(Values.get("student_pg_start")); %>"></td>
				<td><input type="text" name="student_pg_pass" value="<% out.print(Values.get("student_pg_pass")); %>"></td>
				<td><input type="text" name="student_pg_subject" value="<% out.print(Values.get("student_pg_subject")); %>"></td>
				<td><input type="text" name="student_pg_persantage" value="<% out.print(Values.get("student_pg_persantage")); %>"></td>
			</tr>
          </table>
          <div style="clear:both"></div>
          <h4>Address Details</h4>
          <div class="one_third first">
            <label for="email">City<span>*</span></label>
            <input type="text" name="student_city" id="student_city" value="<% out.print(Values.get("student_city")); %>" size="22" style="width:300px;" required>
          </div>
          <div class="one_third">
            <label for="url">State</label>
            <select style="height: 40px; width:300px" name="student_state" required>
				<% out.print(studentDetails.getStateOption((Integer) Values.get("student_state"))); %>
            </select>
          </div>
          <div class="one_third">
            <label for="email">Pincode<span>*</span></label>
            <input type="text" name="student_pincode" id="student_pincode" value="<% out.print(Values.get("student_pincode")); %>" size="22" style="width:300px;" required>
          </div>
		  <div class="one_third first">
            <label for="email">Full Address<span>*</span></label>
            <textarea style="width:300px; height:100px;" name="student_address" required><% out.print(Values.get("student_address")); %></textarea>
          </div>
          
          <div class="block clear"></div>
          <% if(session.getAttribute("login_level") == null || session.getAttribute("login_level").equals("1") || session.getAttribute("login_level").equals("4")) { %>		
          <div>
            <input name="submit" type="submit" value="Save Details">
            &nbsp;
            <input name="reset" type="reset" value="Reset Form">
          </div>
          <% } %>
		  <input type="hidden" name="image_name" value="<% out.print(Values.get("student_image")); %>" />
		  <input type="hidden" name="act" value="Save" />
		  <input type="hidden" id="student_id" name="student_id" value="<% out.print(Values.get("student_id")); %>"/>
        </form>
        </div>
      <div class="clear"></div>
    </main>
  </div>
</div>
<% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("1")) { %>		
	<script>
		 jQuery('#password_row').hide();
	</script>
<% } %>
<%@ include file="includes/footer.jsp" %>
