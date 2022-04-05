package tp1;

import java.util.ArrayList;

public class Chantier {
    private String nomChantier;
    private int codeChantier;
    private String adresse;
    ArrayList<Ouvrier> ouvrier;
    private Statut statut;
    static int nbrChantiers;
    int comptVerification = 0;
    int indexChantierCode = 0;

    Chantier() {
    }

    Chantier(String nomChantier, int codeChantier, String adresse) {
        this();
        this.nomChantier = nomChantier;
        this.codeChantier = codeChantier;
        this.adresse = adresse;
        ouvrier = new ArrayList<>();
        nbrChantiers++;
    }

    public String getNomChantier() {
        return nomChantier;
    }

    public void setNomChantier(String nomChantier) {
        this.nomChantier = nomChantier;
    }

    public int getCodeChantier() {
        return codeChantier;
    }

    public void setCodeChantier(int codeChantier) {
        this.codeChantier = codeChantier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     * methode qui affiche les informations relatives a l'objet.
     * @return chaine de caracteres contenant les attributs relatives a l'objet.
     */
    public String afficherChantier() {
        return "Nom: " + nomChantier +
                ", Code: " + codeChantier +
                ", Adresse: " + adresse +
                ", Statut: " + statut.getStatutEtiquette();
    }

    /**
     * procedure qui ajoute d'ouvrier au chantier.
     */
    public void ajouterOuvrier(Ouvrier ouvriers) {
        ouvrier.add(ouvriers);
    }

    /**
     * methode qui verifier le code du chantier.
     * @param codeChantier
     * @return comptVerification.
     */
    public int verifierChantier(int codeChantier) {
        comptVerification = 0;
        for (int i = 0; i < Main.chantiersListe.size(); i++) {
            if (Main.chantiersListe.get(i).codeChantier == codeChantier) {
                indexChantierCode = i;
                comptVerification++;
            }
        }
        if (comptVerification == 0) {
            System.out.println("le code du chantier n'existe pas");
            comptVerification = 0;
        }
        return comptVerification;
    }

    /**
     * methode qui retourne l'index du chantier dans la liste des chantiers.
     * @return indexChantierCode.
     */
    public int indexChantierCode() {
        return indexChantierCode;
    }
}