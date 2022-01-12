package domain.services;

import domain.daos.GoogleFormDAO;
import domain.models.GoogleForm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

// TODO: add method with criteria

@ApplicationScoped
public class GoogleFormService {
    @Inject
    GoogleFormDAO googleFormDAO;

    @Transactional
    public GoogleForm create(GoogleForm entity) throws Exception {
        return googleFormDAO.create(entity);
    }

    @Transactional
    public GoogleForm update(GoogleForm entity) throws Exception {
         return googleFormDAO.update(entity);
    }

    @Transactional
    public GoogleForm findById(Long id) throws Exception {
        return googleFormDAO.findById(id);
    }

    @Transactional
    public void delete(Long id) throws Exception {
        GoogleForm googleForm = googleFormDAO.findById(id);
        googleFormDAO.delete(googleForm);
    }

    @Transactional
    public List<GoogleForm> findAll() throws Exception {
        return googleFormDAO.findAll();
    }

    @Transactional
    public void deleteAll() throws Exception {
        googleFormDAO.deleteAll();
    }
}