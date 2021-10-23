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
      <!-- ################################################################################################ -->
      <div class="group btmspace-30">
        <!-- Middle Column -->
        <div class="one_half" style="width:68%"> 
          <!-- ################################################################################################ -->
          <h2>Search Company By Companies</h2>
          <ul class="nospace listing" style="padding:1px 1px; margin:1px 1px">
          <% for(int i=0;i<allCompany.size();i++) 
			{ 
				HashMap CompanyDetails = new HashMap();
				CompanyDetails = (HashMap)allCompany.get(i);
		  %>
            <li class="clear" style="padding:1px 1px; margin:1px 1px">
              <div class="imgl borderedbox"><a href="Jobs.jsp?company_id=<%=CompanyDetails.get("company_id")%>"><img src="companyImages/<% out.print(CompanyDetails.get("company_image")); %>" style="height:80px; width:80px;"></a></div>
              <p class="nospace btmspace-15"><a href="Jobs.jsp?company_id=<%=CompanyDetails.get("company_id")%>"><%=CompanyDetails.get("company_name")%></a></p>
              <p><%=CompanyDetails.get("company_description")%></p>
            </li>
           <%
              }
           %>
          </ul>
          <!-- ################################################################################################ --> 
        </div>
        <!-- / Middle Column --> 
         <div style="float: right">
        	<div><img src="images/save_1.jpg" style="width: 250px"></div><br>
        	<div><img src="images/save_2.jpg" style="width: 250px"></div>
        </div>
      </div>
      <!-- / main body -->
      
      <div class="clear"></div>
    </main>
  </div>
</div>
<%@ include file="includes/footer.jsp" %>


