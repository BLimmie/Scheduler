/* firebase_dict
type: reference to database
storage: O(1)
Note: all values are immutable
*/
public class firebase_dict:
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
	)
	
	//get value
	public Object get (String key){
		return ref.child(key).getValue();
	}
	
	//set value
	public void set (String key, <T> value){
		ref.child(key).setValue(value)
	}
	
	//delete value 
	public void del (String key){
		ref.child(key).removeValue()
	}
	
	//get whole dataset
	public HashMap call (){
		return ref.getValue();
	}