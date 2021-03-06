package servlet;
import com.google.firebase.database.*;

public class fbdbrUser extends fbdbr{
    private User tempUser;
	
	//Constructor
	public fbdbrUser (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrUser (DatabaseReference ref){super(ref);}
	
	public fbdbrUser (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempUser = dataSnapshot.getValue(User.class);
            }

            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public User get () {return tempUser;}
}