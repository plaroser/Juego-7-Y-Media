package Models;

public class Carta {
	private int numero;
	private int palo;
	private String[] nombrePalo;
	private String[] nombreCarta;

	public Carta(int numero, int palo) {
		String[] cartas={"as","dos","tres","cuatro","cinco","seis","siete","Sota","Caballo","Rey"};
		this.nombreCarta=cartas;
		String[] palos={"Bastos","Copas","Espadas","Oros"};
		this.nombrePalo=palos;
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
		new Carta((identificador % 10), (identificador / 10));
	}

	/**
	 * @param numero
	 *            de carta
	 * @param palo
	 *            de carta
	 * @return Nos devuelve el ID correspondiente a una carta
	 */
	public int getId(int numero, int palo) {
		String aux = "";
		aux += palo;
		aux += numero;
		return Integer.parseInt(aux);
	}

	public int getNumero() {
		return numero;
	}

	public int getPalo() {
		return palo;
	}

	public String getNombrePalo(int palo) {
		return nombrePalo[palo];
	}

	public String getNombreCarta(int carta){
		return nombreCarta[palo];
	}
	/*public int getValorTute(int numeroCarta){
		
	}*/
}
