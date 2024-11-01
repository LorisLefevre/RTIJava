package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.Protocole;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.ServerError;

public abstract class ServeurThread extends Thread
{
    protected Protocole Protocole;
    protected int PORT;
    protected Logger Logger;
    protected ServerSocket ServerSocket;

    public ServeurThread(int port, Protocole protocole, Logger logger) throws IOException
    {
        super("Thread Serveur. PORT : " + port + "Protocole : " + protocole.RecupererNom());

        this.PORT = port;
        this.Protocole = protocole;
        this.Logger = logger;
        ServerSocket = new ServerSocket(port);
    }
}
