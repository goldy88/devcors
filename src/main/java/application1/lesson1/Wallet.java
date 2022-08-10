package application1.lesson1;

public class Wallet {
    private int actualBalance;

    Wallet() {
    }

    public void saveMoney(int value) {
        this.actualBalance = actualBalance + value;
    }

    public void takeMoney(int value) {
        this.actualBalance = actualBalance - value;
    }

    public int getActualBalance() {
        return actualBalance;
    }

    @Override
    public String toString() {
        return "Actual balance is: " + getActualBalance();
    }
}
