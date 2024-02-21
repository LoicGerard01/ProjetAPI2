package metier;

import java.util.List;
import java.util.Objects;

public class Ville {
    private static int autoId = 1;
    protected int idVille;
    protected String nom;
    protected double latitute;
    protected double longitude;
    protected String pays;
    protected List<Coureur> coureurs;

    public Ville(int idVille, String nom, double latitute, double longitude) {
        this.idVille = autoId++;
        this.nom = nom;
        this.latitute = latitute;
        this.longitude = longitude;
    }

    public Ville(String nom, double latitute, double longitude, String pays, List<Coureur> coureurs) {
        this.idVille = autoId++;
        this.nom = nom;
        this.latitute = latitute;
        this.longitude = longitude;
        this.pays = pays;
        this.coureurs = coureurs;
    }

    public void ajoutCoureur(Coureur coureur){
        this.coureurs.add(coureur);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Coureur> getCoureurs() {
        return coureurs;
    }

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
