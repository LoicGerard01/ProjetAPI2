package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Classement {
    protected int idClassement;
    protected List<Integer> place;
    protected List<BigDecimal> gain;
    protected List<Coureur> listeCoureurs = new ArrayList<>();

    public Classement(int idClassement){
        this.idClassement = idClassement;
    }


    public Classement(int idClassement, List<Integer> place, List<BigDecimal> gain, List<Coureur> listeCoureurs) {
        this.idClassement = idClassement;
        this.place = place;
        this.gain = gain;
        this.listeCoureurs = listeCoureurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classement that = (Classement) o;
        return idClassement == that.idClassement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClassement);
    }

    public int getIdClassement() {
        return idClassement;
    }

    public void setIdClassement(int idClassement) {
        this.idClassement = idClassement;
    }

    public List<Integer> getPlace() {
        return place;
    }

    public void setPlace(List<Integer> place) {
        this.place = place;
    }

    public List<BigDecimal> getGain() {
        return gain;
    }

    public void setGain(List<BigDecimal> gain) {
        this.gain = gain;
    }

    public List<Coureur> getListeCoureurs() {
        return listeCoureurs;
    }

    public void setListeCoureurs(List<Coureur> listeCoureurs) {
        this.listeCoureurs = listeCoureurs;
    }

    @Override
    public String toString() {
        return "Classement{" +
                "idClassement=" + idClassement +
                ", place=" + place +
                ", gain=" + gain +
                ", listeCoureurs=" + listeCoureurs +
                '}';
    }
}
