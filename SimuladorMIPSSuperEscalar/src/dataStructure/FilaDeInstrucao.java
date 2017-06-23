package dataStructure;

import java.util.ArrayList;

import intrucoes.Instrucao;

public class FilaDeInstrucao {
	ArrayList<Instrucao> fila_;
	DataStructure dataStructure_;
	int head_ = 0;
	
	public void setDataStructure(DataStructure dataStructure) {
		this.dataStructure_ = dataStructure;
	}
	
	public void setNaFilaDeInstrucao(String arquivo, DataStructure dataStructure ) {
		fila_ = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada(arquivo, dataStructure);
	}
	
	public void issue(){
		if(head_ < fila_.size()){
			if(fila_.get(head_).issue()) head_++;
		}
	}
	public void setHead(int nByte){
		head_ = nByte/4;
	}

}
