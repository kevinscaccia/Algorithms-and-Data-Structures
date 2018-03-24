/**
 * @author: Kevin Costa Scaccia 
*/
import java.util.Scanner;
public  class RadixSortSolucao{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();// numero de alturas
		int[] alturas = new int[n];
		for(int i=0; i < n; i++){// entrada de dados
			alturas[i] = input.nextInt();
		}	
		
		// o range da altura é de 20cm à 230cm// 3 digitos
		RadixSortSolucao.RadixSort(alturas, 230, 3);
		// imprime altura por altura
		for(int a : alturas)
			System.out.print(a+" ");
	}
	/* Radix Sort
	 * 
     * Internamente utiliza algum outro algoritmo(estável) de ordenação
     * neste caso foi usado um countingsort adaptado
	*/ 
	public static void RadixSort(int[] array, int range, int digitos){
		// pega os digitos do menos significativo ao mais significativo
	 	for(int pos = 0; pos < digitos; pos++)
	 		countingSortAdaptado(array, pos, range);
	}
	private static void countingSortAdaptado(int[] array, int pos, int range){
		int n = array.length;
		int countArray[] = new int[range+1];
	
		// conta a quantidade de elementos de cada digito
		for(int valor : array)
			countArray[getDigito(valor, pos)]++;
		//calcula a posição, somando quantos vem antes
		for(int i = 1; i < range+1; i++)
			countArray[i]+= countArray[i-1];
			
		int[] arrayAuxiliar = new int[array.length];
		// colocando os elementos nas suas posições corretas(no auxiliar)
		for(int i = array.length-1; i >= 0; i--){
			int indice = countArray[getDigito(array[i], pos)]; // indice do elemento atual;
			arrayAuxiliar[indice-1] = array[i]; // coloca o elemento no array auxiliar
			countArray[getDigito(array[i], pos)]--;// decrementa o indice
		}
		// copia o array auxiliar no lugar do dado
		for(int i =0; i < array.length; i++)
		    array[i] = arrayAuxiliar[i];
	}
	// método auxiliar que pega o digito de um valor, dependendo 
	// da posição do digito dignificativo(começa em 0)
	private static int getDigito(int valor, int posicao){
		return valor /(int) Math.pow(10, posicao) % 10;
	}
}