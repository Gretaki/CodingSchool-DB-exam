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
        System.out.println("Choose exam from the list (write an ID): ");
        exams.forEach(exam -> System.out.println(exam.toString()));
    }

    public static void questionList(List<Question> questions) {
        System.out.println("Choose question from the list (write an ID): ");
        questions.forEach(question -> System.out.println(question.toString()));
    }

    public static void answerList(List<Answer> answers) {
        System.out.println("Choose answer from the list (write an ID): ");
        answers.forEach(answer -> System.out.println(answer.toString()));
    }

    public static void signedAsAdmin() {
        System.out.println("Signed in as an ADMIN.");
    }

    public static void adminOptions() {
        System.out.print("""
                Options:
                [1] - add new exam
                [2] - add new question to exam
                [3] - add new answer to question
                [4] - edit exam
                [5] - edit question of exam
                [6] - edit answer of question
                [7] - delete exam
                [8] - delete question of exam
                [9] - delete answer of question
                [10] - statistics
                [x] - exit
                """);
    }

    public static void statisticsOptions() {
        System.out.print("""
                Options:
                [1] - How many people participated in every exam
                [2] - What is the average of correct answers in every exam
                [3] - What is the frequency of every answer
                [x] - exit
                """);
    }

    public static void editQuestionOptions() {
        System.out.print("""
                Options:
                [1] - edit question text
                [2] - move question to another exam
                [x] - exit
                """);
    }

    public static void editAnswerOptions() {
        System.out.print("""
                Options:
                [1] - edit answer text
                [2] - edit answer correctness
                [3] - move answer to another question
                [x] - exit
                """);
    }

    public static void createExamOptions() {
        System.out.print("""
                Options:
                [1] - add question
                [x] - exit
                """);
    }

    public static void createQuestionOptions() {
        System.out.print("""
                Options:
                [1] - add answer
                [x] - exit
                """);
    }
}
