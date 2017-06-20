package DataStructure;

import java.util.ArrayList;

public class ROB {
	
	ArrayList robList = new ArrayList<ROBNode>(10);
	
	public boolean isFull(){
		if (robList.size()>=10){
			return true;
		}
		return false;
	}
}
