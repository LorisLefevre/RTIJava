package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.BSPP;
import Modèle.Protocole.Protocole;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServeurThreadPOOL extends ServeurThread
{
    private AttenteConnexion attenteConnexion;
    private ThreadGroup groupeServeur;
    private int tailleGroupe;

    public ServeurThreadPOOL(int port, Protocole protocole, int taillegroupe, Logger logger) throws IOException
    {
        super(port, protocole, logger);

        attenteConnexion = new AttenteConnexion();
        groupeServeur = new ThreadGroup("POOL");
        this.tailleGroupe = taillegroupe;
    }

    @Override
    public void run()
    {
        Logger.Trace("POOL threads serveur démarré");

        try
        {
            for(int i = 0; i < tailleGroupe; i++)
            {
                new ClientThreadPOOL(new BSPP(Logger), attenteConnexion, groupeServeur, Logger);
            }
        }

        catch(IOException e)
        {
            Logger.Trace("Erreur lors de la création du POOL de threads serveur");
            return;
        }

        while(!this.isInterrupted())
        {
            try
            {
                Socket SocketClient;
                SocketClient = ServerSocket.accept();
                Logger.Trace("Connexion client acceptée");
                attenteConnexion.Ajouter_Connexion(SocketClient);
            }

            catch(SocketTimeoutException e)
            {
                Logger.Trace("Interruption du POOL de threads serveur");
            }

            catch(IOException e)
            {
                Logger.Trace("Erreur d'I/O");
            }
        }

        Logger.Trace("POOL de threads serveur terminé");
        groupeServeur.interrupt();
    }
}
