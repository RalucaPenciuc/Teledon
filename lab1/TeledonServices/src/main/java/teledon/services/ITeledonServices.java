package teledon.services;

import teledon.model.CazCaritabil;
import teledon.model.DTODonatie;
import teledon.model.Donator;
import teledon.model.Voluntar;

public interface ITeledonServices {
    void login(Voluntar voluntar, ITeledonObserver client) throws TeledonException;
    void logout(Voluntar voluntar, ITeledonObserver client) throws TeledonException;
    void adaugaDonatie(DTODonatie donatieDTO) throws TeledonException;
    Iterable<CazCaritabil> findAllCazuriCaritabile();
    Iterable<Donator> cautaDonatori(String nume);
}
