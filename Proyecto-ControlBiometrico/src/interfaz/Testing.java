package interfaz;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.ControlBiometrico;
import dominio.TipoEmpleado;
import dominio.Usuario;

public class Testing {


	@Test
	public void testQueSePuedaRegistrarUnUsuario() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		assertTrue(controlBiometricoTest.registrarUsuario(usuario1));
	}
	
	@Test
	public void testQueSePuedaBuscarUsuarioPorNumeroDeUsuario() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		Usuario usuarioEsperado = usuario1;
		Usuario usuarioObtenido = controlBiometricoTest.obtenerUsuarioPorNumero(1);
		
		assertEquals(usuarioEsperado, usuarioObtenido);
	}
	
	@Test
	public void testQueSePuedaBuscarUsuarioPorNumeroDeUsuarioConOtroValor() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 8000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		Usuario usuarioEsperado = usuario2;
		Usuario usuarioObtenido = controlBiometricoTest.obtenerUsuarioPorNumero(2);
		
		assertEquals(usuarioEsperado, usuarioObtenido);
	}
	
	@Test
	public void testGetGerenteMayorSueldo() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		Usuario usuarioEsperado = usuario4;
		Usuario usuarioObtenido = controlBiometricoTest.obtenerUsuarioGerenteMayorSueldo();
		
		assertEquals(usuarioEsperado, usuarioObtenido);
	}
	
	@Test
	public void testRegistrarFichadaUsuario() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(1, 1, 1);
		
		assertTrue (aValidar);
	}
	
	@Test
	public void testRegistrarFichadaUsuarioConDiaIncorrectoMayor() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(1, 32, 1);
		
		assertFalse (aValidar);
	}
	
	@Test
	public void testRegistrarFichadaUsuarioConDiaIncorrectoMenor() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(1, -5, 1);
		
		assertFalse (aValidar);
	}
	
	@Test
	public void testRegistrarFichadaUsuarioConMesIncorrectoMayor() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(1, 30, 13);
		
		assertFalse (aValidar);
	}
	
	@Test
	public void testRegistrarFichadaUsuarioConMesIncorrectoMenor() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(1, 30, -1);
		
		assertFalse (aValidar);
	}

	@Test
	public void testRegistrarFichadaUsuarioConUsuarioIncorrecto() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(9, 30, 1);
		
		assertFalse (aValidar);
	}
	
	@Test
	public void testRegistrarFichadaUsuarioConUsuarioIncorrectoYFechaIncorrecta() {
		ControlBiometrico controlBiometricoTest = new ControlBiometrico("Unlam", 10);
		Usuario usuario1 = new Usuario(1, "ApellidoPrueba1", TipoEmpleado.ADMINISTRATIVO, 7000);
		Usuario usuario2 = new Usuario(2, "ApellidoPrueba2", TipoEmpleado.GERENTE, 10000);
		Usuario usuario3 = new Usuario(3, "ApellidoPrueba3", TipoEmpleado.OPERARIO, 5000);
		Usuario usuario4 = new Usuario(4, "ApellidoPrueba4", TipoEmpleado.GERENTE, 11000);
		
		controlBiometricoTest.registrarUsuario(usuario1);
		controlBiometricoTest.registrarUsuario(usuario2);
		controlBiometricoTest.registrarUsuario(usuario3);
		controlBiometricoTest.registrarUsuario(usuario4);
		
		boolean aValidar = controlBiometricoTest.registrarFichadaDeUsuario(9, 30, 30);
		
		assertFalse (aValidar);
	}
}