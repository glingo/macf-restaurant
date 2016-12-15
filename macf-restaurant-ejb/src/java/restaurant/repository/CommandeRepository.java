package restaurant.repository;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import restaurant.model.commande.Commande;

@Stateless
public class CommandeRepository extends EntityRepository<Commande> {

    public CommandeRepository() {
        super();
    }

    @Override
    protected Class<Commande> getManagedClass() {
        return Commande.class;
    }

    public Commande findByNumero(String numero) {

         // creer la requete jpql.
        // on recupère l'EntityManager ( fournit par JPA)
        // puis on ecrit la requette a effectuer.
        TypedQuery<Commande> query = this.em.createQuery("SELECT c FROM Commande AS c WHERE c.numero = :numero", Commande.class);
        
        // on injecte les parametres (marqués par des ':' dans la requette.
        query.setParameter("numero", numero);
        
        // on execute la requette.
        // query.getSingleResult();
        
        return singleResultOrNull(query);
    }

}
