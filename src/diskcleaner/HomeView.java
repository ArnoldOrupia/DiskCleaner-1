
package diskcleaner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel {
    public JLabel imagelabel;
    
    public HomeView(){
        JPanel panel=new JPanel();
        add(panel);
        
        imagelabel=new JLabel(new ImageIcon(getClass().getResource("/images/cleaner2.jpg")));
        panel.add(imagelabel);
        
        
    }
}
  
    
    
    

 