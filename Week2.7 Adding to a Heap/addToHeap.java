
public class addToHeap {


	public void bubbleUp(int index){

		if(index == 0) return;

	//integer division
		int parentIndex = (index - 1) / 2;

		if(values[parentIndex] < values[index]){
			swapValue(values[parentIndex], values[index]);
			bubbleUp(parentIndex);
		}

	}

}
