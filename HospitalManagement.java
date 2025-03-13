import java.util.ArrayList;
import java.util.List;

// Doctor class
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.consultDoctor(this);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
        addPatient(patient);
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}



// Patient class
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consultDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public void showDoctors() {
        System.out.println(name + " has consulted with:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void showDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }
    }

    public void showPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

// Demonstration class
public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Bansal Hospital");

        // Creating doctors
        Doctor umair = new Doctor("Umair Ali");
        Doctor shailie = new Doctor("Shailie Sharma");

        // Creating patients
        Patient aaryan = new Patient("Aaryan");
        Patient hitesh = new Patient("Hitesh");

        // Adding doctors and patients to the hospital
        hospital.addDoctor(umair);
        hospital.addDoctor(shailie);
        hospital.addPatient(aaryan);
        hospital.addPatient(hitesh);

        // Consultations
        umair.consult(aaryan);
        umair.consult(hitesh);
        shailie.consult(aaryan);

        // Displaying information
        hospital.showDoctors();
        hospital.showPatients();
        umair.showPatients();
        shailie.showPatients();
        aaryan.showDoctors();
        hitesh.showDoctors();
    }
}

// Output:
// Dr. Umair Ali is consulting Aaryan
// Dr. Umair Ali is consulting Hitesh
// Dr. Shailie Sharma is consulting Aaryan
// Doctors at Bansal Hospital:
// - Dr. Umair Ali
// - Dr. Shailie Sharma
// Patients at Bansal Hospital:
// - Aaryan
// - Hitesh
// Dr. Umair Ali has consulted:
// - Aaryan
// - Hitesh
// Dr. Shailie Sharma has consulted:
// - Aaryan
// Aaryan has consulted with:
// - Dr. Umair Ali
// - Dr. Shailie Sharma
// Hitesh has consulted with:
// - Dr. Umair Ali
