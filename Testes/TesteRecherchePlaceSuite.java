import org.junit.Assert;
import org.junit.Test;

public class TesteRecherchePlaceSuite {

    String rawCarnet = "0|Arevier|Simon|simon@gmail.com|5145678988\n"+
                    "1|Aumoulin|Fred|fredd@yahoo.ca|8196778234\n"+
                    "2|Aouglas|Sylvie|AUCUN|4507461234\n"+
                    "3|Birard|Myriam|AUCUN|AUCUN\n"+
                    "4|Birard|Myriam|AUCUN|AUCUN\n"+
                    "5|Birard|Myriam|AUCUN|AUCUN\n"+
                    "6|Cirard|Myriam|AUCUN|AUCUN\n"+
                    "7|Cirard|Myriam|AUCUN|AUCUN\n"+
                    "8|Cirard|Myriam|AUCUN|AUCUN\n"+
                    "9|Eirard|Myriam|AUCUN|AUCUN\n"+
                    "10|Hirard|Myriam|AUCUN|AUCUN\n"+
                    "11|Hirard|Myriam|AUCUN|AUCUN\n"+
                    "12|Iirard|Myriam|AUCUN|AUCUN\n"+
                    "13|Jirard|Myriam|AUCUN|AUCUN\n"+
                    "14|Jirard|Myriam|AUCUN|AUCUN\n"+
                    "15|Kirard|Myriam|AUCUN|AUCUN\n"+
                    "16|Lirard|Myriam|AUCUN|AUCUN\n"+
                    "17|Lirard|Myriam|AUCUN|AUCUN\n"+
                    "18|Lirard|Myriam|AUCUN|AUCUN\n"+
                    "19|Oirard|Myriam|AUCUN|AUCUN\n"+
                    "20|Oirard|Myriam|AUCUN|AUCUN\n"+
                    "21|Oirard|Myriam|AUCUN|AUCUN\n"+
                    "22|Pirard|Myriam|AUCUN|AUCUN\n"+
                    "23|Pirard|Myriam|AUCUN|AUCUN\n";

    String[] carnet = rawCarnet.split("\n");


    @Test
    public void obtenirNumLigneOuInsererContactA() {
        int reponse = TP2Utils.recherchePositionParNom('A',carnet);
        Assert.assertEquals(2,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactB() {
        int reponse = TP2Utils.recherchePositionParNom('B',carnet);
        Assert.assertEquals(5,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactC() {
        int reponse = TP2Utils.recherchePositionParNom('C',carnet);
        Assert.assertEquals(8,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactD() {
        int reponse = TP2Utils.recherchePositionParNom('D',carnet);
        Assert.assertEquals(9,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactE() {
        int reponse = TP2Utils.recherchePositionParNom('E',carnet);
        Assert.assertEquals(9,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactF() {
        int reponse = TP2Utils.recherchePositionParNom('F',carnet);
        Assert.assertEquals(10,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactG() {
        int reponse = TP2Utils.recherchePositionParNom('G',carnet);
        Assert.assertEquals(10,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactI() {
        int reponse = TP2Utils.recherchePositionParNom('I',carnet);
        Assert.assertEquals(12,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactJ() {
        int reponse = TP2Utils.recherchePositionParNom('J',carnet);
        Assert.assertEquals(14,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactK() {
        int reponse = TP2Utils.recherchePositionParNom('K',carnet);
        Assert.assertEquals(15,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactL() {
        int reponse = TP2Utils.recherchePositionParNom('L',carnet);
        Assert.assertEquals(17,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactN() {
        int reponse = TP2Utils.recherchePositionParNom('N',carnet);
        Assert.assertEquals(19,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactQ() {
        int reponse = TP2Utils.recherchePositionParNom('Q',carnet);
        Assert.assertEquals(24,reponse);
    }

    @Test
    public void obtenirNumLigneOuInsererContactZ() {
        int reponse = TP2Utils.recherchePositionParNom('Z',carnet);
        Assert.assertEquals(24,reponse);
    }
}


