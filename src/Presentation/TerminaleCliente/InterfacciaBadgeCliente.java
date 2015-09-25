package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InterfacciaBadgeCliente {

	private JFrame frmStazioneRicambioBatterie;
	private JTextField codice_badge;

	/**
	 * Launch the application.
	 */
	public static void badgeScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaBadgeCliente window = new InterfacciaBadgeCliente();
					window.frmStazioneRicambioBatterie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacciaBadgeCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,codice_badge.getText(),"Codice Badge", JOptionPane.INFORMATION_MESSAGE);
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
}
