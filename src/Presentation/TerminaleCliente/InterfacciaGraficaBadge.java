package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfacciaGraficaBadge {

	private JFrame frame;
	private JTextField textIDBadge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaGraficaBadge window = new InterfacciaGraficaBadge();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacciaGraficaBadge() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblBenvenutiInStazione = new JLabel("Benvenuti in STAZIONE");
		springLayout.putConstraint(SpringLayout.NORTH, lblBenvenutiInStazione, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBenvenutiInStazione, 120, SpringLayout.WEST, frame.getContentPane());
		lblBenvenutiInStazione.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblBenvenutiInStazione.setForeground(Color.BLUE);
		frame.getContentPane().add(lblBenvenutiInStazione);
		
		JLabel lblInserisciIlCodice = new JLabel("Inserisci il codice del Badge");
		lblInserisciIlCodice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frame.getContentPane().add(lblInserisciIlCodice);
		
		textIDBadge = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblInserisciIlCodice, 4, SpringLayout.NORTH, textIDBadge);
		springLayout.putConstraint(SpringLayout.EAST, lblInserisciIlCodice, -12, SpringLayout.WEST, textIDBadge);
		springLayout.putConstraint(SpringLayout.WEST, textIDBadge, 257, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textIDBadge, -38, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textIDBadge, -97, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(textIDBadge);
		textIDBadge.setColumns(10);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chiamo la funzione di sotto
				
				int IDbadge = Integer.parseInt(textIDBadge.getText());
	//			startValidazione(IDbadge);
			}
		});


		springLayout.putConstraint(SpringLayout.NORTH, btnConferma, 29, SpringLayout.SOUTH, textIDBadge);
		springLayout.putConstraint(SpringLayout.WEST, btnConferma, 175, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConferma, 67, SpringLayout.SOUTH, textIDBadge);
		springLayout.putConstraint(SpringLayout.EAST, btnConferma, 287, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnConferma);
	}
}
