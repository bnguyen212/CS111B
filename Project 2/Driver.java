import java.util.*;

public class Driver {

  public static void main(String[] args) {
    Course history = new Course("American History", 10, 5);
    Course math = new Course("Calculus I", 10, 5);
    Course english = new Course("Modern Literature", 7, 5);
    Course gym = new Course("Physical Education", 20);
    Course computerScience = new Course("Data Structures & Algorithms");
    Course language = new Course("Introductory German", 20);
    Course art = new Course("Drawing I", 10);
    Course science = new Course("Chemistry", 15, 5);

    Student[] studentsInSchool = new Student[15];
    studentsInSchool[0] = new Student("Adam Ant", "S925", true);
    studentsInSchool[1] = new Student("Bob Barker", "S713", false);
    studentsInSchool[2] = new Student("Chevy Chase", "S512", true);
    studentsInSchool[3] = new Student("Doris Day", "S513", true);
    studentsInSchool[4] = new Student("Emilio Estevez", "S516", true);
    studentsInSchool[5] = new Student("Farrah Fawcet", "S956", true);
    studentsInSchool[6] = new Student("Greta Garbo", "S419", true);
    studentsInSchool[7] = new Student("Helen Hunt", "S281", true);
    studentsInSchool[8] = new Student("Jack Johnson", "S790", true);
    studentsInSchool[9] = new Student("Kim Kardashian", "S336", true);
    studentsInSchool[10] = new Student("Martina McBride", "S156", true);
    studentsInSchool[11] = new Student("Renne Russo", "S219", true);
    studentsInSchool[12] = new Student("Susan Serandon", "S472", true);
    studentsInSchool[13] = new Student("Vince Vaughn", "S892", true);
    studentsInSchool[14] = new Student("Walt Whitman", "S901", true);
    for (Student student : studentsInSchool) {
      history.addStudent(student);
    }

    ArrayList<Course> list = new ArrayList<Course>();
    list.add(history);
    list.add(math);
    list.add(english);
    list.add(gym);
    list.add(computerScience);
    list.add(language);
    list.add(art);
    list.add(science);
    Scanner scan = new Scanner(System.in);
    int response = chooseAction(scan, list);
    while (response >= 0) {
      if (response > list.size()) {
        System.out.println("\nInvalid Course ID. Please try again.");
        response = chooseAction(scan, list);
      } else if (response == 0) {
        response = addCourse(scan, list);
      } else {
        response = viewCourse(scan, list.get(response-1), list);
      }
    }

  }

  private static void printCourses(ArrayList<Course> list) {
    System.out.println("\nID\tCourse Title");
    for (int index = 0; index < list.size(); index++) {
      System.out.println(index+1 + "\t" + list.get(index).getTitle());
    }
  }

  private static int chooseAction(Scanner scan, ArrayList<Course> list) {
    System.out.println("\n*********************************************************************");
    System.out.println("\nWelcome to the Course Registration system for the following courses:");
    printCourses(list);
    System.out.println("\nWhat action would you like to take?");
    System.out.println("0\tto add a new course");
    if (list.size() > 0) {
      System.out.printf("1-%s\tto access one of the current courses", list.size());
      System.out.println("\nCtrl+C\tto exit");
    }
    try {
      int result = Integer.parseInt(scan.nextLine());
      return result;
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private static int addCourse(Scanner scan, ArrayList<Course> list) {
    System.out.println("\nLet's add a new course!");

    String title;
    do {
      System.out.print("\nWhat is the title of the course? ");
      title = scan.nextLine();
    } while (title.length() == 0);

    int roster, waitlist;
    System.out.print("\nWhat is the roster size of the course?\nEnter a number between 1 and 100: ");
    try {
      roster = Integer.parseInt(scan.nextLine());
    } catch (NumberFormatException e) {
      roster = 0;
    }
    if (roster > 100) {
      System.out.println("\nWARNING: Invalid number, using max roster size of 100.");
      roster = 100;
    }
    if(roster <= 0) {
      System.out.println("\nWARNING: Invalid number, using default roster size of 50.");
      roster = 50;
    }

    System.out.print("\nWhat is the waitlist size of the course?\nEnter a number between 0 and " + Math.min(25, roster) + ": ");
    try {
      waitlist = Integer.parseInt(scan.nextLine());
    } catch (NumberFormatException e) {
      waitlist = 0;
    }
    if(waitlist > 25 || waitlist > roster) {
      System.out.println("\nWARNING: Invalid number, using max waitlist size of 25 or roster size (whichever is smaller).");
    }
    if (waitlist < 0) {
      System.out.println("\nWARNING: Waitlist size cannot be a negative number. The course will have no waitlist.");
    }

    Course newCourse = new Course(title, roster, waitlist);
    list.add(newCourse);
    System.out.printf("\nSUCCESS: New course \"%s\" added!\n", title);
    return list.size();
  }

  private static int viewCourse(Scanner scan, Course course, ArrayList<Course> list) {
    System.out.println("\n*********************************************************************");
    System.out.println("\n"+course);
    int response = chooseCourseAction(scan);
    while(response != 7) {
      switch(response) {
        case 1:
          addStudent(scan, course);
          break;
        case 2:
          dropStudent(scan, course);
          break;
        case 3:
          updateCourseTitle(scan, course);
          break;
        case 4:
          changeRosterSize(scan, course);
          break;
        case 5:
          changeWaitlistSize(scan, course);
          break;
        case 6:
          System.out.print("\nAre you sure you want to delete this course? (y/n) ");
          String decision = scan.nextLine();
          if (decision.equalsIgnoreCase("y")) {
            if (list.remove(course)) {
              System.out.println("\nSUCCESS: Removed this course from the system.");
              System.out.println("\nNavigating back to view all courses...");
              return chooseAction(scan, list);
            } else {
              System.out.println("\nERROR: Failed to remove this course from the system.");
            }
          }
          break;
        default:
          System.out.println("\nERROR: Invalid action. Please try again.");
      }
      System.out.println("\n*********************************************************************");
      System.out.println("\n"+course);
      response = chooseCourseAction(scan);
    }
    System.out.println("\nNavigating back to view all courses...");
    return chooseAction(scan, list);
  }

  private static int chooseCourseAction(Scanner scan) {
    System.out.println("\nWhat action would you like to take?");
    System.out.println("1\tto add student");
    System.out.println("2\tto remove a student");
    System.out.println("3\tto rename the course");
    System.out.println("4\tto set the roster size");
    System.out.println("5\tto set the waitlist size");
    System.out.println("6\tto delete the course");
    System.out.println("7\tto view all courses");
    int response;
    try {
      response = Integer.parseInt(scan.nextLine());
      return response;
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private static void addStudent(Scanner scan, Course course) {
    System.out.println("\nLet's add student to the course!");
    System.out.print("\nPlease enter student name: ");
    String name = scan.nextLine();
    System.out.print("Please enter student ID: ");
    String id = scan.nextLine();
    System.out.print("Has this student paid tuition? (y/n) ");
    String paid = scan.nextLine();
    if (paid.equalsIgnoreCase("y")) {
      if (name.length() > 0 && id.length() > 0) {
        Student newStudent = new Student(name, id, true);
        System.out.println(course.addStudent(newStudent) ? "\nSUCSSESS: " + name + " has been added to the course."
            : "\nERROR: No changes made to the roster or waitlist.");
      } else {
        System.out.println("\nERROR: Missing student name and/or id.");
      }
    } else {
      System.out.println("\nERROR: Students need to pay tuition before registering for classes.");
    }
  }

  private static void dropStudent(Scanner scan, Course course) {
    System.out.println("\nWho would you like to drop from this course?");
    System.out.print("\nPlease enter student name: ");
    String studentName = scan.nextLine();
    System.out.print("Please enter student ID: ");
    String studentID = scan.nextLine();
    Student newStudent = new Student(studentName, studentID, true);
    System.out.println(course.dropStudent(newStudent) ? "\nSUCCESS: Student with ID \"" + studentID + "\" was dropped from the course."
        : "\nERROR: No changes made to the roster or waitlist.");
  }

  private static void updateCourseTitle(Scanner scan, Course course) {
    System.out.print("\nWhat should the course title be changed to? ");
    String title = scan.nextLine();
    System.out.println(course.setTitle(title) ? "\nSUCCESS: Course title updated to \"" + title + "\"."
        : "\nERROR: Failed to update course title.");
  }

  private static void changeRosterSize(Scanner scan, Course course) {
    System.out.print(
        "\nWhat should the new roster size be?\nEnter a number between " + course.getStudentCount() + " and 100: ");
    try {
      int roster = Integer.parseInt(scan.nextLine());
      if (roster > 100) {
        System.out.println("\nWARNING: Invalid number, using max roster size of 100.");
      }
      System.out.println(course.setRosterSize(roster) ? "\nSUCCESS: Roster size updated."
          : "\nERROR: Failed to change the roster size.");
    } catch (NumberFormatException e) {
      System.out.println("\nERROR: Invalid number, no changes made to the roster size.");
    }
  }

  private static void changeWaitlistSize(Scanner scan, Course course) {
    System.out.print("\nWhat should the new waitlist size be?\nEnter a number between " + course.getWaitlistCount()
        + " and " + Math.min(25, course.getRosterSize()) + ": ");
    try {
      int waitlist = Integer.parseInt(scan.nextLine());
      if (waitlist > course.getRosterSize()) {
        System.out.println(
            "\nWARNING: Waitlist size cannot be greater than roster size, using max waitlist size of 25 or roster size (whichever is smaller).");
      }
      if (waitlist < 0) {
        System.out.println("\nWARNING: Waitlist size cannot be a negative number. The course will have no waitlist.");
      }
      System.out.println(course.setWaitlistSize(waitlist) ? "\nSUCCESS: Waitlist size updated."
          : "\nERROR: Failed to change the waitlist size.");
    } catch (NumberFormatException e) {
      System.out.println("\nERROR: Invalid number, no changes made to the waitlist size.");
    }
  }

}