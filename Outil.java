package tp1;

public class Outil {
    private String nomOutil;
    private int codeOutil;
    private double cout;
    private String action;
    static int nbrOutils;

    Outil() {
    }

    Outil(String nomOutil, int codeOutil, double cout, String action) {
        this();
        this.nomOutil = nomOutil;
        this.codeOutil = codeOutil;
        this.cout = cout;
        this.action = action;
        nbrOutils++;
    }

    public String getNomOutil() {
        return nomOutil;
    }

    public void setNomOutil(String nomOutil) {
        this.nomOutil = nomOutil;
    }

    public int getCodeOutil() {
        return codeOutil;
    }

    public void setCodeOutil(int codeOutil) {
        this.codeOutil = codeOutil;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * methode qui affiche les informations relatives a l'objet.
     * @return chaine de caracteres contenant les attributs relatives a l'objet.
     */
    public String afficherOutil() {
        return "Nom: " + nomOutil +
                ", Code: " + codeOutil +
                ", Cout: " + cout + "$";
    }

    /**
     * methode qui obtient l'action faite par l'outil.
     * @param indexEmployCode
     * @param code_Outil
     * @return chaine de caracteres qui decrit l'action faite par l'outil.
     */
    public String activer(int indexEmployCode, int code_Outil) {
        for (int i = 0; i < Main.ouvriersListe.get(indexEmployCode).coffreOutils.size(); i++) {
            if (Main.ouvriersListe.get(indexEmployCode).coffreOutils.get(i).getCodeOutil() == code_Outil) {
                action = (Main.ouvriersListe.get(indexEmployCode).coffreOutils.get(i).getAction());
                break;
            }
        }
        return action;
    }
}
