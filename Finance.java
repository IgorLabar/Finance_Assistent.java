import java.util.Scanner;

class Finance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] expenses = new double[7];

        double rateUSD = 54.50;
        double rateEUR = 58.98;
        double rateJPY = 0.40;

        System.out.println("Здравствуйте, я Ваш финансовый помощник Бит, давайте познакомимся.");
        System.out.println("Введите Ваше имя:");
        String nameUser = scanner.nextLine();

        System.out.println("Очень приятно "+ nameUser);

        System.out.println("Сколько у Вас осталось денег?");
        double remainingMoney = scanner.nextDouble();

        System.out.println("Сколкьо осталось дней до зарплаты?");
        int payday = scanner.nextInt();

        while (true) {
            System.out.println("Что Вы хотите сделать?");
            System.out.println("1 - Получить совет.");
            System.out.println("2 - Конвертировать валюту.");
            System.out.println("3 - Ввести трату");
            System.out.println("4 - Показать траты за неделю");
            System.out.println("5 - Показать самую большую сумму расходов за неделю");
            System.out.println("6 - Отложить на цель.");
            System.out.println("0 - Выход.");

            int command = scanner.nextInt();

            if (command == 1) {
                if (remainingMoney < 3000) {
                    System.out.println("Сегодня лучше быть экономным и посидеть дома.");
                } else if (remainingMoney < 10000) {
                    if (payday < 10) {
                        System.out.println("Можете сходить в мак!");
                    } else {
                        System.out.println("Сегодня лучше быть экономным и посидеть дома.");
                    }
                } else if (remainingMoney < 30000) {
                    if (payday < 10) {
                        System.out.println("У Вас хорошо получается экономить, можете прикупить себе акции!");
                    } else {
                        System.out.println("Сходите в мак!");
                    }
                } else {
                    if (payday < 10) {
                        System.out.println("Прикупите доллары и пару акций крупных компаний!");
                    } else {
                        System.out.println("У Вас хорошо получается сохранять деньги, сходите в ресторан или закажите суши!");
                    }
                }
            } else if (command == 2) {
                System.out.println("Ваши сбережения: " + remainingMoney + " RUB.");
                System.out.println("В какую валюту хотите конвертировать? Доступные валюты: 1 - USD, 2 - EUR, 3 - JPY.");
                int currency = scanner.nextInt();
                if (currency == 1) {
                    System.out.println("Ваши сбережения в долларах: " + remainingMoney / rateUSD);
                } else if (currency == 2) {
                    System.out.println("Ваши сбережения в евро: " + remainingMoney / rateEUR);
                } else if (currency == 3) {
                    System.out.println("Ваши сбережения в йенах: " + remainingMoney / rateJPY);
                } else {
                    System.out.println("Неизвестная валюта.");
                }
            } else if (command == 3) {
                System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
                int day = scanner.nextInt();
                System.out.println("Введите размер траты:");
                double expense = scanner.nextDouble();
                remainingMoney = remainingMoney - expense;
                expenses[day -1] = expenses[day -1] + expense;
                System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + remainingMoney);
                if (remainingMoney < 1000){
                    System.out.println("У вас осталось совсем мало денег.");
                }
            }else if (command == 6) {
                System.out.println("Введите сумму, которую Вы хотите накопить:");
                int accumulation = scanner.nextInt(); // финансовая цель, которую пользователь ввел.
                System.out.println("Введите сумму, которую Вы можете откладыаать в месяц:");
                int monthPay = scanner.nextInt(); // ежемесячные откладывание.
                int accumulationTotal = 0;
                int month = -1;
                while (accumulationTotal <= accumulation) {
                    accumulationTotal = accumulationTotal + monthPay;
                    month = month + 1;
                }
                System.out.println("Если Вы будете откладывать ежемесячно: " + monthPay + " рублей, то Вы накопите: " + accumulation +
                            " рублей через " + month + " месяцев.");
            } else if (command == 4){
                for (int i = 0; i < expenses.length; i++) {
                    System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
                }
            } else if (command == 5) {
                double maxExpense = 0;
                for (int i =0; i <expenses.length; i++) {
                    if (expenses[i] > maxExpense) {
                        maxExpense = expenses[i];
                    }
                }
                System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");
            } else if (command == 0) {
                System.out.println("До скорой встречи.");
                break;
            } else {
                System.out.println("Такой команды не существует.");
            }
        }
    }
}