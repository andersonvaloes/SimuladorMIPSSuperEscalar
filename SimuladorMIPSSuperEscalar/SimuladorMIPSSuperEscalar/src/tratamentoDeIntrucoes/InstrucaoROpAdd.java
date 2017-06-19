package tratamentoDeIntrucoes;

public class InstrucaoROpAdd extends InstrucaoR implements Instrucao{	
	public InstrucaoROpAdd(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct = 32;
	}
	
}
