<%@ include file="includes/header.jsp" %>
<%@ page import= "java.util.*" %>
<%@ page import= "Model.*" %>
<%
	Company companyDetails = new Company();
	int company_id = Integer.parseInt(request.getParameter ("company_id"));
	HashMap Values =  companyDetails.getCompanyDetails(company_id);	
%>
<script>
function validImage() {
	var val = $("#company_image").val();
	var id = $("#company_id").val();
	if(id == '' || val != '')
	{
		if(val == '') {
			alert('Choose the Company Image');
			return false;
		}
		if (!val.match(/(?:gif|jpg|png|bmp)$/)) {
			// inputted file path is not an image of one of the above types
			alert("inputted file path is not an image!");
			return false;
		}
	}
	return true;
}
</script>
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <div id="comments" style="width: 70%; float:left; margin-right:30px">
      <% if(request.getAttribute("message")!=null) { %>
		<div class="msg"> <% out.print(request.getAttribute("message")); %></div><br />
	  <% } %>
		<form method="post" action="UploadCompany" enctype="multipart/form-data" onsubmit="return validImage()">
  		  <div style="clear:both"></div>
		  <h4>Company Login Details</h4>
          <div class="half_width">
            <label for="email">Company Email<span>*</span></label>
            <input type="text" name="company_email" id="company_email" value="<% out.print(Values.get("company_email")); %>" size="22" style="width:300px;" required>
          </div>
          <div id="password_row">
			  <div class="half_width">
				<label for="email">Password<span>*</span></label>
				<input type="password" name="company_password" id="company_password" value="<% out.print(Values.get("company_password")); %>" size="22" style="width:300px;" required>
			  </div>
			  <div class="half_width">
				<label for="email">Confirm Password<span>*</span></label>
				<input type="password" name="company_confirm_password" id="company_confirm_password" value="<% out.print(Values.get("company_password")); %>" size="22" style="width:300px;" required>
			  </div>
		  </div>
		  <div style="clear:both"></div>
          <h4>Company Details</h4>
          <div class="half_width">
            <label for="email">Company Name<span>*</span></label>
            <input type="text" name="company_name" id="company_name" value="<% out.print(Values.get("company_name")); %>" size="22" style="width:300px;" required>
          </div>
          <div class="half_width">
            <label for="email">Company Contact Number<span>*</span></label>
            <input type="text" name="company_mobile" id="company_mobile" value="<% out.print(Values.get("company_mobile")); %>" size="22" style="width:300px;" required>
          </div>
          <div class="half_width">
            <label for="email">Company Website<span>*</span></label>
            <input type="text" name="company_website" id="company_website" value="<% out.print(Values.get("company_website")); %>" size="22" style="width:300px;" required>
          </div>
          <div class="half_width">
            <label for="email">Company Contact Number<span>*</span></label>
            <input type="text" name="company_mobile" id="company_mobile" value="<% out.print(Values.get("company_mobile")); %>" size="22" style="width:300px;" required>
          </div>
           <div class="half_width">
            <label for="email">Company City<span>*</span></label>
            <select style="height: 40px; width:300px" name = "company_city" id = "company_city" required>
            	<% out.print(companyDetails.getCityOption((Integer) Values.get("company_city"))); %>
            </select>
          </div>
          <div class="half_width">
            <label for="email">Company State<span>*</span></label>
            <select style="height: 40px; width:300px" name = "company_state" id = "company_state" required>
            	<% out.print(companyDetails.getStateOption((Integer) Values.get("company_state"))); %>
            </select>
          </div>
          <div class="half_width">
            <label for="email">Company Country<span>*</span></label>
            <select style="height: 40px; width:300px" name = "company_country" id = "company_country" required>
            	<% out.print(companyDetails.getCountryOption((Integer) Values.get("company_country"))); %>
            </select>
          </div>
          <div class="half_width">
            <label for="email">Company Logo<span>*</span></label>
            <input type="file" name="company_image" id="company_image" style="width:300px">
          </div>
          <div class="half_width">
            <label for="email">Company Address<span>*</span></label>
			<textarea style="width:300px; height:100px;" name="company_address" required><% out.print(Values.get("company_address")); %></textarea>
          </div> 
          <div class="half_width">
            <label for="email">Description<span>*</span></label>
			<textarea style="width:300px; height:100px;" name="company_description" required><% out.print(Values.get("company_description")); %></textarea>
          </div>
          <% if(!Values.get("company_image").equals("")) { %>
          <div class="half_width">
			<img src="companyImages/<% out.print(Values.get("company_image")); %>" style="height:100px; width:100px;">
          </div>
          <% } %>
          <div class="block clear"></div>
          <div>
            <input name="submit" type="submit" value="Save Company">
            &nbsp;
            <input name="reset" type="reset" value="Reset Form">
          </div>
		  <input type="hidden" name="image_name" value="<% out.print(Values.get("company_image")); %>" />
		  <input type="hidden" name="act" value="Save" />
		  <input type="hidden" name="type_id" value="0" />
		  <input type="hidden" id="company_id" name="company_id" value="<% out.print(Values.get("company_id")); %>"/>
		  <input type="hidden" id="company_id" name="company_session_id" value="<% out.print(session.getAttribute("company_id")); %>"/>
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
