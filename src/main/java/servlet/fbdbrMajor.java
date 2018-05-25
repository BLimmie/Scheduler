import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class fbdbrMajor extends fbdbr{
    private Major tempMajor;

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