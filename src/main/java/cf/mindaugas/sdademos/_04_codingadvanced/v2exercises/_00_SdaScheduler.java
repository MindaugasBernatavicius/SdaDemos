package cf.mindaugas.sdademos._04_codingadvanced.v2exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class _00_SdaScheduler {
    public static void main(String[] args) {
        // 1. Manually initialize 15 students; 4 groups and 3 trainers;
        Student jonas = new Student("Jonas", "Jonauskas", LocalDate.of(1985, 9, 20), false);
        Student rokas = new Student("Rokas", "Rakauskas", LocalDate.of(1986, 9, 20), true);
        Student mykolas = new Student("Mykolas", "Mykolaitis", LocalDate.of(1987, 9, 20), false);
        Student jone = new Student("Jonė", "Jonauskaitė", LocalDate.of(1988, 9, 20), false);
        Student romas = new Student("Romas", "Romutis", LocalDate.of(1989, 9, 20), true);
        Student gerda = new Student("Gerda", "Gerdauskaitė", LocalDate.of(1990, 9, 20), false);
        Student viktoras = new Student("Viktoras", "Viktoraitis", LocalDate.of(1991, 9, 20), true);
        Student edvardas = new Student("Edvardas", "Edvardukas", LocalDate.of(1992, 9, 20), false);
        Student kipras = new Student("Kipras", "Kiprijonas", LocalDate.of(1993, 9, 20), false);
        Student nerijus = new Student("Nerijus", "Nerijauskas", LocalDate.of(1994, 9, 20), false);
        Student kostas = new Student("Kostas", "Kostinas", LocalDate.of(1995, 9, 20), false);
        Student ruta = new Student("Rūta", "Rūtelė", LocalDate.of(1996, 9, 20), true);
        Student inga = new Student("Inga", "Ingutė", LocalDate.of(1997, 9, 20), false);
        Student dima = new Student("Dima", "Dimitrov", LocalDate.of(1998, 9, 20), false);
        Student jan = new Student("Jan", "Janevič", LocalDate.of(1999, 9, 20), false);

        Group group1 = new Group("JavaVilnius6");
        Group group2 = new Group("JavaRiga5");
        Group group3 = new Group("JavaVilnius1");
        Group group4 = new Group("JavaVilnius2");

        Trainer trainer1 = new Trainer("Trainer1", "TrainerOne", LocalDate.of(1980, 9, 20), true);
        Trainer trainer2 = new Trainer("Trainer2", "TrainerTwo", LocalDate.of(1981, 9, 20), true);
        Trainer trainer3 = new Trainer("Trainer3", "TrainerThree", LocalDate.of(1982, 9, 20), true);


        // 2. Store all students in a list; all groups in a list; all trainers in a list;
        List<Student> students = new ArrayList<>();
        students.add(jonas);
        students.add(rokas);
        students.add(mykolas);
        students.add(jone);
        students.add(romas);
        students.add(gerda);
        students.add(viktoras);
        students.add(edvardas);
        students.add(kipras);
        students.add(nerijus);
        students.add(kostas);
        students.add(ruta);
        students.add(inga);
        students.add(dima);
        students.add(jan);

        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);

        List<Person> trainers = new ArrayList<>();
        trainers.add(trainer1);
        trainers.add(trainer2);
        trainers.add(trainer3);


        // 3. Assign a trainer to each group
        group1.setTrainer(trainer1);
        group2.setTrainer(trainer2);
        group3.setTrainer(trainer3);

        // 4. Assign 2/3 students to each group
        try {
            group1.addStudent(jonas);
            group1.addStudent(kipras);
            group1.addStudent(gerda);
        } catch (Group.MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
            System.out.println("The maximum number of students reached for this group!");
        }

        try {
            group2.addStudent(edvardas);
            group2.addStudent(rokas);
            group2.addStudent(romas);
            group2.addStudent(gerda);
        } catch (Group.MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
            System.out.println("The maximum number of students reached for this group!");
        }

        try {
            group3.addStudent(jone);
            group3.addStudent(jan);
        } catch (Group.MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
            System.out.println("The maximum number of students reached for this group!");
        }

        try {
            group4.addStudent(inga);
            group4.addStudent(kostas);
            group4.addStudent(dima);
            group4.addStudent(dima);
            group4.addStudent(dima);
        } catch (Group.MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
            System.out.println("The maximum number of students reached for this group!");
        }

        // 7. Display all students in a group sorted alphabetically by lastName
        System.out.println("\n\n7. Display all students in a group sorted alphabetically by lastName:\n");
        groups.forEach(g ->
                g.getStudentList().stream().sorted((Comparator.comparing(Person::getLastName)))
                        .forEach(System.out::println));

        // ... if for one (any) group:
        groups.get(0).getStudentList()
                .stream()
                .sorted((Comparator.comparing(Person::getLastName)))
                .forEach(System.out::println);

        // 8. Display the group with the maximum number of students
        // ... do not mention concrete numbers here.
        System.out.println("\n\n8. Display the group with the maximum number of students:\n");
        groups.stream()
                .max(Comparator.comparing(group -> group.getStudentList().size()))
                .ifPresent(System.out::println);

        // 9. Display all students younger than 25, from all groups (pay attention here, they need to be the ones in the groups)
        System.out.println("\n\n9. Display all students younger than 25, from all groups:\n");
        groups.forEach(g ->
                g.getStudentList()
                        .stream()
                        .filter(student ->
                                ChronoUnit.YEARS.between(
                                        student.getDateOfBirth(),
                                        LocalDate.now()
                                ) < 25)
                        // ... if you used String 1981 for dob, then you could do something like this:
                        //.filter(student -> Integer.ParseInt(student.getDateOfBirth)  ---> 1981 > 25)
                        .forEach(System.out::println)
        );

        // 10. Display all students grouped by trainer that teaches to them (eg. Trainer1 - stud1, stud3, stud4; Trainer2 - stud2, stud 10)
        // ... - regardless of the group they're part of (If you were to store this information in a data structure what would you use?)
        System.out.println("\n\n10. Display all students grouped by trainer that teaches to them :\n");

        Map<Trainer, List<Student>> studentsByTrainerMap = new HashMap<>();
        for (Group g : groups) {
            List<Student> studForTrainer = studentsByTrainerMap.get(g.getTrainer());
            if (studForTrainer == null) {
                studForTrainer = new ArrayList<>(g.getStudentList());
                studentsByTrainerMap.put(g.getTrainer(), studForTrainer);
            } else {
                studForTrainer.addAll(new ArrayList<>(g.getStudentList()));
            }
        }

        // ... it simple to group the structure you convert to stream by some field in that structure
        // ... but it would be difficult to group internal structures.
        // Map<Trainer, List<Group>> studentsByTrainer = groups.stream()
        //         .collect(Collectors.groupingBy(Group::getTrainer));

        for (Map.Entry<Trainer, List<Student>> entry : studentsByTrainerMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().size() + " students");
            System.out.println(entry.getValue() + "\n");
        }


        // 11. Display all students with previous java knowledge
        students.stream()
                .filter(Student::hasPreviousJavaKnowledge)
                .forEach(System.out::println);

        // 12. Display the group with the highest number of students with no previous java knowledge
        System.out.println("\n\n12. Display the group with the highest number of students with no previous java knowledge:\n");
        Optional<Group> groupWithHighestNumOfStudentWithPrevKnowledge = groups.stream().max(
                Comparator.comparing(g ->
                        g.getStudentList()
                                .stream()
                                .filter(student -> !student.hasPreviousJavaKnowledge())
                                .count()));

        // Optional<Group> groupWithHighestNumOfStudentWithPrevKnowledge = groups.stream().max(
        //         Comparator.comparing(g ->
        //                 g.getStudentList().stream().filter(Predicate.not(Student::hasPreviousJavaKnowledge)).count()));
        // // .. Predicate.not() available in Java 11
        groupWithHighestNumOfStudentWithPrevKnowledge.ifPresent(System.out::println);

        // 13. Remove all the students younger than 20 from all groups
        System.out.println("\n\n13. Remove all the students younger than 20 from all groups:\n");
        int ageOfAdmition = 20;
        groups.forEach(g -> g.getStudentList().removeIf(s -> ChronoUnit.YEARS.between(s.getDateOfBirth(), LocalDate.now()) < ageOfAdmition));
        groups.forEach(System.out::println);
    }
}


class Group {
    private String groupName;
    private Trainer trainer;
    private List<Student> studentList = new ArrayList<>();

    public Group(String group) {
        this.groupName = group;
    }
    public String getGroup() {
        return groupName;
    }
    public void setGroup(String group) {
        this.groupName = group;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student s) throws MaximumNumberOfStudentsReached {
        // 6. Ensure the fact that a group will only have a maximum of 5 students;
        // When you try to add a 6th one throw an MaximumNumberOfStudentsReached exception
        if (studentList.size() == 5) {
            throw new MaximumNumberOfStudentsReached();
        }
        // 5. Ensure the fact that a group will only have distinct students (How would you do that?)
        // ... are there other ways? Set?
        else if (studentList.contains(s)) {
            System.out.println("This student already exists in this group!");
        } else {
            studentList.add(s);
        }
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    @Override
    public String toString() {
        return "Group: " + groupName + ";\nTrainer: " + trainer + ";\n" + "Students list: " + studentList + "\n";
    }

    static class MaximumNumberOfStudentsReached extends Exception {
        public MaximumNumberOfStudentsReached() {
            super("There are 5 students in a group already!");
        }
    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

class Student extends Person {
    private boolean hasPreviousJavaKnowledge;
    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }
    public boolean hasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }
    public void setHasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getDateOfBirth() + " Previous Java knowledge: " + hasPreviousJavaKnowledge();
    }
}

class Trainer extends Person {
    private boolean isAuthorized;
    public Trainer(String firstName, String secondName, LocalDate dataOfBirth, boolean isAuthorized) {
        super(firstName, secondName, dataOfBirth);
        this.isAuthorized = isAuthorized;
    }
    public void setIsAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }
    public boolean getIsAuthorized() {
        return this.isAuthorized;
    }
    @Override
    public String toString() {
        return "Trainer{" +
                "isAuthorized=" + isAuthorized +
                "} " + super.toString();
    }
}




