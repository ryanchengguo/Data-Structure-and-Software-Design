public class HashSet {

	private LinkedList<String>[] buckets;
	//resize linked list
	private int currentSize = 0;
	//loadFactor determine if the bucket is too full, then will resize
	//loadFactor will be comapred with currentSize / buckets.length
	private double loadFactor;

	//implementing a Hash Set
	public HashSet(int size) {
		buckets = new LinkedList[size];
		for (int i = 0; i < size; i++){
			buckets[i] = new LinkedList<String>();
		}
		this.loadFactor = loadFactor;
	}

	public int HashCode(String value){
		return value.length();
	}

	public boolean add(String value) {
		//detemine if HashSet have the value already
		if(!contains(value)){
			int index = HashCode(value) % buckets.length;
			LinkedList<String> bucket = buckets[index];
			bucket.addFirst(value);
			//resize linked list
			currentSize++;
			//casting int to double
			double averageLoad = currentSize / (double)buckets.length;
			if(averageLoad > loadFactor) {
				reinsertAll();
			}
			return true;
		}
		return false;
	}

	//implementation of the method to reinsert all values
	private void reinsertAll() {
		//create loacal variable; renaming buckets as oldBuckets
		LinkedList<String> oldBuckets[] = buckets;
		//create a new array of linked list
		buckets = new LinkedList[buckets.length * 2];

		for (LinkedList<String> bucket : oldBuckets){
			for(String element : bucket){
				int index = HashCode(element) % buckets.length;
				//reinsert to new bucket
				Linkedlist<String> newBucket = buckets[index];
				newBucket.addFirst(element);
			}
		}
	}
}