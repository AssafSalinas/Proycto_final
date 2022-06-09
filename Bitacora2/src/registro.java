import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class registro {

	private JFrame frmBitacora;
	private JTextField txt_no;
	private JTextField txt_nom;
	private JTextField txt_entrada;
	private JTextField txt_salida;
	private JTextField txt_fecha;
	DataRegistro conexion = new DataRegistro();
	Variables var = new Variables();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro window = new registro();
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
	public registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBitacora = new JFrame();
		frmBitacora.getContentPane().setBackground(Color.PINK);
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
				conexion.consultarRegistro();
				txt_no.setText(Variables.ncon);
				txt_nom.setText(Variables.nom);
				txt_entrada.setText(Variables.hre);
				txt_salida.setText(Variables.hrs);
				txt_fecha.setText(Variables.fecha);
			}
		});
		btnConsultar.setBounds(29, 234, 100, 23);
		frmBitacora.getContentPane().add(btnConsultar);

		JLabel lblNewLabel = new JLabel("Numero de control : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 46, 124, 14);
		frmBitacora.getContentPane().add(lblNewLabel);

		txt_no = new JTextField();
		txt_no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txt_no.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txt_no.setBounds(142, 44, 86, 20);
		frmBitacora.getContentPane().add(txt_no);
		txt_no.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Variables.ncon = txt_no.getText();
				Variables.nom = txt_nom.getText();
				Variables.hrs = txt_salida.getText();
				Variables.hre = txt_entrada.getText();
				Variables.fecha = txt_fecha.getText();
				conexion.insertarRegistro();
				Limpiar();
			}
		});
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setBounds(139, 234, 89, 23);
		frmBitacora.getContentPane().add(btnRegistrar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(238, 234, 89, 23);
		frmBitacora.getContentPane().add(btnSalir);

		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 87, 61, 14);
		frmBitacora.getContentPane().add(lblNewLabel_1);

		txt_nom = new JTextField();
		txt_nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txt_nom.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txt_nom.setColumns(10);
		txt_nom.setBounds(87, 85, 86, 20);
		frmBitacora.getContentPane().add(txt_nom);

		JLabel txt = new JLabel("Hora de entrada :");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt.setBounds(24, 127, 105, 14);
		frmBitacora.getContentPane().add(txt);

		txt_entrada = new JTextField();
		txt_entrada.setColumns(10);
		txt_entrada.setBounds(127, 125, 86, 20);
		frmBitacora.getContentPane().add(txt_entrada);

		JLabel lblNewLabel_2_1 = new JLabel("Hora de salida:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(24, 158, 89, 14);
		frmBitacora.getContentPane().add(lblNewLabel_2_1);

		txt_salida = new JTextField();
		txt_salida.setColumns(10);
		txt_salida.setBounds(127, 156, 86, 20);
		frmBitacora.getContentPane().add(txt_salida);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(34, 189, 61, 14);
		frmBitacora.getContentPane().add(lblFecha);

		txt_fecha = new JTextField();
		txt_fecha.setColumns(10);
		txt_fecha.setBounds(87, 187, 86, 20);
		frmBitacora.getContentPane().add(txt_fecha);

		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.eliminarRegistro();
			}
		});
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(29, 268, 89, 23);
		frmBitacora.getContentPane().add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Variables.ncon = txt_no.getText();
				Variables.nom = txt_nom.getText();
				Variables.hrs = txt_salida.getText();
				Variables.hre = txt_entrada.getText();
				Variables.fecha = txt_fecha.getText();
				conexion.modificarRegistro();
			}
		});
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(128, 268, 100, 23);
		frmBitacora.getContentPane().add(btnModificar);
	}

	public void Limpiar() {
		txt_no.setText("");
		txt_nom.setText("");
		txt_entrada.setText("");
		txt_salida.setText("");
		txt_fecha.setText("");
	}
}
