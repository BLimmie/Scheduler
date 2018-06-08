import sys
import os
from fdbd import *
import json

os.chdir(os.path.dirname(os.path.realpath(__file__)))
certificate = "cs48courseplanner-firebase-adminsdk-m9s7y-f4080e1e58.json";
url = "https://cs48courseplanner.firebaseio.com/"
filename = sys.argv[1]
fbd = firebase_dict(certificate, url)
node = fbd 
for arg in sys.argv[3:]:
	node = node >> arg 

if sys.argv[2] == "push":
	with open(filename, 'r') as fp:
		data = json.load(fp)
		node.set(data)
	
if sys.argv[2] == "pull":
	with open(filename, 'w') as fp:
		json.dump(node.get(), fp)