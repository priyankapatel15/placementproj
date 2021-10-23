<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>

<%
	Company companyDetails = new Company();
	ArrayList allCompany = companyDetails.getAllCompany(0);
%>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div class="scrollable">
        <h2>Company Report</h2>
		<% if(request.getAttribute("message") != null) { %>
		<div class="msg"><%=request.getAttribute("message") %></div>
		<% } %>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Image</th>
              <th>Name</th>
              <th>Mobile</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
			<% for(int i=0;i<allCompany.size();i++) 
			{ 
				HashMap CompanyDetails = new HashMap();
				CompanyDetails = (HashMap)allCompany.get(i);
			%>
				<tr>
				  <td style="text-align:center;"><% out.print(CompanyDetails.get("company_id")); %></td>
				  <td>
					<a href="company-details.jsp?company_id=<% out.print(CompanyDetails.get("company_id")); %>">
						<img src="companyImages/<% out.print(CompanyDetails.get("company_image")); %>" style="height:80px; width:80px;">
					</a>
				  </td>
				  <td><% out.print(CompanyDetails.get("company_name")); %></td>
				  <td><% out.print(CompanyDetails.get("company_mobile")); %></td>
				  <td><% out.print(CompanyDetails.get("company_email")); %></td>
				  <td> <a href="company.jsp?company_id=<% out.print(CompanyDetails.get("company_id")); %>">Edit</a> </td>
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
