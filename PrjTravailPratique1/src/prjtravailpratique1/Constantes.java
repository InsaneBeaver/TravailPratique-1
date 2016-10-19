package prjtravailpratique1;

public class Constantes
{
    
    final public static String[] TYPESDESEJOURS = {"Séjour d’une semaine (7j)", "Week End (2j Sam-Dim)", "Autre"};
    
    // Pseudomap parce que les maps java sont atroces
    // Pas convaincu que Sept-îles soit la meilleure destination imaginable quand on fait un burnout, mais oki doki OuO
    final public static String[] DESTINATIONS_CLES    = {"Sept-Îles (310$/personne)", "Halifax (350$/personne)", "Toronto (460$/personne)", "Vancouver (790$/personne)"}; 
    final public static double[] DESTINATIONS_VALEURS = {310,                350,              460,              790};
    
    // Constantes générales de catégories
    final public static String[] TYPESDECATEGORIE = {"Personnes seules", "Famille", "Groupe"};
    
    //Constantes pour personnes seules
    final public static double   RABAISINDIVIDUELADOSETAINES = 0.05;
    final public static int      AGEMINIMALADOS              = 13;
    final public static int      AGEMAXIMALADOS              = 18;
    final public static int      AGEMINIMALAINES             = 65;
    
    //Constantes pour famille
    final public static int     NBADULTES                  = 2;
    // Pour un enfant, 6%; pour deux enfants, 7%; pour trois, 8%.
    final public static double[] RABAISSELONNOMBREENFANT   = {0.06, 0.07, 0.08};
    final public static int     NBENFANTSNORMALMAXIMAL     = RABAISSELONNOMBREENFANT.length;
    // 10% pour tous les autres enfants.
    final public static double  RABAISENFANTSUPPLEMENTAIRE = 0.1;

    // Constantes pour groupe
    final public static String[] TYPESDEGROUPES_CLES     = {"Groupe scolaire", "Groupe d'aînés"};
    final public static Boolean[] TYPESDEGROUPES_VALEURS = {true, false};
    final public static int NBMINIMALGROUPE              = 10;
    final public static double RABAISGROUPESCOLAIRE      = 0.04;
    final public static double RABAISGROUPEAINES         = 0.02;
    
    // Constantes pour chambre d'hotel
    final public static String[] FORFAITSDECHAMBRES_CLES    = {"Régulière (60$/nuit)", "Double (100$/nuit)", "Familiale (300$/nuit)", "Suite (400$/nuit)"};
    final public static double[] FORFAITSDECHAMBRES_VALEURS = {60, 100, 300, 400};
    
    // Constantes pour location de voitures. Dernier item doit être "pas de voiture".
    final public static String[] LOCATIONDEVOITURES_CLES      = {"Citadine (30$/jour)", "4x4 (50$/jour)", "Luxe (100$/jour)", "Bus (150$/jour)", "Non (0$/jour)"};
    final public static double[]   LOCATIONDEVOITURES_VALEURS = {30, 50, 100, 150, 0};
    
    //Constantes de taxes;
    final public static double TPS   = 0.05;
    final public static double TVQ   = 0.0975;
    
}

