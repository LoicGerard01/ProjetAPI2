package Championnat;


import java.util.ArrayList;
import java.util.List;

//Les courses appartiennent à des championnats (id:int,nom:String) qui peuvent
//eux-mêmes comporter des championnats. Totaliser le prize money .
public class Championnat {
    private int id;
    private String nom;
    private List<Course> listeCourse = new ArrayList<>();
    private List<Championnat> listeChampionnat = new ArrayList<>();

}
