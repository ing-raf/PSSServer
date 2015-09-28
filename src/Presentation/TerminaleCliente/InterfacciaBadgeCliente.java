package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class InterfacciaBadgeCliente {

	private JFrame frmStazioneRicambioBatterie;
	private JTextField codice_badge;
	private static String Host;

	/**
	 * Launch the application.
	 */
	public static void badgeScreen(String host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaBadgeCliente window = new InterfacciaBadgeCliente();
					InterfacciaBadgeCliente.setHost(host);
					window.frmStazioneRicambioBatterie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public InterfacciaBadgeCliente() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmStazioneRicambioBatterie = new JFrame();
		frmStazioneRicambioBatterie.setForeground(new Color(204, 255, 204));
		frmStazioneRicambioBatterie.getContentPane().setFont(new Font("Maiandra GD", Font.BOLD, 18));
		frmStazioneRicambioBatterie.getContentPane().setForeground(new Color(204, 255, 204));
		frmStazioneRicambioBatterie.setTitle("Stazione ricambio batterie");
		frmStazioneRicambioBatterie.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaBadgeCliente.class.getResource("/Presentation/TerminaleCliente/icon/ic_launcher.png")));
		frmStazioneRicambioBatterie.setBounds(100, 100, 450, 300);
		frmStazioneRicambioBatterie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBenvenuto = new JLabel("Stazione ricambio batterie");
		lblBenvenuto.setForeground(Color.GREEN);
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenuto.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
		
		JLabel lblInserireIlCodice = new JLabel("Inserire il codice bagde:");
		lblInserireIlCodice.setForeground(Color.RED);
		lblInserireIlCodice.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		lblInserireIlCodice.setHorizontalAlignment(SwingConstants.CENTER);
		
		codice_badge = new JTextField();
	
		codice_badge.setHorizontalAlignment(SwingConstants.CENTER);
		codice_badge.setColumns(10);
		
		BadgeClientRMI badge = new BadgeClientRMI(1,InterfacciaBadgeCliente.getHost());
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					badge.startValidazione(Integer.parseInt(codice_badge.getText()));
				} catch (NumberFormatException | RemoteException e) {
					
					e.printStackTrace();
				}
				InterfacciaClienteRegistrato cr = new InterfacciaClienteRegistrato();
				try {
					cr.notifyValidazione(InterfacciaBadgeCliente.getHost());
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				frmStazioneRicambioBatterie.setVisible(false);
				
			}
		});
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(InterfacciaBadgeCliente.class.getResource("/Presentation/TerminaleCliente/icon/ic_badge.png")));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, codice_badge, 6, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.SOUTH, codice_badge, -6, SpringLayout.NORTH, btnOk);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOk, 251, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnOk, 0, SpringLayout.EAST, codice_badge);
		springLayout.putConstraint(SpringLayout.WEST, btnOk, 0, SpringLayout.WEST, codice_badge);
		springLayout.putConstraint(SpringLayout.WEST, codice_badge, 152, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, codice_badge, 280, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 220, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label, 118, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 186, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblInserireIlCodice, 71, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblInserireIlCodice, 113, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblInserireIlCodice, 112, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblInserireIlCodice, 317, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblBenvenuto, 0, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBenvenuto, 0, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblBenvenuto, 65, SpringLayout.NORTH, frmStazioneRicambioBatterie.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBenvenuto, 434, SpringLayout.WEST, frmStazioneRicambioBatterie.getContentPane());
		frmStazioneRicambioBatterie.getContentPane().setLayout(springLayout);
		frmStazioneRicambioBatterie.getContentPane().add(lblBenvenuto);
		frmStazioneRicambioBatterie.getContentPane().add(lblInserireIlCodice);
		frmStazioneRicambioBatterie.getContentPane().add(label);
		frmStazioneRicambioBatterie.getContentPane().add(codice_badge);
		frmStazioneRicambioBatterie.getContentPane().add(btnOk);
		frmStazioneRicambioBatterie.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmStazioneRicambioBatterie.getContentPane(), lblBenvenuto, lblInserireIlCodice, codice_badge, btnOk, label}));
	}
	
	public void ejectBadge() {
		
	}
	
	public static void setHost(String ip){
		Host = ip;
	}
	
	public static String getHost(){
		return Host;
	}
}
