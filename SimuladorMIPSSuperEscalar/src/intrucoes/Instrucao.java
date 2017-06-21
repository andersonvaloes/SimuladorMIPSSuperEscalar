package intrucoes;

import DataStructure.ROB;
import DataStructure.RegisterStatus;
import DataStructure.ReservationStation;

public interface Instrucao {
	public int getOpCode();
	public int getNbyte();
	public String getInstrucao();
	
	public void setNbyte(int i);
	public void setInstrucao(String s);
	public void setEspeculativo();
	public void setRob(ROB r);
	public void setReservationStation(ReservationStation s);
	public void setRegisterStatus(RegisterStatus rs);
	
	public void freeEspeculativo();
	public boolean ehEspeculativo();
	public void execute();
	public void write();
}
