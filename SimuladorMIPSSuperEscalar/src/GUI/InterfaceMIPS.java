package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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

import javax.swing.Action;

public class InterfaceMIPS{

	private JFrame frame;
	private JTable tableEstReserva;
	private JLabel label;
	private JTable tableBuffer;
	private JLabel lblBuffer;
	private JTable tableRegs;
	private JLabel lblRegs;
	private JTable tableClock;
	private JTable table;
	
	public JTable getTableBuffer(){
		return tableBuffer;
	}
	
	public JTable getTableBuffer(){
		return tableBuffer;
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
		
		tableEstReserva = new JTable();
		tableEstReserva.setModel(new DefaultTableModel(
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
				{"ER11", null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Tipo", "Busy", "Instru", "Dest", "Vj", "Vk", "Qj", "Qk", "A"
			}
		));
		tableEstReserva.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableEstReserva.setBounds(10, 34, 582, 176);
		frame.getContentPane().add(tableEstReserva);
		tableEstReserva.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblEstReserva = new JLabel("Esta\u00E7\u00F5es de Reserva");
		lblEstReserva.setBackground(new Color(240, 240, 240));
		lblEstReserva.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstReserva.setBounds(10, 0, 582, 34);
		lblEstReserva.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(lblEstReserva);
		
		label = new JLabel("");
		label.setBounds(10, 221, 108, 25);
		frame.getContentPane().add(label);
		
		tableBuffer = new JTable();
		tableBuffer.setModel(new DefaultTableModel(
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
				"Entrada", "Ocupado", "Inst", "Estado", "Dest", "Valor"
			}
		));
		tableBuffer.setBounds(10, 253, 521, 176);
		tableBuffer.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(tableBuffer);
		
		lblBuffer = new JLabel("Buffer de Reordena\u00E7\u00E3o");
		lblBuffer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuffer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuffer.setBounds(10, 221, 521, 34);
		lblBuffer.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(lblBuffer);
		
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
		tableRegs.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableRegs.getColumnModel().getColumn(1).setPreferredWidth(28);
		tableRegs.getColumnModel().getColumn(2).setPreferredWidth(29);
		tableRegs.getColumnModel().getColumn(3).setPreferredWidth(22);
		tableRegs.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableRegs.getColumnModel().getColumn(5).setPreferredWidth(31);
		tableRegs.getColumnModel().getColumn(6).setPreferredWidth(25);
		tableRegs.getColumnModel().getColumn(7).setPreferredWidth(27);
		tableRegs.getColumnModel().getColumn(8).setPreferredWidth(28);
		tableRegs.getColumnModel().getColumn(9).setPreferredWidth(26);
		tableRegs.getColumnModel().getColumn(10).setPreferredWidth(28);
		tableRegs.getColumnModel().getColumn(11).setPreferredWidth(30);
		tableRegs.setBounds(551, 253, 333, 144);
		tableRegs.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(tableRegs);
		
		lblRegs = new JLabel("Registradores");
		lblRegs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegs.setBounds(551, 221, 333, 34);
		lblRegs.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(lblRegs);
		
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
		tableClock.getColumnModel().getColumn(0).setPreferredWidth(216);
		tableClock.getColumnModel().getColumn(1).setPreferredWidth(79);
		tableClock.setBounds(602, 146, 272, 65);
		tableClock.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(tableClock);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Endere\u00E7o", "Valor"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(216);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.setBounds(602, 49, 272, 82);
		frame.getContentPane().add(table);
		
		JButton btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/Actions-arrow-right-icon.png")));
		btnPlay.setBounds(602, 9, 22, 25);
		frame.getContentPane().add(btnPlay);
		
		JButton btnPlayFull = new JButton("");
		btnPlayFull.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/Actions-arrow-right-double-icon.png")));
		btnPlayFull.setBounds(630, 9, 22, 25);
		frame.getContentPane().add(btnPlayFull);
		
		JButton btnPaste = new JButton("");
		btnPaste.setIcon(new ImageIcon(InterfaceMIPS.class.getResource("/Resources/folder-icon.png")));
		btnPaste.setBounds(655, 9, 22, 25);
		btnPaste.addActionListener(new ClassListener());
		frame.getContentPane().add(btnPaste);
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

