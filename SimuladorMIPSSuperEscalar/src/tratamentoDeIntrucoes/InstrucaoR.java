package tratamentoDeIntrucoes;

abstract public class InstrucaoR  implements Instrucao{
	int nByte;
	int opCode = 0;
	int rs;
	int rt;
	int rd;
	int funct;
	String instrucao;
	public InstrucaoR(int r1, int r2, int r3) {
		rs = r1;
		rt = r2;
		rd = r3;
	}
	@Override
	public int getNbyte() {
		return nByte;
	}
	@Override
	public int getOpCode() {
		return opCode;
	}
	
}
