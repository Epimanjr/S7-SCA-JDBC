package Exercice3;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime
 */
public abstract class CompteBancaire {

    private int numeroCompte;

    private int ideClient;

    private String nomAgence;

    private int solde;

    public CompteBancaire(int numeroCompte, int ideClient, String nomAgence, int solde) {
        this.numeroCompte = numeroCompte;
        this.ideClient = ideClient;
        this.nomAgence = nomAgence;
        this.solde = solde;
    }

    public static void afficherDetailsCompte(int numeroCompte) {
        if (Main.bs.select("select * from compte where NoCompte=" + numeroCompte)) {
            try {
                while (Main.bs.getResult_set().next()) {
                    String agence = Main.bs.getResult_set().getString("NomAgence");
                    int solde = Main.bs.getResult_set().getInt("Solde");
                    System.out.println("Information sur le compte n°" + numeroCompte);
                    System.out.println("Agence = " + agence + " ; Solde = " + solde);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CompteBancaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getIdeClient() {
        return ideClient;
    }

    public void setIdeClient(int ideClient) {
        this.ideClient = ideClient;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

}
