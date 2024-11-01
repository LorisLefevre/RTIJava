package Modèle.Entités;

public class Auteur
{
    private int Id;
    private String Nom;
    private String Prenom;

    private String DateNaissance;

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

    public String getPrenom()
    {
        return Prenom;
    }

    public void setPrenom(String prenom)
    {
        this.Prenom = prenom;
    }

    public String getDateNaissance()
    {
        return DateNaissance;
    }

    public void setDateNaissance(String dateNaissance)
    {
        if (dateNaissance.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            this.DateNaissance = dateNaissance;
        }
        else
        {
            throw new IllegalArgumentException("Date de naissance doit être au format yyyy-mm-dd");
        }
    }

    @Override
    public String toString()
    {
        return "Auteur{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", DateNaissance='" + DateNaissance + '\'' +
                '}';
    }

    public Auteur()
    {
        setId(-1);
        setNom("");
        setPrenom("");
        setDateNaissance("");
    }

    public Auteur(String nom, String prenom, String datenaissance)
    {
        this.Nom = nom;
        this.Prenom = prenom;
        this.DateNaissance = datenaissance;
    }

    public Auteur(int id, String nom, String prenom, String datenaissance)
    {
        this.Id = id;
        this.Nom = nom;
        this.Prenom = prenom;
        this.DateNaissance = datenaissance;
    }
}
