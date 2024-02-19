package metier;

import java.time.LocalDate;
import java.util.Objects;

public class Coureur {
    protected String matricule;   // obligatoire
    protected String nom;     // obligatoire
    protected String prenom;      // obligatoire
    protected LocalDate dateNaiss;
    protected String nationalite;
    protected Ville ville;


    public Coureur(String matricule, String nom , String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom=prenom;
    }
    public Coureur(String matricule, String nom, String prenom, LocalDate dateNaiss, String nationalite, Ville ville) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.nationalite = nationalite;
        this.ville = ville;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Ville getVille() {
        return ville;
    }

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
