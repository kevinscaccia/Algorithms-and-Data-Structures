/**
 * @author: Kevin Costa Scaccia 
*/
import java.util.Scanner;
public  class QuickSort{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();// numero de camisas
		Encomenda[] encomendas = new Encomenda[n];
		for(int i=0; i < n; i++){
			String nome = input.next();
			char cor = input.next().charAt(0);
			char tamanho = input.next().charAt(0);
			encomendas[i] = new Encomenda(nome, cor, tamanho);
		}	
		// ordenando pela cor
		QuickSort.ordenar(encomendas, 0, encomendas.length-1);

		for(Encomenda e : encomendas)
			System.out.println(e);
	}
	/*
		QuickSort adaptado para ordenar conforma um dos critérios da encomenda
		O QUARTO PARÂMETRO se refere ao criterio de ordenação
	*/
	public static void ordenar(Encomenda[] array, int inicio, int fim){
		if(fim-inicio < 1)
			return;// um ou zero elemesntos
		int pivoIndex = particionar(array, inicio, fim);
		ordenar(array, inicio, pivoIndex-1);// Ordena partição esquerda
		ordenar(array, pivoIndex+1, fim);// Ordena partição direita
	}
	// método que particiona o array em duas partes, à esquerda ficam os
	// elementos menores que o pivô, ao centro o pivô em sua posição final
	// e à direita os elementos maiores que o pivô.
	// retorna a posição final desse elemento vetor (no array ordenado)
	public static int particionar(Encomenda[] array, int inicio, int fim){
		Encomenda pivo = array[inicio];
		int esq = inicio;// percorre da esq pra direita
		int dir = fim;// percorre da dir pra esquerda
		while(esq < dir){// enquanto os cursores não cruzarem
			// enquanto houver maiores à direita, anda com o cursor dir
			// encontra um elemento menor que o pivo, à direita
			while(esq < dir && Encomenda.comparar(pivo, array[dir]))
				dir--;
			// encontrou um elemento menor à direita
			if(esq < dir)// coloca esse elemento na posição mais à esquerda
				array[esq] = array[dir];
			// enquanto houver menores à esquerda, anda com o cursor esq
			// encontra um elemento maior que o pivo, à esquerda	
			while(esq < dir && Encomenda.comparar(array[esq], pivo))
				esq++;
			// encontrou um elemento maior à esquerda
			if(esq < dir)// coloca esse elemento mais à direita
				array[dir] = array[esq];
		}
		// se saiu do while é porque os cursores se cruzaram
		// local correto do nosso pivo
		array[dir] = pivo;
		return dir;
	}

	// classe auxiliar que representa uma encomenda
	static class Encomenda{
		String nome;
		char cor;
		char tamanho;
		public Encomenda(String n, char c, char t){
			nome = n; cor = c; tamanho = t;
		}
		public String toString(){
			if(cor == 'b')
				return "branco "+tamanho+" "+nome;
			else
				return "vermelho "+tamanho+" "+nome;
		}
		// retorna true se e1 preceder e2;
		static boolean comparar(Encomenda e1, Encomenda e2){
			if(e1.cor == e2.cor){// cores iguais (usar outros criterios)
				if(e1.tamanho == e2.tamanho){// tamanhos iguais (usar outros criterios)
					if(e1.nome.compareTo(e2.nome) < 0)// e1 precede e2
						return true;// compara nomes
					return false;
				}else{// tamanhos diferentes (usar tamanho como criterio)
					if(e1.tamanho > e2.tamanho)
						return true;
					return false;	
				}
			}else{// cores diferentes (usar cor como criterio)
				if(e1.cor < e2.cor)
					return true;
				return false;
			}	
		}
	}
}