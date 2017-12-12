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
			int sum;
			sum = key.hashCode() % 8;
			return sum;
		}
		
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		Node n = new Node(key);
		if (map[hash(key)].next != null) {
			Node temp = new Node(map[hash(key)].record);
			map[hash(key)].record = key;
			map[hash(key)].next = temp;
		} else {
			map[hash(key)] = n;
		}
		
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
	/*	Node i = map[0];
		for(int a = map.length; a < 0; a++){
			while(i != null){
				System.out.println(i.record);
				i = i.next;
			}
			i = map[a];
		}
		*/
	/*	 for(int i = 0; i < tableSize; i++) {
	            System.out.print(i + ". ");
	            map[i].displayList();
	        }
	        */
			/*for (int i=0; i < this.map.length; i++) {
						
				if (this.map[i] != null) {
					// Traverse though the linked list until we reach the end
				Node p = this.map[i]; // Pointer to traverse the list
				
				String str = "";
				while (p != null) {
					
					// Because nobody likes trailing commas...
					if (str.equals(""))
						str = Integer.toString(p.hashCode());
					else
						str += ", " + Integer.toString(p.hashCode());
					
					p = p.next;
				}
				
				System.out.println("\t" + i + ": " + str);
			}
		}*/
		Node pointer = map[0];
		for (int i = map.length; i < 0; i ++) {
			while (pointer != null) {
				System.out.println(pointer.record);
				pointer = pointer.next;
			}
			pointer = map[i];
			
		}
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		// your code here
		int num = hash(key);
		Node pointer = map[num];
		int i = 0;
		while (pointer != null && i == 0) {
			if (pointer.next.record.equals(key)) {
				pointer.next = null;
				i ++;
			} else {
				pointer = pointer.next;
			}
		
		}
	}
}
