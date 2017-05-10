package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import concesionarioFicheros.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal = new JPanel();
	static Drop concesionario = Gestion.concesionario;
	protected ArrayList<Coche> colores = new ArrayList<Coche>();
	ListIterator<Coche> iteradorColores;
	
	protected JLabel lblMatricula = new JLabel("Matr\u00EDcula: ");
	protected JLabel lblModelo = new JLabel("Modelo: ");
	protected JLabel lblMarca = new JLabel("Marca: ");
	
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton rdbtnRojo = new JRadioButton("Rojo");
	protected JRadioButton rdbtnAzul = new JRadioButton("Azul");
	protected JRadioButton rdbtnPlata = new JRadioButton("Plata");
	protected JTextField Matricula = new JTextField();
	protected JPanel panel = new JPanel();
	
	protected JComboBox<Modelo> modelo = new JComboBox<Modelo>();
	protected JComboBox<Marca> marca = new JComboBox<Marca>();
	
	protected JPanel buttonPane = new JPanel();
	protected JButton btnBuscar = new JButton("Buscar");
	protected JButton okButton = new JButton("Aceptar");
	protected JButton cancelButton = new JButton("Salir");
	protected JButton adelante = new JButton(">");
	protected JButton atras = new JButton("<");
	


	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPadre dialog = new VentanaPadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		Matricula.setBounds(158, 52, 93, 20);
		
		
		
		
		/**
		 * Labels
		 */
		lblMatricula.setBounds(96, 55, 71, 14);
		lblMarca.setBounds(223, 114, 59, 14);
		lblModelo.setBounds(223, 174, 59, 14);
		
	
		/**
		 * Panel de reborde
		 */
		panel.setBorder(new TitledBorder(null, "Colores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(38, 99, 148, 114);
		panel.setLayout(null);
		
		
		/**
		 * Radio Buttons de colores
		 */
		rdbtnPlata.setBounds(49, 43, 78, 23);
		panel.add(rdbtnPlata);
		buttonGroup.add(rdbtnPlata);
		
		rdbtnAzul.setBounds(82, 69, 60, 23);
		panel.add(rdbtnAzul);
		buttonGroup.add(rdbtnAzul);
		
		rdbtnRojo.setBounds(6, 18, 92, 23);
		panel.add(rdbtnRojo);
		buttonGroup.add(rdbtnRojo);
		
		/**
		 * JCombobox 
		 */
		modelo.setBounds(292, 170, 114, 22);
		marca.setBounds(292, 110, 114, 22);
		marca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				modelo.setModel(new DefaultComboBoxModel<Modelo>(setModelos(marca)));
			}
		});
		
		marca.setModel(new DefaultComboBoxModel<Marca>(concesionarioFicheros.Marca.values()));
		modelo.setModel(new DefaultComboBoxModel<Modelo>(concesionarioFicheros.Modelo.getModelos(Marca.values()[0])));
		
		
		/**
		 * Botones de uso
		 */
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarPorMatricula();
			}
		});
		btnBuscar.setBounds(268, 51, 89, 23);
		atras.setBounds(300, 206, 61, 23);
		adelante.setBounds(371, 206, 61, 23);
		
		
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			
			
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
			
			
		
		
	}
	
	void seleccionarBoton(Coche coche) {
		switch(coche.getColor()){
		case PLATA:
			rdbtnPlata.setSelected(true);
			break;
		case AZUL:
			rdbtnAzul.setSelected(true);
			break;
		case ROJO:
			rdbtnRojo.setSelected(true);
			break;
		default:
			JOptionPane.showMessageDialog(panelPrincipal, "Debe elegir un color.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	protected Modelo[] setModelos(JComboBox<Marca> marca) {
		Marca tipo = (Marca) marca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		
		int i = 0; 
		for (Modelo m : concesionarioFicheros.Modelo.values()) {
			if (m.getMarca() == tipo) {
				modelos.add(m);
				
			}
		}
		
		Modelo[]modelos2 = new Modelo[modelos.size()];
		for(Modelo model : modelos){
			modelos2[i++] = model;
		}
		
		return modelos2;
	}
	
	protected Color getColor() throws ColorNoElegidoException {
		if(rdbtnAzul.isSelected())
			return Color.AZUL;
		else if(rdbtnRojo.isSelected())
			return Color.ROJO;
		else if(rdbtnPlata.isSelected())	
			return  Color.PLATA;
		throw new ColorNoElegidoException("Debe elegir un color");
	}
	
	protected void buscarPorMatricula() {
		String matriculaValida = Matricula.getText();
		actualizarCamposMatricula(matriculaValida);
		
	}
	
	protected void actualizarCamposMatricula(String matriculaValida) {
		Coche coche;
		try {
			coche = concesionario.get(matriculaValida);
			
			actualizarCamposSinMatricula(coche);
			
		
		} catch (MatriculaNoValidaException e1) {
			JOptionPane.showMessageDialog(panelPrincipal, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);

		} catch (CocheNoExisteException e1) {
			JOptionPane.showMessageDialog(panelPrincipal, e1.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	void actualizarCamposSinMatricula(Coche coche) {
		Matricula.setText(coche.getMatricula());
		
		marca.setSelectedItem(coche.getModelo().getMarca());
		
		modelo.setSelectedItem(coche.getModelo());
	
		seleccionarBoton(coche);
		
	}
	
	protected void actualizarCamposSinColor(Coche coche) {
		
		Matricula.setText(coche.getMatricula());
		
		marca.setSelectedItem(coche.getModelo().getMarca());
		
		modelo.setSelectedItem(coche.getModelo());
		
	}

	protected void actualizarBoton(JButton atras, JButton adelante) {
		if(!iteradorColores.hasPrevious()){
			iteradorColores.next();
			atras.setEnabled(false);
		}else{
			
			atras.setEnabled(true);
		}
		
		if(!iteradorColores.hasNext()){
			iteradorColores.previous();
			adelante.setEnabled(false);
		}else{
			
			adelante.setEnabled(true);
		}
	}
	protected void mostrarConcesionario(Coche coche) {
		Matricula.setText(coche.getMatricula());
	}
	
	protected ArrayList<Coche> buscarPorColor(Color color) {
		
		for (Coche coche : concesionario.almacen) {
			if ( coche.getColor()== color) {
				colores.add(coche);
				
			}
		}
		return colores;
		
	}
	
	protected void limpiarCampos() {
		Matricula.setText("");
		buttonGroup.clearSelection();
		marca.setSelectedItem(null);	
		modelo.setSelectedItem(null);
	}
	protected void limpiarCamposAlta() {
		Matricula.setText("");
		buttonGroup.clearSelection();

	}
	

}
