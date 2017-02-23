package Models;

import java.util.ArrayList;

public class Baraja {
	ArrayList<Carta> lista_cartas;

	public Baraja() {
		super();
	}

	public Baraja(int tipoBaraja) {
		this();
	}

	public Baraja(int tipoBaraja, Boolean barajar) {
		this(tipoBaraja);
	}

	public void aniadirCarta(int id_carta) {
		this.lista_cartas.add(new Carta(id_carta));
	}

	public void aniadirCarta(ArrayList<Carta> c) {
		this.lista_cartas.addAll(c);
	}

	public void barajar() {
		ArrayList<Carta> aux = null;
		int aleatorio;
		for (int i = 0; i < lista_cartas.size(); i++) {
			aleatorio = (int) (Math.random() * lista_cartas.size());
			aux.add(aleatorio, lista_cartas.get(i));
			lista_cartas.remove(i);
		}
		this.lista_cartas = aux;

	}

	public void cortar(int posicion) {
		ArrayList<Carta> aux = null;
		for (int i = 0; i <= posicion; i++) {
			this.lista_cartas.add(lista_cartas.size(), lista_cartas.get(i));
			this.lista_cartas.remove(i);
		}
	}

	public Carta robar() {
		Carta aux = this.lista_cartas.get(0);
		this.lista_cartas.remove(0);
		return aux;
	}

	public void instertarCartaAlFinal(int id_carta) {
		this.instertarCartaAlFinal(new Carta(id_carta));
	}

	public void insertarCartaAlPrincipio(int id_carta) {
		this.insertarCartaAlPrincipio(new Carta(id_carta));
	}

	public void instertarCartaAlFinal(Carta c) {
		this.lista_cartas.add(c);
	}

	public void insertarCartaAlPrincipio(Carta c) {
		this.lista_cartas.add(0, c);
	}

	public int getNumeroCartas() {
		return lista_cartas.size();
	}

	public boolean isVacia() {
		return (getNumeroCartas() == 0) ? true : false;
	}

	@Override
	public String toString() {
		return "Baraja [lista_cartas=" + lista_cartas + "]";
	}

}
