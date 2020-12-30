

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Darbuotojas implements ISutartis {


  @SerializedName("slaptazodis")
  @Expose
  private String slaptazodis;
  @SerializedName("vardas")
  @Expose
  private String vardas;
  @SerializedName("pavarde")
  @Expose
  private String pavarde;
  @SerializedName("telnr")
  @Expose
  private String telnr;
  @SerializedName("adresas")
  @Expose
  private String adresas;
  @SerializedName("darbuotojoID")
  @Expose
  private Integer darbuotojoID;

  transient List<Darbuotojas> darbuotojai = new ArrayList<Darbuotojas>();

  transient Scanner skaityti = new Scanner(System.in);



  public Darbuotojas(String slaptazodis, String vardas, String pavarde, String telnr, String adresas, int darbuotojoID) {
    this.slaptazodis = slaptazodis;
    this.vardas = vardas;
    this.pavarde = pavarde;
    this.telnr = telnr;
    this.adresas = adresas;
    this.darbuotojoID = darbuotojoID;
  }

  public Darbuotojas() {
  }

  public Integer gautiDarbuotojoID() {
    return this.darbuotojoID;
  }

  public String gautiVarda() {
    return this.vardas;
  }

  public String gautiPavarde() {
    return this.pavarde;
  }

  public String getSlaptazodis() {
    return slaptazodis;
  }

  public String getVardas() {
    return vardas;
  }

  public String getPavarde() {
    return pavarde;
  }

  public String getTelnr() {
    return telnr;
  }

  public String getAdresas() {
    return adresas;
  }

  public int getDarbuotojoID() {
    return darbuotojoID;
  }

  public void setSlaptazodis(String slaptazodis) {
    this.slaptazodis = slaptazodis;
  }

  public void setVardas(String vardas) {
    this.vardas = vardas;
  }

  public void setPavarde(String pavarde) {
    this.pavarde = pavarde;
  }

  public void setTelnr(String telnr) {
    this.telnr = telnr;
  }

  public void setAdresas(String adresas) {
    this.adresas = adresas;
  }

  public void setDarbuotojoID(int darbuotojoID) {
    this.darbuotojoID = darbuotojoID;
  }

  @Override
  public void kurtiNauja() {
    String slaptazodis;
    String vardas;
    String pavarde;
    String telnr;
    String adresas;
    int darbuotojoID = 0;
    darbuotojoID = darbuotojai.size() + 1;
    System.out.println("Naujas darbuotojas: " + darbuotojoID);
    System.out.println("Vardas: ");
    vardas = skaityti.nextLine();
    System.out.println("Pavardė: ");
    pavarde = skaityti.nextLine();
    System.out.println("Telefono numeris: ");
    telnr = skaityti.nextLine();
    System.out.println("Gyvenamosios vietos adresas: ");
    adresas = skaityti.nextLine();
    System.out.println("Slaptažodis: ");
    slaptazodis = skaityti.nextLine();
    System.out.println("Naujas darbuotojas sėkmingai sukurtas!");




    String text ="[{\"slaptazodis\":\"231231\",\"vardas\":\"Marius\",\"pavarde\":\"Gzegozevskis\",\"telnr\":\"232131\",\"adresas\":\"labas\",\"darbuotojoID\":1,\"darbuotojai\":[]}]";



    //Type darbuotojasType = new TypeToken<ArrayList<Darbuotojas>>(){}.getType();
    //List<Darbuotojas> darbuotojasList = new Gson().fromJson(text, darbuotojasType);


    FileWriter myWriter = null;
    File file = new File("src/main/resources/darbuotojai.json");
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
      byte[] data = new byte[(int) file.length()];
      fis.read(data);
      String str = new String(data, "UTF-8");

      Type darbuotojasType = new TypeToken<ArrayList<Darbuotojas>>(){}.getType();
      List<Darbuotojas> darbuotojasList = new Gson().fromJson(str, darbuotojasType);

      darbuotojai = darbuotojasList;
      darbuotojai.add(new Darbuotojas(slaptazodis, vardas, pavarde, telnr, adresas, darbuotojoID));
      String json = new Gson().toJson(darbuotojai);
      myWriter = new FileWriter(file, false);
      myWriter.write(json);
      myWriter.close();
      fis.close();

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
  @Override
  public void ieskotiEsamo() {
    System.out.println("Įveskite paieškos raktažodį:");
    int ivestis = skaityti.nextInt();
    try {
      FileInputStream fa = new FileInputStream(new File("darbuotojai.txt"));
      ObjectInputStream oa = new ObjectInputStream(fa);
      for (Darbuotojas darb : darbuotojai) {
        if (ivestis == darb.darbuotojoID) {
          Darbuotojas d = (Darbuotojas) oa.readObject();
          System.out.println(d.toString());
        }
      }
      oa.close();
      fa.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("Error initializing stream");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void Naikinti() {
    System.out.println("Iveskite darbuotojo, kurį norite panaikinti, ID: ");
    int ivestis = skaityti.nextInt();
    for (Darbuotojas darb : darbuotojai) {
      if (ivestis == darb.darbuotojoID) {
        darbuotojai.remove(darb);
        System.out.println("Darbuotojas " + darbuotojoID + " sėkmingai ištrintas!\n");
      }
    }
  }

  @Override
  public void Perziureti() {


    String text = "[{\"slaptazodis\":\"231231\",\"vardas\":\"Marius\",\"pavarde\":\"Gzegozevskis\",\"telnr\":\"232131\",\"adresas\":\"labas\",\"darbuotojoID\":1,\"darbuotojai\":[]}]";
    Type darbuotojasType = new TypeToken<ArrayList<Darbuotojas>>() {
    }.getType();
    List<Darbuotojas> darbuotojasList = new Gson().fromJson(text, darbuotojasType);
    FileWriter myWriter = null;
    File file = new File("src/main/resources/darbuotojai.json");
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
      byte[] data = new byte[(int) file.length()];
      fis.read(data);
      String str = new String(data, "UTF-8");
      Type type = new TypeToken<ArrayList<Darbuotojas>>() {}.getType();
      List<Darbuotojas> listFromFile = new Gson().fromJson(str, type);

      for (Darbuotojas darbuotojas : listFromFile) {
        System.out.println(darbuotojas.darbuotojoID + " " + darbuotojas.vardas + " " + darbuotojas.telnr);
      }

      fis.close();
    } catch (UnsupportedEncodingException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Override
  public String toString() {
    return "Darbuotojas{" +
        "slaptazodis='" + slaptazodis + '\'' +
        ", vardas='" + vardas + '\'' +
        ", pavarde='" + pavarde + '\'' +
        ", telnr='" + telnr + '\'' +
        ", adresas='" + adresas + '\'' +
        ", darbuotojoID=" + darbuotojoID +
        '}';
  }

  public List<Darbuotojas> getDarbuotojas() {
    return darbuotojai;
  }
}
