package Vue.Serveur.InterfaceGraphique;

import Modèle.BasesdeDonnées.Logger;
import Modèle.Protocole.Protocole;
import Modèle.Protocole.UsineProtocole;
import Modèle.Threads.ServeurThread;
import Modèle.Threads.ServeurThreadDemande;
import Modèle.Threads.ServeurThreadPOOL;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ServeurBSPP extends JFrame implements Logger
{
    ServeurThread serveurThread;
    private JButton DemarrerButton;
    private JCheckBox DemandeCheckbox;

    public JButton getDemarrerButton()
    {
        return DemarrerButton;
    }

    public JCheckBox getDemandeCheckbox()
    {
        return DemandeCheckbox;
    }

    private JPanel TopPanel;

    public JPanel getTopPanel()
    {
        return TopPanel;
    }

    private static ServeurBSPP instance;

    public static ServeurBSPP getServeurBSPP()
    {
        if (instance == null)
        {
            instance = new ServeurBSPP();
        }
        return instance;
    }

    public ServeurBSPP()
    {
        super("Serveur Interface");

        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        TopPanel = new JPanel();
        TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        DemarrerButton = new JButton("Démarrer");
        DemandeCheckbox = new JCheckBox("Demande");

        TopPanel.add(DemarrerButton);
        TopPanel.add(DemandeCheckbox);

        this.add(TopPanel, BorderLayout.NORTH);

        DemarrerButton.addActionListener(e -> Demarrer(DemandeCheckbox.isSelected()));
    }

    // Méthode pour afficher un message
    public void ShowMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    public void Demarrer(boolean Demande)
    {
        ShowMessage("Le serveur démarre...");

        int PORT = 5678;

        try
        {
            Protocole protocole = UsineProtocole.RecupererProtocole(null);
            if(Demande)
            {
                System.out.println("Nom du protocole : " + protocole.RecupererNom());
                serveurThread = new ServeurThreadDemande(PORT, protocole, this);
            }

            else
            {
                int taillePOOL = 15;
                serveurThread = new ServeurThreadPOOL(PORT, protocole, taillePOOL, this);
            }

            serveurThread.start();
        }

        catch(NumberFormatException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Trace(String message)
    {
        System.out.println(message);
    }

    public static void main(String[] args)
    {
        ServeurBSPP serveurBSPP = new ServeurBSPP();
        serveurBSPP.setVisible(true);
    }
}
