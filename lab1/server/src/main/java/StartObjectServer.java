import model.Voluntar;
import repository.IVoluntarRepository;

import java.io.IOException;
import java.util.Properties;

public class StartObjectServer {
    private static int defaultPort = 55555;
    private IVoluntarRepository<String, Voluntar> vrepo;

    public int login(String nume, String parola) {
        Voluntar v = vrepo.findOne(nume);

        if (v != null) {
            if (v.getPassword().equals(parola)) return 1;
            else return 0;
        }
        else return -1;
    }

    public static void main(String[] args) throws ServerException {
        Properties serverProps = new Properties();

        try {
            serverProps.load(StartObjectServer.class.getResourceAsStream("/server.properties"));
            System.out.println("Server properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find server.properties "+e);
            return;
        }

        int chatServerPort = defaultPort;

        try {
            chatServerPort = Integer.parseInt(serverProps.getProperty("server.port"));
        } catch (NumberFormatException nef){
            System.err.println("Wrong Port Number" + nef.getMessage());
            System.err.println("Using default port " + defaultPort);
        }

        System.out.println("Starting server on port: " + chatServerPort);
        AbstractServer server = new MyConcurrentServer(chatServerPort);

        try {
            server.start();
        } catch (ServerException e) {
            System.err.println("Error starting the server" + e.getMessage());

        }
    }
}
