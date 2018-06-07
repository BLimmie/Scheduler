import firebase_admin, firebase_admin.db

""" firebase_dict
type: reference to database
storage: O(1)
Note: all values are immutable
"""
class firebase_dict (dict):
	#Constructor
	def __init__ (self, certificate, url, ref=False):
		if ref:
			self.ref = ref 
		else:
			cred = firebase_admin.credentials.Certificate(certificate)
			firebase_admin.initialize_app(cred, {'databaseURL': url})
			self.ref = firebase_admin.db.reference()
		
	#get value
	def __getitem__(self, key):
		return self.ref.child(str(key)).get()

	#set value
	def __setitem__(self, key, value):
		self.ref.child(str(key)).set(value)
		
	def set(self, value):
		self.ref.set(value)
		
	def get(self):
		return self.ref.get()

	#delete value
	def __delitem__(self, key):
		self.ref.child(str(key)).delete()

	#get whole dataset
	def __call__ (self):
		return self.ref.get()
		
	#Display
	def __repr__ (self):
		return self().__repr__()
		
	def __rshift__ (self, child):
		return firebase_dict(0,0,self.ref.child(str(child)))