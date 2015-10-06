package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class InterfacciaClienteRegistrato {

	private static String Host;
	private JFrame frmMenuCliente;

	/**
	 * Launch the application.
	 */
	public static void clientScreen(String host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaClienteRegistrato window = new InterfacciaClienteRegistrato();
					InterfacciaClienteRegistrato.setHost(host);
					window.frmMenuCliente.setLocationRelativeTo(null);
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
		SpringLayout springLayout = new SpringLayout();
		frmMenuCliente.getContentPane().setLayout(springLayout);
		
		JLabel lblSelezionereUnoperazione = new JLabel("Selezionare un'operazione:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSelezionereUnoperazione, 22, SpringLayout.NORTH, frmMenuCliente.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSelezionereUnoperazione, -105, SpringLayout.EAST, frmMenuCliente.getContentPane());
		lblSelezionereUnoperazione.setForeground(Color.GREEN);
		lblSelezionereUnoperazione.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
		frmMenuCliente.getContentPane().add(lblSelezionereUnoperazione);
		
		JButton btnNewButton = new JButton("Sostituzione");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmMenuCliente.dispose();
				FinestraSostituzione.sostScreen(InterfacciaClienteRegistrato.getHost());
				
			
			}
		});
		frmMenuCliente.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prima installazione");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, frmMenuCliente.getContentPane());
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(btnNewButton_1, "Operazione non disponibile!", "Attenzione!", JOptionPane.WARNING_MESSAGE);
			
			}
		});
		frmMenuCliente.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Credito residuo");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(btnNewButton_1, "Operazione non disponibile!", "Attenzione!", JOptionPane.WARNING_MESSAGE);
			
			}
		});
		frmMenuCliente.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Esci");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton_3);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 282, SpringLayout.WEST, frmMenuCliente.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -115, SpringLayout.WEST, btnNewButton_3);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -47, SpringLayout.EAST, frmMenuCliente.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton_1);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmMenuCliente.setVisible(false);
				try {
					InterfacciaBadgeCliente.ejectBadge();
				} catch (Exception e) {
					e.printStackTrace();
				}
				frmMenuCliente.dispose();
				JOptionPane.showMessageDialog(null, "Espulsione badge!", "Esci", JOptionPane.INFORMATION_MESSAGE);
				InterfacciaClienteNonRegistrato.idleScreen();
			}
		});
		frmMenuCliente.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 18, SpringLayout.SOUTH, lblSelezionereUnoperazione);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 82, SpringLayout.WEST, frmMenuCliente.getContentPane());
		lblNewLabel.setIcon(new ImageIcon(InterfacciaClienteRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/battery.png")));
		frmMenuCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -77, SpringLayout.EAST, frmMenuCliente.getContentPane());
		lblNewLabel_1.setIcon(new ImageIcon(InterfacciaClienteRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/badge.png")));
		frmMenuCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InterfacciaClienteRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/first.png")));
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -18, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		frmMenuCliente.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_3.setIcon(new ImageIcon(InterfacciaClienteRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/exit.png")));
		frmMenuCliente.getContentPane().add(lblNewLabel_3);
	}
	
	public void notifyValidazione(String host) throws Exception {
		ClienteRegistratoClientRMI cr = new ClienteRegistratoClientRMI(1,host);
		if(cr.verifyValidationOutcome() == true){
			InterfacciaClienteRegistrato.clientScreen(host);
		}
		else{
			JOptionPane.showMessageDialog(null, "Codice badge errato!", "Attenzione!", JOptionPane.ERROR_MESSAGE);
			InterfacciaClienteNonRegistrato.idleScreen();
		}
	}
	
	public static void setHost(String ip){
		Host = ip;
	}
	
	public static String getHost(){
		return Host;
	}

}
