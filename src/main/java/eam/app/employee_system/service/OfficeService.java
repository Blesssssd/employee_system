package eam.app.employee_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eam.app.employee_system.models.Office;

@Service
public interface OfficeService {

    public List<Office> getAllOffices();

    public Office saveOffice(Office office);

    public Office getOfficeById(Long id);

    public Office updateOffice(Office office);

    public void deleteOffice(Long id);
}
