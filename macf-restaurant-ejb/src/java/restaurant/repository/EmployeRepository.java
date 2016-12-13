package restaurant.repository;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import restaurant.model.administratif.Employe;

@Stateless
public class EmployeRepository extends EntityRepository<Employe> {

    public EmployeRepository() {
        super();
    }
    
    public Employe login(String code) {
        
        CriteriaBuilder cb = getBuilder();
        CriteriaQuery<Employe> q = cb.createQuery(this.getManagedClass());
        Root<Employe> c = q.from(this.getManagedClass());
        Predicate equal = cb.equal(c.get("code"), code);
        q.select(c).where(equal);
        TypedQuery<Employe> query = em.createQuery(q);
        
        return singleResultOrNull(query);
    }

    @Override
    protected Class<Employe> getManagedClass() {
        return Employe.class;
    }
    
}