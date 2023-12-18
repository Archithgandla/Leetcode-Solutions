/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    int BS(List<Employee> employees,int id){
        
        int low = 0,high = employees.size()-1;
        int mid = low+(high-low)/2;

        while(low<=high){

            if(employees.get(mid).id == id)
                return mid;
            else if(employees.get(mid).id>id)
                high = mid-1;
            else
                low = mid+1;
            mid = low+(high-low)/2;
        }
        return mid;
    }


    public int Util(List<Employee> employees,int id){

        int idx = BS(employees,id);

        if(employees.get(idx).subordinates.size() == 0)
            return employees.get(idx).importance;

        int tot_importance = employees.get(idx).importance;

        for(Integer temp:employees.get(idx).subordinates)
            tot_importance+=Util(employees,temp);
        return tot_importance;
    }



    public int getImportance(List<Employee> employees, int id) {
        Collections.sort(employees,(a,b) -> a.id-b.id);

        int idx = BS(employees,id);
        int ans = employees.get(idx).importance;

        for(Integer temp:employees.get(idx).subordinates)
            ans+=Util(employees,temp);

        return ans;

    }
}