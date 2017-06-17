package tratamentoDeIntrucoes;

public class InstrucaoROpMUL extends InstrucaoR implements Instrucao{
	public InstrucaoROpMUL(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct = 24;		
	}
}
