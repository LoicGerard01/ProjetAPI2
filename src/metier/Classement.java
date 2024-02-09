package metier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classement {
    protected int idClassement;
    protected int place;
    protected BigDecimal gain;
    protected List<Coureur> listeCoureurs = new ArrayList<>();

    public Classement(int idClassement, int place, BigDecimal gain, List<Coureur> listeCoureurs) {
        this.idClassement = idClassement;
        this.place = place;
        this.gain = gain;
        gain.setScale(2, RoundingMode.HALF_UP);
        this.listeCoureurs = listeCoureurs;
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

    public List<Coureur> getListeCoureurs() {
        return listeCoureurs;
    }

    public void setListeCoureurs(List<Coureur> listeCoureurs) {
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
}
