package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class MathProblemAuthenticating extends MathProblem {
    private int passedVotes;
    private int unpassedVotes;

    public int getPassedVotes() {
        return passedVotes;
    }

    public void setPassedVotes(int passedVotes) {
        this.passedVotes = passedVotes;
    }

    public int getUnpassedVotes() {
        return unpassedVotes;
    }

    public void setUnpassedVotes(int unpassedVotes) {
        this.unpassedVotes = unpassedVotes;
    }
}
