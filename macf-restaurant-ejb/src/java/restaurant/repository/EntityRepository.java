package restaurant.repository;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class EntityRepository<E> implements RepositoryInterface<E> {
    
    @PersistenceContext
    protected EntityManager em;
    
    private Class<E> clazz;
    private String className;

    public EntityRepository() {
//        this.clazz = getManagedClass();
//        
//        assert clazz != null 
//                : "Supported Class of a repository must not be null";
//        
//        this.className = clazz.getSimpleName();
    }
    
    @PostConstruct
    public void init(){
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
    
    protected String getManagedClassName(){
        return getManagedClass().getSimpleName();
    }
    
    @Override
    public void save(E instance) {
        em.persist(instance);
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
