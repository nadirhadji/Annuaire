import org.junit.Assert;
import org.junit.Test;

public class TesteUtils {

    @Test
    public void premierTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void neContientQueDesChiffresTrue() {
        String chaine = "12345";
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertTrue(reponse);
    }

    @Test
    public void neContientQueDesChiffresFalse() {
        String chaine = "a2345";
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertFalse(reponse);
    }

    @Test
    public void neContientQueDesChiffresFalse2() {
        String chaine = "*****2345";
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertFalse(reponse);
    }

    @Test
    public void neContientQueDesChiffresFalse3() {
        String chaine = "abcdefg";
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertFalse(reponse);
    }

    @Test
    public void neContientQueDesChiffresFalse4() {
        String chaine = "";
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertFalse(reponse);
    }

    @Test
    public void neContientQueDesChiffresFalse5() {
        String chaine = null;
        boolean reponse = TP2Utils.neContientQueDesChiffres(chaine);
        Assert.assertFalse(reponse);
    }

    @Test
    public void contientNCar0() {
        String chaine = "abcdefg";
        char car = 'h';
        int reponse = TP2Utils.contientNCar(chaine,car);
        Assert.assertEquals(0,reponse);

    }

    @Test
    public void contientNCar1() {
        String chaine = "abcdefg";
        char car = 'g';
        int reponse = TP2Utils.contientNCar(chaine,car);
        Assert.assertEquals(1,reponse);
    }

    @Test
    public void contientNCar2() {
        String chaine = "abcdefgg";
        char car = 'g';
        int reponse = TP2Utils.contientNCar(chaine,car);
        Assert.assertEquals(2,reponse);

    }

    @Test
    public void contientNCar3() {
        String chaine = "abcdefg3gg";
        char car = 'g';
        int reponse = TP2Utils.contientNCar(chaine,car);
        Assert.assertEquals(3,reponse);
    }

    @Test
    public void contientNCarVide() {
        String chaine = "";
        char car = 'g';
        int reponse = TP2Utils.contientNCar(chaine,car);
        Assert.assertEquals(0,reponse);
    }

    @Test
    public void formaterTelephone0() {
        String chaine = "8888888888";
        String reponse = TP2Utils.formaterTelephone(chaine);
        Assert.assertEquals("(888) 888-8888",reponse);
    }

    @Test
    public void formaterTelephone1() {
        String chaine = "5146543456";
        String reponse = TP2Utils.formaterTelephone(chaine);
        Assert.assertEquals("(514) 654-3456",reponse);
    }

    //teste insererCeContactDansCarnet
    String carnet = "3|Crevier|Simon|simon@gmail.com|5145678988\n" +
            "1|Douglas|Sylvie|AUCUN|4507461234\n" +
            "2|Dumoulin|Fred|fredd@yahoo.ca|8196778234\n" +
            "4|Girard|Myriam|AUCUN|AUCUN\n";

    String ligne =  "6|Girard|Myriam|AUCUN|AUCUN\n";
}
