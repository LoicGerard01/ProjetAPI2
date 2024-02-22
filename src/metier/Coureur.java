package metier;

import java.time.LocalDate;
import java.util.Objects;

/**
 * classe métier de gestion d'un coureur/pilote
 *
 * @author Loïc Gérard
 * @version 1.0
 * @see Ville
 */
public class Coureur {
    private static int autoId = 1;
    /**
     * identifiant du coureur.
     */
    protected int idCoureur;
    /**
     * matricule du coureur.
     */
    protected String matricule;   // obligatoire
    /**
     * nom du coureur.
     */
    protected String nom;     // obligatoire
    /**
     * prenom du coureur.
     */
    protected String prenom;      // obligatoire
    /**
     * date de naissance du coureur.
     */
    protected LocalDate dateNaiss;
    /**
     * nationalité du coureur.
     */
    protected String nationalite;
    /**
     * ville d'origine du coureur.
     */
    protected Ville ville;


    /**
     * constructeur paramétré.
     *
     * @param matricule matricule du coureur
     * @param nom       nom du coureur
     * @param prenom    prenom du coureur
     */
    public Coureur(String matricule, String nom, String prenom) {
        this.idCoureur = autoId++;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * constructeur paramétré.
     *
     * @param matricule   matricule du coureur
     * @param nom         nom du coureur
     * @param prenom      prenom du coureur
     * @param dateNaiss   date de naissance du coureur
     * @param nationalite nationalite du coureur
     * @param ville       ville du coureur
     */
    public Coureur(String matricule, String nom, String prenom, LocalDate dateNaiss, String nationalite, Ville ville) {
        this.idCoureur = autoId++;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.nationalite = nationalite;
        this.ville = ville;
    }

    /**
     * getter matricule.
     *
     * @return matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * setter matricule.
     *
     * @param matricule matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
     * getter prenom.
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom.
     *
     * @param prenom prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter date naiss.
     *
     * @return date naiss
     */
    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    /**
     * setter date naiss.
     *
     * @param dateNaiss date naiss
     */
    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    /**
     * getter nationalite.
     *
     * @return nationalite
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * setter nationalite.
     *
     * @param nationalite nationalite
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
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
        Coureur coureur = (Coureur) o;
        return Objects.equals(matricule, coureur.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}
