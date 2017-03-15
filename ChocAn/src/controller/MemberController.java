package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import application.MemberUtil;
import application.MemberDb;
import application.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/AddMem.jsp";
    private static String EDIT = "/EditMem.jsp";
    private static String VALID = "/ValidMem.jsp";
    private static String LIST_USER = "/ListMember.jsp";
    private Member member;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        member = new Member();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        String isvalid = null;
        MemberDb memberdb = new MemberDb();
		 
        if (action.equalsIgnoreCase("delete")){
            int memid = Integer.parseInt(request.getParameter("memid"));
            member.deleteMemberDb(memid);
            forward = LIST_USER;
            request.setAttribute("members", member.getAllMemberDbs());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            int memid = Integer.parseInt(request.getParameter("memid"));
            request.setAttribute("memid", memid);
            request.setAttribute("members", member.getMemberDbById(memid));
        } else if (action.equalsIgnoreCase("listMemberDb")){
            forward = LIST_USER;
            request.setAttribute("members", member.getAllMemberDbs());
        }else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 MemberDb memberdb = new MemberDb();
		 String isvalid= null;
		 String action = request.getParameter("action");
		 memberdb.setFirstName(request.getParameter("firstname"));
		 memberdb.setLastName(request.getParameter("lastname"));
	        String doj = request.getParameter("date");
	            memberdb.setJoinDate(doj);
	        memberdb.setStreetAdd(request.getParameter("stadd"));
	        memberdb.setStatus(request.getParameter("status"));
	        memberdb.setState(request.getParameter("state"));
	        memberdb.setCity(request.getParameter("city"));
	        String memid = request.getParameter("memid");
	        System.out.println("*********************************"+memid+"*********"+action);
	        if(action.equals("add"))
	        {
	        	System.out.println("no i am here***********************************");
	            member.addMemberDb(memberdb);
	        }
	        if(action.equals("update"))
	        {
	        	System.out.println("i am here***************************************");
	        	memberdb.setMemid(Integer.parseInt(memid));
	            member.updateMemberDb(memberdb);
	        }
	        if(action.equals("verify"))
	        {
	        	System.out.println("i am here in verify***************************************"+memid);
	        	memberdb = member.getMemberDbById(Integer.parseInt(memid));
	        	if(memberdb.getStatus() == null)
	        	{
	        		isvalid = "no";
	        	}else if(memberdb.getStatus().equals("active")){
	        		isvalid="yes";	
	        	}else {
	        		isvalid = "no";
	        	}
	        	
	        	LIST_USER = VALID ; 
	        	request.setAttribute("isvalid", isvalid);
	        	
	        	
	        } 
	        
	       RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("members", member.getAllMemberDbs());
	        view.forward(request, response);
	}

}
