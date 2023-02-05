import entities.Answer;
import entities.Exam;
import entities.Question;

import java.util.List;

public class Printer {

    public static void programStartGreeting() {
        System.out.println("Welcome to Examination program!\n");
    }

    public static void userOptions() {
        System.out.print("""
                Options:
                [1] - user
                [2] - admin
                [x] - exit
                """);
    }

    public static void invalidArgumentMessage() {
        System.out.println("Invalid command, choose from the list");
    }

    public static void examList(List<Exam> exams) {
        System.out.println("Choose exam from the list: ");
        exams.forEach(exam -> System.out.println(exam.toString()));
    }

    public static void questionList(List<Question> questions) {
        System.out.println("Choose question from the list: ");
        questions.forEach(question -> System.out.println(question.toString()));
    }

    public static void answerList(List<Answer> answers) {
        System.out.println("Choose answer from the list: ");
        answers.forEach(answer -> System.out.println(answer.toString()));
    }

    public static void exam(Exam exam) {
        System.out.printf("Starting the exam: %s\n", exam);
    }
}
