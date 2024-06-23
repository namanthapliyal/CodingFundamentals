//First soultion
class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums.length==1+upper-lower){
            return res;
        }
        int p1=0,p2=0, i=1;
        List<Integer> range=new ArrayList<>();
        if(nums.length==0){
            p1=lower;
            p2=upper;
            range.add(p1);
            range.add(p2);
            res.add(range);
            return res;
        }else if(nums.length==1){
            range=new ArrayList<>();
            if(nums[0]!=lower){
                p1=lower;
                p2=nums[0]-1;
                range.add(p1);
                range.add(p2);
                res.add(range);
            }
            p1=nums[0]+1;
            p2=upper;
        }else{
            range=new ArrayList<>();
            if(nums[0]!=lower){
                p1=lower;
                p2=nums[0]-1;
                range.add(p1);
                range.add(p2);
                res.add(range);
            }
        }
        //System.out.println(res);
        while(i<nums.length){
            p1=nums[i-1];
            p2=nums[i];
            if(p2-p1>1){
                range=new ArrayList<>();
                range.add(p1+1);
                range.add(p2-1);
                res.add(range);
            }
            //System.out.println(res);
            i++;
        }
        if(nums[nums.length-1]!=upper){
            range=new ArrayList<>();
            range.add(nums[nums.length-1]+1);
            range.add(upper);
            res.add(range);
        }
        //System.out.println(res);
        return res;
    }
}

//Second sol
public class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();

        int p1 = lower, p2;
        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length) {
                p2 = nums[i];
            } else {
                p2 = upper + 1;
            }

            if (p1 <= p2 - 1) {
                List<Integer> range = new ArrayList<>();
                range.add(p1);
                range.add(p2 - 1);
                res.add(range);
            }

            p1 = p2 + 1;
        }

        return res;
    }
}

//Third sol
def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        res=[]
        for a in nums+[upper+1]:
            if a>lower:
                res.append([lower,a-1])
            lower=a+1
        return res