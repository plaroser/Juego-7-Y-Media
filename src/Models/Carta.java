package Models;

public class Carta {
	private int numero;
	private int palo;
	private String[] nombrePalo;
	private String[] nombreCarta;

	public Carta(int numero, int palo) {
		String[] cartas = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo", "Rey" };
		this.nombreCarta = cartas;
		String[] palos = { "Bastos", "Copas", "Espadas", "Oros" };
		this.nombrePalo = palos;
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * Crea una carta a traves de in identificador unico El primer digito del
	 * identificador selecciona el palo El segundo número del identificacdor
	 * selecciona la carta
	 * 
	 * @param identificador
	 */
	public Carta(int identificador) {
		this((identificador % 10), (identificador / 10));
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
		return this.numero;
	}

	public int getPalo() {
		return this.palo;
	}

	/**
	 * Muestra el mobre del palo correspondiente con la carta
	 * 
	 * @return devuelve el nombre del palo
	 */
	public String getNombrePalo() {
		return nombrePalo[this.palo];
	}

	/**
	 * Muestra el nombre de la figura correspondiente con la carta
	 * 
	 * @return devuelve el nombre de la figura
	 */
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

	/**
	 * Muetra el valor de la carta
	 * @return devuelve el valor de la carta en el juego del Mus
	 */
	public int getValorMus() {
		if (this.numero == 1 || this.numero == 2) {
			return 1;
		} else if (this.numero == 3 || (this.numero >= 8 && this.numero <= 10)) {
			return 10;
		} else {
			return this.numero;
		}
	}

	/**
	 * 
	 * @return Devuelve el calor de la carta en el juego de las 7 y media
	 */
	public float getValor7yMedia() {
		if (this.numero >= 7 && this.numero <= 9) {
			return 0.5f;
		} else {
			return (float) this.numero + 1;
		}
	}

	/**
	 * Devuelve el nombre completo de la carta
	 */
	@Override
	public String toString() {
		return "- "+this.getNombreCarta() + " de " + this.getNombrePalo();
	}
}
