import org.junit.Assert;
import org.junit.Test;

public class TesteFormaterContact {

    @Test
    public void formaterContact0() {
        String expected = "LORD, Melanie (3)\nlord.melanie@uqam.ca\n(514) 333-9999\n";
        System.out.println(expected);
        String chaine = "3|lord|melanie|lord.melanie@uqam.ca|5143339999";
        String reponse = TP2Utils.formaterContact(chaine);
        Assert.assertEquals(expected,reponse);
    }

    @Test
    public void formaterContact1() {
        String expected = "LORD, Melanie (3)\n";
        System.out.println(expected);
        String chaine = "3|lord|melanie|aucun|aucun";
        String reponse = TP2Utils.formaterContact(chaine);
        Assert.assertEquals(expected,reponse);
    }

    @Test
    public void formaterContact2() {
        String expected = "LORD, Melanie (3)\nlord.melanie@uqam.ca\n";
        System.out.println(expected);
        String chaine = "3|lord|melanie|lord.melanie@uqam.ca|aucun";
        String reponse = TP2Utils.formaterContact(chaine);
        Assert.assertEquals(expected,reponse);
    }

    @Test
    public void formaterContact3() {
        String expected = "LORD, Melanie (3)\n(514) 333-9999\n";
        System.out.println(expected);
        String chaine = "3|lord|melanie|aucun|5143339999";
        String reponse = TP2Utils.formaterContact(chaine);
        Assert.assertEquals(expected,reponse);
    }
}
