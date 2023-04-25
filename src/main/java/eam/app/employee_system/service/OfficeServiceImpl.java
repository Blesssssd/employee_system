package eam.app.employee_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eam.app.employee_system.models.Office;
import eam.app.employee_system.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    OfficeRepository repository;

    @Override
    public List<Office> getAllOffices() {
        return repository.findAll();
    }

    @Override
    public Office saveOffice(Office office) {
        return repository.save(office);
    }

    @Override
    public Office getOfficeById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Office updateOffice(Office office) {
        return repository.save(office);
    }

    @Override
    public void deleteOffice(Long id) {
        repository.deleteById(id);
    }
   


}
