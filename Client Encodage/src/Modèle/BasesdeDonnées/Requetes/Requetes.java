package Modèle.BasesdeDonnées.Requetes;

import Modèle.BasesdeDonnées.Logger;
import Modèle.BasesdeDonnées.Login.LOGIN;
import Modèle.Entités.Facturation;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.ArrayList;
public class Requetes
{
    private ConnexionBD connexionBD;
    private Logger logger;

    public Requetes(Logger logger)
    {
        try
        {
            connexionBD = new ConnexionBD("127.0.0.1");
        }

        catch(SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        this.logger = logger;
    }

    public boolean Login(LOGIN login)
    {
        String Username = login.getUsername();
        String Password = login.getPassword();

        try
        {
            String Requete = "SELECT password FROM employees WHERE login = ?;";
            PreparedStatement preparedStatement =  connexionBD.connection.prepareStatement(Requete);

            preparedStatement.setString(1, Username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                String PasswordVerification = resultSet.getString("password");
                resultSet.close();
                preparedStatement.close();

                return Password.equals(PasswordVerification);
            }
        }

        catch(SQLException e)
        {
            logger.Trace("Erreur dans la requete de Login : " + e.getMessage());
            throw new RuntimeException("Une erreur s'est produite lors de l'envoi de la requête");
        }

        return false;
    }

    public ArrayList<Facturation> getFacturation(RecupererFacturationRequete facturationRequete)
    {
        int IdClient = facturationRequete.getIdClient();

        try
        {
            String requete = "SELECT id, idclient, date, montant, paye FROM facturation WHERE idclient = " +IdClient + ";";
            ResultSet resultSet = connexionBD.getTuple(requete);

            ArrayList<Facturation> facturations = new ArrayList<>();

            while(resultSet.next())
            {
                int Id = resultSet.getInt("id");
                int idClient = resultSet.getInt("idclient");
                Date date = resultSet.getDate("date");
                String Prix = resultSet.getString("montant");
                boolean Paiement = resultSet.getBoolean("paye");

                Facturation facturation = new Facturation(Id, idClient, Prix, date, Paiement);
                facturations.add(facturation);
            }

            return facturations;
        }

        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean PayerFacturation(FacturationRequete facturationRequete) throws SQLException
    {
        int IdFacturation = facturationRequete.getIdFacturation();

        String requete = "UPDATE factures SET paye = TRUE WHERE id = " +IdFacturation + ";";
        int LignesAffectees = connexionBD.ExecuterUpdate(requete);

        if(LignesAffectees == 1)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean PayerFacturation(int Id) throws SQLException
    {
        int IdFacture = Id;

        String requete = "UPDATE factures SET paye = TRUE WHERE id = " + IdFacture +";";
        int LignesAffectees = connexionBD.ExecuterUpdate(requete);

        if(LignesAffectees == 1)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public void Fermer()
    {
        try
        {
            connexionBD.Close();
        }

        catch(SQLException e)
        {
            logger.Trace("Erreur dans la requête de ma base de données " + e.getMessage());
        }
    }
}
