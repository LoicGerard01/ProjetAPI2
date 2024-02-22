package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * classe métier de gestion d'un classement d'une course
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Coureur
 */
public class Classement {
    private static int autoId = 1;
    /**
     * identifiant du classement.
     */
    protected int idClassement;
    /**
     * placement du coureur dans le classement.
     */
    protected int place = 0;
    /**
     * gain du coureur.
     */
    protected BigDecimal gain;
    /**
     * coureur associé au classement.
     */
    protected Coureur coureur;

    /**
     * constructeur par défaut.
     */
    public Classement() {
        this.idClassement = autoId++;
    }

    /**
     * constructeur parametré.
     *
     * @param coureur coureur
     */
    public Classement(Coureur coureur) {
        this.idClassement = autoId++;
        this.coureur = coureur;
    }

    /**
     * constructeur paramétré.
     *
     * @param place   place du coureur
     * @param gain    gain du coureur
     * @param coureur coureur
     */
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

    /**
     * getter id classement.
     *
     * @return id classement
     */
    public int getIdClassement() {
        return idClassement;
    }

    /**
     * getter place.
     *
     * @return place
     */
    public int getPlace() {
        return place;
    }

    /**
     * setter place.
     *
     * @param place place
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * getter gain.
     *
     * @return gain
     */
    public BigDecimal getGain() {
        return gain;
    }

    /**
     * setter gain.
     *
     * @param gain gain
     */
    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }

    /**
     * getter coureur.
     *
     * @return coureur
     */
    public Coureur getCoureur() {
        return coureur;
    }

    /**
     * setter coureur.
     *
     * @param coureur coureur
     */
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
