package tratamentoFilaDeInstrucao;

import java.util.ArrayList;
import tratamentoDeIntrucoes.Instrucao;

public class FilaDeInstrucao {
	ArrayList<Instrucao> fila;
	public FilaDeInstrucao(String arquivo) {
		fila = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada(arquivo);
	}
	
}
