package listatelefonica.ui;

import java.awt.*;
import javax.swing.*;

public class PainelInicio extends JPanel {

    public PainelInicio() {
        super();

        // Sem método paintComponent        
        // super(new BorderLayout());
        // add(new JLabel(new ImageIcon("lista telefonica.jpg")));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Dimension dimensaoPainel = this.getSize(); 	              
        double largura = dimensaoPainel.getWidth();
        double altura = dimensaoPainel.getHeight();
        
        ImageIcon i1 = new ImageIcon("lista telefonica.jpg");	
        
        Image i2 = i1.getImage().getScaledInstance(
                (int) largura, 
                (int) altura, 
                Image.SCALE_SMOOTH);
        
        Image i3 = new ImageIcon(i2).getImage();
        
        g.drawImage(i3, 0, 0, this);
    }

}
