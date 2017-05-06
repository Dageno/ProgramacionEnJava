package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Ayuda miAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Menu de Ayuda");
		setBounds(100, 100, 319, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConcesionario = new JLabel("Concesionario:");
			lblConcesionario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblConcesionario.setBounds(10, 50, 108, 14);
			contentPanel.add(lblConcesionario);
		}
		{
			JLabel lblAltaDeCoche = new JLabel("Alta de coche -> May\u00FAs+A");
			lblAltaDeCoche.setBounds(65, 76, 207, 14);
			contentPanel.add(lblAltaDeCoche);
		}
		{
			JLabel label = new JLabel("Baja de coche -> May\u00FAs+B");
			label.setBounds(65, 101, 207, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Buscar coche -> May\u00FAs+F");
			label.setBounds(65, 126, 207, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Buscar coche por color -> may\u00FAs+R");
			label.setBounds(65, 151, 228, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Mostrar concesionario -> Alt+A");
			label.setBounds(65, 176, 228, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Ficheros:");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(10, 228, 108, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Ayuda con accesos directos");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(65, 11, 179, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Abrir concesionario -> Ctrl+A");
			label.setBounds(65, 278, 207, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Guardar concesionario -> Ctrl+G");
			label.setBounds(65, 303, 207, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Nuevo concesionario ->  Ctrl+N");
			label.setBounds(65, 253, 228, 14);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	 public  static Ayuda getSingleton() {
		 
		 if (miAyuda==null) {
		 
			 miAyuda=new Ayuda();
		 }
		 
		 return miAyuda;
	}

}
