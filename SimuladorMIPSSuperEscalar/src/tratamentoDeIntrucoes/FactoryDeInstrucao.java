package tratamentoDeIntrucoes;

public final class FactoryDeInstrucao {
	
	public static Instrucao getInstrucao(String s){
		
		if(getOpCode(s).equals("000000")){
			switch (getFunct(s)){
				case "100000":
					return new InstrucaoROpAdd(getRs(s), getRt(s), getRd(s));
				case "011000":
					return new InstrucaoROpMul(getRs(s), getRt(s), getRd(s));
				case "000000":
					return new InstrucaoROpNop(getRs(s), getRt(s), getRd(s));
				case "100010":
					return new InstrucaoROpSub(getRs(s), getRt(s), getRd(s));					
			}
			if(s.substring(26, 31).equals("100000"))
				return new InstrucaoROpAdd(1,2,3);
		}else
			return new InstrucaoROpAdd(1,2,3);
		return new InstrucaoROpAdd(1,2,3);
	}
	
	private static String getFunct(String s) {
		return s.substring(26, 31);
	}
	private static String getOpCode(String s){
		return s.substring(0, 5);
	}
	private static int getRs(String s){
		return Integer.parseInt(s.substring(6,10),2);
	}
	private static int getRt(String s){
		return Integer.parseInt(s.substring(11,15),2);
	}
	private static int getRd(String s){
		return Integer.parseInt(s.substring(16,20),2);
	}
	
	
}
