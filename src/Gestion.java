import metier.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private List<Coureur> listeCoureurs = new ArrayList<>();
    private List<Classement> listeClassement = new ArrayList<>();
    private List<Course> listeCourse = new ArrayList<>();

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        String liste = "" +
                "\t1 - Liste des coureurs,place et gain " + "" +
                "\n\t2 - Gain total d'une course " + "" +
                "\n\t3 - Vainqueur d'une course " + "" +
                "\n\t4 - Ajouter un coureur dans une course " + "" +
                "\n\t5 - Supprimer un coureur de la course " + "" +
                "\n\t6 - Résulats d'une pilote en particulier " + "" +
                "\n\t7 - Modification d'un pilote en particulier" + "" +
                "\n\t8 - Ajouter une ville à une course" + "" +
                "\n\t9 - Supprimer une ville dans une course " + "" +
                "\n\t10 - Modifier une date dans une course" + "" +
                "\n\t11 - Liste des villes d'une course" + "" +
                "\n\t12 - Classement général" + "" +
                "\n\t13 - Quitter";


        int choix;
        do {
            String option;
            System.out.println("" + liste);
            option = saisieControlee("Choix ? ", "^(1[0-3]|[1-9])$");
            choix = Integer.parseInt(option);

            switch (choix) {
                case 1:
                    listeCoureurPlaceGain();
                    break;
                case 2:
                    gainTotalCourse();
                    break;
                case 3:
                    vainqueurCourse();
                    break;
                case 4:
                    ajoutCoureur();
                    break;
                case 5:
                    supprimerCoureur();
                    break;
                case 6:
                    resultatsPilote();
                    break;
                case 7:
                    modifPilote();
                    break;
                case 8:
                    ajoutVilleCourse();
                    break;
                case 9:
                    supprimerVilleCourse();
                    break;
                case 10:
                    modifDateCourse();
                    break;
                case 11:
                    listeVilleCourse();
                    break;
                case 12:
                    classementGeneral();
                    break;
                case 13:
                    System.out.println("Fin de programme ");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 13.");
            }
        } while (choix != 9);
    }

    public String saisieControlee(String texte, String regex) {

        Scanner sc = new Scanner(System.in);
        String s;
        do {
            System.out.println(texte);
            s = sc.nextLine();
            if (!s.matches(regex)) {
                System.out.println("Erreur, recommencez ");
            }
        }
        while (!s.matches(regex));


        return s;
    }


    public void listeCoureurPlaceGain() {

    }

    public void gainTotalCourse() {
        BigDecimal totalGain;
        totalGain = listeCourse.get(0).gainTotal();
        System.out.println(totalGain);
    }

    public void vainqueurCourse() {

    }

    public void ajoutCoureur() {

    }

    public void supprimerCoureur() {

    }

    public void resultatsPilote() {

    }

    public void modifPilote() {

    }

    public void ajoutVilleCourse() {

    }

    public void supprimerVilleCourse() {

    }

    public void modifDateCourse() {

    }

    public void listeVilleCourse() {

    }

    public void classementGeneral() {

    }
}

