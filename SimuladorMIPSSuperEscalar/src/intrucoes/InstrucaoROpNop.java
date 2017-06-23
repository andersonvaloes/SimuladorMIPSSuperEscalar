package intrucoes;


public class InstrucaoROpNop extends InstrucaoR implements Instrucao{
	int time = 1;
	public InstrucaoROpNop(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct_ = 0;		
	}
}
