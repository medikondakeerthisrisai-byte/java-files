import java.util.Scanner;

public class AdaptiveQuiz {

    // Simple Question structure
    static class Question {
        String prompt;
        String optionA;
        String optionB;
        String optionC;
        char correctAnswer;
        int difficulty; // 1 = Easy, 2 = Medium, 3 = Hard

        public Question(String prompt, String optionA, String optionB, String optionC, char correctAnswer, int difficulty) {
            this.prompt = prompt;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.correctAnswer = Character.toUpperCase(correctAnswer);
            this.difficulty = difficulty;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Question Pool
        Question[] questionBank = {
            // Easy Questions (Difficulty 1)
            new Question("What is 2 + 2?", "A) 3", "B) 4", "C) 5", 'B', 1),
            new Question("Which keyword defines a class in Java?", "A) class", "B) define", "C) struct", 'A', 1),
            // Medium Questions (Difficulty 2)
            new Question("Which data type stores fractional numbers in Java?", "A) int", "B) double", "C) boolean", 'B', 2),
            new Question("Which loop guarantees execution at least once?", "A) for", "B) while", "C) do-while", 'C', 2),
            // Hard Questions (Difficulty 3)
            new Question("What is the default value of an Object reference in Java?", "A) 0", "B) undefined", "C) null", 'C', 3),
            new Question("Which feature allows method names to be overloaded?", "A) Polymorphism", "B) Inheritance", "C) Encapsulation", 'A', 3)
        };

        int totalQuestionsToAsk = 4;
        int currentDifficulty = 1; // Start at Easy level
        int score = 0;
        int questionsAsked = 0;
        char restartChoice;

        // do-while loop: continue until exam ends / user finishes session
        do {
            System.out.println("==========================================");
            System.out.println("       STARTING ADAPTIVE QUIZ ENGINE      ");
            System.out.println("==========================================");

            score = 0;
            questionsAsked = 0;
            currentDifficulty = 1;

            // for loop: ask a fixed number of questions
            for (int i = 0; i < totalQuestionsToAsk; i++) {
                // Find a question matching current difficulty
                Question q = getQuestionByDifficulty(questionBank, currentDifficulty, i);

                System.out.println("\n[Question " + (i + 1) + " | Difficulty Level: " + getDifficultyLabel(currentDifficulty) + "]");
                System.out.println(q.prompt);
                System.out.println(q.optionA);
                System.out.println(q.optionB);
                System.out.println(q.optionC);
                System.out.print("Your Answer (A/B/C): ");

                char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

                // if-else statement: check correct or wrong answer
                if (userAnswer == q.correctAnswer) {
                    System.out.println("Result: Correct!");
                    score += currentDifficulty * 10; // Higher difficulty awards more points

                    // nested if statement: adjust difficulty level (increase on correct answer)
                    if (currentDifficulty < 3) {
                        currentDifficulty++;
                        System.out.println("--> Difficulty increased to Level " + currentDifficulty + "!");
                    }
                } else {
                    System.out.println("Result: Wrong! The correct answer was " + q.correctAnswer + ".");

                    // nested if statement: adjust difficulty level (decrease on wrong answer)
                    if (currentDifficulty > 1) {
                        currentDifficulty--;
                        System.out.println("--> Difficulty reduced to Level " + currentDifficulty + ".");
                    }
                }

                questionsAsked++;
            }

            // Display overall final results
            System.out.println("\n==========================================");
            System.out.println("               EXAM RESULTS               ");
            System.out.println("==========================================");
            System.out.println("Total Questions Answered: " + questionsAsked);
            System.out.println("Final Score: " + score);
            System.out.println("Final Adapted Level Reached: " + getDifficultyLabel(currentDifficulty));

            System.out.print("\nDo you want to retake the exam? (Y/N): ");
            restartChoice = Character.toUpperCase(scanner.next().charAt(0));

        } while (restartChoice == 'Y'); // do-while condition to control retaking the exam

        System.out.println("\nThank you for using the Adaptive Quiz Engine!");
        scanner.close();
    }

    // Helper method to pull a question based on target difficulty level
    private static Question getQuestionByDifficulty(Question[] bank, int difficulty, int index) {
        for (Question q : bank) {
            if (q.difficulty == difficulty) {
                return q;
            }
        }
        return bank[index % bank.length]; // Fallback if exact match not found
    }

    private static String getDifficultyLabel(int diff) {
        if (diff == 1) return "Easy";
        if (diff == 2) return "Medium";
        return "Hard";
    }
}