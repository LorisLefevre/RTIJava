package Modèle.Protocole;

import Modèle.BasesdeDonnées.Logger;
import Modèle.BasesdeDonnées.Logout.LOGOUT_Reponse;
import Modèle.Entités.Facturation;
import Modèle.BasesdeDonnées.Login.LOGIN;
import Modèle.BasesdeDonnées.Login.LOGIN_Reponse;
import Modèle.BasesdeDonnées.Logout.LOGOUT;
import Modèle.BasesdeDonnées.Requete;
import Modèle.BasesdeDonnées.Reponse;
import Modèle.BasesdeDonnées.Requetes.Requetes;
import Modèle.BasesdeDonnées.Requetes.FacturationRequete;
import Modèle.BasesdeDonnées.Requetes.FacturationReponse;
import Modèle.BasesdeDonnées.Requetes.RecupererFacturationRequete;
import Modèle.BasesdeDonnées.Requetes.RecupererFacturationReponse;
import Modèle.Threads.TerminerConnexionException;

import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
public class BSPP implements Protocole
{
    private HashMap<String, Socket> ConnexionClient;
    private Logger Logger;
    private Requetes requetes;

    public BSPP(Logger logger)
    {
        this.Logger = logger;
        this.requetes = new Requetes(logger);
        this.ConnexionClient = new HashMap<>();
    }
    @Override
    public String RecupererNom()
    {
        return "BSPP";
    }

    public synchronized Reponse TraitementRequete(Requete requete, Socket socket) throws SQLException, TerminerConnexionException
    {
        if(requete instanceof LOGIN)
        {
            return TraitementLOGIN((LOGIN) requete, socket);
        }

        else if(requete instanceof LOGOUT)
        {
            return TraitementLOGOUT((LOGOUT) requete);
        }

        else if(requete instanceof FacturationRequete)
        {
            return TraitementFACTURATION((FacturationRequete) requete);
        }

        else if(requete instanceof RecupererFacturationRequete)
        {
            return TraitementRECUPERATIONFACTURES((RecupererFacturationRequete) requete);
        }

        return null;
    }

    private synchronized LOGIN_Reponse TraitementLOGIN(LOGIN login, Socket socket) throws TerminerConnexionException
    {
        Logger.Trace("BSPP : Requete de login envoyée par : " + login.getUsername());

        if(!ConnexionClient.containsKey(login.getUsername()))
        {
            if(requetes.Login(login))
            {
                String IP_Client_Port_Client = socket.getInetAddress().getHostAddress() + "/" + socket.getPort();
                Logger.Trace("BSPP : La connexion de l'utilisateur " + login.getUsername() + "a bel et bien été effectuée. Voici son IP et son PORT : " + IP_Client_Port_Client);
                ConnexionClient.put(login.getUsername(), socket);
                return new LOGIN_Reponse(true);
            }

            else
            {
                return new LOGIN_Reponse(false, "Le mot de passe est incorrect");
            }
        }

        else
        {
            Logger.Trace("BSPP : Erreur dans le nom de " + login.getUsername());
            throw new TerminerConnexionException(new LOGIN_Reponse(false));
        }
    }

    private synchronized LOGOUT_Reponse TraitementLOGOUT(LOGOUT logout) throws TerminerConnexionException
    {
        Logger.Trace("BSPP : Requête Logout envoyée par : " + logout.getUsername());

        ConnexionClient.remove(logout.getUsername());

        Logger.Trace("BSPP : Déconnexion réussie");

        throw new TerminerConnexionException(null);
    }

    private synchronized FacturationReponse TraitementFACTURATION(FacturationRequete facturationRequete) throws SQLException
    {
        if(VisaCorrect(facturationRequete.getVisa()))
        {
            if(requetes.PayerFacturation(facturationRequete))
            {
                return new FacturationReponse(true);
            }
            else
            {
                return new FacturationReponse(false, "Le paiement du panier a échoué");
            }
        }

        else
        {
            return new FacturationReponse(false, "Votre carte Visa est invalide");
        }
    }

    private synchronized RecupererFacturationReponse TraitementRECUPERATIONFACTURES(RecupererFacturationRequete facturationRequete)
    {
        ArrayList<Facturation> Facturations = requetes.getFacturation(facturationRequete);
        return new RecupererFacturationReponse(Facturations);
    }

    private boolean VisaCorrect(String Visa)
    {
        if(Visa.length() == 16)
        {
            for (char C : Visa.toCharArray())
            {
                if(!Character.isDigit(C))
                {
                    return false;
                }
            }
            return true;
        }

        else
        {
            return false;
        }
    }
}
