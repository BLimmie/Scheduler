import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrCourse extends fbdbr{
    private Course tempCourse;
	
	//Constructor
	public fbdbrCourse (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrCourse (DatabaseReference ref){this.ref = ref;}
	
	public fbdbrCourse (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempCourse = dataSnapshot.getValue(Course.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public Course get () {return tempCourse;}
}