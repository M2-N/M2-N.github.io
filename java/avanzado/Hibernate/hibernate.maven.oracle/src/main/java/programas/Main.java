package programas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtils;

public class Main {
	public static void main(String[] args) {

		SessionFactory sesion = HibernateUtils.getSessionFactory();
		Session session = sesion.openSession(); // TODO Auto-generated constructor stub
		System.out.println("*********Conectada*******");
			session.close();
		}
	}


