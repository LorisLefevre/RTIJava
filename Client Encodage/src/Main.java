import Vue.Client.InterfaceGraphique.FenetreClient;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        FenetreClient fenetreClient = new FenetreClient();
        fenetreClient.setUsername("LorisRace");
        fenetreClient.setVisible(true);
    }
}