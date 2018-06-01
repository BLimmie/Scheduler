package servlet;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;

import java.io.FileInputStream;
import java.util.HashMap;

/* firebase reader object
1. can get current node value
*/

public class fbdbr <T> {
	public DatabaseReference ref;
	public T t;

	//Constructor
	public fbdbr () {}
	
	public fbdbr (String certificate, String url){new fbdbr(new fbdbw(certificate, url));}

	public fbdbr (DatabaseReference ref){this.ref = ref;}
	
	public fbdbr (fbdbw writer){this.ref = writer.getref();}
	
	//retrieve value
	public void retrieve (){
		this.ref.addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				this.t = dataSnapshot.getValue(T.class);
			}

			public void onCancelled(DatabaseError databaseError) {
				// ...
			}
		});
	}
	
	public void assign (T t){t = this.t;}
}

/*Sample code 
CS8 = Course()
fbdbw_CS8 = fbdbw(certificate, url).child("Course").child("CS8")
fbdbr_CS8 = fbdbr <Course> (fbdbw_CS8)
fbdbr_CS8.retrieve()
fbdbr_CS8.assign(CS8)
*/