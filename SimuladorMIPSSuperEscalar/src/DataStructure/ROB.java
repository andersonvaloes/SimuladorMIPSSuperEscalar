package DataStructure;

import java.util.ArrayList;

public class ROB {
	
	ArrayList<ROBNode> robList = new ArrayList<ROBNode>(10);
	
	public boolean isFull(){
		if (robList.size()>=10){
			return true;
		}
		return false;
	}
	
	public boolean getBusy (int h){
		return robList.get(h).busy;
	}
	
	public int getValue (int h){
		return robList.get(h).value;
	}
	
	public int getDest (int h){
		return robList.get(h).destination;
	}
	
	public String getInstruction (int h){
		return robList.get(h).instruction;
	}
	
	public void setInstruction (int h, String instruction){
		robList.get(h).instruction=instruction;
	}
	
	public void setDest (int b,int rd){
		robList.get(b).destination=rd;
	}
	
	public void setBusy (int b, boolean set){
		robList.get(b).busy=set;
	}
	
	public void setValue (int b, int result){
		robList.get(b).value=result;
	}
}
