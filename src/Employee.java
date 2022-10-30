public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeePassword;

    public Employee(String employeeId, String employeeName, String employeePassword) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePassword = employeePassword;
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
