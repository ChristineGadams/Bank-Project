package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bankentities.Bank;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("bank", bank);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String telephoneNumber = request.getParameter("telephoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		bank.writeToCustomerTxtFile(firstName, lastName, email, telephoneNumber, password);
		bank.readFromCustomerTxtFile(email, password);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		doGet(request, response);
	}

}
