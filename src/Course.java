public class Course {
    private String courseId;
    private String title;
    private String description;
    private String instructor;
    private int credits;
    private double fee;
    private int capacity;
    private int enrolled;

    public Course(String courseId, String title, String description, String instructor, int credits, double fee, int capacity) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.credits = credits;
        this.fee = fee;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }

    public double getFee() {
        return fee;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public boolean hasAvailableSeats() {
        return enrolled < capacity;
    }

    public void incrementEnrolled() {
        if (hasAvailableSeats()) {
            enrolled++;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return courseId.hashCode();
    }
}