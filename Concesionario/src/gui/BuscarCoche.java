package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuscarCoche extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarCoche dialog = new BuscarCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarCoche() {
		setTitle("Concesionario IES Gran Capit\u00E1n (Buscar Coche)");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		

		/**
		 * Labels
		 */
		contentPanel.add(lblMatricula);
		contentPanel.add(lblModelo);
		contentPanel.add(lblMarca);
		
		
		/**
		 * JText Matricula
		 */
		Matricula.setEditable(true);
		contentPanel.add(Matricula);
		
		/**
		 * JComboBox 
		 */
		
		marca.setSelectedItem(null);
		marca.setEnabled(false);
		contentPanel.add(marca);

		modelo.setSelectedItem(null);
		modelo.setEnabled(false);
		contentPanel.add(modelo);
		
		/**
		 * Panel de colores 
		 */
		contentPanel.add(panel);
		contentPanel.setLayout(null);
		
		
		
		rdbtnRojo.setEnabled(false);
		panel.add(rdbtnRojo);
		
		rdbtnAzul.setEnabled(false);
		panel.add(rdbtnAzul);
		
		rdbtnPlata.setEnabled(false);
		panel.add(rdbtnPlata);
		
		/**
		 * Botones 
		 */
		contentPanel.add(btnBuscar);
		contentPanel.add(cancelButton);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.add(cancelButton);
	}
}
