
public class addToHeap {

	public void add(int value){
		if(size == values.length){
			throw new HeapException();
		}
		values[size] = value;
		bubbleUp(size);
		size++;
	}

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
