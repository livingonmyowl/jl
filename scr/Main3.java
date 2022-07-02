import FilePackage.FileCopy;
import FilePackage.FilesCollection;
import FilePackage.ListenBreak;

import  java.io.*;

public class Main3{
/* Копирование файла:
 * Необходимо написать программу, которая на вход получает путь к исходному файлу и путь куда нужно этот файл скопировать.
 * После запуска копирования:
 *   - программа должна показывать прогресс копирования (это могут быть проценты на экране или прогресс-бар псевдографикой)
 *   - должна быть возможность остановить процесс копирования
 *     (хотелось, чтобы это было реализовано так же через отдельный поток слушающий пользовательский ввод,
 *     а не путем остановки приложения через ctrl-c)
 */

    public static void main (String[] args) throws IOException, InterruptedException{
        FilesCollection filesCollection = new FilesCollection();
        if (filesCollection.chooseFiles() == 0){

            ListenBreak listenBreakProcess = new ListenBreak();
            listenBreakProcess.setDaemon(true);
            listenBreakProcess.start();

            FileCopy fileCopy = new FileCopy();
            fileCopy.makeCopy(filesCollection.getInputFile(),filesCollection.getOutputFile());

        } else {
            System.out.println("Программа завершена с ошибкой");
        }
        System.out.println ("Конец");




    }
}
