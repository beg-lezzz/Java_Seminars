public class Main {
    public static void main(String[] args) {

        Human Ivan = new Human("Ivan", Human.Gender.Male, 25);
        Human Olga = new Human("Olga", Human.Gender.Female, 27);
        Human Pavel = new Human("Pavel", Human.Gender.Male, 1, Olga);
        System.out.println(Pavel);
        System.out.println(Olga);
        System.out.println(Ivan);
        Pavel.setFather(Ivan);
        System.out.println(Pavel.getFather());
        System.out.println();
        Pavel.setFather(Ivan);
        System.out.println();
        System.out.println(Pavel.getChildren());

        FamilyTree Ivanov = new FamilyTree("Ivanov");
        Ivanov.addHuman(Olga);
        Ivanov.addHuman(Pavel);
        Ivanov.addHuman(Ivan);
        System.out.println(Ivanov);
//        System.out.println();
//        System.out.println(Ivan.getChildren());
//        System.out.println();
//        System.out.println(Olga.getChildren());
//        Ivan.setMother(Olga);
//        System.out.println(Pavel.getFather());
//        System.out.println();
//        System.out.println(Ivan.getChildren());
//        System.out.println();
//        System.out.println(Olga.getChildren());
    }
}