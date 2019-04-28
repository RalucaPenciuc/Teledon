package teledon.services;

import teledon.model.CazCaritabil;
import teledon.model.DTODonatie;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITeledonObserver extends Remote {
    void updateCazuriList(Iterable<CazCaritabil> cazuriCaritabile) throws TeledonException, RemoteException;
}
