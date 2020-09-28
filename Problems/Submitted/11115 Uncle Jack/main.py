while True:
	d = input()
	if d == "0 0":
		exit(0)

	a = int(d.split()[0])
	b = int(d.split()[1])

	print(a**b)