/**
 * MainApp
 * 
 * La classe MainApp fornisce un'interfaccia utente testuale per eseguire
 * operazioni su una stringa di input fornita.
 * Gli utenti possono scegliere tra le seguenti opzioni:
 * 1. **Conta Consonanti:** Conta il numero di consonanti nella stringa di
 * input.
 * 2. **Converti in Maiuscolo:** Converte la stringa di input in maiuscolo, dove
 * la prima lettera di ogni parola è in maiuscolo.
 * 3. **Esci:** Chiude il programma.
 * 
 * Come utilizzare:
 * 1. Esegui il programma.
 * 2. Inserisci un nome in minuscolo quando richiesto.
 * 3. Seleziona un'opzione dal menu per eseguire l'operazione desiderata sulla
 * stringa di input.
 * 
 * Metodi della Classe:
 * 
 * @param input La stringa di input
 * @return Il numero di consonanti nella stringa di input.
 * 
 * @param input La stringa di input
 * @return La stringa di input convertita in maiuscolo con la prima lettera di
 *         ogni parola in maiuscolo.
 */

public class MainApp {

    public static void main(String[] args) {
        Timer tm = new Timer(); // creiamo un oggetto timer per misurare i tempi
        Chooser ch = new Chooser(new String[] { "1. Conta consonanti", "2. Cambia maiuscolo", "3. Esci" }); // creiamo
                                                                                                            // il menù
                                                                                                            // di scelta
        String input; // specifichiamo dove andrà l'input
        int scelta; // specifichiamo dove andrà la scelta dell'utente
        while (true) {
            do {
                System.out.print("Inserisci un cognome in minuscolo: ");
                input = Chooser.sc.nextLine(); // chiediamo all'utente un input "minuscolo"
            } while (!input.equals(input.toLowerCase()) || (input.matches(".*[0-9].*"))); // check dell'input
            scelta = ch.choose(); // fai scegliere all'utente all'interno del menu di scelta
            switch (scelta) {
                case 1:
                    System.out.println(contaConsonanti(input)); // conta le consonanti presenti
                    break;
                case 2:
                    if (args[args.length - 1].equals("-test"))
                        tm.start(); // avvio il timer
                    System.out.println(convertiMaiuscolo(input)); // trasforma ciascuna parola all'interno in uppercase
                    if (args[args.length - 1].equals("-test")) {
                        tm.stop(); // fermo il timer
                        System.out.println("Tempo impiegato: " + tm.getDuration() + "ms");
                    } // stampa il tempo impiegato;
                    break;
                case 3:
                    Chooser.sc.close(); // chiudiamo scanner
                    System.exit(0); // uscita dal programma con status 0 (riuscito)
                    break;
            }
        }
    }

    /**
     * Conta il numero di consonanti nella stringa di input.
     * 
     * @param input La stringa di input.
     * @return Il numero di consonanti nella stringa di input.
     */
    public static int contaConsonanti(String input) {
        return input.toLowerCase().replaceAll("[aeouiìàòèéù]", "").length();
    }

    /**
     * Conta il numero di vocali nella stringa di input.
     * 
     * @param input La stringa di input.
     * @return Il numero di vocali nella stringa di input.
     */
    public static int contaVocali(String input) {
        return input.length() - contaConsonanti(input);
    }

    /**
     * Converte la stringa di input in maiuscolo, mantenendo la maiuscola solo per
     * il primo carattere di ogni parola.
     * 
     * @param input La stringa di input.
     * @return La stringa di input convertita in maiuscolo con la prima lettera di
     *         ogni parola in maiuscolo.
     */
    public static String convertiMaiuscolo(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean makeUppercase = true;
        String charStr; // contiene il carattere sottoforma di stringa, quindi 'a' diventa "a"

        for (char ch : input.toCharArray()) {
            charStr = Character.toString(ch);
            if (charStr.matches("\"|\\'|,|\\.|\\s+")) { // controlla se " ' , . e lo spazio siano nel carattere
                makeUppercase = true; // segnala che il prossimo carattere deve essere maiuscolo
                result.append(charStr); // aggiunge il carattere alla stringa
                if (charStr.matches("\\.")) {
                    result.append("\n");
                }
                ;
            } else {
                if (makeUppercase) { // se il carattere va reso maiuscolo
                    result.append(Character.toUpperCase(ch)); // aggiunge il carattere maiuscolo
                    makeUppercase = false; // segnala che non va reso maiuscolo il prossimo carattere
                } else {
                    result.append(Character.toLowerCase(ch)); // se non va reso maiuscolo o non rispetta i simboli
                                                              // presenti, aggiungi il carattere
                }
            }
        }

        return result.toString();
    }
}