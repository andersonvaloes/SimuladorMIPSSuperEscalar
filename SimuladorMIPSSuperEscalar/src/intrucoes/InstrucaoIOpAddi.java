package intrucoes;

public class InstrucaoIOpAddi extends InstrucaoI implements Instrucao {
	public InstrucaoIOpAddi(int r1, int r2, int r3, int r4) {
		super(r1, r2, r3, r4);
	}	
	/*@Override
	public boolean issue() {
		if(dataStructure.getReservationStation().isFullAdd() || 
				dataStructure.getReorderBuffer_().isFull()) return false;
		//Verificar se o registrador rs esta ocupado
		if(dataStructure.getRegisterStatus_().isFree(ID))
		return false;
	}*/
}
