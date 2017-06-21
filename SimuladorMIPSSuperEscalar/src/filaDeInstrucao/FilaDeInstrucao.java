package filaDeInstrucao;

import java.util.ArrayList;

import DataStructure.ROB;
import DataStructure.RegisterStatus;
import DataStructure.ReservationStation;
import intrucoes.Instrucao;

public class FilaDeInstrucao {
	ArrayList<Instrucao> fila;
	/*ROB rob;
	ReservationStation rs;
	RegisterStatus regs;*/
	public FilaDeInstrucao(String arquivo) {
		fila = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada(arquivo);
	}
	
	public void emitir(){
		
	}
	
	/*public void setRob(ROB r){
		rob = r;
	}
	public void setReservationStation(ReservationStation s){
		rs = s;
	}*/
	
}
