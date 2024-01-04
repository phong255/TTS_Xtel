package Services;

import Models.Student;
import com.github.benmanes.caffeine.cache.Cache;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Cache.CacheDemo;

public class StudentService{
    private static final Logger log = Logger.getLogger(StudentService.class);
    Cache<String,List<Student>> cache = CacheDemo.getInstance();
    Service service = Service.getInstance();
    public List<Student> getAllStudent() { //Ham lay tat ca student trong database
        List<Student> students;
        students = cache.getIfPresent("all-student");
        if(students == null){   //Kiem tra neu trong cache khong co du lieu thi put du lieu vao cache
            log.info("Du lieu chua duoc luu vao cache !");
            try{
                ResultSet rs = service.getAll("student");
                students = new ArrayList<>();
                while(rs.next()){
                    Student student = new Student(rs.getString("sname"),rs.getString("sage"),rs.getString("saddress"));
                    students.add(student);
                }
                service.close();
                cache.put("all-student",students);  //put du lieu vao cache
                log.info("Ghi vao cache.");
            }
            catch (SQLException e){
                log.error("Loi cau truy van SQL" + e);
            }
        }
        else {
            log.info("Du lieu lay tu cache.");
        }
        return students;    //Neu trong cache co du lieu roi thif return luon
    }
}
