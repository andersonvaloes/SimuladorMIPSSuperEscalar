package intrucoes;


public class InstrucaoROpMul extends InstrucaoR implements Instrucao{
	int time = 3;
	public InstrucaoROpMul(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct_ = 34;		
	}
	
}
