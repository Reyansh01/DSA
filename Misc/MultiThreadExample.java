package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Bank {
    
    private double balance;

    public Bank(int initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void depositAmount(int amount) {
        synchronized (this) {
            balance += amount;
            System.out.println("Depositing amount: " + amount + ". Current balance is now: " + balance);
        }
    }

    public void withdrawAmount(int amount) {
        synchronized (this) {
            if(balance - amount >= 0) {
                balance -= amount;
                System.out.println("Withdraw amount: " + amount + ". Current balance is now: " + balance);
            } else {
                System.out.println("You dont have sufficient balance to withdraw: " + amount);
            }
        }
    }

}

public class MultiThreadExample {

    public static void main(String[] args) {
        Bank bank = new Bank(1000);

        // long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(40);

        for (int i = 0; i <= 20; i++) {
            executorService.submit(() -> {
                bank.depositAmount(100);
                try {
                    // System.out.println("Going to Sleep...");
                    // Thread.sleep(5000);
                    // System.out.println("Sleep ended....");
                } catch (Exception ex) {
                    Thread.currentThread().interrupt();
                }
            }, executorService);
        }

        for (int i = 0; i <= 20; i++) {
            executorService.submit(() -> {
                bank.withdrawAmount(50);
                try {
                    // System.out.println("Going to Sleep...");
                    // Thread.sleep(5000);
                    // System.out.println("Sleep ended....");
                } catch (Exception ex) {
                    Thread.currentThread().interrupt();
                }
            }, executorService);
        }

        // List<Future<Void>> futures = new ArrayList<>();
        // for (int i = 0; i < 20; i++) {
        //     int taskId = i;
        //     Future<Void> future = executorService.submit(() -> {
        //         try {
        //             System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        //             Thread.sleep(5000);
        //             System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
        //         } catch (InterruptedException ex) {
        //             Thread.currentThread().interrupt();
        //         }
        //         return null;
        //     });
            // future.get();
            // futures.add(future);
        // }

        // for (Future<Void> future : futures) {
        //     future.get();
        // }


        // System.out.println("TIME GOT:::::" + (System.currentTimeMillis() - startTime));

        // Future<Void> future = CompletableFuture.supplyAsync(() -> {
        //     for(int i = 0; i < 20; i++) {
        //         // bank.depositAmount(100);
        //         try {
        //             System.out.println("Going to Sleep..." + Thread.currentThread().getName());
        //             Thread.sleep(5000);
        //             System.out.println("Sleep ended...." + Thread.currentThread().getName());
        //         } catch(Exception ex) {
        //             Thread.currentThread().interrupt();
        //         }
        //     }
        //     return null;
        // }, executorService);

        // depositThread.start();
        // withdrawThread.start();

        executorService.shutdown();
        // try {
        //     depositThread.join();
        //     withdrawThread.join();
        // } catch(InterruptedException ex) {
        //     Thread.currentThread().interrupt();
        // }

        // System.out.println("Final balance in the bank: " + bank.getBalance());
    }

}