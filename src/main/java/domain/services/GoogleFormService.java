package domain.services;

import domain.daos.GoogleFormDAO;
import domain.models.GoogleForm;

import java.util.List;

// TODO: add method with criteria

public class GoogleFormService {

    private static GoogleFormDAO googleFormDAO;

    public GoogleFormService() {
        googleFormDAO = new GoogleFormDAO();
    }

    public void persist(GoogleForm entity) {
        googleFormDAO.openCurrentSessionWithTransaction();
        googleFormDAO.persist(entity);
        googleFormDAO.closeCurrentSessionWithTransaction();
    }

    public void update(GoogleForm entity) {
        googleFormDAO.openCurrentSessionWithTransaction();
        googleFormDAO.update(entity);
        googleFormDAO.closeCurrentSessionWithTransaction();
    }

    public GoogleForm findById(Long id) {
        googleFormDAO.openCurrentSession();
        GoogleForm googleForm = googleFormDAO.findById(id);
        googleFormDAO.closeCurrentSession();
        return googleForm;
    }

    public void delete(Long id) {
        googleFormDAO.openCurrentSessionWithTransaction();
        GoogleForm googleForm = googleFormDAO.findById(id);
        googleFormDAO.delete(googleForm);
        googleFormDAO.closeCurrentSessionWithTransaction();
    }

    public List<GoogleForm> findAll() {
        googleFormDAO.openCurrentSession();
        List<GoogleForm> books = googleFormDAO.findAll();
        googleFormDAO.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        googleFormDAO.openCurrentSessionWithTransaction();
        googleFormDAO.deleteAll();
        googleFormDAO.closeCurrentSessionWithTransaction();
    }

    public GoogleFormDAO googleFormDAO() {
        return googleFormDAO;
    }
}