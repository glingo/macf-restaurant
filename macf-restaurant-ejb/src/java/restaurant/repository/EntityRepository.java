package restaurant.repository;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class EntityRepository<E> implements RepositoryInterface<E> {
    
    @PersistenceContext
    protected EntityManager em;
    
    protected CriteriaBuilder builder;
    
    private Class<E> clazz;

    public EntityRepository() { }
    
    @PostConstruct
    public void init(){
        this.clazz = getManagedClass();
        
        assert clazz != null 
                : "Supported Class of a repository must not be null";
        
        this.builder = em.getCriteriaBuilder();
    }
    
    protected abstract Class<E> getManagedClass();
    
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
        CriteriaQuery q = getBuilder().createQuery(this.clazz);
        Root c = q.from(this.clazz);
        q.select(c);
        
        TypedQuery query = em.createQuery(q);
        return query.getResultList();
    }
    
    public CriteriaBuilder getBuilder() {
        return builder;
    }
    
}
