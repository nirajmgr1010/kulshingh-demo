import java.util.ArrayList;
import java.util.Dictionary;

class PatientNotFoundException extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Patient Doesn't Exist sorry !!";
    }
}
class DoctorNotFoundException extends Exception{
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Doctor Doesn't Exist sorry!! ";
    }
}
class Patient{
    private int id;
    private String name;
    private int age;
    private String disease;
    private Doctor assigneDoctor;
    private boolean isAdmitted;

    Patient(int id, String name, int age, String disease){
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }


    public boolean isAdmitted(){
        return isAdmitted;
    }
    public Doctor assignedDoctor(){
        return assigneDoctor;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return id+") "+name+" age: "+age+" Disease: "+disease+" isAdmitted: "+isAdmitted;
    }


}
class Doctor{
    private int DId;
    private String name;
    private String specialization;

    Doctor(int DId, String name, String specialization){
          this.DId = DId;
          this.name = name;
          this.specialization = specialization;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return DId+") "+name+" specialization: "+specialization;
    }
}
class Hospital{

    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();

    public void toAddDoctor(int id, String name, String specialization){
        doctors.add(new Doctor(id,name,specialization));
    }

    public void toAddPatients(int id, String name, int age, String disease){
        patients.add(new Patient(id, name, age, disease));
    }
    

    //Add Doctor
    //Admit patient -> PatientNotFoundException
    //Assign Doctor -> DoctorNotFoundException
    //Discharge Patients
    //Display all patients

}
public class HospitalManagementSystem {
    public static void main(String[] args) {
        
    }
}
