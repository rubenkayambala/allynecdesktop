/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allynecdesktop;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class AllynecDB {
    
     public com.mysql.jdbc.Connection getConnection(){
        
        com.mysql.jdbc.Connection con = null;
        
        try {
            //connexion à la base des données
             con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/allynecdb","root","");
             //JOptionPane.showMessageDialog(null,"Connexion à la base des données réussie.");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Pageprincipale.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Connection échouée !");
            return null;
        }
        
    }
    
}
