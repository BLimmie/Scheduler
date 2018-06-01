package servlet;
import com.google.firebase.database.*;
import java.util.HashMap;
public class fbdbrHashMap extends fbdbr{
    private HashMap tempHashMap;
	
	//Constructor
	public fbdbrHashMap (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrHashMap (DatabaseReference ref){super(ref);}
	
	public fbdbrHashMap (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempHashMap = dataSnapshot.getValue(HashMap.class);
            }

            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public HashMap get () {return tempHashMap;}
}