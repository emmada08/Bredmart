public class Main {
    public static void main(String[] args) {
        // Создаем объекты Product с различными параметрами
        Product product1 = new Product(10, 50.0, 0.75);      // 10 товаров по 50 с 0.75% скидкой
        Product product2 = new Product(5, 200.0, 42.575);     // 5 товаров по 200 с 42.575% скидкой
        Product product3 = new Product(3, 150.0, 59.1);       // 3 товара по 150 с 59.1% скидкой

        // Выполняем расчеты и выводим результаты
        product1.calculateTotal(product1);
        product2.calculateTotal(product2);
        product3.calculateTotal(product3);
    }
}
class Product {
    private int quantity;      //Количество товара
    private double price;      //Цена товара
    private double discount;   //Скидка на товар

    //Конструктор класса
    public  Product(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }
    //Метод для расчета общей суммы покупки со скидкой и без
    public static void calculateTotal(Product product) {
        double TotalAmountWithoutDiscount = product.quantity * product.price;               //Общая сумма без скидки
        double DiscountAmount = TotalAmountWithoutDiscount * (product.discount / 100);      //Сумма скидки
        double TotalAmountDiscount = TotalAmountWithoutDiscount - DiscountAmount;           //Итоговая сумма со скидкой

        //Вывод результатов на экран
        System.out.printf("Общая сумма покупки без скдки: %.2f%n", TotalAmountWithoutDiscount);
        System.out.printf("Сумма со скидкой: %.2f%n", TotalAmountDiscount);
    }
}

