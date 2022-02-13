package ma.ana.gestionuser.domain.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import ma.ana.gestionuser.UnitTest;
import ma.ana.gestionuser.model.model.User;
import ma.ana.gestionuser.model.repository.IUser;
import ma.ana.gestionuser.domain.data.UserData;
import ma.ana.gestionuser.domain.data.UserResponse;
import ma.ana.gestionuser.domain.service.implementation.UserServiceImpl;
import ma.ana.gestionuser.domain.service.map.UserMapper;

class UserServiceTest extends UnitTest {

    @Mock
    private IUser userRepo;
    
    private UserService userService;
    
    private UserData userData;
    private User user;
    
    @Override
	protected void setup() {
		userService = new UserServiceImpl(userRepo);
		this.userData = random.nextObject(UserData.class);
		this.user = UserMapper.mapToEntity(userData);
	}
    
    @Test
    public void testCreateUser()  {
    	when(userRepo.save(user)).thenReturn(user);  
    	UserData secondUserData = userService.createUser(userData);
        assertNotNull(userRepo);
        assertNotNull(secondUserData);
        Assertions.assertThat(userData.getFullName()).isEqualTo(secondUserData.getFullName());
        
    }

    @Test
    public void testGetAll()  {
    	List<User> users = new ArrayList<User>();
    	users.add(user);
    	PageImpl<User> pageUsers = new PageImpl<User>(users);
    	
        when(userRepo.findAll(Mockito.any(Pageable.class))).thenReturn(pageUsers);  
        UserResponse response = userService.getAllUsers(0, 10, "id", "asc");
        assertNotNull(response);
        Assertions.assertThat(response.getContent().size()).isEqualTo(1);
        Assertions.assertThat(response.getContent().get(0).getFullName()).isEqualTo(userData.getFullName());
    }

	
}
