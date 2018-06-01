import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrUser extends fbdbr{
    private User tempUser;
	
	//Constructor
	public fbdbrUser (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrUser (DatabaseReference ref){this.ref = ref;}
	
	public fbdbrUser (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempUser = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public User get () {return tempUser;}
}