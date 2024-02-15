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

    public List<CoureurPlaceGain> listeCoureursPlaceGain(){
        // renvoyer un liste qui contient les trois variables
       List<CoureurPlaceGain> CPG = new ArrayList<>();

       for(int i=0;i<classement.listeCoureurs.size();i++){
           Coureur coureur = classement.listeCoureurs.get(i);
           int place = classement.place[i];
           BigDecimal gain = classement.gain[i];

           CPG.add(new CoureurPlaceGain(coureur,place,gain));
       }
       return CPG;
    }

    public BigDecimal gainTotal(){

        BigDecimal sum = BigDecimal.TWO;

        if (classement != null && classement.gain != null) {
            for (BigDecimal a : classement.gain) {
                if (a != null) {
                    sum = sum.add(a);  // Ajoutez la valeur actuelle à la somme
                }
            }
        }
        return sum;
    }
    public Coureur vainqueur(){
        Coureur vainqueur ;

        for (int i = 0 ;i<this.classement.place.length;i++){
            if (this.classement.place[i] == 1){
                vainqueur = this.classement.listeCoureurs.get(i);
                return vainqueur;
            }
        }
        return null;
    }




    public void addCoureur(Coureur coureur){
        this.addCoureur(coureur);
    }
    public void supCoureur(Coureur coureur){}

    // public void resultat(Coureur coureur,int place,BigDecimal gain){} // on demande quel coureur a encoder sa place et ses gains

    // public void modif(Coureur coureur,int place,BigDecimal gain){}

    public void addVille(Ville ville){
        this.addVille(ville);
    }
    public void supVille(Ville ville){

    }
    public void modifVille(LocalDate date){

    }
    public void listeVille(){}
    public boolean classementComplet(){

        return false;
    }
}
