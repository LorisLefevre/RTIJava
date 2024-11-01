package Modèle.Threads;

import java.net.Socket;
import java.util.LinkedList;

public class AttenteConnexion
{
    private LinkedList<Socket> File_Attente_Connexion;

    public AttenteConnexion()
    {
        File_Attente_Connexion = new LinkedList<>();
    }

    public synchronized void Ajouter_Connexion(Socket socket)
    {
        File_Attente_Connexion.addLast(socket);
        notify();
    }

    public synchronized Socket RecupererConnexion() throws InterruptedException
    {
        while(File_Attente_Connexion.isEmpty())
        {
            wait();
        }
        return File_Attente_Connexion.remove();
    }
}
