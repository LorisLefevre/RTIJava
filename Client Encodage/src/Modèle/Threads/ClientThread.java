package Modèle.Threads;

import Modèle.BasesdeDonnées.Logger;
import Modèle.BasesdeDonnées.Reponse;
import Modèle.BasesdeDonnées.Requete;
import Modèle.Protocole.BSPP;
import Modèle.Protocole.Protocole;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public abstract class ClientThread extends Thread
{
   protected Protocole Protocole;
   protected Socket SocketClient;
   protected Logger Logger;
   private int Numero;

   protected static int NumeroCourant = 1;

   public ClientThread(Protocole protocole, ThreadGroup socketClient, Logger logger) throws IOException
   {
       super(socketClient + "Thread Client démarré : " + NumeroCourant + "Protocole : " + protocole.RecupererNom());

       this.Protocole = protocole;
       this.SocketClient = null;
       this.Logger = logger;
       this.Numero = NumeroCourant++;
   }

    public ClientThread(Protocole protocole, Socket socketClient, Logger logger) throws IOException
    {
        super(socketClient + "Thread Client démarré : " + NumeroCourant + "Protocole : " + protocole.RecupererNom());

        this.Protocole = protocole;
        this.SocketClient = null;
        this.Logger = logger;
        this.Numero = NumeroCourant++;
    }

   @Override
    public void run()
   {
       try
       {
           ObjectInputStream objectInputStream = null;
           ObjectOutputStream objectOutputStream = null;

           try
           {
               objectInputStream = new ObjectInputStream(SocketClient.getInputStream());
               objectOutputStream = new ObjectOutputStream(SocketClient.getOutputStream());

               while(true)
               {
                   try
                   {
                       Requete requete = (Requete) objectInputStream.readObject();
                       Reponse reponse = Protocole.TraitementRequete(requete, SocketClient);
                       objectOutputStream.writeObject(reponse);
                   }

                   catch(IOException e)
                   {
                       System.out.println(getName() + "IOException : " + e.getMessage());
                   }
               }
           }

           catch (SQLException | TerminerConnexionException |  ClassNotFoundException e)
           {
                throw new RuntimeException(e);
           }
       }

       catch(IOException e)
       {
            Logger.Trace("I/O Exception");
       }

       finally
       {
           try
           {
               SocketClient.close();
           }

           catch(IOException e)
           {
               Logger.Trace("Erreur lors de la fermeture de la SocketClient");
           }
       }
   }
}
