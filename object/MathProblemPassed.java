package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class MathProblemPassed extends MathProblem {
    private int totalAttempt;
    private int accepted;

    public int getTotalAttempt() {
        return totalAttempt;
    }

    public void setTotalAttempt(int totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }
}
