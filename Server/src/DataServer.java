import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Servlet implementation class DataServer
 */
@WebServlet("/DataServer")
public class DataServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, NoClassDefFoundError,IOException 
	{
		
	JSONObject responsejson=new JSONObject();
    try{  
    System.out.println("Server ready"); 
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDetails","vinoth","vinoth");   
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from Detail");
    JSONArray al=new JSONArray();
    while(rs.next())  
    {

       JSONObject obj=new JSONObject();
       obj.put("fname",rs.getString(1));
       obj.put("lname",rs.getString(2));
       al.put(obj);
    }
    responsejson.put("detail", al);
	PrintWriter pw=response.getWriter();
	pw.write(responsejson.toString());
	System.out.println(responsejson.toString());
	pw.close();
	}
    catch(Exception e)
    {
    	System.out.println(e);
    }

}
}
