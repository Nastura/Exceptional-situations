
public class Main {
    public static void main(String[] args) throws RuntimeException {

        ShopRepository repo = new ShopRepository();
        Product prod1 = new Product(1, "Заголовок", 2);
        Product prod2 = new Product(1, "Заголовок", 2);

//        try {
//            repo.add(prod1);
//        } catch (NotFoundException e) {
//            System.out.println("Отчет сгенерирован");
//        }

        try {
            repo.add(prod1);
            repo.add(prod2);
        } catch (AlreadyExistsException e) {
            System.out.println("Одинаковый индекс майн");
        }

    }
}