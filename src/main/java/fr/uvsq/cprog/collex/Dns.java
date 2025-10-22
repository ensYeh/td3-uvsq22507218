package fr.uvsq.cprog.collex;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Dns {

    final Properties properties = new Properties();
    public final Map<NomMachine,AdresseIP> Adresses = new HashMap<NomMachine,AdresseIP>() ;
    public  final Map<AdresseIP,NomMachine> Noms = new HashMap<AdresseIP,NomMachine>() ;

    public Dns() {
        List<String> list = null ;
        try{
            FileInputStream input = new FileInputStream("configuration/properties");
            properties.load(input) ;
            input.close();

            Path path = Paths.get(properties.getProperty("database.path"));
            list = Files.readAllLines(path, StandardCharsets.UTF_8) ;
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(list != null){
            for( String s : list ){
                String[] array = s.trim().split(" ") ;
                if(array.length != 2){
                    System.err.println("Fichier dns_data formaté incorrectement.");
                } else {
                    Noms.put(new AdresseIP(array[0]), new NomMachine(array[1]));
                    Adresses.put(new NomMachine(array[1]), new AdresseIP(array[0]));
                }
            }
        } else {
            System.err.println("Problème survenu lors du chargement des données, non traitée par les exceptions.");
        }
    }

    public AdresseIP getItem(NomMachine nom){
        return Adresses.get(nom);
    }

    public NomMachine getItem(AdresseIP adresse) {
        return Noms.get(adresse);
    }

    public void addItem(AdresseIP adresse, NomMachine nom) {
        if( getItem(nom) == null ) {
            String line = System.lineSeparator() + new DnsItem(adresse, nom).toString();
            try {
                Files.write(Paths.get(properties.getProperty("database.path")),
                        line.getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Noms.put(adresse, nom);
            Adresses.put(nom, adresse);
        }
        else
            System.out.println("L'adresse existe déjà");
    }
}
