package dataStructure;

import java.util.ArrayList;

import intrucoes.Instrucao;
import intrucoes.InstrucaoJOpJmp;

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
				if(i < addList.size() && i1 ==null){
					if(addList.get(i).execute(i)){
						i1 = addList.get(i)._instrucao;
						a1 = i;
						if(i1.terminouDeExecutar()){
							i1.setMudou(false);
							//addList.remove(a1);
							i1 = null;
						}
						System.out.println("Teste");
						break;
					}
				}
			}
		}else{
			if(!i1.terminouDeExecutar()){
					i1.execute(a1);
					if(i1.terminouDeExecutar()){
						i1.setMudou(false);
						//addList.remove(a1);
						i1 = null;
					}
			}
		}
		
		if(i2 == null){
			for(int i = 0; i<3; i++){
				if(i < multList.size() && i2 ==null){
					if(multList.get(i).execute(i)) {
						i2 = multList.get(i)._instrucao;
						a2 = i;
						if(i2.terminouDeExecutar()){
							i2.setMudou(false);
							//addList.remove(a2);
							i2 = null;
						}
						break;
					}
				}
			}
		}else{
			//System.out.println("entrou em execussao");
			if(!i2.terminouDeExecutar()){
				i2.execute(a1);
				if(i2.terminouDeExecutar()){
					i2.setMudou(false);
					//addList.remove(a2);
					i2 = null;
				}
			}
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
					//System.out.println(i+ "Probelma RS ver ind" + multList.size());
					//multList.remove(i);
					return;
				}
			}
		}
		for(int i = 0; i<3 ; i++){
			if(i < addList.size()){
				if(addList.get(i).write(i)){
					//addList.remove(i);
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
