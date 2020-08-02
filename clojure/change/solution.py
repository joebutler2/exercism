# Python 3 program to find minimum 
# number of denominations 
def change(coins, amount):
    result = [amount+1] * (amount+1)
    coins_results = [[] for _ in range(amount+1)]

    result[0] = 0

    for i in range(1, amount+1):
        for coin in coins:
            if i >= coin and result[i - coin] + 1 < result[i]:
                result[i] = result[i-coin] + 1
                print("i", i, "coin", coin, "result", result[i])
                coins_results[i] = coins_results[i-coin] + [coin]

    if result[amount] == amount+1:
        return []

    return coins_results[amount]

print(change([1, 5, 10, 21, 25], 76))
print(change([1, 5, 10, 21, 25], 63))


# def findMin(V): 
	
# 	# All denominations of Indian Currency 
# 	deno = [1, 5, 10, 21, 25] 
# 	n = len(deno) 
	
# 	# Initialize Result 
# 	ans = [] 

# 	# Traverse through all denomination 
# 	i = n - 1
# 	while(i >= 0): 
		
# 		# Find denominations 
# 		while (V >= deno[i]): 
# 			V -= deno[i] 
# 			ans.append(deno[i]) 

# 		i -= 1

# 	# Print result 
# 	for i in range(len(ans)): 
# 		print(ans[i], end = " ") 

# # Driver Code 
# if __name__ == '__main__': 
# 	n = 63
# 	print("Following is minimal number", 
# 		"of change for", n, ": ", end = "") 
# 	findMin(n) 
	
# # This code is contributed by 
# # Surendra_Gangwar 

