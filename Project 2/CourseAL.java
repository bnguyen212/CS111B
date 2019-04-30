import java.util.ArrayList;

public class CourseAL {
  private ArrayList<Student> roster, waitlist;
  private String title;
  private int maxRoster, maxWaitlist;
  private final static int DEFAULT_ROSTER_SIZE = 50;
  private final static int MAX_ROSTER_SIZE = 100;
    // Number of spots on the waitlist should be <= the number of spots available on
    // the roster && capped at 25;
  private final static int MAX_WAITLIST_SIZE = 25;

  public CourseAL(String courseTitle) {
    this(courseTitle, DEFAULT_ROSTER_SIZE, 0);
  }

  public CourseAL(String courseTitle, int rosterSize) {
    this(courseTitle, rosterSize, 0);
  }

  public CourseAL(String courseTitle, int rosterSize, int waitlistSize) {
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
    roster = new ArrayList<Student>();
    waitlist = new ArrayList<Student>();
    maxRoster = rosterSize;
    maxWaitlist = waitlistSize;
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
    return roster.size();
  }

  // get max number of students allowed to enroll
  public int getRosterSize() {
    return maxRoster;
  }

  public boolean setRosterSize(int newSize) {
    if (newSize > MAX_ROSTER_SIZE) {
      newSize = MAX_ROSTER_SIZE;
    }
    if (newSize != maxRoster && newSize >= roster.size() && newSize > 0) {
      maxRoster = newSize;
      moveWaitlistToRoster();
      if (maxWaitlist > newSize) {
        setWaitlistSize(newSize);
      }
      return true;
    }
    return false;
  }

  // get number of students currently on the waitlist
  public int getWaitlistCount() {
    return waitlist.size();
  }

  // get max number of students allowed on the waitlist
  public int getWaitlistSize() {
    return maxWaitlist;
  }

  public boolean setWaitlistSize(int newSize) {
    if (newSize > MAX_WAITLIST_SIZE) {
      newSize = MAX_WAITLIST_SIZE;
    }
    if (newSize > maxRoster) {
      newSize = maxRoster;
    }
    if (newSize != maxWaitlist && newSize >= waitlist.size()) {
      maxWaitlist = newSize;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    String s = "Course Title: " + title;
    s += "\nRoster: " + roster.size() + " enrolled (max allowed: " + maxRoster + ")";
    for (Student student : roster) {
      s += "\n\t" + student.toString();
    }
    s += "\nWaitlist: " + waitlist.size() + " waitlisted (max allowed: " + maxWaitlist + ")";
    for (Student student : waitlist) {
      s += "\n\t" + student.toString();
    }
    return s;
  }

  public boolean addStudent(Student student) {
    if (student != null && student.isTuitionPaid()) {
      if (roster.contains(student)) {
        return false;
      }
      if (roster.size() < maxRoster) {
        return roster.add(student);
      }
      if (waitlist.contains(student)) {
        return false;
      }
      if (waitlist.size() < maxWaitlist) {
        return waitlist.add(student);
      }
    }
    return false;
  }

  public boolean dropStudent(Student student) {
    boolean remove = roster.remove(student);
    if (!remove) {
      remove = waitlist.remove(student);
    } else {
      moveWaitlistToRoster();
    }
    return remove;
  }

  private void moveWaitlistToRoster() {
    while (roster.size() < maxRoster && waitlist.size() > 0) {
      roster.add(waitlist.remove(0));
    }
  }
}