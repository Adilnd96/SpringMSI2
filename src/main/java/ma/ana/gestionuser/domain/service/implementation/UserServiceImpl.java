package ma.ana.gestionuser.domain.service.implementation;

import ma.ana.gestionuser.domain.service.map.UserMapper;
import ma.ana.gestionuser.model.model.User;
import ma.ana.gestionuser.model.repository.IUser;
import ma.ana.gestionuser.domain.data.UserData;
import ma.ana.gestionuser.domain.data.UserResponse;
import ma.ana.gestionuser.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private IUser IUser;

    public UserServiceImpl(IUser IUser) {
          this.IUser = IUser;
    }

    @Override
    public UserData createUser(UserData userData) {
        // convert DTO to entity
        User user = UserMapper.mapToEntity(userData);
        User newUser = IUser.save(user);

        // convert entity to DTO
        UserData userResponse = UserMapper.mapToDTO(newUser);
        return userResponse;
    }

    @Override
    public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = IUser.findAll(pageable);

        // get content for page object
        List<User> listOfUsers = users.getContent();

        List<UserData> content= listOfUsers.stream().map(user -> UserMapper.mapToDTO(user)).collect(Collectors.toList());

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNo(users.getNumber());
        userResponse.setPageSize(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());

        return userResponse;
    }


}