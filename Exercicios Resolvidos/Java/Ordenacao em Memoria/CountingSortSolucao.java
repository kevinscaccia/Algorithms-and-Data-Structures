/**
 * @author: Kevin Costa Scaccia 
*/
import java.util.Scanner;
public  class CountingSortSolucao{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();// numero de alturas
		int[] alturas = new int[n];
		for(int i=0; i < n; i++){// entrada de dados
			alturas[i] = input.nextInt();
		}	
		
		// o range da altura é de 20cm à 230cm
		CountingSortSolucao.sort(alturas, 20, 230);
		// imprime altura por altura
		for(int a : alturas)
			System.out.print(a+" ");
	}

	/* Counting Sort
	 * 
     *
     *
	*/
	public static void sort(int[] array, int min, int max){
		int k = max-min+1;
		int[] countArray = new int[k];
		// conta quantos elementos tem de cada
		for(int i=0; i < array.length; i++)
			countArray[array[i]-min]++;// -min
		// conta quantos elementos existem antes (somando com o anterior)
		for(int i = 1; i < k; i++)
			countArray[i]+= countArray[i-1];

		int[] auxArray = new int[array.length];// array auxiliar
		// colocando os elementos nas suas posições corretas(no auxiliar)
		for(int i=0; i < array.length; i++){
			int index = countArray[array[i]-min];// indice do elemento atual
			auxArray[index-1] = array[i];
			countArray[array[i]-min]--;// decrementa o indice
		}
		// copia o array auxiliar no lugar do dado
		for(int i =0; i < array.length; i++)
		    array[i] = auxArray[i];
	}
}