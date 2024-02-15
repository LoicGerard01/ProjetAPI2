package metier;

import java.math.BigDecimal;

public class CoureurPlaceGain {
    protected Coureur coureur;
    protected int place;
    protected BigDecimal gain;

    public CoureurPlaceGain(Coureur coureur, int place, BigDecimal gain) {
        this.coureur = coureur;
        this.place = place;
        this.gain = gain;
    }

    public Coureur getCoureur() {
        return coureur;
    }

    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
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
}
