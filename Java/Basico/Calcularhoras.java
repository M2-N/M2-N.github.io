import java.util.Scanner;

public class Calcularhoras {
	/*
	 * 
	 * Cree una aplicacion , que solicte al usuario , que introduzca 
	 * una cantidad de segundos .
	 * 
	 * La Aplicacion debe mostrar cuantas horas, minutos y segundos hay en en el numero de segundo ,segund
	 * Introducidos por el usuario 
	 * 
	 * 
	 * 
	 * Recordamos esto 
	 * 1 minuto tiene 60 segundos
	 * 
	 * segundos en una hora =60 minutos * 60 segundos = 3600 segundos
	 */

	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);   // Clase que permite la lectura desde teclado 
		int cantidad; // variable donde se almacenaran los segundos introducidos por el usuario
		
		System.out.println("Introduzca una cantidad de Segundos");
		cantidad=sc.nextInt(); // aqui guardamos lo introducido por el usuario ..
		
		
	int segundos=cantidad%60;   
	int minutos=(cantidad%3600)/60;
	int horas=cantidad/3600 ;
	System.out.println(cantidad + " segundos son " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");

		
		
		
		
sc.close();  // cerrando los flujos 
	}

}
