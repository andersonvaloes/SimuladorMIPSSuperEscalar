package DataStructure;

import intrucoes.Instrucao;

public class RSNode {
	
	Instrucao _instrucao;
	boolean busy;
	String op;
	int Vj,Vk;
	String Qj,Qk;
	int A;
	
	public void execute(){
		_instrucao.execute();
	}
	
	public void write(){
		_instrucao.write();
	}
	
}
