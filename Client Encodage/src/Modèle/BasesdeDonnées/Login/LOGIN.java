package Modèle.BasesdeDonnées.Login;

import Modèle.BasesdeDonnées.Requete;

public class LOGIN implements Requete
{
    private String Username;
    private String Password;

    public String getUsername()
    {
        return Username;
    }

    public String getPassword()
    {
        return Password;
    }

    public LOGIN(String username, String password)
    {
        Username = username;
        Password = password;
    }
}
