package ma.ana.gestionuser.domain.service;

import ma.ana.gestionuser.domain.data.UserData;
import ma.ana.gestionuser.domain.data.UserResponse;

public interface UserService {

    UserData createUser(UserData userData);

    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
