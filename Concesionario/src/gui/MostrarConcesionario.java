package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioFicheros.Coche;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarConcesionario extends BuscarCoche {

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
			MostrarConcesionario dialog = new MostrarConcesionario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param concesionario 
	 */
	public MostrarConcesionario() {
		
		setTitle("Mostrar Concesionario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMostrandoElConcesionario = new JLabel("Mostrando el concesionario actual");
		lblMostrandoElConcesionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMostrandoElConcesionario.setBounds(103, 11, 242, 29);
		contentPanel.add(lblMostrandoElConcesionario);
		
		
		
		
		
		if(concesionario.isEmpty()){
			
			
			JLabel lblElConcesionarioEst = new JLabel("El concesionario est\u00E1 vac\u00EDo");
			lblElConcesionarioEst.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblElConcesionarioEst.setBounds(134, 89, 207, 14);
			contentPanel.add(lblElConcesionarioEst);
			
			JLabel lblDeberDarDe = new JLabel("Deber\u00E1 dar de alta alg\u00FAn coche.");
			lblDeberDarDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblDeberDarDe.setBounds(121, 131, 220, 14);
			contentPanel.add(lblDeberDarDe);
			

		
			
		
		
		}else{
			Coche coche = concesionario.get(0);
			iteradorColores = VentanaPadre.concesionario.almacen.listIterator();
			
			actualizarBoton(atras, adelante);
			/**
			 * Labels
			 */
			contentPanel.add(lblMatricula);
			contentPanel.add(lblModelo);
			contentPanel.add(lblMarca);
			
			
			/**
			 * JText Matricula
			 */
			Matricula.setText(coche.getMatricula());
			Matricula.setEditable(false);
			contentPanel.add(Matricula);
			
			/**
			 * JComboBox 
			 */
			
			marca.setSelectedItem(coche.getModelo().getMarca().name());
			marca.setEnabled(false);
			contentPanel.add(marca);
	
			modelo.setSelectedItem(coche.getModelo().name());
			modelo.setEnabled(false);
			contentPanel.add(modelo);
			
			/**
			 * Panel de colores 
			 */
			contentPanel.add(panel);
			panel.setLayout(null);
			
			rdbtnRojo.setEnabled(false);
			panel.add(rdbtnRojo);
			
			rdbtnAzul.setEnabled(false);
			panel.add(rdbtnAzul);
			
			rdbtnPlata.setEnabled(false);
			panel.add(rdbtnPlata);
			
			seleccionarBoton(coche);
			
			
			
			
			adelante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						
						mostrarConcesionario(iteradorColores.next());
						buscarPorMatricula();
						actualizarBoton(atras, adelante);
					
					
				}
			});
				
			contentPanel.add(adelante);
			
			
				
			atras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						mostrarConcesionario(iteradorColores.previous());
						buscarPorMatricula();
						actualizarBoton(atras, adelante);
						
						
					}

				


			});
			contentPanel.add(atras);
				
			
			
			
			
			
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	

}
