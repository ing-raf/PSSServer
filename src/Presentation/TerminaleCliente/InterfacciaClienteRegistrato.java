package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Label;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfacciaClienteRegistrato {

	private JFrame frmMenuCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaClienteRegistrato window = new InterfacciaClienteRegistrato();
					window.frmMenuCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacciaClienteRegistrato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuCliente = new JFrame();
		frmMenuCliente.setTitle("Menu cliente");
		frmMenuCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaClienteRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/ic_launcher.png")));
		frmMenuCliente.setBounds(100, 100, 450, 300);
		frmMenuCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmMenuCliente.getContentPane().setLayout(gridBagLayout);
		
		JButton btnSostituzioneBatteria = new JButton("Sostituzione batteria");
		GridBagConstraints gbc_btnSostituzioneBatteria = new GridBagConstraints();
		gbc_btnSostituzioneBatteria.insets = new Insets(0, 0, 5, 0);
		gbc_btnSostituzioneBatteria.gridx = 2;
		gbc_btnSostituzioneBatteria.gridy = 1;
		frmMenuCliente.getContentPane().add(btnSostituzioneBatteria, gbc_btnSostituzioneBatteria);
		
		JButton btnPrimaInstallazione = new JButton("Prima installazione");
		btnPrimaInstallazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnPrimaInstallazione = new GridBagConstraints();
		gbc_btnPrimaInstallazione.gridx = 2;
		gbc_btnPrimaInstallazione.gridy = 3;
		frmMenuCliente.getContentPane().add(btnPrimaInstallazione, gbc_btnPrimaInstallazione);
	}
	
	public void notifyValidazione() {
		// TODO - implement InterfacciaClienteRegistrato.notifyValidazione
	}

}
