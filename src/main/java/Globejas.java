import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Globejas implements ISutartis {
    private String vardas, pavarde, telNr, adresas;
    private int globejoAK;

    public Globejas() {
    }

    public int gautiGlobejoAK(){return this.globejoAK;}
    public String gautiVarda(){return this.vardas;}
    public String gautiPavarde(){return this.pavarde;}
    List<Globejas> globejai = new ArrayList<Globejas>();
    Scanner skaityti = new Scanner(System.in);

    public Globejas(int globejoAK, String vardas, String pavarde, String telNr, String adresas) {
        this.globejoAK = globejoAK;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telNr = telNr;
        this.adresas = adresas;
    }

    public int getGlobejoAK() {return globejoAK;}
    public void setGlobejoAK(int globejoAK) {this.globejoAK = globejoAK;}
    public String getVardas() {return vardas;}
    public void setVardas(String vardas) {this.vardas = vardas;}
    public String getPavarde() {return pavarde;}
    public void setPavarde(String pavarde) {this.pavarde = pavarde;}
    public String getTelNr() {return telNr;}
    public void setTelNr(String telNr) {this.telNr = telNr;}
    public String getAdresas() {return adresas;}
    public void setAdresas(String adresas) {this.adresas = adresas;}

    public void kurtiNauja() {
        String vardas, pavarde, telNr, adresas;
        int globejoAK;
        System.out.println("Naujas Globėjas:");
        System.out.println("Asmens kodas:");
        globejoAK=skaityti.nextInt();
        System.out.println("Vardas:");
        vardas=skaityti.nextLine();
        System.out.println("Pavardė:");
        pavarde=skaityti.nextLine();
        System.out.println("Telefono numeris:");
        telNr=skaityti.nextLine();
        System.out.println("Gyvenamosios vietos adresas:");
        adresas=skaityti.nextLine();
        System.out.println("Naujas globėjas sėkmingai sukurtas!");

    }

    @Override
    public void ieskotiEsamo() {
        System.out.println("Įveskite paieškos raktažodį:");
        String ivestis = skaityti.nextLine();
        for (Globejas glob : globejai) {
            if (ivestis == String.valueOf(globejoAK) || ivestis == vardas || ivestis == pavarde || ivestis == telNr || ivestis == adresas) {
                System.out.println(glob);
            }
        }
    }
    @Override
    public void Perziureti(){
        for (Globejas glob: globejai){
            System.out.println(glob);
        }
    }
    @Override
    public void Naikinti() {
        System.out.print("Iveskite globėjo, kurį norite panaikinti, asmens kodą: ");
    }
    public List<Globejas> getGlobejas(){
        return globejai;
    }
}
