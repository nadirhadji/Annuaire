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
}
