package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ViewPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrueba frame = new ViewPrueba();
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
	public ViewPrueba() {
		setTitle("Prueba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 4), "Nueva Prueba", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(262, 21, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(318, 18, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(10, 93, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(10, 21, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo");
		lblNewLabel_3.setBounds(10, 144, 46, 14);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Individual", "Colectiva"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(76, 141, 86, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Lugar");
		lblNewLabel_4.setBounds(262, 93, 46, 14);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Las Mestas, Gijon", "Centro ciudad, Gijon", "Parque San Francisco, Oviedo", "Centro ciudad, Oviedo", "Puerto, Aviles", "Pabellon deportivo Aviles, Aviles"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(318, 90, 86, 20);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Patrocinador");
		lblNewLabel_5.setBounds(238, 147, 80, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(10, 201, 80, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(315, 203, 89, 23);
		panel.add(btnNewButton_1);
	}
}
