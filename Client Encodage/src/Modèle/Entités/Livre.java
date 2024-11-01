package Modèle.Entités;

public class Livre {
    private int Id;
    private int IdAuteur;
    private int IdSujet;
    private String Titre;
    private String ISBN;
    private int NombrePages;
    private int Quantite;
    private float Prix;
    private int AnneePublication;

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public int getIdAuteur()
    {
        return IdAuteur;
    }

    public void setIdAuteur(int idAuteur)
    {
        this.IdAuteur = idAuteur;
    }

    public int getIdSujet()
    {
        return IdSujet;
    }

    public void setIdSujet(int idSujet)
    {
        this.IdSujet = idSujet;
    }

    public String getTitre()
    {
        return Titre;
    }

    public void setTitre(String titre)
    {
        this.Titre = titre;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String isbn)
    {
        this.ISBN = isbn;
    }

    public int getNombrePages()
    {
        return NombrePages;
    }

    public void setNombrePages(int nombrePages)
    {
        this.NombrePages = nombrePages;
    }

    public int getQuantite()
    {
        return Quantite;
    }

    public void setQuantite(int quantite)
    {
        this.Quantite = quantite;
    }

    public float getPrix()
    {
        return Prix;
    }

    public void setPrix(float prix)
    {
        this.Prix = prix;
    }

    public int getAnneePublication()
    {
        return AnneePublication;
    }

    public void setAnneePublication(int anneePublication)
    {
        this.AnneePublication = anneePublication;
    }

    @Override
    public String toString()
    {
        return "Livre{" +
                "Id=" + Id +
                ", IdAuteur=" + IdAuteur +
                ", IdSujet=" + IdSujet +
                ", Titre='" + Titre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", NombrePages=" + NombrePages +
                ", Quantite=" + Quantite +
                ", Prix=" + Prix +
                ", AnneePublication=" + AnneePublication +
                '}';
    }

    public Livre()
    {
        this.Id = -1;
        this.IdAuteur = -1;
        this.IdSujet = -1;
        this.Titre = "";
        this.ISBN = "";
        this.NombrePages = 0;
        this.Quantite = 0;
        this.Prix = 0.0f;
        this.AnneePublication = 0;
    }


    public Livre(int id, int idAuteur, int idSujet, String titre, String isbn,
                 int nombrePages, int quantite, float prix, int anneePublication)
    {
        this.Id = id;
        this.IdAuteur = idAuteur;
        this.IdSujet = idSujet;
        this.Titre = titre;
        this.ISBN = isbn;
        this.NombrePages = nombrePages;
        this.Quantite = quantite;
        this.Prix = prix;
        this.AnneePublication = anneePublication;
    }
}
