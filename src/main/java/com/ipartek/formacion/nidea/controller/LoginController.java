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

	private RequestDispatcher dispatcher;
	private String view;
	private Alert alert;

	private static final String USER = "admin";
	private static final String PASSWORD = "admin";

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

			if (logear(request)) {
				alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);
				view = "backoffice/index.jsp";
			} else {
				alert = new Alert("Valores no validos. Prueba con admin - admin", Alert.TIPO_WARNING);
				view = "views/login/index.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			view = "views/login/index.jsp";

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	private Boolean logear(HttpServletRequest request) throws Exception {
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		Boolean validado = false;

		if (USER.equalsIgnoreCase(nombre) && PASSWORD.equals(pass)) {
			validado = true;
		}
		return validado;

	}

}
