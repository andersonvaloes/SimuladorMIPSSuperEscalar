package intrucoes;

import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStationNode;

public class InstrucaoIOpSw extends InstrucaoI implements Instrucao {
	int time = 4;
	public InstrucaoIOpSw(int r1, int r2, int r3, int r4) {
		super(r1, r2, r3, r4);
	}
	@Override
	public boolean issue() {
		if(dataStructure_.getReservationStation().isFullLoad() || 
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
		dataStructure_.getReservationStation().getLoadList().add(rsNode);
		dataStructure_.sPointer++;
		return true;
	}
	@Override
	public boolean execute(int i) {
		if((dataStructure_.getReservationStation().getLoadList().get(i).getQj() != 0 ||
				dataStructure_.getReservationStation().getLoadList().get(i).getQk() != 0) &&
				dataStructure_.getReorderBuffer_().getROBList().get(0)._instrucao.equals(this))return false;
		iniciou = true;
		if(time == 0){
			if(!terminou){
				dataStructure_.getReorderBuffer_().getROBList().get(0).value = 
						dataStructure_.getReservationStation().getLoadList().get(i).getVj() +
						dataStructure_.getReservationStation().getLoadList().get(i).getA();
				//dataStructure_.getReservationStation().getAddList().get(i).setVj(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVj()));
				//dataStructure_.getReservationStation().getAddList().get(i).setVk(dataStructure_.getRegisters_().getReg(dataStructure_.getReservationStation().getAddList().get(i).getVk()));
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
			robnode.value = dataStructure_.getReservationStation().getAddList().get(i).getVk();
			robnode.busy = false;
			dataStructure_.getReservationStation().getLoadList().get(i).setBusy(false);
			dataStructure_.getReservationStation().getLoadList().remove(i);
			return true;
		}
		
		return false;
	}
	
	@Override
	public void commit(){
		int h = dataStructure_.getReorderBuffer_().getNodeID(0).ID;
		if (!dataStructure_.getReorderBuffer_().getBusy(h)){
			int d = dataStructure_.getReorderBuffer_().getDest(h);
			
			dataStructure_.getMemory_().setMem(dataStructure_.getReorderBuffer_().getDest(h),dataStructure_.getReorderBuffer_().getValue(h));
			
			dataStructure_.getReorderBuffer_().setBusy(h, false);
			if(dataStructure_.getRegisterStatus_().getReorder(d)==h)
			{
				dataStructure_.getRegisterStatus_().getBusy().set(d, false);
			}
		}
	}
}
