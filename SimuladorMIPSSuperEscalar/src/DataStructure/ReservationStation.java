package DataStructure;

import java.util.ArrayList;

public class ReservationStation {
	
	ArrayList<RSNode> loadList = new ArrayList<RSNode>(5);
	ArrayList<RSNode> addList = new ArrayList<RSNode>(3);
	ArrayList<RSNode> multList = new ArrayList<RSNode>(3);
	
	public void execute(){
		for(int i = 0; i<5 ; i++){
			loadList.get(i).execute();
		}
		for(int i = 0; i<3 ; i++){
			addList.get(i).execute();
			multList.get(i).execute();
		}
	}
	
	public void write(){
		for(int i = 0; i<5 ; i++){
			loadList.get(i).write();
		}
		for(int i = 0; i<3 ; i++){
			addList.get(i).write();
			multList.get(i).write();
		}
	}
	
	
	public boolean isFullLoad(){
		if(loadList.size()>=5){
			return true;
		}
		
		return false;
	}
	
	
	public boolean isFullAdd(){
		if(addList.size()>=3){
			return true;
		}
		
		return false;
	}
	
	public boolean isFullMult(){
		if(multList.size()>=3){
			return true;
		}
		
		return false;
	}

}
