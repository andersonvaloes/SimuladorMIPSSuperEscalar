package debbug;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import tratamentoDeIntrucoes.FactoryDeInstrucao;
import tratamentoDeIntrucoes.Instrucao;


public class TestantoInstrucao {
	@Test
	public void testandoSeEhPossivelCriarOArrayComOFactory(){
		ArrayList<Instrucao> ins = new ArrayList<Instrucao>();
		ins.add(FactoryDeInstrucao.getInstrucao("00000000101000010011100000011000"));	
		assertEquals(ins.get(0).getOpCode(),0);
		ins.add(FactoryDeInstrucao.getInstrucao("00000000010001100001000000100000"));
		assertEquals(ins.get(1).getOpCode(),0);

	}
	
}
