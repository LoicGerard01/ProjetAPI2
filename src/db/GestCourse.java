package db;

import metier.Course;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class GestCourse {
    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("Connextion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);
    }
    public void ajout() {
        System.out.println("nom de la course :");
        String nom = sc.nextLine();
        System.out.println("Cash Prize : ");
        BigDecimal priceMoney = sc.nextBigDecimal();
        System.out.println("Taille en km");
        Integer km = sc.nextInt();
        sc.skip("\n");

        String query1 = "insert into API_COURSE(nom,priceMoney,km) values(?,?,?)";
        String query2 = "select idcourse from API_COURSE where nom=? and priceMoney=? and km=?";

        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,nom);
            pstm1.setBigDecimal(2,priceMoney);
            pstm1.setInt(3,km);
            int n = pstm1.executeUpdate();
            System.out.println(n+"Ligne insérée");
            if(n==1){
                pstm2.setString(1,nom);
                pstm2.setBigDecimal(2,priceMoney);
                pstm2.setInt(3,km);
                ResultSet rs = pstm2.executeQuery();
                if(rs.next()){
                    int idcourse = rs.getInt(1);
                    System.out.println("id course = "+idcourse);
                }
                else System.out.println("record introuvable");
            }
        }catch (SQLException e) {
            System.out.println("erreur SQL :" + e);
        }
    }

    public void recherche(){
        System.out.println("id de la course recherchée");
        int idrech = sc.nextInt();
        String query = "select * from API_COURSE where idcourse=?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            pstm.setInt(1,idrech);
            ResultSet rs= pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                BigDecimal priceMoney = rs.getBigDecimal(3);
                Integer km = rs.getInt(4);
                Course course = new Course(nom,priceMoney,km);
                System.out.println(course);
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql : "+e);
        }

    }
    public void modification(){
        int choix = 0;
        String nom = " " , query = " ";
        BigDecimal priceMoney = new BigDecimal(0) ;
        int km = 0;

        System.out.println("id du client recherché");
        int idrech = sc.nextInt();

        sc.skip("\n");
        do{
            System.out.println("1.Changement du nom ");
            System.out.println("2.Changement du cash prize ");
            System.out.println("3.Changement de la taille en km ");
            System.out.println("Choix ?");
            choix = sc.nextInt();
            sc.skip("\n");
        }while (choix < 0 || choix >3);
        switch (choix){
            case 1:
                System.out.println("Nouveau nom ?");
                nom = sc.nextLine();
                query="update API_COURSE set nom=? where idcourse = ?";
                break;
            case 2:
                System.out.println("Nouveau cash prize ?");
                priceMoney = sc.nextBigDecimal();
                query="update API_COURSE set priceMoney=? where idcourse = ?";
                break;
            case 3:
                System.out.println("Nouvelle longueur ?");
                km = sc.nextInt();
                query="update API_COURSE set km=? where idcourse = ?";
                break;
        }
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            switch (choix){
                case 1 :
                    pstm.setString(1,nom);
                    pstm.setInt(2,idrech);
                    break;
                case 2 :
                    pstm.setBigDecimal(1,priceMoney);
                    pstm.setInt(2,idrech);
                    break;
                case 3:
                    pstm.setInt(1,km);
                    pstm.setInt(2,idrech);
                    break;
            }
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne mise a jour");
            else System.out.println("record introuvable");

        }catch (SQLException e){
            System.out.println("erreur sql : "+ e);
        }


    }
    public void suppression(){

    }
    private void tous(){

    }

    public static void main(String[] args) throws SQLException {
        GestCourse gestCourse =new GestCourse();
        gestCourse.gestion();
    }

}
