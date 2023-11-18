class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        change = ['*'] * (amount + 1)
        
        def dp(amount):
            if amount == 0:
                return 0
            
            if change[amount] != '*':
                return change[amount];
            
            imin = float('inf')
            for c in coins:
                if amount < c:
                    continue
                
                imin = min(imin, 1 + dp(amount - c))
                
            change[amount] = imin
            return imin
        
        res = dp(amount)
            
        return -1 if res == float('inf') else res 
    