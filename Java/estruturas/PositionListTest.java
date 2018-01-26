/* 
 * Escrito por Kevin Costa Scaccia
 * Classe que testa a implementação de uma lista de posições
 * 
 *
 */
package estruturas;
public class PositionListTest{
	// class test
	public static void main(String[] args) {
		PositionList<String> lista = new NodePositionList<String>();
		// lista.addBefore(lista.getFirst(), "Kevin");
		
		lista.addFirst("Miguel");
		lista.addBefore(lista.getFirst(), "Kevin");
		lista.addAfter(lista.getLast(), "Vitor");


		lista.set(lista.getLast(), "Sabrina");
		
		// imprime a lista utilizando um iterator
		for(String e : lista)
			System.out.println(e);

	}
}