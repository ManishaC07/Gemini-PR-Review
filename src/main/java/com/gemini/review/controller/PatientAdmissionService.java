import java.io.*;
import java.util.*;

public class PatientAdmissionService {

    private static final String FILE_NAME = "patients.txt";

    // Class to represent a Patient
    static class Patient {
        String name;
        int age;
        String gender;
        String admissionDate;
        String diagnosis;

        public Patient(String name, int age, String gender, String admissionDate, String diagnosis) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.admissionDate = admissionDate;
            this.diagnosis = diagnosis;
        }

        @Override
        public String toString() {
            return name + "," + age + "," + gender + "," + admissionDate + "," + diagnosis;
        }

        public static Patient fromString(String line) {
            String[] parts = line.split(",");
            if (parts.length != 5) return null;
            return new Patient(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
        }
    }

    // Method to write patient to file
    public void admitPatient(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(patient.toString());
            writer.newLine();
            System.out.println("Patient admitted successfully.");
        } catch (IOException e) {
            System.out.println("Error writing patient to file: " + e.getMessage());
        }
    }

    // Method to read all patients from file
    public List<Patient> readAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Patient patient = Patient.fromString(line);
                if (patient != null) {
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading patients: " + e.getMessage());
        }
        return patients;
    }

    // Optional: Clear all patients (use carefully)
    public void clearAllPatients() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");
            System.out.println("All patient records cleared.");
        } catch (IOException e) {
            System.out.println("Error clearing patient records: " + e.getMessage());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        PatientAdmissionIO io = new PatientAdmissionIO();

        // Admitting a sample patient
        Patient p1 = new Patient("John Doe", 30, "Male", "2025-07-16", "Fever");
        io.admitPatient(p1);

        // Reading all patients
        List<Patient> allPatients = io.readAllPatients();
        System.out.println("All Patients:");
        for (Patient p : allPatients) {
            System.out.println(p.name + " | Age: " + p.age + " | Gender: " + p.gender + " | Date: " + p.admissionDate + " | Diagnosis: " + p.diagnosis);
        }
    }
}
