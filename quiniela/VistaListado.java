package jcolonia.daw2023.quiniela;

import java.util.List;

/**
 * Lista los partidos que contiene el conjunto.
 */
public class VistaListado {

	/**
	 * Un texto
	 */
	private String str;
	
	private List<String> lista;
	
	/**
	 * Instancia del conjunto.
	 */
	private ConjuntoQuiniela1X2 conjunto;
	
	/**
	 * Constructor con parametro para el titulo
	 * 
	 * @param str titulo recibido
	 */
	public VistaListado(String str) {
		this.str = str;
	}

	/**
	 * Lista los partidos que se encuentren almacenados en ese momento.
	 * 
	 * @param lista que contiene los partidos
	 */
	public void mostrar(List<ElementoPartido1X2> lista) {
		this.lista = lista;
		System.out.println(str);
		
		this.conjunto.lista = lista;
		
		 if (conjunto.generarListado().isEmpty() || conjunto.generarListado() == null) {
	            System.out.println("¡No hay partidos para mostrar!");
	     } else {
			for (String elemento : conjunto.generarListado()) {
	            System.out.println(elemento);
	        }
	        System.out.println();
	     }
	}
}
