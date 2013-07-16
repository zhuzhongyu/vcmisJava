package coboo.cpsDatabases.vcmisServiceEvaluation;

public class YearService {

	public YearService() {
		// TODO Auto-generated constructor stub
	}
String year;
GxyService[] servicesOfYear=new GxyService[5];
public GxyService[] getServicesOfYear() {
	return servicesOfYear;
}
public void setServicesOfYear(GxyService[] servicesOfYear) {
	this.servicesOfYear = servicesOfYear;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
}
