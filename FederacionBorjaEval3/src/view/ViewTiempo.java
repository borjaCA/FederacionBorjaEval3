package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ViewTiempo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTiempo frame = new ViewTiempo();
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
	public ViewTiempo() {
		setTitle("Tiempo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 4), "Nuevo Tiempo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Horas");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 255), 3));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(10, 11, 75, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Minutos");
		lblNewLabel_1.setBorder(new LineBorder(Color.BLUE, 3));
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(10, 64, 75, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundos");
		lblNewLabel_2.setBorder(new LineBorder(Color.BLUE, 3));
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(10, 117, 75, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Centesimas");
		lblNewLabel_3.setBorder(new LineBorder(Color.BLUE, 3));
		lblNewLabel_3.setBackground(Color.PINK);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(10, 174, 75, 23);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(315, 205, 89, 23);
		panel.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(Color.RED);
		spinner.setBorder(new LineBorder(Color.YELLOW, 3));
		spinner.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner.setBounds(95, 11, 102, 23);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBorder(new LineBorder(Color.YELLOW, 3));
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(95, 65, 102, 22);
		panel.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBorder(new LineBorder(Color.YELLOW, 3));
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(95, 118, 102, 23);
		panel.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBorder(new LineBorder(Color.YELLOW, 3));
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner_3.setBounds(95, 175, 102, 22);
		panel.add(spinner_3);
	}
}
