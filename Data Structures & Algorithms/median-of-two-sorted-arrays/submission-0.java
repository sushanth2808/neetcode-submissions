class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = m+n;
        int target = (total-1)/2;
        int firstIndex=-1;
        int secondIndex=-1;

        int p1 = 0;
        int p2=0;
        int index=-1;
        while(p1<n && p2<m){

                if(nums1[p1]<=nums2[p2]){
                index++;
                if(index==target){
                    firstIndex=nums1[p1];
                }
                if(index==target+1){
                    secondIndex=nums1[p1];
                    break;
                }
                p1++;
                }
                else{
                index++;
                if(index==target){
                    firstIndex=nums2[p2];
                }
                if(index==target+1){
                    secondIndex=nums2[p2];
                    break;
                }
                    
                    p2++;
                    }
            }

        while(p1<n){
            index++;
            if(index==target){
                firstIndex=nums1[p1];
            }
            if(index==target+1){
                secondIndex=nums1[p1];
                break;
            }
            p1++;
        }

        while(p2<m){
            index++;
            if(index==target){
                firstIndex=nums2[p2];
            }
            if(index==target+1){
                secondIndex=nums2[p2];
                break;
            }
            p2++;
        }

        if(total%2==0){
            return (firstIndex+secondIndex)/2.0;
        }
        else{
            return firstIndex;
        }

    }
}
