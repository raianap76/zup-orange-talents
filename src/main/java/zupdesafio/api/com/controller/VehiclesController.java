package zupdesafio.api.com.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import zupdesafio.api.com.controller.DTO.VehicleDTO;
import zupdesafio.api.com.controller.Form.VehicleForm;
import zupdesafio.api.com.model.Vehicle;
import zupdesafio.api.com.repository.UsersRepository;
import zupdesafio.api.com.repository.VehiclesRepository;
import zupdesafio.api.com.service.VehicleService;

@RestController
public class VehiclesController {

    @Autowired
    private VehiclesRepository repository;
    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/vehicles")
    public List<VehicleDTO> listVehicles() throws Exception {
        VehicleDTO dto = new VehicleDTO();
        List<Vehicle> vehicles = repository.findAll();
        return dto.convert(vehicles);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleForm form, UriComponentsBuilder uriBuilder)
            throws Exception {
        Vehicle vehicle = form.convert(form, userRepository);
        VehicleService service = new VehicleService();
        vehicle.value = service.getVehicleValue(vehicle);
        this.repository.save(vehicle);
        URI uri = uriBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.id).toUri();
        return ResponseEntity.created(uri).body(new VehicleDTO(vehicle));

    }
}
