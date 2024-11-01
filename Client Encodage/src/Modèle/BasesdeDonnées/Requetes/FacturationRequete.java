package Modèle.BasesdeDonnées.Requetes;

import Modèle.BasesdeDonnées.Requete;

public class FacturationRequete implements Requete
{
    private int IdFacturation;
    private String NomFacturation;
    private String Visa;
    public int getIdFacturation()
    {
        return IdFacturation;
    }

    public void setIdFacturation(int idFacturation)
    {
        this.IdFacturation = idFacturation;
    }

    public String getNomFacturation()
    {
        return NomFacturation;
    }

    public void setNomFacturation(String nomFacturation)
    {
        this.NomFacturation = nomFacturation;
    }

    public String getVisa()
    {
        return Visa;
    }

    public void setVisa(String visa)
    {
        this.Visa = visa;
    }

    public FacturationRequete(int idFacturation, String nomFacturation, String visa)
    {
        this.IdFacturation = idFacturation;
        this.NomFacturation = nomFacturation;
        this.Visa = visa;
    }
}

