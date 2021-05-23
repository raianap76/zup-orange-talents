package zupdesafio.api.com.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import zupdesafio.api.com.model.User;
import zupdesafio.api.com.model.Vehicle;

public class VehiclesFromUserDTO {
    public String ownerName;
    public List<VehicleDTO> vehicles;

    public VehiclesFromUserDTO(List<Vehicle> vehicles, User user) throws Exception {
        this.vehicles = new ArrayList<VehicleDTO>();
        for (int i = 0; i < vehicles.size(); i++) {
            VehicleDTO dto = new VehicleDTO();
            this.vehicles = dto.convert(vehicles);
        }
        this.ownerName = user.name;
    }
}
