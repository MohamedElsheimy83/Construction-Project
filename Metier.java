package tp1;

public class Metier {
    private String nomMetier;
    private Character codeMetier;
    private String syndicat;
    static int nbrMetiers;

    Metier(String nomMetier, Character codeMetier, String syndicat) {
        this.nomMetier = nomMetier;
        this.codeMetier = codeMetier;
        this.syndicat = syndicat;
        nbrMetiers++;
    }

    public String getNomMetier() {
        return nomMetier;
    }

    public void setNomMetier(String nomMetier) {
        this.nomMetier = nomMetier;
    }

    public Character getCodeMetier() {
        return codeMetier;
    }

    public void setCodeMetier(Character codeMetier) {
        this.codeMetier = codeMetier;
    }

    public String getSyndicat() {
        return syndicat;
    }

    public void setSyndicat(String syndicat) {
        this.syndicat = syndicat;
    }

    /**
     * methode qui affiche les informations relatives a l'objet.
     * @return chaine de caracteres contenant les attributs relatives a l'objet.
     */
    public String afficherMetier() {
        return "Nom: " + nomMetier +
                ", Code:" + codeMetier +
                ", Syndicat: " + syndicat;
    }
}
