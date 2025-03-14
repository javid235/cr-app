import java.util.ArrayList;
import java.util.List;

public class CourseData {
    private List<Course> courses;

    public CourseData() {
        courses = new ArrayList<>();
        initializeCourses();
    }

    private void initializeCourses() {
        courses.add(new Course(
            "CS101", 
            "Introduction to Programming", 
            "Learn the fundamentals of programming using Java. This course covers basic syntax, control structures, object-oriented programming concepts, and practical problem-solving techniques.", 
            "Dr. Smith", 
            3, 
            499.99, 
            30
        ));
        
        courses.add(new Course(
            "CS201", 
            "Data Structures and Algorithms", 
            "Master essential data structures and algorithms. Topics include arrays, linked lists, trees, graphs, sorting algorithms, and algorithm analysis for optimal problem-solving.", 
            "Dr. Johnson", 
            4, 
            599.99, 
            25
        ));
        
        courses.add(new Course(
            "CS301", 
            "Database Management Systems", 
            "Comprehensive study of database design, implementation, and management. Learn SQL, database normalization, transaction management, and modern database technologies.", 
            "Dr. Davis", 
            3, 
            549.99, 
            20
        ));
        
        courses.add(new Course(
            "CS401", 
            "Full Stack Web Development", 
            "Build modern web applications from front to back. Cover HTML5, CSS3, JavaScript, React, Node.js, and deployment strategies for creating responsive web applications.", 
            "Prof. Wilson", 
            4, 
            649.99, 
            25
        ));
        
        courses.add(new Course(
            "CS501", 
            "Artificial Intelligence and Machine Learning", 
            "Explore AI concepts, machine learning algorithms, neural networks, and practical applications. Implement AI solutions using popular frameworks and real-world datasets.", 
            "Dr. Brown", 
            4, 
            699.99, 
            20
        ));
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public Course getCourseById(String courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}