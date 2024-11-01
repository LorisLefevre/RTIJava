package Modèle.Entités;

public class Sujet
{
    private int Id;
    private String Nom;

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public String getNom()
    {
        return Nom;
    }

    public void setNom(String nom)
    {
        this.Nom = nom;
    }

    @Override
    public String toString()
    {
        return "Sujet{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                '}';
    }

    public Sujet()
    {
        setId(-1);
        setNom("");
    }

    public Sujet(String nom)
    {
        this.Nom = nom;
    }

    public Sujet(int id, String nom)
    {
        this.Id = id;
        this.Nom = nom;
    }



}
