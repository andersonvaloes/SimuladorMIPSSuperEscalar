package intrucoes;

import dataStructure.DataStructure;
import dataStructure.RegisterStatus;
import dataStructure.ReorderBuffer;
import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStation;
import dataStructure.ReservationStationNode;

abstract public class InstrucaoI implements Instrucao{
	int nByte_;
	int opCode_;
	int rs_;
	int rt_;
	int immediate_;
	boolean ehEspeculativo_ = false;
	String instrucao_;
	
	
	DataStructure dataStructure_;
	
	//Construtor
	public InstrucaoI(int opCode, int rs, int rt, int immediate) {
		opCode_ = opCode;
		rs_ = rs;
		rt_ = rt;
		immediate_ = immediate;
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
	public void setInstrucao(String s) {
		instrucao_ = s;
	}
	@Override
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
		
	}
	/*@Override
	public boolean issue() {
		if(dataStructure_.getReservationStation().isFullAdd() || 
				dataStructure_.getReorderBuffer_().isFull()) return false;
		
		ReservationStationNode rsNode = new ReservationStationNode();
		
		rsNode.setVj(rs_);
		rsNode.setQj(0);
		
		rsNode.setBusy(true);
		rsNode.setInstrucao(this);
		rsNode.setOp(instrucao_);
		
		
		int pos;
		pos = dataStructure_.getReorderBuffer_().getROBList().size();
		ReorderBufferNode robNode = new ReorderBufferNode();
		rsNode.setDest(pos);
		robNode._instrucao = this;
		robNode.instruction = instrucao_;
		//robNode.destination = rd_;
		robNode.busy = true;
		if(dataStructure_.getReorderBuffer_().getROBList().size() == 0)
			robNode.ID = 0;
		else
			robNode.ID = dataStructure_.getReorderBuffer_().getROBList().get(dataStructure_.getReorderBuffer_().getROBList().size()-1).ID++;
		
		
		rsNode.setVk(rs_);
		rsNode.setQk(0);
		
		robNode.state = "Issue";
		
		dataStructure_.getReorderBuffer_().getROBList().add(robNode);
		dataStructure_.getReservationStation().getAddList().add(rsNode);		
		return true;
	}*/
}
