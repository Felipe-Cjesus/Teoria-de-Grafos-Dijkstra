import java.awt.event.ActionEvent;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

	public class BuscaVisivel extends JFrame{

		private JLabel lblBuscar;
		private JLabel lblCodOrigem;
		private JLabel lblCidadeOrigem;
		private JLabel lblCidadeOrigemDesc;
		private JLabel lblCidadeDestino;
		private JLabel lblCidadeDestinoDesc;
		private JLabel lblCodDestino;
		private JLabel lblKM;
		private JTextField txtBuscar;
		private JTextField txtCodOrigem;
		private JTextField txtCidadeOrigem;
		private JTextField txtCidadeDestino;
		private JTextField txtCodDestino;
		private JTextField txtKM;
		private JButton btnSalvar;
		private JButton btnProcessar;
		private JButton btnBuscar;
		private JButton btnAdd;
		private JTable tblDados;
		private JScrollPane spnDados;
		private DefaultTableModel model;

		Grafo g = new Grafo(999);
		
		public BuscaVisivel() {
			setSize(600, 500);
			setTitle("Tela de Busca");
			setLayout(null);
			setResizable(false);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			componentesCriar();
		}
		
		public void limparCampos() {
			txtCodOrigem.setText("");
			txtCidadeOrigem.setText("");
			txtCodDestino.setText("");
			txtCidadeDestino.setText("");
			txtKM.setText("");
		}
		
		private void componentesCriar() {
			lblBuscar = new JLabel("Buscar");
			lblBuscar.setBounds(10, 10 , 60, 25);
			getContentPane().add(lblBuscar);
			
			txtBuscar = new JTextField();
			txtBuscar.setBounds(60, 10, 300, 25);
			getContentPane().add(txtBuscar);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(365, 10, 100, 25);
			getContentPane().add(btnBuscar);
			
			lblCodOrigem = new JLabel("Código:");
			lblCodOrigem.setBounds(10, 50 , 60, 25);
			getContentPane().add(lblCodOrigem);
					
			txtCodOrigem = new JTextField();
			txtCodOrigem.setBounds(60, 50, 75, 25);
			getContentPane().add(txtCodOrigem);
			
			lblCidadeOrigem = new JLabel("Cidade:");
			lblCidadeOrigem.setBounds(180, 50 , 60, 25);
			getContentPane().add(lblCidadeOrigem);
					
			txtCidadeOrigem = new JTextField();
			txtCidadeOrigem.setBounds(230, 50, 130, 25);
			getContentPane().add(txtCidadeOrigem);
			
			lblCidadeOrigemDesc = new JLabel("(ORIGEM)");
			lblCidadeOrigemDesc.setBounds(365, 50 , 60, 25);
			getContentPane().add(lblCidadeOrigemDesc);
			
			lblCodDestino = new JLabel("Código:");
			lblCodDestino.setBounds(10, 80 , 60, 25);
			getContentPane().add(lblCodDestino);
					
			txtCodDestino = new JTextField();
			txtCodDestino.setBounds(60, 80, 75, 25);
			getContentPane().add(txtCodDestino);
			
			lblCidadeDestino = new JLabel("Cidade:");
			lblCidadeDestino.setBounds(180, 80 , 60, 25);
			getContentPane().add(lblCidadeDestino);
					
			txtCidadeDestino = new JTextField();
			txtCidadeDestino.setBounds(230, 80, 130, 25);
			getContentPane().add(txtCidadeDestino);
			
			lblCidadeDestinoDesc = new JLabel("(DESTINO)");
			lblCidadeDestinoDesc.setBounds(365, 80 , 60, 25);
			getContentPane().add(lblCidadeDestinoDesc);
			
			lblKM = new JLabel("KM:");
			lblKM.setBounds(10, 110 , 60, 25);
			getContentPane().add(lblKM);
					
			txtKM = new JTextField();
			txtKM.setBounds(60, 110, 45, 25);
			getContentPane().add(txtKM);
			
			btnAdd = new JButton(new AbstractAction("+") {
		
				@Override					
				public void actionPerformed(ActionEvent e) {
					
					if(txtKM.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Campo <KM> Obrigatório!");
					}
						else if(Double.parseDouble(txtKM.getText()) <=-1 ) {
							JOptionPane.showMessageDialog(null, "Campo <KM> não pode ser Negativo!");
						}
						else if(txtCodOrigem.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo <Código Origem> Obrigatório!");
						}
						else if(txtCidadeOrigem.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo <Cidade Origem> Obrigatório!");
						}
						else if(txtCodDestino.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo <Cidade Destino> Obrigatório!");
						}
						else if(txtCidadeDestino.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Campo <Cidade Destino> Obrigatório!");
						}
						else if(txtCidadeOrigem.getText().equals(txtCidadeDestino.getText())) {
							JOptionPane.showMessageDialog(null, "Campos <Cidade Origem> e <Cidade Destino> não podem ser iguais");
						}
						else if(txtCodOrigem.getText().equals(txtCodDestino.getText())) {
							JOptionPane.showMessageDialog(null, "Campos <Código Origem> e <Código Destino> não podem ser iguais");
						}
					else {
						model.addRow(new Object[] {txtCodOrigem.getText(), txtCidadeOrigem.getText(), txtCodDestino.getText(), txtCidadeDestino.getText(), Integer.parseInt(txtKM.getText())});
						
						try {
							
							for(int i = 0; i <= model.getRowCount()-1; i++) {
								
								int colunaOrigem = Integer.parseInt((String) model.getValueAt(i, 0));
								int colunaDestino = Integer.parseInt((String)model.getValueAt(i, 2));
								int colunaPeso = (Integer) model.getValueAt(i, 4);

								System.out.println("Origem: " + colunaOrigem);
								System.out.println("Destino: " + colunaDestino);
								System.out.println("Peso: " + colunaPeso);
								g.criaAresta(colunaOrigem, colunaDestino, colunaPeso);
							}
							
						}catch (Exception er) {
							er.printStackTrace();
						}
					}
					//Limpa os campos do Jframe
					limparCampos();
				}
			});
			btnAdd.setBounds(524, 115, 45, 25);
			getContentPane().add(btnAdd);
			
			model = new DefaultTableModel();
			model.addColumn("Código Origem");
			model.addColumn("Cidade Origem");
			model.addColumn("Código Destino");
			model.addColumn("Cidade Destino");
			model.addColumn("Distância");
			
			tblDados = new JTable(model);
			spnDados = new JScrollPane(tblDados);
			spnDados.setBounds(10, 145, 565, 280);
			getContentPane().add(spnDados);
			
			btnSalvar = new JButton("SALVAR");
			btnSalvar.setBounds(360, 430, 100, 25);
			getContentPane().add(btnSalvar);
			
			btnProcessar = new JButton(new AbstractAction(("PROCESSAR")) {
				
				@Override
				public void actionPerformed(ActionEvent e) {
										
					try {
						
						int origem = Integer.parseInt(JOptionPane.showInputDialog("Origem"));
						if(origem <= 0) {
							JOptionPane.showMessageDialog(null,"Campo Código Origem não pode ser menor que zero! Processe novamente!");
							return;
						}
						
						int destino = Integer.parseInt(JOptionPane.showInputDialog("Destino"));
						if(destino <= 0 ) {
							JOptionPane.showMessageDialog(null,"Campo Código Destino não pode ser menor que zero! Processe novamente!");
							return;
						}
						
						else {
							
							//Manda para a função o cod de origem e destino e retorna o resultado em uma List
							List<Integer> resultado	= g.caminhoMinimo(origem,destino);
							
							//Retorna em tela a rota com o menor caminho.
							JOptionPane.showMessageDialog(null, "Resultado: "+ resultado);
						}
												
					}
					catch (NumberFormatException err){
						JOptionPane.showMessageDialog(null, "Campos Código Origem e Código Destino não podem estar vazio! Processe novamente!");
					}
				}
			});
			btnProcessar.setBounds(465, 430, 110, 25);
			getContentPane().add(btnProcessar);
		}
	}
