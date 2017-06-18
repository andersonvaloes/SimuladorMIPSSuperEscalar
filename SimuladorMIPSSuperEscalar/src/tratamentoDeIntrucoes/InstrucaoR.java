package tratamentoDeIntrucoes;

abstract public class InstrucaoR  implements Instrucao{
	int nByte;
	int opCode = 0;
	int rs;
	int rt;
	int rd;
	int funct;
	boolean ehEspeculativo = false;
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
