package Modèle.BasesdeDonnées.Requetes;
import java.sql.*;

public class ConnexionBD
{
    Connection connection = null;

    public ConnexionBD(String IP)throws ClassNotFoundException, SQLException
    {
        try
        {
            Class<?> Driver = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\nDriver obtenu\n");

            connection = DriverManager.getConnection("jdbc:mysql://" + IP + "/PourStudent", "root", "");
            System.out.println("\nConnexion à la base de données réussie");
        }

        catch(ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public synchronized ResultSet getTuple(String SQL)throws SQLException
    {
        Statement statement = connection.createStatement();
        return statement.executeQuery(SQL);
    }

    public synchronized int ExecuterUpdate(String SQL)throws SQLException
    {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(SQL);
    }

    public synchronized void Close()throws SQLException
    {
        if(connection != null && !connection.isClosed())
        {
            try
            {
                connection.close();
                System.out.println("\nConnexion à la base de donnée fermée\n");
            }

            catch(SQLException e)
            {
                System.out.println("\nErreur lors de la fermeture de la connexion à la base de données : " + e);
            }
        }
    }



}
