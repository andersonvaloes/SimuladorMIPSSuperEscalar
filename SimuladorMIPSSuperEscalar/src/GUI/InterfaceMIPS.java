package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataStructure.Memory;
import dataStructure.RegisterStatus;
import dataStructure.Registers;
import dataStructure.ReorderBuffer;
import dataStructure.ReorderBufferNode;
import dataStructure.ReservationStation;
import dataStructure.ReservationStationNode;
import processador.ProcessadorMips;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InterfaceMIPS{

	private JFrame frame;
	private JLabel label;

	private ArrayList<ReorderBufferNode> _robList = new ArrayList<ReorderBufferNode>();
	private Memory _memoria = new Memory();
	private ArrayList<ReservationStationNode> _rsLoadList = new ArrayList<ReservationStationNode>();
	private ArrayList<ReservationStationNode> _rsAddList = new ArrayList<ReservationStationNode>();
	private ArrayList<ReservationStationNode> _rsMultList = new ArrayList<ReservationStationNode>();
	private Registers _regs = new Registers();
	private RegisterStatus _regsStatus = new RegisterStatus();
	
	ProcessadorMips p;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTable table;
	private JTable tableRS;
	private JLabel lblROB;
	private JTable tableROB;
	private JLabel lblNewLabel_1;
	private JTable tableRegs;
	private JTable tableClock;
	private JButton btnPlayFull;
	private JButton btnPaste;
	private JButton btnPrediNaoSalta;
	private JButton btnPred1Bit;
	private JButton btnPred2Bits;
	
	public void setTableROB(ArrayList<ReorderBufferNode> robList){
		_robList=robList;
		
		for(int i = 0 ; i<10 && _robList.size()>i;i++){
			System.out.println("Rob list: " + _robList.get(i).ID);
			int j = i+1;
			System.out.println("Rob list: " + _robList.get(i).instruction + " linha : " + j); 
			tableROB.setValueAt(_robList.get(i).ID, j, 0);
			tableROB.setValueAt(_robList.get(i).busy, j, 1);
			tableROB.setValueAt(_robList.get(i).instruction, j, 2);
			tableROB.setValueAt(_robList.get(i).state, j, 3);
			tableROB.setValueAt(_robList.get(i).destination, j, 4);
			tableROB.setValueAt(_robList.get(i).value, j, 5);
		}
		
	}
	
	
	public void setTableRegs(RegisterStatus regsStatus){
		_regsStatus = regsStatus;
		int j = 0;
		for(int k = 1 ; k<11 ; k=k+3){
			for(int i = 1;i<9 ;i++){
				tableRegs.setValueAt(_regsStatus.getBusy().get(j).toString(), i, k);
				tableRegs.setValueAt(_regsStatus.getReorder().get(j).toString(), i, k+1);
				j++;
			}
		}
	}
	
	public void setTableClock(int sPointer, int clock){
		tableClock.setValueAt(sPointer, 1, 1);
		tableClock.setValueAt(clock, 0, 1);
		
	}

	
	public void setTableRS(ArrayList<ReservationStationNode> rsLoadList,ArrayList<ReservationStationNode> rsAddList,ArrayList<ReservationStationNode> rsMultList){
		_rsLoadList = rsLoadList;
		_rsAddList=rsAddList;
		_rsMultList=rsMultList;
		for(int i = 0;i<5 && _rsLoadList.size()>i;i++){
			int j = i+1;
			System.out.println("RS list: " + _rsLoadList.get(i).getInstrucao());
			tableRS.setValueAt(_rsLoadList.get(i).getBusy(), j, 2);
			tableRS.setValueAt(_rsLoadList.get(i).getInstrucao().getInstrucao(), j, 3);
			tableRS.setValueAt(_rsLoadList.get(i).getDest(), j, 4);
			tableRS.setValueAt(_rsLoadList.get(i).getVj(), j, 5);
			tableRS.setValueAt(_rsLoadList.get(i).getVk(), j, 6);
			tableRS.setValueAt(_rsLoadList.get(i).getQj(), j, 7);
			tableRS.setValueAt(_rsLoadList.get(i).getQk(), j, 8);
			tableRS.setValueAt(_rsLoadList.get(i).getA(), j, 9);
		}
		for(int i = 0;i<3 && _rsAddList.size()>i;i++){
			int j = i+6;
			tableRS.setValueAt(_rsAddList.get(i).getBusy(), j, 2);
			tableRS.setValueAt(_rsAddList.get(i).getInstrucao().getInstrucao(), j, 3);
			tableRS.setValueAt(_rsAddList.get(i).getDest(), j, 4);
			tableRS.setValueAt(_rsAddList.get(i).getVj(), j, 5);
			tableRS.setValueAt(_rsAddList.get(i).getVk(), j, 6);
			tableRS.setValueAt(_rsAddList.get(i).getQj(), j, 7);
			tableRS.setValueAt(_rsAddList.get(i).getQk(), j, 8);
			tableRS.setValueAt(_rsAddList.get(i).getA(), j, 9);
		}
		
		for(int i = 0;i<2 && _rsMultList.size()>i;i++){
			int j = i+9;
			tableRS.setValueAt(_rsMultList.get(i).getBusy(), j, 2);
			tableRS.setValueAt(_rsMultList.get(i).getInstrucao().getInstrucao(), j, 3);
			tableRS.setValueAt(_rsMultList.get(i).getDest(), j, 4);
			tableRS.setValueAt(_rsMultList.get(i).getVj(), j, 5);
			tableRS.setValueAt(_rsMultList.get(i).getVk(), j, 6);
			tableRS.setValueAt(_rsMultList.get(i).getQj(), j, 7);
			tableRS.setValueAt(_rsMultList.get(i).getQk(), j, 8);
			tableRS.setValueAt(_rsMultList.get(i).getA(), j, 9);
		}
		
	}
	
	public void setTableMemoria(Memory memoria){
		_memoria=memoria;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMIPS window = new InterfaceMIPS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public InterfaceMIPS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 221, 108, 25);
		frame.getContentPane().add(label);
		
		panel = new JPanel();
		panel.setBounds(0, -26, 884, 440);
		frame.getContentPane().add(panel);
		
		JLabel lblRS = new JLabel("Esta\u00E7\u00E3o de Reserva");
		lblRS.setHorizontalAlignment(SwingConstants.CENTER);
		lblRS.setBorder(BorderFactory.createLineBorder(Color.black));
		
		tableRS = new JTable();
		tableRS.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Tipo", "Busy", "Instru\u00E7\u00E3o", "Dest.", "Vj", "Vk", "Qj", "Qk", "A"},
				{"ER1", "Load/Store", null, null, null, null, null, null, null, null},
				{"ER2", "Load/Store", null, null, null, null, null, null, null, null},
				{"ER3", "Load/Store", null, null, null, null, null, null, null, null},
				{"ER4", "Load/Store", null, null, null, null, null, null, null, null},
				{"ER5", "Load/Store", null, null, null, null, null, null, null, null},
				{"ER6", "Add", null, null, null, null, null, null, null, null},
				{"ER7", "Add", null, null, null, null, null, null, null, null},
				{"ER8", "Add", null, null, null, null, null, null, null, null},
				{"ER9", "Mult", null, null, null, null, null, null, null, null},
				{"ER10", "Mult", null, null, null, null, null, null, null, null},
			},
			new String[] {
					"ID", "Tipo", "Busy", "Instru", "Dest", "Vj", "Vk", "Qj", "Qk", "A"
			}
		));
		tableRS.setEnabled(false);
		tableRS.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblROB = new JLabel("Buffer de reordena\u00E7\u00E3o");
		lblROB.setHorizontalAlignment(SwingConstants.CENTER);
		lblROB.setBorder(BorderFactory.createLineBorder(Color.black));
		
		tableROB = new JTable();
		tableROB.setModel(new DefaultTableModel(
			new Object[][] {
				{"Entrada ", "Ocupado", "Instru\u00E7\u00E3o", "Estado", "Destino", "Valor"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tableROB.setEnabled(false);
		tableROB.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblNewLabel_1 = new JLabel("Registradores");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		tableRegs = new JTable();
		tableRegs.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Ql", "Vl", null, "Ql", "Ql", null, "Ql", "Vl", null, "Ql", "Vl"},
				{"R0", null, null, "R8", null, null, "R16", null, null, "R24", null, null},
				{"R1", "", null, "R9", null, null, "R17", null, null, "R25", null, null},
				{"R2", null, "", "R10", "", "", "R18", "", "", "R26", "", null},
				{"R3", null, null, "R11", null, null, "R19", null, null, "R27", null, ""},
				{"R4", null, null, "R12", null, null, "R20", null, null, "R28", null, null},
				{"R5", null, null, "R13", null, null, "R21", null, null, "R29", null, null},
				{"R6", null, null, "R14", null, null, "R22", null, null, "R30", null, null},
				{"R7", null, null, "R15", null, null, "R23", null, null, "R31", null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tableRegs.setEnabled(false);
		tableRegs.setBorder(BorderFactory.createLineBorder(Color.black));
		
		tableClock = new JTable();
		tableClock.setModel(new DefaultTableModel(
			new Object[][] {
				{"Clock Corrente:", null},
				{"PC:", null},
				{"N\u00FAmero de instru\u00E7\u00F5es conclu\u00EDdas:", null},
				{"Clock por instru\u00E7\u00F5es (CPI):", null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tableClock.setEnabled(false);
		tableClock.setBorder(BorderFactory.createLineBorder(Color.black));
		tableClock.getColumnModel().getColumn(0).setPreferredWidth(216);
		tableClock.getColumnModel().getColumn(1).setPreferredWidth(79);
		tableClock.setBounds(602, 146, 272, 65);
		
		JButton btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/Actions-arrow-right-icon.png")));
		btnPlay.setBounds(602, 9, 22, 25);
		btnPlay.addActionListener(new ClassListenerPlay(this));
		
		btnPlayFull = new JButton("");
		btnPlayFull.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/Actions-arrow-right-double-icon.png")));
		btnPlayFull.setBounds(630, 9, 22, 25);
		btnPlayFull.addActionListener(new ClassListenerPlayFull());
		
		btnPaste = new JButton("");
		btnPaste.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/folder-icon.png")));
		btnPaste.setBounds(655, 9, 22, 25);
		btnPaste.addActionListener(new ClassListener());
		
		btnPrediNaoSalta = new JButton("Preditor n\u00E3o salta");
		
		btnPred1Bit = new JButton("Preditor de 1 bit");
		
		btnPred2Bits = new JButton("Preditor de 2 bits");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRS, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
								.addComponent(tableRS, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tableClock, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(41)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnPlay)
											.addGap(18)
											.addComponent(btnPlayFull)
											.addGap(18)
											.addComponent(btnPaste))
										.addComponent(btnPrediNaoSalta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
										.addComponent(btnPred1Bit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
										.addComponent(btnPred2Bits, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
									.addGap(51))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblROB, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
								.addComponent(tableROB, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tableRegs, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRS, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tableRS, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPlay)
								.addComponent(btnPlayFull)
								.addComponent(btnPaste))
							.addGap(18)
							.addComponent(btnPrediNaoSalta, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPred1Bit, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPred2Bits, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tableClock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblROB, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tableROB, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addComponent(tableRegs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}
	
public class ClassListenerPlay implements ActionListener {
		public InterfaceMIPS _GUI;
		
		ClassListenerPlay(InterfaceMIPS GUI){
			_GUI = GUI;
		}
	
	
	    public void actionPerformed(ActionEvent e) {
	    	
	    	p.RunClock(_GUI);
	    	
	    }   
	}
	
	public class ClassListenerPlayFull implements ActionListener {
		
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    }   
	}
	
	public class ClassListener implements ActionListener {
		
	    public void actionPerformed(ActionEvent e) {
	    	JFileChooser fileChooser = new JFileChooser();
	    	int returnVal = fileChooser.showOpenDialog((Component)e.getSource());
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            try {
	              String filePath = file.getAbsolutePath();
	              System.out.println("Caminho do arquivo: " + filePath);
	              p = new ProcessadorMips(filePath);
	            } catch (Exception ex) {
	              System.out.println("problem accessing file"+file.getAbsolutePath());
	            }
	        } 
	        else {
	            System.out.println("File access cancelled by user.");
	        }       
	    }   
	}
}

