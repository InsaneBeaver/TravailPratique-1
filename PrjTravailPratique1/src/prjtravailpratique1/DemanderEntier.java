package prjtravailpratique1;

import java.util.Scanner;

// Pour des demandes spéciales, on permet au programmeur de passer des restrictions personnalisées sur
// les valeurs qu'on peut donner à l'entier.
// Ces restrictions sont transmises par les classes qui suivent.
// Cela permet, par exemple, de garantir qu'un groupe de personnes aura au minimum 10 personnes. 
// On passe une restriction de type RestrictionEntierMinimum avec un minimum de 10 personnes.

class RestrictionEntier extends RestrictionInformation
{
    public RestrictionEntier()
    {
        mettreMessageErreur(Messages.PASUNENTIER);
    }
    
    @Override
    public Boolean testInfo(String info)
    {
        // Si Integer n'arrive pas à le lire on peut être assez certain que ce n'est pas un nombre. 
        try
        {
            int val = Integer.parseInt(info);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}

class RestrictionEntierMinimum extends RestrictionInformation
{
    private int min;
    public RestrictionEntierMinimum(int _min) 
    {
        min = _min;
        mettreMessageErreur(String.format(Messages.VALEURTROPPETITE, min));
    }
    
    public RestrictionEntierMinimum(int _min, String _errmsg) 
    {
        min = _min;
        mettreMessageErreur(_errmsg);
    }
    
    @Override
    public Boolean testInfo(String a)
    {
        // On peut assumer que la valeur est déja lisible en entier. 
        return Integer.parseInt(a) >= min;
    }
}

class RestrictionEntierMaximum extends RestrictionInformation
{
    private int max;
    public RestrictionEntierMaximum(int _max) 
    {
        max = _max;
        mettreMessageErreur(String.format(Messages.VALEURTROPGRANDE, max));
    }
    
    public RestrictionEntierMaximum(int _max, String _errmsg) 
    {
        max = _max;
        mettreMessageErreur(_errmsg);
    }
    
    @Override
    public Boolean testInfo(String a)
    {
        return Integer.parseInt(a) <= max;
    }
    
}


public class DemanderEntier {
    
    public static int demanderEntier(String requete, RestrictionInformation... restrictions)
    {
        RestrictionInformation[] tableaurestrictions = {new RestrictionEntier()};
        tableaurestrictions = DemanderInformation.concatenerRestrictions(tableaurestrictions, restrictions);
        
        return Integer.parseInt(DemanderInformation.demanderInformation(requete, false, tableaurestrictions));
    }
    
    public static int demanderNaturel(String requete, RestrictionInformation... restrictions)
    {
        RestrictionInformation[] tableaurestrictions = {new RestrictionEntierMinimum(0, Messages.NATURELNEGATIF)};
        tableaurestrictions = DemanderInformation.concatenerRestrictions(tableaurestrictions, restrictions);
        return demanderEntier(requete, tableaurestrictions);
    }
}
