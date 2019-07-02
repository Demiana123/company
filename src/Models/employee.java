package Models;

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

    //getters
    public int getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public int getDepartment_id() {
        return department_id;
    }

}
