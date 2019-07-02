
public class employee {
    private int employee_id;
    private String employee_firstname;
    private String employee_lastname;
    private String birth_date;
    private String hire_date;
    private int department_id;

    //constructor
    public employee(int employee_id,String employee_firstname,String employee_lastname,String birth_date,String hire_date,int department_id) {
        this.employee_id=employee_id;
        this.employee_firstname=employee_firstname;
        this.employee_lastname=employee_lastname;
        this.birth_date=birth_date;
        this.hire_date=hire_date;
        this.department_id=department_id;
    }

    //getters and setters
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }


}
