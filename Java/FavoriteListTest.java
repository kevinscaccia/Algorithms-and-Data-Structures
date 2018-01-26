/* 
 * Escrito por Kevin Costa Scaccia
 * Classe testa a implementação de uma lista de favoritos(mais acessados)
 * Demonstrando um dos usos de uma PositionList, na prática
 *
 */

public class FavoriteListTest{
	
	public static void main(String[] args) {	
		FavoriteList<String> listaDeFavoritos = new FavoriteList<String>();

		// Acessando valores 
		listaDeFavoritos.access("google"); // google +1
		listaDeFavoritos.access("youtube"); // youtube +1
		listaDeFavoritos.access("youtube"); // youtube +1
		listaDeFavoritos.access("google"); // google +1
		listaDeFavoritos.access("google"); // google +1

		listaDeFavoritos.access("yahoo"); // yahoo +1
		listaDeFavoritos.delete("google"); // deletando google do 'rank'


		// imprime o rank
		for(String e : listaDeFavoritos.rank(listaDeFavoritos.getSize()))
			System.out.println(" "+e+" ");
		
	}

}