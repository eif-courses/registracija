import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pacientas extends Globejas implements ISutartis {
    private String vardas, spalva, veisle;
    private int amzius, cipoNr, pacientoID, globejas;
    Lytis lytis;
    Cipas cipas;
    Tipas tipas;
    Globejas glob = new Globejas();
    int globejoAK = glob.gautiGlobejoAK();
    public int gautiPacientoID(){return this.pacientoID;}
    public String gautiVarda(){return this.vardas;}

    List<Pacientas> pacientai = new ArrayList<Pacientas>();
    Scanner skaityti = new Scanner(System.in);

    public Pacientas(String vardas, String spalva, String veisle, int amzius, int cipoNr, int pacientoID, int globejas) {
        this.vardas = vardas;
        this.spalva = spalva;
        this.veisle = veisle;
        this.amzius = amzius;
        this.cipoNr = cipoNr;
        this.pacientoID = pacientoID;
        this.globejas=globejas;
    }

    public Pacientas(){}

    public String getVardas() {return vardas;}
    public void setVardas(String vardas) {this.vardas = vardas;}
    public String getSpalva() {return spalva;}
    public void setSpalva(String spalva) {this.spalva = spalva;}
    public String getVeisle() {return veisle;}
    public void setVeisle(String veisle) {this.veisle = veisle;}
    public int getAmzius() {return amzius;}
    public void setAmzius(int amzius) {this.amzius = amzius;}
    public int getCipoNr() {return cipoNr;}
    public void setCipoNr(int cipoNr) {this.cipoNr = cipoNr;}
    public int getPacientoID() {return pacientoID;}
    public void setPacientoID(int pacientoID) {this.pacientoID = pacientoID;}

    public void kurtiNauja() {
        int a=0;
        String vardas;
        String spalva;
        String veisle;
        int amzius;
        int cipoNr=0;
        int pacientoID;
        int globejas = 0;
        Lytis lytis = null;
        Cipas cipas = null;
        Tipas tipas = null;
        pacientoID=pacientai.size()+1;
        System.out.println("Naujas pacientas: "+pacientoID);
        System.out.println("Globėjo asmens kodas:");
        int ivestis = skaityti.nextInt();
        for(Globejas glob: globejai) {
            if(ivestis == globejoAK){
                globejoAK=ivestis;
            }
        }
        System.out.println("Vardas: ");
        vardas=skaityti.nextLine();
        System.out.println("Pasirinkite tipą:");
        System.out.println("1. Katė");
        System.out.println("2. Šuo");
        System.out.println("3. Graužikas");
        System.out.println("4. Žuvis");
        System.out.println("5. Roplys");
        System.out.println("6. Kita");
        try {
            a = skaityti.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Įveskite skaičių.");
        }
        switch (a){
            case 1:
                tipas= Tipas.KATĖ; break;
            case 2:
                tipas= Tipas.ŠUO; break;
            case 3:
                tipas= Tipas.GRAUŽIKAS; break;
            case 4:
                tipas= Tipas.ŽUVIS; break;
            case 5:
                tipas= Tipas.ROPLYS; break;
            case 6:
                tipas= Tipas.KITA; break;
        }
        System.out.println("Veislė: ");
        veisle=skaityti.nextLine();
        System.out.println("Spalva: ");
        spalva=skaityti.nextLine();
        System.out.println("Amžius: ");
        amzius=skaityti.nextInt();
        System.out.println("Ar augintinis čipuotas? (0 - ne, 1 - taip)");
        try {
            a = skaityti.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Įveskite skaičių.");
        }
        switch (a){
            case 0:
                cipas= Cipas.NEČIPUOTAS;
                cipoNr=0;
                break;
            case 1:
                cipas= Cipas.ČIPUOTAS;
                System.out.println("Čipo numeris: ");
                cipoNr=skaityti.nextInt();
                break;
        }
        System.out.println("Augintinio lytis (0 - patinas, 1 - patelė)");
        try {
            a = skaityti.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Įveskite skaičių.");
        }
        switch (a){
            case 0:
                lytis= Lytis.PATINAS; break;
            case 1:
                lytis= Lytis.PATELĖ; break;
        }
        pacientai.add(new Pacientas(vardas, spalva, veisle, amzius, cipoNr, pacientoID, globejas));
        System.out.println("Naujas pacientas sėkmingai sukurtas!");
    }
    /*String vardas;
        String spalva;
        String veisle;
        int amzius;
        int cipoNr;
        int pacientoID;
        int globejas;
        Lytis lytis;
        Cipas cipas;
        Tipas tipas;*/

    @Override
    public void ieskotiEsamo() {
        System.out.println("Iveskite paieškos raktažodį:");
        String ivestis = skaityti.nextLine();
        for (Pacientas pac : pacientai) {
            if (ivestis == String.valueOf(pacientoID) || ivestis == vardas || ivestis == String.valueOf(cipoNr) || ivestis == String.valueOf(globejoAK)) {
                System.out.println(pac);
            }
        }
    }

    @Override
    public void Naikinti() {
        System.out.println("Iveskite paciento, kurį norite panaikinti, ID: ");
        int ivestis = skaityti.nextInt();
        for (Pacientas pac : pacientai){
            if(ivestis == pacientoID){
                pacientai.remove(pac);
            }
        }
    }
    public void globejoNaikinimas(){
        glob.Naikinti();
        int ivestis = skaityti.nextInt();
        for (Globejas glob : globejai){
            if(ivestis == globejoAK){
                globejai.remove(glob);
                for(Pacientas pac: pacientai){
                    if(ivestis==globejoAK){
                        pacientai.remove(pac);
                    }}}}}
    @Override
    public void Perziureti(){
        for (Pacientas pac: pacientai){
            System.out.println(pac);
        }
    }
    public List<Pacientas> getPacientai(){
        return pacientai;
    }
}
