import java.util.*;
import java.util.Set;

public class EuroJackpot {

    int brojIgraca;
    int counter = 0;
    int counter1 = 0;

    Scanner scan = new Scanner(System.in);

    List<String> listaImena = new ArrayList<>();
    List<Integer> prviSkup = new ArrayList<>();
    List<Integer> drugiSkup = new ArrayList<>();
    Set<Integer> izvuceni = new HashSet<Integer>();
    Set<Integer> izvuceni1 = new HashSet<Integer>();
    List<Integer> brojac = new ArrayList<>();
    List<Integer> brojac1 = new ArrayList<>();


    public void pozdravnaPoruka(){
        System.out.println("\nDobrodošli u COBE EuroJackpot!\n\n******** KREATOR IGRE SE NE OBAVEZUJE ISPLATITI POTENCIJALNE DOBITKE!! :P ********");
    }

    public void generiranjeBrojeva(){
        for(int i = 1; i < 51; i++){
            prviSkup.add(i);
        }
        for(int i = 1; i < 11; i++){
            drugiSkup.add(i);
        }
        System.out.println("\nPrvi skup brojeva je: " + prviSkup + ". \nDrugi skup brojeva je: " + drugiSkup + ".");
    }

    public void brojNatjecatelja(){
        System.out.print("\nMolimo Vas da unesete broj igrača: ");
        brojIgraca = scan.nextInt();
    }

    public void unosIgraca(){
        for(int i = 0; i < brojIgraca; i++){
            System.out.println("Unesite ime " + (i+1) + ". igrača: ");
            String ime = scan.next();
            listaImena.add(ime);
        }
    }

    public void biranjeBrojeva(){
        Collections.shuffle(prviSkup);
        while (izvuceni.size() < 5){
            Integer broj = prviSkup.get(izvuceni.size());
            izvuceni.add(broj);
        }
        Collections.shuffle(drugiSkup);
        while (izvuceni1.size() < 2){
            Integer broj = drugiSkup.get(izvuceni1.size());
            izvuceni1.add(broj);
        }
        for(int i = 0; i < brojIgraca; i++){
            System.out.println("\nMolimo igrača pod imenom '" + listaImena.get(i) + "' da odabere brojeve iz prvog skupa (1-50): ");
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                int odabraniBrojevi = scan.nextInt();
                list.add(odabraniBrojevi);
                list.retainAll(izvuceni);
                counter = list.size();
            }
            System.out.println("Nakon odabira brojeva iz prvog skupa potrebno je odabrati dopunske brojve (1-10): ");
            List<Integer> list1 = new ArrayList<>();
            for(int j = 0; j < 2; j++){
                int odabraniBrojevi1 = scan.nextInt();
                list1.add(odabraniBrojevi1);
                list1.retainAll(izvuceni1);
                counter1 = list1.size();
            }
            brojac.add(counter);
            brojac1.add(counter1);
        }
    }
    public void izvlacenjeBrojeva(){
        System.out.println("\nSretno svim sudionicima, kuglice ulaze u virtualni bubanj!");
        System.out.print("Brojevi iz prvog bubnja su: ");
        for(Integer s : izvuceni){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(s + " ");
        }
        System.out.print(", te dopunski brojevi: ");
        for(Integer p : izvuceni1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.print(p + " ");
        }
        System.out.println(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void provjeraDobitaka(){
        System.out.println("Provjerimo današnje dobitke: ");
        for(int k = 0; k < brojIgraca; k++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("\nIgrač/ica pod imenom: '" + listaImena.get(k) + "' pogodio/la je: " + brojac.get(k) + "+" + brojac1.get(k));
            if(brojac.get(k) > 0 && brojac1.get(k) > 1){
                System.out.println("Čestitamo! Vaš dobitak će možda biti isplaćen jednog dana.");
            }else if(brojac.get(k) > 1 && brojac1.get(k) > 0){
                System.out.println("Čestitamo! Vaš dobitak će možda biti isplaćen jednog dana.");
            }else if(brojac.get(k) > 2 && brojac1.get(k) == 0){
                System.out.println("Čestitamo! Vaš dobitak će možda biti isplaćen jednog dana.");
            }else if(brojac.get(k) == 5 && brojac1.get(k) == 2){
                System.out.println("Osvojili ste COBE Eurojackpot, ali nažalost niste postali multi milijunaš!");
            }
            else{
                System.out.println("Više sreće drugi put! :(");
            }
        }
    }
    public void zahvalaKorisnicima(){
        System.out.println("Hvala na sudjelovanju u našoj igri i dođite nam opet!");
    }

    public static void main(String[] args) {
        EuroJackpot ej = new EuroJackpot();


        ej.pozdravnaPoruka();
        ej.generiranjeBrojeva();
        ej.brojNatjecatelja();
        ej.unosIgraca();
        ej.biranjeBrojeva();
        ej.izvlacenjeBrojeva();
        ej.provjeraDobitaka();
        ej.zahvalaKorisnicima();
    }
}

