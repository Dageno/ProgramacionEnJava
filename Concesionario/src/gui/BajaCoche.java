package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import concesionarioFicheros.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaCoche extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String matriculaValida;
	protected Coche coche;
	private final JPanel contentPanel = new JPanel();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		BajaCoche dialog = new BajaCoche();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);

	}

	/**
	 * Create the dialog.
	 */
	public BajaCoche() {

		setTitle("Concesionario IES Gran Capitán ( Baja Coche )");

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			
		
		

		
		contentPanel.add(Matricula);
		

		contentPanel.add(lblMatricula);
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
		rdbtnAzul.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnPlata.setEnabled(false);
		
		/**
		 * JComboBox
		 */
		contentPanel.add(modelo);
		contentPanel.add(marca);
		marca.setSelectedItem(null);
		modelo.setSelectedItem(null);
		marca.setEnabled(false);
		modelo.setEnabled(false);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorMatricula();
				try {
					coche = concesionario.get(Matricula.getText());
				} catch (MatriculaNoValidaException | CocheNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		contentPanel.add(btnBuscar);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						if (coche != null) {
							try {
								if(marca.getSelectedItem() == null)
									buscarPorMatricula();
								concesionario.eliminar(coche.getMatricula());
								Gestion.setModificado(true);
								JOptionPane.showMessageDialog(contentPanel, "Coche eliminado con éxito.");
								limpiarCampos();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(contentPanel, "Error al eliminar el coche.", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
//						} else {
//							JOptionPane.showMessageDialog(contentPanel, "Debe buscar un coche primero para eliminar.",
//									"Error", JOptionPane.ERROR_MESSAGE);
//						}
					}
				});
				okButton.setActionCommand("Eliminar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				
				buttonPane.add(cancelButton);
			}
		}
	}

}
