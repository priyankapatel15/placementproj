<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>
<%
	Job jobDetails = new Job();
	int job_id = Integer.parseInt(request.getParameter ("job_id"));
	HashMap Values =  jobDetails.getJobDetails(job_id);	
%>
<script>
    function openWin(url)
    {
        location.href = url;
    }
</script>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <% if(request.getParameter("msg") != null) { %>
		<div class="msg"><%=request.getParameter("msg") %></div>
	  <% } %>
      <!-- main body --> 
      <!-- ################################################################################################ -->
      <div class="group btmspace-30">
        <!-- Middle Column -->
        <div class="one_half comments" style="width:68%"> 
          <!-- ################################################################################################ -->
          <h2>Job Title : <%=Values.get("job_title")%></h2>
          <ul class="nospace listing" style="padding:1px 1px; margin:1px 1px">
            <li class="clear" style="padding:1px 1px; margin:1px 1px">
              <div class="imgl borderedbox"><img src="companyImages/<% out.print(Values.get("company_image")); %>" style="height:80px; width:80px;"></div>
              <p class="nospace btmspace-15"><a href="#"><%=Values.get("company_name")%></a></p>
              <p><%=Values.get("company_description")%></p>
            </li>
          </ul>
          <!-- ################################################################################################ --> 
          <table>
              <tr>
                  <th>Job Title</th>
                  <td><%=Values.get("job_title")%></td>
              </tr>
              <tr>
                  <th>Company Name</th>
                  <td><%=Values.get("company_name")%></td>
              </tr>
              <tr>
                  <th>Job Type</th>
                  <td><%=Values.get("jt_title")%></td>
              </tr>
              <tr>
                  <th>Job City</th>
                  <td><%=Values.get("city_name")%></td>
              </tr>
              <tr>
                  <th>Post Date</th>
                  <td><%=Values.get("job_post_date")%></td>
              </tr>
              <tr>
                  <th>Job Skills</th>
                  <td><%=Values.get("job_skills")%></td>
              </tr>
              <tr style="background-color:#ffffff">
                <td colspan="2">
                    <b><u>Job Description : </u></b><br /><br />
                    <%=Values.get("job_description")%>
                </td>
              </tr>
          </table>
			<div style="float:right">
				<% if(!(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("4"))) { %>
					<input value="Login to Apply" type="button" onclick="openWin('student-login.jsp')">
				<% } else if (!jobDetails.checkApplication(Values.get("job_id").toString(),session.getAttribute("student_id").toString())) { %>
					<input value="Apply for this Job" type="button" onclick="openWin('model/job.jsp?act=Apply&job_id=<%=Values.get("job_id")%>&student_id=<%=session.getAttribute("student_id")%>')">
				<% } else { %>
					<div style="color:#ff0000; font-weight:bold; font-size:12px;">You have already applied for this job.</div>
				<%} %>
			</div>
        </div>
        <!-- / Middle Column --> 
        <!-- / main body -->
       <div style="float: right">
        	<div><img src="images/save_1.jpg" style="width: 250px"></div><br>
        	<div><img src="images/save_2.jpg" style="width: 250px"></div>
        </div>
      </div>
      
      <div class="clear"></div>
    </main>
  </div>
</div>
</asp:Content>

