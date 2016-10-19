// Ici vous trouverez l'ensemble des classes qui sont utilisées pour stocker efficacement les données
// de l'utilisateur et pour calculer le prix du voyage.

package prjtravailpratique1;


// Catégories: personne seule/famille/groupe
interface Categorie
{
    // Multiplicateur sur le tarif de base du billet par rapport à la destination
    public double calculerMultiplicateur();

}

class PersonneSeule implements Categorie 
{
    public int age;
    @Override
    public double calculerMultiplicateur()
    {
        // On assume que l'âge est supérieur ou égal à 13 parce que cela aurait dû être géré plus tôt.
        double rabais = 0;
        if(age <= Constantes.AGEMAXIMALADOS || age >= Constantes.AGEMINIMALAINES)
            rabais = Constantes.RABAISINDIVIDUELADOSETAINES;
        
        double multiplicateur = 1 - rabais;
        return multiplicateur; // Personne seule donc pas *1
        
    }
    @Override
    public String toString()
    {
        return String.format(Messages.PERSONNESEULE_RECAP, age);
    }
}

class Famille implements Categorie 
{
    public int nbEnfants;
   
    @Override
    public double calculerMultiplicateur()
    {
        double multiplicateur = 0;
        int nbEnfantsPourCalcul = nbEnfants;
        if(nbEnfants > Constantes.NBENFANTSNORMALMAXIMAL)
        {
            multiplicateur += (nbEnfants - Constantes.NBENFANTSNORMALMAXIMAL) * (1 - Constantes.RABAISENFANTSUPPLEMENTAIRE);
            nbEnfantsPourCalcul = Constantes.NBENFANTSNORMALMAXIMAL;
        }
        
        double rabais = Constantes.RABAISSELONNOMBREENFANT[nbEnfantsPourCalcul - 1];
        
        multiplicateur += (nbEnfantsPourCalcul + Constantes.NBADULTES) * (1 - rabais);
        return multiplicateur;
    }
    
    @Override
    public String toString()
    {
        return String.format(Messages.FAMILLE_RECAP, nbEnfants, (nbEnfants == 1 ? "" : "s"));
    }
}

class Groupe implements Categorie 
{
    public Boolean estEnfants; // Sinon aînés
    public int     nbPersonnes;
    @Override
    public double calculerMultiplicateur()
    {
        double multiplicateur = nbPersonnes * ( 1 - (estEnfants ? Constantes.RABAISGROUPESCOLAIRE : Constantes.RABAISGROUPEAINES ));
        return multiplicateur;
    }
    @Override
    public String toString()
    {
        return String.format(Messages.GROUPE_RECAP, (estEnfants ? "enfants" : "aînés"), nbPersonnes);
    }
}

class ChambreDHotel 
{
    public int nbNuits;
    public int indexDeChambre; // index
    public int nbDeChambres = 1;
    public ChambreDHotel()
    {
        nbNuits = 0;
        indexDeChambre = -1;
        nbDeChambres = 1;
    }
    
    public double calculerPrix()
    {
        double prix = 0;
        if(indexDeChambre != -1)
            prix = Constantes.FORFAITSDECHAMBRES_VALEURS[indexDeChambre] * nbNuits * nbDeChambres;
        
        return prix;
    }
    
    @Override
    public String toString()
    {
        return String.format(Messages.CHAMBRE_RECAP, nbDeChambres, (nbDeChambres == 1 ? "" : "s"), Constantes.FORFAITSDECHAMBRES_CLES[indexDeChambre]);
    }
    
}

class LocationVoiture
{
    public int nbJours;
    public int indexDeLocation;
    public LocationVoiture()
    {
        nbJours = 0;
        indexDeLocation = -1;
    }
    
    public double calculerPrix()
    {
        double prix = 0;
        if(indexDeLocation != -1)
            prix = Constantes.LOCATIONDEVOITURES_VALEURS[indexDeLocation] * nbJours;
       
        return prix;
    }
    
    // Représentation de l'objet sous forme de chaîne: Description de ses attributs.
    @Override
    public String toString()
    {
        return String.format(Messages.LOCATION_RECAP, Constantes.LOCATIONDEVOITURES_CLES[indexDeLocation], nbJours, (nbJours == 1 ? "" : "s"));
    }
}

public class Forme
{
    public Forme()
    {
        nom = "";
        indexDeDestination = -1;
        indexDeCategorie   = -1;
        nbJours            = 0;
        chambre            = new ChambreDHotel();
        location           = new LocationVoiture();
        categorieChoisie   = null;
        
        coutBillets   = 0;
        coutChambre   = 0;
        coutLocation  = 0;
        coutSousTotal = 0;
        coutTPS       = 0;
        coutTVQ       = 0;
        coutTotal     = 0;

    }
    public String nom;
    public int indexDeDestination;
    public int       nbJours;
    
    
    public Categorie categorieChoisie;
    public int       indexDeCategorie; 
    
    public ChambreDHotel chambre;
    public LocationVoiture location;
   
    // Prix
    public double coutBillets;
    public double coutChambre;
    public double coutLocation;
    public double coutSousTotal;
    public double coutTPS;
    public double coutTVQ;
    public double coutTotal;
    
    public void calculerCouts()
    {
        // Fonction destinée à calculer tous les coûts (évidemment). 
        // À n'appeler que si tous les champs ont été remplis, faute de quoi ça risque de mal se passer.
        coutLocation  = location.calculerPrix();
        coutChambre   = chambre.calculerPrix();
        coutBillets   = categorieChoisie.calculerMultiplicateur() * Constantes.DESTINATIONS_VALEURS[indexDeDestination];

        coutSousTotal = coutBillets + coutChambre + coutLocation;
        coutTPS       = coutSousTotal * Constantes.TPS;
        coutTVQ       = coutSousTotal * Constantes.TVQ;

        coutTotal     = coutSousTotal + coutTPS + coutTVQ;
    }
  
}

