
package allynecdesktop;

import java.sql.Date;


public class Class_Enrg {
    
    private int numEmploy;
    private String nom;
    private String pstnom;
    private String pnom;
    private String sexe;
    private Date naissance;
    private String domicile;
    private String contact;
    private String email;
    private String titre;
    private Date dateAjout;
    private int iduser;
    private String situation;
    private String motif;

    public Class_Enrg(int numEmploy, String nom, String pstnom, String pnom, String sexe, Date naissance, String domicile, String contact, String email, String titre, Date dateAjout, int iduser, String situation, String motif) {
        this.numEmploy = numEmploy;
        this.nom = nom;
        this.pstnom = pstnom;
        this.pnom = pnom;
        this.sexe = sexe;
        this.naissance = naissance;
        this.domicile = domicile;
        this.contact = contact;
        this.email = email;
        this.titre = titre;
        this.dateAjout = dateAjout;
        this.iduser = iduser;
        this.situation = situation;
        this.motif = motif;
    }

    public int getNumEmploy() {
        return numEmploy;
    }

    public String getNom() {
        return nom;
    }

    public String getPstnom() {
        return pstnom;
    }

    public String getPnom() {
        return pnom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getNaissance() {
        return naissance;
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

    public String getTitre() {
        return titre;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public int getIduser() {
        return iduser;
    }

    public String getSituation() {
        return situation;
    }

    public String getMotif() {
        return motif;
    }
    
    
    
    
}
