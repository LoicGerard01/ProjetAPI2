package metier;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Infos {
    private static int autoId = 1;
    protected int idInfos;
    protected LocalDate dateDepart;
    protected List<Ville> villes;

    public Infos(LocalDate dateDepart, List<Ville> villes) {
        this.idInfos = autoId++;
        this.dateDepart = dateDepart;
        this.villes = villes;
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

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
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