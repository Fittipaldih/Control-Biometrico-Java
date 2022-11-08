package dominio;

public class ControlBiometrico {
	private String nombre; 
	private final int MAX_CANTIDAD_REGISTROS;
	private Usuario[] usuarios;
	private Ingreso[] ingresosRegistrados;
	
	public ControlBiometrico(String nombre, int cantidadUsuariosARegistrar) {
		super();
		this.nombre = nombre;
		usuarios= new Usuario [cantidadUsuariosARegistrar];
		MAX_CANTIDAD_REGISTROS = 50000;
		ingresosRegistrados = new Ingreso[MAX_CANTIDAD_REGISTROS];
	}
	
	public boolean registrarUsuario(Usuario usuario) {
		boolean seRegistro=false;
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null ) {
				usuarios[i] = usuario;
				seRegistro  = true;
				break;
			}
		}		
		return seRegistro;
	}
	
	public Usuario obtenerUsuarioPorNumero(int numero) {
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i] != null && usuarios[i].getNumero() == numero) {
				return usuarios[i];
			}
		}
		return null;
	}
	
	public Usuario obtenerUsuarioGerenteMayorSueldo() {
		Usuario gerenteMayor = null;
		double sueldoMayor=0;
		for (int i = 0; i < usuarios.length; i++) {
			
				if (usuarios[i] != null && usuarios [i].getTipo()==TipoEmpleado.GERENTE) {
					gerenteMayor = usuarios[i];
					sueldoMayor = usuarios[i].getSueldo();
					
					if (usuarios[i+1]!=null && usuarios[i].getSueldo() < usuarios[i+1].getSueldo()) {
						sueldoMayor = usuarios[i+1].getSueldo();
						gerenteMayor = usuarios[i+1];
						}
					}
		} return gerenteMayor;
	}
	
	public boolean registrarFichadaDeUsuario( int numUsuario, int dia, int mes) {
		/* Validar que el usuario exista y que la fecha sea correcta */
		
		if ( obtenerUsuarioPorNumero(numUsuario) != null && Ingreso.validarFecha(mes, dia)) { 	
			/*SI USUARIO EXISTE Y LA FECHA ES CORRECTA ... */
				Ingreso usuarioQueIngresa = new Ingreso (mes, dia , numUsuario);
			for (int i = 0; i < ingresosRegistrados.length; i++) { /* GUARDO LA FICHADA EN EL ARRAY*/
				if ( ingresosRegistrados[i] == null ) {
					ingresosRegistrados[i] = usuarioQueIngresa;
					return true;
					}
			}
		}	return false;
	}
	
	
	public void ordenarIngresosBurbuja() {
		
		Ingreso aux = null;
		for (int i = 0; i < ingresosRegistrados.length; i++) {
			for (int j = 0; j < ingresosRegistrados.length -1; j++) {
				if ( ingresosRegistrados[i] != null && ingresosRegistrados[i+1] != null && ingresosRegistrados[i].getNumUsuario() > ingresosRegistrados[i+1].getNumUsuario()) {
					aux = ingresosRegistrados[i];
					ingresosRegistrados[i+1] = ingresosRegistrados [i];
					ingresosRegistrados[i] = aux;
				}	
			}
		} 
	}
	
	
	public Ingreso[] obtenerTodosLosIngresosDeUnMes(int mes, ControlBiometrico control) {
		/*LOS ORDENO LLAMANDO AL METODO BURBUJA*/
		control.ordenarIngresosBurbuja();
		/*CREO UN ARRAY CON LOS INGRESOS DEL MES*/
		Ingreso ingresosADevolver[] = new Ingreso [ingresosRegistrados.length];
		/*ACA ME FIJO EL MES */
		for (int i = 0; i < ingresosRegistrados.length; i++) {
			if (ingresosRegistrados[i]!=null && ingresosRegistrados[i].getMes() == mes) {
				ingresosADevolver[i] = ingresosRegistrados[i];
			}

		} return ingresosADevolver;
	}

	@Override
	public String toString() {
		return "Control Biometrico " + nombre;
	}

}
