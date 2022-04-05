package tp1;

public class Statut {
    private String statutEtiquette;
    private String code;
    static int nbrStatuts;
    int comptVerification = 0;
    int indexStatut = 0;

    Statut() {
    }

    Statut(String statutEtiquette, String code) {
        this();
        this.statutEtiquette = statutEtiquette;
        this.code = code;
        nbrStatuts++;
    }

    public String getStatutEtiquette() {
        return statutEtiquette;
    }

    public void setStatutEtiquette(String statutEtiquette) {
        this.statutEtiquette = statutEtiquette;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * methode qui affiche les informations relatives a l'objet.
     * @return chaine de caracteres contenant les attributs relatives a l'objet.
     */
    public String afficherStatut() {
        return "Etiquette: " + statutEtiquette +
                ", Code: " + code;
    }

    /**
     * methode qui verifier le code du statut.
     * @param codeStatut
     * @return comptVerification.
     */
    public int verifierStatut(String codeStatut) {
        comptVerification = 0;
        for (int i = 0; i < Main.statutsListe.size(); i++) {
            if (Main.statutsListe.get(i).getCode().equals(codeStatut)) {
                indexStatut = i;
                comptVerification++;
            }
        }
        return comptVerification;
    }

    /**
     * procedure qui modifier l'etiquett' du statut.
     * @param indexChantierCode
     */
    public void modifierStatut(int indexChantierCode) {
        String nouveauStatut = Main.statutsListe.get(indexStatut).getStatutEtiquette();
        Main.chantiersListe.get(indexChantierCode).getStatut().setStatutEtiquette(nouveauStatut);
    }
}

