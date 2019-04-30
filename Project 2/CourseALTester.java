
public class CourseALTester {

  public static void main(String[] args) {

    // additional tests

    System.out.println("\n*********TESTING CONSTRUCTORS");
    CourseAL math = new CourseAL("Algebra");
    System.out.println("\nAlgebra should have a roster of size 50 and waitlist of size 0");
    System.out.println(math);
    CourseAL english = new CourseAL("Essay Writing", 10);
    System.out.println("\nEssay Writing should have a roster of size 10 and waitlist of size 0");
    System.out.println(english);
    CourseAL gym = new CourseAL("Physical Education", 20, 10);
    System.out.println("\nPhysical Education should have a roster of size 20 and waitlist of size 10");
    System.out.println(gym);
    CourseAL geography = new CourseAL("Oceanography", 120, 200);
    System.out.println("\nOceanography should have a roster of size 100 and waitlist of size 25");
    System.out.println(geography);

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

    CourseAL history = new CourseAL("American History", 5, 5);

    for (Student student : studentsInSchool) {
      history.addStudent(student);
    }

    System.out.println("\n*********TESTING GETTER & SETTERS");
    System.out.println("\n" + history);
    System.out.println("\nCurrent number of students enrolled should be 5: " + history.getStudentCount());
    System.out.println("Roster size should be 5: " + history.getRosterSize());
    System.out.println("Current number of students waitlisted should be 5: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 5: " + history.getWaitlistSize());

    System.out.println("\nSetting roster size to 4 should return false: " + history.setRosterSize(4));
    System.out.println("Setting roster size to 7 should return true: " + history.setRosterSize(7)
        + " - GG & HH should be moved into the roster.");

    System.out.println("\n" + history);

    System.out.println("\nCurrent number of students enrolled should be 7: " + history.getStudentCount());
    System.out.println("Roster size should be 7: " + history.getRosterSize());
    System.out.println("Current number of students waitlisted should be 3: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 5: " + history.getWaitlistSize());

    System.out.println("\nSetting waitlist size to 2 should return false: " + history.setWaitlistSize(2));
    System.out.println("Setting waitlist size to 10 should return true: " + history.setWaitlistSize(10)
        + " (but trimmed down to 7 because waitlist cannot be bigger than roster size)");

    System.out.println("Current number of students waitlisted should be 3: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 7: " + history.getWaitlistSize());

    System.out.println("Setting waitlist size to 3 should return true: " + history.setWaitlistSize(3));
    System.out.println("Current number of students waitlisted should be 3: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 3: " + history.getWaitlistSize());

    System.out.println("\nSetting roster size to 101 should return true: " + history.setRosterSize(101)
        + " (but trimmed down to maximum allowed of 100)");
    System.out.println("Setting waitlist size to 30 should return true: " + history.setWaitlistSize(30)
        + " (but trimmed down to maximum allowed of 25)");

    System.out.println("\nCurrent number of students enrolled should be 10: " + history.getStudentCount());
    System.out.println("Roster size should be 100: " + history.getRosterSize());
    System.out.println("Current number of students waitlisted should be 0: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 25: " + history.getWaitlistSize());

    System.out.println("\nSetting roster size to 20 should return true: " + history.setRosterSize(20)
        + " (waitlist should also be trimmed down to maximum allowed of 20)");

    System.out.println("\nCurrent number of students enrolled should be 10: " + history.getStudentCount());
    System.out.println("Roster size should be 20: " + history.getRosterSize());
    System.out.println("Current number of students waitlisted should be 0: " + history.getWaitlistCount());
    System.out.println("Waitlist size should be 20: " + history.getWaitlistSize());

    // default tester code

    CourseAL course = new CourseAL("Media Studies", 5, 5);

    /*
     * note: to test the extra credit, replace the line above with the line below.
     * the rest of the program should run exactly the same.
     *
     * CourseAL course = new CourseAL("Media Studies", 5, 5);
     *
     */

    System.out.println("\n\n" + course + "\n");
    System.out.println("*****TESTING ADDS: Students BB, RR, SS, VV, and WW should NOT be added. All others should.");
    for (Student student : studentsInSchool) {
      boolean added = course.addStudent(student);
      System.out.println(student + (added ? " added successfully" : " not added"));
    }
    System.out.println(
        "\nCourse should now contain AA, CC, DD, EE, and FF on the course roster (in any order) and GG, HH JJ, KK, and MM on the waitlist (in that exact order).");
    System.out.println("\n" + course + "\n");

    // try to add students already added
    Student studentToAdd = studentsInSchool[2]; // CC
    boolean added = course.addStudent(studentToAdd);
    System.out.println("For " + studentToAdd.getName()
        + ", add method should return false (student is already enrolled on roster): \t" + added);
    studentToAdd = studentsInSchool[7]; // HH
    added = course.addStudent(studentToAdd);
    System.out.println("For " + studentToAdd.getName()
        + ", add method should return false (student is already enrolled on waitlist): \t" + added);

    System.out.println("\n\n*****TESTING DROPS");
    // drop student from roster
    Student studentToDrop = studentsInSchool[2]; // CC
    boolean dropped = course.dropStudent(studentToDrop);
    System.out.println("For " + studentToDrop.getName()
        + ", drop method should return true (student is enrolled on the roster): \t" + dropped);
    System.out.println(
        "\nCourse should now contain AA, DD, EE, FF, and GG on the course roster (in any order) and HH, JJ, KK, and MM on the waitlist (in that exact order).");
    System.out.println("\n" + course + "\n");

    // drop student not on roster or waitlist
    studentToDrop = studentsInSchool[14]; // WW
    dropped = course.dropStudent(studentToDrop);
    System.out.println(
        "For " + studentToDrop.getName() + ", drop method should return false (student is not enrolled): \t" + dropped);
    System.out.println(
        "\nCourse should still contain AA, DD, EE, FF, and GG on the course roster (in any order) and HH, JJ, KK, and MM on the waitlist (in that exact order).");
    System.out.println("\n" + course + "\n");

    // drop student on waitlist
    studentToDrop = studentsInSchool[8]; // JJ
    dropped = course.dropStudent(studentToDrop);
    System.out.println("For " + studentToDrop.getName()
        + ", drop method should return true (student is on the waitlist): \t" + dropped);
    System.out.println(
        "\nCourse should now contain AA, DD, EE, FF, and GG on the course roster (in any order) and HH, KK, and MM on the waitlist (in that exact order).");
    System.out.println("\n" + course + "\n");

    // drop student on roster
    studentToDrop = studentsInSchool[0]; // AA
    dropped = course.dropStudent(studentToDrop);
    System.out.println("For " + studentToDrop.getName()
        + ", drop method should return true (student is enrolled on the roster): \t" + dropped);
    System.out.println(
        "\nCourse should now contain DD, EE, FF, GG, and HH on the course roster (in any order) and KK and MM on the waitlist (in that exact order).");
    System.out.println("\n" + course + "\n");

  }

}
