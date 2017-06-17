package tratamentoDeIntrucoes;

abstract public class InstrucaoJ implements Instrucao{
	int nByte;
	int opCode;
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
