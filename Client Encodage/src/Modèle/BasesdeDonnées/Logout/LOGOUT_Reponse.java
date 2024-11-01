package Modèle.BasesdeDonnées.Logout;

import Modèle.BasesdeDonnées.Reponse;

public class LOGOUT_Reponse implements Reponse
{
    private boolean Valide;

    public LOGOUT_Reponse(boolean valide)
    {
        Valide = valide;
    }

    public boolean estValide()
    {
        return Valide;
    }
}
