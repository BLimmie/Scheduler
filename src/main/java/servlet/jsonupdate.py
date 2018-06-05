import jsontree
import sys

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
		self.get(value)

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

def main():
	os.chdir(os.path.dirname(os.path.realpath(__file__)))
	certificate = "cs48courseplanner-firebase-adminsdk-m9s7y-f4080e1e58.json";
	url = "https://cs48courseplanner.firebaseio.com/"
	filename = sys.argv[2]
	fbd = firebase_dict(certificate, url)
	node = fbd 
		for arg in sys.argv[4:]:
			node = node >> arg 
		
    if sys.argv[3] == "push":
		with open(filename, 'r') as fp:
			data = json.load(fp)
			node.set(data)
		
	if sys.argv[3] == "pull":
		with open(filename, 'w') as fp:
			json.dump(node.get(), fp)
			
"""
python fbdbupdate filepath push/pull *child
"""