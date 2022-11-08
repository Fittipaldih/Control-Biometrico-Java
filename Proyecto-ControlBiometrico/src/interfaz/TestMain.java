package interfaz;
import java.util.Scanner;

import dominio.ControlBiometrico;
import dominio.Ingreso;
import dominio.TipoEmpleado;
import dominio.Usuario;

public class TestMain {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		mensaje("*** BIENVENIDO ***");
		mensaje("VAMOS A CREAR EL CONTROL BIOMETRICO...");
		mensaje("Ingrese nombre del control");
		String nombre = teclado.next();
		mensaje ("Ingrese cantidad maxima de usuarios");
		int cantidadMax = teclado.nextInt();
		ControlBiometrico control = new ControlBiometrico(nombre, cantidadMax);
		mensaje(control+ " creado exitosamente");

		menuOpciones(teclado, control);
	}



	private static void menuOpciones(Scanner teclado, ControlBiometrico control) {
		byte opcion;
		do {
			
		mensaje("**MENU OPCIONES **");
		mensaje("Ingrese opcion deseada: ");
		mensaje("1) Registrar usuario nuevo\n"
				+ "2) obtener Usuario Por Numero\n"
				+ "3) obtener Usuario Gerente Mayor Sueldo\n"
				+ "4) registrar Fichada De Usuario\n"
				+ "5) obtener Todos Los Ingresos De Un Mes\n"
				+ "9) SALIR ");
		opcion = teclado.nextByte();
		switch (opcion) {
			case 1:
				registrarUsuario(teclado, control);
				break;
			case 2:
				obtenerUsuarioNumero(teclado, control);
				break;
			case 3:
				obtenerGerente(teclado, control );
				break;
			case 4:
				registrarFichada(teclado, control);
				break;
			case 5:
				obtenerIngresoMes(teclado, control);
				break;
			case 9:
				System.out.println("Chau vuelva prontos");
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		} while (opcion!= 9);
	}


	private static void obtenerIngresoMes(Scanner teclado, ControlBiometrico control) {
		System.out.println("Ingrese mes deseado");
		int mes = teclado.nextInt();
		Ingreso ingresos[] = control.obtenerTodosLosIngresosDeUnMes(mes, control);
		for (int i = 0; i < ingresos.length; i++) {
			if (ingresos [i]!= null) {
				System.out.println(ingresos[i]);
			}
		}
	}

	private static void registrarFichada(Scanner teclado, ControlBiometrico control) {
		System.out.println("Ingrese num usuario ");
		int usuario= teclado.nextInt();
		System.out.println("Ingrese dia");
		int dia = teclado.nextInt();
		System.out.println("Ingrese mes");
		int mes = teclado.nextInt();
		if ( control.registrarFichadaDeUsuario(usuario, dia, mes)) {
			System.out.println("FICHADA EXITOSA");
			
		} else {
			System.out.println("No se pudo registrar");
		}
		
	}

	private static void obtenerGerente(Scanner teclado, ControlBiometrico control) {
		Usuario gerente = control.obtenerUsuarioGerenteMayorSueldo();
		if ( gerente != null) {
			System.out.println(gerente);
		} else System.out.println("Usuario no encontrado");
		
	}

	private static void obtenerUsuarioNumero(Scanner teclado, ControlBiometrico control) {
		System.out.println("Ingrese numero a buscar");
		int numero = teclado.nextInt();
		Usuario usuario = control.obtenerUsuarioPorNumero(numero);
		if (usuario != null ) {
			System.out.println(usuario);
		} else {
			System.out.println("Usuario no encontrado");
		}	
	}

	private static void registrarUsuario(Scanner teclado, ControlBiometrico control) {
		mensaje("**REGISTRAR USUARIO**");
		mensaje( "Ingrese numero id");
		int numero = teclado.nextInt();
		mensaje("Ingrese apellido");
		String apellido = teclado.next();
		mensaje ("Ingrese tipo");
		TipoEmpleado tipo = validarTipo(teclado);
		mensaje ("Ingrese sueldo");
		double sueldo = teclado.nextDouble();
		Usuario usuario =new Usuario(numero, apellido, tipo, sueldo);
		control.registrarUsuario(usuario);
		mensaje("Registrado correctamente");
	}

	public static TipoEmpleado validarTipo(Scanner teclado) {
		mensaje ("Ingrese 1 para administrativo, 2 para gerente, 3 para operario");
		int opcion =teclado.nextInt();
		TipoEmpleado tipoElegido = TipoEmpleado.values() [opcion-1];
		return tipoElegido;
	}

	public static void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
