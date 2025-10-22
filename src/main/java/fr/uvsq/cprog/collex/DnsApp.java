package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsApp {
    final Dns dns = new Dns();
    final DnsTUI dnsUI = new DnsTUI(dns) ;

    public DnsApp(){}

    public void run(){
        Scanner scanner = new Scanner(System.in); ;
        while(dnsUI.running){
            System.out.print("> ");
            String command = scanner.nextLine();
            dnsUI.nextCommand(command) ;
        }
        //scanner.close();
    }

    public static void main(String[] args) {
        DnsApp app = new DnsApp();
        app.run();
    }
}
