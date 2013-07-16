/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.util.Date;

/**
 * @author user
 *
 */
public class Service {
	

	private Long id;
	Date	serviceTime;
	Doctor	doctor;

	/**
	 * 
	 */
	public Service() {
		super();
	}

	

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

}