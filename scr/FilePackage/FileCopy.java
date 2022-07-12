package FilePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    private long inputFileSize; // = filesCollection.getInputFile().length();
    private long currentWriteBytes = 0;

    private int currentProgress = 0;
    private static final int copySpeed = 16*1024;

    public int getCurrentProgress() {
        return currentProgress;
    }

    public long getInputFileSize() {
        return inputFileSize;
    }

    public long getCurrentWriteBytes() {
        return currentWriteBytes;
    }

    public void makeCopy(File inputFile, File outputFile) throws InterruptedException{
        inputFileSize = inputFile.length();

        //Запускаем процесс копирования файла
        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            byte[] data = new byte[copySpeed];
            int count;

            Thread checkProgress = new Thread(() -> {
                while (true) {
                    System.out.println("Скопировано: " + currentWriteBytes +
                            " байт из " + inputFileSize +
                            " (" + currentProgress + "%)");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            checkProgress.setDaemon(true);
            checkProgress.start();


            while (((count = inputStream.read(data)) != -1) && (!BreakStaticClass.isNeedBreak())) {
                outputStream.write(data, 0, count);
                currentWriteBytes+=count;
                currentProgress = (int) (((double)currentWriteBytes / (double) inputFileSize) * 100);
//                System.out.println("Скопировано: " + currentWriteBytes +
//                        " байт из " + inputFileSize +
//                        " (" + currentProgress + "%)");
                Thread.sleep(100);                                  //Искусственная задержка для тестирования на маленьких файлах

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

}
