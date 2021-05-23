package zupdesafio.api.com.controller;
import zupdesafio.api.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


import zupdesafio.api.com.controller.DTO.UserDTO;
import zupdesafio.api.com.controller.Form.UserForm;
import zupdesafio.api.com.model.User;
import zupdesafio.api.com.repository.UsersRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zupdesafio.api.com.controller.DTO.UserDTO;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository repository;

    @GetMapping("/users")
    public List<UserDTO> listUsers() {
        List<User> users = repository.findAll();
        UserDTO dto = new UserDTO();
        return dto.convert(users);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserForm form, UriComponentsBuilder uriBuilder) {
        User user = form.convert(form);
        this.repository.save(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.id).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

}
