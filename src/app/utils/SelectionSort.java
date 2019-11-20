package app.utils;

public class SelectionSort {

	/**
	 * https://www.geeksforgeeks.org/java-program-for-selection-sort/
	 * Métodos simples
	 * @return array organizado
	 */
	//inicio da organizacão do vetor por seleção
	public static int[] sort(int arr[]) {
	    for (int i = 0; i < arr.length; ++i) {
	        int indiceMenor = i;
	        for (int indiceSeguinte = i+1; indiceSeguinte < arr.length; ++indiceSeguinte) {
	            if (arr[indiceSeguinte] < arr[indiceMenor]) {
	                indiceMenor = indiceSeguinte;
	            }
	        }
	        int aux = arr[i];
	        arr[i] = arr[indiceMenor];
	        arr[indiceMenor] = aux;
	    }
	    return arr;
	}
}
