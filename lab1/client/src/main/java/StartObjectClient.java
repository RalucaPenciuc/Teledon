
import controller.mainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import repository.*;
import service.Service;

import java.io.IOException;
import java.util.Properties;

public class StartObjectClient {
    private static int defaultPort = 55555;
    private static String defaultServer = "localhost";

    public static void main(String[] args) {
        Properties clientProps = new Properties();

        try {
            clientProps.load(StartObjectClient.class.getResourceAsStream("/client.properties"));
            System.out.println("Client properties set. ");
            clientProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find client.properties " + e);
            return;
        }

        String serverIP = clientProps.getProperty("server.host", defaultServer);
        int serverPort = defaultPort;

        try {
            serverPort = Integer.parseInt(clientProps.getProperty("server.port"));
        } catch(NumberFormatException ex) {
            System.err.println("Wrong port number " + ex.getMessage());
            System.out.println("Using default port: " + defaultPort);
        }

        System.out.println("Using server IP " + serverIP);
        System.out.println("Using server port " + serverPort);
//        IChatServer server = new ChatServerObjectProxy(serverIP, serverPort);
//        ChatClientCtrl ctrl = new ChatClientCtrl(server);


        IVoluntarRepository<String, Voluntar> vrepo = new VoluntarRepository(clientProps);
        ICazCaritabilRepository<String, CazCaritabil> ccrepo = new CazCaritabilRepository(clientProps);
        IDonatorRepository<String, Donator> drepo = new DonatorRepository(clientProps);
        IDonatieRepository<Pair<CazCaritabil, Donator>, Donatie> ddrepo = new DonatieRepository(clientProps);

        Service service = new Service(vrepo, ccrepo, drepo, ddrepo);

        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StartObjectClient.class.getResource("fxml/mainWindow.fxml"));
            Parent root = loader.load();

            mainWindowController controller = loader.getController();
            controller.setController(service);

            primaryStage.setTitle("Teledon: Login voluntar");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
