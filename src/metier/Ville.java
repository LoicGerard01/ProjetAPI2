package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe métier de gestion d'une ville
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Course
 */
public class Ville {
    private static int autoId = 1;
    /**
     * identifiant de la ville.
     */
    protected int idVille;
    /**
     * nom de la ville.
     */
    protected String nom;
    /**
     * latitude de la ville.
     */
    protected double latitute;
    /**
     * longitude de la ville.
     */
    protected double longitude;
    /**
     * pays dans lequelle se trouve la ville.
     */
    protected String pays;
    /**
     * liste des coureurs provenant de cette ville.
     */
    protected List<Coureur> coureurs = new ArrayList<>();

    /**
     * constructeur paramétré.
     *
     * @param nom       nom
     * @param latitute  latitute
     * @param longitude longitude
     * @param pays      pays
     */
    public Ville(String nom, double latitute, double longitude, String pays) {
        this.idVille = autoId++;
        this.nom = nom;
        this.latitute = latitute;
        this.longitude = longitude;
        this.pays = pays;
    }

    /**
     * constructeur paramétré.
     *
     * @param nom       nom
     * @param latitute  latitute
     * @param longitude longitude
     * @param pays      pays
     * @param coureurs  coureurs
     */
    public Ville(String nom, double latitute, double longitude, String pays, List<Coureur> coureurs) {
        this.idVille = autoId++;
        this.nom = nom;
        this.latitute = latitute;
        this.longitude = longitude;
        this.pays = pays;
        this.coureurs = coureurs;
    }

    /**
     * Ajout coureur.
     *
     * @param coureur coureur
     */
    public void ajoutCoureur(Coureur coureur) {
        this.coureurs.add(coureur);
    }

    /**
     * getter nom.
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom.
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter latitute.
     *
     * @return latitute
     */
    public double getLatitute() {
        return latitute;
    }

    /**
     * setter latitute.
     *
     * @param latitute latitute
     */
    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    /**
     * getter longitude.
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * setter longitude.
     *
     * @param longitude longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * getter pays.
     *
     * @return pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * setter pays.
     *
     * @param pays pays
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * getter coureurs.
     *
     * @return coureurs
     */
    public List<Coureur> getCoureurs() {
        return coureurs;
    }

    /**
     * setter coureurs.
     *
     * @param coureurs coureurs
     */
    public void setCoureurs(List<Coureur> coureurs) {
        this.coureurs = coureurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return Double.compare(latitute, ville.latitute) == 0 && Double.compare(longitude, ville.longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitute, longitude);
    }
}
