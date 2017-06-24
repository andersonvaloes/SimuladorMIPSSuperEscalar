package dataStructure;

import java.util.ArrayList;

import intrucoes.Instrucao;

public class ReservationStation {
	
	ArrayList<ReservationStationNode> loadList = new ArrayList<ReservationStationNode>(5);
	ArrayList<ReservationStationNode> addList = new ArrayList<ReservationStationNode>(3);
	ArrayList<ReservationStationNode> multList = new ArrayList<ReservationStationNode>(3);
	private DataStructure dataStructure_;
	Instrucao i1=null, i2=null;
	int a1=0, a2=0;
	
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
		
		if(i1 == null){
			for(int i = 0; i<3 ; i++){
				if(i < addList.size()){
					if(addList.get(i).execute(i)){
						i1 = addList.get(i)._instrucao;
						a1 = i;
						break;
					}
				}
			}
		}else{
			i1.execute(a1);
		}
		
		if(i2 == null){
			for(int i = 0; i<3; i++){
				if(i < multList.size()){
					if(multList.get(i).execute(i)) {
						i2 = addList.get(i)._instrucao;
						a2 = i;
						break;
					}
				}
			}
		}else{
			i2.execute(a2);
			
		}
	}
	
	public void write(){
		if(loadList.size()!=0){
			if(loadList.get(0).write(0)){
				loadList.remove(0);
				return;
			}
		}
		for(int i = 0; i<3 ; i++){
			if(i<multList.size()){
				if(multList.get(i).write(i)){
					multList.remove(i);
					return;
				}
			}
		}
		for(int i = 0; i<3 ; i++){
			if(i < addList.size()){
				if(addList.get(i).write(i)){
					addList.remove(i);
					return;
				}
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
