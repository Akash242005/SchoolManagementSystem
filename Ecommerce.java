import java.util.ArrayList;

class User {
    private String name;
    private String email;
    public User(String name,String email)
    {
        this.name = name;
        this.email = email;
    }
    public void display()
    {
        System.out.println("The name : "+name);
        System.out.println("The name : "+email);
    }
    public void performRole(){
        System.out.println("User role is performing now ");
    }
}
class Admin extends User{
    public Admin(String name,String email)
    {
        super(name, email);
    }
    @Override
    public void performRole(){
        System.out.println("The Admin role is performing now");
    }
}
class Seller extends User{
    private String storeName;
    public Seller(String name,String email,String storeName)
    {
        super(name, email);
        this.storeName = storeName;
    }
    @Override
    public void performRole(){
        System.out.println("Seller: Adding and Managing product for the store : "+storeName);
    }
    public void addProduct()
    {
        System.out.println("Seller : Adding produts to the store : "+storeName);
    }
}
class Product{
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void showCatergary() {
    }
}
class Customer extends User{
    public Customer(String name,String email)
    {
        super(name, email);
    }
    @Override
    public void performRole(){
        System.out.println("Customer : Browsing and percesing the product");
    }
    public void placeOrder(Product product)
    {
        System.out.println("Customer : Placing the order");
    }
}
class Electronics extends Product{
    public Electronics(String name,double price)
    {
        super(name, price);
    }
    @Override
    public void showCatergary(){
        System.out.println("Categary : Electronics -> " +getName());
        System.out.println("Categary : Electronics(Price) -> " +getPrice());
    }
}
class Clothing extends Product{
    public Clothing(String name,double price)
    {
        super(name, price);
    }
    @Override
    public void showCatergary(){
        System.out.println("Categary : Clothing -> " +getName());
        System.out.println("Categary : Clothing(Price) -> " +getPrice());
    }
}
class Mobile extends Product{
    public Mobile(String name,double price)
    {
        super(name, price);
    }
    @Override
    public void showCatergary(){
        System.out.println("Categary : Mobile -> " +getName());
        System.out.println("Categary : Mobile(Price) -> " +getPrice());
    }
}
class Groceries extends Product{
    public Groceries(String name,double price)
    {
        super(name, price);
    }
    @Override
    public void showCatergary(){
        System.out.println("Categary : Groceries -> " +getName());
        System.out.println("Categary : Groceries(Price) -> " +getPrice());
    }
}
public class EcomerceSystem{
    public static void main(String[] args)
    {
        User admin = new Admin("Akash", "123456@gmail.com");
        User  seller = new Seller("Akash", "123456@gmail.com", "BigBasket");
        User customer = new Customer("Suresh","47823@gmail.com");

        Product laptop = new Electronics("Laptop",52000.82);
        Product dress = new Clothing("Dress",1200.83);
        Product grocesry = new Groceries("grocery",127.83);
        Product iphone = new Mobile("iphone",125000.29);


        ArrayList<User> users = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        users.add(admin);
        users.add(seller);
        users.add(customer);
        products.add(laptop);
        products.add(dress);
        products.add(grocesry);
        products.add(iphone);
        System.out.println(" ");
        System.out.println("************************USER:***************************");
        for(User user : users)
        {
            user.performRole();
            user.display();
            System.out.println("====================================================");
        }
        System.out.println(" ");
        System.out.println("************************PRODUCT:********************");
        for(Product product : products)
        {
            product.showCatergary();
            System.out.println("====================================================");
        }
    }
}
