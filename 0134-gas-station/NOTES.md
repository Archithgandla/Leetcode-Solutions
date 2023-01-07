​
BRUTE FORCE : Start from all possible indexes
TIME LIMIT EXCEEDED SOLUTION
for(int i=0;i<petrol.length;i++){
int extra = 0;
int j = i;
boolean flag = false;
do{
int fuel = petrol[j]+extra;
//System.out.println("Fuel : "+fuel);
if(fuel<distance[j])
break;
flag = true;
extra = fuel-distance[j];
j=(j+1)%petrol.length;
}while(j!=i);
if(flag == true && j==i)
return j;
}
return -1;
//APPROACH - 2 : Using Queue and count vaariable
//APPROACH-3 : Submitted
​
​
​
​
​