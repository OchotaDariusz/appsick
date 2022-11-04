package org.eu.appsick.visit;

import org.eu.appsick.user.doctor.Doctor;
import org.eu.appsick.user.doctor.DoctorDao;
import org.eu.appsick.user.patient.Patient;
import org.eu.appsick.user.patient.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VisitService {
    private final VisitDao visitDao;
    private final PatientDao patientDao;
    private final DoctorDao doctorDao;

    @Autowired
    public VisitService(VisitDao visitDao, PatientDao patientDao, DoctorDao doctorDao) {
        this.visitDao = visitDao;
        this.patientDao = patientDao;
        this.doctorDao = doctorDao;
    }

    public Visit getById(String id) {
        UUID uuid = UUID.fromString(id);
        return visitDao.getVisit(uuid);
    }

    public List<Visit> getPatientVisits(String patientId) {
        UUID uuid = UUID.fromString(patientId);
        Patient patient = patientDao.getById(uuid);
        return visitDao.getVisitList(patient);
    }

    public List<Visit> getDoctorVisits(String doctorId) {
        UUID uuid = UUID.fromString(doctorId);
        Doctor doctor = doctorDao.getById(uuid);
        return visitDao.getVisitList(doctor);
    }

    public boolean addVisit(Visit visit) {
        return visitDao.addVisit(visit);
    }

    public boolean editVisit(UUID visitID, Visit editedVisit) {
        return visitDao.editVisit(
                visitID,
                editedVisit.getPatientId(),
                editedVisit.getDoctorId(),
                editedVisit.getClinicId(),
                editedVisit.getDate(),
                editedVisit.isOnline(),
                editedVisit.getReason(),
                editedVisit.getStatus()
        );
    }

    public boolean deleteVisit(UUID visitId) {
        return visitDao.deleteVisit(visitDao.getVisit(visitId));
    }

}
