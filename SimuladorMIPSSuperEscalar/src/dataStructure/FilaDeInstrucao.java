package dataStructure;

import java.util.ArrayList;

import intrucoes.Instrucao;

public class FilaDeInstrucao {
	ArrayList<Instrucao> fila_;
	DataStructure dataStructure_;
	
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
	}
	
	public void setNaFilaDeInstrucao(String arquivo, DataStructure dataStructure ) {
		fila_ = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada(arquivo, dataStructure);
	}
	
	public void issue(){
		if(dataStructure_.sPointer < fila_.size()){
			fila_.get(dataStructure_.sPointer).issue();
		}
	}
}
