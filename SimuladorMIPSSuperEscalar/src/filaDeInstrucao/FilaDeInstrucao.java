package filaDeInstrucao;

import java.util.ArrayList;

import intrucoes.Instrucao;

public class FilaDeInstrucao {
	ArrayList<Instrucao> fila;
	public FilaDeInstrucao(String arquivo) {
		fila = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada(arquivo);
	}
	
}
