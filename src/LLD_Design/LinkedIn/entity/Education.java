package LLD_Design.LinkedIn.entity;

public class Education {
    private final String school;
    private final String degree;
    private final int startYear;
    private final int endYear;

    public Education(String school, String degree, int startYear, int endYear) {
        this.school = school;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "Education{" +
                "school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
