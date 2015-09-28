package Presentation.TerminaleCliente;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class FinestraSostituzione {

	private static String Host;
	private JFrame frmMenuDiSostituzione;
	private DefaultListModel<String> listaD;
	private DefaultListModel<String> listaD1;
	private DefaultListModel<String> listaD2;
	private JProgressBar pbar;
	private JFrame progress;


	



	/**
	 * Launch the application.
	 */
	public static void sostScreen(String host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraSostituzione window = new FinestraSostituzione();
					FinestraSostituzione.setHost(host);
					window.frmMenuDiSostituzione.setVisible(false);
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
	public FinestraSostituzione() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmMenuDiSostituzione = new JFrame();
		
		frmMenuDiSostituzione.setIconImage(Toolkit.getDefaultToolkit().getImage(FinestraSostituzione.class.getResource("/Presentation/TerminaleCliente/icon/ic_launcher.png")));
		frmMenuDiSostituzione.setTitle("Menu di sostituzione");
		frmMenuDiSostituzione.setBounds(100, 100, 487, 304);
		frmMenuDiSostituzione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton btnOk = new JButton("Conferma sostituzione");
		
		
		JLabel lblSelezionareUnautovettura = new JLabel("Selezionare un'autovettura");
		lblSelezionareUnautovettura.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		lblSelezionareUnautovettura.setForeground(Color.GREEN);
		lblSelezionareUnautovettura.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblSelezionareUnaBatteria = new JLabel("Selezionare una batteria");
		lblSelezionareUnaBatteria.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelezionareUnaBatteria.setForeground(Color.GREEN);
		lblSelezionareUnaBatteria.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FinestraSostituzione.class.getResource("/Presentation/TerminaleCliente/icon/ic_arrow.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmMenuDiSostituzione.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addGap(109))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addGap(4))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSelezionareUnautovettura, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addGap(58)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(lblSelezionareUnaBatteria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSelezionareUnaBatteria)
								.addComponent(lblSelezionareUnautovettura))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(scrollPane_1))
							.addGap(18))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(87)))
					.addComponent(btnOk)
					.addGap(9))
		);
		
		
		
		
		
		ClienteRegistratoClientRMI cr = new ClienteRegistratoClientRMI(1,FinestraSostituzione.getHost());
		
		//Recupero autovetture
		listaD = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listaD);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		listaD.removeAllElements();
		
		ArrayList<? extends AutovetturaCliente> autovetture = null;
		autovetture = cr.retrieveAutovetture();
		
		if ( autovetture.isEmpty() ) {
			
			JOptionPane.showMessageDialog(null,"Nessuna autovettura presente!","Attenzione!", JOptionPane.WARNING_MESSAGE);
			InterfacciaClienteNonRegistrato.idleScreen();
			frmMenuDiSostituzione.dispose();
			
			
		} else{
			FinestraSostituzione window = new FinestraSostituzione();
			window.frmMenuDiSostituzione.setVisible(true);
			for(int i=0; i<autovetture.size(); i++){
				listaD.addElement(autovetture.get(i).getFornitore()+", "+autovetture.get(i).getModello()+", "+autovetture.get(i).getNumeroTarga());
			}
		}
		//Recupero Batterie o Stazioni
		listaD1 = new DefaultListModel<String>();
		JList<String> list_1 = new JList<String>(listaD1);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaD1.removeAllElements();
		scrollPane_1.setViewportView(list_1);
		
		
		listaD2 = new DefaultListModel<String>();
        JList<String> lista = new JList<String>(listaD2);
        listaD2.removeAllElements();
        
        JPanel pannello = new JPanel();
        JLabel staz = new JLabel("Stazioni con disponibilità:");
        JScrollPane scroll = new JScrollPane(lista);
        JViewport jv1 = new JViewport();
        jv1.setView(staz);
        pannello.add(scroll);
        scroll.setColumnHeader(jv1);
        scroll.setViewportView(lista);
        
        
        
		
		list.addMouseListener(new MouseAdapter() {
			boolean ok = false;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<?> output = null;
				try {
					output = cr.retrieveBatterieCompatibili(list.getSelectedIndex());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				if ( output.isEmpty() ) {
					
					JOptionPane.showMessageDialog(null,"Batteria non presente in alcuna stazione!","Attenzione!", JOptionPane.WARNING_MESSAGE);
					frmMenuDiSostituzione.setVisible(false);
					InterfacciaClienteNonRegistrato.idleScreen();
					frmMenuDiSostituzione.dispose();
					//System.exit(0);
					
				} 
				
				else {
					
						
					
						if ( (output.get(0) instanceof Batteria) && (ok == false)) {
								for(int i=0; i<output.size(); i++){
									listaD1.addElement(((Batteria) output.get(i)).getID()+", "+((Batteria) output.get(i)).getCosto());
								}
								ok  = true;
								btnOk.addMouseListener(new MouseAdapter() {
									

									@Override
									public void mouseClicked(MouseEvent e1) {
										try {
											if(cr.startInstallazione(list_1.getSelectedIndex()) == true){
												JOptionPane.showMessageDialog(null,"Installazione completata!","Sostituzione Batteria", JOptionPane.INFORMATION_MESSAGE);
												frmMenuDiSostituzione.dispose();
												InterfacciaClienteNonRegistrato.idleScreen();
											}
										} catch (RemoteException e) {
										e.printStackTrace();
										}
									}
								});
						} else if ( output.get(0) instanceof Stazione) {
							for(int i=0; i<output.size(); i++){
								listaD2.addElement(((Stazione) output.get(i)).getNome()+", "+((Stazione) output.get(i)).getIndirizzo());
							}
							JOptionPane.showMessageDialog(null,scroll,"Batterie terminate!", JOptionPane.INFORMATION_MESSAGE);
							frmMenuDiSostituzione.setVisible(false);
							InterfacciaClienteNonRegistrato.idleScreen();
							frmMenuDiSostituzione.dispose();
						}
					}

				
			}
		});
		
		
		
		
		scrollPane.setViewportView(list);
		
		frmMenuDiSostituzione.getContentPane().setLayout(groupLayout);
		
	
		

	}
	
	public static void setHost(String ip){
		Host = ip;
	}
	
	public static String getHost(){
		return Host;
	}
	
}
