package tratamentoDeIntrucoes;

abstract public class IntrucaoI implements Instrucao{
	int nByte;
	int opCode = 1;
	String instrucao;
	
	@Override
	public int getNbyte() {
		return nByte;
	}
	@Override
	public int getOpCode() {
		return opCode;
	}
}
