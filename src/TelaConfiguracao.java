import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaConfiguracao extends JFrame{

	private JLabel lblPasta;
	private JLabel lblSucesso;
	private JLabel lblErro;
	private JLabel lblCheck;
	private JTextField txtPasta;
	private JTextField txtSucesso;
	private JTextField txtErro;
	private JButton btnSalvar;
	private JCheckBox chkRota;
	
	public TelaConfiguracao () {
		setSize(300,220);
		setTitle("Configuração");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		criarComponentes();
	}
	
	public void criarComponentes (){
		lblPasta = new JLabel("Pasta:");
		lblPasta.setBounds(10, 10, 60, 25);
		getContentPane().add(lblPasta);
		
		txtPasta = new JTextField();
		txtPasta.setBounds(80, 10, 200, 25);
		getContentPane().add(txtPasta);
		
		lblSucesso = new JLabel("Sucesso:");
		lblSucesso.setBounds(10, 45, 60, 25);
		getContentPane().add(lblSucesso);
		
		txtSucesso = new JTextField();
		txtSucesso.setBounds(80, 45, 95, 25);
		getContentPane().add(txtSucesso);
		
		lblErro = new JLabel("Erro:");
		lblErro.setBounds(10, 80, 60, 25);
		getContentPane().add(lblErro);
		
		txtErro = new JTextField();
		txtErro.setBounds(80, 80, 95, 25);
		getContentPane().add(txtErro);
		
		chkRota = new JCheckBox();
		chkRota.setBounds(80, 110, 20, 25);
		getContentPane().add(chkRota);
		
		lblCheck = new JLabel("Rota Automática");
		lblCheck.setBounds(100, 110, 120, 25);
		getContentPane().add(lblCheck);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(80, 140, 100, 25);	
		getContentPane().add(btnSalvar);
		
	}
}

