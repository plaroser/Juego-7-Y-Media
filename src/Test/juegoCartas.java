package Test;

import java.util.Scanner;

import Models.*;

public class juegoCartas {

	public static void main(String[] args) {
		Baraja b1;
		Baraja bJ1;
		Baraja bMaq;
		boolean primeraVez;
		String masCartas = "Quiere robar más cartas?(s para continuar n para plantarte)";
		String jugarOtraVez = "Quiere continuar jugando?(s para continuar n para plantarte)";
		
		
		do {
			bJ1 = new Baraja();
			bMaq = new Baraja();
			primeraVez = true;
			b1 = new Baraja(1,true);
	
			
			bJ1.aniadirCarta(jugada(b1.robar(), 1));
			bMaq.aniadirCarta(jugada(b1.robar(), 2));
			
			do {
				if (!primeraVez) {
					bJ1.aniadirCarta(jugada(b1.robar(), 1));
				} else {
					primeraVez = !primeraVez;
				}
				System.out.println("Tienes las siguientes cartas: ");
				System.out.println(bJ1);
				System.out.println("Total de puntos: " + bJ1.valorBaraja7Ymedio());

			} while (pregunta(masCartas));
			if (bMaq.valorBaraja7Ymedio() < 6) {
				bMaq.aniadirCarta(jugada(b1.robar(), 2));
			}
			System.out.println();
			System.out.println(String.format("%-30s", "").replace(' ', '*'));
			if (bMaq.valorBaraja7Ymedio() == bJ1.valorBaraja7Ymedio()) {
				System.out.println("(: Empates :)");
			} else if (bMaq.valorBaraja7Ymedio() > 7.5) {
				System.out.println("Le has ganado a la maquina :)");
			} else if (bJ1.valorBaraja7Ymedio() > 7.5) {
				System.out.println("Te ha ganado la maquina! :(");
			} else if (((bMaq.valorBaraja7Ymedio() - 7.5f) > (bJ1.valorBaraja7Ymedio() - 7.5f))) {
				System.out.println("Te ha ganado la maquina! :(");
			} else {
				System.out.println("Le has ganado a la maquina :)");
			}

			System.out.println("Tenias: \t\t" + bJ1.valorBaraja7Ymedio() + " puntos");
			System.out.println("La maquina tenia: \t" + bMaq.valorBaraja7Ymedio() + " puntos");
			System.out.println(String.format("%-30s", "").replace(' ', '*'));
		} while (pregunta(jugarOtraVez));
		System.out.println("ADIOS!!");
	}

	public static Carta jugada(Carta cartaAux, int numeroJugador) {
		System.out.println("Jugador " + numeroJugador + " roba carta:");
		return (cartaAux);
	}

	public static boolean pregunta(String pregunta) {

		Scanner sc = new Scanner(System.in);

		String aux = "";
		boolean esCorrecto = false;

		do {
			System.out.println(pregunta);
			aux = sc.next();
			aux = aux.toLowerCase();
			if (aux.equals("s") || aux.equals("n")) {
				if (aux.equals("n")) {
					return false;
				}
				esCorrecto = true;
			} else {
				System.out.println("ERROR: No ha introducido una opcion valida.");
				esCorrecto = false;
			}
		} while (esCorrecto == false);

		return true;
	}

}
