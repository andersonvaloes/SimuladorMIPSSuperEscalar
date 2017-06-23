package dataStructure;

import java.util.ArrayList;

public class ReservationStation {
	
	ArrayList<ReservationStationNode> loadList = new ArrayList<ReservationStationNode>(5);
	ArrayList<ReservationStationNode> addList = new ArrayList<ReservationStationNode>(3);
	ArrayList<ReservationStationNode> multList = new ArrayList<ReservationStationNode>(3);
	private DataStructure dataStructure_;
	
	public ArrayList<ReservationStationNode> getLoadList(){
		return loadList;
	}
	
	public ArrayList<ReservationStationNode> getAddList(){
		return addList;
	}
	
	public ArrayList<ReservationStationNode> getMultList(){
		return multList;
	}
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
	}
	
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
	public void addAddNode(ReservationStationNode rs){
		addList.add(rs);
	}

}
