
package allynecdesktop;
import allynecdesktop.Pageprincipale;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AllynecDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
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
              //page autorisation
              pg.jCheckBoxLecture.setVisible(false);
              pg.jCheckBoxEcriture.setVisible(false);
              pg.modifierAuto.setVisible(false);
              //page Enrg
              pg.btn_modif_enrg.setVisible(false);
              pg.bnt_supp_enrg.setVisible(false);
              pg.btn_desa_enrg.setVisible(false);
              //connexion à la base des données
              AllynecDB s = new AllynecDB();
              Connection con = s.getConnection();
              //ouverture de l'espace travail
              pg.setVisible(true);
              JOptionPane.showMessageDialog(null, "Veuillez mettre à jour la date et l'heure de votre Ordinateur pour que \n"
                      + "certaines fonctionalités soient exécutées");
              pg.jPanelLogin.setVisible(true);
              pg.ouvrirLien();
              
              
            
              
          }
      }
            
        } catch (Exception e) {
        }
    }
    
}
