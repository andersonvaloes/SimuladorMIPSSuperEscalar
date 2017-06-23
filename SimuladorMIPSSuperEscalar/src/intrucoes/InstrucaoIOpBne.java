package intrucoes;

import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStationNode;

public class InstrucaoIOpBne extends InstrucaoI implements Instrucao {
	int time = 1;
	public InstrucaoIOpBne(int r1, int r2, int r3, int r4) {
		super(r1, r2, r3, r4);
	}
	@Override
	public boolean issue() {
		if(dataStructure_.getReservationStation().isFullAdd() || 
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
		//robNode.destination = rt_;
		robNode.busy = true;
		
		if(dataStructure_.getReorderBuffer_().getROBList().size() == 0)
			robNode.ID = 0;
		else
			robNode.ID = dataStructure_.getReorderBuffer_().getROBList().get(dataStructure_.getReorderBuffer_().getROBList().size()-1).ID++;
		
		rsNode.setVk(dataStructure_.getRegisters_().getReg(rt_));
		rsNode.setQk(0);
		
		rsNode.setA(immediate_);
		
		//dataStructure_.getRegisterStatus_().getReorder().set(rt_, b);
		//dataStructure_.getRegisterStatus_().getBusy().set(rt_, true);
		
		robNode.state = "Issue";
		
		dataStructure_.getReorderBuffer_().getROBList().add(robNode);
		dataStructure_.getReservationStation().getAddList().add(rsNode);
		if(dataStructure_.pred <= dataStructure_.predType/2)
			dataStructure_.sPointer++;
		else
			dataStructure_.sPointer = dataStructure_.sPointer + immediate_/4;
		return true;
	}
	
	@Override
	public boolean execute(int i) {
		if(dataStructure_.getReservationStation().getAddList().get(i).getQj() != 0 ||
				dataStructure_.getReservationStation().getAddList().get(i).getQk() != 0)return false;
		iniciou = true;
		if(time == 0){
			if(!terminou){
				dataStructure_.getReservationStation().getAddList().get(i).setVj(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVj()));
				dataStructure_.getReservationStation().getAddList().get(i).setVk(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVk()));
				terminou = true;
				return true;
			}else{
				return true;
			}
		}
		time--;
		return false;
	}
	
	@Override
	public boolean write(int i) {
		if(terminou){
			ReorderBufferNode robnode = null;
			for(ReorderBufferNode r : dataStructure_.getReorderBuffer_().getROBList()){
				if(r._instrucao.equals(this))
					robnode = r;
			}
			if(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVj()) !=
					dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVk()))
					robnode.value = immediate_;
			else
				robnode.value = 1 + nByte_/4;
			robnode.busy = false;
			int b = dataStructure_.getReservationStation().getAddList().get(i).getDest();
			dataStructure_.getReservationStation().getAddList().get(i).setBusy(false);
			dataStructure_.getReservationStation().getAddList().remove(i);
			return true;
		}
		return false;
	}

}
