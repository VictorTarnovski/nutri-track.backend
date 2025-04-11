package com.nutri_track;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Scanner;

// @Component
public class WorkBench implements ApplicationRunner {

    private final PlatformTransactionManager transactionManager;
    @PersistenceContext
    private final EntityManager entityManager;

    public WorkBench(
            PlatformTransactionManager transactionManager,
            EntityManager entityManager) {
        this.transactionManager = transactionManager;
        this.entityManager = entityManager;
    }

    @Override
    public void run(ApplicationArguments args) {
        var def = new DefaultTransactionDefinition();
        var status = transactionManager.getTransaction(def);
        execute();
        entityManager.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Should rollback the transaction?: 0 - False, 1 - True\nR: ");
        try {
            boolean shouldRollback = scanner.nextInt() != 0;
            scanner.close();

            if(shouldRollback) {
                transactionManager.rollback(status);
                return;
            }

            transactionManager.commit(status);
        } catch (Exception exception) {
            transactionManager.rollback(status);
        }

    }

    private void execute() {}
}
