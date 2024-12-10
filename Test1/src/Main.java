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


