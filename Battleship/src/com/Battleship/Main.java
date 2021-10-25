package com.Battleship;

import java.util.*;

public class Main {
    /**
     * Метод вывода консольных сообщений с туториалом.
     */
    public static void startingOutput() {
        System.out.println("Admiral, you need to produce a plan of an oncoming fight.");
        System.out.println("Here`s a little introduction.");
        System.out.println("It seems like you want to enter the size of the Ocean and number of ships by a console.");
        System.out.println("Firstly, enter the size of the Ocean.");
        System.out.println("It should be entered as two numbers separated with a whitespace.");
        System.out.println("The value should vary from 1 to 20.");
        System.out.println("If you enter not an integer or a number beyond the borders, program will automatically assign 2 as a default value.");
        System.out.println("After that enter the types of ships. There are five of them:");
        System.out.println("1. Submarine");
        System.out.println("2. Destroyer");
        System.out.println("3. Cruiser");
        System.out.println("4. Battleship");
        System.out.println("5. Carrier");
        System.out.println("The number of a certain type can be a zero or higher, but if you enter too many ships, you will be asked to re-enter them.");
        System.out.println("If you enter a non-integer type, the system will automatically restart entering");
        System.out.println("Now enter the size of the Ocean. At first, for X-axis, and then for Y-axis");
    }

    /**
     * Метод ввода из консоли.
     *
     * @param shipTypes Массив с кол-вом кораблей разных типов.
     * @param axis      Массив с кол-вом клеток для каждой из осей.
     * @param torpedoes Кол-во кораблей.
     */
    public static void firstInput(int[] shipTypes, int[] axis, int[] torpedoes) {
        try {
            Scanner sc = new Scanner(System.in);
            axis[0] = sc.nextInt();
            axis[1] = sc.nextInt();
            // Проверка корректности ввода.
            if (axis[0] > 20 | axis[0] < 1 | axis[1] > 20 | axis[1] < 1) {
                throw new Exception("");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("What are you doing? It`s not a game, stop joking!");
            System.out.println("X-axis and Y-axis values are now 2.");
            axis[0] = 2;
            axis[1] = 2;
        } catch (Exception e) {
            System.out.println("That input was incorrect. X-axis and Y-axis values are now 2.");
            axis[0] = 2;
            axis[1] = 2;
        }
        System.out.println("Now enter the ship types starting from one-deck to five-deck. Separate them with the whitespace.");
        Boolean checker = false;
        while (checker != true) {
            try {
                Scanner sc = new Scanner(System.in);
                shipTypes[0] = sc.nextInt();
                shipTypes[1] = sc.nextInt();
                shipTypes[2] = sc.nextInt();
                shipTypes[3] = sc.nextInt();
                shipTypes[4] = sc.nextInt();
                // Проверка корректности ввода.
                if (shipTypes[0] < 0 | shipTypes[1] < 0 | shipTypes[2] < 0 | shipTypes[3] < 0 | shipTypes[4] < 0) {
                    System.out.println("You`ve entered incorrect value.");
                    throw new Exception("");
                }
                // Проверка на соответствие абсолютных площадей.
                // Абсолютная площадь корабля - его клетки и клетки вокруг него.
                // Абсолютная площадь поля - его клетки и рамка вокруг него.
                if (shipTypes[0] * 9 + shipTypes[1] * 12 + shipTypes[2] * 15 + shipTypes[3] * 18 + shipTypes[4] * 21 > (axis[0] + 2) * (axis[1] + 2)) {
                    System.out.println("You`ve entered too many ships. It will be impossible or simply boring to play.");
                    throw new Exception("");
                }
                checker = true;
            } catch (Exception e) {
                System.out.println("Please re-enter the ship types number.");
            }
        }
        if (shipNumber(shipTypes)==0){
            System.out.println("Admiral, there were no enemy ships in your plan. I`ve added a 1-deck ship.");
            shipTypes[0]++;
        }
        // У меня в половине мест падало из-за того, что передаваемое значение долго путешествовало из метода в метод.
        // небольшая перестраховка.
        torpedoes = torpedoesInput(torpedoes);
    }

    /**
     * Ввод торпед.
     *
     * @param torpedoes Кол-во торпед.
     * @return Кол-во торпед(обновлённое).
     */
    public static int[] torpedoesInput(int[] torpedoes) {
        try {
            System.out.println("Now enter the number of torpedoes, if you need such a pittance.");
            System.out.println("If you are strong enough to avoid using them, enter 0.");
            System.out.println("Now enter the integer from 0 to 5. In case of incorrect input default value will be 0.");
            Scanner sc = new Scanner(System.in);
            torpedoes[0] = sc.nextInt();
            if (torpedoes[0] < 0 | torpedoes[0] > 5) {
                System.out.println("You`ve entered incorrect number of torpedoes, admiral.");
                torpedoes[0] = 0;
                throw new Exception("");
            }

        } catch (java.util.InputMismatchException eee) {
            System.out.println("You have a bad sense of humor, Admiral..");
            System.out.println("There are no torpedoes available now.");
            torpedoes[0] = 0;
        } catch (Exception ee) {
            System.out.println("There are no torpedoes available now.");
            torpedoes[0] = 0;
        }
        return torpedoes;
    }

    /**
     * Ввод из командной строки.
     *
     * @param args      Массив с данными из cmd.
     * @param shipTypes Массив с кол-вом кораблей разных типов.
     * @param axis      Массив с кол-вом клеток на каждой оси.
     * @param torpedoes Кол-во торпед.
     */
    public static void secondInput(String[] args, int[] shipTypes, int[] axis, int[] torpedoes) {
        // Здесь все проверки аналогичны консольному вводу.
        try {
            axis[0] = Integer.parseInt(args[0]);
            axis[1] = Integer.parseInt(args[1]);
            shipTypes[0] = Integer.parseInt(args[2]);
            shipTypes[1] = Integer.parseInt(args[3]);
            shipTypes[2] = Integer.parseInt(args[4]);
            shipTypes[3] = Integer.parseInt(args[5]);
            shipTypes[4] = Integer.parseInt(args[6]);
            torpedoes[0] = Integer.parseInt(args[7]);
            if (shipTypes[0] < 0 | shipTypes[1] < 0 | shipTypes[2] < 0 | shipTypes[3] < 0 | shipTypes[4] < 0) {
                System.out.println();
                System.out.println("You`ve entered incorrect value.");
                throw new Exception("");

            }
            if (shipTypes[0] * 9 + shipTypes[1] * 12 + shipTypes[2] * 15 + shipTypes[3] * 18 + shipTypes[4] * 21 > (axis[0] + 2) * (axis[1] + 2)) {
                System.out.println();
                System.out.println("You`ve entered too many ships. It will be impossible or simply boring to play.");
                throw new Exception("");
            }
            if (torpedoes[0] < 0 | torpedoes[0] > 5) {
                System.out.println("You`ve entered incorrect number of torpedoes, admiral.");
                throw new Exception("");
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("The data was incorrect. Please retry with console input.");
            startingOutput();
            firstInput(shipTypes, axis, torpedoes);
        }
    }

    /**
     * Метод перевведения кораблей.
     *
     * @param shipTypes Массив с кол-вом кораблей разных типов.
     * @param y         Кол-во горизонтальных клеток.
     * @param x         Кол-во вертикальных клеток.
     */
    public static void reEntering(int[] shipTypes, int y, int x) {
        // Аналогичные проверки.
        System.out.println("Now enter the ship types starting from one-deck to five-deck. Separate them with the whitespace.");
        Boolean checker = false;
        while (checker != true) {
            try {
                Scanner sc = new Scanner(System.in);
                shipTypes[0] = sc.nextInt();
                shipTypes[1] = sc.nextInt();
                shipTypes[2] = sc.nextInt();
                shipTypes[3] = sc.nextInt();
                shipTypes[4] = sc.nextInt();
                if (shipTypes[0] < 0 | shipTypes[1] < 0 | shipTypes[2] < 0 | shipTypes[3] < 0 | shipTypes[4] < 0) {
                    System.out.println("You`ve entered incorrect value.");
                    throw new Exception("");
                }
                if (shipTypes[0] * 9 + shipTypes[1] * 12 + shipTypes[2] * 15 + shipTypes[3] * 18 + shipTypes[4] * 21 > (x + 2) * (y + 2)) {
                    System.out.println("You`ve entered too many ships. It will be impossible or simply boring to play.");
                    throw new Exception("");
                }
                checker = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Are you serious? Oh, God, we`re gonna die~");
            } catch (Exception e) {
                System.out.println("Re-enter the ship types number immediately, or enemy fleet will regroup.");
            }
        }
    }

    /**
     * Метод заполнения массива с координатами.
     *
     * @param randomizing Массив с координатами.
     * @param cells       Поле для игры.
     */
    public static void fillTheCoords(ArrayList<Coordinate> randomizing, Cell[][] cells) {
        for (int i = 1; i <= cells.length - 2; i++) {
            for (int j = 1; j <= cells[0].length - 2; j++) {
                randomizing.add(new Coordinate(i, j));
            }
        }
    }

    /**
     * Метод подсчёта кораблей.
     *
     * @param tempShips Массив с кол-вом кораблей разных типов.
     * @return Кол-во кораблей.
     */
    public static int shipNumber(int[] tempShips) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            counter += tempShips[i];
        }
        return counter;
    }

    /**
     * Метод генерации размещения кораблей на поле..
     *
     * @param shipTypes Массив с кол-вом кораблей разных типа.
     * @param cells     Поле для игры.
     * @return Поле с кораблями.
     */
    public static Cell[][] generateTheField(int[] shipTypes, Cell[][] cells) {
        // Счётчики кол-ва попыток размещения.
        int shipIterator = 0, fieldIterator = 0;
        ArrayList<Coordinate> randomizing = new ArrayList<Coordinate>();
        fillTheCoords(randomizing, cells);
        Random random = new Random();
        int[] tempShips = shipTypes.clone();
        int checker = 4;
        while (checker >= 0) {
            if (tempShips[checker] == 0) {
                checker--;
            } else {
                // Выбираем случайную координату из списка координат.
                int pos = random.nextInt(randomizing.size());
                // Случайное направление.
                int dir = random.nextInt(2);
                Coordinate coord = randomizing.get(pos);
                boolean check = false;
                if (dir == 0) {
                    check = placeHorizontally(coord, cells, checker + 1);
                    if (check == false) {
                        check = placeVertically(coord, cells, checker + 1);
                        dir = 1;
                    }
                } else {
                    check = placeVertically(coord, cells, checker + 1);
                    if (check == false) {
                        check = placeHorizontally(coord, cells, checker + 1);
                        dir = 0;
                    }
                }
                if (check == true) {
                    placeTheShip(dir, coord, cells, checker + 1, randomizing);
                    tempShips[checker]--;
                    shipIterator = 0;
                } else {
                    shipIterator++;
                }
                // Если попыток размещения корабля больше сотни - попробуем расставить с нуля.
                // Вдруг какой корабль неудачно встал?
                if (shipIterator == 100 | randomizing.size() == 0 & shipNumber(tempShips) > 0) {
                    cells = oceanCreator(cells.length - 2, cells[0].length - 2);
                    randomizing.clear();
                    fillTheCoords(randomizing, cells);
                    fieldIterator++;
                    checker = 4;
                    tempShips = shipTypes.clone();
                }
                // И если вдруг все 100 раз у нас не получилось разместить - перевведём данные.
                if (fieldIterator == 100) {
                    System.out.println("Seems that we cannot place all the ships because of their number.");
                    System.out.println("Please re-enter the ship types.");
                    reEntering(shipTypes, cells.length - 2, cells[0].length - 2);
                    cells = oceanCreator(cells.length - 2, cells[0].length - 2);
                    randomizing = new ArrayList<Coordinate>();
                    fillTheCoords(randomizing, cells);
                    tempShips = shipTypes.clone();
                    fieldIterator = 0;
                    shipIterator = 0;
                    checker = 4;
                }
            }
        }
        return cells;
    }

    /**
     * Метод размещения корабля.
     *
     * @param dir         Направление.
     * @param coord       Стартовая координата.
     * @param cells       Поле для игры.
     * @param decks       Кол-во палуб.
     * @param randomizing Кол-во оставшихся координат.
     */
    public static void placeTheShip(int dir, Coordinate coord, Cell[][] cells, int decks, ArrayList<Coordinate> randomizing) {
        Ship ship = null;
        switch (decks) {
            case 1:
                ship = new Submarine();
                break;
            case 2:
                ship = new Destroyer();
                break;
            case 3:
                ship = new Cruiser();
                break;
            case 4:
                ship = new Battleship();
                break;
            case 5:
                ship = new Carrier();
                break;
        }
        ship.firstCoordinate.x = coord.x;
        ship.firstCoordinate.y = coord.y;
        // Удалим не только клетки корабля, но и клетки вокруг него.
        if (dir == 0) {
            ship.direction = "hor";
            for (int i = coord.x; i < coord.x + decks; i++) {
                cells[coord.y][i].ship = ship;
                cells[coord.y][i].shipStatus = HasShip.YES;
            }
            for (int i = coord.x - 1; i < coord.x + decks + 1; i++) {
                randomizing.remove(new Coordinate(coord.y, i));
                randomizing.remove(new Coordinate(coord.y + 1, i));
                randomizing.remove(new Coordinate(coord.y - 1, i));
            }
        } else {
            ship.direction = "ver";
            for (int i = coord.y; i < coord.y + decks; i++) {
                cells[i][coord.x].ship = ship;
                cells[i][coord.x].shipStatus = HasShip.YES;
            }
            for (int i = coord.y - 1; i < coord.y + decks + 1; i++) {
                randomizing.remove(new Coordinate(i, coord.x));
                randomizing.remove(new Coordinate(i, coord.x - 1));
                randomizing.remove(new Coordinate(i, coord.x + 1));
            }
        }
    }

    /**
     * Метод проверки возможности горизонтального размещения.
     *
     * @param coor  Начальная координата.
     * @param cells Поле для игры.
     * @param decks Кол-во палуб у корабля.
     * @return Возможность размещения.
     */
    public static boolean placeHorizontally(Coordinate coor, Cell[][] cells, int decks) {
        boolean checker = true;
        if (coor.x + decks - 1 > cells[0].length - 2) {
            return false;
        }
        // Условие включает себя и невозможность расстановки "бок о бок".
        for (int i = coor.x - 1; i < coor.x + decks + 1; i++) {
            if (cells[coor.y][i].shipStatus == HasShip.YES | cells[coor.y + 1][i].shipStatus == HasShip.YES | cells[coor.y - 1][i].shipStatus == HasShip.YES) {
                checker = false;
            }
        }
        return checker;
    }

    /**
     * Метод проверки возможности вертикального размещения.
     *
     * @param coor  Начальная координата.
     * @param cells Поле для игры.
     * @param decks Кол-во палуб у корабля.
     * @return Возможность размещения.
     */
    public static boolean placeVertically(Coordinate coor, Cell[][] cells, int decks) {
        // Аналогично.
        boolean checker = true;
        if (coor.y + decks - 1 > cells.length - 2) {
            return false;
        }
        for (int i = coor.y - 1; i < coor.y + decks + 1; i++) {
            if (cells[i][coor.x].shipStatus == HasShip.YES | cells[i][coor.x + 1].shipStatus == HasShip.YES | cells[i][coor.x - 1].shipStatus == HasShip.YES) {
                checker = false;
            }
        }
        return checker;
    }

    /**
     * Метод создания или пересоздания поля.
     *
     * @param x Кол-во вертикальных клеток.
     * @param y Кол-во горизонтальных клеток.
     * @return Созданное поле.
     */
    public static Cell[][] oceanCreator(int x, int y) {
        Cell[][] cells = new Cell[y + 2][x + 2];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell();
            }
        }
        return cells;
    }

    /**
     * Метод вывода игрового поля.
     *
     * @param cells Поле для игры.
     */
    public static void printTheField(Cell[][] cells) {
        for (int i = 1; i < cells.length - 1; i++) {
            for (int j = 1; j < cells[0].length - 1; j++) {
                if (cells[i][j].shotStatus == WasShot.NO) {
                    System.out.print("0 ");
                } else if (cells[i][j].shipStatus == HasShip.YES & cells[i][j].sunkStatus == WasSunk.NO) {
                    System.out.print("2 ");
                } else if (cells[i][j].shipStatus == HasShip.YES & cells[i][j].sunkStatus == WasSunk.YES) {
                    if (cells[i][j].torpedoStatus == WasTorpedoed.YES) {
                        System.out.print("T ");
                    } else {
                        System.out.print("3 ");
                    }
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Метод, в котором происходит сама игра.
     *
     * @param cells      Поле для игры.
     * @param shipNumber Количество кораблей.
     * @param torpedoes  Количество торпед.
     */
    public static int gameMode(Cell[][] cells, int shipNumber, int torpedoes) {
        int score = 0;
        System.out.println();
        System.out.println("It`s time to shoot!");
        if (torpedoes > 0) {
            System.out.println("At first enter T, if you want to use a torpedo. In other case enter whatever you want.");
            System.out.println("And new input comes after that!");
        }
        System.out.println("Enter the x-coordinate and the y-coordinate.");
        System.out.println("Divide them them with the whitespace.");
        System.out.println("You cannot shoot any cell twice. ");
        while (shipNumber > 0) {
            System.out.println();
            printTheField(cells);
            System.out.println();
            System.out.println("Admiral, batteries loaded and ready!");
            int x = 0, y = 0;
            String t = "";
            boolean checker = false;
            boolean torpedoChecker = false;
            while (!checker) {
                try {
                    Scanner sc = new Scanner(System.in);
                    if (torpedoes > 0) {
                        System.out.println("Enter the torpedo status!");
                        t = sc.nextLine();
                    }
                    System.out.println("Enter the coordinates!");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    if (Objects.equals("T", t) == true) {
                        torpedoChecker = true;
                    }
                    if (x < 1 | y < 1 | x > cells[0].length - 2 | y > cells.length - 2) {
                        System.out.println();
                        System.out.println("Admiral, we have no such coordinates! Try again!");
                        throw new Exception("");
                    }
                    if (cells[y][x].shotStatus == WasShot.YES) {
                        System.out.println();
                        System.out.println("Admiral, we have already shot there. The ammo costs money! Try again!");
                        throw new Exception("");
                    }
                    checker = true;
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("What is that? We need numbers, not the Mongolian rock lyrics.");
                    System.out.println("Concentrate and get ready. We must win this battle.");
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("Concentrate and get ready. We must win this battle.");
                }
            }
            // Если торпедируем, то один случай, если нет-другой.
            if (torpedoChecker == true) {
                if (torpedoes == 0) {
                    System.out.println("No torpedoes available, Admiral! Use the batteries!");
                } else {
                    cells[y][x].shotStatus = WasShot.YES;
                    cells[y][x].torpedoStatus = WasTorpedoed.YES;
                    if (cells[y][x].shipStatus == HasShip.NO) {
                        System.out.println();
                        System.out.println("We`ve missed, admiral.");
                    } else {
                        cells[y][x].ship.health = 0;
                        cells[y][x].ship.SunkStatus();
                        cells = sinkingUpdate(cells, cells[y][x].ship, true);
                        shipNumber--;
                    }
                    torpedoes--;
                }
            } else {
                cells[y][x].shotStatus = WasShot.YES;
                if (cells[y][x].shipStatus == HasShip.NO) {
                    System.out.println();
                    System.out.println("We`ve missed, admiral.");
                } else {
                    cells[y][x].ship.health--;
                    cells[y][x].ship.SunkStatus();
                    if (cells[y][x].ship.health == 0) {
                        cells[y][x].sunkStatus = WasSunk.YES;
                        cells = sinkingUpdate(cells, cells[y][x].ship, false);
                        shipNumber--;
                    }
                }
            }
            score++;
        }
        printTheField(cells);
        return score;
    }

    /**
     * Метод обновления статуса затопления.
     *
     * @param cells Поле для игры.
     * @param ship  Корабль, для которого происходит обновление.
     * @param torp  Маркер "торпедированности" корабля.
     * @return
     */
    public static Cell[][] sinkingUpdate(Cell[][] cells, Ship ship, boolean torp) {
        int iterator = 0;
        switch (ship.type) {
            case "submarine":
                iterator = 1;
                break;
            case "destroyer":
                iterator = 2;
                break;
            case "cruiser":
                iterator = 3;
                break;
            case "battleship":
                iterator = 4;
                break;
            case "carrier":
                iterator = 5;
                break;
        }
        // Если потопили корабль, то и клетки вокрууг него автоматически вскрываются.
        if (ship.direction == "ver") {
            for (int i = ship.firstCoordinate.y - 1; i < ship.firstCoordinate.y + iterator + 1; i++) {
                cells[i][ship.firstCoordinate.x].shotStatus = WasShot.YES;
                cells[i][ship.firstCoordinate.x + 1].shotStatus = WasShot.YES;
                cells[i][ship.firstCoordinate.x - 1].shotStatus = WasShot.YES;
            }
            for (int i = ship.firstCoordinate.y; i < ship.firstCoordinate.y + iterator; i++) {
                cells[i][ship.firstCoordinate.x].sunkStatus = WasSunk.YES;
                if (torp == true) {
                    cells[i][ship.firstCoordinate.x].torpedoStatus = WasTorpedoed.YES;
                }
            }
        } else {
            for (int i = ship.firstCoordinate.x - 1; i < ship.firstCoordinate.x + iterator + 1; i++) {
                cells[ship.firstCoordinate.y][i].shotStatus = WasShot.YES;
                cells[ship.firstCoordinate.y + 1][i].shotStatus = WasShot.YES;
                cells[ship.firstCoordinate.y - 1][i].shotStatus = WasShot.YES;
            }
            for (int i = ship.firstCoordinate.x; i < ship.firstCoordinate.x + iterator; i++) {
                cells[ship.firstCoordinate.y][i].sunkStatus = WasSunk.YES;
                if (torp == true) {
                    cells[ship.firstCoordinate.y][i].torpedoStatus = WasTorpedoed.YES;
                }
            }
        }
        return cells;
    }

    /**
     * Метод показа расстановки кораблей на поле.
     *
     * @param cells Поле для игры.
     */
    public static void printTheShip(Cell[][] cells) {
        for (int i = 1; i < cells.length - 1; i++) {
            for (int j = 1; j < cells[0].length - 1; j++) {
                if (cells[i][j].shipStatus == HasShip.YES) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Метод подсчёта лучшего счёта.
     *
     * @param ships Массив с кол-вом кораблей разных типов.
     * @return Наилучший счёт.
     */
    public static int bestScore(int[] ships) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            counter += (i + 1) * ships[i];
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("Admiral! No time to waste! Our planes have spotted the enemy fleet coming. We`re moving out!");
        System.out.println();
        int[] shipTypes = new int[5];
        int[] axis = new int[2];
        int[] torpedoes = new int[1];
        if (args.length != 8) {
            startingOutput();
            firstInput(shipTypes, axis, torpedoes);
        } else {
            System.out.println("You have chosen input by a command line. A choice of a real sea wolf.");
            secondInput(args, shipTypes, axis, torpedoes);
        }
        Cell[][] cells = oceanCreator(axis[0], axis[1]);
        cells = generateTheField(shipTypes, cells);
        // Метод для отображения кораблей на случай, если вам лень отыгрывать поле 20*20. Своего рода чит-код.
        //printTheShip(cells);
        System.out.println();
        System.out.println("All hands on deck! We enter the fray!");
        int score = gameMode(cells, shipNumber(shipTypes), torpedoes[0]);
        System.out.println();
        System.out.println("Wow! Seems like you finished that cowards. Move towards the Empire Bay. We`re going home, boys!");
        System.out.println();
        if (score <= bestScore(shipTypes)) {
            System.out.printf("Perfectly! This going down in history! You showed the best score! It`s %s! \n", score);
        } else {
            System.out.printf("Not bad! You`re score is %s. \n", score);
        }
    }
}
