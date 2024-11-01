package Modèle.LireConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties
{
    private static final String FICHIER_CONFIGURATION = System.getProperty("user.dir")  + "/src/Configuration/Configuration.properties";
    private Properties properties;

    public ConfigurationProperties()
    {
        properties = new Properties();
        try
        {
            FileInputStream fileIS = new FileInputStream(FICHIER_CONFIGURATION);
            properties.load(fileIS);
            fileIS.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getIPServeur()
    {
        return properties.getProperty("IP_Serveur");
    }

    public int getPortServeur()
    {
        String PORT = properties.getProperty("PORT_Serveur");
        try
        {
            return Integer.parseInt(PORT);
        }

        catch(NumberFormatException e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args)
    {
        ConfigurationProperties configurationProperties = new ConfigurationProperties();
        String IP = configurationProperties.getIPServeur();
        int Port = configurationProperties.getPortServeur();

        if(IP != null && Port > 0)
        {
            System.out.println("\nIP : \n" + IP);
            System.out.println("\nPort : \n" + Port);
        }
        else
        {
            System.out.println("\nErreur lors de la lecture du fichier de configuration");
        }
    }
}
