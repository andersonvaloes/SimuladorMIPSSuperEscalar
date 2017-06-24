package dataStructure;

import java.util.ArrayList;

public class ReservationStation {
	
	ArrayList<ReservationStationNode> loadList = new ArrayList<ReservationStationNode>(5);
	ArrayList<ReservationStationNode> addList = new ArrayList<ReservationStationNode>(3);
	ArrayList<ReservationStationNode> multList = new ArrayList<ReservationStationNode>(3);
	private DataStructure dataStructure_;
	boolean estaex1 = false;
	boolean estaex2 = false;
	
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
		if(loadList.size()!=0)
			loadList.get(0).execute(0);
		
		
		for(int i = 0; i<3 && !estaex1 ; i++){
			if(i < addList.size()){
				if(addList.get(i).execute(i)){
					estaex1 = true;
					break;
				}
			}
		}
		
		for(int i = 0; i<3 && !estaex2; i++){
			if(i < multList.size()){
				if(multList.get(i).execute(i)) {
					estaex2 = true;
					break;
				}
			}
		}
	}
	
	public void write(){
		if(loadList.size()!=0){
			if(loadList.get(0).write(0))
				return;
		}
		for(int i = 0; i<3 ; i++){
			if(i<multList.size()){
				if(multList.get(i).write(i))
					return;
			}
		}
		for(int i = 0; i<3 ; i++){
			if(i < addList.size()){
				if(addList.get(i).write(i))
					return;
			}
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
