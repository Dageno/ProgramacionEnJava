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
import java.io.File;
import java.io.FileNotFoundException;
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
	JFileChooser fileChooser = new JFileChooser();
	protected static FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(9, 9));
		if(Gestion.getFile() != null)
			frame.setTitle(Gestion.getFile().getName());
		else
			frame.setTitle("Sin título");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		AltaCoche alta = new AltaCoche();
		BajaCoche baja = new BajaCoche();
		
		
		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo Concesionario");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Gestion.nuevo(VentanaPadre.concesionario);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
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
							"El fichero no contiene ningún concesionario.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con éxito.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con éxito.");
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
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
				if(concesionarioNoVacio()){
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
				if(concesionarioNoVacio()){
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
				if(concesionarioNoVacio()){
					MostrarConcesionario mostrar = new MostrarConcesionario();
					mostrar.setModal(true);
					mostrar.setVisible(true);
				}
			}
		});
		
		JMenuItem mntmBuscarPorColor = new JMenuItem("Buscar Por Color");
		mntmBuscarPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionarioNoVacio()){
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
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerAyuda = new JMenuItem("Ver Ayuda");
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = Ayuda.getSingleton();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca del Concesionario");
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
	private boolean concesionarioNoVacio(){
		if(!VentanaPadre.concesionario.isEmpty())
			return true;
		else
			JOptionPane.showMessageDialog(frame, "El concesionario esta vacío", 
					"Error", JOptionPane.ERROR_MESSAGE );
		return false;
	}
	
	private File leerArchivo() {
		
		fileChooser.setFileFilter(filtro);
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal != JFileChooser.CANCEL_OPTION) {
			return fileChooser.getSelectedFile();
			
		}else{
			
			return null;
		}	
	}
}


