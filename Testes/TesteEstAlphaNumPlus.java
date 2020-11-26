import org.junit.Assert;
import org.junit.Test;

public class TesteEstAlphaNumPlus {

    @Test
    public void estAlphaNumPlus() {
        String chaine = "";
        String plus = "%*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(false,reponse);
    }


    @Test
    public void estAlphaNumPlus1() {
        String chaine = null;
        String plus = "%*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(false,reponse);
    }

    @Test
    public void estAlphaNumPlus2() {
        String chaine = "a7*t889%++++++";
        String plus = "%*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(false,reponse);
    }

    @Test
    public void estAlphaNumPlus3() {
        String chaine = "@!&";
        String plus = "%*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(false,reponse);
    }

    @Test
    public void estAlphaNumPlus4() {
        String chaine = "**%**";
        String plus = "%*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(true,reponse);
    }

    @Test
    public void estAlphaNumPlus5() {
        String chaine = "1B234fgH";
        String plus = null;
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(true,reponse);
    }

    @Test
    public void estAlphaNumPlus6() {
        String chaine = "1B234fgH";
        String plus = "";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(true,reponse);
    }

    @Test
    public void estAlphaNumPlus7() {
        String chaine = "°°°°°°°°°°°";
        String plus = "°+";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(true,reponse);
    }

    @Test
    public void estAlphaNumPlus8() {
        String chaine = "";
        String plus = "";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(false,reponse);
    }

    @Test
    public void estAlphaNumPlus9() {
        String chaine = "azertyuiopqsdfghjkl**mwxcvbn12345678";
        String plus = "*";
        boolean reponse = TP2Utils.estAlphaNumPlus(chaine,plus);
        Assert.assertEquals(true,reponse);
    }
}
