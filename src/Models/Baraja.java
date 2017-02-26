package Models;

import java.util.ArrayList;

public class Baraja {
	private ArrayList<Carta> lista_cartas = new ArrayList<>();
	private int numeroDeCartas;

	/**
	 * Crea una baraja vacia
	 */
	public Baraja() {
	}

	/**
	 * Crea una baraja llena segun el tipo de baraja que le indiques
	 * 
	 * @param tipoBaraja
	 *            1 - baraja espaniola de 40 cartas
	 */
	public Baraja(int tipoBaraja) {
		this();

		switch (tipoBaraja) {
		case 1:
			this.numeroDeCartas = 40;
			break;

		default:
			this.numeroDeCartas = 40;
			break;
		}
		this.rellenarBaraja();
	}

	/**
	 * Crea una baraja llena con el tipo de cartas que le indiques
	 * 
	 * @param tipoBaraja
	 *            1 - baraja espaniola de 40 cartas
	 * @param barajar
	 *            Le indicas si quieres que la baraja este barajada u ordenada
	 */
	public Baraja(int tipoBaraja, Boolean barajar) {
		this(tipoBaraja);
		if (barajar) {
			this.barajar();
		}
	}

	/**
	 * Se usa para añadir una carta al final de la baraja
	 * 
	 * @param c
	 *            es la carta que vas a añadir
	 */
	public void aniadirCarta(Carta c) {
		this.lista_cartas.add(c);
	}

	/**
	 * Se usa para añadir una carta al final de la baraja
	 * 
	 * @param id_carta
	 *            es el identificador de la carta que vas a añadir
	 */
	public void aniadirCarta(int id_carta) {
		aniadirCarta(new Carta(id_carta));
	}

	/**
	 * Añade varias cartas por orden al final de la baraja
	 * 
	 * @param c
	 *            La lista de cartas que vas a añadir.
	 */
	public void aniadirCarta(ArrayList<Carta> c) {
		this.lista_cartas.addAll(c);
	}

	/**
	 * Mezcla la baraja de forma aleatoria
	 */
	public void barajar() {
		ArrayList<Carta> aux = new ArrayList<>();
		int aleatorio;
		for (int i = 0; i < lista_cartas.size(); i++) {
			aleatorio = (int) (Math.random() * aux.size());
			aux.add(aleatorio, lista_cartas.get(i));
			lista_cartas.remove(i);
		}
		this.lista_cartas = aux;

	}

	/**
	 * Corta la baraja segun la posicion indicada
	 * 
	 * @param posicion
	 *            es la posicion a partir de la cual empezara a cortar
	 */
	public void cortar(int posicion) {
		for (int i = 0; i <= posicion; i++) {
			this.lista_cartas.add(lista_cartas.size(), lista_cartas.get(i));
			this.lista_cartas.remove(i);
		}
	}

	/**
	 * Saca de la baraja la primera carta
	 * 
	 * @return devuelve la carta robada
	 */
	public Carta robar() {
		Carta aux = this.lista_cartas.get(0);
		this.lista_cartas.remove(0);
		return aux;
	}

	/**
	 * Inserta al final de la baraja la carta
	 * 
	 * @param id_carta
	 *            es el identificador de la carta que vamos a insertar al final
	 */
	public void instertarCartaAlFinal(int id_carta) {
		this.instertarCartaAlFinal(new Carta(id_carta));
	}

	/**
	 * Inserta una carta al principio de la baraja
	 * 
	 * @param id_carta
	 *            es el identificador de la carta a insertar.
	 */
	public void insertarCartaAlPrincipio(int id_carta) {
		this.insertarCartaAlPrincipio(new Carta(id_carta));
	}

	/**
	 * Inserta una carta al final de la baraja
	 * 
	 * @param c
	 *            Es la carta a insertar
	 */
	public void instertarCartaAlFinal(Carta c) {
		this.lista_cartas.add(c);
	}

	/**
	 * Inserta una carta al principio de la baraja
	 * 
	 * @param c
	 *            Es la carta a insertar
	 */
	public void insertarCartaAlPrincipio(Carta c) {
		this.lista_cartas.add(0, c);
	}

	/**
	 * Muestra el numero de cartas que hay en la baraja
	 * 
	 * @return devuelve el numero entero de cartas actuales.
	 */
	public int getNumeroCartas() {
		return lista_cartas.size();
	}

	/**
	 * Muestra si la baraja esta vacia
	 * 
	 * @return devuelve el estado de la baraja actualmente
	 */
	public boolean isVacia() {
		return (getNumeroCartas() == 0) ? true : false;
	}

	/**
	 * Rellena la baraja segun el tipo de baraja que hayamos seleccionado
	 */
	public void rellenarBaraja() {
		ArrayList<Carta> aux = new ArrayList<>();
		for (int i = 0; i < numeroDeCartas; i++) {
			aux.add(new Carta(i));
		}
		this.lista_cartas.addAll(aux);
	}
/**
 * Muestra el valor de la baraja en el juego de las 7 y media
 * @return
 */
	public float valorBaraja7Ymedio() {
		float aux = 0;
		for (Carta c : this.lista_cartas) {
			aux += c.getValor7yMedia();
		}
		return aux;
	}

	@Override
	public String toString() {
		String aux = "";
		for (Carta c : lista_cartas) {
			aux += c.toString() + "\n";
		}
		return aux;
	}

}
