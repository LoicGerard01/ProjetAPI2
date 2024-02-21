package metier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Les courses appartiennent à des championnats (id:int,nom:String) qui peuvent
//eux-mêmes comporter des championnats. Totaliser le prize money .
public class Championnat {
    private static int autoId = 1;
    protected int id;
    protected String nom;
    protected List<Course> listeCourse = new ArrayList<>();
    protected List<Championnat> listeChampionnat = new ArrayList<>();

    public Championnat(String nom){
        this.id = autoId++;
        this.nom = nom;
    }


    public Championnat(String nom, List<Course> listeCourse, List<Championnat> listeChampionnat) {
        this.id = autoId++;
        this.nom = nom;
        this.listeCourse = listeCourse;
        this.listeChampionnat = listeChampionnat;
    }

    public Championnat(String nom, List<Course> listeCourse) {
        this.id = autoId++;
        this.nom = nom;
        this.listeCourse = listeCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Course> getListeCourse() {
        return listeCourse;
    }

    public void setListeCourse(List<Course> listeCourse) {
        this.listeCourse = listeCourse;
    }

    public List<Championnat> getListeChampionnat() {
        return listeChampionnat;
    }

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
