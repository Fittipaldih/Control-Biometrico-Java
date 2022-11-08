package dominio;

public class Usuario {
	private int numero;
	private String apellido;
	private TipoEmpleado tipo;
	private double sueldo;
	
	public Usuario(int numero, String apellido, TipoEmpleado tipo, double sueldo) {
		super();
		this.numero = numero;
		this.apellido = apellido;
		this.tipo = tipo;
		this.sueldo = sueldo;
	}

	public double getSueldo() {
		return this.sueldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public TipoEmpleado getTipo() {
		return this.tipo;
	}
	
	@Override
	public String toString() {
		return "Usuario numero " + numero + ", apellido " + apellido + ", tipo de empleado " + tipo + ", posee un sueldo de " + sueldo;
	}
	
	
}
