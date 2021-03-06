package servlet;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.reflect.TypeToken;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.util.HashMap;

/* firebase reader object
1. can get current node value
*/

public class fbdbr {
	public DatabaseReference ref;

	//Constructor
	public fbdbr (String certificate, String url){this(new fbdbw(certificate, url));}

	public fbdbr (DatabaseReference ref){this.ref = ref;}
	
	public fbdbr (fbdbw writer){this.ref = writer.getref();}
	
	//retrieve value
	public void retrieve (){}
}

/*Sample code 
fbdbw alldb = new fbdbw(certificate, url)
fbdbw fbdbw_CS8 = alldb.child("Course").child("CS8")
fbdbrCourse fbdbr_CS8(fbdbw_CS8)
fbdbr_CS8.retrieve()
Course CS8 = fbdbr_CS8.get()
*/