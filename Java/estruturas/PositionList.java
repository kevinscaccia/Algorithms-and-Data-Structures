/* 
 * Escrito por Kevin Costa Scaccia
 * Interace que define uma Lista de Posições à ser implementada
 * Observe que extende a classe 'Iterable', sendo assim um objeto iterável
 *
 */
package estruturas;
import java.util.Iterator;

public interface PositionList<E> extends Iterable<E>{
	// Information methods
	public int size();
	public boolean isEmpty();
	// Addiction methods
	public boolean addFirst(E element);
	public boolean addLast(E element);
	public boolean addBefore(Position<E> p, E element);
	public boolean addAfter(Position<E> p, E element);
	//
	public Position<E> getFirst();
	public Position<E> getLast();
	public Position<E> getNext(Position<E> p);
	public Position<E> getPrev(Position<E> p);
	// Edition methods
	public boolean set(Position<E> e, E element);
	public boolean remove(Position<E> p);
	// método da superclasse Iterable 
	public Iterator<E> iterator();
	public void show();
}
