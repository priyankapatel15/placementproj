/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.46
 * Generated at: 2021-10-21 17:41:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Model.*;

public final class student_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/footer.jsp", Long.valueOf(1634833434000L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1634833434000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("Model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Campus Recruitment System</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("<link href=\"layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/jquery-ui.css\">\n");
      out.write("<script src=\"js/jquery-1.10.2.js\"></script>\n");
      out.write("<script src=\"js/jquery-ui.js\"></script>\n");
      out.write("<script src=\"js/jquery.validate.js\"></script>\n");
      out.write("<style>\n");
      out.write(".ui-datepicker {\n");
      out.write("	font-family: \"Trebuchet MS\", \"Helvetica\", \"Arial\",  \"Verdana\", \"sans-serif\";\n");
      out.write("	font-size: 12px;\n");
      out.write("}\n");
      out.write(".ui-datepicker select.ui-datepicker-month, .ui-datepicker select.ui-datepicker-year {\n");
      out.write("	float:left;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("jQuery('document').ready(function() {\n");
      out.write("	jQuery(\"#Form\").validate();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body id=\"top\">\n");
      out.write("<div class=\"wrapper row0\">\n");
      out.write("  <div id=\"topbar\" class=\"clear\"> \n");
      out.write("    <nav>\n");
      out.write("      <ul>\n");
      out.write("		");
 if(session.getAttribute("login_id")!=null) { 
      out.write("\n");
      out.write("		<li>Welcome ");
 out.print(session.getAttribute("login_name")); 
      out.write("</li>\n");
      out.write("        <li><a href=\"model/login.jsp?act=logout\">Logout</a></li>\n");
      out.write("		");
 } else { 
      out.write("\n");
      out.write("		<li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("        <li><a href=\"about.jsp\">About Us</a></li>\n");
      out.write("        <li><a href=\"contact-us.jsp\">Contact Us</a></li>\n");
      out.write("		<li><a href=\"student-login.jsp\">User Login</a></li>\n");
      out.write("		<li><a href=\"login.jsp?title=Adminstrator\">Admin Login</a></li>\n");
      out.write("		");
 } 
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    </nav>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"wrapper row1\">\n");
      out.write("  <header id=\"header\" class=\"clear\"> \n");
      out.write("    <div id=\"logo\" class=\"fl_left\">\n");
      out.write("       <div style=\"float:left; margin-top:-11px;\"><h1 style=\"font-size:36px;\"><a href=\"index.jsp\">Campus Recruitment System</a></h1>\n");
      out.write("      <p style=\"color:#ffffff\">A complete solution for managing Vacancies, Placements, Colleges and Students</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"fl_right\">\n");
      out.write("      <form class=\"clear\" method=\"post\" action=\"#\">\n");
      out.write("        <fieldset>\n");
      out.write("          <legend>Search:</legend>\n");
      out.write("          <input type=\"text\" value=\"\" placeholder=\"Search Here\">\n");
      out.write("          <button class=\"fa fa-search\" type=\"submit\" title=\"Search\"><em>Search</em></button>\n");
      out.write("        </fieldset>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </header>\n");
      out.write("</div>\n");
      out.write("<div class=\"wrapper row2\">\n");
      out.write("  <div class=\"rounded\">\n");
      out.write("    <nav id=\"mainav\" class=\"clear\"> \n");
      out.write("      <ul class=\"clear\">\n");
      out.write("        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>        \n");
      out.write("        <!-- Menu System for Super Admin Login -->\n");
      out.write("        ");
 if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("1")) { 
      out.write("\n");
      out.write("		<!-- Menu System for Super Admin Login -->\n");
      out.write("		<li><a href=\"Companies.jsp\">Companies</a></li>\n");
      out.write("		<li><a href=\"Jobs.jsp?company_id=0\">All Jobs</a></li>\n");
      out.write("		<li><a href=\"#\" class=\"drop\" >Add New</a>\n");
      out.write("         <ul>\n");
      out.write("            <li><a href=\"student.jsp?student_id=0\">Add Applicatnt</a></li>\n");
      out.write("            <li><a href=\"employee.jsp?employee_id=0\">Add System User</a></li>\n");
      out.write("            <li><a href=\"job.jsp?job_id=0\">Add Job</a></li>\n");
      out.write("            <li><a href=\"company.jsp?company_id=0\">Add Company</a></li>\n");
      out.write("            <li><a href=\"college.jsp?college_id=0\">Add College</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </li>\n");
      out.write("		<li style=\"display: none;\"><a href=\"#\" class=\"drop\" >Reports</a>\n");
      out.write("          <ul>\n");
      out.write("            <li><a href=\"report-employee.jsp\">System User Report</a></li>\n");
      out.write("            <li><a href=\"report-student.jsp\">Applicant Report</a></li>\n");
      out.write("            <li><a href=\"report-job.jsp\">Job Report</a></li>\n");
      out.write("            <li><a href=\"report-company.jsp\">Company Report</a></li>\n");
      out.write("            <li><a href=\"report-college.jsp\">College Report</a></li>\n");
      out.write("            <li><a href=\"report-application.jsp\">Job Applications</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </li>\n");
      out.write("        <li><a href=\"change-password.jsp\">Change Password</a></li>\n");
      out.write("        <li><a href=\"model/login.jsp?act=logout\">Logout</a></li>\n");
      out.write("		");
 } 
      out.write("\n");
      out.write("		<!-- End of the Super Admin Menu Section -->\n");
      out.write("		\n");
      out.write("		<!-- Menu System for Student Login -->\n");
      out.write("		");
 if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("4")) { 
      out.write("		\n");
      out.write("		<li><a href=\"Companies.jsp\">Companies</a></li>\n");
      out.write("		<li><a href=\"Jobs.jsp?company_id=0\">All Jobs</a></li>\n");
      out.write("		<li><a href=\"report-application.jsp\">My Applications</a></li>\n");
      out.write("		<li><a href=\"student.jsp?student_id=");
      out.print(session.getAttribute("student_id"));
      out.write("\">My Account</a></li>\n");
      out.write("		<li><a href=\"contact-us.jsp\">Contact Us</a></li>\n");
      out.write("        <li><a href=\"model/student.jsp?act=logout\">Logout</a></li>\n");
      out.write("		");
 } 
      out.write("\n");
      out.write("		<!-- End of Employee Menu Section -->\n");
      out.write("		\n");
      out.write("		<!-- Menu System for Student Login -->\n");
      out.write("		");
 if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("2")) { 
      out.write("		\n");
      out.write("		<li><a href=\"login-home.jsp\">My Dashboard</a></li>\n");
      out.write("		<li><a href=\"report-student.jsp\">Students Lists</a></li>\n");
      out.write("		<li><a href=\"job-application.jsp\">Job Applications</a></li>\n");
      out.write("		<li><a href=\"company.jsp?company_id=");
      out.print(session.getAttribute("company_id"));
      out.write("\">My Account</a></li>\n");
      out.write("        <li><a href=\"model/company.jsp?act=logout\">Logout</a></li>\n");
      out.write("		");
 } 
      out.write("\n");
      out.write("		<!-- End of Employee Menu Section -->\n");
      out.write("		\n");
      out.write("		");
 if(session.getAttribute("login_level") == null) { 
      out.write("\n");
      out.write("			<li><a href=\"about.jsp\">About Us</a></li>\n");
      out.write("			<li><a href=\"faq-list.jsp\">FAQ</a></li>      \n");
      out.write("			<li><a href=\"Companies.jsp\">Companies</a></li>\n");
      out.write("			<li><a href=\"Colleges.jsp\">Colleges</a></li>\n");
      out.write("			<li><a href=\"Jobs.jsp?company_id=0\">All Jobs</a></li>\n");
      out.write("			<li><a href=\"register-page.jsp\">Register</a></li>\n");
      out.write("			<li><a href=\"login-page.jsp\">Login</a></li>      \n");
      out.write("			<li><a href=\"contact-us.jsp\">Contact Us</a></li>\n");
      out.write("		");
 } 
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    </nav>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Student studentDetails = new Student();
	int student_id = Integer.parseInt(request.getParameter ("student_id"));
	HashMap Values =  studentDetails.getStudentDetails(student_id);	

      out.write("\r\n");
      out.write("<div class=\"wrapper row3\">\r\n");
      out.write("  <div class=\"rounded\">\r\n");
      out.write("    ");
 if(request.getParameter("msg") != null) { 
      out.write("\r\n");
      out.write("	<div class=\"msg\">");
      out.print(request.getParameter("msg") );
      out.write("</div>\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("    <main class=\"container clear\"> \r\n");
      out.write("      <!-- main body --> \r\n");
      out.write("      <div id=\"comments\" style=\"width: 100%; float:left; margin-right:30px\">\r\n");
      out.write("      <h2>Student Registration Form</h2>\r\n");
      out.write("		<h4>Personal Details</h4>\r\n");
      out.write("		<form method=\"post\" action=\"model/student.jsp\">\r\n");
      out.write("          <div class=\"one_third first\">\r\n");
      out.write("            <label for=\"email\">Name<span>*</span></label>\r\n");
      out.write("            <input type=\"text\" name=\"student_name\" id=\"student_name\" value=\"");
 out.print(Values.get("student_name")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"one_third\">\r\n");
      out.write("            <label for=\"email\">Mobile<span>*</span></label>\r\n");
      out.write("            <input type=\"text\" name=\"student_mobile\" id=\"student_mobile\" value=\"");
 out.print(Values.get("student_mobile")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("          </div>\r\n");
      out.write("           <div class=\"one_third\">\r\n");
      out.write("            <label for=\"email\">Email<span>*</span></label>\r\n");
      out.write("            <input type=\"text\" name=\"student_email\" id=\"student_email\" value=\"");
 out.print(Values.get("student_email")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div id=\"password_row\">\r\n");
      out.write("			  <div class=\"one_third first\">\r\n");
      out.write("				<label for=\"email\">Password<span>*</span></label>\r\n");
      out.write("				<input type=\"password\" name=\"student_password\" id=\"student_password\" value=\"");
 out.print(Values.get("student_password")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("			  </div>\r\n");
      out.write("			  <div class=\"one_third\">\r\n");
      out.write("				<label for=\"email\">Confirm Password<span>*</span></label>\r\n");
      out.write("				<input type=\"password\" name=\"student_confirm_password\" id=\"student_confirm_password\" value=\"");
 out.print(Values.get("student_password")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("			  </div>\r\n");
      out.write("		  </div>\r\n");
      out.write("          <div style=\"clear:both\"></div>\r\n");
      out.write("          <h4>Qualification Details</h4>\r\n");
      out.write("          <table>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th style=\"width:160px; height:50px; vertical-align:middle\">Degree Name</th>\r\n");
      out.write("				<th style=\"width:160px; height:50px; vertical-align:middle\">College</th>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Start Year</th>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Year of Passing</th>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Subject</th>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Persantage</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th style=\"vertical-align:middle\">High School</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_high_college\" value=\"");
 out.print(Values.get("student_high_college")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_high_start\" value=\"");
 out.print(Values.get("student_high_start")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_high_pass\" value=\"");
 out.print(Values.get("student_high_pass")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_high_subject\" value=\"");
 out.print(Values.get("student_high_subject")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_high_persantage\" value=\"");
 out.print(Values.get("student_high_persantage")); 
      out.write("\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Intermediate</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_inter_college\" value=\"");
 out.print(Values.get("student_inter_college")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_inter_start\" value=\"");
 out.print(Values.get("student_inter_start")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_inter_pass\" value=\"");
 out.print(Values.get("student_inter_pass")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_inter_subject\" value=\"");
 out.print(Values.get("student_inter_subject")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_inter_persantage\" value=\"");
 out.print(Values.get("student_inter_persantage")); 
      out.write("\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Graduation</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_graduate_college\" value=\"");
 out.print(Values.get("student_graduate_college")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_graduate_start\" value=\"");
 out.print(Values.get("student_graduate_start")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_graduate_pass\" value=\"");
 out.print(Values.get("student_graduate_pass")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_graduate_subject\" value=\"");
 out.print(Values.get("student_graduate_subject")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_graduate_persantage\" value=\"");
 out.print(Values.get("student_graduate_persantage")); 
      out.write("\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th style=\"vertical-align:middle\">Post Graduation</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_pg_college\" value=\"");
 out.print(Values.get("student_pg_college")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_pg_start\" value=\"");
 out.print(Values.get("student_pg_start")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_pg_pass\" value=\"");
 out.print(Values.get("student_pg_pass")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_pg_subject\" value=\"");
 out.print(Values.get("student_pg_subject")); 
      out.write("\"></td>\r\n");
      out.write("				<td><input type=\"text\" name=\"student_pg_persantage\" value=\"");
 out.print(Values.get("student_pg_persantage")); 
      out.write("\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          <div style=\"clear:both\"></div>\r\n");
      out.write("          <h4>Address Details</h4>\r\n");
      out.write("          <div class=\"one_third first\">\r\n");
      out.write("            <label for=\"email\">City<span>*</span></label>\r\n");
      out.write("            <input type=\"text\" name=\"student_city\" id=\"student_city\" value=\"");
 out.print(Values.get("student_city")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"one_third\">\r\n");
      out.write("            <label for=\"url\">State</label>\r\n");
      out.write("            <select style=\"height: 40px; width:300px\" name=\"student_state\" required>\r\n");
      out.write("				");
 out.print(studentDetails.getStateOption((Integer) Values.get("student_state"))); 
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"one_third\">\r\n");
      out.write("            <label for=\"email\">Pincode<span>*</span></label>\r\n");
      out.write("            <input type=\"text\" name=\"student_pincode\" id=\"student_pincode\" value=\"");
 out.print(Values.get("student_pincode")); 
      out.write("\" size=\"22\" style=\"width:300px;\" required>\r\n");
      out.write("          </div>\r\n");
      out.write("		  <div class=\"one_third first\">\r\n");
      out.write("            <label for=\"email\">Full Address<span>*</span></label>\r\n");
      out.write("            <textarea style=\"width:300px; height:100px;\" name=\"student_address\" required>");
 out.print(Values.get("student_address")); 
      out.write("</textarea>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"block clear\"></div>\r\n");
      out.write("          ");
 if(session.getAttribute("login_level") == null || session.getAttribute("login_level").equals("1") || session.getAttribute("login_level").equals("4")) { 
      out.write("		\r\n");
      out.write("          <div>\r\n");
      out.write("            <input name=\"submit\" type=\"submit\" value=\"Save Details\">\r\n");
      out.write("            &nbsp;\r\n");
      out.write("            <input name=\"reset\" type=\"reset\" value=\"Reset Form\">\r\n");
      out.write("          </div>\r\n");
      out.write("          ");
 } 
      out.write("\r\n");
      out.write("		  <input type=\"hidden\" name=\"image_name\" value=\"");
 out.print(Values.get("student_image")); 
      out.write("\" />\r\n");
      out.write("		  <input type=\"hidden\" name=\"act\" value=\"Save\" />\r\n");
      out.write("		  <input type=\"hidden\" id=\"student_id\" name=\"student_id\" value=\"");
 out.print(Values.get("student_id")); 
      out.write("\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      <div class=\"clear\"></div>\r\n");
      out.write("    </main>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
 if(session.getAttribute("login_level") != null && session.getAttribute("login_level").equals("1")) { 
      out.write("		\r\n");
      out.write("	<script>\r\n");
      out.write("		 jQuery('#password_row').hide();\r\n");
      out.write("	</script>\r\n");
 } 
      out.write('\r');
      out.write('\n');
      out.write("<div class=\"wrapper row5\">\n");
      out.write("  <div id=\"copyright\" class=\"clear\"> \n");
      out.write("  \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!-- JAVASCRIPTS --> \n");
      out.write("<script src=\"layout/scripts/jquery.fitvids.min.js\"></script> \n");
      out.write("<script src=\"layout/scripts/jquery.mobilemenu.js\"></script> \n");
      out.write("<script src=\"layout/scripts/tabslet/jquery.tabslet.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
