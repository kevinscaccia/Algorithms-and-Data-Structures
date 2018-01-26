/* 
 * Escrito por Kevin Costa Scaccia
 * Classe implementa uma Lista de Posições, utilizando nodos ligados
 * Nesta implementação, a PositionList é na verdade uma lista duplamente encadeada
 *
 */
package estruturas;
import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E>{
	private int size;
	private Node<E> head, tail;
	// Construtor que inicializa a lista ligada
	public NodePositionList(){
		size = 0;
		head = new Node<E>(null, null, null);
		tail = new Node<E>(head, null, null);
		head.setNext(tail);
	}
	//
	public int size(){ return size;}// quantidade de nós
	public boolean isEmpty(){ return (size == 0);} 
	// Addiction methods
	public boolean addFirst(E element){// adiciona nó no inicio da lista
		Node<E> novo = new Node<E>(head, head.getNext(), element);
		if(novo != null){
			head.getNext().setPrev(novo);
			head.setNext(novo);
			size++;
			return true;
		}
		return false;
	}
	public boolean addLast(E element){// adiciona nó no fim da lista
		Node<E> novo = new Node<E>(tail.getPrev(), tail, element);
		if(novo != null){
			tail.getPrev().setNext(novo);
			tail.setPrev(novo);
			size++;
			return true;
		}
		return false;
	}
	public boolean addBefore(Position<E> p, E element){// adiciona antes de outra posição
		Node<E> node = checkPosition(p);
		if(node == null)
			return false;
		Node<E> novo = new Node<E>(node.getPrev(), node, element);
		node.getPrev().setNext(novo);
		node.setPrev(novo);
		size++;
		return true;
	}
	public boolean addAfter(Position<E> p, E element){// adiciona depois de uma posição
		Node<E> node = checkPosition(p);
		if(node == null)
			return false;
		Node<E> novo = new Node<E>( node, node.getNext(), element);
		node.getNext().setPrev(novo);
		node.setNext(novo);
		size++;
		return true;
	}
	//
	public Position<E> getFirst(){
		if(size == 0) return null;
		return head.getNext();
	}
	//
	public Position<E> getLast(){
		if(size == 0) return null;
		return tail.getPrev();
	}
	//
	public Position<E> getNext(Position<E> p){//retorna posição após a informada
		Node<E> node = checkPosition(p);
		if(node == null || node.getNext() == tail)
			return null;
		//
		return node.getNext();
	}
	//
	public Position<E> getPrev(Position<E> p){// retorna a posição prévia
		Node<E> node = checkPosition(p);
		if(node == null || node.getPrev() == head)
			return null;
		//
		return node.getPrev();
	}
	// Edition methods
	public boolean set(Position<E> p, E element){// edita uma posição
		Node<E> node = checkPosition(p);
		if(node == null)
			return false;
		node.setElement(element);
		return true;
	}
	//
	public boolean remove(Position<E> p){//remove uma posição
		Node<E> node = checkPosition(p);
		if(node == null)
			return false;
		Node<E> anterior = node.getPrev();
		node.getPrev().setNext(node.getNext());// atualiza anterior
		node.getNext().setPrev(anterior); //atualiza proximo
		node.setPrev(null); node.setNext(null);
		return true;
	}
	// 
	public Node<E> checkPosition(Position<E> p){// checa se a posição é valida
		if((p == null) || (p == head) || (p == tail))
			return null;
		Node<E> node = (Node<E>) p;
		if((node.getNext() == null) || (node.getPrev() == null))
			return null;
		// nodo valido
		return node;
	}
	//
	public void show(){// método auxiliar pra imprimir a lista sem iterator
		Node<E> cursor = head.getNext();
		while(cursor != tail){
			System.out.println(cursor.getElement());
			cursor = cursor.getNext();
		}
	}
	//
	public Iterator<E> iterator(){// retorna um iterador da lista
		Iterator<E> iterator = new PositionListIterator<E>(this);
		return iterator;
	}
	//
	// classe aninhada que representa os nós da lista
	//
	static class Node<E> implements Position<E>{
		private E element; //elemento
		private Node<E> prev; //nodo anterior
		private Node<E> next; //nodo proximo
		Node(Node<E> prev, Node<E> next, E element){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
		// Access methods
		public E getElement(){ return this.element;}
		public E setElement(E e){ E aux = this.element; this.element = e; return aux;}
		public Node<E> getPrev(){ return this.prev;}
		public Node<E> getNext(){ return this.next;}
		public boolean setPrev(Node<E> prev){ this.prev = prev; return true;}
		public boolean setNext(Node<E> next){ this.next = next; return true;}
	}
}