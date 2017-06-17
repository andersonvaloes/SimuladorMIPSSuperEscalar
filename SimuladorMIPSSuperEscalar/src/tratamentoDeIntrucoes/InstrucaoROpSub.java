package tratamentoDeIntrucoes;

public class InstrucaoROpSub extends InstrucaoR implements Instrucao{
	public InstrucaoROpSub(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct = 24;		
	}
}
