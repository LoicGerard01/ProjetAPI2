package metier;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * classe métier permettant de stocker les informations relative à une course
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Course
 */
public class Infos {
    private static int autoId = 1;
    /**
     * identifiant des infos.
     */
    protected int idInfos;
    /**
     * date de depart de la course.
     */
    protected LocalDate dateDepart;
    /**
     * ville de depart de la course.
     */
    protected Ville ville;

    /**
     * constructeur paramétré.
     *
     * @param dateDepart date de depart
     * @param ville      ville de depart
     */
    public Infos(LocalDate dateDepart, Ville ville) {
        this.idInfos = autoId++;
        this.dateDepart = dateDepart;
        this.ville = ville;
    }

    /**
     * constructeur paramétré.
     *
     * @param ville ville de depart
     */
    public Infos(Ville ville) {
        this.idInfos = autoId++;
        this.ville = ville;
    }

    /**
     * getter id infos.
     *
     * @return id infos
     */
    public int getIdInfos() {
        return idInfos;
    }

    /**
     * setter id infos.
     *
     * @param idInfos id infos
     */
    public void setIdInfos(int idInfos) {
        this.idInfos = idInfos;
    }

    /**
     * getter date depart.
     *
     * @return date depart
     */
    public LocalDate getDateDepart() {
        return dateDepart;
    }

    /**
     * setter date depart.
     *
     * @param dateDepart date depart
     */
    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * getter ville.
     *
     * @return ville
     */
    public Ville getVille() {
        return ville;
    }

    /**
     * setter ville.
     *
     * @param ville ville
     */
    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return idInfos == infos.idInfos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInfos);
    }
}