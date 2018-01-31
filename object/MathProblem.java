package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class MathProblem {
    private String questionId;
    private int questionClassification;
    private String questionDescription;
    private String choiceOne;
    private String choiceTwo;
    private String choiceThree;
    private String choiceFour;
    private String standardAnswer;
    private String contributor;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getQuestionClassification() {
        return questionClassification;
    }

    public void setQuestionClassification(int questionClassification) {
        this.questionClassification = questionClassification;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    public String getChoiceFour() {
        return choiceFour;
    }

    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }
}
