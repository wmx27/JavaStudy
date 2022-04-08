package Chapter10;

public class CourseDemo {
    public static void main(String[] args) {
        Course Math=new Course("Math");
        Math.addStudents("wmx");
        Math.addStudents("HZK");
        Math.addStudents("DSL");
        Math.dropStudent("HZK");
        String[] students=Math.getStudents();
        for(int i=0;i<Math.getNumberOfStudents();i++)
            System.out.print(students[i]+" ");
    }
}


class Course{
    private int Maxsize =20;
    private String courseName;
    private String[] students=new String[Maxsize];
    private int numberOfStudents;
    public Course(String courseName) {
        this.courseName=courseName;
        numberOfStudents=0;
    }
    public String getCourseName()
    {
        return this.courseName;
    }
    public void addStudents(String Student)
    {
        if(numberOfStudents==Maxsize)
        {
            Maxsize*=2;
            String[] students2=new String[Maxsize];
            for(int i=0;i<numberOfStudents;i++)
                students2[i]=this.students[i];
            this.students=students2;
        }
        this.students[this.numberOfStudents]=Student;
        this.numberOfStudents++;
    }
    public void dropStudent(String student)
    {
        for(int i=0;i<this.numberOfStudents;i++)
        {
            if(this.students[i].equals(student)) {
                for (int j = i + i; j < this.numberOfStudents; j++)
                    this.students[j - 1] = this.students[j];
                this.numberOfStudents--;
                break;
            }
        }
    }

    public String[] getStudents() {
        String[] students1=new String[Maxsize];
        for(int i=0;i<numberOfStudents;i++)
            students1[i]=this.students[i];
        return students1;
    }
    public int getNumberOfStudents(){
        return this.numberOfStudents;
    }
    public void clear()
    {
        this.numberOfStudents=0;
    }
}