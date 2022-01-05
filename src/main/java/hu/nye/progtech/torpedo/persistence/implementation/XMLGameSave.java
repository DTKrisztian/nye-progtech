package hu.nye.progtech.torpedo.persistence.implementation;

import java.io.File;
import javax.xml.namespace.QName;

import hu.nye.progtech.torpedo.service.controller.Player;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Game save handler.
 */

public class XMLGameSave implements GameSave {

    /**
     * This saves the player names to different xml files.
     */

    @Override
    public void save(String player, String file) {
        try {
            JAXBElement<String> jaxbElement =
                    new JAXBElement(new QName("player_nickname"),
                            String.class, player);
            JAXBContext jaxbContext = JAXBContext.newInstance(String.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(jaxbElement, new File(file + ".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    /**
     * Loads the player names.
     */

    @Override
    public Player load() {
        return null;
    }
}
