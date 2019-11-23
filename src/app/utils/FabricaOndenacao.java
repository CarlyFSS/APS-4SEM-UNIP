package app.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FabricaOndenacao {

	private long bubbleTime = 0;
	private long selectionTime = 0;
	private long insertionTime = 0;
	private long mergeTime = 0;
	private long dadosTime = 0;
	private int[] arr = null;
	private int[] bubble = null;
	private int[] selection = null;
	private int[] insertion = null;
	private int[] merge = null;
	private List<Dado> listDados = null;
	private TimeCounter timeCounter = null;

	public FabricaOndenacao(int[] arr) {
		timeCounter = new TimeCounter();
		this.arr = arr;
		bubble = Arrays.copyOf(arr, arr.length); // cria copia para cada array
		selection = Arrays.copyOf(arr, arr.length);
		insertion = Arrays.copyOf(arr, arr.length);
		merge = Arrays.copyOf(arr, arr.length);
	}

	public FabricaOndenacao(List<Dado> listDados) {
		timeCounter = new TimeCounter();
		this.listDados = listDados;
	}

	public String toStringCorpo(long valor) {
		String leftAlignFormat = " | %-15d | %-15d | %-15d | %-15d | %-15d | %n";
		String corpo = String.format(leftAlignFormat, valor, bubbleTime, selectionTime, insertionTime, mergeTime);
		return corpo + "+----------------+--------------+-------------+--------------+-------------+\n";
	}

	// metodos Gets para recupera��o de valores
	public int[] getArr() {
		return arr;
	}

	public long getBubbleTime() {
		return bubbleTime;
	}

	public long getSelectionTime() {
		return selectionTime;
	}

	public long getInsertionTime() {
		return insertionTime;
	}

	public long getMergeTime() {
		return mergeTime;
	}

	public long getDadosTime() {
		return dadosTime;
	}

	public int[] getMerge() {
		return merge;
	}

	public int[] getBubble() {
		return bubble;
	}

	public int[] getSelection() {
		return selection;
	}

	public int[] getInsertion() {
		return insertion;
	}

	public List<Dado> getListDados() {
		return listDados;
	}

	public void runDadosSortAndGetTime() {
		timeCounter.startCounter();
		Collections.sort(getListDados());
		timeCounter.stopCounter();
		dadosTime = timeCounter.calculateElapsedTimeInMillis();
	}

	// metodo generico para todos os Sort abaixo
	public void runAllSortAndGetTime() {
		runBubbleSortAndGetTime();
		runInsertionSortAndGetTime();
		runSelectionSortAndGetTime();
		runMergeSortAndGetTime();
	}

	// metodos Sets que ordenam o vetor com base na sua Sort e calcula o seu tempo
	// de execu��o
	public void runBubbleSortAndGetTime() {
		timeCounter.startCounter();
		bubble = BubbleSort.sort(getBubble());
		timeCounter.stopCounter();
		bubbleTime = timeCounter.calculateElapsedTimeInMillis();
	}

	public void runInsertionSortAndGetTime() {
		timeCounter.startCounter();
		insertion = InsertionSort.sort(getInsertion());
		timeCounter.stopCounter();
		insertionTime = timeCounter.calculateElapsedTimeInMillis();
	}

	public void runSelectionSortAndGetTime() {
		timeCounter.startCounter();
		selection = SelectionSort.sort(getSelection());
		timeCounter.stopCounter();
		selectionTime = timeCounter.calculateElapsedTimeInMillis();
	}

	public void runMergeSortAndGetTime() {
		timeCounter.startCounter();
		merge = MergeSort.sort(getMerge(), 0, getMerge().length - 1);
		timeCounter.stopCounter();
		mergeTime = timeCounter.calculateElapsedTimeInMillis();
	}
}
