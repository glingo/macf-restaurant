package kernel.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FlashBag {
    
    private HashMap<String, Collection<String>> flashs;

    public FlashBag() {}
    
    public void addFlash(String type, String flash) {
        
        if(this.flashs == null) {
            this.flashs = new HashMap<>();
        }
        
        if(!this.flashs.containsKey(type)) {
            this.flashs.put(type, new ArrayList<>());
        }
        
        this.flashs.get(type).add(flash);
    }
    
    public Collection<String> getFlashs(String type) {
        Collection<String> found = this.flashs.get(type);
        this.flashs.remove(type);
        return found;
    }
    
    public HashMap<String, Collection<String>> getAll() {
        HashMap<String, Collection<String>> all = this.flashs;
        this.flashs = new HashMap<>();
        return all;
    }
    
}
