package com.ipartek.formacion.nidea.pojo;

public class MesaException extends Exception {

	public MesaException(String mensaje) {
		super(mensaje);
	}

	private static final long serialVersionUID = 1L;

	public static final String MENSAJE_PATAS = "Minimo debemos tener al menos una pata";

}
