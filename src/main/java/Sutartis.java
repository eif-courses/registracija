import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Sutartis implements ISutartis {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    private String sudarymoData;
    private int ID;
    Globejas globejas = new Globejas();
    int globejoAK = globejas.gautiGlobejoAK();
    String gvardas = globejas.gautiVarda();
    String gpavarde = globejas.gautiPavarde();
    Darbuotojas darbuotojas = new Darbuotojas();
    Integer darbuotojoID = darbuotojas.gautiDarbuotojoID();
    String dvardas = darbuotojas.gautiVarda();
    String dpavarde = darbuotojas.gautiPavarde();
    Date data = new Date();
    Pacientas pacientas = new Pacientas();
    int pacientoID = pacientas.gautiPacientoID();
    String pvardas = pacientas.gautiVarda();
    Scanner skaityti = new Scanner(System.in);
    List<Sutartis> sutartys = new ArrayList<Sutartis>();

    public Sutartis(SimpleDateFormat formatter, int darbuotojoID, String sudarymoData, int globejoAK, int ID) {
        this.formatter = formatter;
        this.darbuotojoID = darbuotojoID;
        this.sudarymoData = sudarymoData;
        this.globejoAK = globejoAK;
        this.ID = ID;
    }
    public Sutartis(){}

    public int getDarbuotojoID() {return darbuotojoID;}
    public void setDarbuotojoID(int darbuotojoID) {this.darbuotojoID = darbuotojoID;}
    public String getSudarymoData() {return sudarymoData;}
    public void setSudarymoData(String sudarymoData) {this.sudarymoData = sudarymoData;}
    public int getGlobejoAK() {return globejoAK;}
    public void setGlobejoAK(int globejoAK) {this.globejoAK = globejoAK;}
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

    public void kurtiNauja() {
        String  sudarymoData;
        int darbuotojoID=0, ID, globejoAK = 0, pacientoID=0;
        ID= sutartys.size()+1;
        System.out.println("Nauja sutartis ID: "+ID);
        sudarymoData=formatter.format(data);
        System.out.println("Sudarymo data: "+sudarymoData);
        System.out.println("Pasirašančio darbuotojo ID: ");
        int ivestis = skaityti.nextInt();
        for (Darbuotojas darb: darbuotojas.darbuotojai){
            if(ivestis==darbuotojoID){
                System.out.println("Ar tai šis darbuotojas: "+dvardas+" "+dpavarde+"? T/N");
                String ats = skaityti.nextLine();
                if (ats=="T"){
                    darbuotojoID=ivestis;
                }
                if (ats=="N"){
                    System.out.println("Patikslinkite darbuotojo ID: ");
                }
            }
        }
        System.out.println("Pasirašančio globėjo asmens kodas: ");
        ivestis = skaityti.nextInt();
        for (Globejas glob: globejas.globejai){
            if(ivestis==globejoAK){
            System.out.println("Ar tai šis globėjas: "+gvardas+" "+gpavarde+"? T/N");
            String ats = skaityti.nextLine();
            if(ats=="T"){
                globejoAK=ivestis;
            }
            if(ats=="N"){
                System.out.println("Patikslinkite asmens kodą: ");
            }}
        }
        System.out.println("Paciento ID: ");
        ivestis = skaityti.nextInt();
        for (Pacientas pac: pacientas.pacientai){
            if(ivestis==pacientoID){
                System.out.println("Ar tai šis pacientas: "+pvardas+"? (T/N)");
                String ats = skaityti.nextLine();
                if(ats=="T"){
                    pacientoID=ivestis;
                }
                if(ats=="N"){
                    System.out.println("Patikslinkite paciento ID: ");
                }
            }
        }
        System.out.println("Nauja sutartis sėkmingai sukurta!");
    }

    @Override
    public void ieskotiEsamo() {
        System.out.println("Įveskite paieškos raktažodį:");
        String ivestis = skaityti.nextLine();
        for (Sutartis sut : sutartys) {
            if (ivestis == String.valueOf(globejoAK) || ivestis == String.valueOf(darbuotojoID) || ivestis == String.valueOf(pacientoID) || ivestis == String.valueOf(ID)) {
                System.out.println(sut);
            }
        }
    }

    @Override
    public void Naikinti() {
        System.out.println("Iveskite sutarties, kurią norite panaikinti, ID: ");
        int ivestis = skaityti.nextInt();
        for (Sutartis sut : sutartys){
            if(ivestis == ID){
                sutartys.remove(sut);
            }
        }
    }
    @Override
    public void Perziureti(){
        for (Sutartis sut: sutartys){
            System.out.println(sut);
        }
    }
}
