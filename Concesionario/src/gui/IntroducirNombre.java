package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import concesionarioFicheros.Gestion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class IntroducirNombre extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public IntroducirNombre() {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(100, 50, 382, 115);
		JLabel lblIntroduceElNombre = new JLabel("Introduce el nombre del archivo:");
		lblIntroduceElNombre.setBounds(78, 11, 187, 14);
		getContentPane().add(lblIntroduceElNombre);
		
		textField = new JTextField();
		textField.setBounds(88, 37, 132, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.archivo = new File(textField.getText());
				dispose();
			}
		});
		btnNewButton.setBounds(230, 36, 82, 23);
		getContentPane().add(btnNewButton);
	}

	
}
