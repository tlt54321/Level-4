package Hospital;

import java.util.ArrayList;
// Copyright Wintriss Technical Schools 2013
import java.util.List;

import junit.framework.TestCase;

/* requirements:
 * 1. hospital has doctors and patients
 * 2. doctors can be GeneralPractictioner or Surgeon
 * 3. patients can be assigned to doctors
 * 4. doctors can have no more than 3 patients
 */

public class HospitalTest extends TestCase {

	Hospital testHospital = new Hospital();

	public void testAddDoctor() {
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new Surgeon());
		assertEquals(3, testHospital.getDoctors().size());
	}

	public void testAddPatient() throws Exception {
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		assertEquals(3, testHospital.getPatients().size());
	}

	/* Fix asserts one at a time */
	public void testDoctorsHaveSpecialties() throws Exception {
		Doctor testDoctor = new Doctor();
		assertEquals(false, testDoctor.performsSurgery());

		Doctor testSurgeon = new Surgeon();
		assertEquals(true, testSurgeon.performsSurgery());

		GeneralPractitioner testGP = new GeneralPractitioner();
		assertEquals(true, testGP.makesHouseCalls());
		assertEquals(false, testSurgeon.makesHouseCalls());
		assertEquals(false, testDoctor.makesHouseCalls());
	}

	/* A doctor has a list of patients */
	public void testAssignDoctor() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		testDoctor.assignPatient(new Patient());
		assertEquals(1, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(2, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(3, testDoctor.getPatients().size());
	}

	/* When you check a patient's pulse, they feel cared for */
	public void testCheckPulse() throws Exception {
		Patient testPatient = new Patient();
		assertEquals(false, testPatient.feelsCaredFor());
		testPatient.checkPulse();
		assertEquals(true, testPatient.feelsCaredFor());
	}

	/* Doctors work on their Patients by checking their pulses. */
	public void testDoctorsWork() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		Patient max = new Patient();
		Patient macky = new Patient();
		testDoctor.assignPatient(max);
		testDoctor.assignPatient(macky);
		assertEquals(false, max.feelsCaredFor());
		assertEquals(false, macky.feelsCaredFor());
		testDoctor.doMedicine();
		assertEquals(true, max.feelsCaredFor());
		assertEquals(true, macky.feelsCaredFor());
	}

	/* test calling assignPatient when doctor is full throws exception */
	public void testDoctorsCanOnlyHandle3Patients() throws Exception {
		Doctor testDoctor = new Doctor();
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		try {
			testDoctor.assignPatient(new Patient());
			assertTrue(false);
		} catch (DoctorFullException dfe) {
			assertTrue(true);
		}
assertTrue(testDoctor.getPatients().size() == 3);
	}

	public void test8Patients() throws Exception {
		Hospital hospital = new Hospital();
		for(int i = 0; i < 3; i++){
			hospital.addDoctor(new Doctor());
		}
		//System.out.println(hospital.getDoctors().size());
		for(int i = 0; i < 8; i++){
			hospital.addPatient(new Patient());
		}
		//System.out.println(hospital.getPatients().size());
		// hospital assigns patients to doctors
		testHospital.assignPatientsToDoctors();
		// hospital.getDoctors shows doctors have 3, 3, 2 patients
		List<Doctor> testDoctors = testHospital.getDoctors();
		assertEquals(3, testDoctors.get(0).getPatients().size());
		assertEquals(3, testDoctors.get(1).getPatients().size());
		assertEquals(2, testDoctors.get(2).getPatients().size());
	}

}

class Hospital{
	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public void addDoctor(Doctor d){
		doctors.add(d);
	}
	public void addPatient(Patient p){
		patients.add(p);
	}
	
	public void assignPatientsToDoctors() throws DoctorFullException{
		Doctor doctor1 = doctors.get(0);
		Doctor doctor2 = doctors.get(1);
		Doctor doctor3 = doctors.get(2);
		
		doctor1.assignPatient(patients.get(0));
		doctor1.assignPatient(patients.get(1));
		doctor1.assignPatient(patients.get(2));
		
		doctor2.assignPatient(patients.get(3));
		doctor2.assignPatient(patients.get(4));
		doctor2.assignPatient(patients.get(5));
		
		doctor3.assignPatient(patients.get(6));
		doctor3.assignPatient(patients.get(7));
	}
}

class Patient{
	boolean feelsCaredFor;
	
	public Patient(){
		feelsCaredFor = false;
	}
	
	public void checkPulse(){
		feelsCaredFor = true;
	}

	public boolean feelsCaredFor() {
		return feelsCaredFor;
	}

	public void setFeelsCaredFor(boolean feelsCaredFor) {
		this.feelsCaredFor = feelsCaredFor;
	}
}
class Doctor{
	boolean performsSurgery;
	boolean makesHouseCalls;
	ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	public void assignPatient(Patient p) throws DoctorFullException{
		if(patients.size() == 3){
			throw new DoctorFullException("Doctor is full of patients");
		}
		patients.add(p);
	}
	
	public boolean makesHouseCalls() {
		return makesHouseCalls;
	}

	public void setMakesHouseCalls(boolean makesHouseCalls) {
		this.makesHouseCalls = makesHouseCalls;
	}

	public Doctor(){
		performsSurgery = false;
		makesHouseCalls = false;
	}
	
	public Doctor(boolean performsSurgery, boolean makesHouseCalls){
		this.performsSurgery = performsSurgery;
		this.makesHouseCalls = makesHouseCalls;
	}

	public boolean performsSurgery() {
		return performsSurgery;
	}

	public void setPerformsSurgery(boolean performsSurgery) {
		this.performsSurgery = performsSurgery;
	}
	
	public void doMedicine(){
		for(Patient p: patients){
			p.checkPulse();
		}
	}
}

class DoctorFullException extends Exception{
	public DoctorFullException(String s){
		super(s);
	}
}

class GeneralPractitioner extends Doctor{
	public GeneralPractitioner(){
		super(false, true);
	}
}
class Surgeon extends Doctor{
	public Surgeon(){
		super(true, false);
	}
}