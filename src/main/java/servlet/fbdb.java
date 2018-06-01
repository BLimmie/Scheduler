<<<<<<< HEAD
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.util.HashMap;

/* firebase_dict
type: reference to database
storage: O(1)
Note: all values are immutable
*/

public class fbdb {
	private DatabaseReference ref;

	//Constructor
	public fbdb(String certificate, String url) {
		try {
			FileInputStream serviceAccount = new FileInputStream(certificate);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl(url)
					.build();
			FirebaseApp.initializeApp(options);
			this.ref = FirebaseDatabase.getInstance().getReference();
		} catch (Exception e) {
			System.out.printf("exception");
		}
	}

	public fbdb(DatabaseReference ref) {
		this.ref = ref;
	}
}
public class firebase_dict {
	private DatabaseReference ref;

	//Constructor
	public firebase_dict (String certificate, String url){
		FileInputStream serviceAccount = new FileInputStream(certificate);
		FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.setDatabaseUrl(url)
			.build();
		FirebaseApp.initializeApp(options);
		ref = FirebaseDatabase.getInstance().getReference();
	}
	
	//get value
	public Object get (String key){
		return ref.child(key).getKey();
		return ref.child(key).getValue();
	}
	
	//set value
	public void set (String key, String value){
		ref.child(key).setValue(value);
	}
	
	//delete value 
	public void del (String key){
		ref.child(key).removeValue();
	}

	public fbdb child(String key){
		return new fbdb(ref.child(key));
	}

	public fbdb father() {return new fbdb(ref.getParent());}
	
	//get whole dataset
	public HashMap call (){
		return ref.getValue();
	}
}