package com.aakarsh.quizquest.other;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.aakarsh.quizquest.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static String formatDate(long time){
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    public static Map<String,String> getPythonQuestions(){
        HashMap<String,String> questions = new HashMap<>();
        questions.put("Keyword for defining a function","def");
        questions.put("Type of loop that repeats a fixed number of times","for");
        questions.put("Keyword to handle exceptions","except");
        questions.put("Function to get the length of a list","len");
        questions.put("Keyword to create a class","class");
        questions.put("Method to add an element to a list","append");
        questions.put("Function to read input from the user","input");
        questions.put("Keyword for an infinite loop","while");
        questions.put("Type of collection that is immutable","tuple");
        questions.put("Keyword to import a module","import");
        questions.put("Built-in function to convert a string to an integer","int");
        questions.put("Built-in function to convert a value to a string","str");
        questions.put("Keyword to return a value from a function","return");
        questions.put("Special method name for a constructor","__init__");
        questions.put("Keyword to create a new variable inside a function","global");

        return questions;
    }

    public static Map<String,String> getRandomPythonQuestions(int SIZE){
        HashMap<String,String> questionsMap = new HashMap<>();
        Map<String,String> originalQuestion = getPythonQuestions();
        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }



    public static Map<String,Map<String,Boolean>> getCplusQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("class",true);
        answer1.put("def",false);
        answer1.put("function",false);
        answer1.put("structure",false);
        questions.put("Which keyword is used to define a class in C++?",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("->",true);
        answer2.put(".",false);
        answer2.put("::",false);
        answer2.put("*",false);
        questions.put("Which operator is used to access a member of a class through a pointer?",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("int",true);
        answer3.put("void",false);
        answer3.put("float",false);
        answer3.put("char",false);
        questions.put("What is the default return type of the main function in C++?",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("//",true);
        answer4.put("\\\\",false);
        answer4.put("/* */",false);
        answer4.put("<!- ->",false);
        questions.put("Which of the following is used for comments in C++?",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("6",true);
        answer5.put("4",false);
        answer5.put("5",false);
        answer5.put("7",false);
        questions.put("What is the output of the following code snippet? int x = 5; cout << ++x;",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("iostream",true);
        answer6.put("stdio.h",false);
        answer6.put("conio.h",false);
        answer6.put("math.h",false);
        questions.put("Which header file is required for input/output operations in C++?",answer6);


        return questions;
    }

    public static Map<String,Map<String,Boolean>> getJavaQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answer1 = new HashMap<>();
        answer1.put("throw-catch",false);
        answer1.put("catch-finally",false);
        answer1.put("try-catch ",true);
        answer1.put("try-final",false);
        questions.put("Which of the following is used to handle exceptions in Java?",answer1);

        HashMap<String,Boolean> answer2 = new HashMap<>();
        answer2.put("start()",true);
        answer2.put("begin()",false);
        answer2.put("run()",false);
        answer2.put("execute()",false);
        questions.put("Which of the following methods is used to start a thread execution in Java?",answer2);

        HashMap<String,Boolean> answer3 = new HashMap<>();
        answer3.put("abstract",false);
        answer3.put("final",true);
        answer3.put("protected",false);
        answer3.put("static",false);
        questions.put("Which keyword is used to prevent inheritance of a class in Java?",answer3);

        HashMap<String,Boolean> answer4 = new HashMap<>();
        answer4.put("6 bytes",false);
        answer4.put("4 bytes",false);
        answer4.put("16 bytes",false);
        answer4.put("8 bytes",true);
        questions.put("What is the size of the long data type in Java?",answer4);

        HashMap<String,Boolean> answer5 = new HashMap<>();
        answer5.put("NullPointerException",false);
        answer5.put("ArithmeticException",true);
        answer5.put("ArrayIndexOutOfBoundsException",false);
        answer5.put("ClassCastException",false);
        questions.put("Which exception is thrown when a division by zero occurs in Java?",answer5);

        HashMap<String,Boolean> answer6 = new HashMap<>();
        answer6.put("for",false);
        answer6.put("do-while",true);
        answer6.put("while",false);
        answer6.put("for-each",false);
        questions.put("Which of the following loops will execute at least once?",answer6);



        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomJavaAndCplusQuestions(Context context, String subject, int SIZE){
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion;
        if (subject.equals(context.getString(R.string.java))){
            originalQuestion = getJavaQuestions();
        }else{
            originalQuestion = getCplusQuestions();
        }

        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

}
