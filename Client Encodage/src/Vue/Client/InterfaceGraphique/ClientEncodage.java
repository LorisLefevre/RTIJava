package Vue.Client.InterfaceGraphique;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientEncodage extends JFrame {
    private JTextField UsernameField;
    private JTextField PasswordField;

    public JTextField getUsername() {
        return UsernameField;
    }

    public void setUsername(String username) {
        UsernameField.setText(username);
    }

    public JTextField getPassword() {
        return PasswordField;
    }

    public void setPassword(String password) {
        PasswordField.setText(password);
    }

    private JButton Selectionner;
    private JButton Ajouter;
    private JButton Supprimer;
    private JButton Annuler;
    private JButton Payer;

    private JPanel TopPanel;
    private JScrollPane Scroll;

    private JTable ClientTable;
    private DefaultTableModel TableDefaut;

    private JTable PrénomNomTable;
    private JTable NomTable;

    public ClientEncodage() {
        super("Fenetre Java de Client Encodage");

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        TopPanel = new JPanel();
        TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        UsernameField = new JTextField("Utilisateur");
        UsernameField.setEditable(false);
        PasswordField = new JTextField("Mot de passe");
        PasswordField.setEditable(true);
        Selectionner = new JButton("Sélectionner");
        Ajouter = new JButton("Ajouter");
        Supprimer = new JButton("Supprimer");
        Annuler = new JButton("Annuler");
        Payer = new JButton("Payer");

        TopPanel.add(UsernameField);
        TopPanel.add(PasswordField);
        TopPanel.add(Selectionner);
        TopPanel.add(Ajouter);
        TopPanel.add(Supprimer);
        TopPanel.add(Annuler);
        TopPanel.add(Payer);

        this.add(TopPanel, BorderLayout.NORTH);

        // Table des clients
        String[] ColonnesClient = {"Id", "Titre", "Auteur", "Sujet", "ISBN", "Pages", "Année", "Prix", "Stock"};
        TableDefaut = new DefaultTableModel(ColonnesClient, 0);
        ClientTable = new JTable(TableDefaut);
        ClientTable.setModel(TableDefaut);
        ClientTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Scroll = new JScrollPane(ClientTable);
        this.add(Scroll, BorderLayout.SOUTH); // Place la JTable en bas

        // Panel pour les deux nouvelles JTables
        JPanel SecondRowPanel = new JPanel(new GridLayout(1, 2));

        // JTable Prénom et Nom
        String[] ColonnesPrenomNom = {"Prénom", "Nom"};
        DefaultTableModel PrenomNomModel = new DefaultTableModel(ColonnesPrenomNom, 0);
        PrénomNomTable = new JTable(PrenomNomModel);
        SecondRowPanel.add(new JScrollPane(PrénomNomTable));

        // JTable Nom
        String[] ColonnesNom = {"Nom"};
        DefaultTableModel NomModel = new DefaultTableModel(ColonnesNom, 0);
        NomTable = new JTable(NomModel);
        SecondRowPanel.add(new JScrollPane(NomTable));

        this.add(SecondRowPanel, BorderLayout.CENTER); // Ajoute le panel au centre
    }

    public void ShowMessage(String Message) {
        JOptionPane.showMessageDialog(this, Message);
    }

    public void Selectionner() {}

    public void Ajouter() {}

    public void Supprimer() {}

    public void Annuler() {}

    public void Payer() {}
}
