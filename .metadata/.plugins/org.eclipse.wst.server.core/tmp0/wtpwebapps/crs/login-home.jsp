<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
	    <div style="width: 70%; float:left; margin-right:30px" id="login-home">
		  <h2>Welcome to Campus Recruitment System</h2>
		  
		  <!-- Dashboard For Employee Section -->
		  <% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("4")) { %>		
		  <ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="Companies.jsp">Companies</a></li>
			<li><a href="Jobs.jsp?company_id=0">All Jobs</a></li>
			<li><a href="report-application.jsp">My Applications</a></li>
			<li><a href="customer.jsp?customer_id=<%=session.getAttribute("customer_id")%>">My Account</a></li>
			<li><a href="contact-us.jsp">Contact Us</a></li>
			<li><a href="model/customer.jsp?act=logout">Logout</a></li>
		  </ul>
		  <% } %>
		  
		 <!-- Dashboard For Super Admin Section -->
		 <% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("1")) { %>		
		  <ul>
		  	<li><a href="customer.jsp?customer_id=0">Add Applicatnt</a></li>
            <li><a href="employee.jsp?employee_id=0">Add System User</a></li>
            <li><a href="job.jsp?job_id=0">Add Job</a></li>
            <li><a href="company.jsp?company_id=0">Add Company</a></li>
            <li><a href="college.jsp?college_id=0">Add Colleges</a></li>
            <li><a href="report-employee.jsp">System User Report</a></li>
            <li><a href="report-customer.jsp">Applicant Report</a></li>
            <li><a href="report-job.jsp">Job Report</a></li>
            <li><a href="report-company.jsp">Company Report</a></li>
            <li><a href="report-college.jsp">College Report</a></li>
            <li><a href="job-application.jsp">Job Applications</a></li>
			<li><a href="change-password.jsp">Change Password</a></li>
			<li><a href="login.jsp?act=logout">Logout</a></li>
		  </ul>
		  <% } %>
		   
		 <!-- Dashboard For Super Admin Section -->
		 <% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("2")) { %>		
		  <ul>
		  	<li><a href="report-customer.jsp">View Students</a></li>
            <li><a href="job-application.jsp">Job Applications</a></li>
			<li><a href="change-password.jsp">Change Password</a></li>
			<li><a href="model/company.jsp?act=logout">Logout</a></li>
		  </ul>
		  <% } %>
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
