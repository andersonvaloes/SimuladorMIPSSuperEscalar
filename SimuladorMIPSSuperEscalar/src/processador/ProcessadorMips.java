package processador;

import java.util.ArrayList;

import DataStructure.Memoria;
import DataStructure.ROB;
import DataStructure.ROBNode;
import DataStructure.RSNode;
import DataStructure.RegisterStatus;
import DataStructure.Registradores;
import DataStructure.ReservationStation;
import GUI.InterfaceMIPS;

public class ProcessadorMips {
	ReservationStation RS = new ReservationStation();
	ROB rob = new ROB();
	Memoria memoria = new Memoria();
	RegisterStatus regStatus = new RegisterStatus();
	Registradores regs = new Registradores();
	InterfaceMIPS GUI = new InterfaceMIPS();
	
	public void RunClock(){
		RS.execute();
		RS.write();
		rob.commit();
		
		ArrayList<ROBNode> robList = rob.getROBList();
		ArrayList<RSNode> rsLoadList = RS.getLoadList();
		ArrayList<RSNode> rsAddList = RS.getAddList();
		ArrayList<RSNode> rsMultList = RS.getMultList();
		
		GUI.setTableROB(robList);
		GUI.setTableRS(rsLoadList,rsAddList,rsMultList);
		GUI.setTableRegs(regs);
		GUI.setTableMemoria(memoria);
		GUI.setTableClock();
		
	}
}
