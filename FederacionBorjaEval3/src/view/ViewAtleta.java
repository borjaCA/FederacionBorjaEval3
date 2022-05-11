package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.EquipoDAO;
import entidades.Atleta;
import entidades.Equipo;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.SystemColor;

public class ViewAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDNIONIF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldTelefono;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAtleta frame = new ViewAtleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAtleta() {
		setAlwaysOnTop(true);

		setTitle("Nuevo Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 588);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 712, 527);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre *:");
		lblNombre.setBounds(10, 27, 80, 28);
		panel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(88, 31, 285, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Documentacion * :");
		lblNewLabel.setBounds(10, 87, 115, 28);
		panel.add(lblNewLabel);

		JRadioButton rdbtnDNI = new JRadioButton("DNI");
		buttonGroup.add(rdbtnDNI);
		rdbtnDNI.setBounds(118, 122, 56, 20);
		panel.add(rdbtnDNI);

		JRadioButton rdbtnNIF = new JRadioButton("NIF");
		buttonGroup.add(rdbtnNIF);
		rdbtnNIF.setBounds(182, 120, 109, 23);
		panel.add(rdbtnNIF);

		JLabel lblValorDNI = new JLabel("Introduzca el valor");
		lblValorDNI.setBounds(10, 175, 115, 20);
		panel.add(lblValorDNI);

		textFieldDNIONIF = new JTextField();
		textFieldDNIONIF.setBounds(149, 175, 224, 20);
		panel.add(textFieldDNIONIF);
		textFieldDNIONIF.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(10, 240, 91, 28);
		panel.add(lblNewLabel_1);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(137, 244, 183, 28);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("FechaNAC");
		lblNewLabel_2.setBounds(439, 244, 91, 21);
		panel.add(lblNewLabel_2);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setModel(new SpinnerDateModel(new Date(1652220000000L), new Date(1652220000000L),
				new Date(32514904800000L), Calendar.DAY_OF_YEAR));
		spinnerFecha.setBounds(524, 244, 115, 24);
		panel.add(spinnerFecha);

		JLabel lblNewLabel_3 = new JLabel("Datos  Físicos");
		lblNewLabel_3.setBounds(10, 320, 136, 20);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Altura *:");
		lblNewLabel_4.setBounds(38, 365, 46, 14);
		panel.add(lblNewLabel_4);

		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(135, 362, 86, 20);
		panel.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Peso *:");
		lblNewLabel_5.setBounds(38, 415, 46, 14);
		panel.add(lblNewLabel_5);

		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(135, 412, 86, 20);
		panel.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(38, 469, 46, 14);
		panel.add(lblEquipo);

		DefaultComboBoxModel<Equipo> equiposModel = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBoxEquipos = new JComboBox<Equipo>(equiposModel);
		comboBoxEquipos.setBounds(131, 465, 230, 28);
		EquipoDAO eqpDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equiposList = (ArrayList<Equipo>) eqpDAO.buscarTodos();
		for (Equipo eq : equiposList)
			comboBoxEquipos.addItem(eq);
		;

		String[] equiposStr = new String[equiposList.size()];
		for (int i = 0; i < equiposList.size(); i++)
			equiposStr[i] = equiposList.get(i).toString();
		comboBoxEquipos.setModel(new DefaultComboBoxModel(equiposStr));

		panel.add(comboBoxEquipos);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				Atleta nuevo = new Atleta();
				boolean valido = false;

				String titulo = "";
				String msj = "";
				String errores = "";
				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {

					errores += "El nombre de l equipo  no es válido (3-50 caracteres).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nuevo.getPersona().setNombre(nombre);
				valido = false;

				String dni = textFieldDNIONIF.getText();
				valido = (Validaciones.validarNIE(dni)) || (Validaciones.validarNIF(dni));
				if (!valido) {
					errores += "El dni o nif no es valido ";
				} else
					nuevo.getPersona().getNifnie().mostrar();
				valido = false;

				String telefono = textFieldTelefono.getText();
				valido = Validaciones.validarTelefono(telefono);

				if (!valido) {
					errores += "el telefono no es el adecuado ";
				} else
					nuevo.getPersona().setTelefono(telefono);

				valido = false;
				float peso = 0.0F;
				try {
					peso = Float.valueOf(textFieldPeso.getText());
				} catch (NumberFormatException n) {
					n.getMessage();
				}
				float altura = 0.0F;

				try {
					altura = Float.valueOf(textFieldAltura.getText());
				} catch (NumberFormatException n) {
					n.getMessage();
				}

				valido = false;
				valido = (comboBoxEquipos.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Equipo del nuevo atleta.\n";
					lblEquipo.setForeground(Color.RED);
				} else {
					EquipoDAO eqpDAO = new EquipoDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxEquipos.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idEq = Long.valueOf(aux[0]);
					Equipo equipo = eqpDAO.buscarPorID(idEq);
					ConexBD.cerrarConexion();
					if (equipo == null)
						valido = false;
					else
						// nuevo.setEquipo(equipo); nose porque da error

						valido = errores.isEmpty();

					if (!valido) {
						titulo = "ERROR: Campos inválidos";
						msj = "ERROR: los siguientes campos de Nuevo Equipo NO son válidos:\n\n";
						if (!errores.isEmpty())
							msj += errores + "\n";
						JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
						return;
					}

					AtletaDAO atletadao = new AtletaDAO(ConexBD.establecerConexion());
					long idatletanuevo = atletadao.insertarSinID(nuevo);

					if (idatletanuevo <= 0) {

						titulo = "ERROR al insertar el Nuevo Atleta en la BD";
						msj = "Hubo un error y NO se ha insertado el nuevo atleta prueba en la BD.";
						JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					} else {
						nuevo.setId(idatletanuevo);
						titulo = "Nuevo Atleta insertada en la BD";
						msj = "Se ha insertado correctamente el nuevo atleta:\n" + nuevo.toString();
						JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});
		btnAceptar.setBounds(485, 493, 89, 23);
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(601, 493, 89, 23);
		panel.add(btnCancelar);

		JLabel lblNewLabel_7 = new JLabel("m. en formato (xx.xx)");
		lblNewLabel_7.setBounds(255, 365, 118, 20);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("kg. en formato (xx.xx)");
		lblNewLabel_8.setBounds(255, 415, 118, 14);
		panel.add(lblNewLabel_8);

	}
}
