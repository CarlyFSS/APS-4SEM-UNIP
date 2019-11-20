package app.utils;

public class SortFactory {
	
	private long bubbleTime = 0;
	private long selectionTime = 0;
	private long insertionTime = 0;
	private int[] arr = null;
	private int[] bubble = null;
	private int[] selection = null;
	private int[] insertion = null;
	private TimeCounter timeCounter = null;
	
	public SortFactory(int[] arr) {
		// TODO Auto-generated constructor stub
		timeCounter = new TimeCounter();
		this.arr = arr;
		bubble = new int[arr.length];			//nova instancia para o bubble sort
		selection = new int[arr.length];		//nova instancia para o selection sort
		insertion = new int[arr.length];		//nova instancia para o insertion sort
		for (int i = 0; i < arr.length; i++) {	//seta os valores para as novas instancias
			bubble[i] = arr[i];
			selection[i] = arr[i];
			insertion[i] = arr[i];
		}
	}
	
	public String getToString() {
		return 	toStringTimer() +
				"\n" + 
				toStringArray();
	}
	
	public String toStringTimer(){							//Tabela com o tempo
		return 	"--------------------------------------------\n"+
				getBubbleTime() + "\n" + 
				getSelectionTime() + "\n" + 
				getInsertionTime() + "\n";
	}
	
	public String toStringArray(){							//tabela com os vetores
		return 	"--------------------------------------------\n"+
				getArr().toString() + "\n" +
				"--------------------------------------------\n"+
				getBubble().toString() + "\n" +
				"--------------------------------------------\n"+ 
				getSelection().toString() + "\n" +
				"--------------------------------------------\n"+ 
				getInsertion().toString() + "\n" +
				"--------------------------------------------\n";
	}
	
	//metodos Gets para recuperação de valores
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

	public int[] getBubble() {
		return bubble;
	}

	public int[] getSelection() {
		return selection;
	}

	public int[] getInsertion() {
		return insertion;
	}
	
	//metodos Sets que ordenam o vetor com base na sua Sort e calcula o seu tempo de execução
	public void runBubbleSortAndGetTime() {
        timeCounter.startCounter();
        bubble = BubbleSort.sort(bubble);
        timeCounter.stopCounter();
        bubbleTime = timeCounter.calculateElapsedTimeInMillis();
    }
	
	public void runInsertionSortAndGetTime() {
        timeCounter.startCounter();
        insertion = InsertionSort.sort(insertion);
        timeCounter.stopCounter();
        insertionTime = timeCounter.calculateElapsedTimeInMillis();
    }

    public void runSelectionSortAndGetTime() {
        timeCounter.startCounter();
        selection = SelectionSort.sort(selection);
        timeCounter.stopCounter();
        selectionTime = timeCounter.calculateElapsedTimeInMillis();
    }
}
