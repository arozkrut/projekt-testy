package domain.daos;

import domain.models.GoogleForm;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GoogleFormDAO extends BaseDAO<GoogleForm> {
    public GoogleFormDAO(){
        super(GoogleForm.class);
    }
}