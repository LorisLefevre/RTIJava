package Modèle.BasesdeDonnées.Requetes;

import Modèle.BasesdeDonnées.Requete;

public class RecupererFacturationRequete implements Requete
{
    private int IdClient;

    public int getIdClient()
    {
        return IdClient;
    }

    public void setIdClient(int idClient)
    {
        this.IdClient = idClient;
    }
}
