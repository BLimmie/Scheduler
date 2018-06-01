package servlet;
import com.google.firebase.database.*;
public class fbdbrCourse extends fbdbr{
    private Course tempCourse;
	
	//Constructor
	public fbdbrCourse (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbrCourse (DatabaseReference ref){super(ref);}
	
	public fbdbrCourse (fbdbw writer){super(writer);}

    public void retrieve () {
        this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempCourse = dataSnapshot.getValue(Course.class);
            }

            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
    
    public Course get () {return tempCourse;}
}