package tratamentoDeIntrucoes;

public interface Instrucao {
	public int getOpCode();
	public int getNbyte();
	public String getInstrucao();
	
	public void setNbyte(int i);
	public void setInstrucao(String s);
	public void setEspeculativo();
	
	public void freeEspeculativo();
	public boolean ehEspeculativo();
	
}
