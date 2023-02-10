package AdderSubtractorSynchMethod;

public class Count {
    int value=0;
    synchronized public void addValue(int i){
        value+=i;
    }
}
