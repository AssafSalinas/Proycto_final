import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Bitacora_sala {

	private JFrame frmBitacora;
	private JTextField no_Field;
	private JTextField nom_Field;
	private JTextField entrada_Field;
	private JTextField salida_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bitacora_sala window = new Bitacora_sala();
					window.frmBitacora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bitacora_sala() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBitacora = new JFrame();
		frmBitacora.setTitle("Bitacora");
		frmBitacora.setBounds(100, 100, 431, 354);
		frmBitacora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBitacora.getContentPane().setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnConsultar.setBackground(new Color(255, 255, 255));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola may");
			}
		});
		btnConsultar.setBounds(29, 234, 100, 23);
		frmBitacora.getContentPane().add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("Numero de control : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 46, 124, 14);
		frmBitacora.getContentPane().add(lblNewLabel);
		
		no_Field = new JTextField();
		no_Field.setBounds(142, 44, 86, 20);
		frmBitacora.getContentPane().add(no_Field);
		no_Field.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setBounds(173, 234, 89, 23);
		frmBitacora.getContentPane().add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(299, 234, 89, 23);
		frmBitacora.getContentPane().add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 87, 61, 14);
		frmBitacora.getContentPane().add(lblNewLabel_1);
		
		nom_Field = new JTextField();
		nom_Field.setColumns(10);
		nom_Field.setBounds(87, 85, 86, 20);
		frmBitacora.getContentPane().add(nom_Field);
		
		JLabel lblNewLabel_2 = new JLabel("Hora de entrada :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(24, 127, 105, 14);
		frmBitacora.getContentPane().add(lblNewLabel_2);
		
		entrada_Field = new JTextField();
		entrada_Field.setColumns(10);
		entrada_Field.setBounds(127, 125, 86, 20);
		frmBitacora.getContentPane().add(entrada_Field);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hora de salida:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(24, 158, 89, 14);
		frmBitacora.getContentPane().add(lblNewLabel_2_1);
		
		salida_Field = new JTextField();
		salida_Field.setColumns(10);
		salida_Field.setBounds(127, 156, 86, 20);
		frmBitacora.getContentPane().add(salida_Field);
	}
}
