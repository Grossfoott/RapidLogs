import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

    public static List<String> sortbydate(List<String> lines) {
        List<String> einträge = new ArrayList<>(lines);

        Collections.sort(einträge, new Comparator<String>() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            public int compare(String e1, String e2) {

                String[] parts1 = e1.split(",");
                String[] parts2 = e2.split(",");
                if (parts1.length < 2 || parts2.length < 2) {
                    return 0;
                }
                try {
                    Date date1 = dateFormat.parse(parts1[1]);
                    Date date2 = dateFormat.parse(parts2[1]);
                    return date1.compareTo(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        return einträge;
    }

    private static final String CSV_FILE = "einträge.csv";

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void returnToMenu2(Scanner scanner) {
        System.out.println("Drücken sie enter um ins Menu zurück zu kehren.");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkAndCreateHeader();
        int terminalWidth = 80;

        while (true) {
            System.out.println("                                                      ___._");
            System.out.println("                                                   .'  <0>'-.._");
            System.out.println("                                                  /  /.--.____\")");
            System.out.println("                                                 |   \\   __.-'~");
            System.out.println("                                                 |  :  -' /");
            System.out.println("                                                /:.  :.-'");
            System.out.println("__________                                     | : '. |");
            System.out.println("'--.____  '--------.______       _.----.-----./      :/");
            System.out.println("        '--.__            '----/       '-.      __ :/");
            System.out.println("              '-.___           :           \\   .'  )/");
            System.out.println("                    '---._           _.-'   ] /  _/");
            System.out.println("                         '-._      _/     _/ / _/");
            System.out.println("                             \\_ .-'____.-'__< |  \\___");
            System.out.println("                               <_______.\\    \\_\\_---.7");
            System.out.println("                              |   /'=r_.-'     _\\\\ =/");
            System.out.println("                          .--'   /            ._/'>'");
            System.out.println("                        .'   _.-'");
            System.out.println("                      / .--'");
            System.out.println("                      /,/");
            System.out.println("                      |/)");
            System.out.println("                      'c=,");
            printCentered("==================================", terminalWidth);
            printCentered("Menü", terminalWidth);
            printCentered("==================================", terminalWidth);
            printCentered("1. Eintrag hinzufügen", terminalWidth);
            printCentered("2. Einträge anschauen", terminalWidth);
            printCentered("3. Einträge bearbeiten", terminalWidth);
            printCentered("4. Eintrag suchen", terminalWidth);
            printCentered("5. Eintrag löschen", terminalWidth);
            printCentered("6. Programm beenden", terminalWidth);
            printCentered("==================================", terminalWidth);

            String wahl = scanner.nextLine();

            switch (wahl) {
                case "1":
                    eintraghinzufügen(scanner);
                    break;
                case "2":
                    eintraege(scanner);
                    break;
                case "3":
                    bearbeiten(scanner);
                    break;
                case "4":
                    searchEintrag(scanner);
                    break;
                case "5":
                    eintraglöschen(scanner);
                    break;
                case "6":
                    printCentered(" ______________", terminalWidth);
                    printCentered("|\\ ___________ /|", terminalWidth);
                    printCentered("| |  _ _ _ _  | |", terminalWidth);
                    printCentered("| | | | | | | | |", terminalWidth);
                    printCentered("| | |-+-+-+-| | |", terminalWidth);
                    printCentered("| | |-+-+=+%| | |", terminalWidth);
                    printCentered("| | |_|_|_|_| | |", terminalWidth);
                    printCentered("| |    ___    | |", terminalWidth);
                    printCentered("| |   [___] ()| |", terminalWidth);
                    printCentered("| |         ||| |", terminalWidth);
                    printCentered("| |         ()| |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("|_|___________|_|", terminalWidth);
                    sleep();
                    printCentered("______________", terminalWidth);
                    printCentered("|\\ ___________ /|", terminalWidth);
                    printCentered("| |  /|,| |   | |", terminalWidth);
                    printCentered("| | |,x,| |   | |", terminalWidth);
                    printCentered("| | |,x,' |   | |", terminalWidth);
                    printCentered("| | |,x   ,   | |", terminalWidth);
                    printCentered("| | |/    |%==| |", terminalWidth);
                    printCentered("| |    /] ,   | |", terminalWidth);
                    printCentered("| |   [/ ()   | |", terminalWidth);
                    printCentered("| |       |   | |", terminalWidth);
                    printCentered("| |       |   | |", terminalWidth);
                    printCentered("| |       |   | |", terminalWidth);
                    printCentered("| |      ,'   | |", terminalWidth);
                    printCentered("| |   ,'      | |", terminalWidth);
                    printCentered("|_|,'_________|_|", terminalWidth);
                    sleep();
                    printCentered(" ______________", terminalWidth);
                    printCentered("|\\ ___________ /|", terminalWidth);
                    printCentered("| |  _ _ _ _  | |", terminalWidth);
                    printCentered("| | | | | | | | |", terminalWidth);
                    printCentered("| | |-+-+-+-| | |", terminalWidth);
                    printCentered("| | |-+-+=+%| | |", terminalWidth);
                    printCentered("| | |_|_|_|_| | |", terminalWidth);
                    printCentered("| |    ___    | |", terminalWidth);
                    printCentered("| |   [___] ()| |", terminalWidth);
                    printCentered("| |         ||| |", terminalWidth);
                    printCentered("| |         ()| |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("| |           | |", terminalWidth);
                    printCentered("|_|___________|_|", terminalWidth);
                    return;
                default:
                    printCentered("Error, bitte erneut versuchen", terminalWidth);
            }
        }
    }

    private static void printCentered(String text, int width) {
        int padding = (width - text.length()) / 2;
        String centeredText = " ".repeat(Math.max(0, padding)) + text;
        System.out.println(centeredText);
    }

    public static void checkAndCreateHeader() {
        try {
            if (Files.notExists(Paths.get(CSV_FILE))) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
                    writer.println();
                }
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eintraghinzufügen(Scanner scanner) {
        while (true) {
            printCentered("====Angaben====", 80);
            System.out.print("Tag: ");
            String tag = scanner.nextLine();
            System.out.print("Datum: ");
            String datum = scanner.nextLine();
            System.out.print("Was ich gemacht habe: ");
            String wigh = scanner.nextLine();
            printCentered("===============", 80);
            saveToCSV(tag, datum, wigh);
            sleep();
            return;
        }
    }

    public static void eintraege(Scanner scanner) {
        System.out.println("---------------Einträge---------------");
        try {
            List<String> lines = Files.readAllLines(Paths.get("einträge.csv"));
            if (lines.isEmpty() || lines.size() == 1) {
                printCentered("Keine Einträge vorhanden", 80);
                returnToMenu2(scanner);
                return;
            }

            List<String> sortedLines = sortbydate(lines);

            int maxtaglänge = "Tag".length();
            int maxdatumlänge = "Datum".length();
            int maxwighlänge = "Wigh".length();

            for (String line : sortedLines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", 3);
                if (parts.length < 3) {
                    continue;
                }

                maxtaglänge = Math.max(maxtaglänge, parts[0].length());
                maxdatumlänge = Math.max(maxdatumlänge, parts[1].length());
                maxwighlänge = Math.max(maxwighlänge, parts[2].length());

            }

            boolean firstline = true;
            for (String line : sortedLines) {
                if (firstline) {
                    firstline = false;
                    continue;
                }
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {

                    System.out.printf("| %-" + maxtaglänge + "s | %-" + maxdatumlänge + "s | %-" + maxwighlänge + "s | %n", parts[0], parts[1], parts[2]);
                    System.out.println("--------------------------------------");
                } else {
                    System.out.println("Ungültig" + line);
                    sleep();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnToMenu2(scanner);
    }

    public static void bearbeiten(Scanner scanner) {
        System.out.println("----------Einträge bearbeiten----------");
        try {
            List<String> lines = Files.readAllLines(Paths.get("einträge.csv"));
            if (lines.isEmpty()) {
                System.out.println("Keine Einträge vorhanden.");
                sleep();
                return;
            }

            int maxtaglänge = "Tag".length();
            int maxdatumlänge = "Datum".length();
            int maxwighlänge = "Wigh".length();

            for (String line : lines) {
                String[] parts = line.split(",", 3);
                if (parts.length < 3) continue;

                maxtaglänge = Math.max(maxtaglänge, parts[0].length());
                maxdatumlänge = Math.max(maxdatumlänge, parts[1].length());
                maxwighlänge = Math.max(maxwighlänge, parts[2].length());
            }

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",", 3);
                if (parts.length == 3) {
                    System.out.printf("| %-3d | %-" + maxtaglänge + "s | %-" + maxdatumlänge + "s | %-" + maxwighlänge + "s |%n", i, parts[0], parts[1], parts[2]);
                    System.out.println("-------------------------------------------");
                }
            }

            System.out.print("Wählen Sie die Nummer des Eintrags, den Sie bearbeiten wollen: ");
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index < lines.size()) {
                String[] parts = lines.get(index).split(",");
                String neuTag = promptfornewvalue(scanner, "Neuer Tag (Leer lassen = keine Änderung) ", parts[0]);
                String neuesDatum = promptfornewvalue(scanner, "Neues Datum (Leer lassen = keine Änderung) ", parts[1]);
                String neueBeschreibung = promptfornewvalue(scanner, "Neue Beschreibung (leer lassen = keine Änderung) ", parts[2]);

                parts[0] = neuTag.isEmpty() ? parts[0] : neuTag;
                parts[1] = neuesDatum.isEmpty() ? parts[1] : neuesDatum;
                parts[2] = neueBeschreibung.isEmpty() ? parts[2] : neueBeschreibung;

                lines.set(index, String.join(",", parts));

                updateCSV(lines);
                System.out.println("Änderung erfolgreich gespeichert.");
            } else {
                System.out.println("Ungültige Nummer.");
            }
        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten.");
            e.printStackTrace();
        }
        returnToMenu2(scanner);
    }

    private static String promptfornewvalue(Scanner scanner, String prompt, String currentValue) {
        System.out.print(prompt + "(aktuell: " + currentValue + "): ");
        return scanner.nextLine().trim();
    }


    public static void searchEintrag(Scanner scanner) {
        System.out.print("Geben Sie einen Suchbegriff ein: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        try {
            List<String> lines = Files.readAllLines(Paths.get("einträge.csv"));
            boolean firstLine = true;
            boolean found = false;

            System.out.println("====Suchergebnisse====");
            for (String line : lines) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (line.toLowerCase().contains(searchTerm)) {
                    String[] parts = line.split(",");
                    System.out.println("Tag: ");
                    System.out.println("Datum: " + parts[1]);
                    System.out.println("Was ich gemacht habe: " + parts[2]);
                    System.out.println("================");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Keine Einträge gefunden, die '" + searchTerm + "' enthalten.");
            }
        } catch (IOException e) {
            System.out.println("Error beim Lesen der Datei.");
            e.printStackTrace();
        }
        returnToMenu2(scanner);
    }

    public static void eintraglöschen(Scanner scanner) {
        System.out.println("-------------Eintrag löschen-------------");
        try {
            List<String> lines = Files.readAllLines(Paths.get("einträge.csv"));
            if (lines.size() <= 1) {
                System.out.println("Keine Einträge vorhanden.");
                sleep();
                return;
            }

            boolean firstLine = true;
            int maxtaglänge = "Tag".length();
            int maxdatumlänge = "Datum".length();
            int maxwighlänge = "Wigh".length();

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length == 3) {
                    maxtaglänge = Math.max(maxtaglänge, parts[0].length());
                    maxdatumlänge = Math.max(maxdatumlänge, parts[1].length());
                    maxwighlänge = Math.max(maxwighlänge, parts[2].length());
                }
            }

            for (int i = 1; i < lines.size(); i++) {
                String Line = lines.get(i).trim();
                if (Line.isEmpty()) {
                    continue;
                }
                String[] parts = lines.get(i).split(",");
                if (parts.length == 3) {
                    System.out.printf("%d. %-" + maxtaglänge + "s | %-" + maxdatumlänge + "s | %-" + maxwighlänge + "s%n", i, parts[0].trim(), parts[1].trim(), parts[2].trim());
                    System.out.println("-----------------------------------------");
                } else {
                    System.out.println(i + "Ungültiger Eintrag");
                }
            }

            System.out.println("Wähle die Nummer des Eintrags den sie löschen wollen: ");
            int index = scanner.nextInt();
            scanner.nextLine();


            if (index >= 1 && index < lines.size()) {
                lines.remove(index);
                System.out.println("Eintrag wurde gelöscht.");
                updateCSV(lines);

            } else {
                System.out.println("Ungültige Nummer");
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        returnToMenu2(scanner);
    }

    public static void updateCSV(List<String> lines) {
        try (FileWriter fileWriter = new FileWriter("einträge.csv", false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    printWriter.println(line);
                }
            }
            System.out.println("CSV-Datei wurde aktualisiert.");

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
        public static void saveToCSV (String tag, String datum, String wigh){
            try (FileWriter fileWriter = new FileWriter("einträge.csv", true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {

                printWriter.println(tag + "," + datum + "," + wigh);
                System.out.println("Daten wurden erfolgrecih gespeichert.");

            } catch (IOException e) {
                System.out.println("Ein Fehler ist aufgetreten.");
                e.printStackTrace();
            }

        }
    }