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
    protected Infos infos;
    protected Classement classement;

    public Course(String nom, BigDecimal priceMoney, int km, Infos infos, Classement classement) {
        this.idCourse = autoId++;
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
        // renvoie une liste qui contient les trois variables
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
            totalGain = totalGain.add(a);
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
        classement.getListeCoureurs().add(coureur);
    }

    public void supCoureur(Coureur coureur) {
        classement.getListeCoureurs().remove(coureur);
    }

    public void resultat(Coureur coureur,int place,BigDecimal gain){
        classement.getListeCoureurs().add(coureur);
        classement.getPlace().add(place);
        classement.getGain().add(gain);

    }

    public void modif(Coureur coureur,int place,BigDecimal gain){

        int pos = classement.getListeCoureurs().indexOf(coureur);
        if(pos == -1){
            System.out.println("Le coureur n'est pas dans la liste");
        }
        else{
            classement.getPlace().set(pos,place);
            classement.getGain().set(pos,gain);
        }
    }

    public void addVille(Ville ville) {
        infos.getVilles().add(ville);
    }

    public void supVille(Ville ville) {
        infos.getVilles().remove(ville);
    }

    public void modifVille(LocalDate date) {
        infos.setDateDepart(date);
    }

    public List<Ville> listeVille() {
        return infos.getVilles();
    }

    public boolean classementComplet() {
        if(classement.listeCoureurs.size() == classement.place.size()){
            return true;
        }
        return false;
    }
}

