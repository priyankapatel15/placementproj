package Model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.Connect;

public class College extends Connect
{
/////Function for connect to the MySQL Server Database////////////
	public College()
    {
		Connect.connect_mysql();
    }
	//////////Save User Details /////
	public String saveCollege(HashMap collegeData)
	{
		String SQL = "INSERT INTO `college` (`college_name`, `college_city`, `college_state`, `college_country`, `college_address`, `college_email`, `college_mobile`, `college_description`, `college_website`, `college_image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int record=0; 
		String error = "";
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) collegeData.get("college_name"));
			pstmt.setString(2,(String) collegeData.get("college_city"));
			pstmt.setString(3,(String) collegeData.get("college_state"));
			pstmt.setString(4,(String) collegeData.get("college_country"));
			pstmt.setString(5,(String) collegeData.get("college_address"));
			pstmt.setString(6,(String) collegeData.get("college_email"));
			pstmt.setString(7,(String) collegeData.get("college_mobile"));
			pstmt.setString(8,(String) collegeData.get("college_description"));
			pstmt.setString(9,(String) collegeData.get("college_website"));
			pstmt.setString(10,(String) collegeData.get("college_image"));
			
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
    public HashMap getCollegeDetails(int college_id)
	{
        HashMap results = new HashMap();
        int count=0;
		try
		{
			String SQL = "SELECT * FROM `college`,`city`,`state` WHERE college_city = city_id AND college_state = state_id AND college_id = "+college_id ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
				results.put("college_name",rs.getString("college_name"));
				results.put("college_city",Integer.parseInt(rs.getString("college_city")));
				results.put("college_state",Integer.parseInt(rs.getString("college_state")));
				results.put("college_country",Integer.parseInt(rs.getString("college_country")));
				results.put("college_mobile",rs.getString("college_mobile"));
				results.put("college_email",rs.getString("college_email"));
				results.put("college_address",rs.getString("college_address"));
				results.put("college_id",rs.getString("college_id"));
				results.put("college_image",rs.getString("college_image"));
				results.put("college_description",rs.getString("college_description"));
				results.put("college_website",rs.getString("college_website"));
				results.put("city_name",rs.getString("city_name"));
				results.put("state_name",rs.getString("state_name"));
				
				count++;
            }
			if(count==0)
			{
				results.put("college_name","");
				results.put("college_city",0);
				results.put("college_state",0);
				results.put("college_country",0);
				results.put("college_mobile","");
				results.put("college_email","");
				results.put("college_address","");
				results.put("college_id","");
				results.put("college_image","");
				results.put("college_description","");
				results.put("college_website","");				
			}
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return results;
    }
    /// Update the College ////
	public String updateCollege(HashMap collegeData)
	{
		String SQL = "UPDATE `college` SET `college_name` = ?, `college_city` = ?, `college_state` = ?, `college_country` = ?, `college_address` = ?, `college_email` = ?, `college_mobile` = ?, `college_description` = ?, `college_website` = ?, `college_image` = ? WHERE `college_id` = ?;";
		String error = "";
		
		int record=0;	
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) collegeData.get("college_name"));
			pstmt.setString(2,(String) collegeData.get("college_city"));
			pstmt.setString(3,(String) collegeData.get("college_state"));
			pstmt.setString(4,(String) collegeData.get("college_country"));
			pstmt.setString(5,(String) collegeData.get("college_address"));
			pstmt.setString(6,(String) collegeData.get("college_email"));
			pstmt.setString(7,(String) collegeData.get("college_mobile"));
			pstmt.setString(8,(String) collegeData.get("college_description"));
			pstmt.setString(9,(String) collegeData.get("college_website"));
			pstmt.setString(10,(String) collegeData.get("college_image"));
			pstmt.setString(11,(String) collegeData.get("college_id"));
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
    public ArrayList getAllCollege(int typeID)
	{
		int count=0;
		String SQL = "";
		SQL = "SELECT * FROM `college`";
        ArrayList resultArray = new ArrayList();
        try
		{
			statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{		
				HashMap results = new HashMap();
				results.put("college_name",rs.getString("college_name"));
				results.put("college_city",rs.getString("college_city"));
				results.put("college_state",rs.getString("college_state"));
				results.put("college_country",rs.getString("college_country"));
				results.put("college_mobile",rs.getString("college_mobile"));
				results.put("college_email",rs.getString("college_email"));
				results.put("college_address",rs.getString("college_address"));
				results.put("college_id",rs.getString("college_id"));
				results.put("college_image",rs.getString("college_image"));
				results.put("college_description",rs.getString("college_description"));
				results.put("college_website",rs.getString("college_website"));
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
}


}
