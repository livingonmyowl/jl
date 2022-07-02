package BoxPackage;

public class Box {
    private final int numDigits = 5;
    private int value = 0;
    private boolean marker = false;

    public int getNumDigits() {
        return numDigits;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMarker() {
        return marker;
    }

    public void setMarker(boolean marker) {
        this.marker = marker;
    }

    public synchronized void get() {
        while (!marker) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C(" + this.value + ")");
        value = 0;
        this.marker = false;
        notify();
    }
    public synchronized void put(int value) {
        while (this.value !=0 ) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.marker = true;
        this.value = value;
        System.out.println("P(" + this.value + ")");
        notify();
    }

}
