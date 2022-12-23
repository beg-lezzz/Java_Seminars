import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private String name;
    private Integer volume;
    private List<Human> treeElements = new ArrayList<>();

    private Writable filehandler;

    public FamilyTree(String name) {
        this.name = name;
        this.volume = 0;
    }

    public FamilyTree(String name, List<Human> humans) {
        this(name);
        this.volume = humans.size();
        for (Human human : humans) {
            this.treeElements.add(human);
        }
    }

    public void addHuman(Human human){
        this.treeElements.add(human);
        this.volume++;

//        List<Human> byMother = human.getMother() != null ? human.getMother().getChildren() : null;
//        List<Human> byFather = human.getFather() != null ? human.getFather().getChildren() : null;
//
//        if (byFather != null) {
//            int flag = 0;
//            for (Human hum : byFather) {
//                if (hum.getFullName().equals(human.getFullName())) {
//                    flag++;
//                }
//            }
//            if (flag != 0){
//                human.getFather().addChild();
//            }
//        }
//
//        if (byMother != null) {
//            int flag = 0;
//            for (Human hum : byMother) {
//                if (hum.getFullName().equals(human.getFullName())) {
//                    flag++;
//                }
//            }
//            if (flag != 0){
//                human.getMother().addChild();
//            }
//        }
    }

    @Override
    public String toString() {
        StringBuilder humansForPrint = new StringBuilder();
        for (Human person : treeElements) {
            humansForPrint.append("\n").append(person);
            if (person.getMother() != null) {
                humansForPrint.append(", мать: ").append(person.getMother().getFullName());
            } else humansForPrint.append(", мать: ").append("Не указано");
            if (person.getFather() != null) {
                humansForPrint.append(", отец: ").append(person.getFather().getFullName());
            } else humansForPrint.append(", отец: ").append("Не указано");
            if (person.getChildren().size() !=0){
                humansForPrint.append(", дети: ");
                for (Human child : person.getChildren()) {
                    humansForPrint.append(child.getFullName()).append(", ");
                }
                humansForPrint.deleteCharAt(humansForPrint.length() - 2);
            } else humansForPrint.append(", дети: Не указано");
        }
        return "Семейное дерево " + name +
                " cостоит из " + volume + " " + countPostfix(volume) + ":" +
                humansForPrint;
    }

    public void findByName(String name){
        for (Human human : this.treeElements) {
            if (human.getFullName().equalsIgnoreCase(name)) {
                System.out.println(human);
            }
        }
    }

    public void save() throws IOException {
        try {
            File tree = new File("calc.log");
            tree.createNewFile();
        } catch (IOException e) {
            System.out.println("Упс. Что-то пошло не так. Не удалось обратиться к файлу.");
            e.printStackTrace();
        }

        Path path = Paths.get("calc.log");
        String str = this.toString();

        Files.write(path, str.getBytes(), StandardOpenOption.APPEND);


//        if (logType == 1) {
//            logMessage = LocalDateTime.now() + "\t" + logMessage + "\t(отменено пользователем)" + "\n";
//        } else {
//            logMessage = LocalDateTime.now() + "\t" +logMessage + "\n";
//        }
//
//
//        Path path = Paths.get("calc.log");
//
//        try {
//            Files.write(path, logMessage.getBytes(), StandardOpenOption.APPEND);
//            System.out.println("\nЭто успех. Все ходы записаны.");
//        } catch (IOException e) {
//            System.out.println("Упс. Что-то пошло не так. Лог не записан.");
//            e.printStackTrace();
//        }
    }

    public static String countPostfix(int num)
    {
        String result = null;
        if(num == 11) result = "человек";
        else if(("" + num).endsWith("1")) result = "человека";
        else if(num > 11 && num < 15) result = "человек";
        else if(num % 10 > 1 && num % 10 < 5) result = "человек";
        else result = "человек";

        return result;
    }
}