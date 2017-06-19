package tratamentoDeIntrucoes;

public interface Instrucao {
	public int getOpCode();
	public int getNbyte();
	public boolean ehEspeculativo();
	public void setEspeculativo();
	public void freeEspeculativo();
}
