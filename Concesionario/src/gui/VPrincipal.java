package gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionarioFicheros.Gestion;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

public class VPrincipal {

	JFrame frame;
	public static JFileChooser fileChooser;
	/**
	 * Bloque est�tico para iniciar el filechooser
	 */
	static {
		fileChooser = new JFileChooser();
		FileNameExtensionFilter extension = new FileNameExtensionFilter("Concesionario de coches", "obj");
		fileChooser.setFileFilter(extension);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal window = new VPrincipal();
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
	public VPrincipal() {
		initialize();
		// eventoCerrado();
	}

	// private void eventoCerrado() {
	// addWindowListener(new WindowAdapter() {
	// public void windowClosing(WindowEvent e) {
	// if (Gestion.getModificado()) {
	// if (JOptionPane.showConfirmDialog(null, "Has hecho cambios... �quieres
	// guardar antes de salir?",
	// "Festival modificado", JOptionPane.YES_NO_OPTION) ==
	// JOptionPane.YES_OPTION) {
	// if (Gestion.getFile() == null)
	// try {
	// Gestion.guardarComo(Gestion.ficheroNuevo(), VentanaPadre.concesionario);
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// else
	// try {
	// Gestion.guardar(VentanaPadre.concesionario);
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// }
	// }
	// }
	// });
	//
	//
	//
	// }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(9, 9));
		if (Gestion.getFile() != null)
			frame.setTitle(Gestion.getFile().getName());
		else
			frame.setTitle("Sin t�tulo");
		frame.setBounds(100, 100, 450, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (Gestion.getModificado()) {
					if (Gestion.deseaGuardar("Se han hecho modificaciones, Desea guardar los cambios ? (y/n)")) {
						if (Gestion.getFile() == null)
							try {
								Gestion.guardarComo(Gestion.ficheroNuevo(), VentanaPadre.concesionario);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(frame, "Se ha producido un error al guardar el archivo.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						else
							try {
								Gestion.guardar(VentanaPadre.concesionario);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(frame, "Se ha producido un error al guardar el archivo.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
					}
				}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);

		AltaCoche alta = new AltaCoche();
		BajaCoche baja = new BajaCoche();

		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo Concesionario");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Gestion.nuevo(leerArchivo(), VentanaPadre.concesionario);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevoConcesionario);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir Concesionario...");
		mntmAbrirConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File archivo = leerArchivo();
					VentanaPadre.concesionario = Gestion.abrir(archivo, VentanaPadre.concesionario);
					frame.setTitle(archivo.getName());

				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"El fichero no contiene ning�n concesionario.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmAbrirConcesionario);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.guardar(VentanaPadre.concesionario);
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con �xito.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File archivo = leerArchivo();
					Gestion.guardarComo(archivo, VentanaPadre.concesionario);
					frame.setTitle(archivo.getName());
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con �xito.");
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnCoche = new JMenu("Coche\r\n");
		mnCoche.setMnemonic('c');
		menuBar.add(mnCoche);

		JMenuItem mntmAltaCoche = new JMenuItem("Alta Coche");
		mntmAltaCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alta.setModal(true);
				alta.setVisible(true);
			}
		});
		mntmAltaCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK));
		mnCoche.add(mntmAltaCoche);

		JMenuItem mntmBajaCoche = new JMenuItem("Baja Coche");
		mntmBajaCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (concesionarioNoVacio()) {
					baja.setModal(true);
					baja.setVisible(true);
				}
			}
		});
		mntmBajaCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.SHIFT_MASK));
		mnCoche.add(mntmBajaCoche);

		JMenuItem mntmBuscarCoche = new JMenuItem("Buscar Coche");
		mntmBuscarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionarioNoVacio()) {
					BuscarCoche buscar = new BuscarCoche();
					buscar.setModal(true);
					buscar.setVisible(true);
				}
			}
		});
		mntmBuscarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.SHIFT_MASK));
		mnCoche.add(mntmBuscarCoche);

		JSeparator separator_2 = new JSeparator();
		mnCoche.add(separator_2);

		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					MostrarConcesionario mostrar = new MostrarConcesionario();
					mostrar.setModal(true);
					mostrar.setVisible(true);
				
			}
		});

		JMenuItem mntmBuscarPorColor = new JMenuItem("Buscar Por Color");
		mntmBuscarPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionarioNoVacio()) {
					BuscarColor buscar = new BuscarColor();
					buscar.setModal(true);
					buscar.setVisible(true);
				}

			}
		});
		mntmBuscarPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnCoche.add(mntmBuscarPorColor);
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnCoche.add(mntmMostrarConcesionario);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);

		JMenuItem mntmVerAyuda = new JMenuItem("Ver Ayuda");
		mntmVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = Ayuda.getSingleton();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca del Concesionario");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setModal(true);
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenido al Concesionario de IES Gran Capit\u00E1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel.setBounds(57, 76, 335, 76);
		frame.getContentPane().add(lblNewLabel);

	}

	private boolean concesionarioNoVacio() {
		if (!VentanaPadre.concesionario.isEmpty())
			return true;
		else
			JOptionPane.showMessageDialog(frame, "El concesionario esta vac�o", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	public static File leerArchivo() {

		
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal != JFileChooser.CANCEL_OPTION) {
			return fileChooser.getSelectedFile();

		} else {

			return null;
		}
	}

}
