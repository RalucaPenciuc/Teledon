import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import teledon.services.ITeledonServices;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartTeledonServer {
    public static void main(String[] args) {
//        System.setProperty("java.rmi.server.hostname","172.30.113.166");

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-server.xml");

        System.out.println("Waiting for clients...");
    }
}
