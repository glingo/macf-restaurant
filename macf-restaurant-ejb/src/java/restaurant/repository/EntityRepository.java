package restaurant.repository;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public abstract class EntityRepository<E> implements RepositoryInterface<E> {
    
    @PersistenceContext
    protected EntityManager em;
    
    private final Class<E> clazz;
    private final String className;

    public EntityRepository() {
        this.clazz = getManagedClass();
        
        assert clazz != null 
                : "Supported Class of a repository must not be null";
        
        this.className = clazz.getSimpleName();
    }

//    public EntityRepository(Class<E> clazz) {
//        
//        assert clazz != null 
//                : "Supported Class of a repository must not be null";
//        
//        this.clazz = clazz;
//        this.className = clazz.getSimpleName();
//    }
    
    protected abstract Class<E> getManagedClass();
    
    protected final String getManagedClassName(){
        return getManagedClass().getSimpleName();
    }
    
    @Override
    public void save(E instance) {
        em.getTransaction().begin();
        em.persist(instance);
        em.getTransaction().commit();
    }

    @Override
    public E findById(Long id) {
        return em.find(this.clazz, id);
    }

    @Override
    public Collection<E> findAll() {
        Query q = em.createQuery("SELECT e", this.clazz);
//        q.setParameter("clazz", this.className);
        return q.getResultList();
    }

}
