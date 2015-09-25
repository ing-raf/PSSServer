package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;

public class FinestraSostituzione {

	private JFrame frmMenuDiSostituzione;
	private DefaultListModel listD = new DefaultListModel();
	private ArrayList<String> listA = new ArrayList<String>();
	private JLabel lblNewLabel;
	private JLabel lblModello;
	private JLabel lblTarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraSostituzione window = new FinestraSostituzione();
					window.frmMenuDiSostituzione.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinestraSostituzione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuDiSostituzione = new JFrame();
		frmMenuDiSostituzione.getContentPane().setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		frmMenuDiSostituzione.setIconImage(Toolkit.getDefaultToolkit().getImage(FinestraSostituzione.class.getResource("/Presentation/TerminaleCliente/icon/ic_launcher.png")));
		frmMenuDiSostituzione.setTitle("Menu di sostituzione");
		frmMenuDiSostituzione.setBounds(100, 100, 450, 300);
		frmMenuDiSostituzione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmMenuDiSostituzione.getContentPane().setLayout(springLayout);
		
		JLabel lblSelezionareLautovettura = new JLabel("Selezionare l'autovettura:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSelezionareLautovettura, 10, SpringLayout.NORTH, frmMenuDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSelezionareLautovettura, -111, SpringLayout.EAST, frmMenuDiSostituzione.getContentPane());
		lblSelezionareLautovettura.setForeground(Color.GREEN);
		lblSelezionareLautovettura.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
		frmMenuDiSostituzione.getContentPane().add(lblSelezionareLautovettura);
		
		
		listA.add("Fiat\t"+"Panda\t"+"BX896KL");
		listD.addElement(listA.get(0));
		
		lblNewLabel = new JLabel("Marca");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -185, SpringLayout.SOUTH, frmMenuDiSostituzione.getContentPane());
		lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 73, SpringLayout.WEST, frmMenuDiSostituzione.getContentPane());
		frmMenuDiSostituzione.getContentPane().add(lblNewLabel);
		
		lblModello = new JLabel("Modello");
		springLayout.putConstraint(SpringLayout.NORTH, lblModello, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblModello, 79, SpringLayout.EAST, lblNewLabel);
		lblModello.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		frmMenuDiSostituzione.getContentPane().add(lblModello);
		
		lblTarga = new JLabel("Targa");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTarga, -185, SpringLayout.SOUTH, frmMenuDiSostituzione.getContentPane());
		lblTarga.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.EAST, lblTarga, -69, SpringLayout.EAST, frmMenuDiSostituzione.getContentPane());
		frmMenuDiSostituzione.getContentPane().add(lblTarga);
		
		ScrollPane scrollPane = new ScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 30, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, frmMenuDiSostituzione.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.EAST, lblTarga);
		frmMenuDiSostituzione.getContentPane().add(scrollPane);
		
		JList list = new JList(listD);
		list.setBounds(new Rectangle(100, 100, 100, 100));
		list.setMinimumSize(new Dimension(20, 20));
		list.setMaximumSize(new Dimension(20, 20));
		list.setLocation(new Point(20, 20));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listD.removeAllElements();
		listD.addElement("Fiat\t"+"Panda\t"+"BX896KL");
		frmMenuDiSostituzione.getContentPane().add(list);
	}
}
