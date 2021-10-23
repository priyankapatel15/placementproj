<html>
<head>
<title>Campus Recruitment System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery.validate.js"></script>
<style>
.ui-datepicker {
	font-family: "Trebuchet MS", "Helvetica", "Arial",  "Verdana", "sans-serif";
	font-size: 12px;
}
.ui-datepicker select.ui-datepicker-month, .ui-datepicker select.ui-datepicker-year {
	float:left;
}
</style>
<script>
jQuery('document').ready(function() {
	jQuery("#Form").validate();
});
</script>
</head>
<body id="top">
<div class="wrapper row0">
  <div id="topbar" class="clear"> 
    <nav>
      <ul>
		<% if(session.getAttribute("login_id")!=null) { %>
		<li>Welcome <% out.print(session.getAttribute("login_name")); %></li>
        <li><a href="model/login.jsp?act=logout">Logout</a></li>
		<% } else { %>
		<li><a href="index.jsp">Home</a></li>
        <li><a href="about.jsp">About Us</a></li>
        <li><a href="contact-us.jsp">Contact Us</a></li>
		<li><a href="student-login.jsp">User Login</a></li>
		<li><a href="login.jsp?title=Adminstrator">Admin Login</a></li>
		<% } %>
      </ul>
    </nav>
  </div>
</div>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
       <div style="float:left; margin-top:-11px;"><h1 style="font-size:36px;"><a href="index.jsp">Campus Recruitment System</a></h1>
      <p style="color:#ffffff">A complete solution for managing Vacancies, Placements, Colleges and Students</p>
      </div>
    </div>
    <div class="fl_right">
      <form class="clear" method="post" action="#">
        <fieldset>
          <legend>Search:</legend>
          <input type="text" value="" placeholder="Search Here">
          <button class="fa fa-search" type="submit" title="Search"><em>Search</em></button>
        </fieldset>
      </form>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <div class="rounded">
    <nav id="mainav" class="clear"> 
      <ul class="clear">
        <li class="active"><a href="index.jsp">Home</a></li>        
        <!-- Menu System for Super Admin Login -->
        <% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("1")) { %>
		<!-- Menu System for Super Admin Login -->
		<li><a href="Companies.jsp">Companies</a></li>
		<li><a href="Jobs.jsp?company_id=0">All Jobs</a></li>
		<li><a href="#" class="drop" >Add New</a>
         <ul>
            <li><a href="student.jsp?student_id=0">Add Applicatnt</a></li>
            <li><a href="employee.jsp?employee_id=0">Add System User</a></li>
            <li><a href="job.jsp?job_id=0">Add Job</a></li>
            <li><a href="company.jsp?company_id=0">Add Company</a></li>
            <li><a href="college.jsp?college_id=0">Add College</a></li>
          </ul>
        </li>
		<li style="display: none;"><a href="#" class="drop" >Reports</a>
          <ul>
            <li><a href="report-employee.jsp">System User Report</a></li>
            <li><a href="report-student.jsp">Applicant Report</a></li>
            <li><a href="report-job.jsp">Job Report</a></li>
            <li><a href="report-company.jsp">Company Report</a></li>
            <li><a href="report-college.jsp">College Report</a></li>
            <li><a href="report-application.jsp">Job Applications</a></li>
          </ul>
        </li>
        <li><a href="change-password.jsp">Change Password</a></li>
        <li><a href="model/login.jsp?act=logout">Logout</a></li>
		<% } %>
		<!-- End of the Super Admin Menu Section -->
		
		<!-- Menu System for Student Login -->
		<% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("4")) { %>		
		<li><a href="Companies.jsp">Companies</a></li>
		<li><a href="Jobs.jsp?company_id=0">All Jobs</a></li>
		<li><a href="report-application.jsp">My Applications</a></li>
		<li><a href="student.jsp?student_id=<%=session.getAttribute("student_id")%>">My Account</a></li>
		<li><a href="contact-us.jsp">Contact Us</a></li>
        <li><a href="model/student.jsp?act=logout">Logout</a></li>
		<% } %>
		<!-- End of Employee Menu Section -->
		
		<!-- Menu System for Student Login -->
		<% if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("2")) { %>		
		<li><a href="login-home.jsp">My Dashboard</a></li>
		<li><a href="report-student.jsp">Students Lists</a></li>
		<li><a href="job-application.jsp">Job Applications</a></li>
		<li><a href="company.jsp?company_id=<%=session.getAttribute("company_id")%>">My Account</a></li>
        <li><a href="model/company.jsp?act=logout">Logout</a></li>
		<% } %>
		<!-- End of Employee Menu Section -->
		
		<% if(session.getAttribute("login_level") == null) { %>
			<li><a href="about.jsp">About Us</a></li>
			<li><a href="faq-list.jsp">FAQ</a></li>      
			<li><a href="Companies.jsp">Companies</a></li>
			<li><a href="Colleges.jsp">Colleges</a></li>
			<li><a href="Jobs.jsp?company_id=0">All Jobs</a></li>
			<li><a href="register-page.jsp">Register</a></li>
			<li><a href="login-page.jsp">Login</a></li>      
			<li><a href="contact-us.jsp">Contact Us</a></li>
		<% } %>
      </ul>
    </nav>
  </div>
</div>
