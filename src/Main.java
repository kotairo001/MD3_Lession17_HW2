import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/students.txt";
        List<Student>students=new ArrayList<>();
        students.add(new Student(1,"John","USA"));
        students.add(new Student(2,"Jack","Canada"));
        students.add(new Student(3,"Jane","Russia"));
        students.add(new Student(4,"Rose","UK"));
        writeToFile(filePath,students);
        List<Student>dataReadFromFile = readFile(filePath);
        for (int i = 0; i < dataReadFromFile.size(); i++) {
            System.out.println(dataReadFromFile.get(i));
        }

    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
