import org.junit.Assert;
import org.junit.Test;

public class TesteObtenirInfosContact {

    @Test
    public void obtenirIdContact0() {
        String chaine = "3|lord|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirIdContact(chaine);
        Assert.assertEquals("3",reponse);
    }

    @Test
    public void obtenirIdContact1() {
        String chaine = "444|lord|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirIdContact(chaine);
        Assert.assertEquals("444",reponse);
    }

    @Test
    public void obtenirNomContact0() {
        String chaine = "444|lord|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirNomContact(chaine);
        Assert.assertEquals("lord",reponse);
    }

    @Test
    public void obtenirNomContact1() {
        String chaine = "444|lalala|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirNomContact(chaine);
        Assert.assertEquals("lalala",reponse);
    }

    @Test
    public void obtenirPrenomContact0() {
        String chaine = "444|lalala|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirPrenomContact(chaine);
        Assert.assertEquals("melanie",reponse);
    }

    @Test
    public void obtenirCourrielContact0() {
        String chaine = "444|lalala|lololo|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.obtenirCourrielContact(chaine);
        Assert.assertEquals("lord.melanie@uqam.ca",reponse);
    }

    @Test
    public void obtenirCourrielContact1() {
        String chaine = "444|steve|jobs|aucun|8888888888";
        String reponse = TP2Utils.obtenirCourrielContact(chaine);
        Assert.assertEquals("aucun",reponse);
    }

    @Test
    public void obtenirTelephoneContact0() {
        String chaine = "444|steve|jobs|aucun|8888888888";
        String reponse = TP2Utils.obtenirTelephoneContact(chaine);
        Assert.assertEquals("8888888888",reponse);
    }

    @Test
    public void obtenirTelephoneContact1() {
        String chaine = "444|steve|jobs|aucun|aucun";
        String reponse = TP2Utils.obtenirTelephoneContact(chaine);
        Assert.assertEquals("aucun",reponse);
    }
}
