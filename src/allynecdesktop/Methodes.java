/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allynecdesktop;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Methodes {
    
     //verifier si le champ est vide
    public static boolean estVide(String a )
    {
        return a.isEmpty();
    }
    
    // Signaler un champ vide
      public static String alerterVide( String champ)
    {
         JOptionPane.showMessageDialog(null, champ+" ne peut pas etre vide"); 
        return champ;
    }
    
    //verifier si un champ contient uniquament des lettres
    public static boolean lettreUniquement( String a)
    {
        for(char c : a.toCharArray())
        { 
            if( ! Character.isLetter(c))
            {
                return false;
            }
           
        }
        return true;
    }
     //remplacer la virgule par un point
    public static String arrangement( String a)
    {
        a = a.replace(",",".");
        return a;
    }
    
    
    
    //verifier si un champ contient uniquement les chiffres
    public static boolean chiffreUniquement( String a)
    {
        try {
            int nombre = Integer.parseInt(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public static int compteurChamp( String a) {
        String b = a;
        
        return b.length();
        
    }
    //verifier si un champ contient uniquement les réels(entier)
    public static boolean reelUniquement( String a)
    {
        a = a.replace(",",".");
        try {
            float nombre = Float.parseFloat(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
   
    static boolean lettreUniquement(char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // verifier si l'email est valide
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    
    public  static boolean isValidEmail(String amail){
        CharSequence email = amail;
        
          
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    //verifier si la date est valide



    public static boolean isValidDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
 

   public static Date dateActuelle() {
       Date date = Date.valueOf(LocalDate.now());
        return date;
    }

  
    
    
    public static Time heureActuelle() {
        LocalTime currentTime = LocalTime.now();
        Time heure = Time.valueOf(currentTime);
        return heure;
    }

}


