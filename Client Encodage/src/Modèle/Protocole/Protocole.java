package Modèle.Protocole;

import Modèle.BasesdeDonnées.Requete;
import Modèle.BasesdeDonnées.Reponse;
import Modèle.Threads.TerminerConnexionException;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public interface Protocole
{
    String RecupererNom();
    Reponse TraitementRequete(Requete requete, Socket socket) throws IOException, SQLException, TerminerConnexionException;
}
