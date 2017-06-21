package DataStructure;

import intrucoes.Instrucao;

public class ROBNode {
	
	public int ID;
	public boolean busy;
	public String instruction;
	public String state;
	public int destination;
	public int value;
	public Instrucao _instrucao;
	
	public void setInstrucao (Instrucao instrucao){
		_instrucao = instrucao;
	}
	
	 
}
