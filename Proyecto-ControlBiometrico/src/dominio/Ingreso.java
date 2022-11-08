package dominio;

public class Ingreso {
 private int dia, mes, numeroUsuario;
 
public Ingreso(int dia, int mes, int usuarioQueIngresa) {
	this.dia = dia;
	this.mes = mes;
	this.numeroUsuario = usuarioQueIngresa;
}

	public static boolean validarFecha(int mes, int dia) {
		if (dia>=1 && dia <= 31 && mes == 1|| mes == 3|| mes == 5|| mes == 7|| mes == 8 || mes == 10|| mes == 12 ) {
			return true;
		}
		else if (dia>=1 && dia <= 30 && mes == 4 || mes == 6 || mes== 9 || mes== 11 ) {
			return true;
		}
		else if (dia>=1 && dia <= 28 && mes == 2) {
			return true;
		} else { 
			return false;
			}
		}

	public int getNumUsuario() {
		return this.numeroUsuario;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	
	@Override
	public String toString() {
		return "El usuario numero " + numeroUsuario + " ingreso el dia " + dia + " del mes " + mes;
	}

}

