package Modèle.BasesdeDonnées.Logout;

import Modèle.BasesdeDonnées.Requete;

public class LOGOUT implements Requete
{
    private String Username;

    public String getUsername()
    {
        return Username;
    }

    public LOGOUT(String username)
    {
        Username = username;
    }
}
