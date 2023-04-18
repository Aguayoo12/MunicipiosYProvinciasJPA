package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MunicipioController;
import controller.ProvinciaController;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;
	private JTextField jtfFiltrar;
	private JTextField jtfNombreMunicipio;
	private JComboBox<Municipio> jcbMunicipio;
	private JComboBox<Provincia> jcbProvincia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
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
	public PrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jtfFiltrar = new JTextField();
		jtfFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfFiltrar = new GridBagConstraints();
		gbc_jtfFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltrar.weightx = 1.0;
		gbc_jtfFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltrar.gridx = 0;
		gbc_jtfFiltrar.gridy = 0;
		contentPane.add(jtfFiltrar, gbc_jtfFiltrar);
		jtfFiltrar.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcbMunicipio.removeAllItems();
				llenarMunicipios();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		jcbMunicipio = new JComboBox<Municipio>();
		jcbMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		contentPane.add(jcbMunicipio, gbc_jcbMunicipio);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMunicipio();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Municipio Seleccionado: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(196, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_panel.columnWeights = new double[]{1.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombreMunicipio = new JTextField();
		jtfNombreMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfNombreMunicipio = new GridBagConstraints();
		gbc_jtfNombreMunicipio.weightx = 1.0;
		gbc_jtfNombreMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombreMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombreMunicipio.gridx = 1;
		gbc_jtfNombreMunicipio.gridy = 0;
		panel.add(jtfNombreMunicipio, gbc_jtfNombreMunicipio);
		jtfNombreMunicipio.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Provincia del municipio: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbProvincia = new JComboBox<Provincia>();
		jcbProvincia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(196, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		
		llenarProvincias();
		
	}
	
	private void llenarMunicipios() {
		for (Municipio m : MunicipioController.findByName(jtfFiltrar.getText())) {
			jcbMunicipio.addItem(m);
		}
	}
	
	private void seleccionarMunicipio() {
		Municipio m = (Municipio)jcbMunicipio.getSelectedItem();
		jtfNombreMunicipio.setText(m.getNombre());
		jcbProvincia.setSelectedItem(m.getProvincia());
	}
	
	private void llenarProvincias() {
		for (Provincia p : ProvinciaController.findAll()) {
			jcbProvincia.addItem(p);
		}
	}
	
	private void save() {
		Municipio m = (Municipio)jcbMunicipio.getSelectedItem();
		Provincia p = (Provincia) jcbProvincia.getSelectedItem();
		MunicipioController.update(m, jtfNombreMunicipio.getText(), p);
	}
}
