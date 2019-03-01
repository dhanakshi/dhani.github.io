package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.LoginDao;

import com.mvc.bean.LoginBean;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	LoginDao ld=new LoginDao(); 
	HttpSession session;
	LoginBean log;
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String username=(String)request.getAttribute("username");
			log=ld.giveProfile(username);
			session=request.getSession();
			session.setAttribute("username",log.getUserName());
			session.setAttribute("id", log.getId());
			session.setAttribute("desig", log.getDesig());
			session.setAttribute("office", log.getOffice());
			
			 request.getRequestDispatcher("Home.jsp").forward(request, response);
						// TODO Auto-generated method stub
						
		
					
			
	
		
	}

}
