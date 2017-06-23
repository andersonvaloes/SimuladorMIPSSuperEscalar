package processador;
import java.util.ArrayList;
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
		
		GUI.setTableROB(robList);
		GUI.setTableRS(rsLoadList,rsAddList,rsMultList);
		GUI.setTableRegs(dataStructure.getRegisters_());
		GUI.setTableMemoria(dataStructure.getMemory_());
		GUI.setTableClock();
		
	}
}
