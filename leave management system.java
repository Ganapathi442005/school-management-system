import java.util.*;

class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    public Employee(int id, String name, String position, double salary){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if(salary>0){
        this.salary = salary;
        }else{
            System.out.println("Invalid salary! Salary must be positive number");
        }
    }
    
    public String toString(){
        return"ID:" +id+", Name: " +name+", salary: $"+salary+", Position: " + position;   
        }
}

class LeaveManager {
    //List to store leave requests
    private List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();


   //method to submit a lave request
    public void submitLeaveRequest(LeaveRequest request){
        leaveRequests.add(request);
        System.out.println("Leave request submitted for: "+request.getEmployee().getName());
    }
    //method to show all leave requests
    public void showAllLeaveRequests(){
        System.out.println("\nAll leave Requests:");
        for(LeaveRequest request : leaveRequests ){
            System.out.println(request);
        }
    }
    //method to show leave request
    public void showLeaveByStatus(String status)
    {
        for(LeaveRequest request : leaveRequests)
        {
            if(request.getStatus().equalsIgnoreCase(status))
            {
                System.out.println(request);
            }
        }
    }
    //method to approve leave by employee
    public void approveLeaveByEmployee(int employeeId)
    {
        for(LeaveRequest request: leaveRequests)
        {
            if(request.getEmployee().getId()==employeeId && request.getStatus().equalsIgnoreCase("Requested"))
            {
                request.setStatus("Approved");
                System.out.println("Leave is approved for : "+request.getEmployee().getName());
            }
            else{
                System.out.println("There is no pending leaves for : "+request.getEmployee().getName());
            }
        }
        
    }
    public void rejectLeaveByEmployee(int employeeId)
    {
        for(LeaveRequest request: leaveRequests)
        {
            if(request.getEmployee().getId()==employeeId && request.getStatus().equalsIgnoreCase("Pending"))
            {
                request.setStatus("Approved");
                System.out.println("Leave is approved for : "+request.getEmployee().getName());
            }
        }
    }
}
class LeaveRequest {
    private Employee employee;
    private String startDate;
    private String endDate;
    private String reason;
    private String status;
    public LeaveRequest(Employee employee,String startDate,String endDate,String reason,String status){
        this.employee=employee;
        this.startDate=startDate;
        this.endDate=endDate;
        this.reason=reason;
        this.status=status;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Employee: " + employee.getName() + ", Leave Dates: " + startDate + " to " + endDate + ", Reason: " + reason + ", Status: " + status;
    }
}

public class LeaveManagementSystem{
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee(1, "John Doe", "Software Engineer", 75000);
        Employee emp2 = new Employee(2, "Jane Smith", "HR Manager", 85000);

        // Leave Requests
        LeaveRequest leave1 = new LeaveRequest(emp1, "2024-12-31", "2025-01-02", "Vacation", "Pending");
        LeaveRequest leave2 = new LeaveRequest(emp2, "2024-12-28", "2024-12-30", "Family Emergency", "Pending");

        // Leave Management
        LeaveManager leaveManager = new LeaveManager();
        leaveManager.submitLeaveRequest(leave1);
        leaveManager.submitLeaveRequest(leave2);

        // Show pending leave requests
        System.out.println("\nPending Leave Requests:");
        leaveManager.showLeaveRequestsByStatus("Pending");

        // Approve or reject leaves
        leaveManager.approveLeave(1); // Approving the first leave request
        leaveManager.rejectLeave(2); // Rejecting the second leave request

        // Show all leave requests with updated statuses
        System.out.println("\nUpdated Leave Requests:");
        leaveManager.showAllLeaveRequests();
    }
}
