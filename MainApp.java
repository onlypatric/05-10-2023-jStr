/**
 * MainApp
 * 
 * La classe MainApp fornisce un'interfaccia utente testuale per eseguire operazioni su una stringa di input fornita.
 * Gli utenti possono scegliere tra le seguenti opzioni:
 * 1. **Conta Consonanti:** Conta il numero di consonanti nella stringa di input.
 * 2. **Converti in Maiuscolo:** Converte la stringa di input in maiuscolo, dove la prima lettera di ogni parola è in maiuscolo.
 * 3. **Esci:** Chiude il programma.
 * 
 * Come utilizzare:
 * 1. Esegui il programma.
 * 2. Inserisci un nome in minuscolo quando richiesto.
 * 3. Seleziona un'opzione dal menu per eseguire l'operazione desiderata sulla stringa di input.
 * 
 * Metodi della Classe:
 * 
 * @param input La stringa di input
 * @return Il numero di consonanti nella stringa di input.
 * 
 * @param input La stringa di input
 * @return La stringa di input convertita in maiuscolo con la prima lettera di ogni parola in maiuscolo.
 */

public class MainApp {

    public static void main(String[] args) {
        Chooser ch = new Chooser(new String[]{"1. Conta consonanti", "2. Cambia maiuscolo", "3. Esci"}); // creiamo il menù di scelta
        String input; // specifichiamo dove andrà l'input
        int scelta; // specifichiamo dove andrà la scelta dell'utente
        while(true){
            do {
                System.out.print("Inserisci un nome&cognome in minuscolo: ");
                input = Chooser.sc.nextLine();  // chiediamo all'utente un input "minuscolo"
            } while (!input.equals(input.toLowerCase())); // check dell'input
            scelta = ch.choose(); // fai scegliere all'utente all'interno del menu di scelta
            switch(scelta){
                case 1:
                    System.out.println(contaConsonanti(input)); // conta le consonanti presenti
                    break;
                case 2:
                    System.out.println(convertiMaiuscolo(input)); // trasforma ciascuna parola all'interno in uppercase
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
        return input.toLowerCase().replaceAll("[aeouiàòèéù]", "").length();
    }

    /**
     * Converte la stringa di input in maiuscolo, mantenendo la maiuscola solo per
     * il primo carattere di ogni parola.
     * 
     * @param input La stringa di input.
     * @return La stringa di input convertita in maiuscolo con la prima lettera di
     *         ogni parola in maiuscolo.
     */
    public static String convertiMaiuscolo(String input){
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean makeUppercase = true;
        String charStr;

        for (char ch : input.toCharArray()) {
            charStr = Character.toString(ch);
            if (charStr.matches("\"|\\'|,|\\.|\\^|\\s+")){ // controlla se " ' , . ^ e lo spazio siano nel carattere
                makeUppercase=true; // segnala che il prossimo carattere deve essere maiuscolo
                result.append(charStr); // aggiunge il carattere alla stringa
            }
            else {
                if (makeUppercase) { // se il carattere va reso maiuscolo
                    result.append(Character.toUpperCase(ch)); // aggiunge il carattere maiuscolo
                    makeUppercase = false; // segnala che non va reso maiuscolo il prossimo carattere
                } else {
                    result.append(Character.toLowerCase(ch)); // se non va reso maiuscolo o non rispetta i simboli presenti, aggiungi il carattere
                }
            }
        }

        return result.toString();
    }
}