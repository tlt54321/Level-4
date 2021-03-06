package Hospital;

import java.util.ArrayList;

public class Doctor{
	private boolean performsSurgery;
	private boolean makesHouseCalls;
	private boolean isEvil;
	private Hospital hospital;
	ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	public void assignPatient(Patient p) throws DoctorFullException{
		if(patients.size() > 3){
			throw new DoctorFullException("Doctor is full of patients");
		}else{
			patients.add(p);
		}
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
		isEvil = false;
	}
	public Doctor(String number){
		performsSurgery = false;
		makesHouseCalls = false;
		if(number.equals("666")){
			isEvil = true;
		}
		else{
			isEvil = false;
		}
	}
	public Doctor(String number, Hospital hospital){
		performsSurgery = false;
		makesHouseCalls = false;
		if(number.equals("666")){
			isEvil = true;
		}
		else{
			isEvil = false;
		}
		this.hospital = hospital;
	}
	
	public Hospital getHospital(){
		return hospital;
	}
	
	public boolean isEvil(){
		return isEvil;
	}
	
	public void joinTheDarkSide(){
		isEvil = true;
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
		if(isEvil){
			for(Patient p: patients){
				p.kill();
			}
		}
		else{
			for(Patient p: patients){
				p.checkPulse();
			}
		}
	}
}
