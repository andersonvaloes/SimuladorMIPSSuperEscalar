package DataStructure;

public class Registradores {
	int[] reg = new int[32];
	public Registradores(){
		reg[1] = 0;
	}
	public int getReg(int i) {
		return reg[i];
	}
	public void setReg(int i, int value){
		reg[i] = value;
	}
}
