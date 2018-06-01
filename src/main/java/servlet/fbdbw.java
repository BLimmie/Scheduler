package servlet;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.util.HashMap;

/* firebase writer object
1. can get child and parent nodes based on their key
2. can set and/or delete current node 
*/

public class fbdbw {
	private DatabaseReference ref;
	private String fullpath;

	//Constructor
	public fbdbw() {}
	
	public fbdbw (String certificate, String url){
	    try {
            FileInputStream serviceAccount = new FileInputStream(certificate);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(url)
                    .build();
            FirebaseApp.initializeApp(options);
            this.ref = FirebaseDatabase.getInstance().getReference();
			this.fullpath = this.ref.toString();
        }
        catch (Exception e){System.out.printf("exception");}
	}

	public fbdbw (DatabaseReference ref){
		this.ref = ref;
		this.fullpath = this.ref.toString();
	}
	
	//set node
	public void set (HashMap<String, Object> value) {ref.updateChildrenAsync(value);}
	
	//delete node
	public void del () {ref.removeValue();}

	//get child node
	public fbdbw child(String key) {return new fbdbw(ref.child(key));}

	//get parent node 
	public fbdbw father() {return new fbdbw(ref.getParent());}
	
	//get reference
	public DatabaseReference getref () {return this.ref;}
}