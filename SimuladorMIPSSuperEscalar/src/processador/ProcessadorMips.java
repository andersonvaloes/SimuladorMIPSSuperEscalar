package processador;
import java.util.ArrayList;

import javax.xml.crypto.Data;
import javax.xml.transform.sax.SAXTransformerFactory;
import GUI.InterfaceMIPS;
import dataStructure.DataStructure;
import dataStructure.FilaDeInstrucao;
import dataStructure.Memory;
import dataStructure.RegisterStatus;
import dataStructure.Registers;
import dataStructure.ReorderBuffer;
import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStation;
import dataStructure.ReservationStationNode;

public class ProcessadorMips {
	DataStructure dataStructure = new DataStructure(new FilaDeInstrucao(),
									new Memory(), new Registers(), new RegisterStatus(),
									new ReorderBuffer(), new ReservationStation());	
	InterfaceMIPS GUI = new InterfaceMIPS();
	
	public ProcessadorMips(String arquivo) {
		dataStructure.getFilaDeIntrucao_().setNaFilaDeInstrucao(arquivo, dataStructure);
	}
	
	public void RunClock(){
		dataStructure.getFilaDeIntrucao_().issue();
		dataStructure.getReservationStation().execute();
		dataStructure.getReservationStation().write();
		dataStructure.getReorderBuffer_().commit();
		
		ArrayList<ReorderBufferNode> robList = dataStructure.getReorderBuffer_().getROBList();
		ArrayList<ReservationStationNode> rsLoadList = dataStructure.getReservationStation().getLoadList();
		ArrayList<ReservationStationNode> rsAddList = dataStructure.getReservationStation().getAddList();
		ArrayList<ReservationStationNode> rsMultList = dataStructure.getReservationStation().getMultList();
		
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("");
		
		System.out.println("RobList");
		for(int i=0; i < robList.size(); i++){
			System.out.println(robList.get(i).instruction);
		}
		System.out.println("rsLoadList");
		for(int i=0; i < rsLoadList.size(); i++){
			System.out.println(rsLoadList.get(i).getInstrucao().getInstrucao());
		}
		System.out.println("rsAddList");
		for(int i=0; i < rsAddList.size(); i++){
			System.out.println(rsAddList.get(i).getInstrucao().getInstrucao());
		}
		System.out.println("rsMultList");
		for(int i=0; i < rsMultList.size(); i++){
			System.out.println(rsMultList.get(i).getInstrucao().getInstrucao());
		}
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("");
		
		GUI.setTableROB(dataStructure.getReorderBuffer_().getROBList());
		GUI.setTableRS(dataStructure.getReservationStation().getLoadList(),dataStructure.getReservationStation().getAddList(),
				dataStructure.getReservationStation().getMultList());
		GUI.setTableRegs(dataStructure.getRegisterStatus_());
		GUI.setTableMemoria(dataStructure.getMemory_());
		//GUI.setTableClock();
		
	}
	
	/*public static void main(String[] args) {
		ProcessadorMips p = new ProcessadorMips("/home/spider/git/SimuladorMIPSSuperEscalar/SimuladorMIPSSuperEscalar/src/dataStructure/entrada");
		System.out.println(p.dataStructure.sPointer);
		System.out.println(p.dataStructure.getFilaDeIntrucao_().fila_.size());
		p.RunClock();
		System.out.println(p.dataStructure.getReservationStation().getAddList().get(0).getInstrucao().getInstrucao());
		p.RunClock();
		p.RunClock();
		System.out.println(p.dataStructure.getReservationStation().getLoadList().get(0).getInstrucao().getInstrucao());

		
	}*/
}
