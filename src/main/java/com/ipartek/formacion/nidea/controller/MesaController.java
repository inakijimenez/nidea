package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;
import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Mesa m = new Mesa();
			MaterialDAO dao = new MaterialDAO();
			ArrayList<Material> listaMateriales = dao.getAll();

			// recoger parametros *** SIEMPRE String ***
			String sPatas = request.getParameter("patas");

			// Si parametros no son NULL recoger y crear mesa a medida
			if (sPatas != null) {

				int patas = Integer.parseInt(sPatas);
				try {
					m.setNumeroPatas(patas);
				} catch (Exception e) {
					try {
						m.setNumeroPatas(1);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					Alert alert = new Alert(e.getMessage(), Alert.TIPO_WARNING);
					request.setAttribute("alert", alert);
				}

				String sDimnesion = request.getParameter("dimension");
				int dimension = Integer.parseInt(sDimnesion);
				m.setDimension(dimension);

				String sCustom = request.getParameter("custom");
				if (sCustom == null) {
					m.setCustom(false);
				} else { // viene 'on'
					m.setCustom(true);

					// color
					String color = request.getParameter("color");
					m.setColor(color);
				}

				String sMaterialId = request.getParameter("material");
				int idMaterial = Integer.parseInt(sMaterialId);

				if (idMaterial != -1) {
					m.setMaterial(new Material());
					m.getMaterial().setId(listaMateriales.get(idMaterial).getId());
					m.getMaterial().setPrecio(listaMateriales.get(idMaterial).getPrecio());
					m.getMaterial().setNombre(listaMateriales.get(idMaterial).getNombre());
				}

			}

			// enviar atributos a la JSP
			request.setAttribute("mesa", m);
			request.setAttribute("materiales", dao.getAll());

			// ir a la JSP
			view = "mesa.jsp";

		} catch (NumberFormatException e) {

			e.printStackTrace();

		} finally {
			request.getRequestDispatcher("mesa.jsp").forward(request, response);
		}

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