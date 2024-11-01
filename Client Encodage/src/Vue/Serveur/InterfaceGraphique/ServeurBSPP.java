package Vue.Serveur.InterfaceGraphique;

import Modèle.BasesdeDonnées.Logger;

import javax.swing.*;
import java.awt.*;

public class ServeurBSPP extends JFrame implements Logger
{
    private JButton DemarrerButton;
    private JCheckBox DemandeCheckbox;

    // Getter pour le bouton "Démarrer"
    public JButton getDemarrerButton()
    {
        return DemarrerButton;
    }

    // Getter pour la checkbox "Demande"
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

    // Singleton pour obtenir l'instance unique de ServeurBSPP
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

        // Initialisation des composants
        DemarrerButton = new JButton("Démarrer");
        DemandeCheckbox = new JCheckBox("Demande");

        // Ajout des composants au panneau supérieur
        TopPanel.add(DemarrerButton);
        TopPanel.add(DemandeCheckbox);

        // Ajout du panneau supérieur au JFrame
        this.add(TopPanel, BorderLayout.NORTH);
    }

    // Méthode pour afficher un message
    public void ShowMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    // Action pour le bouton "Démarrer"
    public void Demarrer()
    {
        ShowMessage("Le serveur démarre...");
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
