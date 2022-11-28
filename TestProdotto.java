import java.util.*;
public class TestProdotto {

    public static int trovaProdotto(String codice, Prodotto[] prodotti, int index){
        for(int i = 0; i < index; i++){
            if(prodotti[i].getCodice().equals(codice)){
                return i;
            }
        }
        return -1;
    }

    public static boolean contieneSeq(String codice){
        String seq = "000";
        if(codice.indexOf(seq) < 0){
            return false;
        }

        return true;
    }

    public static Prodotto[] ordina(Prodotto[] prodotti, int index){
        boolean ordinato;
        Prodotto temp;

        do{
            ordinato = true;
            for(int i = index - 1; i > 0; i--){
                if(prodotti[i].getCodice().compareTo(prodotti[i - 1].getCodice()) < 0){
                    temp = prodotti[i - 1];
                    prodotti[i - 1] = prodotti[i];
                    prodotti[i] = temp;
                    ordinato = false;
                }
            }

            if(!ordinato){
                ordinato = true;
                for(int i = 0; i < index - 1; i++){
                    if(prodotti[i].getCodice().compareTo(prodotti[i + 1].getCodice()) > 0){
                        temp = prodotti[i + 1];
                        prodotti[i + 1] = prodotti[i];
                        prodotti[i] = temp;
                        ordinato = false;
                    }
                }
            }
        }while(!ordinato);

        return prodotti;
    }
    
    public static void main(String arg[]){
        Prodotto[] prodotti = new Prodotto[500];
        int index = 0, scelta, giorno, mese, ind;
        String codice;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("0. esci");
            System.out.println("1. inserisci prodotto");
            System.out.println("2. visualizza prodotti");
            System.out.println("3. verifica scadenza prodotto in input");
            System.out.println("4. conta gli zeri nei codici a barre");
            System.out.println("5. Ordina i prodotti con ShakeSort");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 0:
                    break;
                case 1:
                    if(index < 500){
                        System.out.println("Inserisci il codice");
                        codice = scanner.nextLine();
                        System.out.println("Inserisci giorno scadenza");
                        giorno = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci mese scadenza");
                        mese = scanner.nextInt();
                        scanner.nextLine();

                        prodotti[index] = new Prodotto(codice, giorno, mese);
                        index++;
                    }
                    break;
                case 2:
                    if(index > 0){
                        for(int i = 0; i < index; i++){
                            System.out.println("Codice= " + prodotti[i].getCodice());
                            System.out.println("MeseScad= " + prodotti[i].getMese());
                            System.out.println("GiornoScad = " + prodotti[i].getGiorno());
                        }
                    }else{
                        System.out.println("Array vuoto");
                    }
                    break;
                case 3:
                    System.out.println("inserisci codice da cercare");
                    codice = scanner.nextLine();
                    ind = trovaProdotto(codice, prodotti, index);

                    if(ind > -1){
                        System.out.println("Inserisci giorno e mese correnti");
                        giorno = scanner.nextInt();
                        scanner.nextLine();
                        mese = scanner.nextInt();
                        scanner.nextLine();

                        if(prodotti[ind].verificaScadenza(giorno, mese)){
                            System.out.println("Il prodotto è scaduto");
                        }else{
                            System.out.println("Il prodotto non è scaduto");
                        }
                    }else{
                        System.out.println("Prodotto non trovato");
                    }
                    break;
                case 4:
                    if(index > 0){
                        for(int i = 0; i < index; i++){
                            if(contieneSeq(prodotti[i].getCodice())){
                                System.out.println("Il prodotto con codice " + prodotti[i].getCodice() + " contiene la sequenza 000");
                            }else{
                                System.out.println("Il prodotto con codice " + prodotti[i].getCodice() + " non contiene la sequenza 000");
                            }
                        }
                    }else{
                        System.out.println("Array vuoto");
                    }
                    break;
                case 5:
                    if(index < 1){
                        System.out.println("Array vuoto");
                    }else{
                        prodotti = ordina(prodotti, index);
                    }
                    break;
                default:
                    System.out.println("scelta non prevista");
                    break;
            }
        }while(scelta != 0);


    }
}
