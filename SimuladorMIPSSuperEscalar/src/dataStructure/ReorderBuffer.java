package dataStructure;

import java.util.ArrayList;

public class ReorderBuffer {
	
	private ArrayList<ReorderBufferNode> robList = new ArrayList<ReorderBufferNode>(10);
	private DataStructure dataStructure_;
	int head_ = 0, tail_ = 0;
	boolean containsElement = false;
	
	public ArrayList<ReorderBufferNode> getROBList(){
		return robList;
	}
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
	}
	
	public void clearAll(){
		robList.clear();
	}
	
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
	
	/*public void commit(){
		
	}*/
}
