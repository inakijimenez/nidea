package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger params ***Siempre STRINGS ***
		String sPatas = request.getParameter("patas");
		String sMaterial = request.getParameter("material");

		// Generar mesa. Si no hay parametros se crea vacia y si no se le ponen
		Mesa mesa = new Mesa();
		if (sPatas != null) {
			int patas = Integer.parseInt(sPatas);
			mesa.setNumeroPatas(patas);
		}

		switch (Integer.parseInt(sMaterial)) {
		case 0:
			mesa.setMaterial(1);
			;
			break;
		case 1:
			mesa.setMaterial(2);
			;
			break;
		case 2:
			mesa.setMaterial(3);
			;
			break;
		case 3:
			mesa.setMaterial(4);
			;
			break;
		}

		// Pasar atributos
		request.setAttribute("mesa", mesa);

		// ir a la jsp
		request.getRequestDispatcher("mesa.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
