import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ligosIstorija implements ISutartis {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    String diagnoze, vaistai, irasoData;
    int ID;
    Pacientas pacientai = new Pacientas();
    int pacientoID = pacientai.gautiPacientoID();
    Date data = new Date();
    List<ligosIstorija> istorijos = new ArrayList<ligosIstorija>();
    Scanner skaityti =new Scanner(System.in);

    public ligosIstorija(String diagnoze, String vaistai, String irasoData, int pacientoID, Date data) {
        this.diagnoze = diagnoze;
        this.vaistai = vaistai;
        this.irasoData = irasoData;
        this.pacientoID = pacientoID;
        this.data = data;
    }
    public ligosIstorija(){}

    public String getDiagnoze() {return diagnoze;}
    public void setDiagnoze(String diagnoze) {this.diagnoze = diagnoze;}
    public String getVaistai() {return vaistai;}
    public void setVaistai(String vaistai) {this.vaistai = vaistai;}
    public String getIrasoData() {return irasoData;}
    public void setIrasoData(String irasoData) {this.irasoData = irasoData;}
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public int getPacientoID() {return pacientoID;}
    public void setPacientoID(int pacientoID) {this.pacientoID = pacientoID;}

    public void kurtiNauja() {


        System.out.println("Naujas įrašas sėkmingai sukurtas!");
    }

    @Override
    public void ieskotiEsamo() {
        System.out.println("Įveskite paieškos raktažodį: ");
        String ivestis = skaityti.nextLine();
        for (ligosIstorija ligosist : istorijos) {
            if (ivestis == irasoData || ivestis == String.valueOf(ID) || ivestis == String.valueOf(pacientoID)) {
                System.out.println(ligosist);
            }
        }
    }

    @Override
    public void Naikinti() {
        System.out.println("Iveskite įrašo, kurį norite panaikinti, ID: ");
        int ivestis = skaityti.nextInt();
        for (ligosIstorija ligosist : istorijos){
            if(ivestis == ID){
                istorijos.remove(ligosist);
            }
        }
    }
    @Override
    public void Perziureti(){
        for (ligosIstorija ligosist: istorijos){
            System.out.println(ligosist);
        }
    }
}
