package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch;

	float num1 = 0f;
	float num2 = 0f;
	int operacion = 0;
	float resultado = 0f;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Nos llaman a traves de un enlace, peticion get

		// redireccionar a la jsp
		request.getRequestDispatcher("views/calculadora/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Nos llaman a traves de un form con method="POST"

			getParamenters(request);

			// logica de negocio
			request = calcular(request);

			request.setAttribute("resultado", resultado);

			// redireccionar a la jsp
			dispatch = request.getRequestDispatcher("views/calculadora/resultado.jsp");

		} catch (NumberFormatException e2) {
			e2.printStackTrace();
			Alert alert = new Alert("Disculpe las molestias, debe introducir numeros en formato numerico",
					Alert.TIPO_DANGER);
			request.setAttribute("alert", alert);
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert("Disculpe las molestias, tenemos un fallo sin controlar", Alert.TIPO_DANGER);
			request.setAttribute("alert", alert);
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		}

		finally {
			dispatch.forward(request, response);
		}

	}

	private HttpServletRequest calcular(HttpServletRequest request) {
		switch (operacion) {
		case 0:
			resultado = num1 + num2;
			request.setAttribute("operacion", "sumar");

			break;

		case 1:
			resultado = num1 - num2;
			request.setAttribute("operacion", "restar");

			break;

		case 2:
			resultado = num1 * num2;
			request.setAttribute("operacion", "multiplicar");

			break;

		case 3:
			resultado = num1 / num2;
			request.setAttribute("operacion", "dividir");

			break;

		}
		return request;

	}

	private void getParamenters(HttpServletRequest request) {

		String sOp1 = request.getParameter("operador1");
		String sOp2 = request.getParameter("operador2");
		String sOperacion = request.getParameter("operacion");

		if (sOp1.contains(".") || sOp2.contains(".")) {
			throw new NumberFormatException();
		}
		sOp1 = sOp1.replace(",", ".");
		sOp2 = sOp2.replace(",", ".");

		num1 = Float.parseFloat(sOp1);
		num2 = Float.parseFloat(sOp2);
		operacion = Integer.parseInt(sOperacion);
		resultado = 0f;
	}

}
