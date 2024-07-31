
package allynecdesktop;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class ImportEnrg {
    
    private int numEmploye;
    private String nom;
    private String postnom;
    private String prenom;
    private char sexe;
    private Date datenaissance;
    private String domicile;
    private String contact;
    private String email;
    private String statut;
    private Date dateajout;
    private int iduser;

    public ImportEnrg(int numEmploye, String nom, String postnom, String prenom, char sexe, Date datenaissance, String domicile, String contact, String email, String statut, Date dateajout, int iduser) {
        this.numEmploye = numEmploye;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datenaissance = datenaissance;
        this.domicile = domicile;
        this.contact = contact;
        this.email = email;
        this.statut = statut;
        this.dateajout = dateajout;
        this.iduser = iduser;
    }

    public int getNumEmploye() {
        return numEmploye;
    }

    public String getNom() {
        return nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public String getDomicile() {
        return domicile;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getStatut() {
        return statut;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public int getIduser() {
        return iduser;
    }

    
}
