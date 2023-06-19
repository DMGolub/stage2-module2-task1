package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", urlPatterns = "/add")
public class AddUserServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.getRequestDispatcher("jsp/add.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("doPost in AddUserServlet invoked");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		User user = new User(firstName, lastName);
		Warehouse.getInstance().addUser(user);
		request.setAttribute("user", user);
		response.sendRedirect("/add");
	}
}
