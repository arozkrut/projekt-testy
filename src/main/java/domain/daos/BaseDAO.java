package domain.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

public abstract class BaseDAO<T> {
    @Inject
    EntityManager entityManager;

    private final Class<T> type;

    public BaseDAO(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public T create(T entity) throws Exception {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        }
        catch (Exception e){
            throw new Exception("Couldn't create entity.");
        }
    }

    @Transactional
    public T update(T entity) throws Exception {
        try {
            entityManager.merge(entity);
            entityManager.flush();
            return entity;
        }
        catch (Exception e){
            throw new Exception("Couldn't update entity.");
        }
    }

    @Transactional
    public T findById(Long id) throws Exception {
        try {
            return entityManager.find(type, id);
        }
        catch (Exception e){
            throw new Exception("Couldn't find entity with given id.");
        }
    }

    @Transactional
    public void delete(T entity) throws Exception {
        try {
            entityManager.remove(entity);
        }
        catch (Exception e){
            throw new Exception("Couldn't delete entity.");
        }
    }

    @Transactional
    public List<T> findAll() throws Exception {
        try {
            CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(type);
            cq.from(type);
            cq.distinct(true);
            TypedQuery<T> query = entityManager.createQuery(cq);
            return query.getResultList();
        }
        catch (Exception e){
            throw new Exception("Couldn't find all entities.");
        }
    }

    @Transactional
    public void deleteAll() throws Exception {
        try {
            List<T> entityList = findAll();
            for (T entity : entityList) {
                delete(entity);
            }
        }
        catch (Exception e){
            throw new Exception("Couldn't delete all entities.");
        }
    }
}
