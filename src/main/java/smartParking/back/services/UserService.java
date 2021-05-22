package smartParking.back.services;

import smartParking.back.models.User;

public interface UserService extends CrudService<User> {
    User getByName(String name);
}
