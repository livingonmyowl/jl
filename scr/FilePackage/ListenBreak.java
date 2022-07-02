package FilePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListenBreak extends Thread{

    @Override
    public void run ()
    {
        System.out.println("Введите q для прерывания");
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        String breakString = new String();
        while (true) {
            try {
                breakString = inputBuffer.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if (breakString.compareTo("q")==0) {
                BreakStaticClass.setNeedBreak(true);
                System.out.println("Копирование остановлено");
            }


        }
    }




}
