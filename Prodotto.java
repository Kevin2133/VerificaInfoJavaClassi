public class Prodotto{
    String codice;
    int giorno, mese;

    public Prodotto(String codice, int giorno, int mese){
        this.codice = codice;
        this.giorno = giorno;
        this.mese = mese;
    }

    public String getCodice(){
        return this.codice;
    }

    public int getGiorno(){
        return this.giorno;
    }

    public int getMese(){
        return this.mese;
    }

    public boolean verificaScadenza(int giorno, int mese){
        if((this.giorno == 0) || (this.mese == 0)){
            return false;
        }

        if(this.mese < mese){
            return true;
        }

        if((this.mese == mese) && (this.giorno < giorno)){
            return true;
        }

        return false;
    }

}