public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeePassword;
    private String employeeAddress;
    private String employeePhoneNumber;

    public Employee(String employeeId, String employeeName, String employeePassword,String employeeAddress,String employeePhoneNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePassword = employeePassword;
        this.employeeAddress = employeeAddress;
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}
