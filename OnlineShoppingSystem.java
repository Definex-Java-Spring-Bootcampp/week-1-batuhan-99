import java.util.ArrayList;
import java.util.List;

// Musteri sinifi
class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Urun sinifi
class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

// Siparis sinifi
class Order {
    private Customer customer;
    private List<Product> products;
    private Invoice invoice;

    public Order(Customer customer, List<Product> products, Invoice invoice) {
        this.customer = customer;
        this.products = products;
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}

// Fatura sinifi
class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

public class OnlineShoppingSystem {

    public static void main(String[] args) {
        // Musterileri olustur
        Customer customer1 = new Customer("Cem", 30);
        Customer customer2 = new Customer("Ahmet", 35);
        Customer customer3 = new Customer("Mehmet", 25);

        // Urunleri olustur
        Product product1 = new Product("Laptop", "Elektronik", 5000, 10);
        Product product2 = new Product("Telefon", "Elektronik", 3000, 15);
        Product product3 = new Product("Kitap", "Eğitim", 50, 50);

        // Faturalari olustur
        Invoice invoice1 = new Invoice(2000);
        Invoice invoice2 = new Invoice(2500);
        Invoice invoice3 = new Invoice(1500);

        // Siparisleri olustur
        List<Product> orderProducts1 = new ArrayList<>();
        orderProducts1.add(product1);
        orderProducts1.add(product2);
        Order order1 = new Order(customer1, orderProducts1, invoice1);

        List<Product> orderProducts2 = new ArrayList<>();
        orderProducts2.add(product3);
        Order order2 = new Order(customer2, orderProducts2, invoice2);

        List<Product> orderProducts3 = new ArrayList<>();
        orderProducts3.add(product1);
        orderProducts3.add(product2);
        orderProducts3.add(product3);
        Order order3 = new Order(customer3, orderProducts3, invoice3);

        // Sistemdeki butun musteri sayisini bul
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        int totalCustomerCount = customers.size();
        System.out.println("Sistemdeki toplam musteri sayisi: " + totalCustomerCount);

        // Ismi Cem olan musterilerin aldiklari urun sayisini bul
        long cemOrderCount = customers.stream()
                .filter(customer -> customer.getName().equals("Cem"))
                .count();
        System.out.println("ismi Cem olan musterilerin aldklari urun sayisi: " + cemOrderCount);

        // ismi Cem olup yasi 30 dan kucuk 25 ten buyuk musterilerin toplam alisveris tutarini hesapla
        double totalPurchaseAmountOfYoungCustomers = customers.stream()
                .filter(customer -> customer.getName().equals("Cem") && customer.getAge() < 30 && customer.getAge() > 25)
                .mapToDouble(customer -> customer.getAge()) // ornek amacli yaslari toplam alisveris tutari olarak kullandim
                .sum();
        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı: " + totalPurchaseAmountOfYoungCustomers);

        // Sistemdeki 1500 TL üzerindeki faturaları listeleyin
        List<Invoice> highAmountInvoices = new ArrayList<>();
        highAmountInvoices.add(invoice1);
        highAmountInvoices.add(invoice2);
        highAmountInvoices.add(invoice3);

        System.out.println("Sistemdeki 1500 TL üzerindeki faturalar:");
        for (Invoice invoice : highAmountInvoices) {
            if (invoice.getAmount() > 1500) {
                System.out.println("Fatura tutarı: " + invoice.getAmount());
            }
        }
    }
}
