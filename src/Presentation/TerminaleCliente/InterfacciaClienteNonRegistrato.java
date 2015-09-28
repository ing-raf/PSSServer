package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfacciaClienteNonRegistrato {

	private JFrame frmStazioneDiSostituzione;
	private static String Host;
	

	/**
	 * Launch the application.
	 */
	public static void idleScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaClienteNonRegistrato window = new InterfacciaClienteNonRegistrato();
					window.frmStazioneDiSostituzione.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacciaClienteNonRegistrato() {
		visualizzaDisplayIdle();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void visualizzaDisplayIdle() {
		frmStazioneDiSostituzione = new JFrame();
		frmStazioneDiSostituzione.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaClienteNonRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/ic_launcher.png")));
		frmStazioneDiSostituzione.setTitle("Stazione di sostituzione batterie");
		frmStazioneDiSostituzione.setBounds(100, 100, 450, 300);
		frmStazioneDiSostituzione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmStazioneDiSostituzione.getContentPane().setLayout(springLayout);
		
		JLabel lblBenvenutoInStazione = new JLabel("Benvenuto in stazione!");
		springLayout.putConstraint(SpringLayout.NORTH, lblBenvenutoInStazione, 48, SpringLayout.NORTH, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBenvenutoInStazione, 97, SpringLayout.WEST, frmStazioneDiSostituzione.getContentPane());
		lblBenvenutoInStazione.setFont(new Font("Maiandra GD", Font.PLAIN, 24));
		lblBenvenutoInStazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenutoInStazione.setForeground(Color.GREEN);
		frmStazioneDiSostituzione.getContentPane().add(lblBenvenutoInStazione);
		
		JLabel lblDjdsojfaod = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblDjdsojfaod, 1, SpringLayout.SOUTH, lblBenvenutoInStazione);
		springLayout.putConstraint(SpringLayout.WEST, lblDjdsojfaod, 81, SpringLayout.WEST, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDjdsojfaod, 127, SpringLayout.SOUTH, lblBenvenutoInStazione);
		springLayout.putConstraint(SpringLayout.EAST, lblDjdsojfaod, -85, SpringLayout.EAST, frmStazioneDiSostituzione.getContentPane());
		lblDjdsojfaod.setIcon(new ImageIcon(InterfacciaClienteNonRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/batteria.jpg")));
		frmStazioneDiSostituzione.getContentPane().add(lblDjdsojfaod);
		
		JButton btnAvanti = new JButton("Avanti");
		btnAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfacciaBadgeCliente.badgeScreen(InterfacciaClienteNonRegistrato.getHost());
				frmStazioneDiSostituzione.setVisible(false);
			
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnAvanti, -10, SpringLayout.SOUTH, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAvanti, -181, SpringLayout.EAST, frmStazioneDiSostituzione.getContentPane());
		frmStazioneDiSostituzione.getContentPane().add(btnAvanti);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfacciaClienteNonRegistrato.setHost(JOptionPane.showInputDialog(null,"Inserire l'indirizzo IP del server:", "Impostazioni", JOptionPane.QUESTION_MESSAGE));
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 58, SpringLayout.NORTH, frmStazioneDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 65, SpringLayout.WEST, frmStazioneDiSostituzione.getContentPane());
		btnNewButton.setIcon(new ImageIcon(InterfacciaClienteNonRegistrato.class.getResource("/Presentation/TerminaleCliente/icon/ic_settings.png")));
		frmStazioneDiSostituzione.getContentPane().add(btnNewButton);
	}
	
	public static void setHost(String ip){
		Host = ip;
	}
	
	public static String getHost(){
		return Host;
	}
}
