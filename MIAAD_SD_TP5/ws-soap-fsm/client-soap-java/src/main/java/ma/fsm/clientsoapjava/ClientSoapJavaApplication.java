package ma.fsm.clientsoapjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

@SpringBootApplication
public class ClientSoapJavaApplication {

    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDH(90));
        Compte compte = proxy.getCompte(4);
        System.out.println("---------------------------");
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        System.out.println(compte.getDateCreation());


        proxy.listComptes().forEach(cp ->{
            System.out.println("---------------------------");
            System.out.println(cp.getCode());
            System.out.println(cp.getSolde());
            System.out.println(cp.getDateCreation());

        });
    }

}
