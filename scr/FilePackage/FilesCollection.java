package FilePackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilesCollection {

    private BufferedReader inputBuffer;
    private File inputFile;
    private File outputFile;

    public File getInputFile() {
        return inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public int chooseFiles() throws IOException {
        inputBuffer = new BufferedReader(new InputStreamReader(System.in));

        //Задаём имя файла источника
        System.out.println ("Задаём имя файла - источника");
        inputFile = new File (inputBuffer.readLine());
        if (!(inputFile.canRead())){
            System.out.println("Файла \"" + inputFile.getAbsolutePath() + "\" не существует или его невозможно прочитать!");
            inputBuffer.close();
            return (1);
        }

        //Проверяем имя файла источника на директорию
        if (inputFile.isDirectory()){
            System.out.println("\"" + inputFile.getAbsolutePath() + "\" это директория!");
            inputBuffer.close();
            return (2);
        }

        //Задаём имя файла приёмника
        System.out.println ("Задаём имя файла - приёмника");
        outputFile = new File (inputBuffer.readLine());

        //Проверяем на одинаковое имя
        if (inputFile.getAbsolutePath().compareTo(outputFile.getAbsolutePath())==0) {
            System.out.println("Файл источника и приёмника не может быть одним файлом.");
            inputBuffer.close();
            return (5);
        }

        //Проверяем имя файла приёмника на директорию
        if (outputFile.isDirectory()){
            System.out.println("\"" + outputFile.getAbsolutePath() + "\" это директория!");
            inputBuffer.close();
            return (2);
        }

        //Проверяем существует ли файл
        if (outputFile.exists()){
            System.out.println("Файл \"" + outputFile.getAbsolutePath() + "\" существует. Введите 1 для перезаписи");

            //Спрашиваем пользователя о перезаписи существующего файла
            int c;
            c = inputBuffer.read();
            if (c != '1') {
                System.out.println("Файл \"" + outputFile.getAbsolutePath() + "\" не будет перезаписан.");
                inputBuffer.close();
                return (3);
            }

            //Проверяем возможность записи в файла
            if (!outputFile.canWrite()){
                System.out.println("Файл \"" + outputFile.getAbsolutePath() + "\" не может быть перезаписан.");
                inputBuffer.close();
                return (4);
            }
            System.out.println("Файл \"" + outputFile.getAbsolutePath() + "\" будет перезаписан.");
        } else {
            //Создаём новый файл если его ещё не было
            outputFile.createNewFile();
        }

        //Все имена в порядке, инициализируем поток остановки
        System.out.println ("Источник: " + inputFile.getAbsolutePath());
        System.out.println("Приёмник: " + outputFile.getAbsolutePath());
        return (0);

    }
}
