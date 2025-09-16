import java.util.Scanner;

/*
 * Un biologo quiere una Aplicacion para contabilzar el numero de patas que tiene el total de los animales capturados.
 * la aplicacion debe mostrar el numero total de patas.
 * 
 */

public class Biologo {
	
	

	public static void main(String[] args) {
		int hormigas_patas=6;
		int arañas=8;
		int cochinillas=14;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("cuantas arañas a capturado hoy ?");
		int cantidad_araña=sc.nextInt();
		System.out.println("Cuantas hormigas a capturado hoy");
		int cantidad_hormigas=sc.nextInt();
		System.out.println("Cuantas cochinillas a capturado hoy");
		int cantidad_cochinillas=sc.nextInt();
		
		
		int total_patas_arañas=arañas*cantidad_araña;
		int total_patas_hormiga=cantidad_hormigas*hormigas_patas;
		int total_patas_cochinillas=cantidad_cochinillas*cochinillas;

		
	System.out.println("El total de Patas    "        +  (total_patas_arañas+total_patas_hormiga+total_patas_cochinillas));
		
		
		
		
		
		
		sc.close();

	}

}
