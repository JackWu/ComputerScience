import os

for files in os.listdir("."):
  if files.endswith(".java"):
		f = open(files)
		temptext = f.read();
		f.close()
		f = open(files+'~', 'w')
		f.write("package princetonAlgorithms;\n")
		f.write(temptext)
		f.close()
		os.rename(files+'~', files)
