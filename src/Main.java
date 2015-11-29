
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class Main {

    public static void main(String[] args) {
        // Connexion à la base
        BaseInformation bi = new BaseInformation("mysql", "com.mysql.jdbc.Driver", "banque", "root", "", "//localhost");
        BaseSetting bs = new BaseSetting(bi);
        bs.testerConnexion();

        // Contenu de la table client
        if (bs.select("select * from client")) {
            try {
                while (bs.getResult_set().next()) {
                    int id = bs.getResult_set().getInt("IdeClient");
                    String nom = bs.getResult_set().getString("Nom");
                    String adresseCl = bs.getResult_set().getString("AdresseCl");
                    String villeCl = bs.getResult_set().getString("VilleCl");
                    System.out.println("Client N°" + id + " : nom=" + nom + " ; adresse=" + adresseCl + " ; ville=" + villeCl);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Modification du solde 123987 retrait 200€
        int solde = 0;
        if (bs.select("select Solde from compte where NoCompte=123987")) {
            try {
                if (bs.getResult_set().next()) {
                    solde = bs.getResult_set().getInt("Solde");
                    System.out.println("Solde Actuel = " + solde);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        solde -= 200;
        bs.insert("update compte set Solde=" + solde + " where NoCompte=123987");
        if (bs.select("select Solde from compte where NoCompte=123987")) {
            try {
                if (bs.getResult_set().next()) {
                    int newsolde = bs.getResult_set().getInt("Solde");
                    System.out.println("Nouveau Solde = " + newsolde);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
