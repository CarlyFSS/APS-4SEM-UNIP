package app.utils;

public class InsertionSort {

	/**
	 * https://www.geeksforgeeks.org/java-program-for-insertion-sort/
	 * Métodos simples
	 * @return array organizado
	 */
	/*Função para classificar matriz usando classificação por inserção*/
	public static int[] sort(int arr[]) {
	    int n = arr.length; 
	    for (int i=1; i<n; ++i) 
	    { 
	        int key = arr[i]; 
	        int j = i-1; 
	
	        /* Mova elementos de arr [0..i-1], que são
	           maior que a chave, para uma posição à frente
	           de sua posição atual */
	        while (j>=0 && arr[j] > key) 
	        { 
	            arr[j+1] = arr[j]; 
	            j = j-1; 
	        } 
	        arr[j+1] = key; 
	    }
	    return arr;
	}
}
