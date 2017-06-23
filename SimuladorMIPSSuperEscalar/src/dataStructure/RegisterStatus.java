package dataStructure;

import java.util.ArrayList;

public class RegisterStatus {
	ArrayList<Integer> reorder = new ArrayList<Integer>(32);
	ArrayList<Boolean> busy = new ArrayList<Boolean>();
	public boolean isBusy (int ID){
		return busy.get(ID);
	}
	public int getReorder(int id){
		return reorder.get(id);
	}
	public ArrayList<Integer> getReorder(){
		return reorder;
	}
	public ArrayList<Boolean> getBusy(){
		return busy;
	}
	
}
