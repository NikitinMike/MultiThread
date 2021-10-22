package com.company;

public class Main {// Класс для демонстрации работы потока

  public static void main(String[] args) {
    System.out.println("Начали!"); // Сообщение из главного потока программы
    for (int i = 3; i > 0; i--) {
      // Создаем две очереди
      PeopleQueue queue1 = new PeopleQueue(
          "Иван", "Сергей", "Николай", "Фердинанд", "Василий", "Пётр");
      PeopleQueue queue2 = new PeopleQueue(
          "Мария", "Людмила", "Алиса", "Карина", "Ольга", "Настя");
      queue1.start();    //Запускаем одну очередь (дочерний поток)
      queue2.start(); //Запускаем вторую (дочерний поток)
    }
  }
}

class PeopleQueue extends Thread {

  private final String[] names;

  PeopleQueue(String... names) {
    this.names = names;
  }

  @Override
  public void run() {
    for (String name : names) {
      System.out.println(Thread.currentThread().getName() + " Обработаны документы: " + name);
      try {
        sleep(500); // Задержка в 0.5 сек
      } catch (Exception ignored) {
      }
    }
  }
}

