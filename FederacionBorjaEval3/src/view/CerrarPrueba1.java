package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.EquipoDAO;
import dao.MetalDAO;
import dao.PatrocinadorDAO;
import dao.PruebaDAO;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entidades.Atleta;
import entidades.Bronce;
import entidades.Documentacion;
import entidades.Metal;
import entidades.Oro;
import entidades.Lugar;
import entidades.Metal;
import entidades.Patrocinador;
import entidades.Plata;
import entidades.Prueba;
import entidades.Resultado;
import utils.ConexBD;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class CerrarPrueba1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba1 frame = new CerrarPrueba1(idprueba);
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
	public CerrarPrueba1(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if (prueba != null) {
			setTitle("Cerrar Prueba" + idprueba);
		} else
			setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField("" + prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");

		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if (prueba.isIndividual())
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(10, 264, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(10, 384, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(10, 488, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] atletasStr = new String[atletassList.size()];
		for (int i = 0; i < atletassList.size(); i++)
			atletasStr[i] = atletassList.get(i).getPersona().data();

		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(140, 260, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(140, 380, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(140, 484, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JLabel lblOro = new JLabel("IdOro");
		lblOro.setBounds(26, 303, 46, 14);
		contentPane.add(lblOro);

		DefaultComboBoxModel<Metal> metalModel = new DefaultComboBoxModel<Metal>();
		JComboBox<Metal> comboBoxOro = new JComboBox<Metal>(metalModel);
		comboBoxOro.setBounds(140, 293, 114, 20);

		DefaultComboBoxModel<Metal> metalModels = new DefaultComboBoxModel<Metal>();
		JComboBox<Metal> comboBoxPlata = new JComboBox<Metal>(metalModel);
		comboBoxPlata.setBounds(140, 517, 101, 22);

		DefaultComboBoxModel<Metal> metalModeles = new DefaultComboBoxModel<Metal>();
		JComboBox<Metal> comboBoxBronce = new JComboBox<Metal>(metalModel);
		comboBoxBronce.setBounds(140, 413, 101, 22);

		MetalDAO metDAO = new MetalDAO(ConexBD.getCon());
		ArrayList<Metal> metalesList = (ArrayList<Metal>) metDAO.buscarTodos();
		ArrayList<Oro> orosList = new ArrayList<Oro>();
		ArrayList<Plata> platasList = new ArrayList<Plata>();
		ArrayList<Bronce> broncesList = new ArrayList<Bronce>();

		for (Metal eq : metalesList) {
			if (!eq.asignada && eq.getClass().equals(Oro.class)) {

				orosList.add((Oro) eq);

			}
		}

		String[] oroStr = new String[orosList.size()];
		for (int i = 0; i < orosList.size(); i++)
			oroStr[i + 1] = orosList.get(i).toString();

		comboBoxOro.setModel(new DefaultComboBoxModel(oroStr));
		contentPane.add(comboBoxOro);

		for (Metal eq : metalesList) {
			if (!eq.asignada && eq.getClass().equals(Plata.class)) {

				platasList.add((Plata) eq);

			}
		}
		String[] plataStr = new String[platasList.size()];

		for (int i = 0; i < platasList.size(); i++)
			plataStr[i + 1] = platasList.get(i).toString();
		comboBoxPlata.setModel(new DefaultComboBoxModel(plataStr));
		contentPane.add(comboBoxPlata);

		for (Metal eq : metalesList) {
			if (!eq.asignada && eq.getClass().equals(Bronce.class)) {

				broncesList.add((Bronce) eq);

			}
		}
		String[] bronceStr = new String[broncesList.size()];

		for (int i = 0; i < broncesList.size(); i++)
			bronceStr[i + 1] = broncesList.get(i).toString();
		comboBoxBronce.setModel(new DefaultComboBoxModel(bronceStr));
		contentPane.add(comboBoxBronce);

		JLabel lblPlata = new JLabel("IdPlata * :");
		lblPlata.setBounds(10, 421, 57, 14);
		contentPane.add(lblPlata);

		JLabel lblBronce = new JLabel("IdBronce *:");
		lblBronce.setBounds(26, 527, 46, 14);
		contentPane.add(lblBronce);

		JCheckBox chckbxDefinitivo = new JCheckBox("Establecer como definitivo");
		chckbxDefinitivo.setBounds(38, 591, 161, 23);
		contentPane.add(chckbxDefinitivo);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";

				Resultado result = new Resultado();

				long idOro = comboBoxOro.getSelectedIndex();
				float pureza = 0.0F;
				Oro o = new Oro(idOro, pureza);
				valido = Validaciones.validarId(idOro);
				if (!valido) {
					errores += "El Id del oro no es correcto.\n";
					lblOro.setForeground(Color.RED);
				} else
					result.setPrimero(o);
				valido = false;
				long idPlata = comboBoxPlata.getSelectedIndex();
				pureza = 0.0F;
				Plata p = new Plata(idPlata, pureza);
				valido = Validaciones.validarId(idPlata);
				if (!valido) {
					errores += "El Id del oro no es correcto.\n";
					lblPlata.setForeground(Color.RED);
				} else
					result.setSegundo(p);
				valido = false;
				long idBronce = comboBoxBronce.getSelectedIndex();
				pureza = 0.0F;
				Bronce c = new Bronce(idBronce, pureza);
				valido = Validaciones.validarId(idOro);
				if (!valido) {
					errores += "El Id del oro no es correcto.\n";
					lblBronce.setForeground(Color.RED);
				} else
					result.setTercero(c);
				valido = false;

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba " + prueba.getId() + " cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}
			}
		});
		buttonAceptar.setBounds(480, 591, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}
				

			}
		});
		buttonCancelar.setBounds(580, 591, 89, 23);
		contentPane.add(buttonCancelar);
		
		JLabel lblNewLabel = new JLabel("horas");
		lblNewLabel.setBounds(10, 328, 46, 14);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(77, 325, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_1.setBounds(77, 443, 30, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_3.setBounds(337, 443, 30, 20);
		contentPane.add(spinner_3);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(187, 446, 30, 20);
		contentPane.add(spinner_2);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_4.setBounds(77, 564, 30, 20);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_5.setBounds(187, 564, 30, 20);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_6.setBounds(337, 564, 30, 20);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_7.setBounds(198, 325, 30, 20);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_8.setBounds(337, 325, 30, 20);
		contentPane.add(spinner_8);
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(142, 328, 46, 14);
		contentPane.add(lblMinutos);
		
		JLabel lblSegundos = new JLabel("segundos");
		lblSegundos.setBounds(281, 328, 46, 14);
		contentPane.add(lblSegundos);
		
		JLabel lblNewLabel_3 = new JLabel("horas");
		lblNewLabel_3.setBounds(26, 446, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblMinutos_1 = new JLabel("minutos");
		lblMinutos_1.setBounds(131, 446, 46, 14);
		contentPane.add(lblMinutos_1);
		
		JLabel lblSegundos_1 = new JLabel("segundos");
		lblSegundos_1.setBounds(281, 446, 46, 14);
		contentPane.add(lblSegundos_1);
		
		JLabel lblNewLabel_6 = new JLabel("horas");
		lblNewLabel_6.setBounds(26, 570, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblMinutos_2 = new JLabel("minutos");
		lblMinutos_2.setBounds(140, 567, 46, 14);
		contentPane.add(lblMinutos_2);
		
		JLabel lblSegundos_2 = new JLabel("segundos");
		lblSegundos_2.setBounds(281, 567, 46, 14);
		contentPane.add(lblSegundos_2);

	}
}
