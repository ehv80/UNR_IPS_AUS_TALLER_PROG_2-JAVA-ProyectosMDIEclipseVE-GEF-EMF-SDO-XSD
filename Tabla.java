package mdi;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabla extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private String separador = ";"; 
	private JDesktopPane panel;
	/**
	 * This is the default constructor
	 */
	public Tabla(JDesktopPane p) {
		super();
		panel = p;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	
	private void centra () {
		Dimension j = panel.getSize();
		this.setLocation((j.width-this.getWidth())/2,
				(j.height-this.getHeight())/2);

	}
	private void initialize() {
		this.setSize(485, 292);
		centra();
		this.setClosable(true);
		this.setMaximizable(true);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Tabla");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(7,22,65,24));
			jLabel.setText("Archivo:");
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}
	
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new java.awt.Rectangle(106,225,79,24));
			jButton.setText("Aceptar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileInputStream f;
					try {
						f = new FileInputStream(jTextField.getText());
						InputStreamReader i = new InputStreamReader(f);
						BufferedReader b = new BufferedReader(i);
						Vector datosFilas= new Vector(), nombreColumnas= new Vector(), temp;
						nombreColumnas.addAll(new CopyOnWriteArrayList(b.readLine().split(separador)));
						String linea;
						while((linea=b.readLine())!=null) {
							temp = new Vector(new CopyOnWriteArrayList(linea.split(separador)));
							datosFilas.addElement(temp);
						}
						jTable = new JTable(datosFilas, nombreColumnas);
						jTable.getTableHeader().setReorderingAllowed(false);
						jTable.getTableHeader().setResizingAllowed(false);
						jScrollPane.setViewportView(jTable);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Archivo No Existente");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"No se puede leer del archivo");
					}
					
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(290,225,79,24));
			jButton1.setText("Salir");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new java.awt.Rectangle(377,22,79,24));
			jButton2.setText("Buscar");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser j = new JFileChooser();
					int returnVal = j.showOpenDialog(null);
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					       jTextField.setText(j.getSelectedFile().toString());
					    }

				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new java.awt.Rectangle(84,22,282,24));
		}
		return jTextField;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(51,63,362,142));
			jScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
