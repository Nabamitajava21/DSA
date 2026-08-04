class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;
         //Nabamita
        while (left < right) {
            int width = right - left;
            int currArea = min(height[left], height[right]) * width;
            maxArea = max(maxArea, currArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
};
    
