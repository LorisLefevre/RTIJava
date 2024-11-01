package Modèle.Threads;

import Modèle.BasesdeDonnées.Reponse;

public class TerminerConnexionException extends Exception
{
    private Reponse reponse;

    public Reponse getReponse()
    {
        return this.reponse;
    }

    public void setReponse(Reponse rep)
    {
        this.reponse = rep;
    }

    public TerminerConnexionException(Reponse rep)
    {
        super("\nCeci est la fin de la connexion du protocole BSPP\n");
        this.reponse = rep;
    }

}
