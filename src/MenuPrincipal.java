import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuPrincipal {

	public MenuPrincipal() {
		createTrayIcon();
	}
	
	private void createTrayIcon() {
		
		PopupMenu popupMenu = new PopupMenu();
		
		TrayIcon tray = new TrayIcon(new ImageIcon("src\\icon3.png").getImage());
		
		MenuItem menuConfig = new MenuItem("Configuração");
		menuConfig.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaConfiguracao().setVisible(true);
			}
		});
		
		MenuItem menuVisivel = new MenuItem("Visível");
		menuVisivel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuscaVisivel().setVisible(true);
			}
		});
		
		MenuItem menuSair = new MenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saiu do sistema!");
				System.exit(0);
			}
		});
		
		popupMenu.add(menuConfig);
		popupMenu.add(menuVisivel);
		popupMenu.add(menuSair);
		
		tray.setPopupMenu(popupMenu);
		tray.setToolTip("Software de Rota V2021.05.06");
		
		SystemTray systemTray = SystemTray.getSystemTray();
		
		try {
			systemTray.add(tray);
		} 
		catch (AWTException e1) {
			JOptionPane.showMessageDialog(null, "Problemas ao criar o Tray no sistema operacioal");
		}	
	}
}
