import java.util.StringTokenizer;

/**********************************************************
 *  * U Q A M   -   I N F 1 1 2 0
 *  *
 *  * Hadji Nadir (fc191918@ens.uqam.ca)
 *  * HADN08069703
 **********************************************************/
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

      boolean chaineVide = chaine == null || chaine.isEmpty();
      boolean reponse = true;
      int tailleDeChaine;
      int compteur = 0;
      char caracCourant;

      if (chaineVide)
         reponse = false;
      else {
         tailleDeChaine = chaine.length();
         while (reponse && compteur < tailleDeChaine) {
            caracCourant = chaine.charAt(compteur);
            if (!estUnCarNum(caracCourant))
               reponse = false;
            compteur++;
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

      int reponse = 0;
      boolean chaineVide = chaine == null || chaine.isEmpty();

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

      boolean chaineVide = chaine == null || chaine.isEmpty();
      boolean reponse = true;
      boolean boolPlus = false;
      boolean boolChiffre;
      boolean boolLettre;
      char caractereCourant;

      if(chaineVide) {
         reponse = false;
      } else {
         /*
            * Boucle qui parcours chaque caractère de la chaine jusqu'au
            * caractère qui ne satisfait plus les conditions de la methode
          */
         for(int  i = 0 ; i < chaine.length() && reponse ; i++) {

            //Recupérer le caractère courant
            caractereCourant = chaine.charAt(i);

            //Teste si le caractère courant est un chiffre
            boolChiffre = estUnCarNum(caractereCourant);

            //Teste si le caractère courant est une lettre
            boolLettre = estUneLettre(caractereCourant);

            /*
             *Teste si le caractère courant est parmi 'plus'
             * boolChiffre et boolLettre sont égaux dans un
             * seul cas, lorsque tout deux faux soit un
             * caractère qui n'est ni une lettre, ni un chiffre
             */
            if(!(plus == null || plus.isEmpty())) {
               if(boolChiffre == boolLettre)
                  boolPlus = estUnCaracParmi(caractereCourant,plus);
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
    * Cette methode recoit un caractere et une chaine de caractère et
    * doit évaluer si le caractere est contenue dans la chaine
    *
    * @param caractere le caractere à evaluer.
    * @param chaine une chaine de caracteres que peut contenir 'caractere',
    *               en plus des lettres et des caracteres numeriques.
    * @return true si le caractère donnee est inclue dans la chaine plus,
    * sinon false.
    *
    * On suppose ici que 'caractere' et 'chaine' ne sont ni vide ni nul.
    */
   private static boolean estUnCaracParmi(char caractere , String chaine) {

      boolean reponse = false;
      int tailleDeLaChaine = chaine.length();
      int positionCaracCourant = 0;

      while (positionCaracCourant < tailleDeLaChaine) {
         Character caracCourant = chaine.charAt(positionCaracCourant);
         if(caracCourant.equals(caractere))
            reponse = true;
         positionCaracCourant++;
      }

      return reponse;
   }

   /***************************************************
    * METHODES D'OBTENTION D'INFORMATION SUR UN CONTACT
    ***************************************************/

   /** Cette methode recoit en parametre un contact-ligne et la position
    * de l'information a obtenir parmi la ligne.
    *
    * Exemple : obtenirInfoAvecPosition(2,"3|lord|melanie|aucun|aucun")
    * doit retourner melanie car troisième element de la chaine de caractère
    * en commancant par 0 séparé par des "|".
    *
    * @param position la position de l'information a récuperer dans contactLigne
    *                 (O etant le premier element).
    * @param contactLigne le contact dont on veut obtenir une information.
    *             ANTECEDENT :  On suppose contactLigne non null, non vide et
    *                           bien forme. Voir la documentation de la methode
    *                           formaterContactSurUneLigne de cette classe pour
    *                           savoir ce qu'est un contact-ligne bien forme.
    * @return l'information du contactLigne donne en parametre.
    */
   private static String obtenirInfoAvecPosition(int position , String contactLigne){
      String reponse = "";
      byte compteur = 0;
      StringTokenizer tokens = new StringTokenizer(contactLigne,"|");
      while(tokens.hasMoreElements() && compteur <= position ) {
         reponse = tokens.nextToken();
         compteur++;
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
      return obtenirInfoAvecPosition(0,contactLigne);
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
      return obtenirInfoAvecPosition(1,contactLigne);
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
      return obtenirInfoAvecPosition(2,contactLigne);
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
      return obtenirInfoAvecPosition(3,contactLigne);
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
      return obtenirInfoAvecPosition(4,contactLigne);
   }

   /*******************************
    * METHODES DE FORMATAGE
    *******************************/
   
   /**
    * Cette methode formate le tel donne de cette maniere : (450) 123-4567.
    * 
    * @param tel le telephone a formater.
    *        ANTECEDENT : on suppose tel valide : chaine de 10 car numeriques 
    *                     (non vide et non null).
    * @return le numero de telephone formate.
    */
   public static String formaterTelephone(String tel) {

      String reponse;

      reponse = "("+tel.substring(0,3)+") ";
      reponse = reponse + tel.substring(3,6);
      reponse = reponse +"-"+tel.substring(6,10);

      return reponse;
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

      StringBuilder builder = new StringBuilder();

      String nom = TP2Utils.obtenirNomContact(contactLigne).toUpperCase();
      builder.append(nom);
      builder.append(", ");

      String prenom = TP2Utils.obtenirPrenomContact(contactLigne);
      builder.append(prenom.substring(0,1).toUpperCase());
      builder.append(prenom.substring(1));
      builder.append(" ");

      String id = TP2Utils.obtenirIdContact(contactLigne);
      builder.append("(");
      builder.append(id);
      builder.append(")\n");

      String email = TP2Utils.obtenirCourrielContact(contactLigne);
      if(! email.equals("aucun")) {
         builder.append(email);
         builder.append("\n");
      }

      String tel = TP2Utils.obtenirTelephoneContact(contactLigne);
      if(! tel.equals("aucun")) {
         builder.append(formaterTelephone(tel));
         builder.append("\n");
      }

      return builder.toString();
   }

   /*******************************
    * METHODES D'INSERTION
    *******************************/

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

      if (carnet.isEmpty())
         carnet = contactLigne;
      else {
         char lettreDeNom = obtenirLettreDeNom(contactLigne);
         String[] tabCarnet = carnet.split("\n");
         int position = recherchePositionParNom(lettreDeNom,tabCarnet);
         carnet = nouvelleInsertion(carnet,contactLigne,tabCarnet.length,position);
      }

      return carnet;
   }

   /**
    * Cette méthode applique une recherche dichotomique sur une liste triée
    * par ordre alphabétique de noms de contacts. Elle à pour but de trouver
    * la position éxacte à laquelle devra etre inseré un nouveau contact
    * dans le carnet.
    *
    * @param lettre la premiere lettre du nom du nouveau contact
    * @param carnet Une liste de string contenant a chaque case
    *               une ligne de contact complete qu'on suppose
    *               bien formaté.
    *
    * @return La position exacte à laquelle le nouveau contact doit etre inséré
    * Si le retour est 0 : le contact devra etre inseré au tout début du carnet
    * Si le retour est egale au nombre d'element du carnet, le contact devra
    * étre inséré à la toute fin du carnet.
    * Sinon, le nouveau contact prend la place de l'ancien et l'ancien ce vera
    * décalé d'une position à droite (voire doc de nouveauCarnet).
    */
   public static int recherchePositionParNom(char lettre, String[] carnet) {

      int gauche = 0;
      int droite = carnet.length - 1;
      int milieu;
      char charCourant;

      while (gauche <= droite) {
         milieu = (gauche + droite) / 2;
         charCourant = obtenirLettreDeNom(carnet[milieu]);

         if(lettre < charCourant)
            droite = milieu - 1;
         else if (lettre > charCourant)
            gauche = milieu + 1;
         else
            return milieu;
      }
      return gauche;
   }

   /**
    * Cette méthode trouve l'index du dernier caractère de la ligne donnée
    * en argument.
    *
    * @param carnet le carnet de contact
    * @param position le numéro de la ligne dans le carnet qu'on va
    *                 supposer plus grand ou égale à 1.
    * @return l'index du dernier caractères à la ligne donnée en
    * argument.
    */
   private static int obtenirIndexDecoupeCarnet(String carnet, int position) {
      int index = -1;
      /*
       * Puisque la methode indexOf("\n",0) retourne l'index du premier
       * retour à la ligne, on décremente position de 1.
       * Exemple : si on veux retrouver l'index du dernier caractère à la
       * ligne #3 , on passe en argument 2 à la méthode indexOf("\n",2)
       * car celle-ci commence à compter depuis 0.
       */
      position = position-1;
      do {
         index = carnet.indexOf("\n",index+1);
      } while(position-- > 0 && index != -1);
      /*
       * Puisque "\n" contient deux caractères, et qu'on veux d'index
       * de fin de ligne, on incrémente le resultat de index de 1 pour
       * que cette méthode retourne bien l'index de fin de ligne.
       */
      return index+1;
   }

   /**
     * Cette methode ajoute un contact au carnet de contact. Pour faire cela, elle
     * peut procéder de 3 maniere dépendement de la position du nouveau contact.
     * Si position = 0 , alors on place le nouveau contact au tout debut du carnet.
     *                    Si position = nombre de contact, le nouveau contact devra
     *                    etre ajouté à la toute fin du carnet.
     *                    Sinon, on va découper le carnet du début jusqu'à l'index
     *                    de découpe (voire doc de la méthode
    *                     obtenirIndexDecoupeCarnet pour plus de détail).
     *                    On va ensuite concatener la nouvelle ligne de contact pour
     *                    enfin concatener la suite du carnet allant de l'index de
     *                    decoupe jusqu'à la fin du carnet.
     *
     * @param carnet le carnet initale à transformer
     * @param contactLigne le nouveau conctact à ajouter dans le carnet
     * @param position la position du nouveau contact dans le carnet
     * @return le nouveau carnet conteant le nouveau contact
    */
   private static String nouvelleInsertion(String carnet,String contactLigne,
                                       int nbContact,int position) {

      String nouveauCarnet;

      if(position == 0)
         nouveauCarnet = contactLigne + carnet;
      else if (position == nbContact)
         nouveauCarnet = carnet + contactLigne;
      else {
         int indexDeDecouper = obtenirIndexDecoupeCarnet(carnet,position);
         String gauche = carnet.substring(0,indexDeDecouper);
         String droite = carnet.substring(indexDeDecouper);
         nouveauCarnet = gauche + contactLigne + droite;
      }

      return nouveauCarnet;
   }

   /**
    * Cette méthode retourne la premiere lettre du nom en majuscule a
    * partir d'une ligne de contact
    *
    * @param contactLigne Une ligne de contact dans le carnet quelquonque
    *                     On suppose la chaine ecrite en fonction des normes
    *                     en vigeur dans le programme.
    * @return La première lette en majuscule dans le nom du contact
    */
   public static char obtenirLettreDeNom(String contactLigne){
      return obtenirNomContact(contactLigne)
              .substring(0,1)
              .toUpperCase()
              .charAt(0);
   }

   /*******************************
    * METHODES DE SUPPRESSION
    *******************************/

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

      String[] tabCarnet = carnet.split("\n");
      int id = Integer.parseInt(idContact);
      int position = obtenirPositionParId(id,tabCarnet);

      if(position != -1)
         carnet = nouvelleSuppression(carnet,position);

      return carnet;
   }

   /**
    * Cette methode supprime une ligne dans un carnet qu'on suppose déja bien
    * formaté. Pour faire cela, cette méthode trouve l'index du dernier
    * caractère qui se trouve avant la ligne à supprimer et l'index du premier
    * caractère qui suit la ligne à supprimer. Avec ces deux informations, on
    * extrait deux sous chaine qui une fois concatèné l'une à l'autre formeront
    * un nouveau carnet excluant le contact à la ligne 'contactLigne'
    *
    * @param carnet Le carnet de contact
    * @param contactLigne La position de la ligne qui devra etre supprimée
    * @return Le nouveau carnet excluant la ligne passé en argument
    */
   private static String nouvelleSuppression(String carnet, int contactLigne) {

      String res = "";
      int indexSousChaineHaut;
      int indexSousChaineBas;

      if(contactLigne == 0){
         indexSousChaineBas = obtenirIndexDecoupeCarnet(carnet,1);
         res = carnet.substring(indexSousChaineBas);
      } else if (contactLigne > 0) {
         indexSousChaineHaut = obtenirIndexDecoupeCarnet(carnet,contactLigne);
         res = carnet.substring(0,indexSousChaineHaut);
         indexSousChaineBas = obtenirIndexDecoupeCarnet(carnet,contactLigne+1);
         res = res + carnet.substring(indexSousChaineBas);
      }

      return res;
   }

   /**
    * Cette methode donne l'id d'une ligne de contact sous la forme entière
    * On va supposer la ligne de contact bien formaté.
    *
    * @param contactLigne la ligne de contact bien formaté a partir de quoi
    *                     on veux extraire le champ ID
    * @return le champ ID de la ligne de contact sous la forme entière(int).
    */
   public static int obtenirIdEntier(String contactLigne) {
      return Integer.parseInt(obtenirIdContact(contactLigne));
   }

   /**
    * Cette methode cherche la position dans le carnet du contatct ayant
    * le id donnée en argument.
    *
    * @param id le id du contact a trouver
    * @param carnet le carnet de contact sous la forme d'un tableau
    *               de String découpé ligne par ligne.
    * @return un entier qui représente la position du contact ayant
    * pour id la valeur passé en argument. Si le id n'est pas trouvé,
    * cette methode retourne -1.
    */
   public static int obtenirPositionParId(int id , String[] carnet) {

      int reponse = -1;
      int idDebut;
      int idFin;

      //Commence a chercher depuis le debut et la fin du carnet
      int debut = 0;
      int fin = carnet.length-1;

      //Continue a chercher tant que les index de debut et de fin
      //ne se croise pas
      while(debut <= fin && reponse == -1) {

         idDebut = obtenirIdEntier(carnet[debut]);
         idFin = obtenirIdEntier(carnet[fin]);

         if (id == idDebut)
            reponse = debut;
         else if (id == idFin)
            reponse = fin;

         debut++;
         fin--;
      }

      return reponse;
   }
}
