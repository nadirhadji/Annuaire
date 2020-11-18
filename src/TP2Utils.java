import java.util.StringTokenizer;

public class TP2Utils {
   
   public final static String SEPARATEUR_INFO_CONTACT = "|";
   public final static String AUCUN = "aucun";
   
   /**
    * Cette methode cree un contact avec les informations donnees en parametres
    * et le formate sur une ligne comme ceci : id|nom|prenom|courriel|telephone.
    * 
    * Si le courriel ou le telephone est null ou vide, celui-ci est remplace par la 
    * constante AUCUN.
    * 
    * Ex. 1 :     3|lord|melanie|lord.melanie@uqam.ca|5143339999
    * Ex. 2 :     3|lord|melanie|lord.melanie@uqam.ca|aucun
    * Ex. 3 :     3|lord|melanie|aucun|5143339999
    * Ex. 4 :     3|lord|melanie|aucun|aucun
    * 
    * @param idContact le numero d'identification du contact a formater.
    * @param nom le nom du contact a formater. 
    *            ANTECEDENT : on suppose que le nom est valide (entre 1 et 30 car).
    * @param prenom le prenom du contact a formater. 
    *               ANTECEDENT : on suppose que le prenom est valide (entre 1 et 30 car).
    * @param courriel le courriel du contact a formater. 
    *                 ANTECEDENT : on suppose que le courriel est valide 
    *                              (voir la documentation de la methode validerCourriel(...) 
    *                              de la classe TP2 pour savoir ce qu'est un courriel
    *                              valide).
    * @param tel le telephone du contact a formater. 
    *            ANTECEDENT : on suppose que le telephone est valide 
    *                         (voir la documentation de la methode validerTelephone(...) 
    *                         de la classe TP2 pour savoir ce qu'est un telephone
    *                         valide). 
    * @return le contact formate.
    */
   public static String formaterContactSurUneLigne(int idContact, String nom, String prenom,
           String courriel, String tel) {
      
      String contactLigne;
      
      if (courriel == null || courriel.isEmpty()) {
         courriel = AUCUN;
      }
      if (tel == null || tel.isEmpty()) {
         tel = AUCUN;
      }
      contactLigne = idContact + SEPARATEUR_INFO_CONTACT + nom 
              + SEPARATEUR_INFO_CONTACT + prenom + SEPARATEUR_INFO_CONTACT 
              + courriel + SEPARATEUR_INFO_CONTACT + tel;
   
      return contactLigne;
   }
   
   /**
    * Cette methode teste si le car donne est une lettre ('a' a 'z', 'A' a 'Z').
    * 
    * @param car le caractere a tester.
    * @return true si car est une lettre, false sinon.
    */
   public static boolean estUneLettre (char car) {
      return (car >= 'a' && car <= 'z') || (car >= 'A' && car <= 'Z');
   }

   /**
    * Cette methode teste si le car donne est un caractere numerique ('0' a '9').
    * 
    * @param car le caractere a tester.
    * @return true si car est un caractere numerique, false sinon.
    */
   public static boolean estUnCarNum (char car) {
      return (car >= '0' && car <= '9');
   }
   
   /**
    * Cette methode teste si tous les caracteres de la chaine donnee sont
    * des caracteres numeriques ('0' a '9'). Une chaine null ou vide est
    * consideree comme ne contenant pas que des caracteres numeriques (false).
    * 
    * @param chaine la chaine a tester.
    * @return true si tous les caracteres de la chaine donnee sont numeriques,
    *         false sinon.
    * 
    * EXEMPLES : 
    *       ""       -> retourne false
    *       null     -> retourne false
    *       "a6788"  -> retourne false
    *       "456&66" -> retourne false
    *       "12345"  -> retourne true
    * 
    * NOTE TP2 : 
    *    - Cette methode doit utiliser la methode estUnCarNum(...) de cette 
    *      classe.
    */
   public static boolean neContientQueDesChiffres (String chaine) {

      boolean reponse = true;

      if (chaine.equals("") || chaine.isEmpty() )
         reponse = false;
      else {
         for (Character c : chaine.toCharArray()) {
            if(!estUnCarNum(c))
               reponse = false;
         }
      }
      return reponse;
   }
   
   /**
    * Cette methode compte le nombre de car dans chaine. Si la chaine donnee
    * est null ou vide, la methode retourne 0, peu importe le car donne.
    * 
    * @param chaine la chaine dans laquelle compter le nombre d'occurrences du 
    *               car donne.
    * @param car le caractere a compter dans la chaine donnee.
    * @return le nombre de caracteres car dans chaine. 
    */
   public static int contientNCar (String chaine, char car) {

      int reponse  = 0;
      boolean chaineVide = chaine.equals("") || chaine.isEmpty();

      if(!chaineVide) {
         for (Character carac : chaine.toCharArray()){
            if (carac.equals(car))
               reponse++;
         }
      }
      return reponse;
   }
   
   /**
    * Cette methode teste si la chaine donnee ne contient que des lettres 
    * (majuscules ou minuscules), des caracteres numeriques ('0' a '9') ou 
    * l'un ou l'autre des caracteres presents dans la chaine plus donnee.
    * 
    * Si plus est null ou vide, la methode ignore ce parametre et ne teste que si 
    * la chaine donnee ne contient que des lettres ou des caracteres numeriques.
    * 
    * Si chaine est null ou vide, la methode retourne false.
    * 
    * EXEMPLES : 
    *    estAlphaNumPlus ("", "%*")          -> retourne false
    *    estAlphaNumPlus (null, "%*")        -> retourne false
    *    estAlphaNumPlus ("a7*t889%", "%*")  -> retourne true
    *    estAlphaNumPlus ("@!&", "%*")       -> retourne false
    *    estAlphaNumPlus ("**%**", "%*")     -> retourne true
    *    estAlphaNumPlus ("1B234fgH", null)  -> retourne true
    *    estAlphaNumPlus ("1B234fgH", "")    -> retourne true
    * 
    * @param chaine la chaine a tester.
    * @param plus une chaine de caracteres que peut contenir chaine, en plus
    *        des lettres et des caracteres numeriques.
    * @return true si la chaine donnee ne contient que des lettres, des 
    *         caracteres numeriques ('0' a '9') ou  l'un ou l'autre des 
    *         caracteres presents dans la chaine plus donnee.
    * 
    * NOTES POUR LE TP2: 
    *    - Cette methode DOIT utiliser la methodes suivantes (de cette classe): 
    *          - estUneLettre(...)
    *          - estUnCarNum(...)
    */
   public static boolean estAlphaNumPlus (String chaine, String plus) {

      char car = 'a';
      boolean reponse = true;
      boolean boolPlus = false;
      boolean boolChiffre = false;
      boolean boolLettre = false;

      if(chaine == null || chaine.isEmpty()) {
         reponse = false;
      } else {
         /*
            * Boucle qui parcours chaque caractère de la chaine jusqu'au
            * caractère qui ne satisfait plus les conditions de la methode
          */
         for(int  i = 0 ; i < chaine.length() && reponse ; i++) {

            //Recupérer le caractère courant
            car = chaine.charAt(i);

            //Teste si le caractère courant est un chiffre
            boolChiffre = estUnCarNum(car);

            //Teste si le caractère courant est une lettre
            boolLettre = estUneLettre(car);

            //Teste si le caractère courant est parmi 'plus'
            if(!(plus == null || plus.isEmpty())) {
               if(boolChiffre == boolLettre)
                  boolPlus = estUnCaracParmi(car,plus);
            }
            /*
             *Teste si le caractère n'appartient ni au chiffre,
             * ni au lettre, ni au caractère dans la chaine plus.
             */
            if (!(boolLettre || boolChiffre || boolPlus))
               reponse = false;
         }
      }
      return reponse;
   }

   /**
    * Cette methode recoit un caractere(car) et une chaine de caractère(plus) et
    * doit évaluer si (car) est contenu dans (plus)
    *
    * @param car le caractere à evaluer.
    * @param plus une chaine de caracteres que peut contenir car, en plus
    *     *        des lettres et des caracteres numeriques.
    * @return true si le caractère(car) donnee est inclue dans la chaine plus.
    *
    * On suppose ici que 'plus' et 'car' ne sont ni vide ni nul.
    */
   private static boolean estUnCaracParmi(char car , String plus) {

      byte compteurPlus = 0;
      boolean reponse = false;
      byte taillePlus = (byte) plus.length();

      while (compteurPlus < taillePlus) {
         Character carPlus = plus.charAt(compteurPlus);
         if(carPlus.equals(car))
            reponse = true;
         compteurPlus++;
      }

      return reponse;
   }

      /**
    * Cette methode recoit en parametre un contact-ligne et retourne 
    * l'id de ce contact sous forme de chaine de caracteres.
    * 
    * @param contactLigne le contact dont on veut obtenir l'id.
    *        ANTECEDENT :  On suppose contacLigne non null, non vide et 
    *                      bien forme. Voir la documentation de la methode 
    *                      formaterContactSurUneLigne de cette classe pour 
    *                      savoir ce qu'est un contact-ligne bien forme.
    * @return le no d'idendification du contactLigne donne en parametre.
    */
   public static String obtenirIdContact (String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode recoit en parametre un contact-ligne et retourne 
    * le nom de ce contact.
    * 
    * @param contactLigne le contact dont on veut obtenir le nom.
    *        ANTECEDENT :  On suppose contactLigne non null, non vide et 
    *                      bien forme. Voir la documentation de la methode 
    *                      formaterContactSurUneLigne de cette classe pour 
    *                      savoir ce qu'est un contact-ligne bien forme.
    * @return le nom du contactLigne donne en parametre.
    */
   public static String obtenirNomContact (String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode recoit en parametre un contact-ligne et retourne 
    * le prenom de ce contact.
    * 
    * @param contactLigne le contact dont on veut obtenir le prenom.
    *        ANTECEDENT :  On suppose contactLigne non null, non vide et 
    *                      bien forme. Voir la documentation de la methode 
    *                      formaterContactSurUneLigne de cette classe pour 
    *                      savoir ce qu'est un contact-ligne bien forme.
    * @return le prenom du contactLigne donne en parametre.
    */
   public static String obtenirPrenomContact (String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode recoit en parametre un contact-ligne et retourne 
    * le courriel de ce contact. Si ce contact n'a aucun courriel, la chaine
    * retournee est "aucun".
    * 
    * @param contactLigne le contact dont on veut obtenir le courriel.
    *        ANTECEDENT :  On suppose contacLigne non null, non vide et 
    *                      bien forme. Voir la documentation de la methode 
    *                      formaterContactSurUneLigne de cette classe pour 
    *                      savoir ce qu'est un contact-ligne bien forme.
    * @return le courriel du contactLigne donne en parametre.
    */
   public static String obtenirCourrielContact (String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode recoit en parametre un contact-ligne et retourne 
    * le telephone (chaine de 10 car numeriques) de ce contact. 
    * Si ce contact n'a aucun telephone, la chaine retournee est "aucun".
    * 
    * @param contactLigne le contact dont on veut obtenir le telephone.
    *        ANTECEDENT :  On suppose contacLigne non null, non vide et 
    *                      bien forme. Voir la documentation de la methode 
    *                      formaterContactSurUneLigne de cette classe pour 
    *                      savoir ce qu'est un contact-ligne bien forme.
    * @return le telephone (non formate) du contactLigne donne en parametre.
    */
   public static String obtenirTelephoneContact (String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode formate le tel donne de cette maniere : (450) 123-4567.
    * 
    * @param tel le telephone a formater.
    *        ANTECEDENT : on suppose tel valide : chaine de 10 car numeriques 
    *                     (non vide et non null).
    * @return le numero de telephone formate.
    */
   public static String formaterTelephone(String tel) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   } 
   
   /**
    * Cette methode formate le contact-ligne donne sur plusieurs lignes.
    * 
    * Format (avec le NOM tout en majuscules, et le Prenom en minuscules sauf
    *         la première lettre en majuscule):
    *                                  NOM, Prenom (id)
    *                                  courriel - s'il y a lieu
    *                                  telephone formate - s'il y a lieu
    * 
    * Exemples : 
    *    - Supposons le contact-ligne suivant : 6|Abri|ben|benben@hotmail.com|4502334565, 
    *      le contact formate sera :
    *                                  ABRI, Ben (6)
    *                                  benben@hotmail.com
    *                                  (450) 233-4565
    * 
    *    - Supposons le contact-ligne suivant : 6|Abri|ben|benben@hotmail.com|aucun, 
    *      le contact formate sera :
    *                                  ABRI, Ben (6)
    *                                  benben@hotmail.com
    * 
    *    - Supposons le contact-ligne suivant : 6|Abri|ben|aucun|4502334565, 
    *      le contact formate sera :
    *                                  ABRI, Ben (6)
    *                                  (450) 233-4565
    * 
    *    - Supposons le contact-ligne suivant : 6|Abri|ben|aucun|aucun, 
    *      le contact formate sera :
    *                                  ABRI, Ben (6)
    * 
    * @param contactLigne le contact-ligne a formater.
    *                     ANTECEDENT : on le suppose non null, non vide et 
    *                                  bien forme. Voir la documentation de la
    *                                  methode formaterContactSurUneLigne de
    *                                  cette classe pour savoir ce qu'est un 
    *                                  contact-ligne bien forme.
    * @return le contact formate.
    * 
    * NOTES TP2:
    *    - Vous DEVEZ respecter le format explique ci-dessus a la lettre.
    *    - Cette methode DOIT utiliser les methodes suivantes de cette classe :
    *          - obtenirIdContact (...)
    *          - obtenirNomContact (...)
    *          - obtenirPrenomContact (...)
    *          - obtenirCourrielContact (...)
    *          - obtenirTelephoneContact (...)
    */
   public static String formaterContact(String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode insere le contactLigne donne dans le carnet donne. Le contact
    * doit etre insere en respectant l'ordre alphabetique des noms de famille
    * (SANS TENIR COMPTE DE LA CASSE).
    * 
    * Cette methode ne verifie pas les doublons, donc il est possible 
    * d'inserer le même contact plusieurs fois.
    * 
    * 
    * @param carnet le carnet de contacts dans lequel on veut inserer le 
    *               contactLigne donne.
    *               ANTECEDENTS : - On suppose carnet NON NULL (mais peut être
    *                               vide).
    *                             - Si non vide, on suppose le carnet bien 
    *                               forme. Voir la documentation de la methode
    *                               ajouterContact de la classe TP2 pour la 
    *                               description de ce qu'est un carnet bien 
    *                               forme.
    * @param contactLigne le contact (formate sur une ligne) a ajouter dans
    *                     le carnet donne.
    *                     ANTECEDENTS : On suppose que le contactLigne est non
    *                                   null, non vide et bien forme.  
    * 
    * @return une nouvelle chaine de caracteres representant le carnet donne 
    *         APRES l'insertion. Le carnet retourne doit etre bien forme.
    * 
    * NOTES TP2 : 
    *    - un contact-ligne bien forme respecte les specifications donnees dans 
    *      la definition de la methode formaterContactSurUneLigne de cette 
    *      classe.
    * 
    *    - Cette methode DOIT utiliser la methode obtenirNomContact(...) de cette
    *      classe.
    *      
    */
   public static String insererCeContactDansCarnet 
                                         (String carnet, String contactLigne) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)                                     
   }
      
   /**
    * Cette methode supprime du carnet donne le contact ayant comme id le 
    * idContact donne. Si le contact existe dans le carnet, la methode supprime 
    * le contact du carnet. Si le contact n'existe pas dans le carnet, 
    * la methode ne modifie pas le carnet.
    * 
    * @param idContact le no d'identification du contact a supprimer du carnet.
    * @param carnet le carnet dans lequel on veut supprimer le contact ayant
    *               le idContact donne.
    *               ANTECEDENTS : - On suppose carnet NON NULL (mais peut être 
    *                               vide).
    *                             - Si non vide, on suppose le carnet bien 
    *                               forme. Voir la documentation de la methode
    *                               ajouterContact de la classe TP2 pour la 
    *                               description de ce qu'est un carnet bien 
    *                               forme.
    * @return une nouvelle chaine de caracteres representant le carnet APRES 
    *         la suppression (ou le carnet inchange si la suppression n'a 
    *         pas eu lieu).
    * 
    * NOTES TP2 : 
    *    - Cette methode DOIT utiliser la methode obtenirIdContact(...) de cette
    *      classe. 
    * 
    */                                     
   public static String supprimerCeContactDuCarnet (String idContact, String carnet) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }                                      
 
}
