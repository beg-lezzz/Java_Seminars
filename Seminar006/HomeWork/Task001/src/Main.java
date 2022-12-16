public class Main {
    public static void main(String[] args) {
        NoteBook noteBook1 = new NoteBook(1, 256, 500, "HP", "Pavilion",
                "Windows 7", "black");
        NoteBook noteBook2 = new NoteBook(1, 512, 1000, "Lenovo", "P3120",
                "Windows 10", "white");
        NoteBook noteBook3 = new NoteBook(1, 1024, 250, "Asus", "VivoBook",
                "Windows 11", "gold");
        NoteBook noteBook4 = new NoteBook(1, 1024, 500, "Acer", "Transform",
                "CentOS", "black");
        NoteBook noteBook5 = new NoteBook(1, 2048, 2000, "Apple", "MacBook Air",
                "MacOS", "silver");
        NoteBook noteBook6 = new NoteBook(1, 1024, 2000, "HP", "H128970",
                "Windows 10", "black");
        NoteBook noteBook7 = new NoteBook(1, 512, 500, "Lenovo", "Excite",
                "Windows 11", "red");
        NoteBook noteBook8 = new NoteBook(1, 256, 250, "Asus", "LightView",
                "CentOS", "gold");
        NoteBook noteBook9 = new NoteBook(1, 512, 1000, "Acer", "Z2398",
                "Windows 11", "white");
        NoteBook noteBook10 = new NoteBook(1, 4096, 4000, "Apple", "MacBook Pro",
                "MacOS", "Gold");
        NoteBook noteBook11 = new NoteBook(1, 1024, 1000, "HP", "Quattro",
                "RedHat", "gold");

        NoteBook[] noteBooks = new NoteBook[]{noteBook1, noteBook2, noteBook3, noteBook4, noteBook5, noteBook6, noteBook7, noteBook8, noteBook9, noteBook10, noteBook11};



        System.out.println(NoteBook.getByRam(noteBooks, 512, 1024));
        System.out.println(NoteBook.getByOS(noteBooks, "Windows 11"));
    }
}
