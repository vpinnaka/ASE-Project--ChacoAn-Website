package application;

/*import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.DriverManager;

import oracle.jdbc.driver.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

/**
 * Servlet implementation class AddMem
 */
@WebServlet("/AddMem")
public class AddMem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("i am here doGet");
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("i am here doPOst");
		System.out.println("firstname:"+request.getParameter("firstname"));
		System.out.println("lastname:"+request.getParameter("lastname"));
		System.out.println("Street Address:"+request.getParameter("stadd"));
		System.out.println("City:"+request.getParameter("city"));
		System.out.println("State:"+request.getParameter("state"));
		System.out.println("Date:"+request.getParameter("date"));
		System.out.println("Status:"+request.getParameter("status"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String stadd = request.getParameter("stadd");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String date  = request.getParameter("date");
		String status  = request.getParameter("status");
		 Connection c = null;
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  out.println("<title>Example<title>" +
		      "<body bgcolor=FFFFFF>");
		  System.out.println("i am here");
		  out.println("<h2>Record added</h2>");
	//	  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//Establish database connection
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
		         // Step 1: Allocate a database Connection object
		         c = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/test", "root", "root"); // <== Check!
		            // database-URL(hostname, port, default database), username, password

		         // Step 2: Allocate a Statement object within the Connection
		   //Code to write to database
		     Statement stmt = c.createStatement();
		     String updateString = "INSERT INTO member_new(firstname,lastname,streetadd,city,state,joindate,status) " + 
		                "VALUES ('" + firstname + "','"+lastname+"','"+stadd+"','"+city+"','"+state+"','"+date+"','"+status+"')";
		    int count = stmt.executeUpdate(updateString);
		    System.out.println("count:"+count);

		//Code to read from database
		     ResultSet results = stmt.executeQuery(
		                "SELECT memid FROM member_new ");
		     while(results.next()){
		       String s = results.getInt("memid")+"";
		       System.out.println("********************"+s);
		       out.println("<BR><STRONG>Member id is</STRONG>");
		       out.println(s);
		       
		       request.setAttribute("msgid" , s);
		       request.getRequestDispatcher("/Result.jsp").forward(request, response);
		     
		    //  RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
		     // dispatcher.forward(request,response);
		    //  getServletConfig().getServletContext()
              //.getRequestDispatcher("/Result.jsp")
              //.forward(request, response);
		     }
		      stmt.close();
		     }catch(java.sql.SQLException e){
		      System.out.println(e.toString());
		     }/* catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */ catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 out.close();
		   }

    public  void view() throws ClassNotFoundException
    {

        try
        {
            String sql="select * from member_new";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);

            while(rs.next())
            {
                rs.getInt("memid");
                rs.getString("firstname");
                rs.getString("lastname");
                rs.getString("streetadd");
                rs.getString("city");
                rs.getString("state");
                rs.getString("joindate");
                rs.getString("status");
               System.out.println(rs.getString("name"));

            }

        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return;

    }

    public  String insertuser() throws SQLException
    {

        String sql = "INSERT INTO member_new(firstname,lastname,streetadd,city,state,joindate,status) values(?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement prep = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            prep = con.prepareStatement(sql);
            prep.setString(1, "firstname");
            prep.setString(2, "lastname");
            prep.setString(3, "city");
            prep.setString(4, "state");
            prep.setString(5, "joindate");
            prep.setString(6, "status");
            prep.executeUpdate();
            prep.close();

        } 
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return "successfully added";
    }
    public  String update() throws SQLException
    {

        String sql = "update member_new set streetadd=?,city=?,state=?,status=? where firstname=?";
        Connection con = null;
        PreparedStatement prep = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            prep = con.prepareStatement(sql);
            prep.setString(1, "firstname");
            prep.setString(2, "streetadd");
            prep.setString(3, "city");
            prep.setString(4, "state");
            prep.setString(5, "status");
            prep.executeUpdate();
            prep.close();

        } 
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return "successfully update";
    }

public  String delete() throws SQLException
{

    String sql = "delete form member_new where memid=(select memid from member_new where firstname=? and lastname=?";
    Connection con = null;
    PreparedStatement prep = null;

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        prep = con.prepareStatement(sql);
        prep.setString(1, "firstname");
        prep.setString(2, "lastname");
        prep.executeUpdate();
        prep.close();

    } 
    catch (ClassNotFoundException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }
    return "successfully delete";
}

		

}
