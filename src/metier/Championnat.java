package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe métier de gestion d'un championnat
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Course
 */
public class Championnat {
    private static int autoId = 1;
    /**
     * identifiant unique du championnat
     */
    protected int id;
    /**
     * nom du championnat
     */
    protected String nom;
    /**
     * ensemble des course du championnat
     */
    protected List<Course> listeCourse = new ArrayList<>();
    /**
     * ensemble des championnats faisant parti du championnat
     */
    protected List<Championnat> listeChampionnat = new ArrayList<>();

    /**
     * constructeur paramétré.
     *
     * @param nom nom du championnat
     */
    public Championnat(String nom) {
        this.id = autoId++;
        this.nom = nom;
    }


    /**
     * constructeur paramétré.
     *
     * @param nom              nom du championnat
     * @param listeCourse      liste des courses du championnat
     * @param listeChampionnat liste des championnat faisant parti du championnat
     */
    public Championnat(String nom, List<Course> listeCourse, List<Championnat> listeChampionnat) {
        this.id = autoId++;
        this.nom = nom;
        this.listeCourse = listeCourse;
        this.listeChampionnat = listeChampionnat;
    }

    /**
     * constructeur paramétré.
     *
     * @param nom         nom du championnat
     * @param listeCourse liste des courses du championnat
     */
    public Championnat(String nom, List<Course> listeCourse) {
        this.id = autoId++;
        this.nom = nom;
        this.listeCourse = listeCourse;
    }

    /**
     * getter id.
     *
     * @return identifiant du championnat
     */
    public int getId() {
        return id;
    }

    /**
     * getter nom.
     *
     * @return nom du championnat
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
     * getter liste course.
     *
     * @return liste course
     */
    public List<Course> getListeCourse() {
        return listeCourse;
    }

    /**
     * setter liste course.
     *
     * @param listeCourse liste des course
     */
    public void setListeCourse(List<Course> listeCourse) {
        this.listeCourse = listeCourse;
    }

    /**
     * getter liste championnat.
     *
     * @return liste des championnat
     */
    public List<Championnat> getListeChampionnat() {
        return listeChampionnat;
    }

    /**
     * setter liste championnat.
     *
     * @param listeChampionnat liste championnat
     */
    public void setListeChampionnat(List<Championnat> listeChampionnat) {
        this.listeChampionnat = listeChampionnat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Championnat that = (Championnat) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
