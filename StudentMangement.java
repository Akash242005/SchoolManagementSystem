import java.util.ArrayList;

class Person {
        private int id;
        private String name;
        private int age;
        private String address;
        public static String clgname;

        public Person(int id,String name,int age,String address)
        {
            this.id = id;
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public Person()
        {
            this.id = 0;
            this.name = "";
            this.age = 18;
            this.address = "";
        }
        public int getId(){
            return id;
        }
        public void setId(int id)
        {
            if(id>0)
            {
                this.id = id;
            }
            else{
                System.out.println("Enter the Valid id");
            }
        }
        public String getName(){
            return name;
        }
        public void setName(String name)
        {
            if(!name.isEmpty())
            {
                this.name = name;
            }
            else{
                System.out.println("Enter the Valid Name");
            }
        }
        public int getAge(){
            return age;
        }
        public void setAge(int age)
        {
            if(age>0)
            {
                this.age = age;
            }
            else{
                System.out.println("Enter the Valid age");
            }
        }
        public String getAddress(){
            return address;
        }
        public void setAddress(String address)
        {
            if(!address.isEmpty())
            {
                this.address = address;
            }
            else{
                System.out.println("Enter the Valid addresss");
            }
        }
        public void display(){
            System.out.println("The name :"+name);
            System.out.println("The Id :"+id);
            System.out.println("The Age :"+age);
            System.out.println("The Address :"+address);
        }
    }
//=================================================STUDENT===========================================
class Student extends Person{
    private String grade;
    private String StudentId;
    public Student(int id,String name,int age,String address,String grade,String StudentId)
    {
        super(id, name, age, address);
        this.grade = grade;
        this.StudentId = StudentId;
    }
    public Student(){
        this.grade = "";
        this.StudentId = "";
    }
    public String getGrade(){
        return grade;
    }
    public void setStudentId(String StudentId)
    {
        if(!StudentId.isEmpty())
        {
            this.StudentId = StudentId;
        }
        else{
            System.out.println("Enter the Valid StudentId");
        }
    }
    public String getStudentId(){
        return StudentId;
    }
    public void setGrade(String grade)
    {
        if(!grade.isEmpty())
        {
            this.grade = grade;
        }
        else{
            System.out.println("Enter the Valid grade");
        }
    }
    @Override
    public void display(){
        super.display();
        System.out.println("The Grade :"+grade);
        System.out.println("The StudentId :"+StudentId);
    }
}
//=================================================TEACHER=============================================
class Teacher extends Person{
    private String subject;
    private double salery;
    public Teacher(int id,String name,int age,String address,String subject,double salery)
    {
        super(id, name, age, address);
        this.subject = subject;
        this.salery = salery;
    }
    public String getSubject(){
        return subject;
    }
    public void setStudentId(String subject)
    {
        this.subject = subject;
    }
    public double getSalery(){
        return salery;
    }
    public void setSalery(double salery)
    {
        this.salery = salery;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("The Subject :"+subject);
        System.out.println("The Salary :"+salery);
    }
}
//=======================================================MAIN==========================================
class AdminStaff extends Person{
    private String department;
    private String role;
    public AdminStaff(int id,String name,int age,String address,String department,String role)
    {
        super(id, name, age, address);
        this.department = department;
        this.role = role;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("The Department :"+department);
        System.out.println("The Role :"+role);
    }
}
public class StudentMangement{
    public static void main(String[] args)
    {
        ArrayList<Person> person = new ArrayList<>();
        ///=======================STUDENT Details========================================
        //Person s1 = new Student(7, "AKASH", 19, "278/M2,Chavadi Street ,Namakkal", "B", "927622BEC007");
        //Person s2 = new Student(61, "GOWTHAM", 20, "27/S3,Gnadi Nagar,Velur", "B+", "927622BEC061");
        person.add(new Student(7, "AKASH", 19, "278/M2,Chavadi Street ,Namakkal", "B", "927622BEC007"));
        person.add(new Student(61, "GOWTHAM", 20, "27/S3,Gnadi Nagar,Velur", "O", "927622BEC061"));
        ///==========================TEACHER Details=======================================
        //Person t1 = new Teacher(52,"Ganapathi",28,"12/67, Ram Nagar,Dindigul","Mathsamatics",102746.28);
        //Person t2 = new Teacher(19,"Aswin",27,"12/67, Ram Nagar,","Mathsamatics",102746.28);
        person.add(new Teacher(52,"Ganapathi",28,"12/67, Ram Nagar,Dindigul","Mathsamatics",102746.28));
        person.add(new Teacher(19,"Aswin",27,"12/67, Ram Nagar,","Mathsamatics",102746.28));
        ///==========================AdminStaff=============================================
        //Person a1 = new AdminStaff(174, "Sedhu", 27, "237/M3,Gandhi Nagar,Velur", "ECE", "HR");
        //Person a2 = new AdminStaff(17, "Balakumar", 23, "2.V4,Anbu Nagar-1,Dindigual", "ECE", "Manager");
        person.add(new AdminStaff(174, "Sedhu", 27, "237/M3,Gandhi Nagar,Velur", "ECE", "HR"));
        person.add(new AdminStaff(17, "Balakumar", 23, "2.V4,Anbu Nagar-1,Dindigual", "ECE", "Manager"));
        System.out.println("Student Mangement System:");
        for(Person person1:person)
        {
            System.out.println("-----------------------------------------------------------------------");
            person1.display() ;
        }
    }
}
