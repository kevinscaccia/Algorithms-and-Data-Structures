/* 
 * Escrito por Kevin Costa Scaccia
 * Classe que testa a implementação de uma Lista de Posições
 * 
 *
 */
import estruturas.*;

public class PositionListTest{
	// class test
	public static void main(String[] args) {

		PositionList<String> lista = new NodePositionList<String>();


		
		lista.addFirst("C");// adiciona como primeiro na lista
		lista.addFirst("B");// adiciona como primeiro na lista
		lista.addBefore(lista.getFirst(), "A");// adiciona antes do primeiro
		lista.addAfter(lista.getLast(), "E");// adiciona depois do ultimo

		lista.set(lista.getLast(), "D");// altera o ultimo
		lista.addLast("E");// adiciona como ultimo


		// imprime a lista utilizando um iterator
		for(String e : lista)
			System.out.println(e);

	}
}