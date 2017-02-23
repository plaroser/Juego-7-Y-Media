package Models;

public class Carta {
	private int numero;
	private int palo;
	private String[] nombrePalo;
	private String[] nombreCarta;

	public Carta(int numero, int palo) {
		String[] cartas = { "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "Sota", "Caballo", "Rey" };
		this.nombreCarta = cartas;
		String[] palos = { "Bastos", "Copas", "Espadas", "Oros" };
		this.nombrePalo = palos;
		this.numero = numero-1;
		this.palo = palo-1;
	}

	/**
	 * Crea una carta a traves de in identificador unico El primer digito del
	 * identificador selecciona el palo El segundo número del identificacdor
	 * selecciona la carta
	 * 
	 * @param identificador
	 */
	public Carta(int identificador) {
		this ((identificador % 10), (identificador / 10));
	}

	/**
	 * @param numero
	 *            de carta
	 * @param palo
	 *            de carta
	 * @return Nos devuelve el ID correspondiente a una carta
	 */
	public int getId() {
		String aux = "";
		aux += this.palo;
		aux += this.numero;
		return Integer.parseInt(aux);
	}

	public int getNumero() {
		return this.numero +1;
	}

	public int getPalo() {
		return this.palo+1;
	}

	public String getNombrePalo() {
		return nombrePalo[this.palo];
	}

	public String getNombreCarta() {
		return nombreCarta[this.numero];
	}

	/**
	 * Muestra el valor en el juego Tute Si como valor muestra un numero
	 * negativo, has introducido un numero de carta incorrecto.
	 * 
	 * @param numeroCarta
	 *            es el numero de nuestra carta dentro de su palo
	 * @return el valor dentro del Tute
	 */
	public int getValorTute() {
		if (this.numero == 1) {
			return 11;
		} else if (this.numero == 3) {
			return 10;
		} else if (this.numero == 8) {
			return 2;
		} else if (this.numero == 9) {
			return 9;
		} else if (this.numero == 10) {
			return 4;
		} else {
			return -1;
		}
	}

	public int getValorMus() {
		if (this.numero == 1 || this.numero == 2) {
			return 1;
		} else if (this.numero == 3 || (this.numero >= 8 && this.numero <= 10)) {
			return 10;
		} else {
			return this.numero;
		}
	}

	public float getValor7yMedia() {
		if (this.numero >= 8 && this.numero <= 10) {
			return 0.5f;
		} else {
			return (float) this.numero;
		}
	}

	@Override
	public String toString() {
		//return "+++";
		return getNombreCarta()+" de "+getNombrePalo();
	}
}
