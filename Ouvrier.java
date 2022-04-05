package tp1;

import java.util.ArrayList;

public class Ouvrier {
    private String nomOuvrier;
    private int numeroEmploye;
    private Metier metier;
    private double tauxHoraire;
    private int experience;
    private Chantier chantier;
    ArrayList<Outil> coffreOutils;
    static int nbrOuvriers;
    int comptVerification = 0;
    int comptVerificationOutil = 0;
    int indexEmployeCode = 0;

    Ouvrier() {

    }

    Ouvrier(String nomOuvrier, int numeroEmploye, Metier metier, double tauxHoraire, int experience) {
        this();
        this.nomOuvrier = nomOuvrier;
        this.numeroEmploye = numeroEmploye;
        this.metier = metier;
        this.tauxHoraire = tauxHoraire;
        this.experience = experience;
        coffreOutils = new ArrayList<>();
        nbrOuvriers++;
    }

    public String getNomOuvrier() {
        return nomOuvrier;
    }

    public void setNomOuvrier(String nomOuvrier) {
        this.nomOuvrier = nomOuvrier;
    }

    public int getnumeroEmploye() {
        return numeroEmploye;
    }

    public void setnumeroEmploye(int numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    /**
     * methode qui affiche les informations relatives a l'objet.
     * @return chaine de caracteres contenant les attributs relatives a l'objet.
     */
    public String afficherOuvrier() {
        return "Nom: " + nomOuvrier +
                ", Numero: " + numeroEmploye +
                ", Code Metier: " + metier.getCodeMetier() +
                ", Taux horaire: " + tauxHoraire + "$" +
                ", Experience: " + experience + " ans" +
                ", Chantier: " + chantier.getNomChantier();
    }

    /**
     * methode qui verifier le code d'un ouvrier.
     * @param codeEmploye
     * @return comptVerification.
     */
    public int verifierOuvrier(int codeEmploye) {
        comptVerification = 0;
        for (int i = 0; i < Main.ouvriersListe.size(); i++) {
            if (Main.ouvriersListe.get(i).numeroEmploye == codeEmploye) {
                indexEmployeCode = i;
                comptVerification++;
            }
        }
        if (comptVerification == 0) {
            System.out.println("Le numero d'ouvrier n'existe pas");
            comptVerification = 0;
        }
        return comptVerification;
    }

    /**
     * methode qui retourne l'index d'un ouvrier dans la liste des ouvriers.
     * @return indexChantierCode.
     */
    public int indexEmployeCode() {
        return indexEmployeCode;
    }

    /**
     * methode qui verifier le code d'un outil et assurer que cet outil faire partie du coffre d'un ouvrier.
     * @return comptVerification.
     */
    public int utiliserOutil(int codeOutil) {
        comptVerification = 0;
        comptVerificationOutil = 0;

        //verifier le code d'un outil
        for (int i = 0; i < Main.ouvriersListe.size(); i++) {
            for (int j = 0; j < Main.ouvriersListe.get(i).coffreOutils.size(); j++)
                if (Main.ouvriersListe.get(i).coffreOutils.get(j).getCodeOutil() == codeOutil) {
                    comptVerification++;
                }
        }
        if (comptVerification == 0) {
            System.out.println("Le code d'outil n'existe pas");
            comptVerification = 0;
        }

        //Verifier que cet outil faire partie du coffre d'un ouvrier
        if (comptVerification != 0) {
            for (int x = 0; x < Main.ouvriersListe.get(indexEmployeCode).coffreOutils.size(); x++) {
                if (Main.ouvriersListe.get(indexEmployeCode).coffreOutils.get(x).getCodeOutil() == codeOutil)
                    comptVerificationOutil++;
            }
            if (comptVerificationOutil == 0) {
                System.out.println("L'outil n'existe pas dans le coffre a outils de cet ouvrier");
                comptVerification = 0;
            }
        }
        return comptVerification;
    }
}
