package prjtravailpratique1;

// Classe qui contient tous les messages utilisés par le programme.

public class Messages {
    final public static String BIENVENUE             = "Bonjour! Bienvenue à l'agence de voyage BdeB!";
    final public static String NOM_DEMANDE           = "Veuillez entrer votre nom: ";
    final public static String DEST_DEMANDE          = "Veuillez entrer votre destination: ";
    final public static String DUREE_DEMANDE         = "Veuillez entrer la durée du séjour: ";
    final public static String DUREEAUTRE_DEMANDE    = "Veuillez entrer le bon nombre de jours: ";
    final public static String CATEGORIE_DEMANDE     = "Veuillez entrer la catégorie qui vous convient: ";
    final public static String AGE_DEMANDE           = "Veuillez entrer votre âge: ";
    final public static String MAUVAISAGE            = "Vous ne seriez pas en âge de voyager! Veuillez entrer votre vrai âge.";
    final public static String NBENFANTS_DEMANDE     = "Veuillez entrer le nombre d'enfants avec vous: ";
    final public static String MAUVAISNBENFANTS      = "Vous ne pouvez pas avoir zéro enfants. ";
    final public static String TYPEGROUPE_DEMANDE    = "Veuillez entrer votre type de groupes: ";
    final public static String NBGROUPE_DEMANDE      = "Veuillez entrer votre nombre: ";
    final public static String MAUVAISNBGROUPE       = "Vous devez être au moins 10 pour constituer un groupe: ";
    final public static String TYPECHAMBRE_DEMANDE   = "Veuillez entrer le type de chambre désiré: ";
    final public static String NBCHAMBRES_DEMANDE    = "Veuillez entrer le nombre de chambres voulu: ";
    final public static String TYPELOCATION_DEMANDE  = "Veuillez entrer le type de location désiré: ";
    final public static String NBJRSLOCATION_DEMANDE = "Veuillez entrer le nombre de jours de location désiré: ";
    final public static String MAUVAISJRSLOCATION    = "Le nombre de jours de location ne peut pas être supérieur à la durée du voyage (%d jours). ";
   
    final public static String INFOGENERALES_RECAP   = "Votre nom est %s. Vous vous rendez à %s pour une durée de %d jour%s. ";
    final public static String PERSONNESEULE_RECAP   = "Vous êtes une personne seule. Vous avez %d ans.";
    final public static String FAMILLE_RECAP         = "Vous êtes une famille de %d enfant%s.";
    final public static String GROUPE_RECAP          = "Vous êtes un groupe d'%s de %d personnes";
    final public static String CHAMBRE_RECAP         = "Vous avez demandé %d chambre%s d'hôtel de type '%s'";
    final public static String LOCATION_RECAP        = "Vous avez loué '%s' pour une durée de %d jour%s";
    
    // Trucs finaux
    final public static String PRIX_BILLETS          = "Le prix des billets serait %.2f$";
    final public static String PRIX_CHAMBRE          = "Le prix de la chambre serait %.2f$";
    final public static String PRIX_LOCATION         = "Le prix de la location serait %.2f$";
    final public static String PRIX_AVANTTAXES       = "Le prix du voyage sans les taxes serait %.2f$";
    final public static String PRIX_TPS              = "La valeur de la TPS serait %.2f$";
    final public static String PRIX_TVQ              = "La valeur de la TVQ serait %.2f$";
    final public static String PRIX_FINAL            = "Ce voyage vous coûterait %.2f$";
    
    // Choix pour savoir si on repart le programme ou pas
    final public static String CHOIX_FINAL           = "Que souhaitez-vous faire?";
    final public static String BYE_BYE               = "Bye-bye! Revenez nous voir!";
    
    // Messages de fonction de demande d'information
    final public static String DEBUTREQUETE            = ">>> ";
    final public static String MESSAGEDEVALEURINVALIDE = "--Valeur rejetée. %s";
    final public static String VALEURINVALIDE          = "Valeur invalide";
    
    final public static String DEMANDEDINDEX           = "Veuillez entrer la (ou les) lettre(s) correspondant à votre choix.";
    final public static String INDEXINVALIDE           = "L'index que vous avez fourni est soit invalide, soit supérieur à l'index maximal permis %s.";
    
    final public static String PASUNENTIER             = "La valeur fournie n'a pas pu être lue comme un entier. ";
    final public static String NATURELNEGATIF          = "La valeur doit être positive";
    final public static String VALEURTROPGRANDE        = "Valeur trop grande. Doit être inférieure ou égale à %d.";
    final public static String VALEURTROPPETITE        = "Valeur trop petite. Doit être supérieure ou égale à %d.";
    

    
}
