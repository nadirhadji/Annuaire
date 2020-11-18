
public class TP2 {
   
   /***********************
    * CONSTANTES
    ***********************/
   
   //Bornes de validation des entrees de l'utilisateur
   public final static String MENU_MIN = "1";
   public final static String MENU_MAX = "4";
   public final static String CHOIX_MENUS_VALIDES = "1234";
   public final static int ID_CONTACT_MIN = 1;
   public final static int ID_CONTACT_MAX = 999;

   //Messages - validation choix menu
   public final static String MSG_SOLL_MENU = "Entrez votre choix : ";
   public final static String MSG_ERR_MENU = "\nErreur, entrez une valeur entre "
           + MENU_MIN + " et " + MENU_MAX  + ".";

   //Messages - validation des informations d'un contact
   public final static String MSG_SOLL_NOM = "Nom de famille du contact : ";
   public final static String MSG_ERR_NOM = "\nErreur, le nom de famille doit "
           + "contenir entre 1 et 30 caracteres.";
   public final static String MSG_SOLL_PRENOM = "Prenom du contact : ";
   public final static String MSG_ERR_PRENOM = "\nErreur, le prenom doit contenir "
           + "entre 1 et 30 caracteres.";
   public final static String MSG_SOLL_COURRIEL = "Courriel (ou tapez [ENTREE] "
           + "pour omettre le courriel) : ";
   public final static String MSG_ERR_COURRIEL = "\nErreur, le courriel donne est "
           + "mal forme.";
   public final static String MSG_SOLL_TEL = "Telephone (ou tapez [ENTREE] pour "
           + "omettre le telephone) : ";
   public final static String MSG_ERR_TEL = "\nErreur, vous devez entrez une "
           + "chaine de 10 chiffres.";
   public final static String MSG_SOLL_ID_CONTACT = "Entrez le no du contact a "
           + "supprimer : ";
   public final static String MSG_ERR_ID_CONTACT = "Erreur, le no du contact "
           + "doit etre un nombre entier entre 1 et 999.";
   
   //Messages divers
   public final static String PRESENTATION = "Ce logiciel permet la gestion "
           + "d'un carnet de contacts.";
   public final static String MSG_ENTER = "Appuyez sur [ENTREE] pour continuer...";
   public final static String MSG_FIN_PROG = "FIN NORMALE DU PROGRAMME.";
   public final static String MSG_CARNET_VIDE = "Le carnet ne contient aucun contact.";
   
   /*******************************
    * METHODES D'AFFICHAGE
    *******************************/

   /**
    * Cette methode affiche le menu principal de l'application, sous cette
    * forme :
    *    ----
    *    MENU
    *    ----
    *    1. Ajouter un nouveau contact
    *    2. Supprimer un contact
    *    3. Afficher tous les contacts
    *    4. Quitter
    */
   public static void afficherMenu() {
      System.out.println("\n----\nMENU\n----\n"
              + "1. Ajouter un nouveau contact\n"
              + "2. Supprimer un contact\n"
              + "3. Afficher tous les contacts\n"
              + "4. Quitter\n");
   }
   
   /**
    * Cette methode marque une pause, et demande a l'utilisateur de taper ENTREE 
    * pour continuer. Lorsque l'utilisateur tape ENTREE, le programme se poursuit.
    */
   public static void pause () {
      System.out.print(MSG_ENTER);
      Clavier.lireFinLigne();
      System.out.println();
   }
   
   /**
    * Cette methode affiche une presentation du logiciel, et demande de taper 
    * ENTREE pour continuer.
    */
   public static void presenterLogiciel() {
      System.out.println(PRESENTATION + "\n\n");
      pause();
   }
   
   /**
    * Cette methode affiche un message de fin du programme (MSG_FIN_PROG).
    */
   public static void afficherFinProg () {
      System.out.println("\n\n" + MSG_FIN_PROG);
   }
   
   /*******************************
    * METHODES DE VALIDATION
    *******************************/
   
   /**
    * Cette methode demande a l'utilisateur d'entrer une chaine de caracteres en
    * utilisant le message de sollicitation donne msgSoll. 
    * Tant que la chaine entree n'est pas valide, la methode affiche le msg 
    * d'erreur donne, msgErr, et redemande d'entrer une autre chaine. 
    * Une chaine valide est une chaine dont la longueur est entre lngMin et 
    * lngMax inclusivement.
    * 
    * Si lngMin < 0 ou si lngMax < lngMin, la methode retourne null.
    * 
    * @param msgSoll le msg de sollicitation pour la chaine a saisir.
    * @param msgErr le msg d'erreur a afficher lorsque la chaine saisie par
    *               l'utilisateur est invalide.
    * @param lngMin la longueur minimum d'une chaine valide.
    * @param lngMax la longueur maximum d'une chaine valide.
    * @return la chaine valide entree par l'utilisateur.
    */
   public static String validerChaine (String msgSoll, String msgErr, 
           int lngMin, int lngMax) {
      String chaine = null;
      
      if (lngMin >= 0 && lngMax >= lngMin) {
         do {
            System.out.print(msgSoll);
            chaine = Clavier.lireString();
            if (chaine.length() < lngMin || chaine.length() > lngMax) {
               System.out.println(msgErr);
            }
         } while (chaine.length() < lngMin || chaine.length() > lngMax);
      }
      return chaine;
   }
   
   /**
    * Cette methode demande a l'utilisateur d'entrer un nombre entier en
    * utilisant le message de sollicitation donne msgSoll. Tant que la valeur 
    * entree n'est pas valide, la methode affiche le msg d'erreur donne, msgErr, 
    * et redemande d'entrer un autre nombre entier.
    * 
    * Un nombre entier valide est un nombre entier >= 0, entre min et max.
    * Si min est < 0 ou si max < min, la methode retourne -1.
    * 
    * @param msgSoll le message de sollicitation pour le nombre entier a saisir.
    * @param msgErr le message d'erreur a afficher lorsque le nombre entier 
    *               saisi est invalide.
    * @param min la valeur minimum pour un nombre entier valide.
    *            Antecedent : doit etre >= 0
    * @param max la valeur maximum pour un nombre entier valide.
    *            Antecedent : doit etre >= min
    * @return le nombre entier valide saisi par l'utilisateur.
    */
   public static int validerEntier (String msgSoll, String msgErr, 
           int min, int max) {
      int entier = -1;
      
      if (min >= 0 && max >= min) {

         do {
            System.out.print(msgSoll);
            entier = Clavier.lireInt();
            if (entier < min || entier > max) {
               System.out.println(msgErr);
            }
         } while (entier < min || entier > max);
      }
      return entier;
   }
   
   /**
    * Cette methode permet de valider une entree de menu entre MENU_MIN et 
    * MENU_MAX, et retourne ensuite le menu choisi. La methode demande a 
    * l'utilisateur d'entrer une option de menu (MSG_SOLL_MENU) et tant que
    * l'utilisateur n'entre pas une valeur valide (entre MENU_MIN et MENU_MAX),
    * la methode affiche un message d'erreur (MSG_ERR_MENU). 
    * 
    * @return le choix de menu valide saisi par l'utilisateur.
    * 
    * NOTES TP2 : 
    *    - Les valeurs valides pour le menu sont contenues dans la chaine 
    *      CHOIX_MENUS_VALIDES, et vous devez utiliser cette constante.
    * 
    *    - Cette methode DOIT utiliser la methode validerChaine.
    */
   public static String validerMenu() {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   
   /**
    * Cette methode sert a valider un numero de telephone. Elle demande d'abord
    * a l'utilisateur d'entrer un numero de telephone (MSG_SOLL_TEL), et tant que
    * l'utilisateur n'entre pas un telephone valide, elle affiche un message 
    * d'erreur (MSG_ERR_TEL), et redemande d'entrer un autre numero de telephone. 
    * 
    * Un numero de telephone est valide si :
    *    - c'est une chaine de longueur 10 qui ne contient que des caracteres 
    *      numeriques ('0' a '9'). EX: "4153448998"
    * 
    *    OU BIEN
    * 
    *    - c'est une chaine vide ("") => de longueur 0.
    * 
    * @return le numero de telephone valide saisi par l'utilisateur. 
    * 
    * NOTES TP2 : 
    *    - Cette methode DOIT utiliser la methode neContientQueDesChiffres(...)
    *      de la classe TP2Utils.
    * 
    *    - Cette methode DOIT utiliser la methode validerChaine(...) de cette
    *      classe.
    */
   public static String validerTelephone() {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   } 
   
   /**
    * Cette methode sert a valider une adresse de courriel. Elle demande d'abord
    * a l'utilisateur d'entrer son courriel (MSG_SOLL_COURRIEL), et tant que
    * l'utilisateur n'entre pas un courriel valide, elle affiche un message 
    * d'erreur (MSG_ERR_COURRIEL) et redemande d'entrer un autre courriel. 
    * 
    * Un courriel est valide si :
    *    - c'est une chaine de caracteres entre 5 et 50 caracteres inclusivement
    *    ET
    *    - il ne contient que des lettres(minuscules ou majuscules) ou des chiffres
    *      ('0' à '9'), ou les caracteres '_', '.' et '@'
    *    ET
    *    - il contient au moins un caractere '.'  
    *    ET
    *    - il contient exactement un caractere '@'
    * 
    *    OU BIEN
    * 
    *    - c'est une chaine vide ("") => de longueur 0.
    * 
    * @return le courriel valide saisi.
    * 
    * NOTES TP2 : 
    *    - Cette methode DOIT utiliser les methodes suivantes de la classe
    *      TP2Utils :
    *          - contientNCar(...)
    *          - estAlphaNumPlus(...)
    * 
    *    - Cette methode DOIT utiliser la methode validerChaine(...) de cette
    *      classe.
    */
   public static String validerCourriel() {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /*****************************************
    * METHODES D'EXECUTION DES CHOIX DU MENU
    *****************************************/
   
   /**
    * Cette methode saisit et valide toutes les informations d'un contact 
    * (nom, prenom, courriel, et telephone) puis ajoute ce contact au carnet
    * donne en parametre. Après l'insertion, le carnet doit etre bien forme.
    * 
    * @param idContact le numero unique d'identification de ce contact.
    * @param carnet le carnet de contacts dans lequel ajouter le contact cree
    *               avec les informations saisies.
    *               ANTECEDENTS : - On suppose carnet NON NULL (mais peut être 
    *                               vide).
    *                             - Si non vide, on suppose le carnet bien 
    *                               forme.
    * 
    * @return une nouvelle chaine de caracteres representant le carnet de 
    *         contacts APRES l'insertion du nouveau contact.
    * 
    * NOTES TP2:
    * 
    * Un carnet bien forme est une chaine de caracteres qui respecte les 
    * specifications suivantes :
    *    - Une chaine vide signifie qu'il n'y a aucun contact dans le carnet.
    * 
    *    Lorsque le carnet n'est pas vide :
    *    - La chaine doit contenir un seul contact par ligne
    *    - Une ligne representant un contact (contact-ligne) doit être formee 
    *      comme suit :
    *            id|nom|prenom|courriel|telephone 
    * 
    *       * VOUS DEVEZ UTILISER LA METHODE formaterContactSurUneLigne(...) de
    *         la classe TP2Utils pour creer une ligne representant ce contact, 
    *         avant de l'inserer dans le carnet de contacts. Cette methode vous 
    *         est fournie. Voir sa documentation pour savoir comment l'utiliser.
    * 
    *    - Dans le carnet, les contacts-ligne doivent être places en ordre 
    *      alphabetique de leur nom de famille.
    * 
    *    - Exemple d'un carnet bien forme : 
    * 
    *      3|Crevier|Simon|simon@gmail.com|5145678988
    *      1|Douglas|Sylvie|AUCUN|4507461234
    *      2|Dumoulin|Fred|fredd@yahoo.ca|8196778234
    *      4|Girard|Myriam|AUCUN|AUCUN
    * 
    *    - Cette methode DOIT utiliser les methodes de validation de cette 
    *      classe suivantes :
    *          - validerChaine(...) - pour valider le nom et le prenom. 
    *            Un nom ou prenom valide est une chaine possedant entre 
    *            1 et 30 caracteres inclusivement.
    *          
    *          - validerCourriel()  - pour valider le courriel
    *          - validerTelephone() - pour valider le telephone
    * 
    *    - Cette methode DOIT utiliser les methodes suivantes de la classe
    *      TP2Utils :
    *          - formaterContactSurUneLigne(...)
    *          - insererCeContactDansCarnet(...)
    * 
    */
   public static String ajouterContact(int idContact, String carnet) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode saisit et valide le numero (id) du contact a supprimer. 
    * Si le contact existe dans le carnet, la methode supprime le contact du 
    * carnet. Si le contact n'existe pas dans le carnet, la methode ne modifie 
    * pas le carnet.
    * 
    * Si le carnet donne est vide, la methode ne demande pas le numero (id)
    * du contact a supprimer et affiche plutot un message a cet effet
    * (MSG_CARNET_VIDE).
    * 
    * @param carnet le carnet de contacts dans lequel supprimer le contact ayant
    *               l'id saisi par l'utilisateur.
    *               ANTECEDENTS : - On suppose carnet NON NULL (mais peut être 
    *                               vide).
    *                             - Si non vide, on suppose le carnet bien 
    *                               forme.
    * @return une nouvelle chaine de caracteres representant le carnet apres 
    *         la suppression (ou le carnet inchange si la suppression n'a 
    *         pas eu lieu).
    * 
    * NOTES TP2:
    *    - Un id valide est un nombre entier entre 1 et 999. Il est normal que
    *      votre programme plante si l'on entre autre chose qu'un entier.
    * 
    *    - Utilisez les constantes MSG_SOLL_ID_CONTACT, MSG_ERR_ID_CONTACT, 
    *      ID_CONTACT_MIN, ID_CONTACT_MAX
    * 
    *    - Cette methode DOIT utiliser la methode de validation suivante 
    *      de cette classe :
    *          - validerEntier(...) - pour valider l'id du contact a supprimer.
    * 
    *    - Cette methode DOIT utiliser la methode suivante de la classe
    *      TP2Utils :
    *          - supprimerCeContactDuCarnet(...) - pour supprimer ce contact
    */
   public static String supprimerContact (String carnet) {
      //METHODE A COMPLETER
      return null;  //pour compilation (a modifer)
   }
   
   /**
    * Cette methode affiche tous les contacts presents dans le carnet. Si le 
    * carnet est vide, elle affiche plutôt un message a cet effet (MSG_CARNET_VIDE).
    * 
    * @param carnet le carnet a afficher.
    * 
    *  NOTES TP2:
    * 
    *  Exemple d'affichage (vous devez respecter ce format) :
    * 
    *    Supposons le carnet suivant :
    * 
    *    6|abri|Ben|benben@hotmail.com|4502334565 
    *    2|avon|Nathalie|aucun|aucun
    *    1|lord|Marcos|aucun|aucun
    *    5|moo|Roger|moom@yahoo.ca|aucun
    *    3|zoo|Sylvie|szoo@gmail.com|5143445687
    *    4|zuu|Sébastien|aucun|4508889128
    *    
    *    La methode affiche (les noms de famille en majuscules, et les prenoms 
    *    en minuscule sauf la premiere lettre en majuscule) :
    *    --------------------
    *    CARNET DE CONTACTS
    *    --------------------
    * 
    *    ABRI, Ben (6)
    *    benben@hotmail.com
    *    (450) 233-4565
    * 
    *    AVON, Nathalie (2)
    * 
    *    LORD, Marcos (1)
    * 
    *    MOO, Roger (5)
    *    moom@yahoo.ca
    *
    *    ZOO, Sylvie (3)
    *    szoo@gmail.com
    *    (514) 344-5687
    *
    *    ZUU, Sébastien (4)
    *    (450) 888-9128
    * 
    *   - Cette methode DOIT utiliser la methode suivante de la classe
    *     TP2Utils :
    *          - formaterContact(...)
    * 
    */
   public static void afficherTousLesContacts (String carnet) {
      //METHODE A COMPLETER
   }
   
   /**
    * Application de gestion d'un carnet de Contact.
    * @param args aucun argument.
    */
   public static void main (String [] args) {
      
      //carnet de contacts
      String carnet = "";  //Au debut du programme, il n'y a aucun contacts
      String choixMenu;    //choix au menu
      int idContact = ID_CONTACT_MIN; //le premier idContact
      
      //presentation du logiciel
      presenterLogiciel();
      
      //boucle principale du programme
      do {
         //obtenir choix menu
         afficherMenu();
         choixMenu = validerMenu();
         System.out.println();
         
         //executer choix menu
         switch (choixMenu) {
            
            //Ajouter un nouveau contact
            case "1" :
               carnet = ajouterContact(idContact, carnet);
               idContact++; //ajuster le idContact pour le prochain contact 
                            //a ajouter.
               break;
               
            //Supprimer un contact
            case "2" :
               carnet = supprimerContact(carnet);
               break;
               
            //Afficher tous les contacts
            case "3" :
               afficherTousLesContacts(carnet);
               pause();
               break;
         }
        
      } while (!choixMenu.equals(MENU_MAX));
      
      afficherFinProg();
   }
   
}
