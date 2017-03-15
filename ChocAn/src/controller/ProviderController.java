package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import application.MemberUtil;
import application.ProviderDb;
import application.Provider;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProviderController
 */
@WebServlet("/ProviderController")
public class ProviderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/AddProvider.jsp";
    private static String VERIFY = "/VerifyMember.jsp";
    private static String EDIT = "/EditProvider.jsp";
    private static String LIST_USER = "/ListProvider.jsp";
    private Provider provider;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderController() {
        super();
        provider = new Provider();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int proid = Integer.parseInt(request.getParameter("proid"));
            provider.deleteProviderDb(proid);
            forward = LIST_USER;
            request.setAttribute("providers", provider.getAllProviderDbs());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            int proid = Integer.parseInt(request.getParameter("proid"));
            request.setAttribute("proid", proid);
            request.setAttribute("providers", provider.getProviderDbById(proid));
        } else if (action.equalsIgnoreCase("listProviderDb")){
            forward = LIST_USER;
            request.setAttribute("providers", provider.getAllProviderDbs());
        } 
       else {
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
		 ProviderDb providerdb = new ProviderDb();
		 String action = request.getParameter("action");
		 providerdb.setFirstName(request.getParameter("firstname"));
		 providerdb.setLastName(request.getParameter("lastname"));
	        String doj = request.getParameter("date");
	            providerdb.setJoinDate(doj);
	        providerdb.setStreetAdd(request.getParameter("stadd"));
	        providerdb.setStatus(request.getParameter("status"));
	        providerdb.setState(request.getParameter("state"));
	        providerdb.setType(request.getParameter("type"));
	        providerdb.setCity(request.getParameter("city"));
	        String proid = request.getParameter("proid");
	        if(proid == null || proid.isEmpty() || (action.equals("add")))
	        {
	        	System.out.println("no i am here***********************************");
	            provider.addProviderDb(providerdb);
	        }
	        if(action.equals("update"))
	        {
	        	System.out.println("i am here***************************************");
	        	providerdb.setproid(Integer.parseInt(proid));
	            provider.updateProviderDb(providerdb);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("providers", provider.getAllProviderDbs());
	        view.forward(request, response);
	}

}
