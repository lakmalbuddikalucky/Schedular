package schedular;

/**
 *
 * @author 130372T
 */

/**
 * This class is to create linked lists
 */
public class List {
        Node head;
	Node tail;
	int size;
	
        //constructer
	public List(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
        //add a new node and data inside it
	public void add(Object data){
		Node node = new Node(data);
		if(tail != null){
			this.tail.setNext(node);
			this.tail = node;
		}
		if(size == 0){
			this.head = node;
			this.tail = node;
		}
		size++;
	}
	
        //remove the head of the list
	public void removeHead(){
		if(head != null){
			head = head.getNext();
			size--;
			if(size == 0){
				head = null;
				tail = null;
			}
		}
	}
	
        //get the head of list
	public Node getHead() {
		return head;
	}

        //set the head of list
	public void setHead(Node newHead) {
		newHead.setNext(head);
		this.head = newHead;
		size++;
		if(size == 1){
			tail = newHead;
		}
	}
        
        //set the size of the list
	public void setSize(int size) {
		this.size = size;
	}

        //set the tail
	public Node getTail() {
		return tail;
	}
        
        //get the size of the list
	public int getSize() {
		return size;
	}
}
