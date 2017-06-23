package intrucoes;

import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStationNode;

public class InstrucaoIOpLw extends InstrucaoI implements Instrucao {

	public InstrucaoIOpLw(int r1, int r2, int r3, int r4) {
		super(r1, r2, r3, r4);
	}
	/*@Override
	public boolean issue() {
		if(dataStructure_.getReservationStation().isFullLoad() || 
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
