def hugs(n):
    if n <= 1:
        return 0
    else:
        return (n-1) + hugs(n-1)
    
for i in range (0,100,10):
    print(f"{i} -> {hugs(i)}")