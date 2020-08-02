function coinChange(coins, amount) {
  const solutions = new Array(amount + 1);
  for(let i = 0; i <= amount; i++) {
    solutions[i] = amount + 1;
  }
  solutions[0] = 0;
  for(let i = 0; i <= amount; i++) {
    for(let j = 0; j < coins.length; j++) {
      if(coins[j] <= i) {
        solutions[i] = Math.min(solutions[i], 1 + solutions[i - coins[j]]);
      }
    }
  }

  return solutions[amount] > amount ? -1 : solutions[amount];
}

console.log(coinChange([1, 5, 10, 21, 25], 63));
