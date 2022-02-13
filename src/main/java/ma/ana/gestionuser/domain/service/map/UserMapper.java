package ma.ana.gestionuser.domain.service.map;

import ma.ana.gestionuser.model.model.User;
import ma.ana.gestionuser.domain.data.UserData;

public class UserMapper {

    // convert Entity into DTO
    public static UserData mapToDTO(User user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setFullName(user.getFullName());
        userData.setEmail(user.getEmail());
        return userData;
    }

    // convert DTO to entity
    public static User mapToEntity(UserData userData){
        User user = new User();
        user.setFullName(userData.getFullName());
        user.setEmail(userData.getEmail());
        return user;
    }
}
