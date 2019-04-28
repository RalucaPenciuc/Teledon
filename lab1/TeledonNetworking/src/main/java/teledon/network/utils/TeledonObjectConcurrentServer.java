package teledon.network.utils;

import teledon.network.objectprotocol.TeledonClientObjectWorker;
import teledon.services.ITeledonServices;
import java.net.Socket;

public class TeledonObjectConcurrentServer extends AbstractConcurrentServer {
    private ITeledonServices teledonServer;

    public TeledonObjectConcurrentServer(int port, ITeledonServices teledonServer) {
        super(port);
        this.teledonServer = teledonServer;
        System.out.println("Teledon - TeledonObjectConcurrentServer");
    }

    @Override
    protected Thread createWorker(Socket client) {
        TeledonClientObjectWorker worker = new TeledonClientObjectWorker(teledonServer, client);
        Thread tw = new Thread(worker);
        return tw;
    }
}