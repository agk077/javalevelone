package ru.geekbrains.agk077.javalevelone.lesson05;
/*
    Created by agk077@ya.ru (tango!) 09.11.2020
    Домашнее задание к уроку 5, Java уровень 1
 */

import java.util.Calendar;

/*
Предисловие:
не могу сказать, что я отчётливо понял задание со свёздочкой, не смотря на то, что два раза про него спрашивал.
В итоге решил:
 - реализовывать только те геттеры и сеттеры которые необходимы впоследствии для работы с классом/объектами класса;
 - дополнить задание функцией, через которую можно получить текущий стаж работы сотрудника,
 использовал только год, для упрощения.
 */

// Task 1: Создать класс Сотрудник
public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    private int startWorkingYear;   // вводим аттрибут для реализации дополнительной логики

    // Task 2: Констуктор класса должен заполнять поля по указанному списку
    public Employee (String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setStartWorkingYear(int startWorkingYear) {
        this.startWorkingYear = startWorkingYear;
    }

    public int getWorkExperience () {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        // Если до этого не было установлено года начала работы, то считаем его текущим
        if(startWorkingYear == 0)
            this.startWorkingYear = currentYear;
        return currentYear - startWorkingYear;
    }

    // Task 3: Написать метод, который выводит информацию об объекте в консоль
    public void showInfo() {
        System.out.println("ФИО: " + this.fullName + ", " +
                "Должность: " + this.position + ", " +
                "E-mail: " + this.email + ", " +
                "Телефон: " + this.phone + ", " +
                "Зарплата: " + this.salary + ", " +
                "Возраст: " + this.age);
    }

    public static void main(String[] args) {

        // Task 4: Создать массив из 5 сотрудников
        Employee[] personArray = new Employee[5];
        personArray[0] = new Employee("Абрамович ИГ", "разработчик", "abramig@ya.ru",
                "+79660430115", 100000, 42);
        personArray[1] = new Employee("Куанова ГТ", "Ген директор", "kuan_gt@yandex.ru",
                "+79519901882", 150000, 55);
        personArray[2] = new Employee("Повилица ДА", "Мастер участка", "povelitsa@rambler.ru",
                "+79519832909", 60000, 45);
        personArray[3] = new Employee("Харченко ОЛ", "Специалист отдела ЖКХ", "harchenko@mail.ru",
                "+79220901973", 35000, 28);
        personArray[4] = new Employee("Ярослов ВЮ", "Слесарь-сантехник", "n/a",
                "+79220591228", 55000, 35);

        // Task 5: С помощью цикла вывести только сотрудников старше 40
        for (Employee emp : personArray) {
            if (emp.getAge() >= 40) emp.showInfo();
        }

        // Task вне плана: дополнительный скрытый аттрибут,
        // который хранит год начала работы в качестве сотрудника
        personArray[0].setStartWorkingYear(2015);
        System.out.println("Сотрудник: " + personArray[0].getFullName() +
                ", cтаж работы на текущем месте: " + personArray[0].getWorkExperience() + " лет");
        System.out.println("Сотрудник: " + personArray[1].getFullName() +
                ", cтаж работы на текущем месте: " + personArray[1].getWorkExperience() + " лет");
    }
}
