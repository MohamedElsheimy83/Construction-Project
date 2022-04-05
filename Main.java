package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Ouvrier> ouvriersListe = new ArrayList<>();
    static ArrayList<Outil> outilsListe = new ArrayList<>();
    static ArrayList<Metier> metiersListe = new ArrayList<>();
    static ArrayList<Chantier> chantiersListe = new ArrayList<>();
    static ArrayList<Statut> statutsListe = new ArrayList<>();

    /**
     * Procedure principale qui est où le logiciel démarre.
     * @param args Options passées au logiciel: aucune option n'est traitée.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Metier metiers;
        Statut statuts = new Statut();
        Chantier chantiers = new Chantier();
        Ouvrier ouvriers = new Ouvrier();
        Outil outils = new Outil();
        int choix = -1;
        boolean fin = false;
        int numeroEmploye = 0;
        double coutTotal = 0;
        int nombre_chantier = 0;
        int codeChantier = 0;
        int codeOutil = 0;
        int comptVerification = 0;
        String codeStatut = "";

        remplirOutilsListe();
        remplirMetiersListe();
        remplirStatutsList();
        remplirChantiersListe();
        remplirOuviersListe();

        do {
            afficherMenu();   // Afficher le menu principal
            if (scan.hasNextInt()) {
                choix = scan.nextInt();
            }
            scan.nextLine();//Vider le tampon

            switch (choix) {

                case 0:
                    fin = true;
                    break;

                case 1:    //Affiche la liste des ouvriers & le nombre d'ouvriers

                    System.out.println("La liste des ouvriers: ");
                    for (int i = 0; i < ouvriersListe.size(); i++) {
                        System.out.println(ouvriersListe.get(i).afficherOuvrier());
                        System.out.print("Coffre a outil: ");
                        for (int j = 0; j < ouvriersListe.get(i).coffreOutils.size(); j++) {
                            System.out.print(ouvriersListe.get(i).coffreOutils.get(j).getNomOutil() + "  ");
                        }
                        System.out.println('\n');
                    }
                    System.out.println("Nombre d'ouvriers: " + Ouvrier.nbrOuvriers);
                    choix = -1; //reinitialiser le choix du menu
                    break;

                case 2:    //Affiche la liste des metiers & le nombre de metiers

                    System.out.println("La liste des metiers: ");
                    for (int i = 0; i < metiersListe.size(); i++) {
                        System.out.println(metiersListe.get(i).afficherMetier());
                    }
                    System.out.println("Nombre de metiers: " + Metier.nbrMetiers);
                    choix = -1; //reinitialiser le choix du menu
                    break;

                case 3:    //Affiche la liste des chantiers & le nombre de chantiers

                    System.out.println("La liste des chantiers: ");
                    for (int i = 0; i < chantiersListe.size(); i++) {
                        System.out.println(chantiersListe.get(i).afficherChantier());
                    }
                    System.out.println("Nombre des chantiers: " + Chantier.nbrChantiers);
                    choix = -1; //reinitialiser le choix du menu
                    break;

                case 4:    //Affiche la liste des outils & le nombre d'outils

                    System.out.println("La liste des outils: ");
                    for (int i = 0; i < outilsListe.size(); i++) {
                        System.out.println(outilsListe.get(i).afficherOutil());
                    }
                    System.out.println("Nombre d'outils: " + Outil.nbrOutils);
                    choix = -1; //reinitialiser le choix du menu
                    break;

                case 5:    //Afficher la liste des statuts & le nombre de statuts

                    System.out.println("La liste des statuts: ");
                    for (int i = 0; i < statutsListe.size(); i++) {
                        System.out.println(statutsListe.get(i).afficherStatut());
                    }
                    System.out.println("Nombre de statuts: " + Statut.nbrStatuts);
                    choix = -1; //reinitialiser le choix du menu
                    break;

                case 6:    //Afficher la liste des outils d'un ouvrier

                    System.out.print("Entrez le numero d'employe SVP: ");
                    if (scan.hasNextInt()) {
                        numeroEmploye = scan.nextInt();
                    }
                    scan.nextLine(); //Vider le tampon

                    for (int i = 0; i < ouvriersListe.size(); i++) {
                        if (ouvriersListe.get(i).getnumeroEmploye() == numeroEmploye) {
                            System.out.println("Liste des outils de " + ouvriersListe.get(i).getNomOuvrier());
                            for (int j = 0; j < ouvriersListe.get(i).coffreOutils.size(); j++) {
                                System.out.println("Nom: " + ouvriersListe.get(i).coffreOutils.get(j).getNomOutil() +
                                        ", Cout: " + ouvriersListe.get(i).coffreOutils.get(j).getCout());
                                coutTotal = coutTotal + ouvriersListe.get(i).coffreOutils.get(j).getCout();
                            }
                        }
                    }
                    if (coutTotal > 0) {
                        System.out.println("Cout total: " + coutTotal + "$");
                        coutTotal = 0;
                    } else System.out.println("Le numero n'exitse pas");

                    //reinitialiser les variables
                    numeroEmploye = 0;
                    choix = -1;
                    break;

                case 7:    //Afficher la liste des ouvriers d'un chantier specifique

                    System.out.print("Entrez le code du chantier SVP: ");
                    if (scan.hasNextInt()) {
                        codeChantier = scan.nextInt();
                    }
                    scan.nextLine();   //Vider le tampon
                    for (int i = 0; i < chantiersListe.size(); i++) {
                        if (chantiersListe.get(i).getCodeChantier() == codeChantier) {
                            System.out.println("Liste des ouvriers du chantier " + chantiersListe.get(i).getNomChantier());
                            for (int j = 0; j < chantiersListe.get(i).ouvrier.size(); j++) {
                                System.out.println("Numero: " + chantiersListe.get(i).ouvrier.get(j).getnumeroEmploye() +
                                        ", Nom: " + chantiersListe.get(i).ouvrier.get(j).getNomOuvrier() +
                                        ", Metier: " + chantiersListe.get(i).ouvrier.get(j).getMetier().getNomMetier());
                                nombre_chantier++;
                            }
                            System.out.println("Nombre d'ouvriers sur ce chantier: " + nombre_chantier);
                        }
                    }
                    if (nombre_chantier == 0) System.out.println("Le code n'exitse pas");

                    //reinitialiser les variables
                    codeChantier = 0;
                    nombre_chantier = 0;
                    choix = -1;
                    break;

                case 8:    //Demander a un ouvrier d'utiliser un outil

                    System.out.print("Entrez le numero d'ouvrier SVP: ");
                    if (scan.hasNextInt()) {
                        numeroEmploye = scan.nextInt();
                    }
                    scan.nextLine();   //Vider le tampon

                    //Verifier le numero d'employe
                    comptVerification = ouvriers.verifierOuvrier(numeroEmploye);
                    if (comptVerification == 0) {
                        //reinitialiser les variables
                        numeroEmploye = 0;
                        choix = -1;
                        break;
                    }
                    System.out.print("Entrez le code d'outil SVP: ");
                    if (scan.hasNextInt()) {
                        codeOutil = scan.nextInt();
                    }
                    scan.nextLine();    //Vider le tampon

                    //Verifier le code d'outil et que l'outil existe dans le cofrre d'ouvrier
                    comptVerification = ouvriers.utiliserOutil(codeOutil);
                    if (comptVerification == 0) {
                        //reinitialiser les variables
                        numeroEmploye = 0;
                        choix = -1;
                        codeOutil = 0;
                        break;
                    }
                    for (int i = 0; i < ouvriersListe.get(ouvriers.indexEmployeCode()).coffreOutils.size(); i++) {
                        if (ouvriersListe.get(ouvriers.indexEmployeCode()).coffreOutils.get(i).getCodeOutil() == codeOutil) {
                            System.out.println(ouvriersListe.get(ouvriers.indexEmployeCode()).getNomOuvrier() +
                                    " " + outils.activer(ouvriers.indexEmployeCode(), codeOutil) +
                                    " avec la/le/l': " + ouvriersListe.get(ouvriers.indexEmployeCode()).coffreOutils.get(i).getNomOutil());

                            //reinitialiser les variables
                            numeroEmploye = 0;
                            choix = -1;
                            codeOutil = 0;
                            break;
                        }
                    }
                    break;

                case 9:    //Modifier le statut d'un chantier specifique

                    System.out.print("Entrez le code du chantier SVP: ");
                    if (scan.hasNextInt()) {
                        codeChantier = scan.nextInt();
                    }
                    scan.nextLine();    //Vider le tampon
                    comptVerification = 0;

                    //Verifier le code du chantier
                    comptVerification = chantiers.verifierChantier(codeChantier);
                    if (comptVerification == 0) {
                        // reinitialiser les variables
                        codeChantier = 0;
                        choix = -1;
                        break;
                    }
                    System.out.print("Entrez le code du nouveau statut SVP:" + '\n' +
                            " O pour statut (Ouvert)" + '\n' +
                            " C pour statut (Complete)" + '\n' +
                            " P pour statut (Planification)" + '\n' +
                            "Votre choix: ");
                    codeStatut = scan.nextLine();
                    codeStatut = codeStatut.toUpperCase();

                    //Verifier le statut du chantier
                    comptVerification = statuts.verifierStatut(codeStatut);
                    if (comptVerification == 0) {
                        System.out.println("le code du nouveau statut n'existe pas");

                        // reinitialiser les variables
                        codeChantier = 0;
                        codeStatut = "";
                        choix = -1;
                        break;
                    }
                    System.out.print("Chantier " + chantiersListe.get(chantiers.indexChantierCode()).getNomChantier() +
                            " : ancien statut : " + chantiersListe.get(chantiers.indexChantierCode()).getStatut().getStatutEtiquette() +
                            '\n' + "                 nouveau statut : ");
                    statuts.modifierStatut(chantiers.indexChantierCode());
                    System.out.println(chantiersListe.get(chantiers.indexChantierCode()).getStatut().getStatutEtiquette());

                    // reinitialiser les variables
                    codeChantier = 0;
                    codeStatut = "";
                    choix = -1;
                    break;

                default:

                    System.out.println("Votre choix n'est pas valide");
            }
        } while (!fin);

        System.out.println("Fin du program");

    } // Methode main

    /**
     * Procedure qui affiche le menu principal.
     */
    public static void afficherMenu() {
        System.out.println("*****Menu principal*****");
        System.out.println("0 : Terminer");
        System.out.println("1 : Afficher la liste des ouvriers");
        System.out.println("2 : Afficher la liste des metiers");
        System.out.println("3 : Afficher la liste des chantiers");
        System.out.println("4 : Afficher la liste des outils");
        System.out.println("5 : Afficher la liste des statuts");
        System.out.println("6 : Afficher la liste des outils d'un employe");
        System.out.println("7 : Afficher la liste des ouvriers d'un chantier");
        System.out.println("8 : Demander a un ouvrier d'utiliser un outil");
        System.out.println("9 : Modifier le statut d'un chantier");
        System.out.println("*************************************************");
        System.out.print("Entrez votre choix: ");
    }

    /**
     * Procedure qui remplit la liste des outils.
     */
    public static void remplirOutilsListe() {
        Outil outil;
        outil = new Outil("Tournevis", 100, 10.00, "visse et devisse");
        outilsListe.add(outil);
        outil = new Outil("Pince", 200, 15.00, "serre");
        outilsListe.add(outil);
        outil = new Outil("Marteau", 300, 25.00, "cloue et arrache");
        outilsListe.add(outil);
        outil = new Outil("Scie", 400, 30.00, "scie");
        outilsListe.add(outil);
        outil = new Outil("Perceuse", 500, 75.00, "perce et troue");
        outilsListe.add(outil);
        outil = new Outil("Clouseuse", 600, 100.00, "cloue");
        outilsListe.add(outil);
        outil = new Outil("Chalumeau", 700, 50.00, "chauffe");
        outilsListe.add(outil);
        outil = new Outil("Exacto", 800, 15.00, "coupe");
        outilsListe.add(outil);
    }

    /**
     * Procedure qui remplit la liste des metiers.
     */
    public static void remplirMetiersListe() {
        Metier metier;
        metier = new Metier("Electricien", 'E', "FTQ");
        metiersListe.add(metier);
        metier = new Metier("Plombier", 'P', "CSN");
        metiersListe.add(metier);
        metier = new Metier("Charpentier", 'C', "FTQ");
        metiersListe.add(metier);
    }

    /**
     * Procedure qui remplit la liste des statuts.
     */
    public static void remplirStatutsList() {
        Statut statut;
        statut = new Statut("Ouvert", "O");
        statutsListe.add(statut);
        statut = new Statut("Complete", "C");
        statutsListe.add(statut);
        statut = new Statut("Planification", "P");
        statutsListe.add(statut);
    }

    /**
     * Procedure qui remplit la liste des chantiers.
     */
    public static void remplirChantiersListe() {
        Chantier chantier;
        Statut statut;

        //chantier1
        statut = new Statut();
        statut.setStatutEtiquette(statutsListe.get(0).getStatutEtiquette());
        chantier = new Chantier("REM", 01, "rue McGill");
        chantier.setStatut(statut);
        chantiersListe.add(chantier);

        //chantier2
        statut = new Statut();
        statut.setStatutEtiquette(statutsListe.get(0).getStatutEtiquette());
        chantier = new Chantier("Metro", 02, "rue Mount-Royal");
        chantier.setStatut(statut);
        chantiersListe.add(chantier);

        //chantier3
        statut = new Statut();
        statut.setStatutEtiquette(statutsListe.get(0).getStatutEtiquette());
        chantier = new Chantier("Centre Bell", 03, "boul. Rene-Levesque");
        chantier.setStatut(statut);
        chantiersListe.add(chantier);

    }

    /**
     * Procedure qui remplit la liste des ouvriers.
     */
    public static void remplirOuviersListe() {
        Ouvrier ouvrier;
        Chantier chantier;

        //ouvrier1
        chantier = new Chantier();
        chantier.setNomChantier(chantiersListe.get(0).getNomChantier());
        ouvrier = new Ouvrier("Roger", 1001, metiersListe.get(0), 50.00, 12);
        ouvrier.setChantier(chantier);
        ouvriersListe.add(ouvrier);

        //ouvrier2
        chantier = new Chantier();
        chantier.setNomChantier(chantiersListe.get(1).getNomChantier());
        ouvrier = new Ouvrier("Jonathan", 1002, metiersListe.get(0), 40.00, 7);
        ouvrier.setChantier(chantier);
        ouvriersListe.add(ouvrier);

        //ouvrier3
        chantier = new Chantier();
        chantier.setNomChantier(chantiersListe.get(0).getNomChantier());
        ouvrier = new Ouvrier("Amanda", 2001, metiersListe.get(1), 55.00, 15);
        ouvrier.setChantier(chantier);
        ouvriersListe.add(ouvrier);

        //ouvrier4
        chantier = new Chantier();
        chantier.setNomChantier(chantiersListe.get(2).getNomChantier());
        ouvrier = new Ouvrier("Dave", 1003, metiersListe.get(2), 45.00, 9);
        ouvrier.setChantier(chantier);
        ouvriersListe.add(ouvrier);

        //ajouter la liste des outils pour chaque ouvrier
        ouvriersListe.get(0).coffreOutils.add(outilsListe.get(0));
        ouvriersListe.get(0).coffreOutils.add(outilsListe.get(1));
        ouvriersListe.get(0).coffreOutils.add(outilsListe.get(2));
        ouvriersListe.get(0).coffreOutils.add(outilsListe.get(7));
        ouvriersListe.get(1).coffreOutils.add(outilsListe.get(0));
        ouvriersListe.get(1).coffreOutils.add(outilsListe.get(1));
        ouvriersListe.get(1).coffreOutils.add(outilsListe.get(3));
        ouvriersListe.get(1).coffreOutils.add(outilsListe.get(7));
        ouvriersListe.get(2).coffreOutils.add(outilsListe.get(3));
        ouvriersListe.get(2).coffreOutils.add(outilsListe.get(1));
        ouvriersListe.get(2).coffreOutils.add(outilsListe.get(6));
        ouvriersListe.get(3).coffreOutils.add(outilsListe.get(3));
        ouvriersListe.get(3).coffreOutils.add(outilsListe.get(4));
        ouvriersListe.get(3).coffreOutils.add(outilsListe.get(5));
        ouvriersListe.get(3).coffreOutils.add(outilsListe.get(2));

        // ajouter les ouvriers a la liste des chantiers
        chantiersListe.get(0).ajouterOuvrier(ouvriersListe.get(0));
        chantiersListe.get(0).ajouterOuvrier(ouvriersListe.get(2));
        chantiersListe.get(1).ajouterOuvrier(ouvriersListe.get(1));
        chantiersListe.get(2).ajouterOuvrier(ouvriersListe.get(3));
    }
}//Class Main
