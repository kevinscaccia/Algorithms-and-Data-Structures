/**
 * @author: Kevin Costa Scaccia
*/
class CountingSort{
	public static void main(String[] args) {
		int[] array = {1,9,6,3,2,5,4,6,9,7,4,5,10};// array a ser ordenado
		countingSort(array, 0, 10);
		for(int i : array)
			System.out.print(i+" ");
	}
	// 
	static void countingSort(int[] array, int min, int max){
		int k = (max-min)+1;//range dos termos
		int[] arrayCount = new int[k];// inicia com zeros por padrão!
		// conta quantos elementos tem de cada valor possivel (dentro do range)
		for(int i =0; i < array.length; i++)
			arrayCount[array[i]-min]++;// - min faz economia de memoria do countArray
			// -min pra posição 0 do arrayCount ser o primeiro valor possivel do range
		// avalia a posição de cada elemento (somando os anteriores)
		for(int i =1; i < arrayCount.length; i++)
			arrayCount[i] += arrayCount[i-1];
		// agora que temos o arrayCount pronto, colocamos os elementos em suas posições
		// conforme quantos o precedem no array definitivamente ordenado
		int[] arrayAux = new int[array.length];// array uxiliar
		for(int i = 0; i < array.length; i++){
			int indice = arrayCount[array[i]-min];// indice correto no array ordenado
			arrayAux[indice-1] = array[i];// -1 pois indice = quantidade de termos 
			arrayCount[array[i]-min]--;// decrementando a posição
		}
		// copia o array auxiliar no lugar do dado
		for(int i =0; i < array.length; i++)
		    array[i] = arrayAux[i];
	}
}