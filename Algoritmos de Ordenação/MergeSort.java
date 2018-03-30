/**
 * @author: Kevin Costa Scaccia
*/
class MergeSort{
	public static void main(String[] args) {
		int[] array = {6,2,3,1,5,9,4};// array a ser ordenado
		mergeSort(array, 0, array.length-1);// os parâmetros são indices!
		for(int i : array)
			System.out.print(i+" ");
	}
	// inicio e fim são indices!
	static void mergeSort(int[] array, int inicio, int fim){
		if(fim > inicio){
			int meio = (inicio+fim)/2;
			mergeSort(array, inicio, meio);
			mergeSort(array, meio+1, fim);
			merge(array, inicio, meio, fim);
		}
	}
	// [inicio] até [meio], representa a partição esquerda
	// [meio+1] até [fim], representa a partição direita
	private static void merge(int[] array, int inicio, int meio, int fim){
		int tamanho = (fim-inicio)+1;// para n elementos, tamanho (n+1)
		int[] arrayAux = new int[tamanho];
		int cursorEsq = inicio;
		int cursorDir = meio+1;
		int cursorAux = 0;// indice pra adicionar no array ordenado
		// atente aos <= (pois meio e fim são indices do array)
		while(cursorEsq <= meio && cursorDir <= fim){
			// o <= aqui, garante a estabilidade do algoritmo
			if(array[cursorEsq] <= array[cursorDir])
				arrayAux[cursorAux++] = array[cursorEsq++];
			else
				arrayAux[cursorAux++] = array[cursorDir++];
		}
		// caso ainda houver elementos em uma das partições
		while(cursorEsq <= meio)
			arrayAux[cursorAux++] = array[cursorEsq++];
		while(cursorDir <= fim)
			arrayAux[cursorAux++] = array[cursorDir++];
		// copia o array auxiliar pro array de entrada
		for(int i=0; i< tamanho; i++)
			array[inicio+i] = arrayAux[i];
	}
}
