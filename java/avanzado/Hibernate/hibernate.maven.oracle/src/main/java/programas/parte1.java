package programas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Alumnos;
import modelo.Calendario;
import modelo.CalendarioId;
import modelo.Cursos;
import modelo.Equipos;
import modelo.Participantes;
import modelo.Profesores;
import modelo.Tutorias;

public class parte1 {

	public static void main(String[] args) {
		
        ejercicio1();
	    ejercicio2();
		ejercicio3();

	}

	static void ejercicio1() {
		Scanner sc = new Scanner(System.in);
		Integer IdActividad;
		String fecha;
		String hora ;
		String lugar;

		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();  //INICIO LA SESSION

			System.out.println("Introduce el Id actividad");
			String id_cadena = sc.nextLine();    // PARA EVITARME ERRORES LO GUARDO EN UN STRING Y LUEGO 
			                                      // LO VUELVO A INTEGER

			IdActividad = Integer.parseInt(id_cadena);

			System.out.println("Introduce la fecha ");
			fecha = sc.nextLine();

			System.out.println("Introduce la hora ");
			hora = sc.nextLine();

			System.out.println("Introduce el lugar  ");
			lugar = sc.nextLine();

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");    // PARA ADMITIR ESTE FORMATO IGUAL QUE 
			                                                                  // QUE LA BASE DE DATOS
			Date fechadate = formato.parse(fecha);

			CalendarioId id = new CalendarioId();    // COMO ES UNA CLASE EMBLEFABLED CREO EL OBJECTO
			id.setActividad(IdActividad);            // UTILIZO LOS SET PARA GUARDAR LA INFORMACION
			id.setFechaevento(fechadate);
			id.setHora(hora);
			id.setLugar(lugar);

			
			Calendario calendario = (Calendario) session.get(Calendario.class, id);  // LUEGO CREO Y CARGO EL OBJECTO
                                                                                    // CON LA CLASE CALENDARIO
			
			/*
			 * RECORRO EL OBJECTO CALENDARIO E IMPRIMO LOS DATOS QUE SE SOLICITAN ,HACEDIENDO DIRECTAMENTE
			 * DESDE LA CLASE CALENDARIO
			 */
			System.out.println("*********Calendario************");
			System.out.println("Nombre  Actividad " + "\t" + calendario.getActividad().getActividad());
			System.out.println("Nombre Equipos Enfrentados " + "\t" + calendario.getEquipoA().getNombre());
			System.out.println("Nombre Equipos Enfrentados " + "\t" + calendario.getEquipoB().getNombre());
			/*
			 * Voy acceder alos participantes DESDE LA CLASE CALENDATRIO Y VOY CREAR DOS LISTAS
			 * 
			 * UNA POR CADA EQUIPO
			 */
			List<Participantes> participanteEquipoA = calendario.getEquipoA().getParticipantes();
			List<Participantes> participantesEquipoB = calendario.getEquipoB().getParticipantes();
			/*
			 * CON FOR ECAH VOY RECORRER LAS LISTAS Y A MOSTRAR POR PANTLLA CON LOS GET
			 * LOS DATOS QUE SE SOLICITAN
			 */
			
			for (Participantes equipoa : participanteEquipoA) {
				System.out.print("N_Expedientes" + "       " + equipoa.getAlumno().getExpediente());
				System.out.print("fecha Nacimiento" + "     " + equipoa.getAlumno().getFechaNacimiento());
				System.out.println();
			}

			for (Participantes equipob : participantesEquipoB) {
				System.out.print("N_Expedientes" + "       " + equipob.getAlumno().getExpediente());
				System.out.print("fecha Nacimiento" + "      " + equipob.getAlumno().getFechaNacimiento());
				System.out.println();

			} 

			session.close();   // CIERRO LA SESSION
		} catch (HibernateException |

				ParseException e) {
			e.printStackTrace();

		}
		sc.close(); // CIERRO EL FLUJO 

	}

	static void ejercicio2() {
		Scanner sc = new Scanner(System.in);

		try {
			/*
			 * CREO LA SESSION Y LA ABRO
			 */
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			System.out.println("¿ Introduce el ID del profesor? ");
			Integer id = sc.nextInt();
			Profesores profesor = (Profesores) session.get(Profesores.class, id);   // CREO EL OBJECTO DESDE DONDE VOY A CONSULTAL
			System.out.println("**********Profesor********");
			System.out.println("Nombre          " + profesor.getNombre());
			System.out.println("Apellidos        " + profesor.getApellido());
			System.out.println("N_Departamento    " + profesor.getDepartamento_id().getNombre());

			List<Cursos> cursos=profesor.getCursos();   // COMO QUIERO DATOS DE CONSULTA DE OTRA CLASE
                                                        // CREO UNA LISTA PARA ACCEDER A ESA CLASE DESDE
			                                            // PROFESOR Y LUEGO LA RECORRO CON UN FOR EACH
			for (Cursos curso : cursos) {
				System.out.println("Id del curso: " + curso.getIdCurso());
				System.out.println("Nombre del curso: " + curso.getCurso());
				System.out.println();

			}
			/*
			 * COMO EN LA MISMA CONSULTA SE PIDE INFORMACION DE LA CLASE TUTORIAS
			 * ACCEDO A ELLA DESDE LA CLASE PROFESOR Y CREO UNA LISTA Y DE HAY DEVUELVO 
			 * LOS DATOS QUE SE ME SOLICITAN
			 */

			List<Tutorias> tutorias = profesor.getProfesor();
			for (Tutorias tutoria : tutorias) {
				System.out.println("Curso Dia" +       tutoria.getDiaSemana());
				System.out.println("Hora tutoria" +     tutoria.getHoraTutoria());
				System.out.println();

			}

			session.close();
		} catch (HibernateException e) {
			e.getMessage();

		}
         sc.close();  // Cierro la clase scanner
	}
	
	static void ejercicio3() {
		Scanner sc = new Scanner(System.in);
		Integer IdActividad;
		String fecha;
		String hora ;
		String lugar;

		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			System.out.println("Introduce el Id actividad");
			String id_cadena = sc.nextLine();

			IdActividad = Integer.parseInt(id_cadena);

			System.out.println("Introduce la fecha ");
			fecha = sc.nextLine();

			System.out.println("Introduce la hora ");
			hora = sc.nextLine();

			System.out.println("Introduce el lugar  ");
			lugar = sc.nextLine();

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date fechadate = formato.parse(fecha);

			CalendarioId id = new CalendarioId();
			id.setActividad(IdActividad);
			id.setFechaevento(fechadate);
			id.setHora(hora);
			id.setLugar(lugar);
			Calendario calendario=session.get(Calendario.class, id);
			
			/*
			 * LE PREGUNTO QUE SI CALENDATIO EXITE NO HAGAS NADA Y ENVIAME LA INFORMACION
			 * POR CONSOLA
			 */
		   
			if (calendario != null) {
			    System.out.println("El evento ya existe en la base de datos.");
	
			   /*
			    * PERO SI NO EXISTE DIME QUE NO EXITE Y GUARADALO
			    */
			} else {
				  System.out.println("El evento no existe en la base de datos.");
				  System.out.println("******Actualizo los Datos*******");
				  
				    Calendario calendarios=new Calendario();   /// CREO UN NUEVO OBJETO CALENDARIO
				    calendarios.setCalendario(id);             // AÑADO EL ID 
				    session.save(calendarios);                /// Y LO GUARDO
				    
	
			}
			/*
			 * NO ENTIENDO POR QUE NO SE ME GUARDA EN LA BASE DE DATOS
			 * TENGO ALGO MAL Y NO SE QUE PUEDE SER.
			 */

		
		session.close();
	}catch(HibernateException | ParseException e) {
		e.getMessage();
		
	}
	sc.close();   //cierro el scanner
	}
	
}
