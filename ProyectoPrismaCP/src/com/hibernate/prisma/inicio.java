package com.hibernate.prisma;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.prisma.Inventario;

public class inicio {
	// Se instancia la sesión a partir del archivo de configuración de hibernate
	static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session sesion = sessionFactory.openSession();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int Opcion = -1;
		
		while(Opcion!=0) {
			System.out.println("Seleccione la opción requerida:");
			System.out.println("***Si desea salir presione 0***");
			Opcion = scanner.nextInt();
			
			if (Opcion==1) {
				consultarInventario();
			}
			
			else if (Opcion==2) {
				int id_inv=0, cantidad=0, id_material=0;
				boolean disponible=true;
				System.out.println("Por favor ingrese los datos requeridos:");
				id_inv=scanner.nextInt();
				cantidad=scanner.nextInt();
				id_material=scanner.nextInt();
				disponible=scanner.nextBoolean();
				agregarRegistro(id_inv, cantidad, id_material, disponible);
			}
			else if(Opcion==3) {
				int idInvenConsultar=0;
				System.out.println("Ingrese opción a consultar: ");
				idInvenConsultar = scanner.nextInt();
				consultarRegistro(idInvenConsultar);
			}
			else if(Opcion==4) {
				System.out.println("Ingrese el invenatario a modificar: ");
				int inventarioActualizar = scanner.nextInt();
				actualizarInventarioCantidad(inventarioActualizar);
			}
			else if (Opcion!=0){
				System.out.println("Opción no configurada");
			}
		}
		sesion.close();
	}

	public static void consultarInventario() {
		try {
			// Se genera la sesión
			sesion.beginTransaction();
			System.out.println("Conexión Exitosa");

			// Consultar los registros de la tabla Inventario
			List<Inventario> InventarioActual = sesion.createQuery("from Inventario").list();
			System.out.println("\nListado de Inventario actual: ");

			for (Inventario inventario : InventarioActual){
				System.out.println("ID: " + inventario.getId_inventario());
				System.out.println("Cantidad: " + inventario.getCantidad());
				System.out.println("Disponibilidad: " + inventario.isDisponibilidad());
				System.out.println("Materiales ID: " + inventario.getMateriales_id());
				System.out.println();
			}
			sesion.getTransaction().commit(); 
		}

		finally {
			// Se cierra el objeto session factory una vez se deja de utilizar
			//sesion.close();
			System.out.println("Cerrado");
		}
	}

	public static void agregarRegistro (int id_inv, int cantidad, int id_material, boolean disponible) {
		try {
			sesion.beginTransaction();
			System.out.println("Exitosa");
			
			Inventario inventarioNuevo = new Inventario(id_inv, cantidad, disponible, id_material); 
			
			sesion.save(inventarioNuevo);
			
			System.out.println("Agragado con exito");
			sesion.getTransaction().commit();			
			}
		finally {
			//Se cierra la sesión
			//sesion.close();
			}
		}

	public static void consultarRegistro(int idInven) {
		try {
			// Se genera la sesión
			sesion.beginTransaction();
			System.out.println("Exitosa");

			// Consultar los registros de la tabla Inventario
			List<Inventario> InventarioActual = sesion.createQuery("from Inventario where Id_Inventario = '"+idInven+"'").getResultList();
			System.out.println("\nUsuarios registrados");

			for (Inventario inventario : InventarioActual){
				System.out.println("ID: " + inventario.getId_inventario());
				System.out.println("Cantidad: " + inventario.getCantidad());
				System.out.println("Disponibilidad: " + inventario.isDisponibilidad());
				System.out.println("Materiales ID: " + inventario.getMateriales_id());
				System.out.println();
			}
			sesion.getTransaction().commit(); 
		}

		finally {
			// Se cierra el objeto session factory una vez se deja de utilizar
			//sesion.close();
			System.out.println("Cerrado");
		}
	}

	public static void actualizarInventarioCantidad(int idInventarioActualizar) {
		try {
			// Se genera la sesión
			sesion.beginTransaction();
			System.out.println("Ingrese nueva cantidad del inventario");
			int nuevaCantidad = scanner.nextInt();
			// Consultar los registros de la tabla Inventario
			sesion.createQuery("update Inventario set Cantidad = '"+ nuevaCantidad +"' where Id_Inventario = '"+idInventarioActualizar+"'").executeUpdate();
			sesion.getTransaction().commit(); 
			System.out.println("\nUsuarios registrados");
			
		}

		finally {
			// Se cierra el objeto session factory una vez se deja de utilizar
			//sesion.close();
			System.out.println("Cerrado");
		}
	}
}
