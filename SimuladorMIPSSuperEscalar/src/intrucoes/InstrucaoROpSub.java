package intrucoes;

import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStationNode;

public class InstrucaoROpSub extends InstrucaoR implements Instrucao{
	int time = 1;
	public InstrucaoROpSub(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct_ = 24;		
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
		dataStructure_.getReservationStation().getAddList().add(rsNode);
		dataStructure_.sPointer++;
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
			robnode.value = dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVj()) -
					dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVk());
			robnode.busy = false;
			int b = dataStructure_.getReservationStation().getAddList().get(i).getDest();
			dataStructure_.getReservationStation().getAddList().get(i).setBusy(false);
		
			for(ReservationStationNode r : dataStructure_.getReservationStation().getAddList()){
				if(r.getQj() == b) {
					r.setVj(robnode.value);
					r.setQj(0);
				}
				
				if(r.getQk() == b){
					r.setVk(robnode.value);
					r.setQk(0);
				}
			}
			
			for(ReservationStationNode r : dataStructure_.getReservationStation().getMultList()){
				if(r.getQj() == b) {
					r.setVj(robnode.value);
					r.setQj(0);
				}
				
				if(r.getQk() == b){
					r.setVk(robnode.value);
					r.setQk(0);
				}
			}
		
			for(ReservationStationNode r : dataStructure_.getReservationStation().getLoadList()){
				if(r.getQj() == b) {
					r.setVj(robnode.value);
					r.setQj(0);
				}
				
				if(r.getQk() == b){
					r.setVk(robnode.value);
					r.setQk(0);
				}
			}
			dataStructure_.getReservationStation().getAddList().remove(i);
			return true;
		}
		
		return false;
	}
	
	@Override
	public void commit(){
		int h = dataStructure_.getReorderBuffer_().getNodeID(0).ID;
		if (!dataStructure_.getReorderBuffer_().getBusy(h)){
			int d = dataStructure_.getReorderBuffer_().getDest(h);
			
			dataStructure_.getRegisters_().setReg(d, dataStructure_.getReorderBuffer_().getValue(h));
			
			dataStructure_.getReorderBuffer_().setBusy(h, false);
			if(dataStructure_.getRegisterStatus_().getReorder(d)==h)
			{
				dataStructure_.getRegisterStatus_().getBusy().set(d, false);
			}
		}
	}
	
}
