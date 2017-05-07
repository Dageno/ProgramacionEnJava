package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioFicheros.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BuscarColor extends VentanaPadre {

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
			BuscarColor dialog = new BuscarColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarColor() {
		setTitle("Concesionario IES Gran Capitán (Buscar por Color)");
		setBounds(100, 100, 461, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		/**
		 * Labels
		 */
		contentPanel.add(lblMatricula);
		contentPanel.add(lblModelo);
		contentPanel.add(lblMarca);
		
		
		/**
		 * JText Matricula
		 */
		Matricula.setEditable(false);
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
		JComboBox<Color> comboBox = new JComboBox<Color>();
		comboBox.setModel(new DefaultComboBoxModel<Color>(concesionarioFicheros.Color.values()));
		comboBox.setBounds(84, 167, 104, 20);
		contentPanel.add(comboBox);
		
		JLabel lblColores = new JLabel("Colores:");
		lblColores.setBounds(30, 170, 60, 14);
		contentPanel.add(lblColores);
		
			
		/**
		 * Botones de uso
		 */
		atras.setEnabled(false);
		adelante.setEnabled(false);
		
		
		contentPanel.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				colores.clear();
				cogerColor();
				try{
					actualizarCamposSinColor(colores.get(0));
					actualizarBoton(atras, adelante);
				}catch(IndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "No se han encontrado coches con este color", "Coches no encontrados",
							JOptionPane.ERROR_MESSAGE);
				}
						
				
			}

			private void cogerColor() {
				if (comboBox.getSelectedItem() == Color.AZUL)
					iteradorColores = buscarPorColor(Color.AZUL).listIterator();
				else if (comboBox.getSelectedItem() == Color.PLATA)
					iteradorColores = buscarPorColor(Color.PLATA).listIterator();
				else
					iteradorColores = buscarPorColor(Color.ROJO).listIterator();
				
				
			}

		});
			
		
		
		adelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarCamposSinMatricula(iteradorColores.next());
				actualizarBoton(atras, adelante);
			}
		});
		contentPanel.add(adelante);
		
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarCamposSinMatricula(iteradorColores.previous());
				actualizarBoton(atras, adelante);
			}

		});
		contentPanel.add(atras);
		
		
	

		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colores.clear();
				dispose();
			}
		});
		buttonPane.add(cancelButton);
		
		
		
	}

	
}
