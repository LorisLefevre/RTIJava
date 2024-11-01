package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.BSPP;

import java.io.IOException;
import java.lang.annotation.Inherited;

public class ClientThreadPOOL extends ClientThread
{
    private AttenteConnexion attenteConnexion;

    public ClientThreadPOOL(BSPP bspp, AttenteConnexion attente, ThreadGroup groupeClient, Logger logger) throws IOException
    {
        super(bspp, groupeClient, logger);
        attenteConnexion = attente;
    }

    @Override
    public void run()
    {
        Logger.Trace("POOL de threads clients démarré");
        boolean Stop = false;

        while(!Stop)
        {
            try
            {
                Logger.Trace("POOL de threads clients en attente d'une connexion client");
                SocketClient = attenteConnexion.RecupererConnexion();
                Logger.Trace("POOL de threads clients avec une connexion effectuée");
                super.run();
            }

            catch(InterruptedException e)
            {
                Logger.Trace("Interruption du POOL de threads clients");
                Stop = true;
            }
        }

        Logger.Trace("POOL de threads clients terminé");
    }
}
