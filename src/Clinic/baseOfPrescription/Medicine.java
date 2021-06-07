package Clinic.baseOfPrescription;

public class Medicine {
     Payment payment;
     String medicineName;
     double price;

    public Medicine(String medicineName, double price, Payment payment) {
        this.medicineName = medicineName;
        this.price = price;
        this.payment = payment;
    }

}
