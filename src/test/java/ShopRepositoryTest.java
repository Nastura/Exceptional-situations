import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test

    public void successOfDeletingAnExistingElement() { // Успешное удаление существующего элемента

        Product prod1 = new Product(1, "Заголовок", 2);
        Product prod2 = new Product(2, "Заголовок", 2);
        ShopRepository tmp = new ShopRepository();
        tmp.add(prod1);
        tmp.add(prod2);
        tmp.remove(2);

        Product[] expected = {prod1};
        Product[] actual = tmp.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void deletingANonExistingElement() { // Не существующий элемент удаление

        ShopRepository tmp = new ShopRepository();
        Assertions.assertThrows(NotFoundException.class, () -> {
            tmp.remove(0);
        });
    }


    @Test

    public void throwingNotFoundException() { //генерация отчета

        Product prod1 = new Product(1, "Заголовок", 2);
        Product prod2 = new Product(2, "Заголовок", 2);
        ShopRepository tmp = new ShopRepository();
        tmp.add(prod1);
        tmp.add(prod2);
        Assertions.assertThrows(NotFoundException.class, () -> {
            tmp.remove(4);
        });

    }

    @Test
    public void addingTheSameId() { // ИД совпадают

        Product prod1 = new Product(1, "Заголовок", 2);
        Product prod2 = new Product(2, "Заголовок", 2);
        Product prod3 = new Product(2, "Заголовок", 2);
        ShopRepository tmp = new ShopRepository();
        tmp.add(prod1);
        tmp.add(prod2);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            tmp.add(prod3);
        });
    }


    @Test
    public void addElement() { // добавление элемента в массив

        Product prod1 = new Product(1, "Заголовок", 10);
        ShopRepository repo = new ShopRepository();
        repo.add(prod1);
        Product[] expected = {prod1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

}
