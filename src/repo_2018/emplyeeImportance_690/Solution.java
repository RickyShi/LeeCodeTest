package repo_2018.emplyeeImportance_690;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        /*Employee e1 = new Employee(1,5, Arrays.asList(2,3));
        Employee e2 = new Employee(2,3, Arrays.asList(4));
        Employee e3 = new Employee(3,4, Arrays.asList());
        Employee e4 = new Employee(4,1, Arrays.asList());
        System.out.println(solution.getImportance( Arrays.asList(e1,e2,e3,e4),1));
        System.out.println(solution.getImportance2( Arrays.asList(e1,e2,e3,e4),1));
        System.out.println(solution.getImportance3( Arrays.asList(e1,e2,e3,e4),1));*/

        Employee e = null;
        System.out.println(solution.getImportance2( Arrays.asList(e),1));
    }
    /**Ricky way, could use hashMap to search faster*/
    public int getImportance(List<Employee> employees, int id) {
        Employee employee = null;
        int rtn = 0;
        for(Employee e:employees){
            if(e.id==id){
                employee = e;
                break;
            }
        }

        if (employee==null) return 0;
        rtn+=employee.importance;
        if (employee.subordinates==null||employee.subordinates.isEmpty()) return rtn;
        for (int i:employee.subordinates){
            rtn +=getImportance(employees,i);
        }
        return rtn;
    }

    /** Using HashMap */
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> eMap = new HashMap<>();
        for (Employee e: employees) {
            if(e!=null) {
                eMap.put(e.id, e);
            }
        }
        return dfs(id, eMap);
    }
    public int dfs(int eid, Map<Integer, Employee> eMap) {
        Employee employee = eMap.getOrDefault(eid,null);
        if (employee==null) return 0;
        int ans = employee.importance;
        for (Integer subId: employee.subordinates)
            ans += dfs(subId, eMap);
        return ans;
    }

    /**
     * The bad part is that every time we are doing for(Employee e:employees){emap.put(e.id, e);}
     * So below is a bad pratice. we should use another function as a recursive function.
     */
    public int getImportance3(List<Employee> employees, int id) {

        int rtn = 0;
        Map<Integer, Employee> emap = new HashMap<>();
        for(Employee e:employees){
            emap.put(e.id, e);
        }

        Employee employee = emap.get(id);
        rtn+=employee.importance;
        if (employee.subordinates==null||employee.subordinates.isEmpty()) return rtn;
        for (int i:employee.subordinates){
            rtn +=getImportance(employees,i);
        }
        return rtn;
    }


}
