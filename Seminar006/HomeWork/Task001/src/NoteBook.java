import java.util.Arrays;

public class NoteBook {

    private int id, ram, volumeHD;
    private String manufacturer, model, operationSystem, colour;

    public NoteBook(int id, int ram, int volumeHD,
                    String manufacturer, String model, String operationSystem, String colour) {
        this.id = id;
        this.ram = ram;
        this.volumeHD = volumeHD;
        this.manufacturer = manufacturer;
        this.model = model;
        this.operationSystem = operationSystem;
        this.colour = colour;
    }

    public static StringBuilder getByRam(NoteBook[] noteBooks, int min, int max){
        StringBuilder outString = new StringBuilder();
        if (min > max){
            max = min + max;
            min = max - min;
            max = max - min;
        }
        for (NoteBook n : noteBooks) {
            if (n.ram >= min && n.ram <=max){
                outString.append(n).append("\n");
            }
        }
        return outString;
    }

    public static StringBuilder getByHD(NoteBook[] noteBooks, int min, int max){
        StringBuilder outString = new StringBuilder();
        if (min > max){
            max = min + max;
            min = max - min;
            max = max - min;
        }
        for (NoteBook n : noteBooks) {
            if (n.volumeHD >= min && n.volumeHD <=max){
                outString.append(n).append("\n");
            }
        }
        return outString;
    }

    public static StringBuilder getByOS(NoteBook[] noteBooks, String os){
        StringBuilder outString = new StringBuilder();
        for (NoteBook n : noteBooks) {
            if (n.operationSystem.equalsIgnoreCase(os)){
                outString.append(n).append("\n");
            }
        }
        return outString;
    }
    public static StringBuilder getByColour(NoteBook[] noteBooks, String colour){
        StringBuilder outString = new StringBuilder();
        for (NoteBook n : noteBooks) {
            if (n.colour.equalsIgnoreCase(colour)){
                outString.append(n).append("\n");
            }
        }
        return outString;
    }

    @Override
    public String toString() {
        return manufacturer + " " + model
                + ", RAM " + ram + "Mb "
                + ", HD " + volumeHD + "Gb "
                + ", OS " + operationSystem
                + ", Цвет " + colour;
    }
}