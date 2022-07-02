package VolatilePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VolatileListenBreak extends Thread{
    private /*volatile*/ boolean needBreak = false;

    public boolean isNeedBreak() {
        return needBreak;
    }

    @Override
    public void run ()
    {
        System.out.println("Запуск потока остановки. Введите break для прерывания");
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        String breakString = new String();
        while (true) {
            try {
                breakString = inputBuffer.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if (breakString.compareTo("break")==0) {
                this.needBreak = true;
            }
            System.out.println("break: " + this.needBreak);

        }
    }

}
