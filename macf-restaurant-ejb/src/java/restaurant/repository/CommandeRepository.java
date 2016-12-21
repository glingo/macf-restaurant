package restaurant.repository;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import restaurant.model.catalogue.Menu;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;

@Stateless
public class CommandeRepository extends EntityRepository<Commande> {

    @PersistenceContext(unitName = "macf-restaurant-PU")
    private EntityManager em;

    public CommandeRepository() {
        super();
    }

    @Override
    protected Class<Commande> getManagedClass() {
        return Commande.class;
    }

    public Commande findByNumero(String numero) {

        // créer la requete jpql.
        // on recupère l'EntityManager ( fournit par JPA)
        // puis on écrit la requete à effectuer.
        TypedQuery<Commande> query = this.em.createQuery("SELECT c FROM Commande AS c WHERE c.numero = :paramNumero", Commande.class);

        // on injecte les paramètres (marqués par des ':' dans la requete.
        query.setParameter("paramNumero", numero);

        // on execute la requette.
        // query.getSingleResult();
        Commande cmd = singleResultOrNull(query);

        if (cmd != null) {
            Collection<LigneDeCommande> lcs = findLignesCommandeByIdCmd(cmd.getId());
            for (LigneDeCommande l : lcs) {
                if (l.getMenu() != null) {
                    Collection<LigneDeCommande> slc = findSousLigneCommandeByIdLigneCmd(l.getId());
                    l.setSousLigneDeCommande(slc);
                }
            }
            cmd.setLigneDeCommandes(lcs);
        }
        return cmd;
    }

    private Collection<LigneDeCommande> findLignesCommandeByIdCmd(Long idCmd) {
        String req01 = "SELECT lc FROM LigneDeCommande AS lc WHERE lc.commande.id = :paramId";
        Query query = em.createQuery(req01);
        query.setParameter("paramId", idCmd);
        return query.getResultList();
    }

    private Collection<LigneDeCommande> findSousLigneCommandeByIdLigneCmd(Long idLigneCmd) {
        String req01 = "SELECT lc FROM LigneDeCommande AS lc WHERE lc.ligneDeCommande.id= :paramId";
        Query query = em.createQuery(req01);
        query.setParameter("paramId", idLigneCmd);
        return query.getResultList();
    }
}
