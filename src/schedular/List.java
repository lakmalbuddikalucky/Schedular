package schedular;

/**
 *
 * @author 130372T
 */
public class List {
        Node head;
	Node tail;
	int size;
	
	public List(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
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
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node newHead) {
		newHead.setNext(head);
		this.head = newHead;
		size++;
		if(size == 1){
			tail = newHead;
		}
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getTail() {
		return tail;
	}

	public int getSize() {
		return size;
	}
}
