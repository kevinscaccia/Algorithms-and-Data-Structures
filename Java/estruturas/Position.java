/* 
 * Escrito por Kevin Costa Scaccia
 * Interface de uma Posição, à ser implementada por um nó, por exemplo
 * Ela existe para separar o usuário das informações internas de um nó 
 *
 */
package estruturas;
public interface Position<E>{
	public E getElement();
}
