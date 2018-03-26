package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("views/login/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			logear(request);
			dispatcher = request.getRequestDispatcher("/backoffice");

		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert("Valores no validos. Prueba con admin - admin", Alert.TIPO_WARNING);
			request.setAttribute("alert", alert);
			dispatcher = request.getRequestDispatcher("views/login/index.jsp");
		} finally {
			dispatcher.forward(request, response);
		}

	}

	private Boolean logear(HttpServletRequest request) throws Exception {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");

		if (nombre.equals("admin") && pass.equals("admin")) {
			return true;
		} else {
			throw new Exception();
		}

	}

}
