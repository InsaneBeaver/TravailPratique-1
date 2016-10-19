// Ici vous trouverez tout le code qui sert à afficher ses informations ainsi que le prix de son voyage à l'utilisateur. 

package prjtravailpratique1;

public class RecapitulationIO {

   public static void recapitulerInformations(Forme forme)
   {
        System.out.println(String.format(Messages.INFOGENERALES_RECAP, forme.nom, Constantes.DESTINATIONS_CLES[forme.indexDeDestination], forme.nbJours, (forme.nbJours == 1 ? "" : "s")));
        
        // Usage de la surcharge de toString dans ces classes
        System.out.println(forme.categorieChoisie);
        System.out.println(forme.chambre);

        if(forme.location.indexDeLocation != Constantes.LOCATIONDEVOITURES_CLES.length - 1)
            System.out.println(forme.location);        

   }
   
   public static void afficherPrix(Forme forme)
   {
        System.out.println(String.format(Messages.PRIX_BILLETS, forme.coutBillets));
        System.out.println(String.format(Messages.PRIX_CHAMBRE, forme.coutChambre));
        System.out.println(String.format(Messages.PRIX_LOCATION, forme.coutLocation));
       
        System.out.println(String.format(Messages.PRIX_TPS, forme.coutTPS));
        System.out.println(String.format(Messages.PRIX_TVQ, forme.coutTVQ));
        System.out.println(String.format(Messages.PRIX_FINAL, forme.coutTotal));
   }
}
