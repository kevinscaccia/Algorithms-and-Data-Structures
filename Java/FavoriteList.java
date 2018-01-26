/* 
 * Escrito por Kevin Costa Scaccia
 * Classe que implementa uma lista de favoritos(mais acessados)
 * utilizando uma Lista de Posições
 *
 */
import estruturas.*;

public class FavoriteList<E>{
	protected PositionList<Entry<E>> lista;
	public FavoriteList(){
		lista = new NodePositionList<Entry<E>>();
	}
	//
	public Position<Entry<E>> findPosition(E obj){
		for(Position<Entry<E>> pos : lista.positions())// percorre toda a lista
			if(pos.getElement().getElement().equals(obj)){// encontrou
				return pos;// retorna posição do elemento buscado
			}
		return null;
	}
	//
	public void access(E obj){
		Position<Entry<E>> posicaoAtual = findPosition(obj);
		if(posicaoAtual == null){// não existe na lista
			Entry<E> novo = new Entry<E>(obj);
			lista.addLast(novo);// adiciona na lista
			posicaoAtual = lista.getLast();
			// System.out.println("NOVA ENTRADA: "+obj);
		}else{// existe na lista
			posicaoAtual.getElement().incrementCount();
			// System.out.println("INCREMENTANDO ENTRADA: "+ posicaoAtual.getElement().getElement());
		}			
		order(posicaoAtual);
	}
	//
	public void delete(E obj){
		Position<Entry<E>> posicaoAtual = findPosition(obj);
		if(posicaoAtual == null) return;
		lista.remove(posicaoAtual);
	}
	//
	protected void order(Position<Entry<E>> cursor){
		Entry<E> e = cursor.getElement();
		int count = e.getCount();

		while(cursor != lista.getFirst()){// percorre a lista
			Position<Entry<E>> anterior = lista.getPrev(cursor);// pega a posição anterior
			if(count <= anterior.getElement().getCount())// ordena(decrescente)
				break;// posição certa
			lista.set(cursor, anterior.getElement());//
			cursor = anterior;//
		}
		lista.set(cursor, e);// armazena a entrada na sua posição final
	}
	
	//
	public Iterable<E> rank(int qtd){
		if(qtd <=0 || qtd> lista.getSize())
			return null;
		//
		PositionList<E> rank = new NodePositionList<E>();// lista do rank
		int i = 0;
		for(Entry<E> e : lista){// (para cada entrada na lista)lista é iteravel
			rank.addLast(e.getElement());
			if(i == qtd)
				break;
			i++;
		}
		return rank;
	}
	public int getSize(){ return lista.getSize();}
	public void showList(){
		System.out.println("-----");
		for(Entry<E> e : lista)
			System.out.println(e.getElement());
		System.out.println("-----");
	}



	// Entradas
	protected static class Entry<E> implements Position<E>{
		private int count;
		private E element;
		public Entry(E element){
			this.count = 1;
			this.element = element;
		}
		public E getElement(){ return this.element;}
		public int getCount(){ return this.count;}
		public void incrementCount(){ this.count++;}
	}
}
*/