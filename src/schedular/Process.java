package schedular;
/**
 *
 * @author 130372T
 */


/**
 * This class is for creating process objects
 * A process has,    -Process ID
 *                   -Arrival Time
 *                   -Service Time
 *                   -Completed State
 *                   -Process Name
 */
public class Process {
        private int ID;
	private int arrivalTime;
	private int serviceTime;
	private boolean completed;
        private String name;
	
	public Process(String name,int ID){
		this.completed = false;
		this.ID = ID;
                this.name = name;
	}
        
        public String getName(){
            return this.name;
        }
        
        public void setName(String name){
            this.name = name;
        }
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public boolean isCompleted() {
		return completed;
	}
	public int getID() {
		return ID;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public void run(){
		System.out.println((this.ID) + " is running");
	}
    
}
