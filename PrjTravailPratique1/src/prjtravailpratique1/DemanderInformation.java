/*
    Voir la définition de demanderInformation pour plus de détails.
 */
package prjtravailpratique1;

import java.util.Scanner;

abstract class RestrictionInformation
{
    abstract public Boolean testInfo(String info); // Si vrai, la restriction est remplie. Si pas vrai, la valeur est déclarée comme invalide.
    public String errmsg = "Valeur invalide";
    
    protected final void mettreMessageErreur(String msg)
    {
        errmsg = msg;
    }
}


public class DemanderInformation {
    public static String demanderInformation(String requete, Boolean peutEtreVide, RestrictionInformation... restrictions)
    {
        // Code de base.
        // Toutes les autres fonctions de demande d'informations (comme demanderEntier et demanderIndex)
        // passent par cette fonction. Pour garantir un comportement spécifique (comme pour demander un index
        // ou un entier, ils fournissent des restrictions qui dérivent de la classe RestrictionInformation.
        // Si l'input fourni n'obéit pas à une restriction, le programme imprime le message d'erreur qui
        // venait avec la classe et redemande tout à l'utilisateur.
        // Si ça marche, la fonction sort du while et retourne l'input sous forme de chaîne (c'est la 
        // job du programme de convertir cette chaîne en quelque chose de voulu)
        String resultat;
        boucleDeDemande:
        while(true)
        {
            Scanner clavier = new Scanner(System.in);
            System.out.println(requete);
            System.out.print(Messages.DEBUTREQUETE);

            resultat = clavier.nextLine();
            
            // On fait just redemander si ça ne peut pas être vide et si ce l'est. 
            // Pas besoin de dire à l'utilisateur pourquoi, il s'en doute sûrement.
            if(resultat.length() == 0 && !peutEtreVide) 
                continue;
            
            // On teste toutes les restrictions qui nous ont été données.
            for(RestrictionInformation restriction:restrictions)
            {
                if(!restriction.testInfo(resultat))
                {
                    // Mauvais. On imprime l'erreur et on repart dans la boucle. 
                    System.out.println(String.format(Messages.MESSAGEDEVALEURINVALIDE, restriction.errmsg));
                    continue boucleDeDemande;
                }
            }
            
            // Si l'on est passé à travers le for sans continuer la boucle, on a fini. 
            break;
            
        }
        return resultat;
    }

    
    public static RestrictionInformation[] concatenerRestrictions(RestrictionInformation[]... args)
    {
        // Étape 1: On compte le nombre d'éléments total
        int len = 0;
        for(RestrictionInformation[] arg : args) for(RestrictionInformation elem : arg) len++;
        
        // Étape 2: On crée le tableau avec le bon nombre d'items
        RestrictionInformation[] nouveauTableau = new RestrictionInformation[len];
        
        // Étape 3: On vire tous les éléments dans ce même tableau
        int i = 0;
        for(RestrictionInformation[] arg : args) for(RestrictionInformation elem : arg) 
        {
            if(elem != null)
                nouveauTableau[i] = elem;
            i++;
        }
        
        // Étape 4: Prêt à être servi.
        return nouveauTableau;
    }
}
