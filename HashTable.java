/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		
		if(key == null){
			return 0;
		}
		else{
			int sum = 0;
			for (int i=0; i < key.length(); i++) {
				char place = key.charAt(i);
				sum = sum + place;
			}
			return Math.abs(sum) % 8;
		}
		
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		/*
		Node n = new Node(key);
		if (map[hash(key)] != null) {
			Node temp = new Node(map[hash(key)].record);
			map[hash(key)].record = key;
			map[hash(key)].next = temp;
		} else {
			map[hash(key)] = n;
		}
		*/
		int num = hash(key);
		Node newNode = new Node(key);
		newNode.next = map[num];
		map[num] = newNode;
		
	}
	
	/*
	 * This method returs true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		int num = hash(key);
		Node point = map[num];
		int i = 0;
		while(point != null && i == 0){
			if(point.record == map[num].record)
			i++;
			else{
				point = point.next;
			}
		}
		if( i > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {

		for (int i = 0; i < tableSize; i++) {
			Node pointer = map[i];
			System.out.println(i + ": ");
			while (pointer != null){
				System.out.println(pointer.record);
				pointer = pointer.next;
			}
			
		}
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		// your code here
		int num = hash(key);
		Node pointer = map[num];
		Node p = null;
		while (pointer != null ) {
			if (pointer.record.equals(key)) {
				pointer.record = null;
			} 
			p = pointer;
			pointer = pointer.next;
		
		}
	}
}
