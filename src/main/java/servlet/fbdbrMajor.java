import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrMajor extends fbdbr{
    private Major tempMajor;
	
	//Constructor
	public fbdbrMajor (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrMajor (DatabaseReference ref){this.ref = ref;}
	
	public fbdbrMajor (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempMajor = dataSnapshot.getValue(Major.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public Major get () {return tempMajor;}
}