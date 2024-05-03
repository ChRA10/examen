package jcolonia.daw2023.quiniela;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que permite listar los partidos introducidos
 */
public class VistaDiálogoAltaPartido1X2 {
	
	private String str;
	
	private String equipoLocal = "Ingrese el equipo Local";
	
	private String equipoVisitante;
	
	private String resultado;
	
	private Scanner scEntrada;

	public VistaDiálogoAltaPartido1X2(String str) {
		this.str = str;
		VistaMenú menú = new VistaMenú(str, null);
		scEntrada = new Scanner(System.in);
		entradaQuiniela1X2();
	}

	public ElementoPartido1X2 entradaQuiniela1X2() {
		String datos;
		int contador = 0;
		ElementoPartido1X2 elemento = new ElementoPartido1X2();

		try {
			System.out.println("1.- Ingrese el nombre del equipo local\n2.- Ingrese el nombre del equipo visitante\n3.- Ingrese el resultado (1X2)\nIngrese las opciones");
			datos = scEntrada.nextLine();
			elemento.setDato(datos);
		} catch (Partido1X2Exception e) {
			System.out.println(e);
		} catch (DatoPartido1X2Exception e) {
			System.out.println(e);
		}

		
		return elemento;
	}

	/**
	 * Confirma si los datos introducidos son los correctos.
	 * 
	 * @param string titulo
	 * @return true si es verdadero o false si es falso
	 */
	public boolean confirmarAlta(String string) {
		if(entradaQuiniela1X2().toString().isEmpty() ) {
			return true;
		}
		return false;
	}
}
