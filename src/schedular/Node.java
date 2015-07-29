package schedular;
/**
 *
 * @author 130372T
 */

/**
 * This class is for creating nodes of the linked list
 * Instances of this class is used to create the waiting process queue in a scheduler
 */
public class Node {
        Node next;
	Object data;
	
        //constructer
	public Node(Object data){
		this.data = data;
		this.next = null;
	}
	
        //return next node
	public Node getNext() {
		return next;
	}
        
        //set next node
	public void setNext(Node next) {
		this.next = next;
	}
        
        //get the data object
	public Object getData() {
		return data;
	}

        //set data object
	public void setData(Object data) {
		this.data = data;
	}
    
}
