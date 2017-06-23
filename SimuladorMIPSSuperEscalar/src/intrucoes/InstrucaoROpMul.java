package intrucoes;

import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStationNode;

public class InstrucaoROpMul extends InstrucaoR implements Instrucao{
	int time = 3;
	public InstrucaoROpMul(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct_ = 34;		
	}
	@Override
	public boolean issue() {
		if(dataStructure_.getReservationStation().isFullMult() || 
				dataStructure_.getReorderBuffer_().isFull()) return false;
		
		ReservationStationNode rsNode = new ReservationStationNode();
		ReorderBufferNode robNode = new ReorderBufferNode();
		
		if(dataStructure_.getRegisterStatus_().isBusy(rs_)){
			int h = dataStructure_.getRegisterStatus_().getReorder(rs_);
			if(!dataStructure_.getReorderBuffer_().getBusy(h)){
				rsNode.setVj(dataStructure_.getReorderBuffer_().getValue(h));
				rsNode.setQj(0);
			}else{
				rsNode.setQj(h);
			}
		}else{
			rsNode.setVj(dataStructure_.getRegisters_().getReg(rs_));
			rsNode.setQj(0);
		}
		
		rsNode.setBusy(true);
		rsNode.setInstrucao(this);
		rsNode.setOp(instrucao_);
		
		int b;
		b = dataStructure_.getReorderBuffer_().getROBList().size();
		rsNode.setDest(b);
		
		robNode._instrucao = this;
		robNode.instruction = instrucao_;
		robNode.destination = rd_;
		robNode.busy = true;
		
		if(dataStructure_.getReorderBuffer_().getROBList().size() == 0)
			robNode.ID = 0;
		else
			robNode.ID = dataStructure_.getReorderBuffer_().getROBList().get(dataStructure_.getReorderBuffer_().getROBList().size()-1).ID++;
		
		if(dataStructure_.getRegisterStatus_().isBusy(rt_)){
			int h = dataStructure_.getRegisterStatus_().getReorder(rt_);
			if(!dataStructure_.getReorderBuffer_().getBusy(h)){
				rsNode.setVk(dataStructure_.getReorderBuffer_().getValue(h));
				rsNode.setQk(0);
			}else{
				rsNode.setQk(h);
			}
		}else{
			rsNode.setVk(dataStructure_.getRegisters_().getReg(rt_));
			rsNode.setQk(0);
		}
		
		dataStructure_.getRegisterStatus_().getReorder().set(rd_, b);
		dataStructure_.getRegisterStatus_().getBusy().set(rd_, true);
		
		robNode.state = "Issue";
		
		dataStructure_.getReorderBuffer_().getROBList().add(robNode);
		dataStructure_.getReservationStation().getMultList().add(rsNode);
		dataStructure_.sPointer++;
		return true;
	}
	@Override
	public boolean execute(int i) {
		if(dataStructure_.getReservationStation().getMultList().get(i).getQj() != 0 ||
				dataStructure_.getReservationStation().getMultList().get(i).getQk() != 0)return false;
		iniciou = true;
		if(time == 0){
			if(!terminou){
				dataStructure_.getReservationStation().getMultList().get(i).setVj(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVj()));
				dataStructure_.getReservationStation().getMultList().get(i).setVk(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVk()));
				terminou = true;
				return true;
			}else{
				return true;
			}
		}
		time--;
		return false;
	}
	
}
