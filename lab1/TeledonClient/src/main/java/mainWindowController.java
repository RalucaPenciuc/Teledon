import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import teledon.model.CazCaritabil;
import teledon.model.Voluntar;
import teledon.services.ITeledonObserver;
import teledon.services.ITeledonServices;
import teledon.services.TeledonException;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MainWindowController extends UnicastRemoteObject implements ITeledonObserver, Serializable {
    private ITeledonServices server;
    private Voluntar voluntar;
    private CazCaritabilWindowController teledonController;

    Parent mainChatParent;

    @FXML private TextField numeUtilizator;
    @FXML private PasswordField parolaUtilizator;
    @FXML private Button loginButton;

    public MainWindowController() throws RemoteException {
    }

    public void setServer(ITeledonServices server) { this.server = server; }

    public void setTeledonController(CazCaritabilWindowController teledonController) { this.teledonController = teledonController; }

    public void setParent(Parent p){ mainChatParent = p; }

    @FXML
    private void clickLoginButton(ActionEvent actionEvent) {
        String nume = numeUtilizator.getText();
        String parola = parolaUtilizator.getText();
        voluntar = new Voluntar(nume, parola);
        try {
            Stage stage = new Stage();
            stage.setTitle("Teledon");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindowController.class.getResource("/cazCaritabilWindow.fxml"));
            AnchorPane root = loader.load();
            stage.setScene(new Scene(root));

            teledonController = loader.getController();

            server.login(voluntar, teledonController);

            teledonController.setService(stage, server);
            teledonController.setUser(voluntar);

            stage.setOnCloseRequest(event -> {
                teledonController.logout();
                System.exit(0);
            });

            stage.show();
            teledonController.setUser(voluntar);
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

        } catch (TeledonException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Teledon");
            alert.setHeaderText("Authentication failure");
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCazuriList(Iterable<CazCaritabil> cazuriCaritabile) throws TeledonException, RemoteException {

    }
}
