package metier;

import java.math.BigDecimal;

/**
 * classe métier permettant de stocker les variables coureur ,place et gain
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Course
 */
public class CoureurPlaceGain {
    /**
     * identifiant cpg.
     */
    protected int idCPG;
    private static int autoId = 1;
    /**
     * coureur.
     */
    protected Coureur coureur;
    /**
     * place du coureur.
     */
    protected int place;
    /**
     * gain du coureur.
     */
    protected BigDecimal gain;

    /**
     * constructeur paramétré
     *
     * @param coureur coureur
     * @param place   place
     * @param gain    gain
     */
    public CoureurPlaceGain(Coureur coureur, int place, BigDecimal gain) {
        this.idCPG = autoId++;
        this.coureur = coureur;
        this.place = place;
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
}
