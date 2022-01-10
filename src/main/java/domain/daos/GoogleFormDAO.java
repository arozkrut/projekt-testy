package domain.daos;

import domain.models.GoogleForm;

public class GoogleFormDAO extends BaseDAO<GoogleForm> {
    public GoogleFormDAO(){
        super(GoogleForm.class, "GoogleForm");
    }
}