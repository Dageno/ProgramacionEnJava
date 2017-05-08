package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import concesionarioFicheros.*;

public class AltaCoche extends VentanaPadre {

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
			AltaCoche dialog = new AltaCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param concesionario 
	 * @param concesionario 
	 */
	public AltaCoche() {
		setTitle("Concesionario IES Gran Capitán ( Alta Coche )");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			contentPanel.add(lblMatricula);
		}

		/**
		 * JText de matricula
		 */
		contentPanel.add(Matricula);
		Matricula.setColumns(10);
		
		/**
		 * Labels
		 */
		contentPanel.add(lblMarca);
		contentPanel.add(lblModelo);

		/**
		 * Reborde de colores 
		 */
		contentPanel.add(panel);
		panel.setLayout(null);

		/**
		 * Botones de radio de colores
		 */
		
		panel.add(rdbtnPlata);
		panel.add(rdbtnRojo);
		panel.add(rdbtnAzul);

		/**
		 * JCombobox
		 */
		
		contentPanel.add(modelo);
		contentPanel.add(marca);

		{
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							concesionario.annadir(Matricula.getText(), getColor(), (Modelo) modelo.getSelectedItem());
							Gestion.setModificado(true);
							limpiarCamposAlta();
							JOptionPane.showMessageDialog(contentPanel, "Coche añadido con éxito." );
							
						} catch (Exception e) {
							
							JOptionPane.showMessageDialog(contentPanel, "Error al añadir el coche.", 
									"Error", JOptionPane.ERROR_MESSAGE );
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						limpiarCampos();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	

	
}
