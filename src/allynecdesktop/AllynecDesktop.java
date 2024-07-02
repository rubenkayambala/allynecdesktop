
package allynecdesktop;
import allynecdesktop.Pageprincipale;
import java.awt.BorderLayout;

public class AllynecDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bienvenu bn = new Bienvenu();
        bn.setVisible(true);
        Pageprincipale pg = new Pageprincipale();
     
        
         try {
            
            
      for( int i = 0; i< 100; i++)
      {
        
          Thread.sleep(10);
          bn.jProgressBar1.setValue(i);
         
          if( i == 99)
          {
              
              bn.dispose();
              pg.jPanelPrincipale.setVisible(false);
              pg.jPanelEnreg.setVisible(false);
              pg.jPanelPresence.setVisible(false);
              pg.jPanelValidation.setVisible(false);
              pg.jPanelAdmin.setVisible(false);
              
              pg.setVisible(true);
              pg.jPanelLogin.setVisible(true);
              pg.ouvrirLien();
              
              
            
              
          }
      }
            
        } catch (Exception e) {
        }
    }
    
}
