import firebase_admin, firebase_admin.db

""" firebase_dict
type: reference to database
storage: O(1)
Note: all values are immutable
"""
class firebase_dict (dict):
	#Constructor
	def __init__ (self, certificate, url):
		cred = firebase_admin.credentials.Certificate(certificate)
		firebase_admin.initialize_app(cred, {'databaseURL': url})
		self.ref = firebase_admin.db.reference()
		
	#get value
	def __getitem__(self, key):
		return self.ref.child(str(key)).get()

	#set value
	def __setitem__(self, key, value):
		self.ref.child(str(key)).set(value)

	#delete value
	def __delitem__(self, key):
		self.ref.child(str(key)).delete()

	#get whole dataset
	def __call__ (self):
		return self.ref.get()
		
	#Display
	def __repr__ (self):
		return self().__repr__()

if __name__ == "__main__":
	certificate = 'temp-c0b09-firebase-adminsdk-fqxrx-ab2b9d1f13.json'
	url = 'https://temp-c0b09.firebaseio.com/'
	fbd = firebase_dict(certificate, url)
	fbd[100] = [1,2,3]
	print(fbd[100])
	del fbd[100]
	print(fbd)