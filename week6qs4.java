import java.util.Scanner;

interface Confidential {}

class Document {
    String title;
    Document(String title) {
        this.title = title;
    }
}

class FinancialReport extends Document implements Confidential {
    FinancialReport(String title) { super(title); }
}

class PublicMemo extends Document {
    PublicMemo(String title) { super(title); }
}

public class week6qs4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter document title: ");
        String title = sc.nextLine();
        System.out.print("Is it confidential? (true/false): ");
        boolean isConfidential = sc.nextBoolean();

        Document doc;
        if (isConfidential) {
            doc = new FinancialReport(title);
        } else {
            doc = new PublicMemo(title);
        }

        checkConfidentiality(doc);
        sc.close();
    }

    public static void checkConfidentiality(Document doc) {
        if (doc instanceof Confidential) {
            System.out.println(doc.title + " is a CONFIDENTIAL document.");
        } else {
            System.out.println(doc.title + " is a standard/public document.");
        }
    }
}