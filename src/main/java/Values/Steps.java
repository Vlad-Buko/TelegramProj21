package Values;

public enum Steps {


    STEP1("step1"),
    STEP2("step2"),
    STEP3("step3"),
    STEP4("step4");

    private String title;

    Steps(String s) {
        this.title = s;
    }

    @Override
    public String toString() {
        return title;
    }

}