package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course {
    private static int autoId = 1;
    protected int idCourse;
    protected String nom;
    protected BigDecimal priceMoney;
    protected int km;
    protected List<Infos> listeInfos;
    protected List<Classement> listeClassement;

    public Course(String nom, BigDecimal priceMoney, int km, List<Infos> infos, List<Classement> classement) {
        this.idCourse = autoId++;
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.km = km;
        this.listeInfos = infos;
        this.listeClassement = classement;
    }

    public Course(String nom, BigDecimal priceMoney, int km) {
        this.idCourse = autoId++;
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.km = km;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public List<Infos> getListeInfos() {
        return listeInfos;
    }

    public void setListeInfos(List<Infos> listeInfos) {
        this.listeInfos = listeInfos;
    }

    public List<Classement> getListeClassement() {
        return listeClassement;
    }

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


    public List<CoureurPlaceGain> listeCoureursPlaceGain() {
        // renvoie une liste qui contient les trois variables
        List<CoureurPlaceGain> CPG = new ArrayList<>();

        for (int i = 0; i < listeClassement.size(); i++) {
            Coureur coureur = listeClassement.get(i).getCoureur();
            int place = listeClassement.get(i).getPlace();
            BigDecimal gain = listeClassement.get(i).getGain();

            CPG.add(new CoureurPlaceGain(coureur, place, gain));
        }
        return CPG;
    }

    public BigDecimal gainTotal() {

        BigDecimal a = BigDecimal.ZERO;
        BigDecimal totalGain = BigDecimal.ZERO;

        for (int i = 0; i < listeClassement.size(); i++) {
            a = listeClassement.get(i).gain;
            totalGain = totalGain.add(a);
        }

        return totalGain;
    }

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


    public void addCoureur(Coureur coureur) {
        listeClassement.add(new Classement(coureur));
    }

    public void supCoureur(Coureur coureur) {
        listeClassement.remove(coureur);
    }

    public void resultat(Coureur coureur, int place, BigDecimal gain) {
        listeClassement.add(new Classement(place, gain, coureur));

    }

    public void modif(Coureur coureur, int place, BigDecimal gain) {

        int pos = listeClassement.indexOf(coureur);
        if (pos == -1) {
            System.out.println("Le coureur n'est pas dans la liste");
        } else {
            listeClassement.get(pos).setPlace(place);
            listeClassement.get(pos).setGain(gain);
        }
    }

    public void addVille(Ville ville) {
        listeInfos.add(new Infos(ville));
    }

    public void supVille(Ville ville) {
        listeInfos.remove(ville);
    }

    public void modifVille(LocalDate date,Ville ville) {
        for(int i = 0;i<listeInfos.size();i++){
           if(listeInfos.get(i).getDateDepart().equals(date)){
               listeInfos.get(i).setVille(ville);
           }
        }
    }

    public List<Ville> listeVille() {
        List<Ville> lville = new ArrayList<>();
        for (int i = 0; i < listeInfos.size(); i++) {
            lville.add(listeInfos.get(i).getVille());
        }
        return lville;
    }

    public boolean classementComplet() {
        int i = 0;
        do {
            if (listeClassement.get(i).getPlace() == 0) {
                return false;
            }
        } while (i < listeClassement.size());

        return true;

    }
}

