/* 
 * Escrito por Kevin Costa Scaccia
 * Classe implementa um iterador de uma lista de posições
 * 
 *
 */
package estruturas;
import java.util.Iterator;

public class PositionListIterator<E> implements Iterator<E>{
	private PositionList<E> list;
	private Position<E> cursor;
	public PositionListIterator(PositionList<E> l){
		list = l;
		if(list.isEmpty())
			cursor = null;
		else
			cursor = list.getFirst();
	}

	public boolean hasNext(){
		return (cursor != null);
	}
	public E next(){
		if(!hasNext()) 
			return null;
		E elem = cursor.getElement();

		if(cursor == list.getLast())
			cursor = null;
		else
			cursor = list.getNext(cursor);
		return elem;
	}


}