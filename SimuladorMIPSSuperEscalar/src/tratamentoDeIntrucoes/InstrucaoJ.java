package tratamentoDeIntrucoes;

abstract public class InstrucaoJ implements Instrucao{
	int nByte;
	int opCode = 2;
	int target;
	boolean ehEspeculativo = false;
	String instrucao;
	
	public InstrucaoJ(int t) {
		target = t;
	}
	
	@Override
	public int getNbyte() {
		return nByte;
	}
	@Override
	public void setNbyte(int i) {
		nByte = i;
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
	@Override
	public String getInstrucao() {
		return instrucao;
	}
	@Override
	public void setInstrucao(String s) {
		instrucao = s;
	}
}
