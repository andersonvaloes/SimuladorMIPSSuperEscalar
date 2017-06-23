package intrucoes;


public class InstrucaoROpAdd extends InstrucaoR implements Instrucao{	
	int time = 1;
	public InstrucaoROpAdd(int rs, int rt, int rd) {
		super(rs, rt, rd);
		funct_ = 32;
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
}
