package tratamentoFilaDeInstrucao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import tratamentoDeIntrucoes.FactoryDeInstrucao;
import tratamentoDeIntrucoes.Instrucao;

public class SetDeEntradaDeInstrucoes {
	
	public static ArrayList<Instrucao> getSetIntrucaoDaEntrada(String s){
		String linha;
		//s = "/home/spider/git/SimuladorMIPSSuperEscalar/SimuladorMIPSSuperEscalar/src/tratamentoFilaDeInstrucao/entrada";
		ArrayList<Instrucao> list = new ArrayList<Instrucao>();
		try {
			FileReader arq = new FileReader(s);
			BufferedReader lerArq = new BufferedReader(arq);
			while( (linha = lerArq.readLine()) != null){
				//System.out.println(linha.split(";")[0]);
				list.add(FactoryDeInstrucao.getInstrucao(linha.split(";")[0]));
				//System.out.println(linha.split("; ")[1]);
				list.get(list.size()-1).setInstrucao(linha.split("; ")[1]);
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Problema encontrado", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
		return list;
	}
	/*public static void main(String[] args) {
		ArrayList<Instrucao> s = SetDeEntradaDeInstrucoes.getSetIntrucaoDaEntrada("");
	}*/
}
