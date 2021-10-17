package interfaceUsuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CamposMenu extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel delimitador;
    private JTextField tdelimitador;
    private JButton sub;
    private JButton reset;
    private JRadioButton linha;
    private JRadioButton coluna;
    


	public CamposMenu() {
			setTitle("Janela Menu");
	        setBounds(150, 45, 450, 300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(true);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Menu");
	        title.setFont(new Font("Arial", Font.PLAIN, 18));
	        title.setSize(80, 50);
	        title.setLocation(200, 5);
	        c.add(title);
	        
	       
	 
	        delimitador = new JLabel("Delimitador");
	        delimitador.setFont(new Font("Arial", Font.PLAIN, 13));
	        delimitador.setSize(100, 20);
	        delimitador.setLocation(90, 50);
	        c.add(delimitador);
	        
	        tdelimitador = new JTextField();
	        tdelimitador.setFont(new Font("Arial", Font.PLAIN, 15));
	        tdelimitador.setSize(50, 20);
	        tdelimitador.setLocation(180, 50);
	        c.add(tdelimitador);
	        
	        linha = new JRadioButton("Linha");
	        linha.setFont(new Font("Arial", Font.PLAIN, 15));
	        linha.setSelected(false);
	        linha.setSize(75, 20);
	        linha.setLocation(90, 125);
	        c.add(linha);
	 
	        coluna = new JRadioButton("Coluna");
	        coluna.setFont(new Font("Arial", Font.PLAIN, 15));
	        coluna.setSelected(false);
	        coluna.setSize(80, 20);
	        coluna.setLocation(90, 90);
	        c.add(coluna);
	        setVisible(true);
	        

	        sub = new JButton("Submit");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(100, 220);
	        sub.addActionListener(this);
	        c.add(sub);
	 
	        reset = new JButton("Reset");
	        reset.setFont(new Font("Arial", Font.PLAIN, 15));
	        reset.setSize(100, 20);
	        reset.setLocation(240, 220);
	        reset.addActionListener(this);
	        c.add(reset);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String opDelimitador;
		String linha_coluna;
		// TODO Auto-generated method stub
		if(e.getSource() == sub) {
			//System.out.println(tdelimitador.getText());
			opDelimitador = tdelimitador.getText();
			
			if (linha.isSelected()) {
		        coluna.setSelected(false);
		        linha_coluna = "Linha";
			}
                // System.out.println("Linha");}
             else {
            	 linha_coluna = "Coluna";
                 linha.setSelected(false);
                 }
            	 //System.out.println("Coluna");
				System.out.println("Opção: " + linha_coluna + " Delimitador: " + opDelimitador);
             }
		
		else if (e.getSource() == reset) {
            String def = "";
            tdelimitador.setText(def);
            coluna.setSelected(false);
            linha.setSelected(false);

        }
	}
	
}
