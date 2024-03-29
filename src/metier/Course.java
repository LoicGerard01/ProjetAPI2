package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * classe métier de gestion d'une course
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Infos
 * @see Classement
 */
public class Course {
    private static int autoId = 1;
    /**
     * identifiant de la course.
     */
    protected int idCourse;
    /**
     * nom de la course.
     */
    protected String nom;
    /**
     * prix de la course ( gains ).
     */
    protected BigDecimal priceMoney;
    /**
     * longueur de la course en km
     */
    protected Integer km;
    /**
     * liste des infos sur la course.
     */
    protected List<Infos> listeInfos = new ArrayList<>();
    /**
     * liste des classement concernant la course.
     */
    protected List<Classement> listeClassement = new ArrayList<>();

    /**
     * constructeur paramétré.
     *
     * @param nom        nom
     * @param priceMoney price money
     * @param km         km
     */
    public Course(String nom, BigDecimal priceMoney, int km) {
        this.idCourse = autoId++;
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.km = km;
    }

    /**
     * getter nom.
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom.
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter price money.
     *
     * @return price money
     */
    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    /**
     * setter price money.
     *
     * @param priceMoney price money
     */
    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    /**
     * getter km.
     *
     * @return km
     */
    public int getKm() {
        return km;
    }

    /**
     * setter km.
     *
     * @param km km
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * getter liste infos.
     *
     * @return liste infos
     */
    public List<Infos> getListeInfos() {
        return listeInfos;
    }

    /**
     * setter liste infos.
     *
     * @param listeInfos liste infos
     */
    public void setListeInfos(List<Infos> listeInfos) {
        this.listeInfos = listeInfos;
    }

    /**
     * getter liste classement.
     *
     * @return liste classement
     */
    public List<Classement> getListeClassement() {
        return listeClassement;
    }

    /**
     * setter classement.
     *
     * @param listeClassement liste classement
     */
    public void setClassement(List<Classement> listeClassement) {
        this.listeClassement = listeClassement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return idCourse == course.idCourse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse);
    }


    /**
     * Liste coureurs place gain list.
     * <p>
     * cette méthode récupère l'intégralité des coureurs inscrits dans une course ainsi que leurs positions et leurs gains
     * les données sont stockées dans une liste CPG de type CoureurPlaceGain et celle-ci est renvoyée à la fin de la fonction
     *
     * @return liste cpg
     */
    public List<CoureurPlaceGain> listeCoureursPlaceGain() {

        List<CoureurPlaceGain> CPG = new ArrayList<>();

        for (int i = 0; i < listeClassement.size(); i++) {
            Coureur coureur = listeClassement.get(i).getCoureur();
            int place = listeClassement.get(i).getPlace();
            BigDecimal gain = listeClassement.get(i).getGain();

            CPG.add(new CoureurPlaceGain(coureur, place, gain));
        }
        return CPG;
    }

    /**
     * Gain total big decimal.
     * <p>
     * cette méthode calcule le total des gains remportés lors d'une course
     * la somme est renvoyée au format BigDecimal
     *
     * @return BigDecimal totalGain
     */
    public BigDecimal gainTotal() {

        BigDecimal a = BigDecimal.ZERO;
        BigDecimal totalGain = BigDecimal.ZERO;

        for (int i = 0; i < listeClassement.size(); i++) {
            a = listeClassement.get(i).gain;
            totalGain = totalGain.add(a);
        }

        return totalGain;
    }

    /**
     * Vainqueur coureur.
     * <p>
     * cette méthode parcours le classement de la course et renvoie le coureur situé en première position
     * si aucun coureur n'est situé à la première position , 'null' est renvoyé.
     *
     * @return Coureur
     */
    public Coureur vainqueur() {
        Coureur vainqueur;

        for (int i = 0; i < listeClassement.size(); i++) {
            if (listeClassement.get(i).getPlace() == 1) {
                vainqueur = listeClassement.get(i).getCoureur();
                return vainqueur;
            }
        }
        System.out.println("Vainqueur non trouvé");
        return null;
    }


    /**
     * Add coureur.
     * <p>
     * cette méthode reçoit un coureur en paramètre et l'ajoute dans la liste des classements
     *
     * @param coureur coureur
     */
    public void addCoureur(Coureur coureur) {
        listeClassement.add(new Classement(coureur));
    }

    /**
     * Sup coureur.
     * <p>
     * cette méthode reçoit un coureur en paramètre et le supprime de la liste des classements
     * renvoie true si l'opération a pu être réalisée.
     *
     * @param coureur coureur
     */
    public boolean supCoureur(Coureur coureur) {
        boolean trouve = false;
        for(int i=0;i<listeClassement.size();i++){
            Classement classement = listeClassement.get(i);
            if(classement.getCoureur().equals(coureur)){
                listeClassement.remove(i);
                trouve = true;
            }
        }
        return trouve;
    }

    /**
     * Resultat.
     * <p>
     * cette méthode reçoit en paramètre un coureur, sa place et ses gains
     * elle ajoute ensuite un nouveau classement dans la liste composé de ces données
     *
     * @param coureur coureur
     * @param place   place
     * @param gain    gain
     */
    public void resultat(Coureur coureur, int place, BigDecimal gain) {
        listeClassement.add(new Classement(place, gain, coureur));

    }

    /**
     * Modif.
     * <p>
     * cette méthode reçoit en paramètre un coureur, sa nouvelle place et ses nouveaux gains
     * elle parcourt la liste des classement pour trouver le coureur
     * si le coureur est trouvé les anciennes données (place et gain) sont remplacées par les nouvelles données
     * renvoie true si l'opération a pu être réalisé, ou false si le coureur n'a pas été trouvé.
     *
     * @param coureur coureur
     * @param place   place
     * @param gain    gain
     */
    public boolean modif(Coureur coureur, int place, BigDecimal gain) {
        boolean trouve = false;
        for(int i=0;i<listeClassement.size();i++){
            Classement classement = listeClassement.get(i);
            if(classement.getCoureur().equals(coureur)){
                listeClassement.get(i).setPlace(place);
                listeClassement.get(i).setGain(gain);
                trouve = true;
            }
        }
        return trouve;
    }

    /**
     * Add ville.
     * <p>
     * cette méthode reçoit une ville en paramètre et l'ajoute à la liste d'infos
     *
     * @param ville ville
     */
    public void addVille(Ville ville) {
        listeInfos.add(new Infos(ville));
    }

    /**
     * Sup ville.
     * <p>
     * cette méthode reçoit une ville en paramètre et supprime la ville de la liste d'infos
     * renvoie true si l'opération a pu être réalisée.
     *
     * @param ville ville
     */
    public boolean supVille(Ville ville) {
        boolean trouve = false;

        for(int i=0;i<listeInfos.size();i++){
            Infos infos = listeInfos.get(i);
            if(infos.getVille().equals(ville)){
                listeInfos.remove(i);
                trouve = true;
            }
        }
        return trouve;
    }

    /**
     * Modif ville.
     * <p>
     * cette méthode reçoit en paramètre une ville et une nouvelle date
     * elle recherche ensuite la ville correspondante et remplace l'ancienne date par la nouvelle
     * renvoie true si l'opération a pu être réalisée.
     *
     * @param date  date
     * @param ville ville
     */
    public boolean modifVille(LocalDate date, Ville ville) {
        boolean trouve = false;
        for (int i = 0; i < listeInfos.size(); i++) {
            if(listeInfos.get(i).getVille().equals(ville)){
                listeInfos.get(i).setDateDepart(date);
                trouve = true;
            }
        }
        return trouve;
    }
    /**
     * Liste ville.
     * <p>
     * cette méthode récupère toutes les villes enregistrées dans la liste d'infos,
     * les stock dans une liste de Ville et renvoie ensuite cette liste.
     *
     * @return list Ville
     */
    public List<Ville> listeVille() {
        List<Ville> lville = new ArrayList<>();
        for (int i = 0; i < listeInfos.size(); i++) {
            lville.add(listeInfos.get(i).getVille());
        }
        return lville;
    }

    /**
     * Classement complet boolean.
     * <p>
     * cette méthode vérifie que dans chaque classement , tout les coureurs ont une position attribuée.
     * un coureur ayant 0 comme place signifie que sa place n'a pas été modifié depuis son ajout
     * renvoie vrai si tout les coureurs ont une place
     * sinon renvoie faux
     *
     * @return boolean
     */
    public boolean classementComplet() {
        int i = 0;
        do {
            if (listeClassement.get(i).getPlace() == 0) {
                return false;
            }
        } while (i < listeClassement.size());

        return true;

    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", nom='" + nom + '\'' +
                ", priceMoney=" + priceMoney +
                ", km=" + km +
                ", listeInfos=" + listeInfos +
                ", listeClassement=" + listeClassement +
                '}';
    }
}

