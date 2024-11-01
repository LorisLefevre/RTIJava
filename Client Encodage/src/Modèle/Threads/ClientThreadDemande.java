package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.Protocole;

import java.io.IOException;
import java.net.Socket;

public class ClientThreadDemande extends ClientThread
{
    private int Numero;

    public ClientThreadDemande(Protocole protocole, Socket SocketClient, Logger logger) throws IOException
    {
        super(protocole, SocketClient, logger);
        Numero = NumeroCourant++;
    }

    @Override
    public void run()
    {
        boolean Stop = false;
        Logger.Trace("Thread Client démarré");

        while(!Stop)
        {
            Logger.Trace("Thread Client en attente d'une connexion client");
            Logger.Trace("Thread Client qui s'occupe d'une connexion");
            super.run();
            Logger.Trace("Thread Client en fin de connexion client");
        }
    }
}
