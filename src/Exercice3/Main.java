/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice3;

/**
 *
 * @author Maxime
 */
public class Main {
    
    public static BaseSetting bs = null;
    
    public static void main(String[] args) {
        // Connexion à la base
        BaseInformation bi = new BaseInformation("mysql", "com.mysql.jdbc.Driver", "banque", "root", "", "//localhost");
        bs = new BaseSetting(bi);
        bs.testerConnexion();
        
        CompteBancaire.afficherDetailsCompte(124578);
    }
}
