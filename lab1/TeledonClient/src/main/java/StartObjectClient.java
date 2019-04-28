import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import teledon.services.ITeledonServices;

public class StartObjectClient extends Application {
    public void start(Stage primaryStage) {
        System.out.println("In start");

        try {
            ApplicationContext factory = new ClassPathXmlApplicationContext("spring-client.xml");
            ITeledonServices server = (ITeledonServices) factory.getBean("teledonService");
            System.out.println("Obtained a reference to remote teledon server");

            FXMLLoader loginLoader = new FXMLLoader();
            loginLoader.setLocation(StartObjectClient.class.getResource("mainWindow.fxml"));
            Parent root = loginLoader.load();

            MainWindowController loginController = loginLoader.<MainWindowController>getController();
            loginController.setServer(server);


            FXMLLoader cazLoader = new FXMLLoader();
            cazLoader.setLocation(StartObjectClient.class.getResource("cazCaritabilWindow.fxml"));
            Parent croot = cazLoader.load();

            CazCaritabilWindowController cazController = cazLoader.<CazCaritabilWindowController>getController();
            cazController.setServer(server);

            loginController.setTeledonController(cazController);
            loginController.setParent(croot);


            primaryStage.setTitle("Teledon");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();


        } catch (Exception e) {
            System.err.println("Teledon initialization exception: " + e);
            e.printStackTrace();
        }
    }
}
