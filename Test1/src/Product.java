public class Product   {
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