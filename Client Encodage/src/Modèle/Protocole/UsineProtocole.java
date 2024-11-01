package Modèle.Protocole;

import Modèle.BasesdeDonnées.Logger;

public class UsineProtocole
{
    public static Protocole RecupererProtocole(Logger logger)
    {
        return new BSPP(logger);
    }
}
