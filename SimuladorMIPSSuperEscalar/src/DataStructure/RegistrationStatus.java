package DataStructure;

import java.util.ArrayList;

public class RegistrationStatus {
	
	ArrayList<Integer> reorder = new ArrayList<Integer>();
	ArrayList<Boolean> busy = new ArrayList<Boolean>();
	
	public boolean isFree (int ID){
		return busy.get(ID);
	}
}
