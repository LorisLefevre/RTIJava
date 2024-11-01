package Modèle.BasesdeDonnées.Requetes;

import Modèle.BasesdeDonnées.Reponse;
import Modèle.Entités.Facturation;

import java.util.ArrayList;

public class RecupererFacturationReponse implements Reponse
{
    private ArrayList<Facturation> Factures;

    public ArrayList<Facturation> getFactures()
    {
        return Factures;
    }

    public void setFactures(ArrayList<Facturation> factures)
    {
        this.Factures = factures;
    }

    public RecupererFacturationReponse(ArrayList<Facturation> factures)
    {
        this.Factures = factures;
    }
}
