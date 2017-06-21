package intrucoes;

import DataStructure.ROB;
import DataStructure.RegisterStatus;
import DataStructure.ReservationStation;

abstract public class InstrucaoI implements Instrucao{
	int nByte;
	int opCode;
	int rs;
	int rt;
	int immediate;
	boolean ehEspeculativo = false;
	String instrucao;
	
	ROB rob;
	ReservationStation ress;
	RegisterStatus regs;
	
	//Construtor
	public InstrucaoI(int r1, int r2, int r3, int r4) {
		opCode = r1;
		rs = r2;
		rt = r3;
		immediate = r4;
	}
	
	@Override
	public int getNbyte() {
		return nByte;
	}
	@Override
	public void setNbyte(int i) {
		nByte = i;
	}
	@Override
	public int getOpCode() {
		return opCode;
	}
	@Override
	public boolean ehEspeculativo() {
		return ehEspeculativo;
	}
	@Override
	public void setEspeculativo() {
		ehEspeculativo = true;
	}
	@Override
	public void freeEspeculativo() {
		ehEspeculativo = false;
	}
	@Override
	public String getInstrucao() {
		return instrucao;
	}
	@Override
	public void setInstrucao(String s) {
		instrucao = s;
	}
	@Override
	public void setReservationStation(ReservationStation s) {
		ress = s;		
	}
	@Override
	public void setRob(ROB r) {
		rob = r;
	}
	@Override
	public void setRegisterStatus(RegisterStatus rs) {
		regs = rs;
	}
}
