import org.junit.Assert;
import org.junit.Test;

public class TesteInsererContact {

    String rawCarnet =  "0|Arevier|Simon|simon@gmail.com|5145678988\n"+
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

    String expected1 =  "0|Arevier|Simon|simon@gmail.com|5145678988\n"+
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
                        "18|Mirard|Myriam|AUCUN|AUCUN\n"+
                        "19|Oirard|Myriam|AUCUN|AUCUN\n"+
                        "20|Oirard|Myriam|AUCUN|AUCUN\n"+
                        "21|Oirard|Myriam|AUCUN|AUCUN\n"+
                        "22|Pirard|Myriam|AUCUN|AUCUN\n"+
                        "23|Pirard|Myriam|AUCUN|AUCUN\n";

    String expected2 =  "0|Arevier|Simon|simon@gmail.com|5145678988\n" +
                        "1|Aumoulin|Fred|fredd@yahoo.ca|8196778234\n" +
                        "18|Airard|Myriam|AUCUN|AUCUN\n" +
                        "2|Aouglas|Sylvie|AUCUN|4507461234\n" +
                        "3|Birard|Myriam|AUCUN|AUCUN\n" +
                        "4|Birard|Myriam|AUCUN|AUCUN\n" +
                        "5|Birard|Myriam|AUCUN|AUCUN\n" +
                        "6|Cirard|Myriam|AUCUN|AUCUN\n" +
                        "7|Cirard|Myriam|AUCUN|AUCUN\n" +
                        "8|Cirard|Myriam|AUCUN|AUCUN\n" +
                        "9|Eirard|Myriam|AUCUN|AUCUN\n" +
                        "10|Hirard|Myriam|AUCUN|AUCUN\n" +
                        "11|Hirard|Myriam|AUCUN|AUCUN\n" +
                        "12|Iirard|Myriam|AUCUN|AUCUN\n" +
                        "13|Jirard|Myriam|AUCUN|AUCUN\n" +
                        "14|Jirard|Myriam|AUCUN|AUCUN\n" +
                        "15|Kirard|Myriam|AUCUN|AUCUN\n" +
                        "16|Lirard|Myriam|AUCUN|AUCUN\n" +
                        "17|Lirard|Myriam|AUCUN|AUCUN\n" +
                        "18|Lirard|Myriam|AUCUN|AUCUN\n" +
                        "18|Mirard|Myriam|AUCUN|AUCUN\n" +
                        "19|Oirard|Myriam|AUCUN|AUCUN\n" +
                        "18|Oirard|Myriam|AUCUN|AUCUN\n" +
                        "20|Oirard|Myriam|AUCUN|AUCUN\n" +
                        "21|Oirard|Myriam|AUCUN|AUCUN\n" +
                        "22|Pirard|Myriam|AUCUN|AUCUN\n" +
                        "23|Pirard|Myriam|AUCUN|AUCUN\n" +
                        "18|Qirard|Myriam|AUCUN|AUCUN\n" +
                        "18|Zirard|Myriam|AUCUN|AUCUN\n";

    String contactLigne = "18|Mirard|Myriam|AUCUN|AUCUN\n";

    String carnetDeuxContact = "18|Mirard|Myriam|AUCUN|AUCUN\n"+
                                "18|Mirard|Myriam|AUCUN|AUCUN\n";

    @Test
    public void inserer() {
        String res = TP2Utils.insererCeContactDansCarnet(rawCarnet,
                                            "18|Mirard|Myriam|AUCUN|AUCUN\n");
        Assert.assertEquals(expected1,res);
    }

    @Test
    public void inserer2() {
        String res = TP2Utils.insererCeContactDansCarnet(rawCarnet,
                "18|Mirard|Myriam|AUCUN|AUCUN\n");

        String res2 = TP2Utils.insererCeContactDansCarnet(res,
                "18|Airard|Myriam|AUCUN|AUCUN\n");

        String res3 = TP2Utils.insererCeContactDansCarnet(res2,
                "18|Qirard|Myriam|AUCUN|AUCUN\n");

        String res4 = TP2Utils.insererCeContactDansCarnet(res3,
                "18|Zirard|Myriam|AUCUN|AUCUN\n");

        String res5 = TP2Utils.insererCeContactDansCarnet(res4,
                "18|Oirard|Myriam|AUCUN|AUCUN\n");

        Assert.assertEquals(expected2,res5);
    }

    @Test
    public void inserer3() {
        String res = TP2Utils.insererCeContactDansCarnet("",contactLigne);
        Assert.assertEquals(contactLigne,res);
    }

    @Test
    public void inserer4() {
        String res = TP2Utils.insererCeContactDansCarnet(contactLigne,contactLigne);
        Assert.assertEquals(carnetDeuxContact,res);
    }
}
