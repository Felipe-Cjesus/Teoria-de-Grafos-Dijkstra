import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	private JMenuBar barraMenu;
	private JMenu menuSistema;
	private JMenu menuRota;
	private JMenuItem itemSistemaSair;
	private JMenuItem itemSistemaConfig;
	private JMenuItem itemRotaVisivel;
	private JFrame frame;
	
	public Menu() {
		criaMenu();
	}
	
	private void criaMenu() {
		barraMenu = new JMenuBar();
		
		menuSistema = new JMenu("Sistema");
		itemSistemaConfig = new JMenuItem("Configuração");
		itemSistemaConfig.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new TelaConfiguracao().setVisible(true);
				}
			});
		itemSistemaSair = new JMenuItem("Sair");
		itemSistemaSair.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					System.out.println("Saiu do sistema!");
				}
			});
			
		menuSistema.add(itemSistemaConfig);
		menuSistema.addSeparator();
		menuSistema.add(itemSistemaSair);
			
		menuRota = new JMenu("Rota");
		itemRotaVisivel = new JMenuItem("Menor Caminho");
		itemRotaVisivel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new BuscaVisivel().setVisible(true);
				}
			});
		menuRota.add(itemRotaVisivel);
		
		barraMenu.add(menuSistema);
		barraMenu.add(menuRota);
		
		frame = new JFrame("Sistema de Rota - v2021.05.06");
		frame.setSize(1000, 600);
		frame.setJMenuBar(barraMenu);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
