
package allynecdesktop;

import java.sql.Date;
import java.sql.Time;

public class Class_presence {
    // classe pour importe les données de la bd vers la page presence
    private int numpresence;
    private String nom;
    private String prenom;
    private String sexe;
    private String titre;
    private String contact;
    private Date datepresence;
    private Time heurepresence;
    private int iduser;

    public Class_presence(int numpresence, String nom, String prenom, String sexe, String titre, String contact, Date datepresence, Time heurepresence, int iduser) {
        this.numpresence = numpresence;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.titre = titre;
        this.contact = contact;
        this.datepresence = datepresence;
        this.heurepresence = heurepresence;
        this.iduser = iduser;
    }

    public int getNumpresence() {
        return numpresence;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTitre() {
        return titre;
    }

    public String getContact() {
        return contact;
    }

    public Date getDatepresence() {
        return datepresence;
    }

    public Time getHeurepresence() {
        return heurepresence;
    }

    public int getIduser() {
        return iduser;
    }

    
    
}
