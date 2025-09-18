package programas;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import modelo.Alumnos;
import modelo.Calendario;
import modelo.CalendarioId;
import modelo.Equipos;
import modelo.Profesores;

public class parte2 {

	public static void main(String[] args) {

		/*
		 * En esta parte he realizado los metodos para probar cada una de las consultas
		 * que hecho en las clases se que solo se pedia un metodo , pero como tenia que
		 * probar si funcionaban los he dejado.
		 */

		profesorOrdenar();
		ConsultaParametrizadaAlumno();
		consultaParametrizadaProfesor();
		CalendarioListado2();

	}
	/*
	* Creo la session y la abro
	 * luego creo el query y con session creo la named query ,con los 
	 * parametros del Name de la query y el nombre de la clase que la tiene
	 * creo una lista con ese objeto y devuelvo el query. y 
	 * como el tostring devuelvo los datos de la consulta
	 * 
	 */

	static void AlumnosOrdenar() {
		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			Query query = session.createNamedQuery("AlumnosOrdenados", Alumnos.class);
			List<Alumnos> resultados = query.getResultList();

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

		}

	}

	static void profesorOrdenar() {
		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			Query query = session.createNamedQuery("ProfesoresOrdenados", Profesores.class);
			List<Profesores> resultados = query.getResultList();

			for (Profesores a : resultados) {
				System.out.println(a.toString());
			}

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

		}

	}
	
	/* Creo la session y la abro
	 * luego creo el query y con session creo la named query ,con los 
	 * parametros del Name de la query y el nombre de la clase que la tiene
	 * como esta parametrizada , en los parametros pongo el nombre que utilizo en el named query
	 * y el filtro de los apellidos , creo una lista del Objeto  y sobre esa lista devuelve el listado
	 * del query  , y solo con el toString de la clase  lo muesto Todo
	 */

	static void ConsultaParametrizadaAlumno() {

		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			Query query = session.createNamedQuery("Alumnosparamtrizados", Alumnos.class);
			query.setParameter("apellidoPattern", "%Sanchez Hoz%");
			List<Alumnos> resultados = query.getResultList();

			System.out.println(resultados.toString());

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

		}

	}
	/*
	 * Creo la session y la abro
	 * luego creo el query y con session creo la named query ,con los 
	 * parametros del Name de la query y el nombre de la clase que la tiene
	 * como esta parametrizada , en los parametros pongo el nombre que utilizo en el named query
	 * y el filtro de los apellidos , creo una lista de profesores y sobre esa lista devuelve el listado
	 * del query  , y solo con el toString de la clase Profesores lo muesto Todo
	 */

	static void consultaParametrizadaProfesor() {

		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();
        
			Query query = session.createNamedQuery("ProfesorParametrizados", Profesores.class);
			query.setParameter("apellidoPattern", "%Matamoros Prudencio%");
			List<Profesores> resultados = query.getResultList();

			System.out.println(resultados.toString());

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

		}

	}

	static void CalendarioListado() {

		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			Query query = session.createNamedQuery("prueba", Calendario.class);
			List<Calendario> resultados = query.getResultList();

			System.out.println(resultados.toString());

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

		}

	}

	static void CalendarioListado2() {
		try {
			Session session = utils.HibernateUtils.getSessionFactory().openSession();

			Query query = session.createNamedQuery("prueba");
			List<Object[]> resultados = query.getResultList();

			for (Object[] resultado : resultados) {
				String actividad = (String) resultado[0];
				String equipoAID = (String) resultado[1];
				String equipoBID = (String) resultado[2];
				Date fecha = (Date) resultado[3];
				String hora = (String) resultado[4];
				String lugar = (String) resultado[5];

				Time horaTime = Time.valueOf(hora); //

				System.out.println("Actividad: " + actividad + " " + ", Equipo A: " + equipoAID + " " + ", Equipo B: "
						+ equipoBID + ", Fecha: " + fecha + " " + ", Hora: " + hora + " " + ", Lugar: " + lugar);
			}

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
	}


