package zupdesafio.api.com.controller;

import java.util.List;

import zupdesafio.api.com.controller.DTO.UserDTO;
import zupdesafio.api.com.controller.DTO.VehicleDTO;
import zupdesafio.api.com.controller.DTO.VehiclesFromUserDTO;
import zupdesafio.api.com.model.User;
import zupdesafio.api.com.model.Vehicle;
import zupdesafio.api.com.repository.UsersRepository;
import zupdesafio.api.com.repository.VehiclesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesFromUserController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VehiclesRepository vehiclesRepository;

    @GetMapping("/vehiclesUser/{cpf}")
    public VehiclesFromUserDTO listVehiclesUser(@PathVariable int cpf) throws Exception {
        UserDTO dto = new UserDTO();
        User user = usersRepository.findByCPF(cpf);
        List<Vehicle> vehicles = vehiclesRepository.findByOwner_CPF(cpf);
        VehiclesFromUserDTO result = new VehiclesFromUserDTO(vehicles, user);
        return result;
    }
}
