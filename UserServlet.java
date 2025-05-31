package com.sitit23.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitit23.daoimpl.UserDaoImpl;
import com.sitit23.vo.ResultVO;
import com.sitit23.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDaoImpl daoImpl = new UserDaoImpl();
	ResultVO rvo = new ResultVO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String name = request.getParameter("name");
			String stream = request.getParameter("stream");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			
			UserVO uvo = new UserVO();
			uvo.setName(name);
			uvo.setEmail(email);
			uvo.setStream(stream);
			uvo.setCity(city);
			
			rvo = daoImpl.dataInsert(uvo);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/");
			rd.include(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
