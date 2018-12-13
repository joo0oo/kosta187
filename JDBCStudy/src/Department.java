/**
 * O-R Mapping 클래스 (object- relation(=테이블) mapping)
 * Domain 클래스 (=업무 관련해서 추상화된 클래스)
 * @author 송주현
 *
 */
public class Department {
	private int departmentID;
	private String departmentName;
	private int managerID;
	private int locationID;
	
	public Department() {
		
	}
	
	public Department(int departmentID, String departmentName, int managerID, int locationID) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.managerID = managerID;
		this.locationID = locationID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", managerID="
				+ managerID + ", locationID=" + locationID + "]";
	}

	
}
