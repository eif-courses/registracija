import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner skaityti = new Scanner(System.in);
        int a=0, b=0;
        Darbuotojas darb = new Darbuotojas();
        Globejas glob = new Globejas();
        Pacientas pac = new Pacientas();
        Sutartis sut = new Sutartis();
        ligosIstorija li = new ligosIstorija();
        String Meniu =("Meniu: \n"
	    +"1. Darbuotojai\n"
	    +"2. Globėjai\n"
	    +"3. Pacientai\n"
	    +"4. Sutartys\n"
	    +"5. Ligos istorijos\n"
        +"6. Baigti darbą");
	    String veiksmuMeniu=("1. Peržiūrėti esamus\n"
        +"2. Kurti naują\n"
        +"3. Ieškoti\n"
        +"4. Naikinti\n"
        +"5. Grįžti į pagrindinį meniu");

	    do{
	    System.out.println(Meniu);

        try{
            a=skaityti.nextInt();
        }
        catch (InputMismatchException e){
            while (a<1 || a>6){
                System.out.println("Neteisingai įvedėte, įveskite skaičių nuo 1 iki 6.");
                System.out.println(Meniu);
                a=skaityti.nextInt();
            }
        }

        if(a==1) {
            do{
            System.out.println("Darbuotojai:");
            System.out.println(veiksmuMeniu);
            try {b = skaityti.nextInt();}
            catch (InputMismatchException e) {
                System.out.println("Įveskite skaičių!");
                skaityti.next();}
            while (b < 1 || b > 5) {
                System.out.println("Neteisingai įvedėte, įveskite skaičių nuo 1 iki 5.");
                System.out.println(Meniu);
                b = skaityti.nextInt();
            }

            if (b == 1) {
                darb.Perziureti();
            }
            if (b == 2) {
                darb.kurtiNauja();
            }
            if (b == 3) {
                darb.ieskotiEsamo();
            }
            if (b == 4) {
                darb.Naikinti();
            }}while(b!=5);
        }
        if(a==2){
            do{
                System.out.println("Globėjai:");
                System.out.println(veiksmuMeniu);
                try{b=skaityti.nextInt();}
                catch (InputMismatchException e){
                    System.out.println("Įveskite skaičių!");
                    skaityti.next();}
                while (b<1 || b>5){
                    System.out.println("Neteisingai įvedėte, įveskite skaičių nuo 1 iki 5.");
                    System.out.println(Meniu);
                    a=skaityti.nextInt();}
                if(b==1){
                    glob.Perziureti();
                }
                if(b==2){
                    glob.kurtiNauja();
                }
                if(b==3){
                    glob.ieskotiEsamo();
                }
                if(b==4){
                    glob.Naikinti();
                }
            } while(b!=5);
        }
        if(a==3){
            System.out.println("Pacientai:");
            do{
                System.out.println(veiksmuMeniu);
                b=skaityti.nextInt();
                if(b==1){
                    pac.Perziureti();
                }
                if(b==2){
                    pac.kurtiNauja();
                }
                if(b==3){
                    pac.ieskotiEsamo();
                }
                if(b==4){
                    pac.Naikinti();
                }
            } while(b!=5);
        }
        if(a==4){
            System.out.println("Sutartys:");
            do{
                System.out.println(veiksmuMeniu);
                b=skaityti.nextInt();
                if(b==1){
                    sut.Perziureti();
                }
                if(b==2){
                    sut.kurtiNauja();
                }
                if(b==3){
                    sut.ieskotiEsamo();
                }
                if(b==4){
                    sut.Naikinti();
                }
            } while(b!=5);
        }
        if(a==5){
            System.out.println("Ligos istorijos:");
            do{
                System.out.println(veiksmuMeniu);
                b=skaityti.nextInt();
                if(b==1){
                    li.Perziureti();
                }
                if(b==2){
                    li.kurtiNauja();
                }
                if(b==3){
                    li.ieskotiEsamo();
                }
                if(b==4){
                    li.Naikinti();
                }
            } while(b!=5);
}}while(a!=6);
    }}
