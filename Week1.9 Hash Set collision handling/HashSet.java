public class HashSet {
	
	private LinkedList<String>[] buckets;

	public HashSet(int size){
		//the constructor for the HashSet, create this new LinkedList array
		buckets = new LinkedList[size];
		//initialize each bucket as a new LinkedList of strings
		for(int i = 0; i < size; i++){
			buckets[i] = new LinkedList<String>();
		}
	}

	private int hashCode(String value){
		return value.length();
	}


	public boolean add(String value){
		if(!contains(value)){
			int index = hashCode(value) % buckets.length;
			LinkedList<String> bucket = buckets[index];
			bucket.addFirst(value);
			return true;
		}
		//if the set already contains that value, won't add it again
		return false;
	}

	public boolean contains(value){
		int index = hashCode(value) % buckets.length;
		LinkedList<String> bucket = buckets[index];
		//iterating through that bucket(LinkedLiST) determining whether it contains the element
		return bucket.contains(value);
	}


}