/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjtravailpratique1;

class RestrictionIndex extends RestrictionInformation
{
    private int indexmax;
    public RestrictionIndex(int _indexmax)
    {
        indexmax = _indexmax;
        mettreMessageErreur(String.format(Messages.INDEXINVALIDE, DemanderIndex.indexAIndexAlpha(indexmax)));
        
    }
    
    @Override
    public Boolean testInfo(String info)
    {
        info = DemanderIndex.nettoyerIndex(info);
        
        // tout est de format a, b, aa, bbb, etc. Si une lettre diverge, c'est pas bon.
        Boolean lettresToutesPareilles = true;
        for(int i = 1; i < info.length(); i++)
        {
            if(info.charAt(i) != info.charAt(0))
            {
                lettresToutesPareilles = false;
                break;
            }
        }
        
        // Trois tests; 1) le premier caractère doit être une lettre 2) tous les caractères doivent être identiques
        // 3) L'index doit être bon (pas supérieur à la longueur du tableau)
        return ((info.charAt(0)) >= 97) && (info.charAt(0) <= 122) && 
               lettresToutesPareilles && 
               (DemanderIndex.indexAlphaAIndex(info) <= indexmax);
    }
}
public class DemanderIndex {
    
    public static String multiplierCaractere(char caractere, int nombreDeFois)
    {
        String resultat = "";
        for(int i = 0; i < nombreDeFois; i++)
            resultat += caractere;
        
        return resultat;
    }
    
    public static String nettoyerIndex(String indexAlpha)
    {
        // Nettoie l'index en supprimant tous les caractères non numériques et en mettant tout en minuscules
        // "B." -> "b", "a A" -> "aa"
        String resultat = new String();
        for(int i = 0; i < indexAlpha.length(); i++)
        {
            char caractere = indexAlpha.charAt(i);
            if(Character.isAlphabetic(caractere))
                resultat += Character.toLowerCase(caractere);
        }
        return resultat;
    }
    
    public static String indexAIndexAlpha(int index)
    {
        // Transforme un index de tableau (comme 0, 1, 2) en lettre (a pour 0, b pour 1, aa pour 26, etc. )
        // Pas strictement nécessaire puisqu'on aurait juste pu imprimer l'index direct, mais pourquoi pas
        
        int l = index % 26; // Représente la lettre qui sera multipliée (de a = 0 à z = 25)
        int n = (index - l) / 26 + 1; // Représente le nombre de fois que lettre devra être multipliée.
        return multiplierCaractere((char)(97 + l), n);
    }
    public static int indexAlphaAIndex(String indexAlpha)
    {
        // Opération réciproque du précédent. 
        // On assume que l'index numérique est v
        return 26 * indexAlpha.length() + Character.toLowerCase(indexAlpha.charAt(0)) - 123;
    }
    
    public static int demanderIndex(String message, String[] choix, RestrictionInformation... restrictions)
    {
        // Prend un message à afficher, un tableau de string. Affiche le choix et demande à l'utilisateur de choisir
        if(choix.length == 0) return -1; // Il n'y a rien à faire avec ça
        
        System.out.println(message);
        // Imprime tous les choix de manière sympathique. 
        for(int i = 0; i < choix.length; i++)
            System.out.println("\t"+ indexAIndexAlpha(i) + ". " + choix[i]);

        // La restriction de l'index valide est la priorité numéro 1 de la fonction. 
        restrictions = DemanderInformation.concatenerRestrictions(new RestrictionInformation[] {new RestrictionIndex(choix.length - 1)}, restrictions);
        
        String indexAlpha = DemanderInformation.demanderInformation(Messages.DEMANDEDINDEX, false, restrictions);
        return indexAlphaAIndex(nettoyerIndex(indexAlpha));
    }
    
}
