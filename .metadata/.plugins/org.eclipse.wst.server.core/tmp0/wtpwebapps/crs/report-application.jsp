<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>

<%
	Job jobDetails = new Job();
	int student_id = 0;
	if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("4")) {
		student_id = Integer.parseInt(session.getAttribute("student_id").toString());
	}
	ArrayList allJob = jobDetails.getAllApplication(student_id);
%>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div class="scrollable">
        <h2>Job Report</h2>
		<% if(request.getParameter("msg") != null) { %>
		<div class="msg"><%=request.getParameter("msg") %></div>
		<% } %>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Image</th>
              <th>Applicant Name</th>
              <th>Job Title</th>
              <th>Contact Number</th>
              <th>Type</th>
              <th>Date</th>
            </tr>
          </thead>
          <tbody>
			<% for(int i=0;i<allJob.size();i++) 
			{ 
				HashMap JobDetails = new HashMap();
				JobDetails = (HashMap)allJob.get(i);
			%>
				<tr>
				  <td style="text-align:center;"><% out.print(JobDetails.get("job_id")); %></td>
				  <td>
					<a href="JobsDetails.jsp?job_id=<% out.print(JobDetails.get("job_id")); %>">
						<img src="companyImages/<% out.print(JobDetails.get("company_image")); %>" style="height:80px; width:80px;">
					</a>
				  </td>
				  <td><% out.print(JobDetails.get("student_name")); %></td>
				  <td><% out.print(JobDetails.get("job_title")); %></td>
				  <td><% out.print(JobDetails.get("student_mobile")); %></td>
				  <td><% out.print(JobDetails.get("jt_title")); %></td>
				  <td><% out.print(JobDetails.get("apply_date")); %></td>
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
