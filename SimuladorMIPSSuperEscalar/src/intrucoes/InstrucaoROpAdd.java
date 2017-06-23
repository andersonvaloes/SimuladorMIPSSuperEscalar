package intrucoes;


public class InstrucaoROpAdd extends InstrucaoR implements Instrucao{	
	public InstrucaoROpAdd(int rs, int rt, int rd) {
		super(rs, rt, rd);
		funct_ = 32;
	}
}
