package tuhinmaji.demo1;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@GetMapping("/courses")
	public ArrayList<Course> getAllCources(){
		Course c=new Course(1,"Python","Jose");
		ArrayList<Course> courseList= new ArrayList<>();
		courseList.add(c);
		return courseList;
		
	}
}
