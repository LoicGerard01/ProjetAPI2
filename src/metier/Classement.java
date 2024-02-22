package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Classement {
    private static int autoId = 1;
    protected int idClassement;
    protected int place = 0;
    protected BigDecimal gain;
    protected Coureur coureur;

    public Classement(){
        this.idClassement = autoId++;
    }
    public Classement(Coureur coureur){
        this.idClassement = autoId++;
        this.coureur = coureur;
    }

    public Classement(int place, BigDecimal gain, Coureur coureur) {
        this.idClassement = autoId++;
        this.place = place;
        this.gain = gain;
        this.coureur = coureur;
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

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public BigDecimal getGain() {
        return gain;
    }

    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }

    public Coureur getCoureur() {
        return coureur;
    }

    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }
    @Override
    public String toString() {
        return "Classement{" +
                "place=" + place +
                ", gain=" + gain +
                ", coureur=" + coureur +
                '}';
    }
}
