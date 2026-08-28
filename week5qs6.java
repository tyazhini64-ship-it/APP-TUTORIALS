import java.util.*;

class Candidate {
    int candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;

    public Candidate(int candidate_Id, String name, int aptitude, int technical, int communication) {
        this.candidate_Id = candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    public int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class week5qs6 {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;

        Candidate[] candidates = new Candidate[N];

        candidates[0] = new Candidate(101, "Arun", 80, 90, 70);
        candidates[1] = new Candidate(102, "Priya", 90, 85, 80);
        candidates[2] = new Candidate(103, "Ravi", 70, 95, 75);
        candidates[3] = new Candidate(104, "Divya", 85, 85, 85);
        candidates[4] = new Candidate(105, "Kiran", 80, 80, 70);

        Arrays.sort(candidates, new Comparator<Candidate>() {
            public int compare(Candidate c1, Candidate c2) {
                int score1 = c1.getTotalScore();
                int score2 = c2.getTotalScore();

                if (score1 != score2) {
                    return Integer.compare(score2, score1);
                }
                return Integer.compare(c1.candidate_Id, c2.candidate_Id);
            }
        });

        for (int i = 0; i < K; i++) {
            System.out.println(candidates[i].candidate_Id + " " + candidates[i].name + " " + candidates[i].getTotalScore());
        }
    }
}
