package DataStructure;

public class Memoria {
	static int[] memoria = new int[2048];
	
	public int getMem(int i) {
		return memoria[i];
	}
	public void setMem(int i, int value){
		memoria[i] = value;
	}
	
	/*public static void main(String[] args) {
		memoria[2047] = 1;
		System.out.println(memoria[2046]);
	}*/
}
