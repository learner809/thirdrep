package com.lti;
import java.sql.*;
//import java.util.ArrayList;
import java.util.ArrayList;

public class StudentDao {
DatabaseConnector db=new DatabaseConnector();
	
public String addDetails(Student s)
{
	String result="";
	
	try
	{
		String query="Insert into college values (?,?,?,?,?,?)";
		PreparedStatement pstmt=db.getPreparedStatement(query);
		pstmt.setInt(1,s.getId());
		pstmt.setString(2, s.getCname());
		pstmt.setString(3,s.getCourseType());
		pstmt.setString(4, s.getCity());
		pstmt.setInt(5,s.getFees());
		pstmt.setString(6, s.getPincode());
		
		System.out.println("Success");
		int i=pstmt.executeUpdate();
		
		if(i==1)
		{
			result=Results.SUCCESS;
		}
		else
		{
			result=Results.FAILURE;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		result=Results.PROBLEM;
	}
	finally
	{
		db.closeConnection();
	}
	
	return result;
}

public ArrayList<Student> getAllColleges(String courseType, String city)
{
	Student s=null;
	
ArrayList<Student> list=new ArrayList<>();
	
	
	try
	{
		String query="Select * from college where courseType='"+courseType+"' and city='"+city+"'";
		ResultSet rs=db.getResultSet(query);
		while(rs.next())
		{
			s=new Student();
			s.setId(rs.getInt("id"));
			s.setCname(rs.getString("cname"));
			s.setCourseType(rs.getString("courseType"));
			s.setCity(rs.getString("city"));
			s.setFees(rs.getInt("fees"));
			
			list.add(s);
		}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	
	}
	finally
	{
		db.closeConnection();
	}
	
	return  list;
}

public String deleteCollege(Student s)
{
	String result="";
	
	try
	{
		String query="delete from college where cid=?";
		PreparedStatement pstmt=db.getPreparedStatement(query);
		pstmt.setInt(1,s.getId());
		
		int i=pstmt.executeUpdate();
		
		if(i==1)
		{
			result=Results.SUCCESS;
		}
		else
		{
			result=Results.FAILURE;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		result=Results.PROBLEM;
	}
	finally
	{
		db.closeConnection();
	}
	
	return result;
}

	

}


	