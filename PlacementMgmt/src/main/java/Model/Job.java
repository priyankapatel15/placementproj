package Model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.Connect;

public class Job extends Connect
{
	 /////Function for connect to the MySQL Server Database////////////
		public Job()
	    {
			Connect.connect_mysql();
	    }
		//////////Save User Details /////
		public String saveJob(HashMap jobData)
		{
			String SQL = "INSERT INTO `job` (`job_company_id`, `job_title`, `job_skills`, `job_post_date`, `job_city`, `job_description`, `job_jt_id`) VALUES (?, ?, ?, ?, ?, ?, ?);";
			int record=0; 
			String error = "";
			
			try
			{
				pstmt = connection.prepareStatement(SQL);
				pstmt.setString(1,(String) jobData.get("job_company_id"));
				pstmt.setString(2,(String) jobData.get("job_title"));
				pstmt.setString(3,(String) jobData.get("job_skills"));
				pstmt.setString(4,(String) jobData.get("job_post_date"));
				pstmt.setString(5,(String) jobData.get("job_city"));
				pstmt.setString(6,(String) jobData.get("job_description"));
				pstmt.setString(7,(String) jobData.get("job_jt_id"));
				
				record = pstmt.executeUpdate();
				pstmt.close();
				connection.close();
			}
			catch(Exception e)
			{
				StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
			}
			return error;
		}
		//////////Save User Details /////
		public String apply(String jobID, String studentID)
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			String  SQL = "INSERT INTO `apply` (`apply_job_id`, `apply_user_id`, `apply_date`) VALUES (?, ?, ?);";
			int record=0; 
			String error = "";
			
			try
			{
				pstmt = connection.prepareStatement(SQL);
				pstmt.setString(1,jobID);
				pstmt.setString(2,studentID);
				pstmt.setString(3,todayDate);
				
				record = pstmt.executeUpdate();
				pstmt.close();
				connection.close();
			}
			catch(Exception e)
			{
				StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
			}
			return error;
		}
		//////////Check for the application /////
		public boolean checkApplication(String jobID, String userID)
		{
			String SQL = "SELECT* from apply WHERE  apply_job_id = '" + jobID + "' AND  apply_user_id = '" + userID + "'";
			int record=0; 
			String error = "";
			int count=0;
			boolean applied = false;
			try
			{
				statement = connection.createStatement();
	            rs = statement.executeQuery(SQL);
	            while(rs.next())
	            {
					count = 1;
				}
			}
			catch(Exception e)
			{
				StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
			}
			if(count == 0)
				return false;
			return true;
		}
		//////////////////Function for getting Users Details//////////	
	    public HashMap getJobDetails(int job_id)
		{
	        HashMap results = new HashMap();
	        int count=0;
			try
			{
	            String SQL =  "SELECT * FROM job, company, job_type, city WHERE city_id = job_city AND job_company_id = company_id AND job_jt_id = jt_id AND job_id = "+job_id ;
	            statement = connection.createStatement();
	            rs = statement.executeQuery(SQL);
	            while(rs.next())
				{
					results.put("job_id",rs.getString("job_id"));
					results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
					results.put("job_title",rs.getString("job_title"));
					results.put("job_skills",rs.getString("job_skills"));
					results.put("job_post_date",rs.getString("job_post_date"));
					results.put("job_city",Integer.parseInt(rs.getString("job_city")));
					results.put("job_description",rs.getString("job_description"));
					results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
					results.put("company_name",rs.getString("company_name"));
					results.put("company_city",Integer.parseInt(rs.getString("company_city")));
					results.put("company_state",Integer.parseInt(rs.getString("company_state")));
					results.put("company_country",Integer.parseInt(rs.getString("company_country")));
					results.put("company_mobile",rs.getString("company_mobile"));
					results.put("company_email",rs.getString("company_email"));
					results.put("company_address",rs.getString("company_address"));
					results.put("company_id",rs.getString("company_id"));
					results.put("company_image",rs.getString("company_image"));
					results.put("company_description",rs.getString("company_description"));
					results.put("company_website",rs.getString("company_website"));
					results.put("jt_title",rs.getString("jt_title"));
					results.put("city_name",rs.getString("city_name"));
					count++;
	            }
				if(count==0)
				{
					results.put("job_id","");
					results.put("job_company_id",0);
					results.put("job_title","");
					results.put("job_skills","");
					results.put("job_post_date","");
					results.put("job_city",0);
					results.put("job_description","");
					results.put("job_jt_id",0);
				}
	         }
			 catch(Exception e)
			 {
	            System.out.println("Error is: "+ e);
	       	 }
	        return results;
	    }
	    
		public String updateJob(HashMap jobData)
		{
			String SQL = "UPDATE `job` SET `job_company_id` = ?, `job_title` = ?, `job_skills` = ?, `job_post_date` = ?, `job_city` = ?, `job_description` = ?, `job_jt_id` = ? WHERE `job_id` = ?;";
			String error = "";
			
			int record=0;	
			
			try
			{
				pstmt = connection.prepareStatement(SQL);
				pstmt.setString(1,(String) jobData.get("job_company_id"));
				pstmt.setString(2,(String) jobData.get("job_title"));
				pstmt.setString(3,(String) jobData.get("job_skills"));
				pstmt.setString(4,(String) jobData.get("job_post_date"));
				pstmt.setString(5,(String) jobData.get("job_city"));
				pstmt.setString(6,(String) jobData.get("job_description"));
				pstmt.setString(7,(String) jobData.get("job_jt_id"));
				pstmt.setString(8,(String) jobData.get("job_id"));
				record = pstmt.executeUpdate();
				pstmt.close();
				connection.close();
			}
			catch(Exception e)
			{
				StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
			}
			return error;
		}

		////////////////Function for getting all the Airport Details////////////////////  
	    public ArrayList getAllJob(int companyID)
		{
			String SQL;
			if(companyID == 0)
				SQL = "SELECT * FROM job, company, job_type WHERE job_company_id = company_id AND job_jt_id = jt_id";
			else
				SQL = "SELECT * FROM job, company, job_type WHERE job_company_id = company_id AND job_jt_id = jt_id AND company_id = "+companyID;
			int count=0;
	        ArrayList resultArray = new ArrayList();
	        try
			{
				statement = connection.createStatement();
	            rs = statement.executeQuery(SQL);
	            while(rs.next())
				{		
					HashMap results = new HashMap();
					results.put("job_id",rs.getString("job_id"));
					results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
					results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
					results.put("job_title",rs.getString("job_title"));
					results.put("job_skills",rs.getString("job_skills"));
					results.put("job_post_date",rs.getString("job_post_date"));
					results.put("job_city",Integer.parseInt(rs.getString("job_city")));
					results.put("job_description",rs.getString("job_description"));
					results.put("company_name",rs.getString("company_name"));
					results.put("company_city",Integer.parseInt(rs.getString("company_city")));
					results.put("company_state",Integer.parseInt(rs.getString("company_state")));
					results.put("company_country",Integer.parseInt(rs.getString("company_country")));
					results.put("company_mobile",rs.getString("company_mobile"));
					results.put("company_email",rs.getString("company_email"));
					results.put("company_address",rs.getString("company_address"));
					results.put("company_id",rs.getString("company_id"));
					results.put("company_image",rs.getString("company_image"));
					results.put("company_description",rs.getString("company_description"));
					results.put("company_website",rs.getString("company_website"));
					results.put("jt_title",rs.getString("jt_title"));
					
					count++;
	                resultArray.add(results);
	            }
	         }
			catch(Exception e)
			{
	            System.out.println("Error is: "+ e);
	        }
	        return resultArray;
	    }
	    ////////////////Function for getting all the Airport Details////////////////////  
	    public ArrayList getAllApplication(int apply_user_id)
		{
			String SQL;
			String error="";
			if(apply_user_id == 0)
				SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id";
			else
				SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id AND apply_user_id = "+apply_user_id;
			int count=0;
	        ArrayList resultArray = new ArrayList();
	        try
			{
				statement = connection.createStatement();
	            rs = statement.executeQuery(SQL);
	            while(rs.next())
				{		
					HashMap results = new HashMap();
					results.put("job_id",rs.getString("job_id"));
					results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
					results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
					results.put("job_title",rs.getString("job_title"));
					results.put("job_skills",rs.getString("job_skills"));
					results.put("job_post_date",rs.getString("job_post_date"));
					results.put("job_city",Integer.parseInt(rs.getString("job_city")));
					results.put("job_description",rs.getString("job_description"));
					results.put("company_name",rs.getString("company_name"));
					results.put("company_city",Integer.parseInt(rs.getString("company_city")));
					results.put("company_state",Integer.parseInt(rs.getString("company_state")));
					results.put("company_country",Integer.parseInt(rs.getString("company_country")));
					results.put("company_mobile",rs.getString("company_mobile"));
					results.put("company_email",rs.getString("company_email"));
					results.put("company_address",rs.getString("company_address"));
					results.put("company_id",rs.getString("company_id"));
					results.put("company_image",rs.getString("company_image"));
					results.put("company_description",rs.getString("company_description"));
					results.put("company_website",rs.getString("company_website"));
					results.put("jt_title",rs.getString("jt_title"));
					results.put("student_name",rs.getString("student_name"));
					results.put("student_mobile",rs.getString("student_mobile"));
					results.put("student_email",rs.getString("student_email"));
					results.put("student_password",rs.getString("student_password"));
					results.put("student_address",rs.getString("student_address"));
					results.put("student_city",rs.getString("student_city"));
					results.put("student_state",Integer.parseInt(rs.getString("student_state")));
					results.put("student_pincode",rs.getString("student_pincode"));	
					results.put("student_id",rs.getString("student_id"));			
					results.put("apply_date",rs.getString("apply_date"));			
									
					count++;
	                resultArray.add(results);
	            }
	         }
			catch(Exception e)
			{
	            StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
	        }
	        return resultArray;
	    }
	    ////////////////Function for getting all the Airport Details////////////////////  
	    public ArrayList getJobApplication(int company_id)
		{
			String SQL;
			String error="";
			SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id AND job_company_id = "+company_id;
			int count=0;
	        ArrayList resultArray = new ArrayList();
	        try
			{
				statement = connection.createStatement();
	            rs = statement.executeQuery(SQL);
	            while(rs.next())
				{		
					HashMap results = new HashMap();
					results.put("job_id",rs.getString("job_id"));
					results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
					results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
					results.put("job_title",rs.getString("job_title"));
					results.put("job_skills",rs.getString("job_skills"));
					results.put("job_post_date",rs.getString("job_post_date"));
					results.put("job_city",Integer.parseInt(rs.getString("job_city")));
					results.put("job_description",rs.getString("job_description"));
					results.put("company_name",rs.getString("company_name"));
					results.put("company_city",Integer.parseInt(rs.getString("company_city")));
					results.put("company_state",Integer.parseInt(rs.getString("company_state")));
					results.put("company_country",Integer.parseInt(rs.getString("company_country")));
					results.put("company_mobile",rs.getString("company_mobile"));
					results.put("company_email",rs.getString("company_email"));
					results.put("company_address",rs.getString("company_address"));
					results.put("company_id",rs.getString("company_id"));
					results.put("company_image",rs.getString("company_image"));
					results.put("company_description",rs.getString("company_description"));
					results.put("company_website",rs.getString("company_website"));
					results.put("jt_title",rs.getString("jt_title"));
					results.put("student_name",rs.getString("student_name"));
					results.put("student_mobile",rs.getString("student_mobile"));
					results.put("student_email",rs.getString("student_email"));
					results.put("student_password",rs.getString("student_password"));
					results.put("student_address",rs.getString("student_address"));
					results.put("student_city",rs.getString("student_city"));
					results.put("student_state",Integer.parseInt(rs.getString("student_state")));
					results.put("student_pincode",rs.getString("student_pincode"));	
					results.put("student_id",rs.getString("student_id"));			
					results.put("apply_date",rs.getString("apply_date"));			
									
					count++;
	                resultArray.add(results);
	            }
	         }
			catch(Exception e)
			{
	            StringWriter writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter( writer );
				e.printStackTrace( printWriter );
				printWriter.flush();
				String stackTrace = writer.toString();
				error+="Error : "+stackTrace;
				System.out.println(" Error : "+ e.toString());
	        }
	        return resultArray;
	    }
	    /////Function for Getting the List////////////
		public String getCityOption(Integer SelID)
	    {
			int selectedID = SelID.intValue();
	    	return Connect.getOptionList("city","city_id","city_name","city_id,city_name",selectedID,"1");
	    }
	    /////Function for Getting the List////////////
		public String getCompanyOption(Integer SelID)
	    {
			int selectedID = SelID.intValue();
	    	return Connect.getOptionList("company","company_id","company_name","company_id,company_name",selectedID,"1");
	    }
	    /////Function for Getting the List////////////
		public String getJobTypeOption(Integer SelID)
	    {
			int selectedID = SelID.intValue();
	    	return Connect.getOptionList("job_type","jt_id","jt_title","jt_id,jt_title",selectedID,"1");
	    }
	}


}
