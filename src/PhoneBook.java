import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем телефонную книгу
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи
        addContact(phoneBook, "Иван", "123456789");
        addContact(phoneBook, "Алена", "987654321");
        addContact(phoneBook, "Иван", "555555555");
        addContact(phoneBook, "Алена", "111111111");
        addContact(phoneBook, "Дима", "333333333");

        // Выводим отсортированные записи
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт с таким именем уже существует, добавляем новый номер в список
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для вывода отсортированных записей телефонной книги
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей для сортировки
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
