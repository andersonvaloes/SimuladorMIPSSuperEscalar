package DataStructure;

import intrucoes.Instrucao;

public class RSNode {
	
	Instrucao _instrucao;
	boolean _busy;
	String _op;
	int _Vj,_Vk;
	String _Qj,_Qk;
	int _dest;
	int _A;
	
	public void setDest(int dest){
		_dest=dest;
	}
	
	public void setInstrucao(Instrucao instrucao){
		_instrucao=instrucao;
	}
	
	public void setBusy(boolean busy){
		_busy=busy;
	}
	
	public void setOp(String op){
		_op=op;
	}
	
	public void setVj(int Vj){
		_Vj=Vj;
	}
	
	public void setVk(int Vk){
		_Vk=Vk;
	}
	
	public void setQj(String Qj){
		_Qj=Qj;
	}
	
	public void setQk(String Qk){
		_Qk=Qk;
	}
	
	public void setA(int A){
		_A=A;
	}
	
	public Instrucao getInstrucao(){
		return _instrucao;
	}
	
	public boolean getBusy(){
		return _busy;
	}
	
	public String getOp(){
		return _op;
	}
	
	public int getVj(){
		return _Vj;
	}
	
	public int getDest(){
		return _dest;
	}
	
	public int getVk(){
		return _Vk;
	}
	
	public String getQk(){
		return _Qk;
	}
	
	public String getQj(){
		return _Qj;
	}
	
	public int getA(){
		return _A;
	}
	
	public void execute(){
		_instrucao.execute();
	}
	
	public void write(){
		_instrucao.write();
	}
	
}
