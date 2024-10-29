package Vue.Client.InterfaceGraphique;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
public class FenetreClient extends JFrame
{
    private JTextField UsernameField;

    public JTextField getUsername()
    {
        return UsernameField;
    }

    public void setUsername(String username)
    {
        UsernameField.setText(username);
    }

    private JButton Selectionner;

    public JButton getSelectionner()
    {
        return Selectionner;
    }

    private JButton Ajouter;

    public JButton getAjouter()
    {
        return Ajouter;
    }

    private JButton Supprimer;

    public JButton getSupprimer()
    {
        return Supprimer;
    }

    private JButton Annuler;

    public JButton getAnnuler()
    {
        return Annuler;
    }

    private JButton Payer;

    public JButton getPayer()
    {
        return Payer;
    }

    private JPanel TopPanel;

    public JPanel getTopPanel()
    {
        return TopPanel;
    }

    private JScrollPane Scroll;

    public JScrollPane getScroll()
    {
        return Scroll;
    }

    private JTable ClientTable;

    public JTable getClientTable()
    {
        return ClientTable;
    }

    private DefaultTableModel TableDefaut;

    public DefaultTableModel getTableDefaut()
    {
        return TableDefaut;
    }

    private static FenetreClient instance;

    public static FenetreClient getFenetreClient()
    {
        if(instance == null)
        {
            instance = new FenetreClient();
        }

        return instance;
    }

    public FenetreClient()
    {
        super("Fenetre Java de Client Encodage");

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        TopPanel = new JPanel();
        TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        UsernameField = new JTextField("Utilisateur");
        UsernameField.setEditable(false);
        Selectionner = new JButton("Sélectionner");
        Ajouter = new JButton("Ajouter");
        Supprimer = new JButton("Supprimer");
        Annuler = new JButton("Annuler");
        Payer = new JButton("Payer");

        TopPanel.add(UsernameField);
        TopPanel.add(Selectionner);
        TopPanel.add(Ajouter);
        TopPanel.add(Supprimer);
        TopPanel.add(Annuler);
        TopPanel.add(Payer);

        this.add(TopPanel, BorderLayout.NORTH);

        String[] Colonnes = {"Auteur", "Titre", "Sujet", "ISBN", "Quantite", "Prix"};
        TableDefaut = new DefaultTableModel(Colonnes, 0);
        ClientTable = new JTable(TableDefaut);
        ClientTable.setModel(TableDefaut);
        ClientTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Scroll = new JScrollPane(ClientTable);
        this.add(Scroll, BorderLayout.CENTER);
    }

    public void ShowMessage(String  Message)
    {
        JOptionPane.showMessageDialog(this, Message);
    }

    public void Selectionner()
    {

    }

    public void Ajouter()
    {

    }

    public void Supprimer()
    {

    }

    public void Annuler()
    {

    }

    public void Payer()
    {

    }

}
