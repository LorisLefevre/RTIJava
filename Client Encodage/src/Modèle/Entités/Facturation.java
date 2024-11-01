package Modèle.Entités;

import java.io.Serializable;
import java.util.Date;

public class Facturation implements Serializable
{
    private int IdFacture;
    private int IdClient;
    private String Total;
    private Date Date;
    private boolean Paiement;

    public int getIdFacture()
    {
        return IdFacture;
    }

    public void setIdFacture(int idFacture)
    {
        this.IdFacture = idFacture;
    }

    public int getIdClient()
    {
        return IdClient;
    }

    public void setIdClient(int idClient)
    {
        this.IdClient = idClient;
    }

    public String getTotal()
    {
        return Total;
    }

    public void setTotal(String total)
    {
        this.Total = total;
    }

    public Date getDate()
    {
        return Date;
    }

    public void setDate(Date date)
    {
        this.Date = date;
    }

    public boolean getPaiement()
    {
        return Paiement;
    }

    public void setPaiement(boolean paiement)
    {
        Paiement = paiement;
    }

    public Facturation(int idFacture, int idClient, String total, Date date, boolean paiement)
    {
        this.IdFacture = idFacture;
        this.IdClient = idClient;
        this.Total = total;
        this.Date = date;
        this.Paiement = paiement;
    }
}
