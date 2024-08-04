package LLD_Design.Prototype_DesignPattern.scaler;

public class IntelligentStudent extends Student {
    int iq;

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone(){
        IntelligentStudent it = new IntelligentStudent();
        it.setAvgpspbatch(this.getAvgpspbatch());
        it.setBatch(this.getBatch());
        return it;
    }
}
