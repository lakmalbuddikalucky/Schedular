package schedular;
import Interfaces.MainWindow;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author 130372T
 */

/**
 * This class is for creating schedulers
 */
public class Schedular extends Thread{
        //initially creates 5 new processes
        Process p1,p2,p3,p4,p5;
        
        //the output list of processes which will be sorted according to the time they begin to execute
        Process[] output = new Process[5];
        
        //the list of processes waiting to be executed at a given time
        List waitingList = new List();
        int index=0;
        int index2=0;
        int prevTime=0;
        boolean reA=false,reB=false,reC=false,reD=false,reE=false;
        
        //this method execute the scheduler and output a list of processes sorted according to the time they begin to execute
        public void runQueue(int time,JButton q1,JButton q2,JButton q3, JButton q4, JButton q5,JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5){
            JButton[] buttonList = new JButton[5];
            buttonList[0] = q1;
            buttonList[1] = q2;
            buttonList[2] = q3;
            buttonList[3] = q4;
            buttonList[4] = q5;
            
            for(JButton button : buttonList){
                button.setText("");
            }
            
            reA = MainWindow.removed(1);
            reB = MainWindow.removed(2);
            reC = MainWindow.removed(3);
            reD = MainWindow.removed(4);
            reE = MainWindow.removed(5);
            
            int time1 = Integer.valueOf(t1.getText());
            int time2 = Integer.valueOf(t2.getText());
            int time3 = Integer.valueOf(t3.getText());
            int time4 = Integer.valueOf(t4.getText());
            int time5 = Integer.valueOf(t5.getText());
            
            if(time1<=time) {
                for(JButton button : buttonList){
                    if(button.getText().equals("")){
                         if(reA==false) {
                             button.setText("A");
                         }
                         break;
                    }
                } 
            }
 
            if(time2<=time) {
                for(JButton button : buttonList){
                    if(button.getText().equals("")){
                         if(reB==false)button.setText("B");
                         break;
                    }
                } 
            }
            
            if(time3<=time) {
                for(JButton button : buttonList){
                    if(button.getText().equals("")){
                         if(reC==false)button.setText("C");
                         break;
                    }
                } 
            }
            
            if(time4<=time) {
                for(JButton button : buttonList){
                    if(button.getText().equals("")){
                         if(reD==false)button.setText("D");
                         break;
                    }
                } 
            }
            
            if(time5<=time) {
                for(JButton button : buttonList){
                    if(button.getText().equals("")){
                         if(reE==false)button.setText("E");
                         break;
                    }
                } 
            }
        }
        
        //run method of the sceduler
	public Process[] run(JButton q1,JButton q2,JButton q3, JButton q4, JButton q5,JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JTextField s1,JTextField s2,JTextField s3,JTextField s4,JTextField s5){
		//create an array of processes
                //there can be any number of processes but here it is hard coded to 5 processes
                Process[] processList = new Process[5];
		
                p1 = new Process("A",0);
		processList[0] = p1;
		processList[0].setArrivalTime(Integer.valueOf(t1.getText()));
		processList[0].setServiceTime(Integer.valueOf(s1.getText()));
                       
                p2 = new Process("B",1);
		processList[1] = p2;
		processList[1].setArrivalTime(Integer.valueOf(t2.getText()));
		processList[1].setServiceTime(Integer.valueOf(s2.getText()));
                       
                p3 = new Process("C",2);
		processList[2] = p3;
		processList[2].setArrivalTime(Integer.valueOf(t3.getText()));
		processList[2].setServiceTime(Integer.valueOf(s3.getText()));
                        
                p4 = new Process("D",3);
		processList[3] = p4;
		processList[3].setArrivalTime(Integer.valueOf(t4.getText()));
		processList[3].setServiceTime(Integer.valueOf(s4.getText()));
                        
                p5 = new Process("E",4);
		processList[4] = p5;
		processList[4].setArrivalTime(Integer.valueOf(t5.getText()));
		processList[4].setServiceTime(Integer.valueOf(s5.getText()));
		
                /*
                * Sort the processes according to the Arrival Time
                */                
                
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4-j ; j++){
                        if(processList[j].getArrivalTime() > processList[j+1].getArrivalTime()){
                            Process temp = processList[j];
                            processList[j] = processList[j+1];
                            processList[j+1] = temp;
                        }
                    }
                }
		int lastArrivedProcessID = -1;
		int time = 0;
		int count = 0;
		boolean finished = false;
		
                
                
                //runs a loop until all the processes finish executing
		while(!finished){ 
			for(int i = lastArrivedProcessID + 1; i < 5; i++){
                            //check whether new processes have arrived
                            //if (yes) --> the new processes will be added to the proper location of the waiting queue
                            //if (no)  --> break the for loop
				
                            if(processList[i].getArrivalTime() <= time){
					Node currentNode = waitingList.getHead();
					Node prevNode = null;
					while(true){
                                                //checking whether the current node is null
						if(currentNode == null){
							waitingList.add(processList[i]);
							break;
						}else if( ((Process)currentNode.getData()).getServiceTime() > processList[i].getServiceTime() ){
                                                        //this is checked in order to make the queue in order
							Node newNode = new Node(processList[i]);
							if(prevNode != null){
								prevNode.setNext(newNode);
								newNode.setNext(currentNode);
								waitingList.setSize(waitingList.getSize() + 1);
								break;
							}else{
								waitingList.setHead(newNode);
								break;
							}
						}else{
							prevNode = currentNode;
							currentNode = currentNode.getNext();
						}
					}
				}else{
					break;
				}
				lastArrivedProcessID++;
			}
                        //check whether the waiting list is empty
                        //if (yes) --> no new processes have arrived so add +1 to time
                        //if (no)  --> take the head of the waiting list of processes
                        //             add it to the output list
                        //             add the service time of that process to time
                        //             remove that process from the waiting list
			
			if(waitingList.getSize() == 0){
				time ++;
                                
			}else{
                                output[index] = (Process)waitingList.getHead().getData();
                                index++;
				count ++;
				time += ((Process)waitingList.getHead().getData()).getServiceTime();
				((Process)waitingList.getHead().getData()).setCompleted(true);
				waitingList.removeHead();
				if(count == 5){
                                    return output;
                                }		
			}  
                        
		}
                
                //return the output process list
                return output;
	}
}
