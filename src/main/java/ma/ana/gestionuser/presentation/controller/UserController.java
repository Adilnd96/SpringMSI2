package ma.ana.gestionuser.presentation.controller;

import ma.ana.gestionuser.domain.data.UserData;
import ma.ana.gestionuser.domain.data.UserResponse;
import ma.ana.gestionuser.domain.service.UserService;
import ma.ana.gestionuser.presentation.utils.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create blog user rest api
    @PostMapping
    public ResponseEntity<UserData> createUser(@RequestBody UserData userData){
        return new ResponseEntity<>(userService.createUser(userData), HttpStatus.CREATED);
    }

    // get all users rest api
    @GetMapping
    public UserResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = Constantes.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constantes.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constantes.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constantes.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

}