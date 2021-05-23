package zupdesafio.api.com.controller.Form;

import zupdesafio.api.com.model.User;
import zupdesafio.api.com.model.Vehicle;
import zupdesafio.api.com.repository.UsersRepository;

public class VehicleForm {
    public String brand;
    public String model;
    public String year;
    public int ownerCPF;

    public Vehicle convert(VehicleForm form, UsersRepository repository) {
        User user = repository.findByCPF(form.ownerCPF);
        return new Vehicle(form.brand, form.model, form.year, "0", user);
    }
}
