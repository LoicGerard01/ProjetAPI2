package metier;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Infos {
    private static int autoId = 1;
    protected int idInfos;
    protected LocalDate dateDepart;
    protected Ville ville;

    public Infos(LocalDate dateDepart, Ville ville) {
        this.idInfos=autoId++;
        this.dateDepart = dateDepart;
        this.ville = ville;
    }
    public Infos(Ville ville) {
        this.idInfos=autoId++;
        this.ville = ville;
    }

    public int getIdInfos() {
        return idInfos;
    }

    public void setIdInfos(int idInfos) {
        this.idInfos = idInfos;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
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
        Infos infos = (Infos) o;
        return idInfos == infos.idInfos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInfos);
    }
}