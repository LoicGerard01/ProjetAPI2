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

    public List<Coureur> listeCoureursPlaceGain(){
        // renvoyer un liste qui contient les trois variables

    }
    public void gainTotal(){
        BigDecimal sum = BigDecimal.ZERO;
    }
    public void vainqueur(){}
    public void addCoureur(Coureur coureur){}
    public void supCoureur(Coureur coureur){}
    // public void resultat(Coureur coureur,){} // on demande quel coureur a encoder sa place et ses gains
    // public void modif(Coureur coureur,){}
    public void addVille(Ville ville){}
    public void supVille(Ville ville){}
    public void modifVille(LocalDate date){

    }
    public void listeVille(){}
    public boolean classementComplet(){

        return false;
    }
}
