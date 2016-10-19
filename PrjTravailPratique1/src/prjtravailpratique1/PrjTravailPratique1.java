package prjtravailpratique1;

public class PrjTravailPratique1 
{
    public static void main(String[] args)
    {
        while(true)
        {
            IOUtils.separateur2();
            Forme forme = new Forme();
            RemplissageDeFormeIO remplissage = new RemplissageDeFormeIO(forme);
            remplissage.remplirForme();
            forme.calculerCouts();
            
            // Recap des informations entrées et affichage des prix
            RecapitulationIO.recapitulerInformations(forme);
            IOUtils.separateur2();
            RecapitulationIO.afficherPrix(forme);
            
            IOUtils.separateur2();
            
            // Option de sortir
            String[] choix =  {"Quitter", "Recommencer"};
            
            if(DemanderIndex.demanderIndex(Messages.CHOIX_FINAL, choix) == 0) 
            {
                System.out.println(Messages.BYE_BYE);
                break;
            }
        }
    }
    
}
