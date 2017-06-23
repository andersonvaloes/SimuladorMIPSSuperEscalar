package intrucoes;

import dataStructure.DataStructure;
import dataStructure.RegisterStatus;
import dataStructure.ReorderBuffer;
import dataStructure.ReservationStation;

abstract public class InstrucaoJ implements Instrucao{
	int nByte_;
	int opCode_ = 2;
	int target_;
	boolean ehEspeculativo_ = false;
	String instrucao_;

	private DataStructure dataStructure_;
	
	
	public InstrucaoJ(int target) {
		target_ = target;
	}
	
	@Override
	public int getNbyte() {
		return nByte_;
	}
	@Override
	public void setNbyte(int i) {
		nByte_ = i;
	}
	@Override
	public int getOpCode() {
		return opCode_;
	}
	@Override
	public boolean ehEspeculativo() {
		return ehEspeculativo_;
	}
	@Override
	public void setEspeculativo() {
		ehEspeculativo_ = true;
	}
	@Override
	public void freeEspeculativo() {
		ehEspeculativo_ = false;
	}
	@Override
	public String getInstrucao() {
		return instrucao_;
	}
	@Override
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
		
	}
	/*@Override
	public void setInstrucao(String s) {
		instrucao = s;
	}
	@Override
	public void setReservationStation(ReservationStation s) {
		ress = s;		
	}
	@Override
	public void setRob(ReorderBuffer r) {
		rob = r;
	}*/
}
