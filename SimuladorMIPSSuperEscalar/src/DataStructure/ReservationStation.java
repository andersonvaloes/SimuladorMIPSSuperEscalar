package DataStructure;

import java.util.ArrayList;

public class ReservationStation {
	
	ArrayList loadList = new ArrayList<RSNode>();
	ArrayList addList = new ArrayList<RSNode>();
	ArrayList multList = new ArrayList<RSNode>();
	
	public boolean isFullLoad(){
		if(loadList.size()>=5){
			return true;
		}
		
		return false;
	}
	
	
	public boolean isFullAdd(){
		if(addList.size()>=5){
			return true;
		}
		
		return false;
	}
	
	public boolean isFullMult(){
		if(multList.size()>=5){
			return true;
		}
		
		return false;
	}

}
