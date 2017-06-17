package tratamentoDeIntrucoes;

public final class FactoryDeInstrucao {
	public static Instrucao getInstrucao(String s){
		if(s.substring(0, 5).equals("000000")){
			switch (s.substring(26, 31)){
				case "100000":
					return new InstrucaoROpAdd(1,2,3);
			}
			if(s.substring(26, 31).equals("100000"))
				return new InstrucaoROpAdd(1,2,3);
		}else
			return new InstrucaoROpAdd(1,2,3);
		return new InstrucaoROpAdd(1,2,3);
		
	}
}
