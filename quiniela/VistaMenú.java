package jcolonia.daw2023.quiniela;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Vista diseñada para que el usuario sea capaz de intrepretar las opciones a escoger.
 */
public class VistaMenú {
	
	/**
	 * Scanner instanciado.
	 */
	private static Scanner scEntrada;
	
	/**
	 * Nombre que recibira el constructor y sera utilziado para el titulo.
	 */
	private String nombre;
	
	/**
	 * Pregunta al usuario por una opcion.
	 */
	private String pregunta = "Elija una opción";
	
	/**
	 * Lista de opciones disponibles para el usuario.
	 */
	private String [] listaOpciones;

	/**
	 * Valor numerico para elegir la opción del menú.
	 */
	private int opción;
	
	/**
	 * Constructor que recibe el nombre y la lista.
	 * 
	 * @param nombre del titulo
	 * @param lista de opciones
	 */
	public VistaMenú(String nombre,String[] lista) {
		this.nombre = nombre;
		this.listaOpciones = lista;
		scEntrada = new Scanner(System.in);
	}
	
	/**
	 * Muestra el nombre o título, con subrayado doble.
	 */
	public void mostrarTítuloPrincipal() {
		String línea = generarLínea(nombre, true);

//		out.println();
		out.println(línea);
		out.println(nombre);
		out.println(línea);
	}
	
	/**
	 * Facilita un interface ({@link java.util.Scanner Scanner}) único vinculado a
	 * la entrada estándar. La unicidad se consigue con un patrón al estilo
	 * «Singleton».
	 * 
	 * @return el gestor correspondiente
	 */
	public static Scanner getScEntrada() {
		if (scEntrada == null) {
			scEntrada = new Scanner(System.in);
		}
		return scEntrada;
	}
	
	/**
	 * Lista de opciones del menú.
	 */
	public void mostrarMenú() {
		for(int i=0; i < listaOpciones.length; i++) {
			System.out.printf("%d.- %s \n",i + 1 ,listaOpciones[i]);
		}
	}
	
	/**
	 * Genera una línea con guiones «-» o iguales «=» de la misma longitud que el
	 * texto facilitado. La línea resultante se puede utilizar como subrayado del
	 * texto referido.
	 * 
	 * @param texto    el texto de referencia
	 * @param realzado indicando si el carácter a utilizar será «=» (para
	 *                 <code>true</code>) o «-» (para <code>false</code>)
	 * @return el texto generado
	 */
	public static String generarLínea(String texto, boolean realzado) {
		String línea;
		String relleno = realzado ? "=" : "-";

		// A: Composición manual
		// StringBuffer línea = new StringBuffer();
		// for (int i = 0; i < texto.length(); i++) {
		// línea.append(relleno);
		// }

		// B: API Java, String...
		línea = relleno.repeat(texto.length());

		return línea;
	}
	
	/**
	 * Constructor que pregunta la elección del usuario.
	 * 
	 * @return respuesta del ususario.
	 */
	public int pedirOpción(){
		String linea;
		boolean salir = false;
		
		do {
			System.out.println(pregunta);
			linea = scEntrada.nextLine();
			try {
				opción = Integer.parseInt(linea);
				
				if(opción > 0 && opción <= listaOpciones.length) {
					salir = true;
				}else {
					System.out.println("!!Ingresa un numero valido BOBO!!");
				}
				
			} catch(Exception e) {
				System.out.print("Ingrese un numero valido BOBO!!\n");
				
			}
		} while (salir == false);
		
		return opción;
	}
}
