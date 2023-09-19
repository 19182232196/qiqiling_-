package Test2;
import java.util.ArrayList;
import java.util.List;
public class Testb {
    private List<Testa> testaList=new ArrayList<>();
    public  void add(Testa testa){
        testaList.add(testa);
    }
    public void remove(String e){
        Testa toremove=null;
        for(Testa testa:testaList){
            if(testa.getE().equals(e)){
                toremove=testa;
                break;
            }
        }
        if (toremove!=null){

        }
    }
}