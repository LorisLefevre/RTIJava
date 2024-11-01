package Modèle.BasesdeDonnées.Requetes;

import Modèle.BasesdeDonnées.Reponse;

public class FacturationReponse implements Reponse
{
    private boolean Valide;
    private String Message;

    public boolean estValide()
    {
        return Valide;
    }

    public void setValide(boolean valide)
    {
        this.Valide = valide;
    }

    public String getMessage()
    {
        return Message;
    }

    public void setMessage(String message)
    {
        this.Message = message;
    }

    public FacturationReponse(boolean valide)
    {
        this.Valide = valide;
    }

    public FacturationReponse(boolean valide, String message)
    {
        this.Valide = valide;
        this.Message = message;
    }
}
