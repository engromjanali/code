Problem -4:
(a)

int count = 0;
for (int i = n; i > 0; i /= 2) // O(log N)
{
    for (int j = 0; j < n; j+=5)  //O (N)
   {
        count += 1;
    }
}

Ans - O (N log N)

(b)

for(int i =1; i*i<n; i++) // O (sqrt(N))
{
     cout << “hello”;
}

Ans - O (sqrt(N))


(c)

for(int i =1; i<n; i=i*2) //O (log(N))
{
   for(int j=1; j*j<n; j+=2) //O (sqrt(N))
  {
      cout << “hello”;
   }
}

Ans - O ( log(N) x sqrt(N) )

(d)
int m = 1;
for(int i=0; m<=n; i++) // O (sqrt N)
{
    m+=i;
}

Ans - O ( sqrt(N) )


