package homework6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Создание класса Laptop
public class Laptop {
    // Создание поля на основе другого класса
    private List<Brand> brands;
    // Создание полей
    private String model;
    private float diagonal;
    private String screenResolution;
    private boolean dvdRom;
    private int hardDisk;
    private String operativeMemory;
    private String operatingSystem;
    private String color;
    // Создание пустого конструктора для работы с методами
    public Laptop() {
    }
    // Создание конструктора для создания экземпляров класса
    public Laptop(String model, float diagonal, String screenResolution, boolean dvdRom, int hardDisk,
                  String operativeMemory, String operatingSystem, String color) {
        this.brands = new ArrayList<>();
        this.model = model;
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.dvdRom = dvdRom;
        this.hardDisk = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    // Создание методов get\set Для работы с private полями
    public String getModel() {return model;}
    public float getDiagonal() {return diagonal;}
    public String getScreenResolution() {return screenResolution;}
    public String isDvdRom() {String dvd = "";
        if (dvdRom) {
            dvd = "есть";
        }else{
            dvd = "нет";}
        return dvd;
    }
    public int getHardDisk() {return hardDisk;}
    public String getOperativeMemory() {return operativeMemory;}
    public String getOperatingSystem() {return operatingSystem;}
    public String getColor() {return color;}
    // Создание метода для создания экземпляра другого класса
    public void addBrand(Brand brand) {
        brands.add(brand);
    }
    // создание метода фильтрации ноутбуков по всем критериям
    public List<Laptop> filter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Здравствуйте, Укажите параметры для ноутбука: " +
                "\nУкажите размер жёсткого диска в гб (300,500,600,700,1000):");
        String enterHardDisk = scan.nextLine();
        int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
        System.out.println("Укажите количество оперативной памяти в Гб (4, 8, 16):");
        String enterOperativeMemory = scan.nextLine();
        System.out.println("Укажите операционную систему (Linux, ios, Windows):");
        String enterOperatingSystem = scan.nextLine();
        System.out.println("Укажите цвет ноутбука (black, white):");
        String enterColor = scan.nextLine();

        List<Laptop> listLaptop = new ArrayList<>();
        for (Laptop tempLaptop : laptop) {
            if (intParseEnterHardDisk == tempLaptop.hardDisk) {
                if (enterOperativeMemory.equals(tempLaptop.operativeMemory)) {
                    if (enterOperatingSystem.equals(tempLaptop.operatingSystem)) {
                        if (enterColor.equals(tempLaptop.color)) {
                            listLaptop.add(tempLaptop);
                        }
                    }
                }
            }
        }
        return listLaptop;
    }

    // создание метода фильтрации ноутбуков по выбранным критериям
    public Set<Laptop> newFilter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println("""
                Здравствуйте. Выберите критерии фильтрации ноутбуков:
                1. Размер жесткого диска
                2. Объем оперативной памяти
                3. Операционная система
                4. Цвет""");
        String userRequest = scan.nextLine();

        for (int i = 0; i < userRequest.length(); i++) {
            if(1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите размер жёсткого диска в Гб (300,500,600,700,1000):");
                String enterHardDisk = scan.nextLine();
                int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
                for (Laptop tempLaptop : laptop) {
                    if (intParseEnterHardDisk != tempLaptop.hardDisk){
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(2 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите количество оперативной памяти в Гб (4, 8, 16):");
                String enterOperativeMemory = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if (!(enterOperativeMemory.equals(tempLaptop.operativeMemory))) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(3 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите операционную систему (Linux, ios, Windows):");
                String enterOperatingSystem = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((!enterOperatingSystem.equals(tempLaptop.operatingSystem))) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(4 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите цвет ноутбука (black, white):");
                String enterColor = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if (!(enterColor.equals(tempLaptop.color))) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        return listLaptop;
    }

    // метод toString, выводит на экран данные объекта
    @Override
    public String toString() {
        return "\nНоутбук  ->  " + model + "\nБрэнд = " + brands + ",\nДиагональ экрана = " + diagonal + ",\nРазрешение матрицы = "
                + screenResolution
                + ",\nПривод = " + dvdRom + ",\nЖесткий диск = " + hardDisk + ",\nОперативная память = " + operativeMemory
                + ",\nОперационная система = " + operatingSystem + ",\nЦвет = " + color + "\n";
    }

}