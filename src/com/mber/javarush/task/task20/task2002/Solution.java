package com.mber.javarush.task.task20.task2002;

import java.io.*;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "src/com/mber/javarush/task/task20/task2002/file.bin";

            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User mikeLee = new User();
            mikeLee.setFirstName("Mike");
            mikeLee.setLastName("Lee");
            mikeLee.setBirthDate(new Date(1990-1900, Calendar.DECEMBER, 25));
            mikeLee.setMale(true);
            mikeLee.setCountry(User.Country.RUSSIA);
            javaRush.users.add(mikeLee);

            User annaLee = new User();
            annaLee.setFirstName("Anna");
            annaLee.setLastName("Lee");
            annaLee.setBirthDate(new Date(1994-1900, Calendar.OCTOBER, 12));
            annaLee.setMale(false);
            annaLee.setCountry(User.Country.UKRAINE);
            javaRush.users.add(annaLee);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (this.users.size() > 0) {
                for (User current : this.users) {
                    String data = current.getFirstName() +
                            "/" + current.getLastName() +
                            "/" + current.getBirthDate().getTime() +
                            "/" + current.isMale() +
                            "/" + current.getCountry();
                    printWriter.println(data);
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                User user = new User();
                String[] lineArray = line.split("/");

                if (lineArray.length < 5) break;

                user.setFirstName(lineArray[0]);
                user.setLastName(lineArray[1]);
                user.setBirthDate(new Date(Long.parseLong(lineArray[2])));
                user.setMale(Boolean.parseBoolean(lineArray[3]));
                switch (lineArray[4]) {
                    case "UKRAINE" -> user.setCountry(User.Country.UKRAINE);
                    case "RUSSIA" -> user.setCountry(User.Country.RUSSIA);
                    default -> user.setCountry(User.Country.OTHER);
                }
                this.users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return Objects.equals(users, javaRush.users);

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}