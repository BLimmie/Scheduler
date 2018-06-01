import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrHashMap extends fbdbr{
    private HashMap tempHashMap;
	
	//Constructor
	public fbdbrHashMap (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrHashMap (DatabaseReference ref){this.ref = ref;}
	
	public fbdbrHashMap (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempHashMap = dataSnapshot.getValue(HashMap.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public HashMap get () {return tempHashMap;}
}