package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogriddb", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//read
	public String readEmployee()  
	{   
		String output = ""; 
	
		try   
		{    
			Connection con = connect(); 
		
			if (con == null)    
			{
				return "Error while connecting to the database for reading."; 
			} 
	 
			// Prepare the html table to be displayed    
			output = "<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>Employee ID</th>"
					+ "			<th>Employee Name</th>"
					+ "			<th>Employee Type</th>"
					+ "			<th>Employee Email</th>"
					+ "			<th>Employee Password</th>"
					+ "			<th>Employee Phone</th>"
					+ "		</tr>";
	 
			String query = "SELECT * FROM employee";
			Statement stat = con.createStatement();
			ResultSet rSet = stat.executeQuery(query);
	 
			// iterate through the rows in the result set    
			while(rSet.next()) {
				String empId = Integer.toString(rSet.getInt("empId"));
				String empName = rSet.getString("empName");
				String empType = rSet.getString("empType");
				String empEmail = rSet.getString("empEmail");
				String empPassword = rSet.getString("empPassword");
				String empPhone = rSet.getString("empPhone");

				// Add into the HTML table 
				output += "<tr><td><input id='hidEmployeeIDUpdate' name='hidEmployeeIDUpdate' type='hidden' value='" + empId + "'>" + empId + "</td>";
				output += 	"<td>" + empName +  "</td>";
				output += 	"<td>" + empType +  "</td>";
				output += 	"<td>" + empEmail +  "</td>";
				output += 	"<td>" + empPassword +  "</td>";
				output += 	"<td>" + empPhone +  "</td>";
				output += 	"</tr>";

				// buttons     
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-employeeid='" + empId + "'></td>"       
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-employeeid='" + empId + "'>" + "</td></tr>"; 
		
			}
			con.close(); 
	 
			// Complete the HTML table    
			output += "</table>";   
		}   
		catch (Exception e)   
		{    
			output = "Error while reading the Employee.";    
			System.err.println(e.getMessage());   
		} 
	 
		return output;  
	}
	
	//insert employee data
	public String insertEmployee(String empName, String empType, String empEmail, String empPassword, String empPhone)  
	{   
		String output = ""; 
	 
		try
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{
				return "Error while connecting to database";
			} 
	 
			// create a prepared statement 
			String query = "INSERT INTO employee (`empId`, `empName`,`empType`, `empEmail`, `empPassword`, `empPhone` )\"\r\n"
					+ "							+ \"VALUES (?,?,?,?,?,?)"; 
	 
	 
			PreparedStatement prepStat = con.prepareStatement(query);
	 
			// binding values    
			prepStat.setInt(1, 0);
			prepStat.setString(2, empName);
			prepStat.setString(3, empType);
			prepStat.setString(4, empEmail);
			prepStat.setString(5, empPassword);
			prepStat.setString(6, empPhone);
			
			// execute the statement    
			prepStat.execute();    
			con.close(); 
	   
			String newEmployee = readEmployee(); 
//			output =  "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";   
			output = "Employee Inserted Successfully!";

		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the Employee.\"}";  
			System.err.println(e.getMessage());   
		} 
		
	  return output;  
	}
	
	//update
	
	public String updateEmployee(String empId, String empName, String empType, String empEmail, String empPassword, String empPhone)    
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{
				return "Error while connecting to database.";
			} 
	 
			// create a prepared statement    
			String query = "UPDATE employee SET empName=?, empType=?, empEmail=?, empPassword=?, empPhone=? where empId=?"; 
	 
			PreparedStatement prepStat = con.prepareStatement(query);
			
			//binding values
			prepStat.setInt(1, 0);
			prepStat.setString(2, empName);
			prepStat.setString(3, empType);
			prepStat.setString(4, empEmail);
			prepStat.setString(5, empPassword);
			prepStat.setString(6, empPhone);
			
			 // execute the statement
			prepStat.execute();    
			con.close(); 
	 
			String newEmployee = readEmployee();    
			output = "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the Employee.\"}";   
			System.err.println(e.getMessage());   
		} 
	 
	  return output;  
	} 
	
	//delete
	public String deleteEmployee(String empID)   
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{
				return "Error while connecting to the database for deleting."; 
			} 
	 
			// create a prepared statement    
			String query = "DELETE FROM employee WHERE empId=?";  
	 
			PreparedStatement prepStat = con.prepareStatement(query); 
	 
			// binding values    
			prepStat.setInt(1, Integer.parseInt(empId)); 
	 
			// execute the statement    
			prepStat.execute();    
			con.close(); 
	 
			String newEmployee = newEmployee();  
			    
			output = "{\"status\":\"success\", \"data\": \"" +  newEmployee + "\"}";    
		}   
		catch (Exception e)   
		{    
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the employee.\"}";    
			System.err.println(e.getMessage());   
		} 
	 
		return output;  
	}
}
