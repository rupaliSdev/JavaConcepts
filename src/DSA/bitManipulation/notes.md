n & n-1 -> remove the right most bit of n

10 & 
01
=00

use when want to count no of set bits
n%2==0 then n & n-1 =0


n & ~(n-1)

isolates the rightmost set bit

10 &
~(01)= 11

= 10