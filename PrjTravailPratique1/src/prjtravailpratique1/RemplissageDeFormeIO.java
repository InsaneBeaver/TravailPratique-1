// Ici vous trouverez tout le code qui est utilisé pour obtenir les données de l'utilisateur.

package prjtravailpratique1;

public class RemplissageDeFormeIO
{
    public RemplissageDeFormeIO(Forme _forme)
    {
        forme = _forme;

    }
    Forme forme;


    
    public void remplirForme()
    {
        
        System.out.println(Messages.BIENVENUE);
        
        // Manière pseudo-efficace de l'écrire pour éviter 
        // d'avoir à réécrire IOUtils.separateur() à chaque fois.
        for(int i = 0; i < 6; i++)
        {
            switch(i)
            {
                case 0:
                    demanderNom();
                    break;
                case 1:
                    demanderDestination();
                    break;
                  
                case 2:
                    demanderLongueurSejour();
                    break;
                    
                case 3:
                    demanderCategorie();
                    break;
                    
                case 4:
                    demanderChambre();
                    break;
                
                case 5:
                    demanderLocation();
                    break;
            }
            IOUtils.separateur();
          
        }
    }
        
        
    private void demanderNom()
    {
        forme.nom = DemanderInformation.demanderInformation(Messages.NOM_DEMANDE, false);
    }
    
    private void demanderDestination()
    {
        forme.indexDeDestination =  DemanderIndex.demanderIndex(Messages.DEST_DEMANDE, Constantes.DESTINATIONS_CLES);
    }
    
    private void demanderLongueurSejour()
    {
        int indexDeSejour =  DemanderIndex.demanderIndex(Messages.DUREE_DEMANDE, Constantes.TYPESDESEJOURS);
        int nbJours = 0;
        switch(indexDeSejour)
        {
            case 0:
                nbJours = 7;
                break;
            
            case 1:
                nbJours = 2;
                break;
                
            case 2:
                nbJours = DemanderEntier.demanderNaturel(Messages.DUREEAUTRE_DEMANDE);
                break;

        
        }        
        forme.nbJours = nbJours;
        
    }
    
    private void demanderCategorie()
    {
        int indexDeCategorie =  DemanderIndex.demanderIndex(Messages.CATEGORIE_DEMANDE, Constantes.TYPESDECATEGORIE);
        forme.indexDeCategorie = indexDeCategorie;
        Categorie categorieChoisie = null;
        
        switch(indexDeCategorie)
        {
            case 0:
                categorieChoisie = demanderPersonneSeule(); 
                break;
            
            case 1:
                categorieChoisie = demanderFamille();
                break;
            
            case 2:
                categorieChoisie = demanderGroupe();
                break;
            
        }
        forme.categorieChoisie = categorieChoisie;
    }
    
    private Categorie demanderPersonneSeule()
    {
        PersonneSeule categorie = new PersonneSeule();
        // Restriction: Entier doit être supérieur ou égal à âge minimal ado.
        RestrictionInformation restriction = new RestrictionEntierMinimum(Constantes.AGEMINIMALADOS, Messages.MAUVAISAGE);
        categorie.age = DemanderEntier.demanderNaturel(Messages.AGE_DEMANDE, restriction);
        return categorie;
        
    }
    
    private Categorie demanderFamille()
    {
        Famille categorie = new Famille();
        
        // minimum de 1 enfant (sinon ça ne s'appelle pas une famille)
        RestrictionInformation restriction = new RestrictionEntierMinimum(1, Messages.MAUVAISNBENFANTS);

        categorie.nbEnfants = DemanderEntier.demanderNaturel(Messages.NBENFANTS_DEMANDE, restriction);
        return categorie;
    
    }
    private Categorie demanderGroupe()
    {
        Groupe categorie = new Groupe();
        categorie.estEnfants = Constantes.TYPESDEGROUPES_VALEURS[ DemanderIndex.demanderIndex(Messages.TYPEGROUPE_DEMANDE, Constantes.TYPESDEGROUPES_CLES)];
        RestrictionEntierMinimum restriction = new RestrictionEntierMinimum(Constantes.NBMINIMALGROUPE, Messages.MAUVAISNBGROUPE);
        categorie.nbPersonnes = DemanderEntier.demanderNaturel(Messages.NBGROUPE_DEMANDE, restriction);
       
        return categorie;
    
    }
    
    private void demanderChambre()
    {
        forme.chambre.nbNuits = forme.nbJours;
        forme.chambre.indexDeChambre =  DemanderIndex.demanderIndex(Messages.TYPECHAMBRE_DEMANDE, Constantes.FORFAITSDECHAMBRES_CLES);

        if(forme.indexDeCategorie != 0)
            forme.chambre.nbDeChambres = DemanderEntier.demanderNaturel(Messages.NBCHAMBRES_DEMANDE);
        
        else
             forme.chambre.nbDeChambres = 1;
    
    }
    
    private void demanderLocation()
    {
        forme.location.indexDeLocation =  DemanderIndex.demanderIndex(Messages.TYPELOCATION_DEMANDE, Constantes.LOCATIONDEVOITURES_CLES);
        
        // Sinon, l'utilisateur ne veut pas de location. 
        if(forme.location.indexDeLocation != Constantes.LOCATIONDEVOITURES_CLES.length - 1)
        {
            String errmsg                        = String.format(Messages.MAUVAISJRSLOCATION, forme.nbJours);
            RestrictionEntierMaximum restriction = new RestrictionEntierMaximum(forme.nbJours, errmsg);
            forme.location.nbJours               = DemanderEntier.demanderNaturel(Messages.NBJRSLOCATION_DEMANDE, restriction);
        }
        
    }
}
