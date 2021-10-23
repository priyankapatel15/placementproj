package Model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.Connect;

public class Faq extends Connect
{

/////Function for connect to the MySQL Server Database////////////
	public Faq()
    {
		Connect.connect_mysql();
    }
	//////////Save User Details /////
	public String saveFaq(HashMap faqData)
	{
		String SQL = "INSERT INTO faq (faq_question, faq_answer) VALUES (?, ?);";
		int record=0; 
		String error = "";
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) faqData.get("faq_question"));
			pstmt.setString(2,(String) faqData.get("faq_answer"));
			
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
    public HashMap getFaqDetails(int faq_id)
	{
        HashMap results = new HashMap();
        int count=0;
		try
		{
            String SQL =  "SELECT * FROM faq WHERE faq_id = "+faq_id ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
				results.put("faq_id",rs.getString("faq_id"));
				results.put("faq_question",rs.getString("faq_question"));
				results.put("faq_answer",rs.getString("faq_answer"));
				count++;
            }
			if(count==0)
			{
				results.put("faq_id","");
				results.put("faq_question","");
				results.put("faq_answer","");
			}
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return results;
    }
    
	public String updateFaq(HashMap faqData)
	{
		String SQL = "UPDATE faq SET faq_question = ?,faq_answer = ? WHERE faq_id = ?";
		String error = "";
		
		int record=0;	
		
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) faqData.get("faq_question"));
			pstmt.setString(2,(String) faqData.get("faq_answer"));
			pstmt.setString(3,(String) faqData.get("faq_id"));
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
    public ArrayList getAllFaq()
	{
		String SQL = "SELECT * FROM faq";
		int count=0;
        ArrayList resultArray = new ArrayList();
        try
		{
			statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{		
				HashMap results = new HashMap();
				results.put("faq_id",rs.getString("faq_id"));
				results.put("faq_question",rs.getString("faq_question"));
				results.put("faq_answer",rs.getString("faq_answer"));
				
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
}

}
