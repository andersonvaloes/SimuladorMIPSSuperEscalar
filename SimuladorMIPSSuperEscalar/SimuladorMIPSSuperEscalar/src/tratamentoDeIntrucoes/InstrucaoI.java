package tratamentoDeIntrucoes;

abstract public class InstrucaoI implements Instrucao{
	int nByte;
	int opCode;
	int rs;
	int rt;
	int immediate;
	boolean ehEspeculativo = false;
	String instrucao;
	
	
	
	public InstrucaoI(int r1, int r2, int r3, int r4) {
		opCode = r1;
		rs = r2;
		rt = r3;
		immediate = r4;
	}
	
	@Override
	public int getNbyte() {
		return nByte;
	}
	@Override
	public int getOpCode() {
		return opCode;
	}
	@Override
	public boolean ehEspeculativo() {
		return ehEspeculativo;
	}
	@Override
	public void setEspeculativo() {
		ehEspeculativo = true;
	}
	@Override
	public void freeEspeculativo() {
		ehEspeculativo = false;
	}
}
