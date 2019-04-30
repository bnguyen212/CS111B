import java.util.Arrays;

public class Course {
  private Student[] roster, waitlist;
  private String title;
  private int studentCount, waitlistCount;
  private final static int DEFAULT_ROSTER_SIZE = 50;
  private final static int MAX_ROSTER_SIZE = 100;
  // Number of spots on the waitlist should be <= the number of spots available on the roster && capped at 25;
  private final static int MAX_WAITLIST_SIZE = 25;

  // Courses have no waitlist by default, unless explicitly initialized with a waitlist size
  public Course(String courseTitle) {
    this(courseTitle, DEFAULT_ROSTER_SIZE, 0);
  }

  public Course(String courseTitle, int rosterSize) {
    this(courseTitle, rosterSize, 0);
  }

  public Course(String courseTitle, int rosterSize, int waitlistSize) {
    if (rosterSize > MAX_ROSTER_SIZE) {
      rosterSize = MAX_ROSTER_SIZE;
    } else if (rosterSize <= 0) {
      rosterSize = DEFAULT_ROSTER_SIZE;
    }
    if (waitlistSize < 0) {
      waitlistSize = 0;
    } else if (waitlistSize > rosterSize) {
      waitlistSize = rosterSize;
    }
    if (waitlistSize > MAX_WAITLIST_SIZE) {
      waitlistSize = MAX_WAITLIST_SIZE;
    }
    title = courseTitle;
    roster = new Student[rosterSize];
    waitlist = new Student[waitlistSize];
    studentCount = 0;
    waitlistCount = 0;
  }

  public String getTitle() {
    return title;
  }

  public boolean setTitle(String newTitle) {
    if (newTitle != null && newTitle.length() > 0) {
      title = newTitle;
      return true;
    }
    return false;
  }

  // get number of students currently enrolled
  public int getStudentCount() {
    return studentCount;
  }

  // get max number of students allowed to enroll
  public int getRosterSize() {
    return roster.length;
  }

  public boolean setRosterSize(int newSize) {
    if (newSize > MAX_ROSTER_SIZE) {
      newSize = MAX_ROSTER_SIZE;
    }
    if (newSize != roster.length && newSize >= studentCount && newSize > 0) {
      roster = Arrays.copyOf(roster, newSize);
      while (studentCount < roster.length && waitlistCount > 0) {
        moveWaitlistToRoster();
      }
      if (waitlist.length > newSize) {
        setWaitlistSize(newSize);
      }
      return true;
    }
    return false;
  }

  // get number of students currently on the waitlist
  public int getWaitlistCount() {
    return waitlistCount;
  }

  // get max number of students allowed on the waitlist
  public int getWaitlistSize() {
    return waitlist.length;
  }

  public boolean setWaitlistSize(int newSize) {
    if (newSize > MAX_WAITLIST_SIZE) {
      newSize = MAX_WAITLIST_SIZE;
    }
    if (newSize > roster.length) {
      newSize = roster.length;
    }
    if (newSize < 0) {
      newSize = 0;
    }
    if (newSize != waitlist.length && newSize >= waitlistCount) {
      waitlist = Arrays.copyOf(waitlist, newSize);
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    String s = "Course Title: " + title;
    s += "\nRoster: " + studentCount + " enrolled (max allowed: " + roster.length + ")";
    if (studentCount > 0) {
      for (int index = 0; index < studentCount; index++) {
        s += "\n\t" + roster[index].toString();
      }
    }
    s += "\nWaitlist: " + waitlistCount + " waitlisted (max allowed: " + waitlist.length + ")";
    if (waitlistCount > 0) {
      for (int index = 0; index < waitlistCount; index++) {
        s += "\n\t" + waitlist[index].toString();
      }
    }
    return s;
  }

  public boolean addStudent(Student student) {
    if (student != null && student.isTuitionPaid()) {
      for (Student currentStudent : roster) {
        if (student.equals(currentStudent)) {
          return false;
        }
      }
      if (studentCount < roster.length) {
        roster[studentCount] = student;
        studentCount++;
        return true;
      }
      for (Student currentStudent : waitlist) {
        if (student.equals(currentStudent)) {
          return false;
        }
      }
      if (waitlistCount < waitlist.length) {
        waitlist[waitlistCount] = student;
        waitlistCount++;
        return true;
      }
    }
    return false;
  }

  public boolean dropStudent(Student student) {
    for (int index = 0; index < studentCount; index++) {
      Student currentStudent = roster[index];
      if (student.equals(currentStudent)) {
        roster[index] = roster[studentCount-1];
        roster[studentCount-1] = null;
        studentCount--;
        moveWaitlistToRoster();
        return true;
      }
    }
    for (int index = 0; index < waitlistCount; index++) {
      Student currentStudent = waitlist[index];
      if (student.equals(currentStudent)) {
        removeFromWaitlist(index);
        return true;
      }
    }
    return false;
  }

  // move one student at the top of the waitlist into the roster
  private void moveWaitlistToRoster() {
    if (studentCount < roster.length && waitlistCount > 0) {
      roster[studentCount] = waitlist[0];
      studentCount++;
      removeFromWaitlist(0);
    }
  }

  private void removeFromWaitlist(int position) {
    if (position < waitlistCount) {
      for (int index = position; index < waitlistCount-1; index++) {
        waitlist[index] = waitlist[index+1];
      }
      waitlist[waitlistCount-1] = null;
      waitlistCount--;
    }
  }

}