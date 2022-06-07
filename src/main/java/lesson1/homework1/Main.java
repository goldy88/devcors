package lesson1.homework1;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.saveMoney(1000);
        wallet.saveMoney(1000);
        wallet.saveMoney(1000);
        wallet.takeMoney(1500);


        System.out.println(wallet);

    }
}
