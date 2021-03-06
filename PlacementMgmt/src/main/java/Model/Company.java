package Model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.Connect;

public class Company extends Connect
{
/////Function for connect to the MySQL Server Database////////////
	public Company()
    {
		Connect.connect_mysql();
    }
	//////////Save User Details /////
	public String saveCompany(HashMap companyData)
	{
		String SQL = "INSERT INTO `company` (`company_name`, `company_city`, `company_state`, `company_country`, `company_address`, `company_email`, `company_mobile`, `company_description`, `company_website`, `company_image`, `company_password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int record=0; 
		String error = "";
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) companyData.get("company_name"));
			pstmt.setString(2,(String) companyData.get("company_city"));
			pstmt.setString(3,(String) companyData.get("company_state"));
			pstmt.setString(4,(String) companyData.get("company_country"));
			pstmt.setString(5,(String) companyData.get("company_address"));
			pstmt.setString(6,(String) companyData.get("company_email"));
			pstmt.setString(7,(String) companyData.get("company_mobile"));
			pstmt.setString(8,(String) companyData.get("company_description"));
			pstmt.setString(9,(String) companyData.get("company_website"));
			pstmt.setString(10,(String) companyData.get("company_image"));
			pstmt.setString(11,(String) companyData.get("company_password"));
			
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
	//////////////////Function for getting Users Details//////////	
    public HashMap getCompanyDetails(int company_id)
	{
        HashMap results = new HashMap();
        int count=0;
		try
		{
			String SQL = "SELECT * FROM `company` WHERE company_id = "+company_id ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
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
				results.put("company_password",rs.getString("company_password"));
				
				count++;
            }
			if(count==0)
			{
				results.put("company_password","");
				results.put("company_name","");
				results.put("company_city",0);
				results.put("company_state",0);
				results.put("company_country",0);
				results.put("company_mobile","");
				results.put("company_email","");
				results.put("company_address","");
				results.put("company_id","");
				results.put("company_image","");
				results.put("company_description","");
				results.put("company_website","");				
			}
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return results;
    }
    /// Update the Company ////
	public String updateCompany(HashMap companyData)
	{
		String SQL = "UPDATE `company` SET `company_name` = ?, `company_city` = ?, `company_state` = ?, `company_country` = ?, `company_address` = ?, `company_email` = ?, `company_mobile` = ?, `company_description` = ?, `company_website` = ?, `company_image` = ?, `company_password` = ? WHERE `company_id` = ?;";
		String error = "";
		
		int record=0;	
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) companyData.get("company_name"));
			pstmt.setString(2,(String) companyData.get("company_city"));
			pstmt.setString(3,(String) companyData.get("company_state"));
			pstmt.setString(4,(String) companyData.get("company_country"));
			pstmt.setString(5,(String) companyData.get("company_address"));
			pstmt.setString(6,(String) companyData.get("company_email"));
			pstmt.setString(7,(String) companyData.get("company_mobile"));
			pstmt.setString(8,(String) companyData.get("company_description"));
			pstmt.setString(9,(String) companyData.get("company_website"));
			pstmt.setString(10,(String) companyData.get("company_image"));
			pstmt.setString(11,(String) companyData.get("company_password"));
			pstmt.setString(12,(String) companyData.get("company_id"));
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
    public ArrayList getAllCompany(int typeID)
	{
		int count=0;
		String SQL = "";
		SQL = "SELECT * FROM `company`";
        ArrayList resultArray = new ArrayList();
        try
		{
			statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{		
				HashMap results = new HashMap();
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",rs.getString("company_city"));
				results.put("company_state",rs.getString("company_state"));
				results.put("company_country",rs.getString("company_country"));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
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
	/////Function for Getting the List////////////
	public String getCityOption(Integer SelID)
    {
		int selectedID = SelID.intValue();
    	return Connect.getOptionList("city","city_id","city_name","city_id,city_name",selectedID,"1");
    }
    /////Function for Getting the List////////////
	public String getStateOption(Integer SelID)
    {
		int selectedID = SelID.intValue();
    	return Connect.getOptionList("state","state_id","state_name","state_id,state_name",selectedID,"1");
    }
    /////Function for Getting the List////////////
	public String getCountryOption(Integer SelID)
    {
		int selectedID = SelID.intValue();
    	return Connect.getOptionList("country","country_id","country_name","country_id,country_name",selectedID,"1");
    }
    //////////////////Function for getting Login Details//////////	
    public HashMap getLoginDetails(String login_user,String login_password)
	{
        HashMap resultsArray = new HashMap();
        int count=0;
		try
		{
            String SQL =  "SELECT * FROM company WHERE company_email = '"+login_user+"' AND company_password = '"+login_password+"'" ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
				resultsArray.put("company_id",rs.getString("company_id"));
				resultsArray.put("company_name",rs.getString("company_name"));
				resultsArray.put("login_level",4);
				count++;
            }
			if(count==0)
			{
				resultsArray.put("company_id","");
				resultsArray.put("company_name","");
				resultsArray.put("login_level",0);
			}
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return resultsArray;
    }	
    //////////////////Function for checking the existing username//////////	
    public int checkUsernameExits(String login_user, int type)
	{
        HashMap resultsArray = new HashMap();
        int exits=0;
		try
		{
			String SQL = "";
			if(type == 1) {
				SQL =  "SELECT * FROM company WHERE company_email = '"+login_user+"'" ;
			}
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
				exits++;
            }
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return exits;
    }
    //////////////////Function for geting the Single Airport Details//////////	
    public boolean checkLogin(String login_user,String login_password)
	{
        int count=0;
		try
		{
            String SQL = "SELECT * FROM company WHERE company_email = '"+login_user+"' AND company_password = '"+login_password+"'" ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())	count++;    
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
		if(count==0)
			return false;
        return true;
    }
}


}
