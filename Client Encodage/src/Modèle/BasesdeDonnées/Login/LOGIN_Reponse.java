package Modèle.BasesdeDonnées.Login;

import Modèle.BasesdeDonnées.Reponse;

public class LOGIN_Reponse implements Reponse
{
    private boolean Valide;

    private String Message;

    public LOGIN_Reponse(Boolean valide)
    {
        Valide = valide;
    }

    public LOGIN_Reponse(Boolean valide, String message)
    {
        Valide = valide;
        Message = message;
    }

    public boolean estValide()
    {
        return Valide;
    }
}
