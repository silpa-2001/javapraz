import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args) {
        String filePath ="poem.txt";

        try {
            FileStatistics stats = getFileStatistics(filePath);
            System.out.println("Number of characters: " + stats.getCharacterCount());
            System.out.println("Number of lines: " + stats.getLineCount());
            System.out.println("Number of words: " + stats.getWordCount());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static FileStatistics getFileStatistics(String filePath) throws IOException {
        int charCount = 0;
        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                // Splitting line into words by spaces
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return new FileStatistics(charCount, lineCount, wordCount);
    }
}

class FileStatistics {
    private final int characterCount;
    private final int lineCount;
    private final int wordCount;

    public FileStatistics(int characterCount, int lineCount, int wordCount) {
        this.characterCount = characterCount;
        this.lineCount = lineCount;
        this.wordCount = wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }
}
