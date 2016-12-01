package restaurant.repository;

import java.util.Collection;
import javax.ejb.Stateless;

@Stateless
public interface RepositoryInterface<E> {
    
    void save(E instance);
    
    E findById(Long id);
    
    Collection<E> findAll();
    
}
