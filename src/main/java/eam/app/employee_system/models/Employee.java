package eam.app.employee_system.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "nif", nullable = false, length = 50)
    private String nif;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname1", nullable = false, length = 50)
    private String surname1;

    @Column(name = "surname2", nullable = false, length = 50)
    private String surname2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_office")
    private Office office;
}
