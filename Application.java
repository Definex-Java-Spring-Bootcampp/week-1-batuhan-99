package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalDateTime;

public class Application {

    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    private Application() {
    }

    /*
    public Application(CreditCard creditCard, User user, LocalDateTime localDateTime) {
        this.creditCard = creditCard;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }*/

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}

 class ApplicationService {

    public User findUserWithMostApplications(List<Application> applications) {
        // Kullanıcıların başvuru sayısını tutmak için bir harita oluştur
        Map<User, Integer> applicationCountMap = new HashMap<>();

        // Tüm başvuruları döngü ile kontrol 
        for (Application application : applications) {
            User user = application.getUser();

            // Kullanıcının başvuru sayısını artırın veya ilk kez başvuru yapıyorsa 1 olarak ayarla
            int count = applicationCountMap.getOrDefault(user, 0);
            applicationCountMap.put(user, count + 1);
        }

        // En çok başvuru yapan kullanıcıyı bul
        User userWithMostApplications = null;
        int maxApplications = 0;

        for (Map.Entry<User, Integer> entry : applicationCountMap.entrySet()) {
            if (entry.getValue() > maxApplications) {
                maxApplications = entry.getValue();
                userWithMostApplications = entry.getKey();
            }
        }

        return userWithMostApplications;
    }


}