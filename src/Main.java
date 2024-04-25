//joseph Momot
//1660
//4/25/2024

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


public class Main {
    public static ArrayList<Task> myTasks = new ArrayList<>();

    public static void main(String[] args) {



        try {

            Scanner input = new Scanner(System.in);



            //Task asimpletest = new Task("cat", "walk the cat", 5);
            //System.out.println(asimpletest);


            String option = "";


            while (!(option.equals("0"))) {

                System.out.println("(1) Add a task.\n" +
                        "(2) Remove a task.\n" +
                        "(3) Update a task.\n" +
                        "(4) List all tasks.\n" +
                        "(5) List task by priority.\n" +
                        "(6) super secret junk.\n" +
                        "(7) deserialize\n" +
                        "(0) Exit.");
                option = input.nextLine();


                if (option.equals("1")) {
                    System.out.println("what task name");
                    String taskName = input.nextLine();

                    System.out.println("give a description of the task");
                    String taskDescription = input.nextLine();

                    System.out.println("give a priority for the task, 1 through 5");
                    int taskPriority = input.nextInt();
                    input.nextLine();

                    Task theNewTask = new Task(taskName, taskDescription, taskPriority);
                    myTasks.add(theNewTask);


                } else if (option.equals("2")) {
                    System.out.println("what task do you want to remove");
                    System.out.println(myTasks);
                    int delete = input.nextInt();
                    input.nextLine();
                    myTasks.remove(delete);

                } else if (option.equals("3")) {
                    System.out.println("what task do you want to update (start from 0)");
                    System.out.println(myTasks);
                    int delete = input.nextInt();
                    input.nextLine();
                    myTasks.remove(delete);
                    System.out.println("what would you like to change the task name to?");
                    String taskName = input.nextLine();

                    System.out.println("give a description of the task");
                    String taskDescription = input.nextLine();

                    System.out.println("give a priority for the task, 1 through 5");
                    int taskPriority = input.nextInt();
                    input.nextLine();

                    Task theNewTask = new Task(taskName, taskDescription, taskPriority);
                    myTasks.add(theNewTask);


                } else if (option.equals("4")) {
                    Collections.sort(myTasks);
                    for(Task a : myTasks){
                        System.out.println(a);
                    }


                } else if (option.equals("5")){
                    System.out.println("what priority do you want to display");
                    Collections.sort(myTasks);
                    int userInput = input.nextInt();
                    input.nextLine();


                    for (int i = 0; i < myTasks.size(); i++) {
                        if (myTasks.get(i).getPriority() == userInput){
                            System.out.println(myTasks.get(i));
                        }
                    }
                } else if(option.equals("6")){
                    System.out.println("Code was made by joseph momot on april 25th 2024, for 1660");
                } else if(option.equals("7")){
                    deserialize();
            }


            }
            serialize();



        }catch(Exception e){
            System.out.println("improper input");

        }



    }


    static void serialize(){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("tasklist.json")){
            gson.toJson(myTasks,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void deserialize(){
        try (FileReader reader = new FileReader("tasklist.json")){
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Task>>(){}.getType();
            myTasks = gson.fromJson(jsonElement,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
