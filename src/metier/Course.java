package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course {
    protected int idCourse;
    protected String nom;
    protected BigDecimal priceMoney;
    protected int km;
    protected Infos infos;
    protected Classement classement;

    public Course(String nom, BigDecimal priceMoney, int km, Infos infos, Classement classement) {
        this.nom = nom;
        this.priceMoney = priceMoney;
        priceMoney.setScale(2, RoundingMode.HALF_UP);
        this.km = km;
        this.infos = infos;
        this.classement = classement;
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

    public Infos getInfos() {
        return infos;
    }

    public void setInfos(Infos infos) {
        this.infos = infos;
    }

    public Classement getClassement() {
        return classement;
    }

    public void setClassement(Classement classement) {
        this.classement = classement;
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
        // renvoyer un liste qui contient les trois variables
        List<CoureurPlaceGain> CPG = new ArrayList<>();

        for (int i = 0; i < classement.listeCoureurs.size(); i++) {
            Coureur coureur = classement.listeCoureurs.get(i);
            int place = classement.place.get(i);
            BigDecimal gain = classement.gain.get(i);

            CPG.add(new CoureurPlaceGain(coureur, place, gain));
        }
        return CPG;
    }

    public BigDecimal gainTotal() {

        BigDecimal totalGain = BigDecimal.ZERO;

        for (BigDecimal a : classement.gain) {
            if (a != null) {
                totalGain = totalGain.add(a);  // Ajoute la valeur actuelle à la somme
            }
        }

        return totalGain;
    }

    public Coureur vainqueur() {
        Coureur vainqueur;

        for (int i = 0; i < this.classement.place.size(); i++) {
            if (this.classement.place.get(i) == 1) {
                vainqueur = this.classement.listeCoureurs.get(i);
                return vainqueur;
            }
        }
        System.out.println("Vainqueur non trouvé");
        return null;
    }


    public void addCoureur(Coureur coureur) {
        this.classement.listeCoureurs.add(coureur);
    }

    public void supCoureur(Coureur coureur) {
        this.classement.listeCoureurs.remove(coureur);
    }

    public void resultat(Coureur coureur,int place,BigDecimal gain){
        classement.listeCoureurs.add(coureur);
        classement.place.add(place);
        classement.gain.add(gain);

    }

    public void modif(Coureur coureur,int place,BigDecimal gain){

    }

    public void addVille(Ville ville) {
        this.infos.villes.add(ville);
    }

    public void supVille(Ville ville) {
        this.infos.villes.remove(ville);
    }

    public void modifVille(LocalDate date) {

    }

    public List<Ville> listeVille() {
        return this.infos.getVilles();
    }

    public boolean classementComplet() {

        return false;
    }
}
