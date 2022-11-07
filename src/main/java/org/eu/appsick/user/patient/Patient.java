package org.eu.appsick.user.patient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.eu.appsick.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends User {

    private UUID patientId;
    private UUID medicalDataId;
    private String pesel;
    private boolean premium;

    public Patient(UUID userId, String firstName, String lastName, LocalDate birthDate, Sex sex, String telephoneNumber, String email, String password, UUID medicalDataId, String pesel, boolean premium) {
        super(userId, firstName, lastName, birthDate, sex, telephoneNumber, email, password);
        this.medicalDataId = medicalDataId;
        this.pesel = pesel;
        this.premium = premium;
    }
}
