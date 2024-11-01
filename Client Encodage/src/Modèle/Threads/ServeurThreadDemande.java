package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.Protocole;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServeurThreadDemande extends ServeurThread
{
    private ThreadGroup Groupe;
    private static int Taille_Groupe = 0;
    protected int PORT;
    protected Protocole Protocole;

    public ServeurThreadDemande(int port, Protocole protocole, Logger logger) throws IOException
    {
        super(port, protocole, logger);
        this.Protocole = protocole;
        Groupe = new ThreadGroup("DEMANDE");
        this.Taille_Groupe++;
    }

    @Override
    public void run()
    {
        Logger.Trace("Thread Serveur Demande démarré");

        while(!this.isInterrupted())
        {
            Socket SocketClient;

            try
            {
                SocketClient = ServerSocket.accept();
                Logger.Trace("Client accepté, on crée son thread");
                Thread ClientThread = new ClientThreadDemande(Protocole, SocketClient, Logger);
                ClientThread.start();
            }
            catch(SocketTimeoutException e)
            {
                Logger.Trace("Thread Client Interrompu");
            }

            catch(IOException e)
            {
                Logger.Trace("Erreur d'I/O");
            }
        }

        Logger.Trace("Thread Serveur Demande interrompu");

        try
        {
            ServerSocket.close();
        }

        catch(IOException e)
        {
            Logger.Trace("Erreur d'I/O");
        }


    }


}
