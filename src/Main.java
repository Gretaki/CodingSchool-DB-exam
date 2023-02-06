import entities.Answer;
import entities.Exam;
import entities.Participant;
import entities.Question;
import entities.Result;
import entities.ResultChoice;
import entities.ResultStatus;
import org.hibernate.Session;
import repositories.AnswerRepository;
import repositories.ExamRepository;
import repositories.ParticipantRepository;
import repositories.QuestionRepository;
import repositories.ResultChoiceRepository;
import repositories.ResultRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactoryMaker.getFactory();
        Session session = SessionFactoryMaker.getFactory().openSession();
        Scanner sc = new Scanner(System.in);

        runProgram(sc, session);

        sc.close();
    }

    public static Session runProgram(Scanner sc, Session session) {
        Printer.programStartGreeting();

        boolean runProgram = true;
        while (runProgram) {
            Printer.userOptions();
            String inputOption = sc.nextLine().toLowerCase();
            switch (inputOption) {
                case "1" -> participateInExam(sc, session);
                case "2" -> administrateExams(sc, session);
                case "x" -> runProgram = false;
                default -> Printer.invalidArgumentMessage();
            }
        }
        return session;
    }

    private static void administrateExams(Scanner sc, Session session) {
        Printer.signedAsAdmin();

        boolean runProgramAsAdmin = true;
        while (runProgramAsAdmin) {
            Printer.adminOptions();
            String inputOption = sc.nextLine().toLowerCase();
            switch (inputOption) {
                case "1" -> createExam(sc, session);
                case "2" -> createQuestion(sc, session);
                case "3" -> createAnswer(sc, session);
                case "4" -> editExam(sc, session);
                case "5" -> editQuestion(sc, session);
                case "6" -> editAnswer(sc, session);
                case "7" -> deleteExam(sc, session);
                case "8" -> deleteQuestion(sc, session);
                case "9" -> deleteAnswer(sc, session);
                case "10" -> showStatistics(sc, session);
                case "x" -> runProgramAsAdmin = false;
                default -> Printer.invalidArgumentMessage();
            }
        }
    }

    private static void showStatistics(Scanner sc, Session session) {
        boolean run = true;
        while (run) {
            Printer.statisticsOptions();
            String inputOption = sc.nextLine().toLowerCase();
            switch (inputOption) {
                case "1" -> getPeopleByExam(session);
                case "2" -> getResultChoiceByParticipantByExam(session);
                case "3" -> getAnswerChoicesByQuestion(session);
                case "x" -> run = false;
                default -> Printer.invalidArgumentMessage();
            }
        }
    }

    private static void getPeopleByExam(Session session) {
        ExamRepository examRepository = new ExamRepository(session);
        List<Object[]> peopleByExam = examRepository.getPeopleByExam();

        System.out.println("  Exam                    | NoOfParticipants");
        peopleByExam.forEach(value -> {
            System.out.printf("%3d. %-20s | %s\n", (long) value[0], value[1], value[2]);
        });
    }

    private static void getResultChoiceByParticipantByExam(Session session) {
        ExamRepository examRepository = new ExamRepository(session);
        List<Object[]> results = examRepository.getResultChoiceByParticipantByExam();

        System.out.println("  Exam                    | AvgOfCorrectAnswersInExam");
        results.forEach(value -> {
            double correct = ((BigDecimal) value[3]).doubleValue() / ((Long) value[2]);
            double total = ((Long) value[4]).doubleValue() / ((Long) value[2]);
            String correctString = String.format("%.2f / %.0f", correct, total);
            System.out.printf("%3d. %-20s | %s\n", (long) value[0], value[1], correctString);
        });
    }

    private static void getAnswerChoicesByQuestion(Session session) {
        ResultChoiceRepository resultChoiceRepository = new ResultChoiceRepository(session);
        List<Object[]> results = resultChoiceRepository.getAnswerChoicesByQuestion();

        System.out.println("  Exam                                             |  A  |  B  |  C  ");
        results.forEach(value -> {
            System.out.printf("%3d. %-45s | %3d | %3d | %3d\n", (long) value[0], value[1], (long) value[2], (long) value[3], (long) value[4]);
        });
    }

    private static void deleteExam(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        QuestionRepository questionRepository = new QuestionRepository(session);
        List<Question> questions = questionRepository.getByExam(exam);

        questions.forEach(question -> {
            AnswerRepository answerRepository = new AnswerRepository(session);
            List<Answer> answers = answerRepository.getByQuestion(question);
            answers.forEach(answerRepository::delete);
            questionRepository.delete(question);
        });

        ExamRepository examRepository = new ExamRepository(session);
        examRepository.delete(exam);
        System.out.println("Exam deleted successfully");
    }

    private static void deleteQuestion(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        Question question = chooseQuestion(sc, session, exam);

        AnswerRepository answerRepository = new AnswerRepository(session);
        List<Answer> answers = answerRepository.getByQuestion(question);
        answers.forEach(answerRepository::delete);

        QuestionRepository questionRepository = new QuestionRepository(session);
        questionRepository.delete(question);
        System.out.println("Question deleted successfully");
    }

    private static void deleteAnswer(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        Question question = chooseQuestion(sc, session, exam);
        Answer answer = chooseAnswer(sc, session, question);

        AnswerRepository answerRepository = new AnswerRepository(session);
        answerRepository.delete(answer);
        System.out.println("Answer deleted successfully");
    }

    private static void editExam(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        System.out.println("Enter updates exam name: ");
        String inputExamName = sc.nextLine();
        ExamRepository examRepository = new ExamRepository(session);
        examRepository.update(exam, inputExamName);
    }

    private static void editQuestion(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        Question question = chooseQuestion(sc, session, exam);

        boolean run = true;
        while (run) {
            Printer.editQuestionOptions();
            String inputOption = sc.nextLine().toLowerCase();
            String inputQuestionName = "";
            Exam updatedExam = null;
            switch (inputOption) {
                case "1" -> {
                    System.out.println("Enter updates question name: ");
                    inputQuestionName = sc.nextLine();
                }
                case "2" -> updatedExam = chooseExam(sc, session);
                case "x" -> run = false;
                default -> Printer.invalidArgumentMessage();
            }

            QuestionRepository questionRepository = new QuestionRepository(session);
            questionRepository.update(question, inputQuestionName, updatedExam);
        }
    }

    private static void editAnswer(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        Question question = chooseQuestion(sc, session, exam);
        Answer answer = chooseAnswer(sc, session, question);

        boolean run = true;
        while (run) {
            Printer.editAnswerOptions();
            String inputOption = sc.nextLine().toLowerCase();
            String inputAnswerName = "";
            boolean updatedAnswerCorrectness = false;
            Question updatedQuestion = null;
            switch (inputOption) {
                case "1" -> {
                    System.out.println("Enter updates answer: ");
                    inputAnswerName = sc.nextLine();
                }
                case "2" -> {
                    System.out.println("Enter updates correctness: ");
                    String inputAnswerCorrectness = sc.nextLine().toLowerCase().trim();
                    updatedAnswerCorrectness = inputAnswerCorrectness.equals("y") || inputAnswerCorrectness.equals("yes") | inputAnswerCorrectness.equals("true") | inputAnswerCorrectness.equals("t");
                }
                case "3" -> updatedQuestion = chooseQuestion(sc, session, exam);
                case "x" -> run = false;
                default -> Printer.invalidArgumentMessage();
            }
            AnswerRepository answerRepository = new AnswerRepository(session);
            answerRepository.update(answer, inputAnswerName, updatedAnswerCorrectness, updatedQuestion);
        }
    }

    private static void createExam(Scanner sc, Session session) {
        System.out.println("Enter exam name: ");
        String inputExamName = sc.nextLine();
        ExamRepository examRepository = new ExamRepository(session);
        Exam exam = examRepository.add(new Exam(inputExamName));

        boolean runAddingQuestions = true;
        while (runAddingQuestions) {
            Printer.createExamOptions();
            String inputOption = sc.nextLine().toLowerCase();
            switch (inputOption) {
                case "1" -> createQuestionForExam(sc, session, exam);
                case "x" -> runAddingQuestions = false;
                default -> Printer.invalidArgumentMessage();
            }
        }
    }

    private static void createQuestion(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        createQuestionForExam(sc, session, exam);
    }

    private static void createAnswer(Scanner sc, Session session) {
        Exam exam = chooseExam(sc, session);
        Question question = chooseQuestion(sc, session, exam);
        createAnswerForQuestion(sc, session, question);
    }

    private static void createQuestionForExam(Scanner sc, Session session, Exam exam) {
        System.out.println("Enter question: ");
        String inputQuestion = sc.nextLine();
        QuestionRepository questionRepository = new QuestionRepository(session);
        Question question = questionRepository.add(new Question(inputQuestion, exam));

        boolean runAddingAnswers = true;
        while (runAddingAnswers) {
            Printer.createQuestionOptions();
            String inputOption = sc.nextLine().toLowerCase();
            switch (inputOption) {
                case "1" -> createAnswerForQuestion(sc, session, question);
                case "x" -> runAddingAnswers = false;
                default -> Printer.invalidArgumentMessage();
            }
        }
    }

    private static void createAnswerForQuestion(Scanner sc, Session session, Question question) {
        System.out.println("Enter answer: ");
        String inputAnswer = sc.nextLine();
        System.out.println("Is answer correct: ");
        String inputAnswerCorrectness = sc.nextLine().toLowerCase();
        boolean answerIsCorrect = inputAnswerCorrectness.equals("y") || inputAnswerCorrectness.equals("yes") | inputAnswerCorrectness.equals("true") | inputAnswerCorrectness.equals("t");

        AnswerRepository answerRepository = new AnswerRepository(session);
        answerRepository.add(new Answer(inputAnswer, answerIsCorrect, question));
    }

    private static void participateInExam(Scanner sc, Session session) {
        ResultRepository resultRepository = new ResultRepository(session);
        ResultChoiceRepository resultChoiceRepository = new ResultChoiceRepository(session);

        Participant participant = enterName(sc, session);
        Exam exam = chooseExam(sc, session);
        Result result = createResult(resultRepository, exam, participant);
        answerQuestions(sc, resultChoiceRepository, session, exam, result);

        showResults(resultChoiceRepository, result);
        resultRepository.makeExamStatusCompleted(result);
    }

    private static Participant enterName(Scanner sc, Session session) {
        System.out.println("Enter your name: ");
        String inputName = sc.nextLine();
        ParticipantRepository participantRepository = new ParticipantRepository(session);
        return participantRepository.add(new Participant(inputName));
    }

    private static Result createResult(ResultRepository resultRepository, Exam exam, Participant participant) {
        return resultRepository.add(new Result(ResultStatus.IN_PROGRESS, exam, participant));
    }

    private static void showResults(ResultChoiceRepository resultChoiceRepository, Result result) {
        System.out.println("All answers:");
        List<ResultChoice> resultChoices = resultChoiceRepository.getByResult(result);
        int totalCorrectResults = 0;
        for (int i = 0; i < resultChoices.size(); i++) {
            ResultChoice resultChoice = resultChoices.get(i);
            boolean isAnswerIsCorrect = resultChoice.getAnswer().isAnswerIsCorrect();
            if (isAnswerIsCorrect) {
                totalCorrectResults++;
            }
            String answerIsCorrect = isAnswerIsCorrect ? "✅" : "❌";
            System.out.printf("%3d. Question: %-60s Your answer: %-20s | %s\n", i + 1, resultChoice.getQuestion(), resultChoice.getAnswer(), answerIsCorrect);
        }
        System.out.println("Total correct result: " + totalCorrectResults + " / " + resultChoices.size());
    }

    private static void answerQuestions(Scanner sc, ResultChoiceRepository resultChoiceRepository, Session session, Exam exam, Result result) {
        QuestionRepository questionRepository = new QuestionRepository(session);
        AnswerRepository answerRepository = new AnswerRepository(session);

        List<Question> questions = questionRepository.getByExam(exam);
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.printf("%3d. %s :\n", i + 1, question);
            List<Answer> answers = answerRepository.getByQuestion(question);
            for (int j = 0; j < answers.size(); j++) {
                System.out.printf("  %3d. %s\n", j + 1, answers.get(j));
            }

            System.out.print("Your answer: ");
            String inputAnswer = sc.nextLine().toLowerCase().trim();
            int inputAnswerIndex = Integer.parseInt(inputAnswer) - 1;

            resultChoiceRepository.add(new ResultChoice(result, question, answers.get(inputAnswerIndex)));
        }
    }

    private static Exam chooseExam(Scanner sc, Session session) {
        ExamRepository examRepository = new ExamRepository(session);
        List<Exam> exams = examRepository.getAll();
        Printer.examList(exams);
        String inputExam = sc.nextLine().toLowerCase();
        return examRepository.getById(Long.parseLong(inputExam));
    }

    private static Question chooseQuestion(Scanner sc, Session session, Exam exam) {
        QuestionRepository questionRepository = new QuestionRepository(session);
        List<Question> questions = questionRepository.getByExam(exam);
        Printer.questionList(questions);
        String inputQuestion = sc.nextLine().toLowerCase();
        return questionRepository.getById(Long.parseLong(inputQuestion));
    }

    private static Answer chooseAnswer(Scanner sc, Session session, Question question) {
        AnswerRepository answerRepository = new AnswerRepository(session);
        List<Answer> answers = answerRepository.getByQuestion(question);
        Printer.answerList(answers);
        String inputAnswer = sc.nextLine().toLowerCase();
        return answerRepository.getById(Long.parseLong(inputAnswer));
    }
}
