import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrCourse extends fbdbr{
    private Course tempCourse;

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