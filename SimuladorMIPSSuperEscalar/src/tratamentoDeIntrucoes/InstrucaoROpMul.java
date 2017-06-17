package tratamentoDeIntrucoes;

public class InstrucaoROpMul extends InstrucaoR implements Instrucao{
	public InstrucaoROpMul(int r1, int r2, int r3) {
		super(r1, r2, r3);
		funct = 34;		
	}
}
