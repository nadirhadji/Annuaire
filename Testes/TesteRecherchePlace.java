import org.junit.Assert;
import org.junit.Test;

public class TesteRecherchePlace {

    String rawCarnet = "0|B|Myriam|AUCUN|AUCUN\n"+
                    "1|C|Myriam|AUCUN|AUCUN\n"+
                    "2|E|Myriam|AUCUN|AUCUN\n"+
                    "3|G|Myriam|AUCUN|AUCUN\n"+
                    "4|I|Myriam|AUCUN|AUCUN\n"+
                    "5|K|Myriam|AUCUN|AUCUN\n"+
                    "6|M|Myriam|AUCUN|AUCUN\n"+
                    "7|O|Myriam|AUCUN|AUCUN\n"+
                    "8|Q|Myriam|AUCUN|AUCUN\n"+
                    "9|S|Myriam|AUCUN|AUCUN\n"+
                    "10|U|Myriam|AUCUN|AUCUN\n"+
                    "11|W|Myriam|AUCUN|AUCUN\n"+
                    "12|Y|Myriam|AUCUN|AUCUN\n";

    String[] carnet = rawCarnet.split("\n");

    @Test
    public void obtenirNumLigneOuInsererContactA() {
        int reponse = TP2Utils.recherchePlace('A',carnet);
        Assert.assertEquals(0,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactD() {
        int reponse = TP2Utils.recherchePlace('D',carnet);
        Assert.assertEquals(2,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactF() {
        int reponse = TP2Utils.recherchePlace('F',carnet);
        Assert.assertEquals(3,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactH() {
        int reponse = TP2Utils.recherchePlace('H',carnet);
        Assert.assertEquals(4,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactJ() {
        int reponse = TP2Utils.recherchePlace('J',carnet);
        Assert.assertEquals(5,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactL() {
        int reponse = TP2Utils.recherchePlace('L',carnet);
        Assert.assertEquals(6,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactZ() {
        int reponse = TP2Utils.recherchePlace('Z',carnet);
        Assert.assertEquals(13,reponse);
    }



}
